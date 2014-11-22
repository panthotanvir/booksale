package net.teamname.booksale.domain;

/**
 * Created on 11/22/14 3:00 PM.
 *
 * @author: mithunshawon
 */
public class User {
    private String userName;
    private int uniId;
    private int deptId;
    private String email;
    private String password;
    private String phoneNo;
    private String address;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
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
}
