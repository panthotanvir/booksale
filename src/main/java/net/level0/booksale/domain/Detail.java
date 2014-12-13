package net.level0.booksale.domain;

/**
 * Created on 11/25/14 12:01 AM.
 *
 * @author: mithunshawon
 */
public class Detail {


    private Book book;
    private User user;
    private University university;
    private String divisionName ;
    private int divisionId;


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getDivisionName() { return divisionName;  }

    public void setDivisionName(String divisionName) {  this.divisionName = divisionName; }

    public int getDivisionId() { return divisionId; }

    public void setDivisionId(Integer divisionId) { this.divisionId = divisionId; }

}
