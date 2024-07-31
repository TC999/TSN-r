package com.kwad.sdk.ranger;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.ranger.C10957c;
import com.kwad.sdk.utils.C11124s;
import com.kwad.sdk.utils.C11137y;
import java.util.List;

/* renamed from: com.kwad.sdk.ranger.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10944a {
    public static final String TAG = "Ranger_" + C10949b.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m24395a(@NonNull C10957c c10957c) {
        final List<C10957c.C10958a> list = c10957c.aNl;
        if (list == null || list.isEmpty()) {
            return;
        }
        C10232b.m26625DD();
        C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.ranger.a.1
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            /* renamed from: onActivityCreated */
            public final void mo24393a(Activity activity, Bundle bundle) {
                super.mo24393a(activity, bundle);
                try {
                    C10944a.m24396a(activity, list);
                } catch (Throwable th) {
                    C10331c.m26250e(C10944a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    /* renamed from: e */
    private static String m24394e(Object obj, String str) {
        Object field;
        return (TextUtils.isEmpty(str) || (field = C11124s.getField(obj, str)) == null) ? "" : field.getClass().getName();
    }

    /* renamed from: a */
    static void m24396a(Activity activity, @NonNull List<C10957c.C10958a> list) {
        try {
            for (C10957c.C10958a c10958a : list) {
                if (c10958a != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), c10958a.aNn)) {
                        str = c10958a.aNn;
                    } else if (!TextUtils.isEmpty(c10958a.aNo) && activity.getClass().getName().startsWith(c10958a.aNn)) {
                        str = m24394e(activity, c10958a.aNo);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int m23590b = C11137y.m23590b("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        C11137y.m23612a("ksadsdk_perf_ranger_v2", str, m23590b);
                        String str2 = TAG;
                        C10331c.m26254d(str2, "act:" + str + " num:" + m23590b);
                    }
                }
            }
        } catch (Throwable th) {
            String str3 = TAG;
            C10331c.m26250e(str3, "record:" + Log.getStackTraceString(th));
        }
    }
}
