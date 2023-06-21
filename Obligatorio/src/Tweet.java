import uy.edu.um.prog2.adt.linkedlist.*;

import java.time.LocalDate;
import java.util.Date;

public class Tweet {
    private String content;
    private static long idCounter=0;
    private long id;
    private User user;
    private String source;
    private boolean isRetweet;
    private LocalDate date;
    private MyLinkedListImpl<HashTag> hashTags;
    public Tweet (String content, User user, String source, boolean isRetweet, LocalDate date) {
        this.id = idCounter++;
        this.content = content;
        this.user = user;
        this.source = source;
        this.isRetweet = isRetweet;
        this.date = date;
        this.hashTags=new MyLinkedListImpl<>();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getContent() {return content;}
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
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}
    public MyLinkedListImpl<HashTag> getHashTags() {return hashTags;}
    public void setHashTags(MyLinkedListImpl<HashTag> hashTags) {this.hashTags = hashTags;}
}
