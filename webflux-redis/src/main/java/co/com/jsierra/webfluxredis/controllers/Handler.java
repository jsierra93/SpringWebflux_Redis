package co.com.jsierra.webfluxredis.controllers;

import co.com.jsierra.webfluxredis.models.Message;
import co.com.jsierra.webfluxredis.services.MessageRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyExtractors.toMono;

@Slf4j
@Configuration
public class Handler {
    @Autowired
    private MessageRedisService messageRedisService;

    public Mono<ServerResponse> saveValue(ServerRequest serverRequest) {
        String key = serverRequest.pathVariable("key");
        Mono<Boolean> message = serverRequest.body(toMono(Message.class))//toMono es un extractor
             /*   .map( msg -> {
                    msg.setId(UUID.randomUUID().toString());
                    return msg;
                })*/
                .flatMap( msg ->  messageRedisService.put(key, msg));

        return ServerResponse
                .ok()
                .body(message, Boolean.class);
    }

    public Mono<ServerResponse> getValue(ServerRequest serverRequest) {
        String key = serverRequest.pathVariable("key");
        return ServerResponse
                .ok()
                .body(messageRedisService.get(key), Message.class);
    }

    public Mono<ServerResponse> deleteValue(ServerRequest serverRequest) {
        String key = serverRequest.pathVariable("key");
        return ServerResponse
                .ok()
                .body(messageRedisService.delete(key), Boolean.class);
    }
}
