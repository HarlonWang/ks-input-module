package whl.ks.im;

import java.util.List;

/**
 * Created by Harlon Wang on 2025/2/20.
 * 电脑设备类
 */
public class DeviceComputer extends Device{
    public DeviceComputer(List<Config> config) {
        super(config);
        this.name = "电脑(PC)";
    }
}
