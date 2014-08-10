WCMPopularService
=========


WCMPopularService  is a custom library based in Java for obtain request response of some web services (spotify, youtube, weather api, facebook, twitter, etc), this library generate a List<Object> with a lot of HashMap<Key, Object>, where the key is a enumarator for each service.


  - Includes a interface as handler information for each event.
  - Implements a guice injector for Singleton injections
  - Includes a notification center for change events.
  - Also includes utilities for donwload image, video etc.
  - Android support.

##Developers
    Carlos Bedoy https://github.com/cbedoy
    David Garcia https://github.com/idcodeoverflow
Version
----

0.5


Usage 
-----

``` java
import com.google.inject.Guice;
import com.google.inject.Injector;
import core.common.InformationHandler;
import core.guice.Module;
import services.bing.BingService;
import services.spotify.SpotifyService;
import services.weather.WeatherService;
import services.weather.interfaces.WeatherServiceInformationHandler;
import services.youtube.YoutubeService;
import services.youtube.enums.YoutubeKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --------------------------------------------------------
 * Created by Carlos Bedoy on 2/08/14.
 * CBYoutubeApi
 * Mobile Developer
 * Aguascalientes Mexico
 * Email:       carlos.bedoy@gmail.com
 * Facebook:    https://www.facebook.com/carlos.bedoy
 * ---------CODE && MUSIC ----------------------------------
 */
public class MainTest {
    public static void main(String[]WeCodeMx)
    {
        List<Object> dataModel = SpotifyTest();

        for(Object data : dataModel)
        {
            HashMap<YoutubeKey, Object> information = (HashMap<YoutubeKey, Object>) data;
            System.out.println("-------------------------------------------------------");
            for(Map.Entry<YoutubeKey, Object> entry : information.entrySet())
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }


    }

    private static List<Object> YoutubeTest()
    {
        InformationHandler informationHandler   = null;
        Injector injector                       = Guice.createInjector(new Module());
        informationHandler                      = injector.getInstance(YoutubeService.class);
        informationHandler.executeWithValue("pokemon");
        return informationHandler.getDataModel();
    }
```
