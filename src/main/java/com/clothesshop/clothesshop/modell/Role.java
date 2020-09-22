package com.clothesshop.clothesshop.modell;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "Roles")
@Entity
@NoArgsConstructor
public class Role extends BaseEntity{

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> userList;

    private String name;

}
