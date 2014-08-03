package core.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

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
public abstract class RequestService implements  InformationHandler
{
    protected InformationDelegate       informationDelegate;
    protected JSONParser                jsonParser;
    protected List<Object>              dataModel;
    protected String                    updated;
    protected JSONObject                jsonObject;
    protected String                    accountKeyEncrypt;
    protected boolean                   withAuthorization;
    private URLConnection               urlConnection;
    private BufferedReader              bufferedReader;
    private String                      response;
    private URL                         url;
    private Object                      objectParsed;

    public  void setInformationDelegate(InformationDelegate informationDelegate){
        this.informationDelegate = informationDelegate;
    }

    public abstract void parseData(JSONObject requestObject);
    public abstract String createUrl(String valueFormatted);

    private void executeRequest(String requestLink){
        try {
            url                     = new URL(requestLink);
            urlConnection           = url.openConnection();
            urlConnection.setConnectTimeout(30000);
            urlConnection.setReadTimeout(30000);
            if (withAuthorization)
                urlConnection.setRequestProperty("Authorization", "Basic "+ accountKeyEncrypt);
            bufferedReader          = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            response                = bufferedReader.readLine();
            objectParsed            = jsonParser.parse(response);
            jsonObject              = (JSONObject)objectParsed;
            dataModel.clear();
            parseData(jsonObject);
            if(this.informationDelegate!=null)
                this.informationDelegate.reloadDataWithData(dataModel);
        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        } catch (org.json.simple.parser.ParseException e) {

        }

    }

    @Override
    public void executeWithValue(String value)
    {
        executeRequest(createUrl(validateValue(value)));
    }


    private String validateValue(String value)
    {
        return value.contains(" ")?value.replace(" ", "%20"):value;
    }

    @Override
    public List<Object> getDataModel()
    {
        return this.dataModel;
    }
}
