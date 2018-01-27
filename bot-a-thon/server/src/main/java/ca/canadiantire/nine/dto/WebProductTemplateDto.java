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

    private Collection<WebProductTemplateItem> products;

    public static class WebProductTemplateItem {

        private String id;

        private Integer quantity;

        private Product product;

        public String getId() {
            return id;
        }

        public void setId(final String id) {
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
