package services.weather;

import core.common.RequestService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import services.weather.interfaces.WeatherServiceInformationHandler;

import java.util.ArrayList;

/**
 * --------------------------------------------------------
 * Created by Carlos Bedoy on 3/08/14.
 * CBYoutubeApi
 * Mobile Developer
 * Aguascalientes Mexico
 * Email:       carlos.bedoy@gmail.com
 * Facebook:    https://www.facebook.com/carlos.bedoy
 * ---------CODE && MUSIC ----------------------------------
 */
public class WeatherService extends RequestService implements WeatherServiceInformationHandler
{

    public WeatherService(){
        super();
        this.jsonParser                 = new JSONParser();
        this.dataModel                  = new ArrayList<Object>();
    }


    @Override
    public void parseData(JSONObject requestObject) {



        JSONObject coord                = (JSONObject) requestObject.get("coord");
        JSONObject sys                  = (JSONObject) requestObject.get("sys");
        JSONObject weather              = (JSONObject) requestObject.get("weather");
        JSONObject base                 = (JSONObject) requestObject.get("base");
        JSONObject main                 = (JSONObject) requestObject.get("main");
        JSONObject wind                 = (JSONObject) requestObject.get("wind");
        JSONObject clouds               = (JSONObject) requestObject.get("clouds");

    }

    @Override
    public String createUrl(String valueFormatted) {
        return "http://api.openweathermap.org/data/2.5/weather?"+valueFormatted;
    }

    @Override
    public void requestWithCountry(String country) {
        createUrl("q="+country);
    }

    @Override
    public void requestWithCountryAndCity(String country, String city) {
        createUrl("q="+country+","+city);
    }

    @Override
    public void requestWithCords(double latitude, double longitude) {
        createUrl("lat="+latitude+"&lon="+longitude);
    }

    @Override
    public void requestWithId(int idCity) {
        createUrl("id="+idCity);
    }
}
