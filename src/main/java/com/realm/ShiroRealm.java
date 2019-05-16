package com.realm;


import com.bean.Admin;
import com.bean.Authority;
import com.bean.Role;
import com.bean.User;
import com.service.AdminService;
import com.service.AuthorityService;
import com.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthorityService authorityService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        Subject subject = SecurityUtils.getSubject();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Admin admin =  (Admin) principalCollection.getPrimaryPrincipal();
        Role role = roleService.findRole(admin.getRole());
        List<String> collection = new ArrayList<String>();
        if (role.getAuthority()!=null&&!role.getAuthority().equals("")) {
            List<Authority> authorities = authorityService.findAuthoritys(role.getAuthority());
            for (Authority authority:authorities) {
                collection.add(authority.getAuthority());
            }
        }
//        System.out.println(collection.toArray().toString());
        info.addStringPermissions(collection);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        Admin admin = adminService.selectByName(token.getUsername());
        if(admin==null){
            return null;
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getName());//盐值加密
        return new SimpleAuthenticationInfo(admin,admin.getPassword(),credentialsSalt,getName());//验证密码
    }
}
