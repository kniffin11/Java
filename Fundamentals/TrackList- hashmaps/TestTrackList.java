import java.util.HashMap;
import java.util.Set;

public class TestTrackList {
    public static void main(String[] args){
        // Create a trackList of type HashMap
        // Add in at least 4 songs that are stored by title
        // Pull out one of the songs by its track title
        // Print out all the track names and lyrics in the format Track: Lyrics
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("1985", "1985 I arrived");
        trackList.put("No Role Models", "No role models and I'm here right now");
        trackList.put("Crooked Smile", "Just to show them kids its real");
        trackList.put("Snow on da Bluff", "Fooled by my college degree");
        trackList.get("1985");

        Set<String> Lyrics = trackList.keySet();
        for(String Track : Lyrics){
            System.out.println(Track);
            System.out.println(trackList.get(Track));  
        }

    }
}
