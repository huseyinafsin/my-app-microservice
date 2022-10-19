package com.lica.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository  customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

         // TODO: 18.10.2022 check if email valid
         // TODO: 18.10.2022 check if email not taken
         // TODO: 18.10.2022 store customer in db

        customerRepository.save(customer);
    }
}

