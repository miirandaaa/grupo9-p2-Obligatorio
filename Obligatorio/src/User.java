import uy.edu.um.prog2.adt.linkedlist.*;

import java.time.LocalDate;

public class User {
    private String name;
    private long id;
    private static long idCounter=0;
    private boolean isVerified;
    private int userFavourites;
    private MyLinkedListImpl<Long> tweets;
    private LocalDate lastTweet;

    public User(String name, boolean isVerified, int userFavourites) {
        this.name = name;
        this.id = idCounter++;
        this.isVerified = isVerified;
        this.userFavourites = userFavourites;
        this.tweets=new MyLinkedListImpl<>();
        this.lastTweet = null;
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
    public static long getIdCounter() {return idCounter;}
    public static void setIdCounter(long idCounter) {User.idCounter = idCounter;}
    public boolean isVerified() {return isVerified;}
    public void setVerified(boolean verified) {isVerified = verified;}
    public int getUserFavourites() {return userFavourites;}
    public void setUserFavourites(int userFavourites) {this.userFavourites = userFavourites;}
    public MyLinkedListImpl<Long> getTweets() {return tweets;}
    public void setTweets(MyLinkedListImpl<Long> tweets) {this.tweets = tweets;}
    public LocalDate getLastTweet() {return lastTweet;}
    public void setLastTweet(LocalDate lastTweet) {this.lastTweet = lastTweet;}
}
