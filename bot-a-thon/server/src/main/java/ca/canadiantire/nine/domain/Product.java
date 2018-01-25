package ca.canadiantire.nine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Victor Letunovsky (@vletunovsky)
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    private String name;

    private String barCode;

    private String imageUri;

    public Product() {
    }

    public Product(Category category, String name, String barCode, String imageUri) {
        this.category = category;
        this.name = name;
        this.barCode = barCode;
        this.imageUri = imageUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
