package com.zca.blog.entities;

import java.util.Date;

public class MyGame {
    private Integer gId;

    private String gameTitle;

    private String gTag;

    private Integer gameClass;

    private Integer state;

    private Date creatorTime;

    private Date updateTime;

    private String gameCover;

    private String gamePreview;

    private String creatorPerson;

    private Integer creatorId;

    private String gameContent;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getgTag() {
        return gTag;
    }

    public void setgTag(String gTag) {
        this.gTag = gTag;
    }

    public Integer getGameClass() {
        return gameClass;
    }

    public void setGameClass(Integer gameClass) {
        this.gameClass = gameClass;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getGameCover() {
        return gameCover;
    }

    public void setGameCover(String gameCover) {
        this.gameCover = gameCover;
    }

    public String getGamePreview() {
        return gamePreview;
    }

    public void setGamePreview(String gamePreview) {
        this.gamePreview = gamePreview;
    }

    public String getCreatorPerson() {
        return creatorPerson;
    }

    public void setCreatorPerson(String creatorPerson) {
        this.creatorPerson = creatorPerson;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getGameContent() {
        return gameContent;
    }

    public void setGameContent(String gameContent) {
        this.gameContent = gameContent;
    }
}