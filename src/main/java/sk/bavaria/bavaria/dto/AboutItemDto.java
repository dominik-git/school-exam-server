package sk.bavaria.bavaria.dto;

import sk.bavaria.bavaria.model.Photo;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

public class AboutItemDto {
    @Lob
    private String description;
    private String title;
    private String secondTitle;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Photo photo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
