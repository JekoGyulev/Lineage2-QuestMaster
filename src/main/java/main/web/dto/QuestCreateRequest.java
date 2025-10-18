package main.web.dto;

import jakarta.validation.constraints.*;
import main.model.PlayerClass;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

public class QuestCreateRequest {
    @NotBlank
    @Size(min = 6, max = 26)
    private String title;
    @NotNull
    private UUID rewardItemId;
    @NotNull
    private PlayerClass eligibleClass;
    @NotBlank
    @Size(min = 110, max = 128)
    private String description;
    @NotBlank
    @URL
    private String bannerURL;
    @Min(value = 1)
    @Max(value = 13)
    private double xp;

    public QuestCreateRequest() {}

    public QuestCreateRequest(String title, UUID rewardItemId, PlayerClass eligibleClass, String description, String bannerURL, double xp) {
        this.title = title;
        this.rewardItemId = rewardItemId;
        this.eligibleClass = eligibleClass;
        this.description = description;
        this.bannerURL = bannerURL;
        this.xp = xp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getRewardItemId() {
        return rewardItemId;
    }

    public void setRewardItemId(UUID rewardItemId) {
        this.rewardItemId = rewardItemId;
    }

    public PlayerClass getEligibleClass() {
        return eligibleClass;
    }

    public void setEligibleClass(PlayerClass eligibleClass) {
        this.eligibleClass = eligibleClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBannerURL() {
        return bannerURL;
    }

    public void setBannerURL(String bannerURL) {
        this.bannerURL = bannerURL;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }
}
