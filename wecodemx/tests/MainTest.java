package tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import core.common.InformationHandler;
import core.guice.Module;
import services.bing.BingService;
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
        InformationHandler informationHandler;
        Injector injector = Guice.createInjector(new Module());
        informationHandler = injector.getInstance(YoutubeService.class);
        informationHandler.executeWithValue("pokemon");
        List<Object> dataModel = informationHandler.getDataModel();
        for(Object data : dataModel)
        {
            HashMap<YoutubeKey, Object> information = (HashMap<YoutubeKey, Object>) data;
            System.out.println("-------------------------------------------------------");
            for(Map.Entry<YoutubeKey, Object> entry : information.entrySet())
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        informationHandler = injector.getInstance(BingService.class);
        informationHandler.executeWithValue("pokemon");

    }
}
