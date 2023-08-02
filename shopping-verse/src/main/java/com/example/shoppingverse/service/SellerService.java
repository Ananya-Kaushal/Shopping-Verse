package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.requestDto.SellerRequestDto;
import com.example.shoppingverse.dto.responseDto.SellerResponseDto;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        //Request Dto->Entity
        Seller seller= SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        //Save the entity
        Seller savedSeller=sellerRepository.save(seller);

        //Entity-> Response Dto
        SellerResponseDto sellerResponseDto=SellerTransformer.SellerToSellerResponseDto(savedSeller);
        return sellerResponseDto;
    }
}
