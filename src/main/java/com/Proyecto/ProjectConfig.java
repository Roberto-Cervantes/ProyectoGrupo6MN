package com.Proyecto;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    // Los siguientes 5 metodos son para trabajar la parte 
    // de internacionalización del sitio web

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();

        slr.setDefaultLocale(Locale.getDefault());

        slr.setLocaleAttributeName("session.current.locale");

        slr.setTimeZoneAttributeName("session.current.timezone");

        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");

        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    // son para manejar el password y la contraseña
    // FORMA DE NO HACER UN CONTROLLER PARA ESTAS RUTAS, LOS GET MAPPING YA VAN A ESTAR DEFINIDAS AHI
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // permite ingreso con rol todos
                .authorizeHttpRequests(
                        (request) -> request
                                .requestMatchers("/", "/index", "/errores/**",
                                        "/carrito/**", "/pruebas/**", "/reportes/**",
                                        "/registro/**", "/js/**", "/webjars/**")
                                .permitAll()
                                // permite ingreso solo con rol admin       
                                .requestMatchers(
                                        "/administrador/**"
                                ).hasRole("ADMIN")
                )
                // indica cual es el formulario de login
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
    
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("Roberto")
                .password("{noop}123")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    /*
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build)
            throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(
                new BCryptPasswordEncoder()
        );
    }*/
 /* El siguiente método se utiliza para completar la clase no es 
    realmente funcional, la próxima semana se reemplaza con usuarios de BD */
    

}
