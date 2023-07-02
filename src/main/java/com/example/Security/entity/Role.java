package com.example.Security.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "role")
public class Role {
    @Id
    @Column(name = "roleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "roleName")
    private String roleName;
    @Column(name = "userId")
    private Integer userId;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Integer userId) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
