package com.tahayasin.BloodDonor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private Person person;
    private String username;
    @JsonIgnore
    private String password;

    public AppUser(Person person, String username, String password, AppRole role) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>(Arrays.asList(role));
        //this.roles.add(role);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "role_id"))
    private Set<AppRole> roles;
    //private List<AppRole> roles;

    public void assignRole(AppRole appRole) {
        roles.add(appRole);
    }

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "appUser")
//    private Set<BloodRequest> bloodRequests;

//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private Collection<AppRole> roles = new ArrayList<>();

}
