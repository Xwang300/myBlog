package com.cass.config.security;

import com.cass.user.domain.Permission;
import com.cass.user.domain.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
public class AuthUserDetails implements UserDetails {

    private String nickName;

    private String pswd;

    private List<Role> roleList;

    private List<Permission> permissionList;

    public AuthUserDetails(String nickName, String pswd, List<Role> roleList, List<Permission> permissionList) {
        super();
        this.nickName = nickName;
        this.pswd = pswd;
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public AuthUserDetails() {
        this.nickName = "NA";
        this.pswd = "NA";
        this.roleList = Collections.EMPTY_LIST;
        this.permissionList = Collections.EMPTY_LIST;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : this.roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.pswd;
    }

    @Override
    public String getUsername() {
        return this.nickName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
