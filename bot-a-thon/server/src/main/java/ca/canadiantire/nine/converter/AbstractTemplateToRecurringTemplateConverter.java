package ca.canadiantire.nine.converter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import ca.canadiantire.nine.dao.RecurringTemplateRepository;
import ca.canadiantire.nine.dao.UserRepository;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.dto.AbstractTemplateDto;
import ca.canadiantire.nine.enums.TimeUnits;
import ca.canadiantire.nine.service.TemplateService;

public abstract class AbstractTemplateToRecurringTemplateConverter<T extends AbstractTemplateDto> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecurringTemplateRepository templateRepository;

    @Autowired
    private TemplateService templateService;

    public RecurringTemplate convertAndSave(final T templateDto) {
        RecurringTemplate template = new RecurringTemplate();
        template.setUser(userRepository.findOne(templateDto.getUserId()));
        template.setStartDate(LocalDate.parse(templateDto.getStartDate()));
        template.setTimeUnitAmount(templateDto.getTimeUnitAmount());
        template.setTimeUnit(TimeUnits.valueOf(templateDto.getTimeUnit()));
        convertItems(templateDto, template);
        template.setAmount(templateService.calculateTemplateAmount(template));
        template.setDiscount(templateService.calculateTemplateDiscount(template));
        templateRepository.save(template);
        return template;
    }

    protected abstract void convertItems(final T templateDto, final RecurringTemplate template);
}
