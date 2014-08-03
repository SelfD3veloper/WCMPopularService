import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import guice.Module;

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
public class Main {
    public static void main(String[]WeCodeMx){
        Injector injector = Guice.createInjector(new Module());
    }
}
