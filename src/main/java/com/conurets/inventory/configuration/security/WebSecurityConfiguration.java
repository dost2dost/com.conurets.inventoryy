package com.conurets.inventory.configuration.security;

import com.conurets.inventory.configuration.security.jwt.JwtAccessDeniedHandler;
import com.conurets.inventory.configuration.security.jwt.JwtAuthenticationEntryPoint;
import com.conurets.inventory.configuration.security.jwt.JwtAuthenticationTokenFilter;
import com.conurets.inventory.service.CustomUserDetailsService;
import com.conurets.inventory.util.InventoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;

/**
 * @author MSA
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = "com.conurets.inventory")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static final String[] URL_API = new String[]{"/api/login", "/api/addUser"};
    public static final String[] RESOURCES = new String[]{"/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**"};
    public static final String[] UI_PAGES = new String[]{"/", "/form", "/reports", "/login",
            "/header", "/footer", "/form-left-panel", "/basic-info", "/storage-info",
            "/report-left-panel", "/report-basic-info", "/spare-useage", "/item-handling",
            "/caliration", "/item-conition", "/supplier-info","/upload","/uploadf"};

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(customUserDetailsService, "customUserDetailsService");
        InventoryHelper.checkConfiguration(jwtAuthenticationEntryPoint, "jwtAuthenticationEntryPoint");
        InventoryHelper.checkConfiguration(jwtAccessDeniedHandler, "jwtAccessDeniedHandler");
    }

    /**
     * Initialize authentication manager bean
     *
     * @return authentication manager object
     * @throws Exception
     */

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Initialize BCryptPasswordEncoder bean
     *
     * @return BCryptPasswordEncoder object
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Initialize JwtAuthenticationTokenFilter bean
     *
     * @return JwtAuthenticationTokenFilter object
     */

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * Configure customUserDetailsService passwordEncoder beans
     *
     * @param authenticationManagerBuilder
     * @throws Exception
     */

    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * Set access path
     *
     * @param http
     * @throws Exception
     */

    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl()
                .and()
                .frameOptions().disable()
                .and()
                .cors()
                .and()
                .csrf().disable().exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(UI_PAGES).permitAll()
                .antMatchers(URL_API).permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .invalidateHttpSession(Boolean.TRUE)
                .clearAuthentication(Boolean.TRUE)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll();

        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(Boolean.TRUE)
                .expiredUrl("/?expired")
                .sessionRegistry(sessionRegistry());
        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(RESOURCES);
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
}