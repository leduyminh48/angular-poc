package ca.canadiantire.nine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.converter.WebProductTemplateToRecurringTemplateConverter;
import ca.canadiantire.nine.dao.RecurringTemplateRepository;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.dto.WebProductTemplateDto;

/**
 * @author Victor Letunovsky
 */
@Service
public class RecurringTemplateService {

    @Autowired
    private WebProductTemplateToRecurringTemplateConverter converter;

    @Autowired
    private RecurringTemplateRepository repository;

    public WebProductTemplateDto convertRecurringTemplate(Long id) {
        RecurringTemplate recurringTemplate = repository.findOne(id);
        return converter.convert(recurringTemplate);
    }

    public WebProductTemplateDto convertRecurringTemplateByUserId(Long userId) {
        RecurringTemplate recurringTemplate = repository.getRecurringTemplatesByUserId(userId).stream()
                .reduce((first, second) -> second).orElse(null);
        if (recurringTemplate == null) {
            return null;
        }
        return converter.convert(recurringTemplate);
    }
}
