package com.gmerino.data.net;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guille on 09/03/2015.
 */
class UserResponse {

    private List<Result> results = new ArrayList<>();


    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
