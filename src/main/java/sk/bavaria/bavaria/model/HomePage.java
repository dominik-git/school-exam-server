package sk.bavaria.bavaria.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "HomePage")
public class HomePage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Photo> photos;

    public Long getId() {
        return id;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}


