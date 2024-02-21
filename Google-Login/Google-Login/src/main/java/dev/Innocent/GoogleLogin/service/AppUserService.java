package dev.Innocent.GoogleLogin.service;

import dev.Innocent.GoogleLogin.enums.LoginProvider;
import dev.Innocent.GoogleLogin.model.AppUser;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Value
public class AppUserService implements UserDetailsService {
    PasswordEncoder passwordEncoder;
    Map<String, AppUser> users = new HashMap<>();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }

    @PostConstruct
    private void createHardcodedUser(){
        var bob = AppUser.builder()
                .username("bob")
                .password(passwordEncoder.encode("123"))
                .authorities(List.of(new SimpleGrantedAuthority("read")))
                .build();

        var bil = AppUser.builder()
                .username("bil")
                .password(passwordEncoder.encode("123"))
                .authorities(List.of(new SimpleGrantedAuthority("read")))
                .build();

        createUser(bob);
        createUser(bil);
    }

    public OAuth2UserService<OidcUserRequest, OidcUser> oidcLoginHandler() {
        return userRequest -> {
            LoginProvider provider = getProvider(userRequest);
            OidcUserService delegate = new OidcUserService();
            OidcUser oidcUser = delegate.loadUser(userRequest);
            return AppUser.builder()
                    .loginProvider(provider)
                    .username(oidcUser.getName())
                    .name(oidcUser.getFullName())
                    .email(oidcUser.getEmail())
                    .userId(oidcUser.getName())
                    .imageUrl(oidcUser.getAttribute("picture"))
                    .password(passwordEncoder.encode(UUID.randomUUID().toString()))
                    .attributes(oidcUser.getAttributes())
                    .authorities(oidcUser.getAuthorities())
                    .build();
        };
    }

    private LoginProvider getProvider(OidcUserRequest userRequest) {
        return LoginProvider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
    }

    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2LoginHandler() {
        return userRequest -> {
            LoginProvider provider = getProvider(userRequest);
            DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
            OAuth2User oAuth2User = delegate.loadUser(userRequest);
            return AppUser.builder()
                    .loginProvider(provider)
                    .username(oAuth2User.getAttribute("login"))
                    .name(oAuth2User.getAttribute("login"))
                    .password(passwordEncoder.encode(UUID.randomUUID().toString()))
                    .userId(oAuth2User.getName())
                    .imageUrl(oAuth2User.getAttribute("avatar_url"))
                    .attributes(oAuth2User.getAttributes())
                    .authorities(oAuth2User.getAuthorities())
                    .build();
        };
    }

    private LoginProvider getProvider(OAuth2UserRequest userRequest) {
        return LoginProvider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
    }

    private void createUser(AppUser user) {
        users.putIfAbsent(user.getUsername(), user);
    }
}
