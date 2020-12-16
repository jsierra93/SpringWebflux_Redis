package co.com.jsierra.webfluxredis.models;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;
    private String message;
}
