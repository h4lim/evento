package com.evento.domain.elk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Document(indexName = "participation_index")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long accountId;

    @Column
    private Long eventId;

}
