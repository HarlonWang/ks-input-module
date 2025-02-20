package whl.ks.im;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Harlon Wang on 2025/2/20.
 * 滑动拦截器
 */
public class SwipingInterceptor implements Interceptor{
    private final Context context;
    boolean swiping;

    public SwipingInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public boolean intercept(String action, String event, Device device) {
        if (event.equals("swipeStart")) {
            swiping = true;
            return false;
        } else if (event.equals("swipeEnd")) {
            swiping = false;
            return false;
        }

        if (swiping && !device.name.equals("手机") && action.equals("forward")) {
            System.out.println("事件冲突了");
            if (context != null) {
                new AlertDialog.Builder(context)
                        .setMessage("事件冲突了")
                        .setPositiveButton("确定", null)
                        .show();
            }
            return true;
        }

        return false;
    }
}
