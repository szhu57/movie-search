/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudou;

/**
 *
 * @author hp
 */
public class Tudou {

    private String itemCode;
    private String title;
    private String tags;
    private String description;
    private String picUrl;
    private String pubDate;
    private String outerPlayerUrl;
    private String location;
    private String playUrl;

    public Tudou(String outerPlayerUrl) {
        this.outerPlayerUrl = outerPlayerUrl;
    }

    public Tudou() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getOuterPlayerUrl() {
        return outerPlayerUrl;
    }

    public void setOuterPlayerUrl(String outerPlayerUrl) {
        this.outerPlayerUrl = outerPlayerUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
