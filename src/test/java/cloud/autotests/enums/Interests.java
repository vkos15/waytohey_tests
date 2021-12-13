package cloud.autotests.enums;

public enum Interests {
    FAMILY("Family"),
    YOGA("Yoga"),
    FITNESS("Fitness");

    private String description;

    //специальный конструктор
    Interests(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
