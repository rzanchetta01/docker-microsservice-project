package com.sismain.api.service;

import com.sismain.api.models.UserModel;
import com.sismain.api.mq.UserProducer;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserProducer producer;

    public UserService(UserProducer producer) {
        this.producer = producer;
    }

    public void postMessage(UserModel msg) {
        producer.sendMessage(msg.toJson());
    }
}
