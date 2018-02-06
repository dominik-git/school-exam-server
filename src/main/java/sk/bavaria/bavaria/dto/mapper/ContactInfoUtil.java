package sk.bavaria.bavaria.dto.mapper;

import sk.bavaria.bavaria.dto.ContactInfoDTO;
import sk.bavaria.bavaria.model.ContactInfo;

public class ContactInfoUtil {
    private ContactInfoUtil() {
    }

    public static void enrichContactInfoFromContactInfoDTO(ContactInfo contactInfoToUpdate, ContactInfoDTO contactInfoDTO){
        contactInfoToUpdate.setServiceName(contactInfoDTO.getServiceName());
        contactInfoToUpdate.setEmailAddress(contactInfoDTO.getEmailAddress());
        contactInfoToUpdate.setNumber1(contactInfoDTO.getNumber1());
        contactInfoToUpdate.setNumber2(contactInfoDTO.getNumber2());
        contactInfoToUpdate.setAddress(contactInfoDTO.getAddress());
        contactInfoToUpdate.setOpenTime(contactInfoDTO.getOpenTime());
        contactInfoToUpdate.setCloseTime(contactInfoDTO.getCloseTime());
        contactInfoToUpdate.setOpenDay(contactInfoDTO.getOpenDay());
        contactInfoToUpdate.setCloseDay(contactInfoDTO.getCloseDay());
        contactInfoToUpdate.setPositionX(contactInfoDTO.getPositionX());
        contactInfoToUpdate.setPositionY(contactInfoDTO.getPositionY());
    }
}
