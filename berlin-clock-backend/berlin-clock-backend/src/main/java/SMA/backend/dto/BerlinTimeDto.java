package SMA.backend.dto;

public class BerlinTimeDto {

    private String berlinTime;

    public BerlinTimeDto(){
        super();
    }
    public BerlinTimeDto(String berlinTime) {
        this.berlinTime = berlinTime;
    }

    public String getBerlinTime() {
        return berlinTime;
    }

    public void setBerlinTime(String berlinTime) {
        this.berlinTime = berlinTime;
    }
}
