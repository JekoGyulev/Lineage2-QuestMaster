package main.model;


import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "quests")
@Builder
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private double xp;
    @Column(name = "banner_url",nullable = false, unique = true)
    private String bannerUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "eligible_class", nullable = false)
    private PlayerClass eligibleClass;
    @ManyToOne(optional = false)
    private Item rewardedItem;
    @ManyToOne
    private Player capturer;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    public Quest() {}

    public Quest(UUID id, String title, String description, double xp, String bannerUrl, PlayerClass eligibleClass, Item rewardedItem, Player capturer, LocalDateTime createdOn, LocalDateTime updatedOn, String createdBy, String updatedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.xp = xp;
        this.bannerUrl = bannerUrl;
        this.eligibleClass = eligibleClass;
        this.rewardedItem = rewardedItem;
        this.capturer = capturer;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public PlayerClass getEligibleClass() {
        return eligibleClass;
    }

    public void setEligibleClass(PlayerClass eligibleClass) {
        this.eligibleClass = eligibleClass;
    }

    public Item getRewardedItem() {
        return rewardedItem;
    }

    public void setRewardedItem(Item rewardedItem) {
        this.rewardedItem = rewardedItem;
    }

    public Player getCapturer() {
        return capturer;
    }

    public void setCapturer(Player capturer) {
        this.capturer = capturer;
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
}

