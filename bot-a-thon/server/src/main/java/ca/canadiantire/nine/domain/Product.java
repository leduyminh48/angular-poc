package ca.canadiantire.nine.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
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

    @Column(scale = 2)
    private BigDecimal price;

    private String imageUri;

    private Integer discount;

    private Integer bonus;

    public Product() {
    }

    public Product(final Category category, final String name, final String barCode, final String imageUri, final
    Integer discount, final Integer bonus) {
        this.category = category;
        this.name = name;
        this.barCode = barCode;
        this.imageUri = imageUri;
        this.discount = discount;
        this.bonus = bonus;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(final String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(final String imageUri) {
        this.imageUri = imageUri;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(final Integer discount) {
        this.discount = discount;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(final Integer bonus) {
        this.bonus = bonus;
    }
}
