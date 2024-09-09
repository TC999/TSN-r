package com.kwad.sdk.ranger;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.ranger.c;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull c cVar) {
        final List<c.a> list = cVar.aNl;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.ranger.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String e(Object obj, String str) {
        Object field;
        return (TextUtils.isEmpty(str) || (field = s.getField(obj, str)) == null) ? "" : field.getClass().getName();
    }

    static void a(Activity activity, @NonNull List<c.a> list) {
        try {
            for (c.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.aNn)) {
                        str = aVar.aNn;
                    } else if (!TextUtils.isEmpty(aVar.aNo) && activity.getClass().getName().startsWith(aVar.aNn)) {
                        str = e(activity, aVar.aNo);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int b4 = y.b("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        y.a("ksadsdk_perf_ranger_v2", str, b4);
                        String str2 = TAG;
                        com.kwad.sdk.core.e.c.d(str2, "act:" + str + " num:" + b4);
                    }
                }
            }
        } catch (Throwable th) {
            String str3 = TAG;
            com.kwad.sdk.core.e.c.e(str3, "record:" + Log.getStackTraceString(th));
        }
    }
}
