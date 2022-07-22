package lbd.fissst.springsecurity2lbd.security.configuration;

import lbd.fissst.springsecurity2lbd.security.UserPermissions;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/decimal").hasAnyAuthority(
                        UserPermissions.DECIMAL_WRITE.getPermission(),
                        UserPermissions.ACCESS_ALL.getPermission()
                        )
                .antMatchers(HttpMethod.POST, "/api/multiplier").hasAnyAuthority(
                        UserPermissions.MULTIPLIER_WRITE.getPermission(),
                        UserPermissions.ACCESS_ALL.getPermission()
                )
                .antMatchers("/api/number").permitAll()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/api/user/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
