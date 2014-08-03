package services.bing;

import core.common.RequestService;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
public class BingService extends RequestService{

    public BingService()
    {
        super();
        this.jsonParser                 = new JSONParser();
        this.dataModel                  = new ArrayList<Object>();
        this.withAuthorization          = true;
        encodeKey();
    }


    private void encodeKey(){
        String accountKey = "qcN+C8Z41IFbeIsQsDjq90rinInEKaNJew+y9CBAxdM";
        byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
        this.accountKeyEncrypt = new String(accountKeyBytes);
    }

    @Override
    public void parseData(JSONObject requestObject) {
        requestObject.toJSONString();
    }

    @Override
    public String createUrl(String valueFormatted) {
        return new String("https://api.datamarket.azure.com/Bing/Search/v1/Image?Query='"+valueFormatted+"'&$skip=0&$top=100&$format=json&Adult='Off");
    }
}
