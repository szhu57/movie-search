/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "moviedb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviedb.findAll", query = "SELECT m FROM Moviedb m"),
    @NamedQuery(name = "Moviedb.findByMovieid", query = "SELECT m FROM Moviedb m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Moviedb.findByTitle", query = "SELECT m FROM Moviedb m WHERE m.title = :title"),
    @NamedQuery(name = "Moviedb.findByType", query = "SELECT m FROM Moviedb m WHERE m.type = :type"),
    @NamedQuery(name = "Moviedb.findByRating", query = "SELECT m FROM Moviedb m WHERE m.rating = :rating"),
    @NamedQuery(name = "Moviedb.findByStarts", query = "SELECT m FROM Moviedb m WHERE m.starts = :starts"),
    @NamedQuery(name = "Moviedb.findByDirector", query = "SELECT m FROM Moviedb m WHERE m.director = :director"),
    @NamedQuery(name = "Moviedb.findByDescription", query = "SELECT m FROM Moviedb m WHERE m.description = :description"),
    @NamedQuery(name = "Moviedb.findByCoverurl", query = "SELECT m FROM Moviedb m WHERE m.coverurl = :coverurl")})
public class Moviedb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Movieid")
    private Integer movieid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rating")
    private Double rating;
    @Size(max = 100)
    @Column(name = "Starts")
    private String starts;
    @Size(max = 100)
    @Column(name = "Director")
    private String director;
    @Size(max = 500)
    @Column(name = "Description")
    private String description;
    @Size(max = 200)
    @Column(name = "Coverurl")
    private String coverurl;

    public Moviedb() {
    }

    public Moviedb(Integer movieid) {
        this.movieid = movieid;
    }

    public Moviedb(Integer movieid, String title, String type) {
        this.movieid = movieid;
        this.title = title;
        this.type = type;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviedb)) {
            return false;
        }
        Moviedb other = (Moviedb) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Moviedb[ movieid=" + movieid + " ]";
    }
    
}
