package com.qf.entity;
/*
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
 */
public class User {
private Integer id;
private String username;
private String password;
private String realname;
private String email;
private String gender;
private Integer flag;
private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String realname, String email, String gender, Integer flag, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.email = email;
        this.gender = gender;
        this.flag = flag;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", flag=" + flag +
                ", role=" + role +
                '}';
    }
}
