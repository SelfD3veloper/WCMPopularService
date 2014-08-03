package core.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import core.common.InformationHandler;
import services.bing.BingService;
import services.youtube.YoutubeService;
import tests.MainTest;

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
        this.bind(YoutubeService.class).in(Scopes.SINGLETON);
        this.bind(MainTest.class).in(Scopes.SINGLETON);

        this.bind(InformationHandler.class).annotatedWith(Names.named("services/youtube")).to(YoutubeService.class);
        this.bind(InformationHandler.class).annotatedWith(Names.named("services/bing")).to(BingService.class);
    }
}
