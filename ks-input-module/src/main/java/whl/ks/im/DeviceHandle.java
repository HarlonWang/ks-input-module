package whl.ks.im;

import java.util.List;

/**
 * Created by Harlon Wang on 2025/2/20.
 * 手柄设备类
 */
public class DeviceHandle extends Device{
    public DeviceHandle(List<Config> config) {
        super(config);
        this.name = "手柄";
    }
}
