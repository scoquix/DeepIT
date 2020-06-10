package com.scoquix.deepIT.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class AuthorizedUser {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private char[] password;

    @Column(name = "enabled")
    private Integer enabled;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user",
            targetEntity = Authority.class,
            cascade = CascadeType.ALL)
    private List<Authority> roles;

    public AuthorizedUser(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public AuthorizedUser() {
    }

    public void addRole(String roleName) {
        if (roles == null)
            roles = new ArrayList<>();
        if (roleName.equals("ROLE_USER")
                || roleName.equals("ROLE_MANAGER")
                || roleName.equals("ROLE_TEACHER"))
            roles.add(new Authority(username, roleName));
    }

    public List<String> getRoles() {
        roles.forEach(e -> System.out.println(e.getRole()));
        List<String> newRoles = roles.stream()
                .map(Authority::getRole)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(newRoles);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
