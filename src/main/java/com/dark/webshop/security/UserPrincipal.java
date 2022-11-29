package com.dark.webshop.security;

import com.dark.webshop.database.entity.user.AuthenGroup;
import com.dark.webshop.database.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {
    private final User user;
    private final List<AuthenGroup> authenGroups;

    public UserPrincipal(User user, List<AuthenGroup> authenGroups) {
        super();
        this.user = user;
        this.authenGroups = authenGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == authenGroups) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authenGroups.forEach(group ->
                grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup()))
        );
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
