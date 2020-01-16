package com.example.myapplication;

import android.widget.ImageView;

import java.util.ArrayList;

//import com.bluelinelabs.logansquare.annotation.JsonField;
//import com.bluelinelabs.logansquare.annotation.JsonObject;

//@JsonObject
public class ModelDev{

    private String action;
    private String image;
    ArrayList< Object > contact = new ArrayList < Object > ();


    // Getter Methods

    public String getAction() {
        return action;
    }

    public String getImage() {
        return image;
    }

    // Setter Methods

    public void setAction(String action) {
        this.action = action;
    }

    public void setImage(String image) {
        this.image = image;
    }
}