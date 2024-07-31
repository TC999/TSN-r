package com.kwad.sdk.utils.p450a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11122q;
import com.kwad.sdk.utils.p450a.C10990c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.kwad.sdk.utils.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10999e {
    static ExecutorService aJs = Executors.newSingleThreadExecutor();
    static boolean aPh = m24177NO();

    /* renamed from: NO */
    private static boolean m24177NO() {
        C10998d.setExecutor(aJs);
        C10998d.m24178a(new C10990c.InterfaceC10996d() { // from class: com.kwad.sdk.utils.a.e.1
            @Override // com.kwad.sdk.utils.p450a.C10990c.InterfaceC10996d
            /* renamed from: a */
            public final void mo24175a(String str, Exception exc) {
                C10331c.m26246w("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.p450a.C10990c.InterfaceC10996d
            /* renamed from: e */
            public final void mo24174e(String str, Throwable th) {
                C10331c.m26250e("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.p450a.C10990c.InterfaceC10996d
            /* renamed from: i */
            public final void mo24173i(String str, String str2) {
                C10331c.m26248i("UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        aPh = true;
        return true;
    }

    /* renamed from: av */
    public static C10990c m24176av(@NonNull Context context, String str) {
        if (!aPh) {
            m24177NO();
        }
        return new C10990c.C10993a(C11122q.m23747N(context, "ks_union"), str).m24183NM();
    }
}
