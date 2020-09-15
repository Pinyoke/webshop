package com.clothesshop.clothesshop.modell;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "Roles")
@Entity
@Data
public class Role extends BaseEntity{

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> userList;

    private String name;

    public Role() {
    }

    public Role(String name) {

        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
