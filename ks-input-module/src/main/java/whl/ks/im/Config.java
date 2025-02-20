package whl.ks.im;

import java.util.*;

/**
 * Created by Harlon Wang on 2025/2/20.
 * 配置类，用于存储动作和对应的事件
 */
public class Config {

    String action;
    List<String> event;

    public Config(String action, List<String> event) {
        this.action = action;
        this.event = event;
    }

}
