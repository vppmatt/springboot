package com.neueda.portfolio_manager.dtos;

public class InstructionDTO {

    private InstructionType type;
    private String share;
    private Integer volume;

    public InstructionType getType() {
        return type;
    }

    public void setType(InstructionType type) {
        this.type = type;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "InstructionDTO{" +
                "type=" + type +
                ", share='" + share + '\'' +
                ", volume=" + volume +
                '}';
    }
}
