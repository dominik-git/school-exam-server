package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.dto.ContactInfoDTO;
import sk.bavaria.bavaria.dto.mapper.ContactInfoUtil;
import sk.bavaria.bavaria.model.ContactInfo;
import sk.bavaria.bavaria.repository.ContactRepository;

import java.util.List;

@RestController
@RequestMapping("/contact")
@Api(value = "/contact", description = "Basic crud over Address entity.")
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveContactInfo(@RequestBody ContactInfo contactInfo) {
        contactRepository.save(contactInfo);
    }

    @GetMapping
    public List<ContactInfo> getContactInfo() {
        return contactRepository.findAll();
    }

    @PostMapping(value = "/updateInfo/{id}", consumes = "application/json", produces = "application/json")
    public void updateContactInfo(@RequestBody ContactInfoDTO contactInfoDTO, @PathVariable(value = "id") Long id) {
        ContactInfo contactInfoToUpdate = contactRepository.findOne(id);
        ContactInfoUtil.enrichContactInfoFromContactInfoDTO(contactInfoToUpdate, contactInfoDTO);
        contactRepository.save(contactInfoToUpdate);


    }

}
