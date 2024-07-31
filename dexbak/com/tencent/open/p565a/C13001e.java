package com.tencent.open.p565a;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13001e implements InterfaceC12997a {

    /* renamed from: a */
    private OkHttpClient f37275a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.a.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13002a implements Interceptor {

        /* renamed from: a */
        private final String f37276a;

        public C13002a(String str) {
            this.f37276a = str;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.f37276a).build());
        }
    }

    public C13001e(String str) throws NoClassDefFoundError {
        m15221a(str);
    }

    /* renamed from: a */
    private void m15221a(String str) {
        String userAgent = Version.userAgent();
        if (userAgent != null && userAgent.startsWith("okhttp/3")) {
            C13002a c13002a = new C13002a(str);
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder addInterceptor = connectionSpecs.connectTimeout(15000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).cache(null).addInterceptor(c13002a);
            m15217a(addInterceptor);
            this.f37275a = addInterceptor.build();
            return;
        }
        throw new NoClassDefFoundError();
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public void mo15222a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return;
        }
        if (this.f37275a.connectTimeoutMillis() == j && this.f37275a.readTimeoutMillis() == j2) {
            return;
        }
        SLog.m15127i("OkHttpServiceImpl", "setTimeout changed.");
        OkHttpClient.Builder newBuilder = this.f37275a.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f37275a = newBuilder.connectTimeout(j, timeUnit).readTimeout(j2, timeUnit).writeTimeout(j2, timeUnit).build();
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public InterfaceC13004g mo15220a(String str, String str2) throws IOException {
        SLog.m15127i("OkHttpServiceImpl", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new C13000d(this.f37275a.newCall(new Request.Builder().url(str).get().build()).execute(), str2.length());
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public InterfaceC13004g mo15219a(String str, Map<String, String> map) throws IOException {
        SLog.m15127i("OkHttpServiceImpl", "post data");
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    builder.add(str2, str3);
                }
            }
        }
        FormBody build = builder.build();
        return new C13000d(this.f37275a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public InterfaceC13004g mo15218a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.m15127i("OkHttpServiceImpl", "post data, has byte data");
            MultipartBody.Builder builder = new MultipartBody.Builder();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        builder.addFormDataPart(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    builder.addFormDataPart(str4, str4, RequestBody.create(MediaType.get("content/unknown"), bArr));
                    SLog.m15121w("OkHttpServiceImpl", "post byte data.");
                }
            }
            MultipartBody build = builder.build();
            return new C13000d(this.f37275a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
        }
        return mo15219a(str, map);
    }

    /* renamed from: a */
    private void m15217a(OkHttpClient.Builder builder) {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                C13005h c13005h = new C13005h();
                TrustManager m15203a = c13005h.m15203a();
                if (m15203a == null) {
                    return;
                }
                builder.sslSocketFactory(c13005h, (X509TrustManager) m15203a);
                SLog.m15127i("OkHttpServiceImpl", "enableTls2: enabled.");
            } catch (KeyManagementException e) {
                SLog.m15128e("OkHttpServiceImpl", "enableTls2: failed.", e);
            } catch (KeyStoreException e2) {
                SLog.m15128e("OkHttpServiceImpl", "enableTls2: failed.", e2);
            } catch (NoSuchAlgorithmException e3) {
                SLog.m15128e("OkHttpServiceImpl", "enableTls2: failed.", e3);
            }
        }
    }
}
