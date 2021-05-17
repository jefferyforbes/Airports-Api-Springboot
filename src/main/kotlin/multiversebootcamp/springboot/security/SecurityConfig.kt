package multiversebootcamp.springboot.security


import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityRequirements
//import multiversebootcamp.springboot.security.SecurityConfig.ROLES.ADMIN_ROLE
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import kotlin.Throws
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.w3c.dom.Text
import java.lang.Exception

//@EnableWebSecurity
//class SecurityConfig: WebSecurityConfigurerAdapter() {
//    init{
//        val users = User.withUsername("mainUser")
//        val user = users
//            .username("mainUser")
//            .password("mainPassword")
//            .roles("USER", ADMIN_ROLE)
//            .build()
//    }
//
//    fun userAuthenticate(
//        authenticate: AuthenticationManagerBuilder,
//        passwordEncoder: BCryptPasswordEncoder
//    ): AuthenticationManagerBuilder {
//        authenticate
//            .inMemoryAuthentication()
//            .withUser("mainUser")
//            .password(passwordEncoder.encode("mainPassword"))
//            .authorities(ADMIN_ROLE)
//            .roles(ADMIN_ROLE)
//        return authenticate
//    }
//
//    val passwordEncoder = BCryptPasswordEncoder()
//
//    val currentUser: UserDetails? = User.withUsername("mainUser")
//    .password(passwordEncoder.encode("mainPassword"))
//    .authorities(ADMIN_ROLE)
//    .roles(ADMIN_ROLE)
//    .build()
//
//    override fun configure(http: HttpSecurity) {
//        http
//            .csrf()
//            .disable()
//            .authorizeHttpRequests {
//                http
//                    .authorizeRequests()
//                    .anyRequest().fullyAuthenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .permitAll(true)
//                    .and()
//                    .logout()
//                    .permitAll()
//                    .and()
//                    .httpBasic()
//            }
//    }
//
//    object ROLES {
//        const val ADMIN_ROLE = "Admin"
//        const val USER_ROLE = "User"
//    }
//}