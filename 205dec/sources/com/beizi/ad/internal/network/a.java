package com.beizi.ad.internal.network;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.ad.R;
import com.beizi.ad.c.a;
import com.beizi.ad.c.b;
import com.beizi.ad.c.d;
import com.beizi.ad.c.e;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.f;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.utilities.DeviceInfo;
import com.beizi.ad.internal.utilities.DeviceInfoUtil;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.HashingFunctions;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.UserEnvInfo;
import com.beizi.ad.internal.utilities.UserEnvInfoUtil;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.p;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdRequestImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends AsyncTask<Void, Integer, ServerResponse> {

    /* renamed from: a  reason: collision with root package name */
    private SoftReference<f> f13984a;

    /* renamed from: d  reason: collision with root package name */
    private final Set<String> f13985d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f13986e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<String> f13987f;

    /* renamed from: g  reason: collision with root package name */
    private Date f13988g;

    /* renamed from: h  reason: collision with root package name */
    private String f13989h;

    /* renamed from: i  reason: collision with root package name */
    private int f13990i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13991j;

    /* renamed from: k  reason: collision with root package name */
    private String f13992k;

    /* renamed from: l  reason: collision with root package name */
    private int f13993l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13994m;

    /* renamed from: c  reason: collision with root package name */
    private static final ServerResponse f13983c = new ServerResponse(true);

    /* renamed from: b  reason: collision with root package name */
    public static final String f13982b = HashingFunctions.md5("emulator");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdRequestImpl.java */
    /* renamed from: com.beizi.ad.internal.network.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0126a {

        /* renamed from: d  reason: collision with root package name */
        private Date f13998d;

        /* renamed from: e  reason: collision with root package name */
        private String f13999e;

        /* renamed from: h  reason: collision with root package name */
        private String f14002h;

        /* renamed from: j  reason: collision with root package name */
        private boolean f14004j;

        /* renamed from: a  reason: collision with root package name */
        private final HashSet<String> f13995a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f13996b = new Bundle();

        /* renamed from: c  reason: collision with root package name */
        private final HashSet<String> f13997c = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private int f14000f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f14001g = false;

        /* renamed from: i  reason: collision with root package name */
        private int f14003i = -1;

        public void a(String str) {
            this.f13995a.add(str);
        }

        public void b(String str) {
            this.f13997c.add(str);
        }

        public void c(String str) {
            this.f13999e = str;
        }

        public void d(String str) {
            this.f14002h = str;
        }

        public com.beizi.ad.b.a e() {
            return new com.beizi.ad.b.a(this.f13998d, this.f14000f, this.f13995a, false);
        }

        public void a(Class<? extends com.beizi.ad.b.b> cls, Bundle bundle) {
            this.f13996b.putBundle(cls.getName(), bundle);
        }

        public void b(boolean z3) {
            this.f14004j = z3;
        }

        public int c() {
            return this.f14000f;
        }

        public Set<String> d() {
            return this.f13995a;
        }

        public void a(Date date) {
            this.f13998d = date;
        }

        public String b() {
            return this.f13999e;
        }

        public void a(int i4) {
            this.f14000f = i4;
        }

        public void a(boolean z3) {
            this.f14003i = z3 ? 1 : 0;
        }

        public Date a() {
            return this.f13998d;
        }

        public Bundle a(Class<? extends com.beizi.ad.b.b> cls) {
            return this.f13996b.getBundle(cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.f13985d = new HashSet();
        this.f13986e = null;
        this.f13987f = new HashSet();
    }

    private boolean b(int i4) {
        if (i4 != 200) {
            HaoboLog.i(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.http_bad_status, i4));
            return false;
        }
        return true;
    }

    public void a(f fVar) {
        this.f13984a = new SoftReference<>(fVar);
        e c4 = fVar.c();
        if (c4 != null && c4.b() != null) {
            DeviceInfoUtil.retrieveDeviceInfo(StubApp.getOrigApplicationContext(c4.b().getApplicationContext()));
            UserEnvInfoUtil.retrieveUserEnvInfo(StubApp.getOrigApplicationContext(c4.b().getApplicationContext()));
            if (c.a(StubApp.getOrigApplicationContext(c4.b().getApplicationContext())).b(c4.b())) {
                return;
            }
            a(2);
            cancel(true);
            return;
        }
        a(0);
        cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @TargetApi(11)
    /* renamed from: b */
    public void onCancelled(ServerResponse serverResponse) {
        super.onCancelled(serverResponse);
        HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.cancel_request));
    }

    public a(C0126a c0126a) {
        this.f13988g = c0126a.f13998d;
        this.f13989h = c0126a.f13999e;
        this.f13990i = c0126a.f14000f;
        this.f13985d = Collections.unmodifiableSet(c0126a.f13995a);
        this.f13986e = c0126a.f13996b;
        this.f13987f = Collections.unmodifiableSet(c0126a.f13997c);
        this.f13991j = c0126a.f14001g;
        this.f13992k = c0126a.f14002h;
        this.f13993l = c0126a.f14003i;
        this.f13994m = c0126a.f14004j;
    }

    private void a(int i4) {
        f fVar = this.f13984a.get();
        if (fVar != null) {
            fVar.a(i4);
        }
        HaoboLog.clearLastResponse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ServerResponse doInBackground(Void... voidArr) {
        e c4;
        f fVar = this.f13984a.get();
        if (fVar == null || (c4 = fVar.c()) == null) {
            return null;
        }
        try {
            boolean z3 = c4.i() == k.PREFETCH;
            h a4 = h.a();
            DeviceInfo deviceInfo = DeviceInfo.getInstance();
            d.a a5 = new d.a.C0121a().a(deviceInfo.sdkUID).j(DeviceInfo.density).l(m.a(h.a().f13808j)).m(m.b(h.a().f13808j)).n(m.c(h.a().f13808j)).o(deviceInfo.bootMark).p(deviceInfo.updateMark).b("").c(deviceInfo.os).a(e.EnumC0122e.PLATFORM_ANDROID).a(deviceInfo.devType).d(deviceInfo.brand).e(deviceInfo.model).f(deviceInfo.manufacturer).g(deviceInfo.resolution).h(deviceInfo.screenSize).i(deviceInfo.language).k(deviceInfo.root).q(deviceInfo.agVercode).a(deviceInfo.wxInstalled).r(DeviceInfo.physicalMemoryByte).s(DeviceInfo.harddiskSizeByte).t(deviceInfo.hmsCoreVersion).u(deviceInfo.getRomVersion()).a();
            UserEnvInfo userEnvInfo = UserEnvInfo.getInstance();
            a.b.C0118a c5 = new a.b.C0118a().a("3.5.0.11").a(e.i.SRC_APP).c(UserEnvInfoUtil.getVersionName(h.a().f13808j)).a(z3 ? e.g.REQ_WIFI_PRELOAD : e.g.REQ_AD).a(p.c()).b(a4.d()).a(a5).a(new d.c.a().a(userEnvInfo.f14022net).a(userEnvInfo.isp).a()).c(p.d(c4.b())).d(p.c(c4.b())).b(p.a(c4.b())).c(p.b(c4.b()));
            if (z3) {
                for (String str : h.a().l()) {
                    if (!StringUtil.isEmpty(str)) {
                        c5.a(new a.C0116a.C0117a().a(str).c(c4.a()).a());
                    }
                }
            } else {
                c5.a(new a.C0116a.C0117a().a(c4.c()).c(c4.a()).b(c4.k()).a());
            }
            a.b a6 = c5.a();
            byte[] bytes = com.beizi.ad.lance.a.a.a(com.beizi.ad.lance.a.k.a(), a6.toString()).getBytes();
            l.d("lance", "sdkRequest:" + a6.toString());
            String m4 = h.a().m();
            l.d("lance", "getRequestBaseUrl:" + m4);
            HaoboLog.setLastRequest(a6.toString());
            HaoboLog.i(HaoboLog.httpReqLogTag, HaoboLog.getString(R.string.fetch_url, HaoboLog.getLastRequest()));
            HttpURLConnection a7 = a(new URL(m4));
            a(a7, bytes);
            a7.connect();
            if (!b(a7.getResponseCode())) {
                return f13983c;
            }
            if (a7.getContentLength() == 0) {
                HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_blank));
            }
            InputStream inputStream = a7.getInputStream();
            b.i a8 = b.i.a(inputStream);
            inputStream.close();
            return new ServerResponse(a8, a7.getHeaderFields(), c4.i());
        } catch (IOException unused) {
            HaoboLog.e(HaoboLog.httpReqLogTag, HaoboLog.getString(R.string.http_io));
            return f13983c;
        } catch (IllegalArgumentException unused2) {
            HaoboLog.e(HaoboLog.httpReqLogTag, HaoboLog.getString(R.string.http_unknown));
            return f13983c;
        } catch (SecurityException unused3) {
            HaoboLog.e(HaoboLog.httpReqLogTag, HaoboLog.getString(R.string.permissions_internet));
            return f13983c;
        } catch (MalformedURLException unused4) {
            HaoboLog.e(HaoboLog.httpReqLogTag, HaoboLog.getString(R.string.http_url_malformed));
            return f13983c;
        } catch (Exception e4) {
            e4.printStackTrace();
            HaoboLog.e(HaoboLog.httpReqLogTag, Log.getStackTraceString(e4));
            HaoboLog.e(HaoboLog.httpReqLogTag, HaoboLog.getString(R.string.unknown_exception));
            return f13983c;
        }
    }

    private HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", h.a().f13806e);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        String cookie = WebviewUtil.getCookie();
        if (!TextUtils.isEmpty(cookie)) {
            httpURLConnection.setRequestProperty("Cookie", cookie);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ServerResponse serverResponse) {
        if (serverResponse == null) {
            HaoboLog.v(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.no_response));
            a(2);
        } else if (serverResponse.a()) {
            a(2);
        } else {
            f fVar = this.f13984a.get();
            if (fVar != null) {
                fVar.a(serverResponse);
            }
        }
    }
}
