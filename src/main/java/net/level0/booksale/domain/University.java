package net.level0.booksale.domain;

/**
 * Created by mithunshawon on 11/15/14.
 */
public class University {
    private String uniName ;
    private Integer id ;
    private int deptId;
    private String deptName;


    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
