package whl.ks.im;

import java.util.List;

/**
 * Created by Harlon Wang on 2025/2/20.
 * 手机设备类
 */
public class DeviceMobile extends Device{
    public DeviceMobile(List<Config> config) {
        super(config);
        this.name = "手机";
    }
}
