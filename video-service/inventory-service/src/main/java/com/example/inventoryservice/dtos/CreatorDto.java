package com.example.inventoryservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatorDto {
    String name;
    String email;
}
