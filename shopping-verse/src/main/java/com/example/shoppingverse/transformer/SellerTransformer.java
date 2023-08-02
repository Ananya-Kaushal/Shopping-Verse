package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.requestDto.SellerRequestDto;
import com.example.shoppingverse.dto.responseDto.SellerResponseDto;
import com.example.shoppingverse.model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto)
    {
        //Request Dto->Entity
        return  Seller.builder()
                .name(sellerRequestDto.getName())
                .emailId(sellerRequestDto.getEmailId())
                .address(sellerRequestDto.getAddress())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }

    public static SellerResponseDto SellerToSellerResponseDto(Seller seller)
    {
        //Entity->Response Dto
        return SellerResponseDto.builder()
                .name(seller.getName())
                .emailId(seller.getEmailId())
                .build();
    }
}
