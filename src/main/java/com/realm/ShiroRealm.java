package com.realm;


import com.bean.User;
import com.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // token中包含用户输入的用户名和密码
        // 第一步从token中取出用户名
//        String userName = (String) authenticationToken.getPrincipal();
//        // 第二步：根据用户输入的userCode从数据库查询
//        User user = userService.selectUserName(userName);
//        // 如果查询不到返回null
//        if (user == null) {//
//            return null;
//        }
//        // 获取数据库中的密码
//        String password = user.getPassword();
        /**
         * 认证的用户,正确的密码
         */
//        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, password, this.getName());
        return null;
    }

    public String getName(){
        return "ShiroRealm";
    }
}
