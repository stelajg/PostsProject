package com.example.brand.dto;

public class Post {
    String caption;
    String id;
    String picture;
    Float engagement;
    String permalink;
    String date;
    String created_time;
    String comments;
    Integer reach;
    Integer impressions;
    String type;
    Integer shares;
    Float post_engagement_rate;
    Integer likes;
    SIProfile si_profile_info;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Float getEngagement() {
        return engagement;
    }

    public void setEngagement(Float engagement) {
        this.engagement = engagement;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getReach() {
        return reach;
    }

    public void setReach(Integer reach) {
        this.reach = reach;
    }

    public Integer getImpressions() {
        return impressions;
    }

    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Float getPost_engagement_rate() {
        return post_engagement_rate;
    }

    public void setPost_engagement_rate(Float post_engagement_rate) {
        this.post_engagement_rate = post_engagement_rate;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public SIProfile getSi_profile_info() {
        return si_profile_info;
    }

    public void setSi_profile_info(SIProfile si_profile_info) {
        this.si_profile_info = si_profile_info;
    }
}
