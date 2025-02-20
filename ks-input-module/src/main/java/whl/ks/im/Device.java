package whl.ks.im;

import java.util.*;
/**
 * Created by Harlon Wang on 2025/2/20.
 * 设备抽象类
 */
public abstract class Device {

    public String name;
    EventListener eventListener;
    Map<String, List<String>> eventBinding = new HashMap<>();

    public Device(List<Config> config) {
        initEventBinding(config);
    }

    // 接收设备的事件
    public void trigger(String eventCode) {
        for (Map.Entry<String, List<String>> entry : eventBinding.entrySet()) {
            String action = entry.getKey();
            List<String> events = entry.getValue();
            for (String event : events) {
                if (event.equals(eventCode)) {
                    if (eventListener != null) {
                        eventListener.onEvent(action, event);
                    }
                }
            }
        }
    }

    // 后续可以支持添加多个事件监听
    public void addEventListener(EventListener listener) {
        this.eventListener = listener;
    }

    // 按键和行为绑定
    public void bindEvent(String action, List<String> event) {
        eventBinding.computeIfAbsent(action, k -> new ArrayList<>()).addAll(event);
    }

    public void initEventBinding(List<Config> config) {
        for (Config item : config) {
            bindEvent(item.action, item.event);
        }
    }

}
