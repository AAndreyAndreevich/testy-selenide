package saucedemo.enums;

public enum EnumFilter {
    NAME_A_TO_Z(0),
    NAME_Z_TO_A(1),
    PRICE_LOW_TO_HIGH(2),
    PRICE_HIGH_TO_LOW(3);

    private int filter;

    public int getFilter() {
        return filter;
    }

    EnumFilter(int filter) {}
}