package cloud.autotests.enums;

public enum Religions {

    CHRISTIANITY("Christianity"),
    ISLAM("Islam"),
    JUDAISM("Judaism"),
    BUDDHISM("Buddhism"),
    PAGANISM("Paganism"),
    ATHEISM("Atheism"),
    LIFE_ON_OTHER_PLANETS("I believe in life on other planets"),
    OTHER("Other"),
    NO_MATTER("Doesn't matter");


    private String description;

    //специальный конструктор
    Religions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
