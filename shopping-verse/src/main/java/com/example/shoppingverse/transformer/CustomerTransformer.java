package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.requestDto.CustomerRequestDto;
import com.example.shoppingverse.dto.responseDto.CustomerResponseDto;
import com.example.shoppingverse.model.Customer;

//@UtilityClass  -> for ensuring class is not instantiated but not a std. practice to write
public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId())
                .address(customerRequestDto.getAddress())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo())
                .address(customer.getAddress())
                .build();
    }
}
