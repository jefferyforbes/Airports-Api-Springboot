package multiversebootcamp.springboot.security.mocksecurity

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity(debug = true)
class BasicWebSecurity : WebSecurityConfigurerAdapter() {

    @Override
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .inMemoryAuthentication()
            .withUser("mainUser")
            .password("mainPassword")
            .roles("admin")

        User.builder()
            .username("mainUser")
            .password("mainPassword")
    }

    @Bean
    fun getPasswordEncoder(): PasswordEncoder? {
        return NoOpPasswordEncoder.getInstance()
    }
}