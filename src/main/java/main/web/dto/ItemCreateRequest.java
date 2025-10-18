package main.web.dto;

import jakarta.validation.constraints.*;
import main.model.ItemType;
import org.hibernate.validator.constraints.URL;

public class ItemCreateRequest {
    @NotBlank
    @Size(min = 6, max = 26)
    private String name;
    @NotNull
    private ItemType type;
    @Min(1)
    @Max(3)
    private double xpMultiplier;
    @URL
    @NotBlank
    private String iconUrl;

    public ItemCreateRequest() {}

    public ItemCreateRequest(String name, ItemType type, double xpMultiplier, String iconUrl) {
        this.name = name;
        this.type = type;
        this.xpMultiplier = xpMultiplier;
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public double getXpMultiplier() {
        return xpMultiplier;
    }

    public void setXpMultiplier(double xpMultiplier) {
        this.xpMultiplier = xpMultiplier;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
