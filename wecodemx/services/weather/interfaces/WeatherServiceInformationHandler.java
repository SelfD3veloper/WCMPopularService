package services.weather.interfaces;

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
public interface WeatherServiceInformationHandler
{
    public void requestWithCountry(String country);

    public void requestWithCountryAndCity(String country, String city);

    public void requestWithCords(double latitude, double longitude);

    public void requestWithId(int idCity);

}
