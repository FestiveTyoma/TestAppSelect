package com.myprojects.watchfilm.POJO;



public class Result {

    @com.squareup.moshi.Json(name = "display_title")
    private String displayTitle;
    @com.squareup.moshi.Json(name = "mpaa_rating")
    private String mpaaRating;
    @com.squareup.moshi.Json(name = "critics_pick")
    private Integer criticsPick;
    @com.squareup.moshi.Json(name = "byline")
    private String byline;
    @com.squareup.moshi.Json(name = "headline")
    private String headline;
    @com.squareup.moshi.Json(name = "summary_short")
    private String summaryShort;
    @com.squareup.moshi.Json(name = "publication_date")
    private String publicationDate;
    @com.squareup.moshi.Json(name = "opening_date")
    private String openingDate;
    @com.squareup.moshi.Json(name = "date_updated")
    private String dateUpdated;
    @com.squareup.moshi.Json(name = "link")
    private Link link;
    @com.squareup.moshi.Json(name = "multimedia")
    private Multimedia multimedia;

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Integer getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(Integer criticsPick) {
        this.criticsPick = criticsPick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }
}
