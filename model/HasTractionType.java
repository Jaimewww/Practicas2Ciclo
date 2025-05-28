package model;

public interface HasTractionType {
    boolean hasFourWheelTraction();
    void setFourWheelTraction(boolean fourWheelTraction) throws IllegalArgumentException;
}
