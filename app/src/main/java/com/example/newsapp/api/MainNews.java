package com.example.newsapp.api;

import com.example.newsapp.api.ModelClass;

import java.util.ArrayList;

public class MainNews {

//    These three fields are the outermost objects present.
    private String status;
    private String totalResults;
    private ArrayList<ModelClass> articles; // This is an arraylist of ModelClass because it contains all the info from ModelClass.

    public MainNews(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
