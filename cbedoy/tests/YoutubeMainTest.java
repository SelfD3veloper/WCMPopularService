package tests;

import youtube.enums.YoutubeKey;
import youtube.services.YoutubeRequestService;

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
public class YoutubeMainTest {
    public static void main(String[]cbedoy)
    {
        YoutubeRequestService.getInstance().executeWithValue("pokemon");
        List<Object> dataModel = YoutubeRequestService.getInstance().getDataModel();
        for(Object data : dataModel)
        {
            HashMap<YoutubeKey, Object> information = (HashMap<YoutubeKey, Object>) data;
            System.out.println("-------------------------------------------------------");
            for(Map.Entry<YoutubeKey, Object> entry : information.entrySet())
            {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}
