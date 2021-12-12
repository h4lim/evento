package com.evento.domain.elk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@ToString
@Document(indexName = "event_index")
public class Event {

    @Id
    private String id;

    private String eventName;

    private String eventDescription;

    private String eventLocation;

}
