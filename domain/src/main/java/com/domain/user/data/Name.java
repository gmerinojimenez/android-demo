
package com.domain.user.data;

import com.google.gson.annotations.Expose;import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;

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

public class Name {

    @Expose
    private String title;
    @Expose
    private String first;
    @Expose
    private String last;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Name withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 
     * @return
     *     The first
     */
    public String getFirst() {
        return first;
    }

    /**
     * 
     * @param first
     *     The first
     */
    public void setFirst(String first) {
        this.first = first;
    }

    public Name withFirst(String first) {
        this.first = first;
        return this;
    }

    /**
     * 
     * @return
     *     The last
     */
    public String getLast() {
        return last;
    }

    /**
     * 
     * @param last
     *     The last
     */
    public void setLast(String last) {
        this.last = last;
    }

    public Name withLast(String last) {
        this.last = last;
        return this;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(this.title);
        builder.append(" ");
        builder.append(first);
        builder.append(" ");
        builder.append(last);
        return builder.toString();
    }

}
