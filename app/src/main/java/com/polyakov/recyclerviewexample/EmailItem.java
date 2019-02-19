package com.polyakov.recyclerviewexample;

class EmailItem {
    private String title;
    private String subTitle;
    private String content;
    private String date;

    EmailItem(String title, String subTitle, String content, String date) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.date = date;
    }

    String getTitle() { return title; }

    String getSubTitle() {
        return subTitle;
    }

    String getContent() {
        return content;
    }

    String getDate() {
        return date;
    }
}