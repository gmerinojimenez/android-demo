
package com.gmerino.data.net;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Example {

    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     * 
     * @return
     *     The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Example withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}
