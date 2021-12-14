package cloud.autotests.enums;

public enum Orientations {

    HETEROSEXUAL("Family"),
    BISEXUAL("Yoga"),
    LESBIAN("Fitness"),
    ASEXUAL("Asexual"),
    DEMISEXUAL("Demisexual"),
    PANSEXUAL("Pansexual"),
    QUEER("Queer"),
    QUESTIONING("Questioning"),
    OTHER("Other"),
    NO_MATTER("Doesn\'t matter");


    private String description;

    //специальный конструктор
    Orientations(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
