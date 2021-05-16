package multiversebootcamp.springboot.security


//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import kotlin.Throws
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.web.server.ServerHttpSecurity
//import org.springframework.security.config.web.server.ServerHttpSecurity.http
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//import org.w3c.dom.Text
//import java.lang.Exception

//@Configuration
//@EnableWebSecurity
//class SecurityConfig : BCryptPasswordEncoder() {
//    init {
//
//        fun hashedPassword = SecurityConfig.run { encode("passsword") }
//    }

//    override fun configure(http: HttpSecurity?) {
//        http{
//            httpBasic("user", "password")
//        }
//    }

//}

//internal class WebSecurityConfig : WebSecurityConfigurerAdapter() {
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//            .authorizeRequests()
//            .antMatchers("/", "/home").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll()
//    }
//
//    @Bean
//    public override fun userDetailsService(): UserDetailsService {
//        val user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("password")
//            .roles("USER")
//            .build()
//        return InMemoryUserDetailsManager(user)
//    }
//}