package pl.weseleam.model;

public enum Menu {
    NORMAL("mięsna"),
    VEGETARIAN("wegetariańska"),
    VEGAN("wegańska");

    private final String description;

    private Menu(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}