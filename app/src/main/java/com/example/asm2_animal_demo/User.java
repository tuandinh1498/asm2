package com.example.asm2_animal_demo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable, Parcelable {
    private int Img1;
    private int Img2;
    private String text2;
    private String mota;
    //TEST commit

    protected User(Parcel in) {
        Img1 = in.readInt();
        Img2 = in.readInt();
        text2 = in.readString();
        mota = in.readString();
        byte tmpIsLiked = in.readByte();
        isLiked = tmpIsLiked == 0 ? null : tmpIsLiked == 1;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    private Boolean isLiked;

    public User(int img1, int img2, String text2,String mota) {
        Img1 = img1;
        Img2 = img2;
        this.text2 = text2;
        this.mota=mota;
        isLiked = false;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getImg1() {
        return Img1;
    }

    public void setImg1(int img1) {
        Img1 = img1;
    }

    public int getImg2() {
        return Img2;
    }

    public void setImg2(int img2) {
        Img2 = img2;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Img1 == user.Img1 && Img2 == user.Img2 && Objects.equals(text2, user.text2);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Img1);
        parcel.writeInt(this.Img2);
        parcel.writeString(this.mota);
        parcel.writeString(this.text2);
    }
}
