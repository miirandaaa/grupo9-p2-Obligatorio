public class User {
    private String name;
    private static long lastID = 0;
    private long id;
    public User(String name) {
        this.name = name;
        this.id = ++lastID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
