package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.core.d.a;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.File;
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
import org.json.JSONObject;
import xyz.adscope.common.network.Headers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j implements com.kwad.framework.filedownloader.a.b {
    private final OkHttpClient akO;
    private final Request.Builder akP;
    private Request akQ;
    private Response akR;

    /* renamed from: com.kwad.sdk.j$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 implements com.kwad.sdk.service.a.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.service.a.e
        public final void G(String str, String str2) {
            com.kwad.components.core.d.a.j(str, str2);
        }

        @Override // com.kwad.sdk.service.a.e
        public final void a(final com.kwad.sdk.service.a.c cVar) {
            com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.j.1.1
                @Override // com.kwad.components.core.d.a.b
                public final String getKey() {
                    com.kwad.sdk.service.a.c cVar2 = cVar;
                    if (cVar2 != null) {
                        return cVar2.getKey();
                    }
                    return null;
                }

                @Override // com.kwad.components.core.d.a.b
                public final JSONObject getValue() {
                    com.kwad.sdk.service.a.c cVar2 = cVar;
                    if (cVar2 != null) {
                        return cVar2.getValue();
                    }
                    return null;
                }
            });
        }

        @Override // com.kwad.sdk.service.a.e
        public final void gatherException(Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }

        @Override // com.kwad.sdk.service.a.e
        public final void a(final com.kwad.sdk.service.a.g gVar) {
            com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.j.1.2
                @Override // com.kwad.components.core.d.a.c
                public final void onCrashOccur(int i4, String str) {
                    com.kwad.sdk.service.a.g gVar2 = gVar;
                    if (gVar2 != null) {
                        gVar2.l(i4, str);
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.j$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass2 implements com.kwad.sdk.service.a.d {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.service.a.d
        public final void a(boolean z3, String str, String str2, String str3) {
            com.kwad.sdk.core.diskcache.b.a.DM().dB(str);
        }

        public final File bZ(String str) {
            return com.kwad.sdk.core.diskcache.b.a.DM().bZ(str);
        }
    }

    /* renamed from: com.kwad.sdk.j$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass3 implements com.kwad.sdk.service.a.j {
        AnonymousClass3() {
        }

        public final boolean rd() {
            com.kwad.components.core.p.b.rc();
            return com.kwad.components.core.p.b.rd();
        }

        public final int re() {
            com.kwad.components.core.p.b.rc();
            return com.kwad.components.core.p.b.re();
        }

        public final int rf() {
            return com.kwad.components.core.p.b.rc().rf();
        }

        @Override // com.kwad.sdk.service.a.j
        public final InputStream wrapInputStream(InputStream inputStream) {
            com.kwad.components.core.p.b.rc();
            return com.kwad.components.core.p.b.wrapInputStream(inputStream);
        }
    }

    /* renamed from: com.kwad.sdk.j$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass4 implements com.kwad.sdk.core.network.k {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.network.k
        public final void a(com.kwad.sdk.core.network.j jVar) {
            com.kwad.sdk.commercial.b.b(jVar);
        }

        public final com.kwad.sdk.core.b yQ() {
            return com.kwad.components.core.request.model.b.rb();
        }

        @Override // com.kwad.sdk.core.network.k
        public final void a(com.kwad.sdk.core.network.i iVar) {
            com.kwad.sdk.commercial.b.b(iVar);
        }
    }

    /* renamed from: com.kwad.sdk.j$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass5 implements com.kwad.sdk.service.a.b {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.service.a.b
        public final void H(String str, String str2) {
            com.kwad.sdk.core.e.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
        }

        public final void aF(AdTemplate adTemplate) {
            com.kwad.components.core.o.a.qI().f(adTemplate, 21007);
        }

        @Override // com.kwad.sdk.service.a.b
        public final void e(@NonNull JSONObject jSONObject, int i4) {
            com.kwad.components.core.o.a.qI().e(jSONObject, i4);
        }

        public final void yR() {
            com.kwad.components.core.o.a.qI().ap(ServiceProvider.getContext());
        }
    }

    /* renamed from: com.kwad.sdk.j$6  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass6 implements s {
        AnonymousClass6() {
        }

        public final boolean aa(long j4) {
            o oVar = com.kwad.sdk.core.config.c.asn;
            return o.aa(j4);
        }

        public final int ue() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.ue();
            }
            return 0;
        }

        public final int yS() {
            return com.kwad.sdk.core.config.d.yS();
        }
    }

    /* renamed from: com.kwad.sdk.j$7  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass7 implements com.kwad.sdk.core.video.a.f {
        AnonymousClass7() {
        }

        public final boolean uf() {
            return ((com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class)).uf();
        }

        public final boolean yT() {
            return com.kwad.sdk.core.config.d.yT();
        }

        public final boolean yU() {
            return com.kwad.sdk.core.config.d.yU();
        }
    }

    /* renamed from: com.kwad.sdk.j$8  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass8 implements com.kwad.sdk.utils.b.b {
        AnonymousClass8() {
        }

        @Override // com.kwad.sdk.utils.b.b
        public final void a(com.kwad.sdk.utils.b.a aVar) {
            if (aVar == null) {
                return;
            }
            com.kwad.sdk.commercial.b.b(aVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements c.b {
        private volatile OkHttpClient akO;
        private OkHttpClient.Builder akS;

        public a() {
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b be(String str) {
            if (this.akO == null) {
                synchronized (a.class) {
                    if (this.akO == null) {
                        OkHttpClient.Builder builder = this.akS;
                        this.akO = builder != null ? builder.build() : new OkHttpClient();
                        this.akS = null;
                    }
                }
            }
            return new j(str, this.akO, (byte) 0);
        }

        public a(boolean z3) {
            if (z3) {
                this.akS = j.zb();
            } else {
                this.akS = j.zc();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class b implements com.kwad.sdk.service.a.f {
        private b() {
        }

        @Override // com.kwad.sdk.service.a.f
        public final void a(String str, Map<String, String> map, String str2) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }

        public final boolean aG(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            return aVar != null && aVar.ug();
        }

        public final String am(String str) {
            return com.kwad.sdk.core.a.d.am(str);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return l.zJ().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return l.zJ().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            l.zJ();
            return l.getSDKVersion();
        }

        public final boolean pj() {
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                return aVar.pj();
            }
            return false;
        }

        public final com.kwad.sdk.core.response.b.g uh() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.uh();
            }
            return null;
        }

        public final boolean yV() {
            return l.zJ().yV();
        }

        public final boolean yW() {
            return l.zJ().yW();
        }

        public final boolean yX() {
            return l.zJ().yX();
        }

        public final boolean yY() {
            return l.zJ().yY();
        }

        public final String yZ() {
            return com.kwad.sdk.kgeo.a.yZ();
        }

        public final com.kwad.sdk.core.b za() {
            return com.kwad.sdk.kgeo.a.JD();
        }

        public final List<AdTemplate> zb() {
            return com.kwad.sdk.core.download.b.DO().zb();
        }

        public final String zc() {
            return h.yF();
        }

        public final JSONObject zd() {
            return com.kwad.components.core.o.a.qI().m("", "").toJson();
        }

        public final JSONObject ze() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getBodyParams();
        }

        public final Map<String, String> zf() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getHeader();
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class c implements com.kwad.sdk.service.a.h {
        private c() {
        }

        public final int aD(Context context) {
            return com.kwad.sdk.core.config.item.c.bg(context);
        }

        public final boolean ab(long j4) {
            return com.kwad.sdk.core.config.d.ab(j4);
        }

        public final boolean ca(String str) {
            return com.kwad.sdk.core.config.a.ca(str);
        }

        public final int cb(String str) {
            return com.kwad.sdk.core.config.d.cb(str);
        }

        public final <T> T getAppConfigData(T t3, com.kwad.sdk.f.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.d.CK().getAppConfigData((Object) null, bVar);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        public final boolean xn() {
            return com.kwad.sdk.core.config.d.xn();
        }

        public final int zA() {
            return com.kwad.sdk.core.config.d.zA();
        }

        public final boolean zB() {
            return com.kwad.sdk.core.config.d.zB();
        }

        public final String zC() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auh);
        }

        public final boolean zD() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aul);
        }

        public final String zE() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aur);
        }

        public final boolean zg() {
            return com.kwad.sdk.core.config.d.zg();
        }

        public final boolean zh() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.asA);
        }

        public final boolean zi() {
            return com.kwad.sdk.core.config.d.zi();
        }

        public final boolean zj() {
            return com.kwad.sdk.core.config.d.zj();
        }

        public final String zk() {
            return com.kwad.sdk.core.config.d.zk();
        }

        public final String zl() {
            return com.kwad.sdk.core.config.d.zl();
        }

        public final List<String> zm() {
            return com.kwad.sdk.core.config.d.zm();
        }

        public final boolean zn() {
            return com.kwad.sdk.core.config.d.zn();
        }

        public final boolean zo() {
            return com.kwad.sdk.core.config.d.zo();
        }

        public final boolean zp() {
            return com.kwad.sdk.core.config.d.CP();
        }

        public final boolean zq() {
            return com.kwad.sdk.core.config.d.zq();
        }

        public final boolean zr() {
            return com.kwad.sdk.core.config.d.zr();
        }

        public final int zs() {
            return com.kwad.sdk.core.config.d.zs();
        }

        public final int zt() {
            return com.kwad.sdk.core.config.d.zt();
        }

        public final double zu() {
            return com.kwad.sdk.core.config.d.zu();
        }

        public final boolean zv() {
            return com.kwad.sdk.core.config.d.zv();
        }

        public final boolean zw() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atY);
        }

        public final boolean zx() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atZ);
        }

        public final boolean zy() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aua);
        }

        public final boolean zz() {
            return com.kwad.sdk.core.config.d.zz();
        }

        /* synthetic */ c(byte b4) {
            this();
        }
    }

    /* synthetic */ j(String str, OkHttpClient okHttpClient, byte b4) {
        this(str, okHttpClient);
    }

    private String bX(String str) {
        String bd = bd("Content-Type");
        String extension = q.getExtension(str);
        String str2 = ".apk";
        if (!TextUtils.isEmpty(bd) && TextUtils.isEmpty(extension)) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(bd);
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

    private static OkHttpClient.Builder yZ() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).addInterceptor(new com.kwad.sdk.k.a()).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    private static OkHttpClient.Builder za() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).addInterceptor(new com.kwad.sdk.k.a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    static /* synthetic */ OkHttpClient.Builder zb() {
        return za();
    }

    static /* synthetic */ OkHttpClient.Builder zc() {
        return yZ();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.akP.addHeader(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bd(String str) {
        String str2;
        if (Headers.KEY_CONTENT_DISPOSITION.equals(str)) {
            try {
            } catch (Exception unused) {
                str2 = "";
            }
            if (TextUtils.isEmpty(com.kwad.framework.filedownloader.f.f.bv(this.akR.header(str)))) {
                List<String> pathSegments = this.akR.request().url().pathSegments();
                str2 = pathSegments.get(pathSegments.size() - 1);
                return "attachment; filename=\"" + bX(str2) + "\"";
            }
            return this.akR.header(str);
        }
        Response response = this.akR;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        if (this.akQ == null) {
            this.akQ = this.akP.build();
        }
        this.akR = this.akO.newCall(this.akQ).execute();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        Response response = this.akR;
        if (response != null) {
            return ((com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class)).wrapInputStream(response.body().byteStream());
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        Response response = this.akR;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vc() {
        if (this.akQ == null) {
            this.akQ = this.akP.build();
        }
        return this.akQ.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vd() {
        Response response = this.akR;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void ve() {
        this.akQ = null;
        Response response = this.akR;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.akR.body());
        }
        this.akR = null;
    }

    private j(Request.Builder builder, OkHttpClient okHttpClient) {
        this.akP = builder;
        this.akO = okHttpClient;
    }

    private j(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }
}
