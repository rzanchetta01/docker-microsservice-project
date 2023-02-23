package com.microsservice.userHouse.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservice.userHouse.models.UserCustomer;
import com.microsservice.userHouse.mq.dto.UserCustomerDTO;
import com.microsservice.userHouse.service.IUserService;
import com.microsservice.userHouse.service.impl.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class UserConsumer {


    ObjectMapper objectMapper;
    IUserService<UserCustomer> userService;

    public UserConsumer(IUserService<UserCustomer> userService) {
        this.objectMapper = new ObjectMapper();
        this.userService = userService;
    }

    @RabbitListener(queues = "${user.rabbitmq.queue}")
    public void recievedMessage(String user) {
        System.out.println("Recieved Message From RabbitMQ: " + user);

        try {
            UserCustomerDTO userCustomer = objectMapper.readValue(user, UserCustomerDTO.class);
            switch (userCustomer.operationType) {
                case "save" -> userService.save(userCustomer.userCustomer);
                case "delete" -> userService.delete(userCustomer.userCustomer.getId());
                case "update" -> userService.update(userCustomer.userCustomer, userCustomer.userCustomer.getId());
                default -> throw  new Exception("Operation type missing");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

