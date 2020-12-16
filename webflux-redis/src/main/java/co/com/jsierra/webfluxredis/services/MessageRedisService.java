package co.com.jsierra.webfluxredis.services;

import co.com.jsierra.webfluxredis.models.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MessageRedisService {

    @Autowired
    private ReactiveRedisTemplate<String, Message> redisTemplate;

    public Mono<Boolean> put(String key, Message message) {
        return redisTemplate.opsForValue().set(key, message)
                .doFinally(val -> log.info("Save: key {} , value: {}", key, message ));
    }

    public Mono<Message> get(String key) {
        return redisTemplate.opsForValue().get(key)
                .doOnNext(val -> log.info("Get: key {} , value: {}", key, val ));
    }

    public Mono<Boolean> delete(String key) {
        return redisTemplate.opsForValue().delete(key)
                .doFinally(val -> log.info("Delete: key {} ", key ));
    }
}
