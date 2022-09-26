package com.target.kafka.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    
    private String messageReferenceId;

    @Enumerated(value = EnumType.STRING)
    private MessageType messageType;

    @Version
    private long version;
}
