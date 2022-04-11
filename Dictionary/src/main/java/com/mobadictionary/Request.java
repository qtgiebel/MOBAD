package com.mobadictionary;

public class Request {

    private String searchParams;

    private String game;

    private String keyword;

    public String getSearchParams() {
        return searchParams;
    }

    public void setHttpMethod(String httpMethod) {
        this.searchParams = httpMethod;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
