package sk.bavaria.bavaria.dto.mapper;

import sk.bavaria.bavaria.dto.AboutItemDto;
import sk.bavaria.bavaria.model.AboutItem;

public class AboutItemUtil {

    private AboutItemUtil() {
    }

    public static void enrichAboutItemFromAboutItemDTO(AboutItem aboutItemToUpdate, AboutItemDto aboutItemDto){
        aboutItemToUpdate.setDescription(aboutItemDto.getDescription());
        aboutItemToUpdate.setPhoto(aboutItemDto.getPhoto());
        aboutItemToUpdate.setSecondTitle(aboutItemDto.getSecondTitle());
        aboutItemToUpdate.setTitle(aboutItemDto.getTitle());
    }
}
