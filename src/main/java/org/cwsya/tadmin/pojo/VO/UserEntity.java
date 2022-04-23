package org.cwsya.tadmin.pojo.VO;

import org.yaml.snakeyaml.events.Event;

/**
 * @author cws
 * 用户信息
 */
public class UserEntity {
    private Integer id;
    private String userName;
    private String passWord;
    private Integer status;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", status=" + status +
                '}';
    }

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String passWord, Integer status) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
