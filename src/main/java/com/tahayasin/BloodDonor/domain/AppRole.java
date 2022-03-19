package com.tahayasin.BloodDonor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    private String roleName;


    @Override
    public String getAuthority() {
        return roleName;
    }

//    @ManyToMany(mappedBy = "roles")
//    private Set<AppUser> users;
}
