package com.example.myfirstapp;

class SpyLog implements Log {
    String tag;
    String message;

    public void d(String tag, String message) {
        this.tag = tag;
        this.message = message;
    }
}
