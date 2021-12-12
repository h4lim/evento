package com.evento.repository.elk;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface Event extends ElasticsearchRepository<com.evento.domain.elk.Event, String> {
}
