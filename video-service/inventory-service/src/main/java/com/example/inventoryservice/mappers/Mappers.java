package com.example.inventoryservice.mappers;

import com.example.inventoryservice.dtos.CreatorDto;
import com.example.inventoryservice.dtos.VideoDto;
import com.example.inventoryservice.entities.Creator;
import com.example.inventoryservice.entities.Video;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mappers {
    private ModelMapper modelMapper = new ModelMapper();

    public Creator fromCreatorDtoToCreator(CreatorDto creatorDto){
        return this.modelMapper.map(creatorDto,Creator.class);
    }
    public Video fromVideoDtoToVideo(VideoDto videodto){
        return this.modelMapper.map(videodto, Video.class);
    }

}
