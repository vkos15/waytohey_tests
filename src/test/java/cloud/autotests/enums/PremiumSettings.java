package cloud.autotests.enums;

public enum PremiumSettings {

    ISHADOW_B("Don’t show my appearance on pages of the males"),
    ISHADOW_G("Don’t show my appearance on pages of the females"),
    IS_INVISIBLE("Hide my online status"),
    HIDE_ZODIAC("Hide my zodiac sign"),
    HIDE_VIP("Hide your Premium subscription from others"),
    HIDE_VCARD("Hide my profile from unregistered users"),
    HIDE_BIG_PHOTO("Hide my profile from users without photos");

    private final String description;

    //специальный конструктор
    PremiumSettings(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
