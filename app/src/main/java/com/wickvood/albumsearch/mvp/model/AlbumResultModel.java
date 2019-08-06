package com.wickvood.albumsearch.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumResultModel {
    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<AlbumsModel> results = null;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<AlbumsModel> getResults() {
        return results;
    }

    public void setResults(List<AlbumsModel> results) {
        this.results = results;
    }
}
