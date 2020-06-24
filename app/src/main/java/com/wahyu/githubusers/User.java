package com.wahyu.githubusers;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wahyu_septiadi on 22, June 2020.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

class User implements Parcelable {
    private int avatar;
    private String name, username, company, location;
    private int repos, follower, following;

    protected User(Parcel in) {
        avatar = in.readInt();
        name = in.readString();
        username = in.readString();
        company = in.readString();
        location = in.readString();
        repos = in.readInt();
        follower = in.readInt();
        following = in.readInt();
    }

    public User() {

    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRepos() {
        return repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avatar);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeInt(repos);
        dest.writeInt(follower);
        dest.writeInt(following);
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
}
