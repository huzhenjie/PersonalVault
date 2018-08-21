package com.scrat.personalvault.data.storage.img;

import com.google.auto.value.AutoValue;

import java.io.Serializable;

@AutoValue
public abstract class Img implements Serializable {
    public abstract long id();
    public abstract long size();
    public abstract String imgName();
    public abstract long createdAt();
    public abstract long updateAt();
    public abstract String md5();

}
