package ca.canadiantire.nine.dto;

public abstract class AbstractTemplateDto {
    private Long userId;

    private String startDate;

    private Integer timeUnitAmount;

    private String timeUnit;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public Integer getTimeUnitAmount() {
        return timeUnitAmount;
    }

    public void setTimeUnitAmount(final Integer timeUnitAmount) {
        this.timeUnitAmount = timeUnitAmount;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(final String timeUnit) {
        this.timeUnit = timeUnit;
    }
}
