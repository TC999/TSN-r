package com.amap.api.col.p0463l;

import android.content.Context;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.3l.f5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdiuManager {

    /* renamed from: c */
    private static AdiuManager f4159c;

    /* renamed from: a */
    private final Context f4160a;

    /* renamed from: b */
    private final String f4161b = SecurityUtil.m54524d(C1925p4.m54183u("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private AdiuManager(Context context) {
        this.f4160a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    public static AdiuManager m55028a(Context context) {
        if (f4159c == null) {
            synchronized (AdiuManager.class) {
                if (f4159c == null) {
                    f4159c = new AdiuManager(context);
                }
            }
        }
        return f4159c;
    }

    /* renamed from: b */
    public final synchronized void m55027b() {
        try {
            if (DeviceInfo.m54758z() == null) {
                DeviceInfo.m54767q(NetReuestParam.m54661a());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public final void m55026c(String str) {
        AdiuStorageModel.m54920b(this.f4160a).m54918d(this.f4161b);
        AdiuStorageModel.m54920b(this.f4160a).m54915g(str);
    }
}
