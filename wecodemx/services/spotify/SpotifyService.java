package services.spotify;

import core.common.RequestService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import services.youtube.enums.YoutubeKey;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * --------------------------------------------------------
 * Created by Carlos Bedoy on 9/08/14.
 * CBYoutubeApi
 * Mobile Developer
 * Aguascalientes Mexico
 * Email:       carlos.bedoy@gmail.com
 * Facebook:    https://www.facebook.com/carlos.bedoy
 * ---------CODE && MUSIC ----------------------------------
 */
public class SpotifyService extends RequestService {

    public SpotifyService()
    {
        super();
        this.jsonParser                 = new JSONParser();
        this.dataModel                  = new ArrayList<Object>();
        this.withAuthorization          = false;
    }

    @Override
    public String createUrl(String valueFormatted)
    {
        return new String("https://ws.spotify.com/search/1/track.json?q="+valueFormatted);
    }


    @Override
    public void parseData(JSONObject requestObject){
        JSONArray jsonArray                     = (JSONArray) requestObject.get("tracks");
        HashMap<SpotifyKey, Object> information = null;
        for(Object object : jsonArray)
        {
            if(object!=null)
            {
                information                                     = new HashMap<SpotifyKey, Object>();
                JSONObject currentItem                          = (JSONObject) object;
                JSONObject album                                = (JSONObject) currentItem.get("album");
                JSONObject artists                              = (JSONObject) currentItem.get("artists");
                information.put(SpotifyKey.ALBUM_AVAILABILITY,  album.get("availability"));
                information.put(SpotifyKey.ALBUM_HREF,          album.get("href"));
                information.put(SpotifyKey.ALBUM_NAME,          album.get("name"));
                information.put(SpotifyKey.ALBUM_RELEASED,      album.get("released"));
                information.put(SpotifyKey.NAME,                currentItem.get("name"));
                information.put(SpotifyKey.POPULARITY,          currentItem.get("popularity"));
                information.put(SpotifyKey.LENGTH,              currentItem.get("length"));
                information.put(SpotifyKey.HREF,                currentItem.get("href"));
                information.put(SpotifyKey.ARTIST_HREF,         artists.get("href"));
                information.put(SpotifyKey.ARTIST_NAME,         artists.get("name"));
                information.put(SpotifyKey.TRACK_NUMBER,        currentItem.get("track-number"));
                dataModel.add(information);
            }
        }
    }

}
