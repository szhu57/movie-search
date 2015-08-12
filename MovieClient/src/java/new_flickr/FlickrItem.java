/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package new_flickr;

/**
 *
 * @author SEU
 */
public class FlickrItem {
    private String URL = null;
    private String thumb = null;
    private String title = null;

    public String getThumb() {
        return thumb;
    }

    public String getURL() {
        return URL;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FlickrItem() {
    }

    public FlickrItem(String URL, String thumb, String title) {
        this.URL = URL;
        this.thumb = thumb;
        this.title = title;
    }

}
