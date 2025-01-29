package saucedemo.enums;

public enum EnumDriver {

    CHROME("chrome"),
    EDGE("edge");

    private String driver;

    public String getDriver() {
        return driver;
    }

    EnumDriver(String driver) {}
}
