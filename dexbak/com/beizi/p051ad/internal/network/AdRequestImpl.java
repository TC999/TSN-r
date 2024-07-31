package com.beizi.p051ad.internal.network;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.C2594an;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.AdParameters;
import com.beizi.p051ad.internal.AdRequestDelegate;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.utilities.DeviceInfo;
import com.beizi.p051ad.internal.utilities.DeviceInfoUtil;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.HashingFunctions;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.UserEnvInfo;
import com.beizi.p051ad.internal.utilities.UserEnvInfoUtil;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.lance.p062a.AesUtil;
import com.beizi.p051ad.lance.p062a.KeyGenerator;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.OaidAndGaidUtils;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.beizi.p051ad.p055b.MediationAdRequest;
import com.beizi.p051ad.p055b.MediationAdapter;
import com.beizi.p051ad.p056c.AdRequest;
import com.beizi.p051ad.p056c.AdResponseOuterClass;
import com.beizi.p051ad.p056c.CommonInfo;
import com.beizi.p051ad.p056c.EnumType;
import com.stub.StubApp;
import io.netty.handler.codec.http.HttpHeaders;
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

/* renamed from: com.beizi.ad.internal.network.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdRequestImpl extends AsyncTask<Void, Integer, ServerResponse> {

    /* renamed from: a */
    private SoftReference<AdRequestDelegate> f10375a;

    /* renamed from: d */
    private final Set<String> f10376d;

    /* renamed from: e */
    private final Bundle f10377e;

    /* renamed from: f */
    private final Set<String> f10378f;

    /* renamed from: g */
    private Date f10379g;

    /* renamed from: h */
    private String f10380h;

    /* renamed from: i */
    private int f10381i;

    /* renamed from: j */
    private boolean f10382j;

    /* renamed from: k */
    private String f10383k;

    /* renamed from: l */
    private int f10384l;

    /* renamed from: m */
    private boolean f10385m;

    /* renamed from: c */
    private static final ServerResponse f10374c = new ServerResponse(true);

    /* renamed from: b */
    public static final String f10373b = HashingFunctions.md5("emulator");

    /* compiled from: AdRequestImpl.java */
    /* renamed from: com.beizi.ad.internal.network.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C2918a {

        /* renamed from: d */
        private Date f10389d;

        /* renamed from: e */
        private String f10390e;

        /* renamed from: h */
        private String f10393h;

        /* renamed from: j */
        private boolean f10395j;

        /* renamed from: a */
        private final HashSet<String> f10386a = new HashSet<>();

        /* renamed from: b */
        private final Bundle f10387b = new Bundle();

        /* renamed from: c */
        private final HashSet<String> f10388c = new HashSet<>();

        /* renamed from: f */
        private int f10391f = -1;

        /* renamed from: g */
        private boolean f10392g = false;

        /* renamed from: i */
        private int f10394i = -1;

        /* renamed from: a */
        public void m49333a(String str) {
            this.f10386a.add(str);
        }

        /* renamed from: b */
        public void m49328b(String str) {
            this.f10388c.add(str);
        }

        /* renamed from: c */
        public void m49324c(String str) {
            this.f10390e = str;
        }

        /* renamed from: d */
        public void m49321d(String str) {
            this.f10393h = str;
        }

        /* renamed from: e */
        public MediationAdRequest m49320e() {
            return new MediationAdRequest(this.f10389d, this.f10391f, this.f10386a, false);
        }

        /* renamed from: a */
        public void m49334a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f10387b.putBundle(cls.getName(), bundle);
        }

        /* renamed from: b */
        public void m49327b(boolean z) {
            this.f10395j = z;
        }

        /* renamed from: c */
        public int m49326c() {
            return this.f10391f;
        }

        /* renamed from: d */
        public Set<String> m49323d() {
            return this.f10386a;
        }

        /* renamed from: a */
        public void m49332a(Date date) {
            this.f10389d = date;
        }

        /* renamed from: b */
        public String m49330b() {
            return this.f10390e;
        }

        /* renamed from: a */
        public void m49337a(int i) {
            this.f10391f = i;
        }

        /* renamed from: a */
        public void m49331a(boolean z) {
            this.f10394i = z ? 1 : 0;
        }

        /* renamed from: a */
        public Date m49338a() {
            return this.f10389d;
        }

        /* renamed from: a */
        public Bundle m49335a(Class<? extends MediationAdapter> cls) {
            return this.f10387b.getBundle(cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdRequestImpl() {
        this.f10376d = new HashSet();
        this.f10377e = null;
        this.f10378f = new HashSet();
    }

    /* renamed from: b */
    private boolean m49340b(int i) {
        if (i != 200) {
            HaoboLog.m49288i(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.http_bad_status, i));
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m49345a(AdRequestDelegate adRequestDelegate) {
        this.f10375a = new SoftReference<>(adRequestDelegate);
        AdParameters mo49370c = adRequestDelegate.mo49370c();
        if (mo49370c != null && mo49370c.m49514b() != null) {
            DeviceInfoUtil.retrieveDeviceInfo(StubApp.getOrigApplicationContext(mo49370c.m49514b().getApplicationContext()));
            UserEnvInfoUtil.retrieveUserEnvInfo(StubApp.getOrigApplicationContext(mo49370c.m49514b().getApplicationContext()));
            if (SharedNetworkManager.m49304a(StubApp.getOrigApplicationContext(mo49370c.m49514b().getApplicationContext())).m49301b(mo49370c.m49514b())) {
                return;
            }
            m49346a(2);
            cancel(true);
            return;
        }
        m49346a(0);
        cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @TargetApi(11)
    /* renamed from: b */
    public void onCancelled(ServerResponse serverResponse) {
        super.onCancelled(serverResponse);
        HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.cancel_request));
    }

    public AdRequestImpl(C2918a c2918a) {
        this.f10379g = c2918a.f10389d;
        this.f10380h = c2918a.f10390e;
        this.f10381i = c2918a.f10391f;
        this.f10376d = Collections.unmodifiableSet(c2918a.f10386a);
        this.f10377e = c2918a.f10387b;
        this.f10378f = Collections.unmodifiableSet(c2918a.f10388c);
        this.f10382j = c2918a.f10392g;
        this.f10383k = c2918a.f10393h;
        this.f10384l = c2918a.f10394i;
        this.f10385m = c2918a.f10395j;
    }

    /* renamed from: a */
    private void m49346a(int i) {
        AdRequestDelegate adRequestDelegate = this.f10375a.get();
        if (adRequestDelegate != null) {
            adRequestDelegate.mo49373a(i);
        }
        HaoboLog.clearLastResponse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ServerResponse doInBackground(Void... voidArr) {
        AdParameters mo49370c;
        AdRequestDelegate adRequestDelegate = this.f10375a.get();
        if (adRequestDelegate == null || (mo49370c = adRequestDelegate.mo49370c()) == null) {
            return null;
        }
        try {
            boolean z = mo49370c.m49501i() == EnumC2888k.PREFETCH;
            BeiZiImpl m49492a = BeiZiImpl.m49492a();
            DeviceInfo deviceInfo = DeviceInfo.getInstance();
            CommonInfo.C2807a m49821a = new CommonInfo.C2807a.C2808a().m49818a(deviceInfo.sdkUID).m49808j(DeviceInfo.density).m49806l(OaidAndGaidUtils.m49042a(BeiZiImpl.m49492a().f10139i)).m49805m(OaidAndGaidUtils.m49041b(BeiZiImpl.m49492a().f10139i)).m49804n(deviceInfo.bootMark).m49803o(deviceInfo.updateMark).m49816b("").m49815c(deviceInfo.f10413os).m49819a(EnumType.EnumC2816e.PLATFORM_ANDROID).m49820a(deviceInfo.devType).m49814d(deviceInfo.brand).m49813e(deviceInfo.model).m49812f(deviceInfo.manufacturer).m49811g(deviceInfo.resolution).m49810h(deviceInfo.screenSize).m49809i(deviceInfo.language).m49807k(deviceInfo.root).m49802p(deviceInfo.agVercode).m49817a(deviceInfo.wxInstalled).m49801q(DeviceInfo.physicalMemoryByte).m49800r(DeviceInfo.harddiskSizeByte).m49799s(deviceInfo.hmsCoreVersion).m49798t(deviceInfo.getRomVersion()).m49821a();
            UserEnvInfo userEnvInfo = UserEnvInfo.getInstance();
            AdRequest.C2790b.C2791a m50052c = new AdRequest.C2790b.C2791a().m50055a("3.5.0.5").m50056a(EnumType.EnumC2820i.SRC_APP).m50051c(UserEnvInfoUtil.getVersionName(BeiZiImpl.m49492a().f10139i)).m50057a(z ? EnumType.EnumC2818g.REQ_WIFI_PRELOAD : EnumType.EnumC2818g.REQ_AD).m50061a(SystemUtil.m49031c()).m50053b(m49492a.m49475d()).m50059a(m49821a).m50058a(new CommonInfo.C2810c.C2811a().m49789a(userEnvInfo.f47179net).m49790a(userEnvInfo.isp).m49791a()).m50051c(SystemUtil.m49029d(mo49370c.m49514b())).m50050d(SystemUtil.m49030c(mo49370c.m49514b())).m50054b(SystemUtil.m49037a(mo49370c.m49514b())).m50052c(SystemUtil.m49033b(mo49370c.m49514b()));
            if (z) {
                for (String str : BeiZiImpl.m49492a().m49466l()) {
                    if (!StringUtil.isEmpty(str)) {
                        m50052c.m50060a(new AdRequest.C2788a.C2789a().m50078a(str).m50076c(mo49370c.m49519a()).m50079a());
                    }
                }
            } else {
                m50052c.m50060a(new AdRequest.C2788a.C2789a().m50078a(mo49370c.m49511c()).m50076c(mo49370c.m49519a()).m50077b(mo49370c.m49499k()).m50079a());
            }
            AdRequest.C2790b m50062a = m50052c.m50062a();
            byte[] bytes = AesUtil.m49091a(KeyGenerator.m49047a(), m50062a.toString()).getBytes();
            LogUtil.m49043d("lance", "sdkRequest:" + m50062a.toString());
            String m49465m = BeiZiImpl.m49492a().m49465m();
            LogUtil.m49043d("lance", "getRequestBaseUrl:" + m49465m);
            HaoboLog.setLastRequest(m50062a.toString());
            HaoboLog.m49288i(HaoboLog.httpReqLogTag, HaoboLog.getString(C2750R.C2755string.fetch_url, HaoboLog.getLastRequest()));
            HttpURLConnection m49342a = m49342a(new URL(m49465m));
            m49343a(m49342a, bytes);
            m49342a.connect();
            if (!m49340b(m49342a.getResponseCode())) {
                return f10374c;
            }
            if (m49342a.getContentLength() == 0) {
                HaoboLog.m49290e(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.response_blank));
            }
            InputStream inputStream = m49342a.getInputStream();
            AdResponseOuterClass.C2804i m49915a = AdResponseOuterClass.C2804i.m49915a(inputStream);
            inputStream.close();
            return new ServerResponse(m49915a, m49342a.getHeaderFields(), mo49370c.m49501i());
        } catch (IOException unused) {
            HaoboLog.m49290e(HaoboLog.httpReqLogTag, HaoboLog.getString(C2750R.C2755string.http_io));
            return f10374c;
        } catch (IllegalArgumentException unused2) {
            HaoboLog.m49290e(HaoboLog.httpReqLogTag, HaoboLog.getString(C2750R.C2755string.http_unknown));
            return f10374c;
        } catch (SecurityException unused3) {
            HaoboLog.m49290e(HaoboLog.httpReqLogTag, HaoboLog.getString(C2750R.C2755string.permissions_internet));
            return f10374c;
        } catch (MalformedURLException unused4) {
            HaoboLog.m49290e(HaoboLog.httpReqLogTag, HaoboLog.getString(C2750R.C2755string.http_url_malformed));
            return f10374c;
        } catch (Exception e) {
            e.printStackTrace();
            HaoboLog.m49290e(HaoboLog.httpReqLogTag, Log.getStackTraceString(e));
            HaoboLog.m49290e(HaoboLog.httpReqLogTag, HaoboLog.getString(C2750R.C2755string.unknown_exception));
            return f10374c;
        }
    }

    /* renamed from: a */
    private HttpURLConnection m49342a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m49343a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", BeiZiImpl.m49492a().f10137d);
        httpURLConnection.setRequestProperty("Content-Type", C2594an.f8583d);
        httpURLConnection.setRequestProperty("Accept", C2594an.f8583d);
        String cookie = WebviewUtil.getCookie();
        if (!TextUtils.isEmpty(cookie)) {
            httpURLConnection.setRequestProperty(HttpHeaders.Names.COOKIE, cookie);
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
            HaoboLog.m49286v(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.no_response));
            m49346a(2);
        } else if (serverResponse.m49366a()) {
            m49346a(2);
        } else {
            AdRequestDelegate adRequestDelegate = this.f10375a.get();
            if (adRequestDelegate != null) {
                adRequestDelegate.mo49372a(serverResponse);
            }
        }
    }
}
