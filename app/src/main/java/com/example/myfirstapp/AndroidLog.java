package com.example.myfirstapp;

class AndroidLog implements Log {
    public void d(String tag, String message) {
        android.util.Log.d(tag, message);
    }
}
