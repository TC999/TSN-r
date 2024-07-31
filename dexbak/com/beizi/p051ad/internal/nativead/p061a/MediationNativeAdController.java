package com.beizi.p051ad.internal.nativead.p061a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.AdRequestDelegate;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.network.AdResponse;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.internal.utilities.DeviceInfo;
import com.beizi.p051ad.internal.utilities.HTTPGet;
import com.beizi.p051ad.internal.utilities.HTTPResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.view.Displayable;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.beizi.ad.internal.nativead.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediationNativeAdController {

    /* renamed from: a */
    public ServerResponse f10271a;

    /* renamed from: b */
    AdRequestDelegate f10272b;

    /* renamed from: c */
    MediationAd f10273c;

    /* renamed from: f */
    int f10276f;

    /* renamed from: d */
    boolean f10274d = false;

    /* renamed from: e */
    boolean f10275e = false;

    /* renamed from: g */
    private boolean f10277g = false;

    /* renamed from: h */
    private final Handler f10278h = new HandlerC2910b(this);

    /* renamed from: i */
    private long f10279i = -1;

    /* renamed from: j */
    private long f10280j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MediationNativeAdController.java */
    /* renamed from: com.beizi.ad.internal.nativead.a.a$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C29081 implements AdResponse {

        /* renamed from: a */
        final /* synthetic */ NativeAdResponse f10281a;

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: a */
        public EnumC2888k mo49313a() {
            return EnumC2888k.NATIVE;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: b */
        public boolean mo49312b() {
            return true;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: c */
        public Displayable mo49311c() {
            return null;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: d */
        public NativeAdResponse mo49310d() {
            return this.f10281a;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: e */
        public String mo49309e() {
            return "";
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: f */
        public String mo49308f() {
            return this.f10281a.getPrice();
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: g */
        public String mo49307g() {
            return null;
        }

        @Override // com.beizi.p051ad.internal.network.AdResponse
        /* renamed from: h */
        public void mo49306h() {
            this.f10281a.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediationNativeAdController.java */
    /* renamed from: com.beizi.ad.internal.nativead.a.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class AsyncTaskC2909a extends HTTPGet {

        /* renamed from: a */
        AdRequestDelegate f10282a;

        /* renamed from: b */
        final int f10283b;

        /* renamed from: d */
        private final String f10285d;

        /* renamed from: e */
        private final HashMap<String, Object> f10286e;

        /* renamed from: f */
        private final boolean f10287f;

        /* renamed from: g */
        private final long f10288g;

        /* renamed from: h */
        private final long f10289h;

        /* synthetic */ AsyncTaskC2909a(MediationNativeAdController mediationNativeAdController, AdRequestDelegate adRequestDelegate, String str, int i, HashMap hashMap, boolean z, long j, long j2, C29081 c29081) {
            this(adRequestDelegate, str, i, hashMap, z, j, j2);
        }

        @Override // com.beizi.p051ad.internal.utilities.HTTPGet
        protected String getUrl() {
            StringBuilder sb = new StringBuilder(this.f10285d);
            sb.append("&reason=");
            sb.append(this.f10283b);
            sb.append("&uid=");
            sb.append(Uri.encode(DeviceInfo.getInstance().sdkUID));
            if (this.f10288g > 0) {
                sb.append("&latency=");
                sb.append(Uri.encode(String.valueOf(this.f10288g)));
            }
            if (this.f10289h > 0) {
                sb.append("&total_latency=");
                sb.append(Uri.encode(String.valueOf(this.f10289h)));
            }
            return sb.toString();
        }

        private AsyncTaskC2909a(AdRequestDelegate adRequestDelegate, String str, int i, HashMap<String, Object> hashMap, boolean z, long j, long j2) {
            super(true, true);
            this.f10282a = adRequestDelegate;
            this.f10285d = str;
            this.f10283b = i;
            this.f10286e = hashMap;
            this.f10287f = z;
            this.f10288g = j;
            this.f10289h = j2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.beizi.p051ad.internal.utilities.HTTPGet, android.os.AsyncTask
        public void onPostExecute(HTTPResponse hTTPResponse) {
            if (this.f10287f) {
                HaoboLog.m49288i(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.result_cb_ignored));
                return;
            }
            AdRequestDelegate adRequestDelegate = this.f10282a;
            if (adRequestDelegate == null) {
                HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.fire_cb_requester_null));
                return;
            }
            ServerResponse serverResponse = null;
            if (hTTPResponse != null && hTTPResponse.getSucceeded()) {
                serverResponse = new ServerResponse(hTTPResponse, EnumC2888k.NATIVE);
                if (this.f10286e.containsKey(ServerResponse.EXTRAS_KEY_ORIENTATION)) {
                    serverResponse.addToExtras(ServerResponse.EXTRAS_KEY_ORIENTATION, this.f10286e.get(ServerResponse.EXTRAS_KEY_ORIENTATION));
                }
            } else {
                HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.result_cb_bad_response));
            }
            adRequestDelegate.mo49372a(serverResponse);
        }
    }

    /* compiled from: MediationNativeAdController.java */
    /* renamed from: com.beizi.ad.internal.nativead.a.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class HandlerC2910b extends Handler {

        /* renamed from: a */
        WeakReference<MediationNativeAdController> f10290a;

        public HandlerC2910b(MediationNativeAdController mediationNativeAdController) {
            this.f10290a = new WeakReference<>(mediationNativeAdController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediationNativeAdController mediationNativeAdController = this.f10290a.get();
            if (mediationNativeAdController == null || mediationNativeAdController.f10275e) {
                return;
            }
            HaoboLog.m49284w(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediation_timeout));
            try {
                mediationNativeAdController.m49409a(0);
            } catch (IllegalArgumentException unused) {
            } catch (Throwable th) {
                mediationNativeAdController.f10273c = null;
                throw th;
            }
            mediationNativeAdController.f10273c = null;
        }
    }

    private MediationNativeAdController(MediationAd mediationAd, AdRequestDelegate adRequestDelegate, ServerResponse serverResponse) {
        if (mediationAd == null) {
            HaoboLog.m49290e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediated_no_ads));
            this.f10276f = 3;
        } else {
            HaoboLog.m49292d(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.instantiating_class, mediationAd.m49783a()));
            this.f10272b = adRequestDelegate;
            this.f10273c = mediationAd;
            this.f10271a = serverResponse;
            m49404b();
            m49401d();
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) Class.forName(mediationAd.m49783a()).newInstance();
                if (adRequestDelegate.mo49370c() != null) {
                    mediationNativeAdapter.m49398a(adRequestDelegate.mo49370c().m49514b(), mediationAd.m49778e(), mediationAd.m49781b(), this, adRequestDelegate.mo49369d());
                } else {
                    this.f10276f = 1;
                }
            } catch (ClassCastException e) {
                m49406a(e, mediationAd.m49783a());
            } catch (ClassNotFoundException e2) {
                m49406a(e2, mediationAd.m49783a());
            } catch (IllegalAccessException e3) {
                m49406a(e3, mediationAd.m49783a());
            } catch (InstantiationException e4) {
                m49406a(e4, mediationAd.m49783a());
            } catch (LinkageError e5) {
                m49406a(e5, mediationAd.m49783a());
            }
        }
        int i = this.f10276f;
        if (i != -1) {
            m49409a(i);
        }
    }

    /* renamed from: a */
    public static MediationNativeAdController m49408a(MediationAd mediationAd, AdRequestDelegate adRequestDelegate, ServerResponse serverResponse) {
        return new MediationNativeAdController(mediationAd, adRequestDelegate, serverResponse);
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    /* renamed from: b */
    private void m49403b(int i) {
        if (this.f10275e) {
            return;
        }
        AdRequestDelegate adRequestDelegate = this.f10272b;
        MediationAd mediationAd = this.f10273c;
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
            new AsyncTaskC2909a(this, adRequestDelegate, this.f10273c.m49777f(), i, this.f10273c.m49776g(), z, m49399f(), m49407a(adRequestDelegate), null).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
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

    /* renamed from: f */
    private long m49399f() {
        long j = this.f10279i;
        if (j > 0) {
            long j2 = this.f10280j;
            if (j2 > 0) {
                return j2 - j;
            }
            return -1L;
        }
        return -1L;
    }

    /* renamed from: c */
    void m49402c() {
        this.f10278h.removeMessages(0);
    }

    /* renamed from: d */
    protected void m49401d() {
        this.f10279i = System.currentTimeMillis();
    }

    /* renamed from: e */
    protected void m49400e() {
        this.f10280j = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m49406a(Throwable th, String str) {
        HaoboLog.m49290e(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediation_instantiation_failure, th.getClass().getSimpleName()));
        if (!StringUtil.isEmpty(str)) {
            HaoboLog.m49284w(HaoboLog.mediationLogTag, String.format("Adding %s to invalid networks list", str));
            BeiZiImpl.m49492a().m49485a(EnumC2888k.NATIVE, str);
        }
        this.f10276f = 3;
    }

    /* renamed from: a */
    protected void m49410a() {
        this.f10273c = null;
        HaoboLog.m49292d(HaoboLog.mediationLogTag, HaoboLog.getString(C2750R.C2755string.mediation_finish));
    }

    /* renamed from: a */
    public void m49409a(int i) {
        if (this.f10274d || this.f10275e) {
            return;
        }
        m49400e();
        m49402c();
        m49403b(i);
        this.f10275e = true;
        m49410a();
    }

    /* renamed from: a */
    private long m49407a(AdRequestDelegate adRequestDelegate) {
        if (adRequestDelegate != null) {
            long j = this.f10280j;
            if (j > 0) {
                return adRequestDelegate.mo49460a(j);
            }
            return -1L;
        }
        return -1L;
    }

    /* renamed from: b */
    void m49404b() {
        if (this.f10274d || this.f10275e) {
            return;
        }
        this.f10278h.sendEmptyMessageDelayed(0, 15000L);
    }

    /* renamed from: a */
    public void m49405a(boolean z) {
        this.f10277g = z;
        if (z) {
            m49410a();
        }
    }
}
