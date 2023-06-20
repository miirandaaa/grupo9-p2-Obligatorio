import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
public class User {
    private String name;
    private long id;
    private static long idCounter=0;
    private boolean isVerified;
    private int userFavourites;
    private MyLinkedListImpl<Tweet> tweets;
    private Tweet lastTweet;

    public User(String name, boolean isVerified, int userFavourites) {
        this.name = name;
        this.id = idCounter++;
        this.isVerified = isVerified;
        this.userFavourites = userFavourites;
        this.tweets=null;
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
    public MyLinkedListImpl<Tweet> getTweets() {return tweets;}
    public void setTweets(MyLinkedListImpl<Tweet> tweets) {this.tweets = tweets;}
    public Tweet getLastTweet() {return lastTweet;}
    public void setLastTweet(Tweet lastTweet) {this.lastTweet = lastTweet;}
}
