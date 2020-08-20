package com.accesscontrol.log.consumer;

import com.accesscontrol.access.model.AccessLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer {

  @KafkaListener(topics = "spec4-jeremias-pak-1", groupId = "AccessLog")
  public void listener(@Payload AccessLog log) {
    System.out.println(
      "log: isAuthorized:" + log.getAuthorized()
        + " customer " + log.getCustomerId()
        + " door " + log.getDoorId()
    );
  }
}
