package models;

public class UserContextModel {

    private Integer id;
    private String name;

    public UserContextModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserContextModel( ) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
