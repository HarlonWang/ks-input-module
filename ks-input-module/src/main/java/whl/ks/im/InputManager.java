package whl.ks.im;

import java.util.*;
/**
 * Created by Harlon Wang on 2025/2/20.
 * 输入管理器类
 */
public class InputManager {
    List<Device> devices = new ArrayList<>();
    List<Interceptor> interceptors = new ArrayList<>();
    InputListener inputListener;

    public interface InputListener {
        void onInput(String action, String event, Device device);
    }

    // 设备添加
    public void addDevice(Device device) {
        devices.add(device);
        // 添加设备的输入监听
        device.addEventListener((action, event) -> {
            boolean isInterceptor = false;
            // 是否需要拦截处理
            for (Interceptor interceptor : interceptors) {
                if (interceptor.intercept(action, event, device)) {
                    isInterceptor = true;
                    break;
                }
            }
            if (!isInterceptor) {
                dispatchEvent(action, event, device);
            }
        });
    }

    // 拦截器添加
    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void dispatchEvent(String action, String event, Device device) {
        System.out.printf("设备%s: %s 事件触发了 %s 行为\n", device.name, event, action);
        if (inputListener != null) {
            inputListener.onInput(action, event, device);
        }
    }

}
