package com.amap.api.col.p0463l;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3l.c7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MarkInfoManager {

    /* renamed from: a */
    static WeakReference<LogConfig> f3743a;

    /* compiled from: MarkInfoManager.java */
    /* renamed from: com.amap.api.col.3l.c7$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class RunnableC1756a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f3744a;

        /* renamed from: b */
        final /* synthetic */ Context f3745b;

        RunnableC1756a(String str, Context context) {
            this.f3744a = str;
            this.f3745b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (MarkInfoManager.class) {
                try {
                    String m54585b = C1849l4.m54585b(C1925p4.m54189o(this.f3744a));
                    LogConfig m54750a = Utils.m54750a(MarkInfoManager.f3743a);
                    Utils.m54745f(this.f3745b, m54750a, Log.f5127j, 50, AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    if (m54750a.f3558e == null) {
                        m54750a.f3558e = new Base64EncryptProcessor(new RSAAESEncryptProcessor(new GZipEncryptProcessor()));
                    }
                    String m54201c = C1925p4.m54201c(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                    LogEngine.m55539c(m54585b, C1925p4.m54189o(" \"timestamp\":\"" + m54201c + "\",\"details\":" + this.f3744a), m54750a);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m55447a(String str, Context context) {
        SDKLogHandler.m53861r().submit(new RunnableC1756a(str, context));
    }
}
