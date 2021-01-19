package com.example.democassandra.datatypes;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("users") // must be same name as that of table in the database
public class User {
    @PrimaryKey
    @Column("userId")   // must be same name as column name in the database
    private int userId;

    @Column("username")
    private String name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
