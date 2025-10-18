package main.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "items")
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType type;
    @Column(name = "xp_bonus_multiplier")
    private double xpBonusMultiplier;
    @Column(nullable = false, unique = true)
    private String iconUrl;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;


    public Item() {}

    public Item(UUID id, String name, ItemType type, double xpBonusMultiplier, String iconUrl, LocalDateTime createdOn, LocalDateTime updatedOn, String createdBy, String updatedBy) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.xpBonusMultiplier = xpBonusMultiplier;
        this.iconUrl = iconUrl;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public double getXpBonusMultiplier() {
        return xpBonusMultiplier;
    }

    public void setXpBonusMultiplier(double xpBonusMultiplier) {
        this.xpBonusMultiplier = xpBonusMultiplier;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }



    public String getTypeAndMultiplierFormatted() {
        // Weapon - x3.0 XP
        return String.format("%s - x%.1f XP", type, xpBonusMultiplier);
    }

}

