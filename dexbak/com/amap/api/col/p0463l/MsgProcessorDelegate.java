package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.NativeCrashHandler;
import com.amap.api.col.p0463l.SDKInfo;
import com.stub.StubApp;
import java.util.List;

/* renamed from: com.amap.api.col.3l.w5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MsgProcessorDelegate {

    /* renamed from: a */
    private Context f5631a;

    /* renamed from: b */
    private SDKInfo f5632b;

    /* renamed from: c */
    private boolean f5633c = true;

    /* renamed from: d */
    private String f5634d = "40C27E38DCAD404B5465362914090908";

    /* renamed from: e */
    private SDKSPUtil f5635e = new SDKSPUtil("40C27E38DCAD404B5465362914090908");

    /* renamed from: a */
    public final void m53586a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            SDKInfo m54389c = new SDKInfo.C1869a(str, str2, str).m54390b(strArr).m54391a(str3).m54389c();
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f5631a = origApplicationContext;
                this.f5632b = m54389c;
                this.f5633c = z;
                this.f5635e.m53320c(origApplicationContext, m54389c);
            }
        } catch (AMapCoreException unused) {
        }
    }

    /* renamed from: b */
    public final void m53585b(String str, String str2) {
        List<SDKInfo> m53321b = this.f5635e.m53321b(this.f5631a);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.C1986a.f5681a;
        NativeCrashHandler.m53524b(this.f5631a, str, str2, m53321b, this.f5633c, this.f5632b);
    }
}
