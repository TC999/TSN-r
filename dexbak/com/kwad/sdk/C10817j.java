package com.kwad.sdk;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.p440k.C10838a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10972j;
import com.kwad.sdk.utils.C11122q;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* renamed from: com.kwad.sdk.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10817j implements InterfaceC9432b {
    private final OkHttpClient akO;
    private final Request.Builder akP;
    private Request akQ;
    private Response akR;

    /* renamed from: com.kwad.sdk.j$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10818a implements C9492c.InterfaceC9494b {
        private volatile OkHttpClient akO;
        private OkHttpClient.Builder akS;

        public C10818a() {
        }

        @Override // com.kwad.framework.filedownloader.p353f.C9492c.InterfaceC9494b
        /* renamed from: be */
        public final InterfaceC9432b mo24736be(String str) {
            if (this.akO == null) {
                synchronized (C10818a.class) {
                    if (this.akO == null) {
                        OkHttpClient.Builder builder = this.akS;
                        this.akO = builder != null ? builder.build() : new OkHttpClient();
                        this.akS = null;
                    }
                }
            }
            return new C10817j(str, this.akO, (byte) 0);
        }

        public C10818a(boolean z) {
            if (z) {
                this.akS = C10817j.m24744zb();
            } else {
                this.akS = C10817j.m24743zc();
            }
        }
    }

    /* synthetic */ C10817j(String str, OkHttpClient okHttpClient, byte b) {
        this(str, okHttpClient);
    }

    /* renamed from: bX */
    private String m24751bX(String str) {
        String mo24750bd = mo24750bd("Content-Type");
        String extension = C11122q.getExtension(str);
        String str2 = ".apk";
        if (!TextUtils.isEmpty(mo24750bd) && TextUtils.isEmpty(extension)) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(mo24750bd);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            if (!TextUtils.isEmpty(extensionFromMimeType)) {
                str2 = "." + extensionFromMimeType;
            }
            sb.append(str2);
            return sb.toString();
        } else if (TextUtils.isEmpty(str)) {
            return System.currentTimeMillis() + ".apk";
        } else {
            return str;
        }
    }

    /* renamed from: yZ */
    private static OkHttpClient.Builder m24746yZ() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new C10838a()).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    /* renamed from: za */
    private static OkHttpClient.Builder m24745za() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new C10838a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    /* renamed from: zb */
    static /* synthetic */ OkHttpClient.Builder m24744zb() {
        return m24745za();
    }

    /* renamed from: zc */
    static /* synthetic */ OkHttpClient.Builder m24743zc() {
        return m24746yZ();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final void addHeader(String str, String str2) {
        this.akP.addHeader(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: bd */
    public final String mo24750bd(String str) {
        String str2;
        if ("Content-Disposition".equals(str)) {
            try {
            } catch (Exception unused) {
                str2 = "";
            }
            if (TextUtils.isEmpty(C9501f.m28506bv(this.akR.header(str)))) {
                List<String> pathSegments = this.akR.request().url().pathSegments();
                str2 = pathSegments.get(pathSegments.size() - 1);
                return "attachment; filename=\"" + m24751bX(str2) + "\"";
            }
            return this.akR.header(str);
        }
        Response response = this.akR;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final void execute() {
        if (this.akQ == null) {
            this.akQ = this.akP.build();
        }
        this.akR = this.akO.newCall(this.akQ).execute();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final InputStream getInputStream() {
        Response response = this.akR;
        if (response != null) {
            return ((InterfaceC10972j) ServiceProvider.get(InterfaceC10972j.class)).wrapInputStream(response.body().byteStream());
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    public final int getResponseCode() {
        Response response = this.akR;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: vc */
    public final Map<String, List<String>> mo24749vc() {
        if (this.akQ == null) {
            this.akQ = this.akP.build();
        }
        return this.akQ.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: vd */
    public final Map<String, List<String>> mo24748vd() {
        Response response = this.akR;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.p348a.InterfaceC9432b
    /* renamed from: ve */
    public final void mo24747ve() {
        this.akQ = null;
        Response response = this.akR;
        if (response != null && response.body() != null) {
            C10738b.closeQuietly(this.akR.body());
        }
        this.akR = null;
    }

    private C10817j(Request.Builder builder, OkHttpClient okHttpClient) {
        this.akP = builder;
        this.akO = okHttpClient;
    }

    private C10817j(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }
}
