
package com.gmerino.data.net;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

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

public class Example {

    @Expose
    private List<Results> results = new ArrayList<Results>();

    /**
     * 
     * @return
     *     The results
     */
    public List<Results> getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(List<Results> results) {
        this.results = results;
    }

    public Example withResults(List<Results> results) {
        this.results = results;
        return this;
    }

}
