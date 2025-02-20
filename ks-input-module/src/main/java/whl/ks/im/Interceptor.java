package whl.ks.im;

/**
 * Created by Harlon Wang on 2025/2/20.
 * 拦截器
 */
public interface Interceptor {
    boolean intercept(String action, String event, Device device);
}
