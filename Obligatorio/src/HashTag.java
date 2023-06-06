public class HashTag {
    private static long lastID = 0;
    private long id;
    private String text;

    public HashTag(String text) {
        this.id = ++lastID;
        this.text = text;
    }
}
