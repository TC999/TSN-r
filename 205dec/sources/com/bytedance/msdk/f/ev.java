package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {
    private static volatile ev xv;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f28313c = "";

    /* renamed from: w  reason: collision with root package name */
    private volatile ExecutorService f28314w = com.bytedance.msdk.adapter.sr.f.c(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.f.ev.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c implements Callable<String> {
        private c() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.c.getContext());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.msdk.adapter.sr.xv.c("gaid-", "getAdvertisingId: " + id);
                    ev.w(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.c.getContext());
                if (advertisingIdInfo2 != null) {
                    ev.this.f28313c = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            com.bytedance.msdk.adapter.sr.xv.c("AdvertisingIdHelper", "mGAId:" + ev.this.f28313c + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return ev.this.f28313c;
        }
    }

    private ev() {
    }

    public String w() {
        try {
            this.f28313c = wv.c("tt_device_info", com.bytedance.msdk.core.c.getContext()).w(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "");
            com.bytedance.msdk.adapter.sr.xv.c(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "--==-- getGAIdTimeOut-mGAId = " + this.f28313c);
            if (TextUtils.isEmpty(this.f28313c)) {
                synchronized (this) {
                    if (this.f28314w != null) {
                        FutureTask futureTask = new FutureTask(new c());
                        this.f28314w.execute(futureTask);
                        this.f28313c = (String) futureTask.get(1L, TimeUnit.MICROSECONDS);
                        if (!TextUtils.isEmpty(this.f28313c)) {
                            this.f28314w.shutdown();
                            this.f28314w = null;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.f28313c;
    }

    public synchronized void xv() {
        try {
            this.f28313c = wv.c("tt_device_info", com.bytedance.msdk.core.c.getContext()).w(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "");
            com.bytedance.msdk.adapter.sr.xv.c(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "--==-- initGAIdByAsyc-mGAId = " + this.f28313c);
            if (TextUtils.isEmpty(this.f28313c) && this.f28314w != null) {
                this.f28314w.execute(new FutureTask(new c()));
            }
        } catch (Throwable unused) {
        }
    }

    public static ev c() {
        if (xv == null) {
            synchronized (ev.class) {
                if (xv == null) {
                    xv = new ev();
                }
            }
        }
        return xv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        wv.c("tt_device_info", com.bytedance.msdk.core.c.getContext()).c(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, str);
    }
}
