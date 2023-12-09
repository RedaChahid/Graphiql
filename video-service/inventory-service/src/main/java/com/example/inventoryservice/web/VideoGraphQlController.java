package com.example.inventoryservice.web;

import com.example.inventoryservice.dtos.CreatorDto;
import com.example.inventoryservice.dtos.VideoDto;
import com.example.inventoryservice.entities.Creator;
import com.example.inventoryservice.entities.Video;
import com.example.inventoryservice.mappers.Mappers;
import com.example.inventoryservice.repositories.creatorRepository;
import com.example.inventoryservice.repositories.videoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    Mappers mappers;
    private creatorRepository creatorrepository;
    private videoRepository videorepository;
    VideoGraphQlController(creatorRepository creatorrepository, videoRepository videorepository , Mappers mappers){
        this.creatorrepository = creatorrepository;
        this.videorepository = videorepository;
        this.mappers=mappers;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videorepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorrepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
    @MutationMapping
    public Video saveVideo(@Argument VideoDto videoDto){
        Video video = mappers.fromVideoDtoToVideo(videoDto);
        CreatorDto creatorDto = videoDto.getCreatorDto();
        Creator creator = mappers.fromCreatorDtoToCreator(creatorDto);
        Creator savedCreator = creatorrepository.save(creator);
        video.setCreator(savedCreator);
        return videorepository.save(video);
    }
    @MutationMapping
    public Creator saveCreator(@Argument CreatorDto creatorDto){
        Creator creator = mappers.fromCreatorDtoToCreator(creatorDto);
        return creatorrepository.save(creator);
    }

}
