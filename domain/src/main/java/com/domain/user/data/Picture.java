
package com.domain.user.data;

import com.google.gson.annotations.Expose;

public class Picture {

    @Expose
    private String large;
    @Expose
    private String medium;
    @Expose
    private String thumbnail;

    /**
     * 
     * @return
     *     The large
     */
    public String getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(String large) {
        this.large = large;
    }

    public Picture withLarge(String large) {
        this.large = large;
        return this;
    }

    /**
     * 
     * @return
     *     The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Picture withMedium(String medium) {
        this.medium = medium;
        return this;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Picture withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

}
