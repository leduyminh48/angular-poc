package ca.canadiantire.nine.dto;

import java.util.Collection;

import ca.canadiantire.nine.domain.Product;
import ca.canadiantire.nine.enums.TimeUnits;

/**
 * @author Victor Letunovsky
 */
public class WebProductTemplateDto {

    private String name;

    private Boolean active;

    private String startDate;

    private String endDate;

    private Integer timeUnitAmount;

    private TimeUnits timeUnits;

    private Integer discount;

    private Collection<WebProductTemplateItem> products;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    public Integer getTimeUnitAmount() {
        return timeUnitAmount;
    }

    public void setTimeUnitAmount(final Integer timeUnitAmount) {
        this.timeUnitAmount = timeUnitAmount;
    }

    public TimeUnits getTimeUnits() {
        return timeUnits;
    }

    public void setTimeUnits(final TimeUnits timeUnits) {
        this.timeUnits = timeUnits;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(final Integer discount) {
        this.discount = discount;
    }

    public Collection<WebProductTemplateItem> getProducts() {
        return products;
    }

    public void setProducts(final Collection<WebProductTemplateItem> products) {
        this.products = products;
    }

    public static class WebProductTemplateItem {

        private Long id;

        private Integer quantity;

        private Product product;

        public Long getId() {
            return id;
        }

        public void setId(final Long id) {
            this.id = id;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(final Integer quantity) {
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(final Product product) {
            this.product = product;
        }
    }

}
