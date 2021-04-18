package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
	UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //ログインページを指定。
        //ログインページへのアクセスは全員許可する。
        http.formLogin()
            .loginPage("/login")
            //認証処理に移る
            .loginProcessingUrl("/authenticate")
            .usernameParameter("userName")
            .passwordParameter("password")
            //ログインに成功
            .defaultSuccessUrl("/task")
            .permitAll();

        //会員登録機能実装時に追加
        http.authorizeRequests()
            .antMatchers("/RegistrationForm").permitAll()
            .antMatchers("/Register").permitAll()
            .antMatchers("/Result").permitAll()
            .anyRequest().authenticated();

        http.authorizeRequests().antMatchers("/task") // /homeに一致するリクエストは
            .permitAll();

        http.authorizeRequests()
            //全てのリクエストに対して認証をかける
            .anyRequest().authenticated();
    }

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	void copnfigureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
}
