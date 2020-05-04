package io.priyoworkspace.springsecurityv2.controller;

import io.priyoworkspace.springsecurityv2.exceptionHandle.IlligalCustomerDataNotFoundException;
import io.priyoworkspace.springsecurityv2.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/websale/in/v2")
public class CustomerDataController {

    private final static List<Customer> dummyData= Arrays.asList(
        new Customer(1002,"abcd"),new Customer(1003,"asdf")
    );

    @GetMapping("/customer/{c_id}")
    public Customer getCustomerDetail(@PathVariable("c_id") Integer c_id){
        log.info("getCustomerDetail() called for {}",c_id);
        return dummyData.stream().filter(c->c.getCId().equals(c_id)).findFirst().orElseThrow(()->new IlligalCustomerDataNotFoundException(""+c_id));
    }
}
