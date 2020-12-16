package co.com.jsierra.webfluxredis.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Route {

    public static final String PATH = "/v1/redis";

    @Bean
    public RouterFunction<ServerResponse> router(Handler handler) {
        return route(
                GET(PATH + "/{key}").and(accept(MediaType.APPLICATION_JSON)), handler::getValue)
                .andRoute(POST(PATH + "/{key}").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE(PATH + "/{key}").and(accept(MediaType.APPLICATION_JSON)), handler::delete
                );
    }
}
