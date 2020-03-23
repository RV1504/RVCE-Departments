package com.inhall.rvcedepartments.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class DepartmentEntity implements Parcelable {
    private String departmentName, departmentImage, departmentId;

    public DepartmentEntity(String departmentName, String departmentImage, String departmentId) {
        this.departmentName = departmentName;
        this.departmentImage = departmentImage;
        this.departmentId = departmentId;
    }

    public DepartmentEntity() {
    }

    protected DepartmentEntity(Parcel in) {
        departmentName = in.readString();
        departmentImage = in.readString();
        departmentId = in.readString();
    }

    public static final Creator<DepartmentEntity> CREATOR = new Creator<DepartmentEntity>() {
        @Override
        public DepartmentEntity createFromParcel(Parcel in) {
            return new DepartmentEntity(in);
        }

        @Override
        public DepartmentEntity[] newArray(int size) {
            return new DepartmentEntity[size];
        }
    };

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentImage() {
        return departmentImage;
    }

    public void setDepartmentImage(String departmentImage) {
        this.departmentImage = departmentImage;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departmentName);
        dest.writeString(departmentImage);
        dest.writeString(departmentId);
    }
}
