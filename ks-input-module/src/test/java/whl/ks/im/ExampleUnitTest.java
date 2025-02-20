package whl.ks.im;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testInputModule() {
        InputManager im = new InputManager();

        List<Config> pcConfig = Arrays.asList(
                new Config("attack", Arrays.asList("enter", "space")),
                new Config("forward", Collections.singletonList("up"))
        );
        Device pc = new DeviceComputer(pcConfig);

        List<Config> mobileConfig = Arrays.asList(
                new Config("attack", Collections.singletonList("click")),
                new Config("forward", Arrays.asList("swipeStart", "swipeEnd"))
        );
        Device mobile = new DeviceMobile(mobileConfig);

        im.addDevice(pc);
        im.addDevice(mobile);
        im.addInterceptor(new SwipingInterceptor(null));

        pc.trigger("enter");
        mobile.trigger("click");
        mobile.trigger("swipeStart");
        pc.trigger("up");
        pc.trigger("enter");
        mobile.trigger("swipeEnd");
        pc.trigger("up");
        mobile.bindEvent("attack", Collections.singletonList("longClick"));
        mobile.trigger("longClick");
    }
}