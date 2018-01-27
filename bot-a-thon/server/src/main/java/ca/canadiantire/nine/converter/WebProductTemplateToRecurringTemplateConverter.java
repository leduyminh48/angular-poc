package ca.canadiantire.nine.converter;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.dto.WebProductTemplateDto;

/**
 * @author Victor Letunovsky
 */
@Component
public class WebProductTemplateToRecurringTemplateConverter {

    @Autowired
    private RecurringItemRepository recurringItemRepository;

    public WebProductTemplateDto convert(RecurringTemplate template) {
        WebProductTemplateDto dto = new WebProductTemplateDto();
        dto.setName(template.getName());
        dto.setActive(template.getActive());
        LocalDate startDate = template.getStartDate();
        if (startDate != null) {
            dto.setStartDate(startDate.toString());
        }
        LocalDate endDate = template.getEndDate();
        if (endDate != null) {
            dto.setEndDate(endDate.toString());
        }
        dto.setTimeUnitAmount(template.getTimeUnitAmount());
        dto.setTimeUnits(template.getTimeUnit());
        dto.setDiscount(template.getDiscount());
        dto.setProducts(recurringItemRepository.getRecurringItemsByTemplateId(template.getId()).stream()
                .map(this::convertItem).collect(Collectors.toSet()));
        return dto;
    }

    private WebProductTemplateDto.WebProductTemplateItem convertItem(RecurringItem item) {
        WebProductTemplateDto.WebProductTemplateItem dtoItem = new WebProductTemplateDto.WebProductTemplateItem();
        dtoItem.setId(item.getId());
        dtoItem.setQuantity(item.getQuantity());
        dtoItem.setProduct(item.getProduct());
        return dtoItem;
    }
}
