package enums;

public enum EnumUser {

    STANDARD("standard_user"),
    LOCKED("locked_out_user"),
    PROBLEM("problem_user"),
    PERFORMANCE("performance_glitch_user"),
    ERROR("error_user"),
    VISUAL("visual_user");

    private String username;

    public String getUsername(String username) {
        return username;
    }

    EnumUser(String username) {}
}
