package main.model;

public enum ItemType {

    WEAPON("Weapon"),
    ARMOR("Armor"),
    OTHER("Other");

    private String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
