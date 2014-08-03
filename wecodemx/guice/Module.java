package guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import tests.YoutubeMainTest;
import youtube.services.YoutubeRequestService;

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
public class Module extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(YoutubeRequestService.class).in(Scopes.SINGLETON);
        this.bind(YoutubeMainTest.class).in(Scopes.SINGLETON);
    }
}
