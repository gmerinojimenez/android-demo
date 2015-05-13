
package com.domain.user;

import com.google.gson.annotations.Expose;import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;

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
