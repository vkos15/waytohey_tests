package cloud.autotests.enums;

public enum PremiumSettings {

    ISHADOW_B("Hide my visiting activity from men"),
    ISHADOW_G("Hide my visiting activity from women"),
    IS_INVISIBLE("Hide my online status"),
    HIDE_ZODIAC("Hide my zodiac sign"),
    HIDE_RATE("Hide response rate"),
    HIDE_VCARD("Hide my profile from unregistered users"),
    HIDE_VIEWS("Hide my profile views"),
    HIDE_BIG_PHOTO("Hide my profile from users without photos"),

    INCOGNITO("Incognito mode Your photos will be blurred for everyone except users on your Favorites list");

    private final String description;

    //специальный конструктор
    PremiumSettings(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
