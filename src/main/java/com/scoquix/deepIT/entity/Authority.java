package com.scoquix.deepIT.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            },
            targetEntity = AuthorizedUser.class)
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private AuthorizedUser user;

    public Authority() {
    }

    public Authority(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
