package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.requestDto.CustomerRequestDto;
import com.example.shoppingverse.dto.responseDto.CustomerResponseDto;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);   // saves both customer and cart;

        // prepare the response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}
