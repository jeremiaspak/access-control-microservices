package com.accesscontrol.log.consumer;

import com.accesscontrol.access.model.AccessLog;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class LogConsumer {

  @KafkaListener(topics = "spec4-jeremias-pak-1", groupId = "AccessLog")
  public void listener(@Payload AccessLog log) {
    System.out.println(
      "log: isAuthorized:" + log.getAuthorized()
        + " customer " + log.getCustomerId()
        + " door " + log.getDoorId()
    );
    try {
      writeToFile(log);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeToFile(AccessLog log) throws IOException {
    String[] HEADERS = { "customer_id", "door_id", "is_authorized" };
    FileWriter file = new FileWriter("log.csv");
    try (CSVPrinter printer = new CSVPrinter(file, CSVFormat.DEFAULT.withHeader(HEADERS))) {
      printer.printRecord(log.getCustomerId(), log.getDoorId(), log.getAuthorized());
    }
  }
}
