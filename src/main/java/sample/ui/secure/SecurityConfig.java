package sample.ui.secure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import org.springframework.core.env.Environment;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  Environment env;

  @Autowired
  public void registerGlobalAuthentication(AuthenticationManagerBuilder auth)
      throws Exception
  {
    if ("h2".equals(env.getProperty("spring.profiles.active")))
      return;

    DefaultSpringSecurityContextSource context = new DefaultSpringSecurityContextSource("ldap://worldcompany.com:389/dc=worldcompany,dc=com");
    context.afterPropertiesSet();

    auth.ldapAuthentication()
        .contextSource(context)
        .userDnPatterns("uid={0},ou=people")
        //.groupRoleAttribute("cn")
        .rolePrefix("");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
      http.csrf()
          .disable()
          .authorizeRequests()
        .antMatchers("/css/**", "/js/**", "/app/**", "/img/**", "/error").permitAll()
          .anyRequest().authenticated()
        .and()
          .formLogin().loginPage("/login").defaultSuccessUrl("/", true).permitAll()
        .and()
        .logout().permitAll();
  }
}