package net.level0.booksale.domain;


/**
 * Created on 11/22/14 3:00 PM.
 *
 * @author: mithunshawon
 *
 */
public class User {
    private int userId;
    private String userName;
    private int uniId;
    private int deptId;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    private int user;
    private boolean isUser;
    private String photo;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUniId(int uniId) {
        this.uniId = uniId;
    }

    public int getUniId() {
        return uniId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isUser(){
        if(userId!=0){
            return isUser = true;
        }
        return isUser;
    }
}
