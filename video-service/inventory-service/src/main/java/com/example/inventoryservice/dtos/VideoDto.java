package com.example.inventoryservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VideoDto {
    String name;
    String url;
    String description;
    String datePublication;
    CreatorDto creatorDto;
}
