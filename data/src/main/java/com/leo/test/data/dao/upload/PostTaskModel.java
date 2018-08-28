package com.leo.test.data.dao.upload;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */

public class PostTaskModel implements Parcelable {

    private String phone;

    private String password;

    public PostTaskModel() {
    }

    public PostTaskModel(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostTaskModel{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phone);
        dest.writeString(this.password);
    }

    protected PostTaskModel(Parcel in) {
        this.phone = in.readString();
        this.password = in.readString();
    }

    public static final Creator<PostTaskModel> CREATOR = new Creator<PostTaskModel>() {
        @Override
        public PostTaskModel createFromParcel(Parcel source) {
            return new PostTaskModel(source);
        }

        @Override
        public PostTaskModel[] newArray(int size) {
            return new PostTaskModel[size];
        }
    };
}
