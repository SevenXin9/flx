package com.realm;


import com.bean.Admin;
import com.bean.User;
import com.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Collection<String> collection = new ArrayList<String>();
//        collection.add("index");
        //info.addStringPermissions(collection);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        Admin admin = adminService.selectByName(token.getUsername());
        if(admin==null){
            return null;
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getName());
        return new SimpleAuthenticationInfo(admin,admin.getPassword(),credentialsSalt,getName());
    }
}
