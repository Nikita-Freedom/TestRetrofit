package com.example.myapplication;

import android.graphics.ColorSpace;
import android.widget.ImageView;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class Request{
    public Request(String name, String surname, String patronymic, ColorSpace.Model body) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.body = body;
    }
    @JsonField(name = "name")
    private
    String name;
    @JsonField(name = "surname")
    private
    String surname;
    @JsonField(name = "patronymic")
    private
    String patronymic;
    @JsonField(name = "body")
    ColorSpace.Model body;

    public Request(int i, ModelDev modelDev) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    /* тут создаешь пустой конструктор и конструктор для всех переменных*/
}
