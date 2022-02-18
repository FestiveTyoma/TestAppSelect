package com.myprojects.watchfilm.POJO;




public class Link {

    @com.squareup.moshi.Json(name = "type")
    private String type;
    @com.squareup.moshi.Json(name = "url")
    private String url;
    @com.squareup.moshi.Json(name = "suggested_link_text")
    private String suggestedLinkText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuggestedLinkText() {
        return suggestedLinkText;
    }

    public void setSuggestedLinkText(String suggestedLinkText) {
        this.suggestedLinkText = suggestedLinkText;
    }

}
