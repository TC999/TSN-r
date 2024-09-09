package com.beizi.ad.internal.nativead.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.internal.f;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.utilities.DeviceInfo;
import com.beizi.ad.internal.utilities.HTTPGet;
import com.beizi.ad.internal.utilities.HTTPResponse;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.view.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MediationNativeAdController.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ServerResponse f13912a;

    /* renamed from: b  reason: collision with root package name */
    f f13913b;

    /* renamed from: c  reason: collision with root package name */
    com.beizi.ad.internal.a.a f13914c;

    /* renamed from: f  reason: collision with root package name */
    int f13917f;

    /* renamed from: d  reason: collision with root package name */
    boolean f13915d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f13916e = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13918g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f13919h = new b(this);

    /* renamed from: i  reason: collision with root package name */
    private long f13920i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f13921j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MediationNativeAdController.java */
    /* renamed from: com.beizi.ad.internal.nativead.a.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class AnonymousClass1 implements com.beizi.ad.internal.network.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NativeAdResponse f13922a;

        @Override // com.beizi.ad.internal.network.b
        public k a() {
            return k.NATIVE;
        }

        @Override // com.beizi.ad.internal.network.b
        public boolean b() {
            return true;
        }

        @Override // com.beizi.ad.internal.network.b
        public c c() {
            return null;
        }

        @Override // com.beizi.ad.internal.network.b
        public NativeAdResponse d() {
            return this.f13922a;
        }

        @Override // com.beizi.ad.internal.network.b
        public String e() {
            return "";
        }

        @Override // com.beizi.ad.internal.network.b
        public String f() {
            return this.f13922a.getPrice();
        }

        @Override // com.beizi.ad.internal.network.b
        public String g() {
            return null;
        }

        @Override // com.beizi.ad.internal.network.b
        public void h() {
            this.f13922a.destroy();
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
    /* compiled from: MediationNativeAdController.java */
    /* renamed from: com.beizi.ad.internal.nativead.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class AsyncTaskC0125a extends HTTPGet {

        /* renamed from: a  reason: collision with root package name */
        f f13923a;

        /* renamed from: b  reason: collision with root package name */
        final int f13924b;

        /* renamed from: d  reason: collision with root package name */
        private final String f13926d;

        /* renamed from: e  reason: collision with root package name */
        private final HashMap<String, Object> f13927e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f13928f;

        /* renamed from: g  reason: collision with root package name */
        private final long f13929g;

        /* renamed from: h  reason: collision with root package name */
        private final long f13930h;

        /* synthetic */ AsyncTaskC0125a(a aVar, f fVar, String str, int i4, HashMap hashMap, boolean z3, long j4, long j5, AnonymousClass1 anonymousClass1) {
            this(fVar, str, i4, hashMap, z3, j4, j5);
        }

        @Override // com.beizi.ad.internal.utilities.HTTPGet
        protected String getUrl() {
            StringBuilder sb = new StringBuilder(this.f13926d);
            sb.append("&reason=");
            sb.append(this.f13924b);
            sb.append("&uid=");
            sb.append(Uri.encode(DeviceInfo.getInstance().sdkUID));
            if (this.f13929g > 0) {
                sb.append("&latency=");
                sb.append(Uri.encode(String.valueOf(this.f13929g)));
            }
            if (this.f13930h > 0) {
                sb.append("&total_latency=");
                sb.append(Uri.encode(String.valueOf(this.f13930h)));
            }
            return sb.toString();
        }

        private AsyncTaskC0125a(f fVar, String str, int i4, HashMap<String, Object> hashMap, boolean z3, long j4, long j5) {
            super(true, true);
            this.f13923a = fVar;
            this.f13926d = str;
            this.f13924b = i4;
            this.f13927e = hashMap;
            this.f13928f = z3;
            this.f13929g = j4;
            this.f13930h = j5;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.beizi.ad.internal.utilities.HTTPGet, android.os.AsyncTask
        public void onPostExecute(HTTPResponse hTTPResponse) {
            if (this.f13928f) {
                HaoboLog.i(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.result_cb_ignored));
                return;
            }
            f fVar = this.f13923a;
            if (fVar == null) {
                HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.fire_cb_requester_null));
                return;
            }
            ServerResponse serverResponse = null;
            if (hTTPResponse != null && hTTPResponse.getSucceeded()) {
                serverResponse = new ServerResponse(hTTPResponse, k.NATIVE);
                if (this.f13927e.containsKey("ORIENTATION")) {
                    serverResponse.addToExtras("ORIENTATION", this.f13927e.get("ORIENTATION"));
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
    /* compiled from: MediationNativeAdController.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<a> f13931a;

        public b(a aVar) {
            this.f13931a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f13931a.get();
            if (aVar == null || aVar.f13916e) {
                return;
            }
            HaoboLog.w(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediation_timeout));
            try {
                aVar.a(0);
            } catch (IllegalArgumentException unused) {
            } catch (Throwable th) {
                aVar.f13914c = null;
                throw th;
            }
            aVar.f13914c = null;
        }
    }

    private a(com.beizi.ad.internal.a.a aVar, f fVar, ServerResponse serverResponse) {
        if (aVar == null) {
            HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediated_no_ads));
            this.f13917f = 3;
        } else {
            HaoboLog.d(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.instantiating_class, aVar.a()));
            this.f13913b = fVar;
            this.f13914c = aVar;
            this.f13912a = serverResponse;
            b();
            d();
            try {
                com.beizi.ad.internal.nativead.a.b bVar = (com.beizi.ad.internal.nativead.a.b) Class.forName(aVar.a()).newInstance();
                if (fVar.c() != null) {
                    bVar.a(fVar.c().b(), aVar.e(), aVar.b(), this, fVar.d());
                } else {
                    this.f13917f = 1;
                }
            } catch (ClassCastException e4) {
                a(e4, aVar.a());
            } catch (ClassNotFoundException e5) {
                a(e5, aVar.a());
            } catch (IllegalAccessException e6) {
                a(e6, aVar.a());
            } catch (InstantiationException e7) {
                a(e7, aVar.a());
            } catch (LinkageError e8) {
                a(e8, aVar.a());
            }
        }
        int i4 = this.f13917f;
        if (i4 != -1) {
            a(i4);
        }
    }

    public static a a(com.beizi.ad.internal.a.a aVar, f fVar, ServerResponse serverResponse) {
        return new a(aVar, fVar, serverResponse);
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    private void b(int i4) {
        if (this.f13916e) {
            return;
        }
        f fVar = this.f13913b;
        com.beizi.ad.internal.a.a aVar = this.f13914c;
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
            new AsyncTaskC0125a(this, fVar, this.f13914c.f(), i4, this.f13914c.g(), z3, f(), a(fVar), null).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
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

    private long f() {
        long j4 = this.f13920i;
        if (j4 > 0) {
            long j5 = this.f13921j;
            if (j5 > 0) {
                return j5 - j4;
            }
            return -1L;
        }
        return -1L;
    }

    void c() {
        this.f13919h.removeMessages(0);
    }

    protected void d() {
        this.f13920i = System.currentTimeMillis();
    }

    protected void e() {
        this.f13921j = System.currentTimeMillis();
    }

    private void a(Throwable th, String str) {
        HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediation_instantiation_failure, th.getClass().getSimpleName()));
        if (!StringUtil.isEmpty(str)) {
            HaoboLog.w(HaoboLog.mediationLogTag, String.format("Adding %s to invalid networks list", str));
            h.a().a(k.NATIVE, str);
        }
        this.f13917f = 3;
    }

    protected void a() {
        this.f13914c = null;
        HaoboLog.d(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediation_finish));
    }

    public void a(int i4) {
        if (this.f13915d || this.f13916e) {
            return;
        }
        e();
        c();
        b(i4);
        this.f13916e = true;
        a();
    }

    private long a(f fVar) {
        if (fVar != null) {
            long j4 = this.f13921j;
            if (j4 > 0) {
                return fVar.a(j4);
            }
            return -1L;
        }
        return -1L;
    }

    void b() {
        if (this.f13915d || this.f13916e) {
            return;
        }
        this.f13919h.sendEmptyMessageDelayed(0, 15000L);
    }

    public void a(boolean z3) {
        this.f13918g = z3;
        if (z3) {
            a();
        }
    }
}
