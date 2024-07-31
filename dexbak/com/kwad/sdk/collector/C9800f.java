package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11016aj;
import com.kwad.sdk.utils.C11020am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.kwad.sdk.collector.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9800f {
    @Nullable
    /* renamed from: Ay */
    public static JSONArray m27754Ay() {
        Context context = ServiceProvider.getContext();
        List<C9801g> m27752aL = m27752aL(context);
        m27752aL.add(m27753aK(context));
        return C9801g.m27750t(m27752aL);
    }

    /* renamed from: aK */
    private static C9801g m27753aK(Context context) {
        boolean m24096cr = C11020am.m24096cr(context);
        C10331c.m26254d("InfoCollector", "queryAccessibilityServicePermission result: " + m24096cr);
        return new C9801g(C7282g.f24953k, m24096cr ? C9801g.PERMISSION_GRANTED : C9801g.PERMISSION_DENIED);
    }

    @NonNull
    /* renamed from: aL */
    private static List<C9801g> m27752aL(Context context) {
        String[] m24116cq;
        int i;
        ArrayList arrayList = new ArrayList();
        if (context != null && (m24116cq = C11016aj.m24116cq(context)) != null) {
            for (String str : m24116cq) {
                int m24099aq = C11020am.m24099aq(context, str);
                if (m24099aq == 0) {
                    i = C9801g.PERMISSION_GRANTED;
                } else if (m24099aq == -1) {
                    i = C9801g.PERMISSION_DENIED;
                } else {
                    i = C9801g.anC;
                }
                arrayList.add(new C9801g(str, i));
            }
        }
        return arrayList;
    }
}
