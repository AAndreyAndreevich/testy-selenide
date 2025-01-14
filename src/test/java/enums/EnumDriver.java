package enums;

public enum EnumDriver {

    CHROME("chrome"), EDGE("edge");

    private static String driver;

    public static String getDriver() {
        return driver;
    }

    EnumDriver(String driver) {}
}
