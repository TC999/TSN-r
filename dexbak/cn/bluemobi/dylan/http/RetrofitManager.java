package cn.bluemobi.dylan.http;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RetrofitManager {
    private static volatile RetrofitManager singleton;
    private Object apiService;
    private long currentTimeout;
    private TimeUnit currentTimeoutUnit;
    private TimeUnit defaultTimeoutUnit;
    private SSLSocketFactory factory;
    private OkHttpClient mOkHttpClient;
    private OkHttpClient.Builder okhttpBuilder;
    private boolean overlockCard;
    private Retrofit retrofit;
    private Retrofit.Builder retrofitBuilder;
    private String secret;
    String TAG = "Http";
    private final int TIMEOUT = 15;
    private boolean debugMode = true;
    private List<Interceptor> interceptorList = new ArrayList();
    private long defaultTimeout = 30;

    private RetrofitManager() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.defaultTimeoutUnit = timeUnit;
        this.currentTimeout = 30L;
        this.currentTimeoutUnit = timeUnit;
        this.overlockCard = true;
    }

    public static String convertFileSize(long j) {
        if (j >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return String.format("%.1f GB", Float.valueOf(((float) j) / ((float) IjkMediaMeta.AV_CH_STEREO_RIGHT)));
        }
        if (j >= 1048576) {
            float f = ((float) j) / ((float) 1048576);
            return String.format(f > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f));
        } else if (j >= 1024) {
            float f2 = ((float) j) / ((float) 1024);
            return String.format(f2 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f2));
        } else {
            return String.format("%d B", Long.valueOf(j));
        }
    }

    public static String formatDuring(long j) {
        if (j < 1000) {
            return j + "ms";
        } else if (j < 60000) {
            return ((j % 60000) / 1000) + "s";
        } else {
            return ((j % C7193bi.f24584s) / 60000) + "min";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPartHeaders(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField(TTDownloadField.TT_HEADERS);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            return ((Headers) field.get(part)).get("content-disposition").split(";")[1].split("=")[1].replace("\"", "");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRequestBody(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            RequestBody requestBody = (RequestBody) field.get(part);
            MediaType contentType = requestBody.contentType();
            if (!contentType.type().equals("multipart")) {
                return contentType.type().equals(SocializeProtocolConstants.IMAGE) ? convertFileSize(requestBody.contentLength()) : "";
            }
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return buffer.readString(contentType.charset(Charset.forName("UTF-8")));
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static RetrofitManager getRetrofitManager() {
        if (singleton == null) {
            synchronized (RetrofitManager.class) {
                if (singleton == null) {
                    singleton = new RetrofitManager();
                }
            }
        }
        return singleton;
    }

    private SSLContext overlockCard() {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: cn.bluemobi.dylan.http.RetrofitManager.5
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            return sSLContext;
        } catch (Exception unused) {
            Log.e(this.TAG, "ssl出现异常");
            return null;
        }
    }

    private SSLSocketFactory setCertificates(InputStream... inputStreamArr) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int length = inputStreamArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                InputStream inputStream = inputStreamArr[i];
                int i3 = i2 + 1;
                keyStore.setCertificateEntry(Integer.toString(i2), certificateFactory.generateCertificate(inputStream));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                i2 = i3;
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void addInterceptor(Interceptor interceptor) {
        this.interceptorList.add(interceptor);
    }

    public void changeBaseUrl(String str) {
        this.retrofit = this.retrofitBuilder.baseUrl(str).build();
    }

    public <T> T getApiService(Class<T> cls) {
        long j = this.defaultTimeout;
        long j2 = this.currentTimeout;
        if (j == j2 && this.currentTimeoutUnit == this.defaultTimeoutUnit) {
            return (T) this.retrofit.create(cls);
        }
        this.okhttpBuilder.readTimeout(j2, this.currentTimeoutUnit).connectTimeout(this.currentTimeout, this.currentTimeoutUnit).writeTimeout(this.currentTimeout, this.currentTimeoutUnit);
        Retrofit build = this.retrofitBuilder.client(this.okhttpBuilder.build()).build();
        this.retrofit = build;
        T t = (T) build.create(cls);
        this.okhttpBuilder.readTimeout(this.defaultTimeout, this.defaultTimeoutUnit).connectTimeout(this.defaultTimeout, this.defaultTimeoutUnit).writeTimeout(this.defaultTimeout, this.defaultTimeoutUnit);
        this.retrofit = this.retrofitBuilder.client(this.okhttpBuilder.build()).build();
        this.currentTimeout = this.defaultTimeout;
        this.currentTimeoutUnit = this.defaultTimeoutUnit;
        return t;
    }

    public <T> void initRetrofit(Class<T> cls, String str) {
        this.mOkHttpClient = new OkHttpClient();
        Interceptor interceptor = new Interceptor() { // from class: cn.bluemobi.dylan.http.RetrofitManager.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder newBuilder = request.newBuilder();
                if (request.body() instanceof FormBody) {
                    FormBody.Builder builder = new FormBody.Builder();
                    FormBody formBody = (FormBody) request.body();
                    String str2 = "";
                    String str3 = "";
                    for (int i = 0; i < formBody.size(); i++) {
                        String encodedName = formBody.encodedName(i);
                        String encodedValue = formBody.encodedValue(i);
                        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equals(encodedName)) {
                            str2 = encodedValue;
                        } else if ("class".equals(encodedName)) {
                            str3 = encodedValue;
                        }
                        builder.addEncoded(encodedName, encodedValue);
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(RetrofitManager.this.secret)) {
                        builder.add("sign", MD5Utils.md5(str2 + str3 + RetrofitManager.this.secret));
                        newBuilder.method(request.method(), builder.build());
                    }
                }
                return chain.proceed(newBuilder.build());
            }
        };
        Interceptor interceptor2 = new Interceptor() { // from class: cn.bluemobi.dylan.http.RetrofitManager.2
            private StringBuilder mMessage = new StringBuilder();

            private void addRequestParement(Request request) {
                if (request.body() instanceof FormBody) {
                    FormBody formBody = (FormBody) request.body();
                    for (int i = 0; i < formBody.size(); i++) {
                        String encodedName = formBody.encodedName(i);
                        String value = formBody.value(i);
                        if (this.mMessage.indexOf("=") != -1) {
                            this.mMessage.append(ShellAdbUtils.f33810d);
                            this.mMessage.append("\u3000\u3000\u3000\u3000\u3000");
                        }
                        this.mMessage.append(encodedName);
                        this.mMessage.append("=");
                        this.mMessage.append(value);
                    }
                } else if (request.body() instanceof MultipartBody) {
                    for (MultipartBody.Part part : ((MultipartBody) request.body()).parts()) {
                        String partHeaders = RetrofitManager.this.getPartHeaders(part);
                        String str2 = null;
                        try {
                            str2 = URLDecoder.decode(RetrofitManager.this.getRequestBody(part).replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        if (this.mMessage.indexOf("=") != -1) {
                            this.mMessage.append(ShellAdbUtils.f33810d);
                            this.mMessage.append("\u3000\u3000\u3000\u3000\u3000");
                        }
                        this.mMessage.append(partHeaders);
                        this.mMessage.append("=");
                        this.mMessage.append(str2);
                    }
                }
            }

            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                this.mMessage.setLength(0);
                Request request = chain.request();
                this.mMessage.append("请求地址：");
                this.mMessage.append(request.url());
                this.mMessage.append(ShellAdbUtils.f33810d);
                Response proceed = chain.proceed(request.newBuilder().build());
                if ("POST".equals(request.method())) {
                    this.mMessage.append("请求参数：");
                    addRequestParement(request);
                    this.mMessage.append(ShellAdbUtils.f33810d);
                    this.mMessage.append("请求大小：");
                    if (request.body() != null) {
                        this.mMessage.append(RetrofitManager.convertFileSize(request.body().contentLength()));
                    }
                    C11792j.m20470c(this.mMessage.toString());
                    this.mMessage.setLength(0);
                    this.mMessage.append("响应地址：");
                    this.mMessage.append(proceed.request().url());
                    this.mMessage.append(ShellAdbUtils.f33810d);
                    this.mMessage.append("响应参数：");
                    addRequestParement(proceed.request());
                    this.mMessage.append(ShellAdbUtils.f33810d);
                }
                this.mMessage.append("响应耗时：");
                this.mMessage.append(RetrofitManager.formatDuring(proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis()));
                this.mMessage.append(ShellAdbUtils.f33810d);
                String string = proceed.body().string();
                Response build = proceed.newBuilder().body(ResponseBody.create(proceed.body().contentType(), string)).build();
                this.mMessage.append("响应大小：");
                if (request.body() != null) {
                    this.mMessage.append(RetrofitManager.convertFileSize(build.body().contentLength()));
                }
                this.mMessage.append(ShellAdbUtils.f33810d);
                this.mMessage.append("响应数据：");
                this.mMessage.append(ShellAdbUtils.f33810d);
                this.mMessage.append(JsonParse.formatJson(EncodeUtils.ascii2native(string)));
                C11792j.m20470c(this.mMessage.toString());
                return build;
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.okhttpBuilder = builder;
        builder.readTimeout(this.defaultTimeout, this.defaultTimeoutUnit).connectTimeout(this.defaultTimeout, this.defaultTimeoutUnit).writeTimeout(this.defaultTimeout, this.defaultTimeoutUnit);
        for (Interceptor interceptor3 : this.interceptorList) {
            this.okhttpBuilder.addInterceptor(interceptor3);
        }
        this.okhttpBuilder.addInterceptor(interceptor);
        if (this.debugMode) {
            this.okhttpBuilder.addInterceptor(interceptor2);
        }
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: cn.bluemobi.dylan.http.RetrofitManager.3
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            if (this.overlockCard) {
                this.okhttpBuilder.sslSocketFactory(socketFactory, x509TrustManager).hostnameVerifier(new HostnameVerifier() { // from class: cn.bluemobi.dylan.http.RetrofitManager.4
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str2, SSLSession sSLSession) {
                        return true;
                    }
                });
            } else {
                SSLSocketFactory sSLSocketFactory = this.factory;
                if (sSLSocketFactory != null) {
                    this.okhttpBuilder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
                }
            }
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        this.mOkHttpClient = this.okhttpBuilder.build();
        Retrofit.Builder builder2 = new Retrofit.Builder();
        this.retrofitBuilder = builder2;
        Retrofit build = builder2.baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(this.mOkHttpClient).build();
        this.retrofit = build;
        this.apiService = build.create(cls);
    }

    public void setDebugMode(boolean z) {
        this.debugMode = z;
    }

    public void setDefaultTimeout(long j, TimeUnit timeUnit) {
        this.defaultTimeout = j;
        this.defaultTimeoutUnit = timeUnit;
        if (this.retrofitBuilder != null) {
            this.okhttpBuilder.readTimeout(j, timeUnit).connectTimeout(this.defaultTimeout, this.defaultTimeoutUnit).writeTimeout(this.defaultTimeout, this.defaultTimeoutUnit);
            this.retrofit = this.retrofitBuilder.client(this.okhttpBuilder.build()).build();
        }
    }

    public void setOverlockCard(boolean z) {
        this.overlockCard = z;
    }

    public void setSSLSocketFactory(InputStream... inputStreamArr) {
        this.factory = setCertificates(inputStreamArr);
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setTimeout(long j, TimeUnit timeUnit) {
        this.currentTimeout = j;
        this.currentTimeoutUnit = timeUnit;
    }

    public <T> T getApiService() {
        return (T) this.apiService;
    }
}
