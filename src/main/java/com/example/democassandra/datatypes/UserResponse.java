package com.example.democassandra.datatypes;


import java.util.List;

public class UserResponse extends Response {
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
