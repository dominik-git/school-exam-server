package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.dto.ContactInfoDTO;
import sk.bavaria.bavaria.model.ContactInfo;
import sk.bavaria.bavaria.repository.ContactRepository;
import java.util.List;

@RestController
@RequestMapping("/contact")
@Api(value="/contact", description="Basic crud over Address entity.")
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping(value="/contact",consumes = "application/json", produces = "application/json")
    public void saveContactInfo(@RequestBody ContactInfo contactInfo){
        contactRepository.save(contactInfo);
    }

    @GetMapping
    public List<ContactInfo> getContactInfo(){
       return contactRepository.findAll();
    }

    @PostMapping(value="/updateInfo/{id}", consumes = "application/json", produces = "application/json")
    public void updateContactInfo(@RequestBody ContactInfoDTO contactInfoDTO, @PathVariable(value="id") long id){
        ContactInfo contactInfoToUpdate = contactRepository.findOne(id);
        contactInfoToUpdate.setServiceName(contactInfoDTO.getServiceName());
        contactInfoToUpdate.setEmailAddress(contactInfoDTO.getEmailAddress());
        contactInfoToUpdate.setNumber1(contactInfoDTO.getNumber1());
        contactInfoToUpdate.setNumber2(contactInfoDTO.getNumber2());
        contactInfoToUpdate.setCity(contactInfoDTO.getCity());
        contactInfoToUpdate.setStreet(contactInfoDTO.getStreet());
        contactInfoToUpdate.setPostalCode(contactInfoDTO.getPostalCode());
        contactInfoToUpdate.setOpenTime(contactInfoDTO.getOpenTime());
        contactInfoToUpdate.setCloseTime(contactInfoDTO.getCloseTime());
        contactInfoToUpdate.setOpenDay(contactInfoDTO.getOpenDay());
        contactInfoToUpdate.setCloseDay(contactInfoDTO.getCloseDay());
        contactInfoToUpdate.setPositionX(contactInfoDTO.getPositionX());
        contactInfoToUpdate.setPositionY(contactInfoDTO.getPositionY());
        contactRepository.save(contactInfoToUpdate);


    }

}
