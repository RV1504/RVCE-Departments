package com.inhall.rvcedepartments.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class FaculityListEntity implements Parcelable {
    private String name,email,experience;

    public FaculityListEntity(String name, String email, String experience)
    {
        this.name=name;
        this.email=email;
        this.experience=experience;
    }



    protected FaculityListEntity(Parcel in) {
        name = in.readString();
        email = in.readString();
        experience = in.readString();
    }

    public static final Parcelable.Creator<FaculityListEntity> CREATOR = new Parcelable.Creator<FaculityListEntity>() {
        @Override
        public FaculityListEntity createFromParcel(Parcel in) {
            return new FaculityListEntity(in);
        }

        @Override
        public FaculityListEntity[] newArray(int size) {
            return new FaculityListEntity[size];
        }
    };

    public FaculityListEntity() {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getExperience() {

        return experience;
    }
    public void setPhone(String experience)
    {
        this.experience=experience;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(experience);

    }
}
