package com.accesscontrol.access.producer;

import com.accesscontrol.access.model.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccessProducer {

  @Autowired
  private KafkaTemplate<String, AccessLog> producer;

  public void publish(AccessLog log) {
    producer.send("spec4-jeremias-pak-1", log);
  }
}
