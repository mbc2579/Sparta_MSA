package com.kafka_sample.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerEndpoint {

    // group이 다르고 topic이 같은 로직
    // group이 다르고 topic이 같다면 각 group마다 같은 메세지를 받음
    @KafkaListener(groupId = "group_a", topics = "topic1")
    public void consumeFromGroupA(String message) {
        log.info("Group A consumed message from topic1: " + message);
    }
    @KafkaListener(groupId = "group_b", topics = "topic1")
    public void consumeFromGroupB(String message) {
        log.info("Group B consumed message from topic1: " + message);
    }

    // topic이 다르고 group이 같은 로직
    // group이 같더라도 메세지는 topic을 대상으로 발행하기 때문에 topic2와 topic3이 각 각 따로 출력된다.
    @KafkaListener(groupId = "group_c", topics = "topic2")
    public void consumeFromGroupC(String message) {
        log.info("Group C consumed message from topic2: " + message);
    }
    @KafkaListener(groupId = "group_c", topics = "topic3")
    public void consumeFromGroupD(String message) {
        log.info("Group C consumed message from topic3: " + message);
    }

    // 둘다 다른 로직
    @KafkaListener(groupId = "group_d", topics = "topic4")
    public void consumeFromGroup0(String message) {
        log.info("Group C consumed message from topic4: " + message);
    }
}
