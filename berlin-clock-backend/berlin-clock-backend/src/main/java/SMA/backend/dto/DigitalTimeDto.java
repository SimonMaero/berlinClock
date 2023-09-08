package SMA.backend.dto;

public class DigitalTimeDto {

    private String digitalTime;

    public DigitalTimeDto() {
        super();
    }
    public DigitalTimeDto(String digitalTime) {
        this.digitalTime = digitalTime;
    }

    public String getDigitalTime() {
        return digitalTime;
    }

    public void setDigitalTime(String digitalTime) {
        this.digitalTime = digitalTime;
    }
}
