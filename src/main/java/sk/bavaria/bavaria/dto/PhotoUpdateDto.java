package sk.bavaria.bavaria.dto;

import java.io.Serializable;

public class PhotoUpdateDto implements Serializable{
    private Long id;
    private Integer oredering;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOredering() {
        return oredering;
    }

    public void setOredering(Integer oredering) {
        this.oredering = oredering;
    }
}
