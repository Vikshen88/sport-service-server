////package com.vikshen.sportservice.config;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////
////import javax.sql.DataSource;
////
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled " +
//                        " from users where username=?")
//                .authoritiesByUsernameQuery(
//                        "select users.username, authorities.authority " +
//                        "from users" + "" +
//                        "join users_authorities on users.id_user=users_authorities.id_user" +
//                        "join authorities on authorities.id_authority=users_authorities.id_authority");
//   }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//            http.cors();
//            http.authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .antMatchers("/post/article/**").hasRole("USER")
//                    .antMatchers("/comment/(**").hasAnyRole("USER", "ADMIN")
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .and()
//                    .formLogin()
//                        .loginPage("/login")
//                        .loginProcessingUrl("/authenticateTheUser")
//                    .permitAll()
//                   .and()
//                    .logout().permitAll()
//                    .and()
//                    .exceptionHandling().accessDeniedPage("/access-denied");
//    }
//}
