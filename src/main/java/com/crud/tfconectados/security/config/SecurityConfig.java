package com.crud.tfconectados.security.config;

import com.crud.tfconectados.security.filters.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    //Inyectando JWT Filter por constructor}

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    //se define como un bean para que pueda ser utilizado en otros lugares, como en el controlador de autenticación
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    // Bean para codificar las contraseñas para ser usando en cualquier parte de la app
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // Definir el SecurityFilterChain como un bean, ya no necesitamos heredar, configuramos toda la seg.
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/authenticate", "/create-authenticate", "/test").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        // Añadir el filtro JWT antes del filtro de autenticación
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    //Filter opcional si se desea configurar globalmente el acceso a los endpoints sin anotaciones
    // en cada endpoint
    /*@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //config.addAllowedOrigin("${ip.frontend}"); // Permite un solo origen (para propiedades)
        config.setAllowedOriginPatterns(Collections.singletonList("*")); //Permite todos los origenes
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept")); // Cabeceras permitidas
        config.setExposedHeaders(Arrays.asList("Authorization"));  //Importante para expponer el token
        config.setMaxAge(3600L); // Tiempo de vida de la configuración en caché (en segundos)
        source.registerCorsConfiguration("/**", config); // Aplica esta configuración a todas las rutas
        return source;
    }*/

}