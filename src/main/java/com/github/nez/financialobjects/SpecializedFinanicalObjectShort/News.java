package com.github.nez.financialobjects.SpecializedFinanicalObjectShort;

public class News {
    String datetime;
    String headline;
    String source;
    String url;
    String summary;
    String related;
    String image;
    String lang;
    boolean hasPaywall;

    public News(String datetime, String headline, String source, String url, String summary, String related, String image, String lang, boolean hasPaywall){
        super();
        this.datetime=datetime;
        this.headline=headline;
        this.source=source;
        this.url=url;
        this.summary=summary;
        this.related=related;
        this.image=image;
        this.lang=lang;
        this.hasPaywall=hasPaywall;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getSummary() {
        return summary;
    }

    public String getRelated() {
        return related;
    }

    public String getImage() {
        return image;
    }

    public String getLang() {
        return lang;
    }

    public boolean isHasPaywall() {
        return hasPaywall;
    }
}

