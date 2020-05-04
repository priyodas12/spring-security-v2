package io.priyoworkspace.springsecurityv2.model;

import lombok.Getter;

public class Customer {
    @Getter
    private final Integer cId;
    @Getter
    private final String cName;

    public Customer(Integer cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }


}
