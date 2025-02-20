package whl.ks.im.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

import whl.ks.im.Config;
import whl.ks.im.Device;
import whl.ks.im.DeviceComputer;
import whl.ks.im.DeviceHandle;
import whl.ks.im.DeviceMobile;
import whl.ks.im.InputManager;
import whl.ks.im.SwipingInterceptor;

public class MainActivity extends AppCompatActivity {

    private Device mobile;
    private Device pc;
    private Device handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView content = findViewById(R.id.content);

        // 创建 PC 设备
        pc = new DeviceComputer(Arrays.asList(
                new Config("attack", Arrays.asList("enter", "space")),
                new Config("forward", Collections.singletonList("up"))
        ));

        // 创建手机设备
        mobile = new DeviceMobile(Arrays.asList(
                new Config("attack", Collections.singletonList("click")),
                new Config("forward", Arrays.asList("swipeStart", "swipeEnd"))
        ));

        // 添加手柄设备
        handle = new DeviceHandle(Arrays.asList(
                new Config("attack", Collections.singletonList("a")),
                new Config("forward", Collections.singletonList("b"))
        ));

        // 创建输入管理
        InputManager inputManager = new InputManager();
        // 添加设备
        inputManager.addDevice(pc);
        inputManager.addDevice(mobile);
        inputManager.addDevice(handle);
        // 添加拦截器
        inputManager.addInterceptor(new SwipingInterceptor(this));
        inputManager.setInputListener((action, event, device) -> content.append(String.format("设备%s: %s 事件触发了 %s 行为\n", device.name, event, action)));
    }

    public void mobileClick(View view) {
        mobile.trigger("click");
    }

    public void pcEnter(View view) {
        pc.trigger("enter");
    }

    public void pcUp(View view) {
        pc.trigger("up");
    }

    public void mobileSwipeStart(View view) {
        mobile.trigger("swipeStart");
    }

    public void mobileSwipeEnd(View view) {
        mobile.trigger("swipeEnd");
    }

    public void handleA(View view) {
        handle.trigger("a");
    }

    public void handleB(View view) {
        handle.trigger("b");
    }
}