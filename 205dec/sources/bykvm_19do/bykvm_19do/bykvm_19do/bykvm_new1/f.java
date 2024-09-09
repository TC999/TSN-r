package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: AdvertisingIdHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static volatile f f644c;

    /* renamed from: a  reason: collision with root package name */
    private String f645a = "";

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f646b = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingIdHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Callable<String> {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    Logger.d("gaid-", "getAdvertisingId: " + id);
                    f.b(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
                if (advertisingIdInfo2 != null) {
                    f.this.f645a = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            Logger.d("AdvertisingIdHelper", "mGAId:" + f.this.f645a + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return f.this.f645a;
        }
    }

    private f() {
    }

    public static f c() {
        if (f644c == null) {
            synchronized (f.class) {
                if (f644c == null) {
                    f644c = new f();
                }
            }
        }
        return f644c;
    }

    public String b() {
        try {
            this.f645a = r.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "");
            Logger.i("gaid-", "getGAIdTimeOut-mGAId=" + this.f645a);
            if (TextUtils.isEmpty(this.f645a)) {
                this.f646b.execute(new FutureTask(new b()));
            }
        } catch (Throwable unused) {
        }
        return this.f645a;
    }

    public String a() {
        try {
            this.f645a = r.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "");
            Logger.i("gaid-", "getGAIdTimeOut-mGAId=" + this.f645a);
            if (TextUtils.isEmpty(this.f645a)) {
                FutureTask futureTask = new FutureTask(new b());
                this.f646b.execute(futureTask);
                this.f645a = (String) futureTask.get(500000L, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable unused) {
        }
        return this.f645a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        r.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).b(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, str);
    }
}
