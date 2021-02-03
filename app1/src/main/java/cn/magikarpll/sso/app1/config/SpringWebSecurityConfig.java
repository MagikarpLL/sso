//package cn.magikarpll.sso.app1.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/protected-endpoint").hasAuthority("ADMIN")
//                .anyRequest().authenticated();
//    }
//
//}
