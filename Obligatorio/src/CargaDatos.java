import org.apache.commons.csv.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.adt.linkedlist.*;



public class CargaDatos {
    public void datos(MyHashTable<String,User> hashUsers,MyHashTable<String,HashTag> hashHashtags,MyHashTable<Long,Tweet> hashTweets) throws IOException{
        String[] arrayHashtag;
        int counter=0;
        int counter2=0;
        int counter3=0;

        Reader in = new FileReader("src/Data/f1_dataset_test.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            counter3++;
            String userName;
            LocalDate dateTweetCreated;
            int userFavourites;
            boolean userVerified;
            boolean tweetRetweet;
            String content;
            String source;

            if (record.isConsistent()) {
                try {
                    arrayHashtag = transformarArray(record.get(11));
                    dateTweetCreated = transformarDate(record.get(9));
                    userFavourites = transformarInterger(record.get(7));
                    userVerified = transformarBoolean(record.get(8));
                    tweetRetweet = transformarBoolean(record.get(13));
                    userName = record.get(1);
                    content = record.get(10);
                    source = record.get(12);
                    counter++;
                } catch (Exception e) {
                    counter2++;
                    continue;
                }

            } else {
                counter2++;
                continue;
            }
            //Creacion de usuario
            User tweetUser;
            if (!hashUsers.contains(userName)) {
                tweetUser=new User(userName,userVerified,userFavourites);
                hashUsers.put(userName,tweetUser);
            } else {
                tweetUser=hashUsers.get(userName);
            }
            //Creacion del tweet
            Tweet nuevoTweet= new Tweet(content,tweetUser,source,tweetRetweet,dateTweetCreated);
            hashTweets.put(nuevoTweet.getId(),nuevoTweet);
            //Cargar la linkedlist de hashtags del tweet y creacion de hashtags en caso de no existir
            for (int i = 0; i < arrayHashtag.length; i++) {
                if (!hashHashtags.contains(arrayHashtag[i])) {
                    HashTag nuevoHashTag = new HashTag(arrayHashtag[i]);
                    hashHashtags.put(arrayHashtag[i], nuevoHashTag);
                    nuevoTweet.getHashTags().add(nuevoHashTag);
                } else {
                    nuevoTweet.getHashTags().add(hashHashtags.get(arrayHashtag[i]));
                }
            }
            //Poner el tweet a la lista de tweets del usuario
            tweetUser.getTweets().add(nuevoTweet.getId());
            //Verificar si es el ultimo tweet que publico el usuario y cambiar la cantidad de favourites.
            if(tweetUser.getLastTweet()==null){
                tweetUser.setLastTweet(nuevoTweet);
            } else {
                if(tweetUser.getLastTweet().getDate().isBefore(dateTweetCreated)){
                    tweetUser.setLastTweet(nuevoTweet);
                    tweetUser.setUserFavourites(userFavourites);
                }
            }


        }
        System.out.println(counter+" correctos");
        System.out.println(counter2+" errores");
        System.out.println(counter3+" total");
    }

    public String[] transformarArray(String str){
        String cleanedStr = str.replaceAll("\\[|'|\\]", "");

        // Split the string by comma and space
        String[] splitArray = cleanedStr.split(", ");

        // Create an array and copy the split values

        return splitArray;
    }

    public LocalDate transformarDate(String str) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate localDate = LocalDate.parse(str, formatter);
        return localDate;
    }

    public int transformarInterger(String str) throws NumberFormatException{
        double numberDouble = Double.parseDouble(str);
        int number = (int) numberDouble;
        return number;
    }

    public boolean transformarBoolean(String str) throws Exception{
        if(!str.equals("True") && !str.equals("False")){
            throw new Exception();
        }else{
            boolean valor = Boolean.parseBoolean(str);
            return valor;
        }

    }
}
