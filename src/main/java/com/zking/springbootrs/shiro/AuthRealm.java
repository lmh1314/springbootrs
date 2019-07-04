package com.zking.springbootrs.shiro;

import com.zking.springbootrs.model.Mypermission;
import com.zking.springbootrs.model.User;
import com.zking.springbootrs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------执行授权方法---------");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //到数据库查询当前登陆用户的授权字符串
        //获得当前登陆用户
        Subject subject = SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
        List<Mypermission> permissions= userService.getPermissionByUid(user.getUid());
        for (Mypermission permission : permissions) {
            info.addStringPermission(permission.getPermission());
        }
        return info;
    }

    /**
     * 认证登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //token携带了用户信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取前端输入的用户名
        String userName  = usernamePasswordToken.getUsername();

        //根据用户名查询数据库中对应的记录
        User user = userService.getUserByName(usernamePasswordToken.getUsername());
        System.out.println(user);
        //当前realm对象的name
        String realmName = getName();
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUname());
        //封装用户信息，构建AuthenticationInfo对象并返回
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getUpwd(),
                credentialsSalt, realmName);
        return authcInfo;
    }
}
