package com.microsservice.userHouse.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_customer")
public class UserCustomer extends BaseUser{

    public UserCustomer() {
        super();
    }
}
