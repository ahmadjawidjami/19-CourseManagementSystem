package af.hu.cs.se.security;

import af.hu.cs.se.model.Permission;
import af.hu.cs.se.model.Role;
import af.hu.cs.se.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("USER"));
//        return authorities;

//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
//        grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getPermissions()));

//        return Collections.singletonList(new SimpleGrantedAuthority("USER"));

//        System.out.println(grantedAuthorities.toString());
//
//        return grantedAuthorities;
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        for (Permission permission : user.getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
        }

        System.out.println(authorities.toString());

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
