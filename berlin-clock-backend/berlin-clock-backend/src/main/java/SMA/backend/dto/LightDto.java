package SMA.backend.dto;

public class LightDto {

    private int id;
    private boolean isYellow;
    private boolean isLighted;

    public LightDto(){
        super();
    }

    public LightDto(int id, boolean isYellow, boolean isLighted) {
        this.id = id;
        this.isYellow = isYellow;
        this.isLighted = isLighted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isYellow() {
        return isYellow;
    }

    public void setYellow(boolean yellow) {
        isYellow = yellow;
    }

    public boolean isLighted() {
        return isLighted;
    }

    public void setLighted(boolean lighted) {
        isLighted = lighted;
    }
}
