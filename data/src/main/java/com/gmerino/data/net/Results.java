
package com.gmerino.data.net;

import java.util.ArrayList;
import java.util.List;

import com.domain.user.data.Info;
import com.domain.user.data.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("results")
    @Expose
    private List<User> users = new ArrayList<User>();
    @SerializedName("info")
    @Expose
    private Info info;

    /**
     * 
     * @return
     *     The results
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * 
     * @param users
     *     The results
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * 
     * @return
     *     The info
     */
    public Info getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

}
