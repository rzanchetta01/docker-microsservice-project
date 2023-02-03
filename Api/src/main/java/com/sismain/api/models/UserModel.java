package com.sismain.api.models;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserModel {
    public String operationType;
    public User userCustomer;

    public UserModel(String operationType, User userCustomer) {
        this.operationType = operationType;
        this.userCustomer = userCustomer;
    }

    public UserModel() {}

    public String toJson() {
        System.out.println(this.toString());
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(this);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

    @Override
    public String toString() {
        return "UserModel{" +
                "operationType='" + operationType + '\'' +
                ", userCustomer=" + userCustomer +
                '}';
    }
}

