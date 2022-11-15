package com.lica.customer;

import com.lica.clients.fraud.FraudCheckResponse;
import com.lica.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository  customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

         // TODO: 18.10.2022 check if email valid
         // TODO: 18.10.2022 check if email not taken
         customerRepository.saveAndFlush(customer);
       // TODO: 18.10.2022 check if fraudster

        /*

        We don't use that code anymore because we are using opengeign instead of resttemplate
                FraudCheckResponse =
                        restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                        FraudCheckResponse.class, customer.getId());
        */

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }


        // TODO: 18.10.2022 send notfication

    }
}

