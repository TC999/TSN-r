package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.bytedance.msdk.adapter.util.Logger;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdvertisingIdHelper {

    /* renamed from: c */
    private static volatile AdvertisingIdHelper f651c;

    /* renamed from: a */
    private String f652a = "";

    /* renamed from: b */
    private final ExecutorService f653b = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingIdHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.f$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class CallableC0987b implements Callable<String> {
        private CallableC0987b() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(InternalContainer.m59945d());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    Logger.m37562d("gaid-", "getAdvertisingId: " + id);
                    AdvertisingIdHelper.m59230b(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(InternalContainer.m59945d());
                if (advertisingIdInfo2 != null) {
                    AdvertisingIdHelper.this.f652a = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            Logger.m37562d("AdvertisingIdHelper", "mGAId:" + AdvertisingIdHelper.this.f652a + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return AdvertisingIdHelper.this.f652a;
        }
    }

    private AdvertisingIdHelper() {
    }

    /* renamed from: c */
    public static AdvertisingIdHelper m59229c() {
        if (f651c == null) {
            synchronized (AdvertisingIdHelper.class) {
                if (f651c == null) {
                    f651c = new AdvertisingIdHelper();
                }
            }
        }
        return f651c;
    }

    /* renamed from: b */
    public String m59231b() {
        try {
            this.f652a = SPUtils.m59131a("tt_device_info", InternalContainer.m59945d()).m59130a("gaid", "");
            Logger.m37554i("gaid-", "getGAIdTimeOut-mGAId=" + this.f652a);
            if (TextUtils.isEmpty(this.f652a)) {
                this.f653b.execute(new FutureTask(new CallableC0987b()));
            }
        } catch (Throwable unused) {
        }
        return this.f652a;
    }

    /* renamed from: a */
    public String m59235a() {
        try {
            this.f652a = SPUtils.m59131a("tt_device_info", InternalContainer.m59945d()).m59130a("gaid", "");
            Logger.m37554i("gaid-", "getGAIdTimeOut-mGAId=" + this.f652a);
            if (TextUtils.isEmpty(this.f652a)) {
                FutureTask futureTask = new FutureTask(new CallableC0987b());
                this.f653b.execute(futureTask);
                this.f652a = (String) futureTask.get(500000L, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable unused) {
        }
        return this.f652a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m59230b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SPUtils.m59131a("tt_device_info", InternalContainer.m59945d()).m59123b("gaid", str);
    }
}
