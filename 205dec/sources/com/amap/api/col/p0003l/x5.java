package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.y5;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MsgProcessorDelegate.java */
/* renamed from: com.amap.api.col.3l.x5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x5 {

    /* renamed from: a  reason: collision with root package name */
    private Context f9422a;

    /* renamed from: b  reason: collision with root package name */
    private p4 f9423b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9424c = true;

    /* renamed from: d  reason: collision with root package name */
    private String f9425d = "40C27E38DCAD404B5465362914090908";

    /* renamed from: e  reason: collision with root package name */
    private a6 f9426e = new a6("40C27E38DCAD404B5465362914090908");

    /* compiled from: NativeCrashHandler.java */
    /* renamed from: com.amap.api.col.3l.x5$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static x5 f9427a = new x5();
    }

    public final void a(Context context, boolean z3, String str, String str2, String str3, String[] strArr) {
        try {
            p4 c4 = new p4.a(str, str2, str).b(strArr).a(str3).c();
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f9422a = origApplicationContext;
                this.f9423b = c4;
                this.f9424c = z3;
                this.f9426e.c(origApplicationContext, c4);
            }
        } catch (fk unused) {
        }
    }

    public final void b(String str, String str2) {
        List<p4> b4 = this.f9426e.b(this.f9422a);
        y5 y5Var = y5.a.f9523a;
        y5.b(this.f9422a, str, str2, b4, this.f9424c, this.f9423b);
    }
}
