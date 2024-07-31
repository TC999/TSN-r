package cn.bluemobi.dylan.http;

import android.content.Context;
import cn.bluemobi.dylan.http.MessageManager;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Http {
    private static volatile Http http;
    private static ResponseInterceptor responseInterceptor;
    private boolean debugMode;
    private final String TAG = "HTTP";
    private Integer loadingDialogLayoutId = null;

    private Http() {
    }

    public static void changeBaseUrl(String str) {
        RetrofitManager.getRetrofitManager().changeBaseUrl(str);
    }

    public static <T> T getApiService(Class<T> cls) {
        return (T) RetrofitManager.getRetrofitManager().getApiService(cls);
    }

    public static Http getHttp() {
        if (http == null) {
            synchronized (Http.class) {
                if (http == null) {
                    http = new Http();
                }
            }
        }
        return http;
    }

    public static HttpRequest with(Context context) {
        HttpRequest httpRequest = new HttpRequest(context);
        ResponseInterceptor responseInterceptor2 = responseInterceptor;
        if (responseInterceptor2 != null) {
            httpRequest.setResponseInterceptor(responseInterceptor2);
        }
        return httpRequest;
    }

    public Http addInterceptor(Interceptor interceptor) {
        RetrofitManager.getRetrofitManager().addInterceptor(interceptor);
        return this;
    }

    public Integer getLoadingDialogLayoutId() {
        return this.loadingDialogLayoutId;
    }

    public <T> Http init(Class<T> cls, String str, String str2, String str3, String str4, int i) {
        RetrofitManager.getRetrofitManager().initRetrofit(cls, str);
        JsonParse.getJsonParse().initJson(str2, str3, str4, i);
        return http;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public Http setDebugMode(boolean z) {
        this.debugMode = z;
        RetrofitManager.getRetrofitManager().setDebugMode(z);
        return http;
    }

    public Http setDefaultTimeout(long j, TimeUnit timeUnit) {
        RetrofitManager.getRetrofitManager().setDefaultTimeout(j, timeUnit);
        return this;
    }

    public Http setErrorMessage(String str) {
        MessageManager.getMessageManager().setErrorMessage(str);
        return http;
    }

    public void setLoadingDialog(int i) {
        this.loadingDialogLayoutId = Integer.valueOf(i);
    }

    public void setResponseInterceptor(ResponseInterceptor responseInterceptor2) {
        responseInterceptor = responseInterceptor2;
    }

    public Http setSecret(String str) {
        RetrofitManager.getRetrofitManager().setSecret(str);
        return this;
    }

    public Http setShowMessageModel(MessageManager.MessageModel messageModel) {
        MessageManager.getMessageManager().setShowMessageModel(messageModel);
        return http;
    }

    public Http setUseEnglishLanguage(boolean z) {
        MessageManager.getMessageManager().setUseEnglishLanguage(z);
        return http;
    }
}
