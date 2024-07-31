package com.beizi.p051ad.internal.p057a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.AdDispatcher;
import com.beizi.p051ad.internal.AdRequestDelegate;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.network.AdResponse;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.utilities.DeviceInfo;
import com.beizi.p051ad.internal.utilities.HTTPGet;
import com.beizi.p051ad.internal.utilities.HTTPResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.view.Displayable;
import com.beizi.p051ad.p055b.MediationAdRequest;
import com.beizi.p051ad.p055b.MediationAdapter;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.beizi.ad.internal.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class MediationAdViewController {

    /* renamed from: j */
    static HashMap<String, String> f9828j = new HashMap<>();

    /* renamed from: a */
    protected EnumC2888k f9829a;

    /* renamed from: b */
    protected MediationAdapter f9830b;

    /* renamed from: c */
    protected MediationAd f9831c;

    /* renamed from: d */
    protected AdDispatcher f9832d;

    /* renamed from: f */
    protected ServerResponse f9834f;

    /* renamed from: l */
    private SoftReference<AdRequestDelegate> f9839l;

    /* renamed from: e */
    protected MediationDisplayable f9833e = new MediationDisplayable(this);

    /* renamed from: g */
    protected boolean f9835g = false;

    /* renamed from: h */
    protected boolean f9836h = false;

    /* renamed from: i */
    protected boolean f9837i = false;

    /* renamed from: m */
    private final Handler f9840m = new HandlerC2823b(this);

    /* renamed from: n */
    private long f9841n = -1;

    /* renamed from: o */
    private long f9842o = -1;

    /* renamed from: k */
    protected boolean f9838k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MediationAdViewController.java */
    /* renamed from: com.beizi.ad.internal.a.b$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C28211 implements AdResponse {

        /* renamed from: a */
        final /* synthetic */ MediationAdViewController f9843a;

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: a */
        public EnumC2888k mo49313a() {
            return this.f9843a.f9829a;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: b */
        public boolean mo49312b() {
            return true;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: c */
        public Displayable mo49311c() {
            return this.f9843a.f9833e;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: d */
        public NativeAdResponse mo49310d() {
            return null;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: e */
        public String mo49309e() {
            return "";
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: f */
        public String mo49308f() {
            return null;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: g */
        public String mo49307g() {
            return null;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: h */
        public void mo49306h() {
            this.f9843a.f9833e.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediationAdViewController.java */
    /* renamed from: com.beizi.ad.internal.a.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class AsyncTaskC2822a extends HTTPGet {

        /* renamed from: a */
        WeakReference<AdRequestDelegate> f9844a;

        /* renamed from: b */
        final int f9845b;

        /* renamed from: d */
        private final String f9847d;

        /* renamed from: e */
        private final HashMap<String, Object> f9848e;

        /* renamed from: f */
        private final boolean f9849f;

        /* renamed from: g */
        private final long f9850g;

        /* renamed from: h */
        private final long f9851h;

        /* synthetic */ AsyncTaskC2822a(MediationAdViewController mediationAdViewController, AdRequestDelegate adRequestDelegate, String str, int i, HashMap hashMap, boolean z, long j, long j2, C28211 c28211) {
            this(adRequestDelegate, str, i, hashMap, z, j, j2);
        }

        @Override // com.beizi.p051ad.internal.utilities.HTTPGet
        protected String getUrl() {
            StringBuilder sb = new StringBuilder(this.f9847d);
            sb.append("&errorCode=");
            sb.append(this.f9845b);
            DeviceInfo deviceInfo = DeviceInfo.getInstance();
            if (!StringUtil.isEmpty(deviceInfo.sdkUID)) {
                sb.append("&sdkuid=");
                sb.append(Uri.encode(deviceInfo.sdkUID));
            }
            if (this.f9850g > 0) {
                sb.append("&latency=");
                sb.append(Uri.encode(String.valueOf(this.f9850g)));
            }
            if (this.f9851h > 0) {
                sb.append("&total_latency=");
                sb.append(Uri.encode(String.valueOf(this.f9851h)));
            }
            return sb.toString();
        }

        private AsyncTaskC2822a(AdRequestDelegate adRequestDelegate, String str, int i, HashMap<String, Object> hashMap, boolean z, long j, long j2) {
            super(true, true);
            this.f9844a = new WeakReference<>(adRequestDelegate);
            this.f9847d = str;
            this.f9845b = i;
            this.f9848e = hashMap;
            this.f9849f = z;
            this.f9850g = j;
            this.f9851h = j2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.beizi.p051ad.internal.utilities.HTTPGet, android.os.AsyncTask
        public void onPostExecute(HTTPResponse hTTPResponse) {
            if (this.f9849f) {
                HaoboLog.m49288i(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.result_cb_ignored));
                return;
            }
            AdRequestDelegate adRequestDelegate = this.f9844a.get();
            if (adRequestDelegate == null) {
                HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.fire_cb_requester_null));
                return;
            }
            ServerResponse serverResponse = null;
            if (hTTPResponse != null && hTTPResponse.getSucceeded()) {
                serverResponse = new ServerResponse(hTTPResponse, MediationAdViewController.this.f9829a);
                if (this.f9848e.containsKey(ServerResponse.EXTRAS_KEY_ORIENTATION)) {
                    serverResponse.setAdOrientation(this.f9848e.get(ServerResponse.EXTRAS_KEY_ORIENTATION).equals("h") ? 1 : 2);
                }
            } else {
                HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.result_cb_bad_response));
            }
            adRequestDelegate.mo49372a(serverResponse);
        }
    }

    /* compiled from: MediationAdViewController.java */
    /* renamed from: com.beizi.ad.internal.a.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class HandlerC2823b extends Handler {

        /* renamed from: a */
        WeakReference<MediationAdViewController> f9852a;

        public HandlerC2823b(MediationAdViewController mediationAdViewController) {
            this.f9852a = new WeakReference<>(mediationAdViewController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediationAdViewController mediationAdViewController = this.f9852a.get();
            if (mediationAdViewController == null || mediationAdViewController.f9835g) {
                return;
            }
            HaoboLog.m49284w(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediation_timeout));
            try {
                mediationAdViewController.m49774a(0);
            } catch (IllegalArgumentException unused) {
            } catch (Throwable th) {
                mediationAdViewController.f9832d = null;
                mediationAdViewController.f9830b = null;
                mediationAdViewController.f9831c = null;
                throw th;
            }
            mediationAdViewController.f9832d = null;
            mediationAdViewController.f9830b = null;
            mediationAdViewController.f9831c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediationAdViewController(AdRequestDelegate adRequestDelegate, MediationAd mediationAd, AdDispatcher adDispatcher, EnumC2888k enumC2888k, ServerResponse serverResponse) {
        int i;
        if (f9828j.isEmpty()) {
            m49771a("1", "Baidu");
            m49771a("4", "GDT");
            m49771a("43", "AFP");
        }
        this.f9834f = serverResponse;
        this.f9839l = new SoftReference<>(adRequestDelegate);
        this.f9831c = mediationAd;
        this.f9832d = adDispatcher;
        this.f9829a = enumC2888k;
        if (mediationAd == null) {
            HaoboLog.m49290e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediated_no_ads));
            i = 3;
        } else {
            i = !m49761l() ? 2 : -1;
        }
        if (i != -1) {
            m49774a(i);
        }
    }

    /* renamed from: l */
    private boolean m49761l() {
        String str;
        HaoboLog.m49292d(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.instantiating_class, this.f9831c.m49783a()));
        try {
            String str2 = this.f9831c.m49783a() + "." + this.f9829a.toString();
            String str3 = f9828j.get(str2);
            String str4 = BeiZiImpl.m49492a().f10138e.get(str2);
            if (StringUtil.isEmpty(str4)) {
                if (StringUtil.isEmpty(str3)) {
                    str = getClass().getPackage().getName() + "." + str2;
                } else {
                    str = getClass().getPackage().getName() + "." + str3;
                }
                this.f9830b = (MediationAdapter) Class.forName(str).newInstance();
            } else {
                this.f9830b = (MediationAdapter) Class.forName(getClass().getPackage().getName() + "." + str4).getConstructor(String.class).newInstance(str2);
            }
            return true;
        } catch (ClassCastException e) {
            m49770a(e, this.f9831c.m49783a());
            return false;
        } catch (ClassNotFoundException e2) {
            m49770a(e2, this.f9831c.m49783a());
            return false;
        } catch (IllegalAccessException e3) {
            m49770a(e3, this.f9831c.m49783a());
            return false;
        } catch (InstantiationException e4) {
            m49770a(e4, this.f9831c.m49783a());
            return false;
        } catch (LinkageError e5) {
            m49770a(e5, this.f9831c.m49783a());
            return false;
        } catch (NoSuchMethodException e6) {
            m49770a(e6, this.f9831c.m49783a());
            return false;
        } catch (InvocationTargetException e7) {
            m49770a(e7, this.f9831c.m49783a());
            return false;
        }
    }

    /* renamed from: m */
    private long m49760m() {
        long j = this.f9841n;
        if (j > 0) {
            long j2 = this.f9842o;
            if (j2 > 0) {
                return j2 - j;
            }
            return -1L;
        }
        return -1L;
    }

    /* renamed from: a */
    void m49771a(String str, String str2) {
        f9828j.put(str + ".SPLASH", str2 + ExploreConstants.SCENE_SPLASH);
        f9828j.put(str + ".BANNER", str2 + "Banner");
        f9828j.put(str + ".INTERSTITIAL", str2 + ExploreConstants.SCENE_INTERSTITIAL);
        f9828j.put(str + ".NATIVE", str2 + "Native");
        f9828j.put(str + ".REWARDEDVIDEO", str2 + ExploreConstants.SCENE_INTERSTITIAL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m49768b() {
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50089b();
        }
        this.f9837i = true;
        this.f9830b = null;
        this.f9831c = null;
        HaoboLog.m49292d(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediation_finish));
    }

    /* renamed from: c */
    public abstract void mo49751c();

    /* renamed from: d */
    public boolean m49766d() {
        return this.f9837i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m49765e() {
        if (this.f9836h || this.f9835g) {
            return;
        }
        this.f9840m.sendEmptyMessageDelayed(0, 15000L);
    }

    /* renamed from: f */
    void m49764f() {
        this.f9840m.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void m49763g() {
        this.f9841n = System.currentTimeMillis();
    }

    /* renamed from: h */
    protected void m49762h() {
        this.f9842o = System.currentTimeMillis();
    }

    /* renamed from: i */
    public abstract void mo49750i();

    /* renamed from: j */
    public abstract void mo49749j();

    /* renamed from: k */
    public abstract void mo49748k();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m49772a(Class cls) {
        if (this.f9835g) {
            return false;
        }
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter == null || cls == null || !cls.isInstance(mediationAdapter)) {
            HaoboLog.m49290e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.instance_exception, cls != null ? cls.getCanonicalName() : "null"));
            m49774a(3);
            return false;
        }
        return true;
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    /* renamed from: b */
    private void m49767b(int i) {
        if (this.f9835g) {
            return;
        }
        AdRequestDelegate adRequestDelegate = this.f9839l.get();
        MediationAd mediationAd = this.f9831c;
        if (mediationAd == null || StringUtil.isEmpty(mediationAd.m49777f())) {
            if (i == -1) {
                return;
            }
            HaoboLog.m49284w(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.fire_cb_result_null));
            if (adRequestDelegate == null) {
                HaoboLog.m49290e(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.fire_cb_requester_null));
                return;
            } else {
                adRequestDelegate.mo49372a((ServerResponse) null);
                return;
            }
        }
        boolean z = i == -1 ? true : (adRequestDelegate == null || adRequestDelegate.mo49458b() == null || adRequestDelegate.mo49458b().size() <= 0) ? false : true;
        try {
            new AsyncTaskC2822a(this, adRequestDelegate, this.f9831c.m49777f(), i, this.f9831c.m49776g(), z, m49760m(), m49773a(adRequestDelegate), null).execute(new Void[0]);
        } catch (RejectedExecutionException e) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str, "Concurrent Thread Exception while firing ResultCB: " + e.getMessage());
        } catch (Exception e2) {
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str2, "Exception while firing ResultCB: " + e2.getMessage());
        }
        if (!z || i == -1 || adRequestDelegate == null) {
            return;
        }
        adRequestDelegate.mo49372a((ServerResponse) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public MediationAdRequest m49775a() {
        AdRequestDelegate adRequestDelegate = this.f9839l.get();
        if (adRequestDelegate != null) {
            return adRequestDelegate.mo49369d();
        }
        return null;
    }

    /* renamed from: a */
    private void m49770a(Throwable th, String str) {
        HaoboLog.m49290e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediation_instantiation_failure, th.getClass().getSimpleName()));
        if (StringUtil.isEmpty(str)) {
            return;
        }
        HaoboLog.m49284w(HaoboLog.mediationLogTag, String.format("Adding %s to invalid networks list", str));
        BeiZiImpl.m49492a().m49485a(this.f9829a, str);
    }

    /* renamed from: a */
    public void m49774a(int i) {
        if (this.f9836h || this.f9835g || this.f9837i) {
            return;
        }
        m49762h();
        m49764f();
        m49767b(i);
        this.f9835g = true;
        m49768b();
    }

    /* renamed from: a */
    private long m49773a(AdRequestDelegate adRequestDelegate) {
        if (adRequestDelegate != null) {
            long j = this.f9842o;
            if (j > 0) {
                return adRequestDelegate.mo49460a(j);
            }
            return -1L;
        }
        return -1L;
    }

    /* renamed from: a */
    public void m49769a(boolean z) {
        this.f9838k = z;
        if (z) {
            m49768b();
        }
    }
}
