
package com.gmerino.data.net;

import com.domain.user.data.User;
import com.google.gson.annotations.Expose;

/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
