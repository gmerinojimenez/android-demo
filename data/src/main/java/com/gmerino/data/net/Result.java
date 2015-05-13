
package com.gmerino.data.net;

import com.domain.user.User;
import com.google.gson.annotations.Expose;

public class Result {

    @Expose
    private User user;
    @Expose
    private String seed;

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public Result withUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * 
     * @return
     *     The seed
     */
    public String getSeed() {
        return seed;
    }

    /**
     * 
     * @param seed
     *     The seed
     */
    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Result withSeed(String seed) {
        this.seed = seed;
        return this;
    }

}
