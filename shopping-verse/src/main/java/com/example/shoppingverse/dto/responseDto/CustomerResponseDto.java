package com.example.shoppingverse.dto.responseDto;

import com.example.shoppingverse.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponseDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;

    String address;
}
