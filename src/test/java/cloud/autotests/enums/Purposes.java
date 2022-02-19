package cloud.autotests.enums;

public enum Purposes {

    NO_MATTER("Doesn\'t matter"),
    FRIENDSHIP("Friendship"),
    SERIOUS_RELATIONSHIP("Serious relationship"),
    FLIRTING("Flirting");


    private String description;

    //специальный конструктор
    Purposes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}