package com.beizi.ad.internal.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.utilities.DeviceInfo;
import com.beizi.ad.internal.utilities.HTTPGet;
import com.beizi.ad.internal.utilities.HTTPResponse;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.StringUtil;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MediationAdViewController.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class b {

    /* renamed from: j  reason: collision with root package name */
    static HashMap<String, String> f13526j = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    protected k f13527a;

    /* renamed from: b  reason: collision with root package name */
    protected com.beizi.ad.b.b f13528b;

    /* renamed from: c  reason: collision with root package name */
    protected com.beizi.ad.internal.a.a f13529c;

    /* renamed from: d  reason: collision with root package name */
    protected com.beizi.ad.internal.c f13530d;

    /* renamed from: f  reason: collision with root package name */
    protected ServerResponse f13532f;

    /* renamed from: l  reason: collision with root package name */
    private SoftReference<com.beizi.ad.internal.f> f13537l;

    /* renamed from: e  reason: collision with root package name */
    protected e f13531e = new e(this);

    /* renamed from: g  reason: collision with root package name */
    protected boolean f13533g = false;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f13534h = false;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f13535i = false;

    /* renamed from: m  reason: collision with root package name */
    private final Handler f13538m = new HandlerC0123b(this);

    /* renamed from: n  reason: collision with root package name */
    private long f13539n = -1;

    /* renamed from: o  reason: collision with root package name */
    private long f13540o = -1;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f13536k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MediationAdViewController.java */
    /* renamed from: com.beizi.ad.internal.a.b$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class AnonymousClass1 implements com.beizi.ad.internal.network.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f13541a;

        @Override // com.beizi.ad.internal.network.b
        public k a() {
            return this.f13541a.f13527a;
        }

        @Override // com.beizi.ad.internal.network.b
        public boolean b() {
            return true;
        }

        @Override // com.beizi.ad.internal.network.b
        public com.beizi.ad.internal.view.c c() {
            return this.f13541a.f13531e;
        }

        @Override // com.beizi.ad.internal.network.b
        public NativeAdResponse d() {
            return null;
        }

        @Override // com.beizi.ad.internal.network.b
        public String e() {
            return "";
        }

        @Override // com.beizi.ad.internal.network.b
        public String f() {
            return null;
        }

        @Override // com.beizi.ad.internal.network.b
        public String g() {
            return null;
        }

        @Override // com.beizi.ad.internal.network.b
        public void h() {
            this.f13541a.f13531e.destroy();
        }

        @Override // com.beizi.ad.internal.network.b
        public boolean i() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MediationAdViewController.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends HTTPGet {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<com.beizi.ad.internal.f> f13542a;

        /* renamed from: b  reason: collision with root package name */
        final int f13543b;

        /* renamed from: d  reason: collision with root package name */
        private final String f13545d;

        /* renamed from: e  reason: collision with root package name */
        private final HashMap<String, Object> f13546e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f13547f;

        /* renamed from: g  reason: collision with root package name */
        private final long f13548g;

        /* renamed from: h  reason: collision with root package name */
        private final long f13549h;

        /* synthetic */ a(b bVar, com.beizi.ad.internal.f fVar, String str, int i4, HashMap hashMap, boolean z3, long j4, long j5, AnonymousClass1 anonymousClass1) {
            this(fVar, str, i4, hashMap, z3, j4, j5);
        }

        @Override // com.beizi.ad.internal.utilities.HTTPGet
        protected String getUrl() {
            StringBuilder sb = new StringBuilder(this.f13545d);
            sb.append("&errorCode=");
            sb.append(this.f13543b);
            DeviceInfo deviceInfo = DeviceInfo.getInstance();
            if (!StringUtil.isEmpty(deviceInfo.sdkUID)) {
                sb.append("&sdkuid=");
                sb.append(Uri.encode(deviceInfo.sdkUID));
            }
            if (this.f13548g > 0) {
                sb.append("&latency=");
                sb.append(Uri.encode(String.valueOf(this.f13548g)));
            }
            if (this.f13549h > 0) {
                sb.append("&total_latency=");
                sb.append(Uri.encode(String.valueOf(this.f13549h)));
            }
            return sb.toString();
        }

        private a(com.beizi.ad.internal.f fVar, String str, int i4, HashMap<String, Object> hashMap, boolean z3, long j4, long j5) {
            super(true, true);
            this.f13542a = new WeakReference<>(fVar);
            this.f13545d = str;
            this.f13543b = i4;
            this.f13546e = hashMap;
            this.f13547f = z3;
            this.f13548g = j4;
            this.f13549h = j5;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.beizi.ad.internal.utilities.HTTPGet, android.os.AsyncTask
        public void onPostExecute(HTTPResponse hTTPResponse) {
            if (this.f13547f) {
                HaoboLog.i(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.result_cb_ignored));
                return;
            }
            com.beizi.ad.internal.f fVar = this.f13542a.get();
            if (fVar == null) {
                HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.fire_cb_requester_null));
                return;
            }
            ServerResponse serverResponse = null;
            if (hTTPResponse != null && hTTPResponse.getSucceeded()) {
                serverResponse = new ServerResponse(hTTPResponse, b.this.f13527a);
                if (this.f13546e.containsKey("ORIENTATION")) {
                    serverResponse.setAdOrientation(this.f13546e.get("ORIENTATION").equals("h") ? 1 : 2);
                }
            } else {
                HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.result_cb_bad_response));
            }
            fVar.a(serverResponse);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MediationAdViewController.java */
    /* renamed from: com.beizi.ad.internal.a.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class HandlerC0123b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<b> f13550a;

        public HandlerC0123b(b bVar) {
            this.f13550a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.f13550a.get();
            if (bVar == null || bVar.f13533g) {
                return;
            }
            HaoboLog.w(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediation_timeout));
            try {
                bVar.a(0);
            } catch (IllegalArgumentException unused) {
            } catch (Throwable th) {
                bVar.f13530d = null;
                bVar.f13528b = null;
                bVar.f13529c = null;
                throw th;
            }
            bVar.f13530d = null;
            bVar.f13528b = null;
            bVar.f13529c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.beizi.ad.internal.f fVar, com.beizi.ad.internal.a.a aVar, com.beizi.ad.internal.c cVar, k kVar, ServerResponse serverResponse) {
        int i4;
        if (f13526j.isEmpty()) {
            a("1", "Baidu");
            a("4", AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT);
            a("43", "AFP");
        }
        this.f13532f = serverResponse;
        this.f13537l = new SoftReference<>(fVar);
        this.f13529c = aVar;
        this.f13530d = cVar;
        this.f13527a = kVar;
        if (aVar == null) {
            HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediated_no_ads));
            i4 = 3;
        } else {
            i4 = !l() ? 2 : -1;
        }
        if (i4 != -1) {
            a(i4);
        }
    }

    private boolean l() {
        String str;
        HaoboLog.d(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.instantiating_class, this.f13529c.a()));
        try {
            String str2 = this.f13529c.a() + "." + this.f13527a.toString();
            String str3 = f13526j.get(str2);
            String str4 = com.beizi.ad.internal.h.a().f13807f.get(str2);
            if (StringUtil.isEmpty(str4)) {
                if (StringUtil.isEmpty(str3)) {
                    str = getClass().getPackage().getName() + "." + str2;
                } else {
                    str = getClass().getPackage().getName() + "." + str3;
                }
                this.f13528b = (com.beizi.ad.b.b) Class.forName(str).newInstance();
            } else {
                this.f13528b = (com.beizi.ad.b.b) Class.forName(getClass().getPackage().getName() + "." + str4).getConstructor(String.class).newInstance(str2);
            }
            return true;
        } catch (ClassCastException e4) {
            a(e4, this.f13529c.a());
            return false;
        } catch (ClassNotFoundException e5) {
            a(e5, this.f13529c.a());
            return false;
        } catch (IllegalAccessException e6) {
            a(e6, this.f13529c.a());
            return false;
        } catch (InstantiationException e7) {
            a(e7, this.f13529c.a());
            return false;
        } catch (LinkageError e8) {
            a(e8, this.f13529c.a());
            return false;
        } catch (NoSuchMethodException e9) {
            a(e9, this.f13529c.a());
            return false;
        } catch (InvocationTargetException e10) {
            a(e10, this.f13529c.a());
            return false;
        }
    }

    private long m() {
        long j4 = this.f13539n;
        if (j4 > 0) {
            long j5 = this.f13540o;
            if (j5 > 0) {
                return j5 - j4;
            }
            return -1L;
        }
        return -1L;
    }

    void a(String str, String str2) {
        f13526j.put(str + ".SPLASH", str2 + "Splash");
        f13526j.put(str + ".BANNER", str2 + "Banner");
        f13526j.put(str + ".INTERSTITIAL", str2 + "Interstitial");
        f13526j.put(str + ".NATIVE", str2 + "Native");
        f13526j.put(str + ".REWARDEDVIDEO", str2 + "Interstitial");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.b();
        }
        this.f13535i = true;
        this.f13528b = null;
        this.f13529c = null;
        HaoboLog.d(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediation_finish));
    }

    public abstract void c();

    public boolean d() {
        return this.f13535i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f13534h || this.f13533g) {
            return;
        }
        this.f13538m.sendEmptyMessageDelayed(0, 15000L);
    }

    void f() {
        this.f13538m.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f13539n = System.currentTimeMillis();
    }

    protected void h() {
        this.f13540o = System.currentTimeMillis();
    }

    public abstract void i();

    public abstract void j();

    public abstract void k();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Class cls) {
        if (this.f13533g) {
            return false;
        }
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar == null || cls == null || !cls.isInstance(bVar)) {
            HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.instance_exception, cls != null ? cls.getCanonicalName() : "null"));
            a(3);
            return false;
        }
        return true;
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    private void b(int i4) {
        if (this.f13533g) {
            return;
        }
        com.beizi.ad.internal.f fVar = this.f13537l.get();
        com.beizi.ad.internal.a.a aVar = this.f13529c;
        if (aVar == null || StringUtil.isEmpty(aVar.f())) {
            if (i4 == -1) {
                return;
            }
            HaoboLog.w(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.fire_cb_result_null));
            if (fVar == null) {
                HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.fire_cb_requester_null));
                return;
            } else {
                fVar.a((ServerResponse) null);
                return;
            }
        }
        boolean z3 = i4 == -1 ? true : (fVar == null || fVar.b() == null || fVar.b().size() <= 0) ? false : true;
        try {
            new a(this, fVar, this.f13529c.f(), i4, this.f13529c.g(), z3, m(), a(fVar), null).execute(new Void[0]);
        } catch (RejectedExecutionException e4) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.e(str, "Concurrent Thread Exception while firing ResultCB: " + e4.getMessage());
        } catch (Exception e5) {
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.e(str2, "Exception while firing ResultCB: " + e5.getMessage());
        }
        if (!z3 || i4 == -1 || fVar == null) {
            return;
        }
        fVar.a((ServerResponse) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.beizi.ad.b.a a() {
        com.beizi.ad.internal.f fVar = this.f13537l.get();
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    private void a(Throwable th, String str) {
        HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediation_instantiation_failure, th.getClass().getSimpleName()));
        if (StringUtil.isEmpty(str)) {
            return;
        }
        HaoboLog.w(HaoboLog.mediationLogTag, String.format("Adding %s to invalid networks list", str));
        com.beizi.ad.internal.h.a().a(this.f13527a, str);
    }

    public void a(int i4) {
        if (this.f13534h || this.f13533g || this.f13535i) {
            return;
        }
        h();
        f();
        b(i4);
        this.f13533g = true;
        b();
    }

    private long a(com.beizi.ad.internal.f fVar) {
        if (fVar != null) {
            long j4 = this.f13540o;
            if (j4 > 0) {
                return fVar.a(j4);
            }
            return -1L;
        }
        return -1L;
    }

    public void a(boolean z3) {
        this.f13536k = z3;
        if (z3) {
            b();
        }
    }
}
