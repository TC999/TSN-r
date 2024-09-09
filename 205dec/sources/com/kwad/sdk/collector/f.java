package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    @Nullable
    public static JSONArray Ay() {
        Context context = ServiceProvider.getContext();
        List<g> aL = aL(context);
        aL.add(aK(context));
        return g.t(aL);
    }

    private static g aK(Context context) {
        boolean cr = am.cr(context);
        com.kwad.sdk.core.e.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + cr);
        return new g("android.permission.BIND_ACCESSIBILITY_SERVICE", cr ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    @NonNull
    private static List<g> aL(Context context) {
        String[] cq;
        int i4;
        ArrayList arrayList = new ArrayList();
        if (context != null && (cq = aj.cq(context)) != null) {
            for (String str : cq) {
                int aq = am.aq(context, str);
                if (aq == 0) {
                    i4 = g.PERMISSION_GRANTED;
                } else if (aq == -1) {
                    i4 = g.PERMISSION_DENIED;
                } else {
                    i4 = g.anC;
                }
                arrayList.add(new g(str, i4));
            }
        }
        return arrayList;
    }
}
