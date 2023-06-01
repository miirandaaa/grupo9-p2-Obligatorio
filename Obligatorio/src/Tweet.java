public class Tweet {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    private String content;
    private User user;
    private String source;

    private boolean isRetweet;

    public Tweet(long id, String content, User user, String source, boolean isRetweet) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.source = source;
        this.isRetweet = isRetweet;
    }
}
