package com.kwad.components.core.video;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.videocache.p415c.C10562a;
import com.kwad.sdk.utils.C11010ad;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.components.core.video.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9000j {

    /* renamed from: UY */
    private static Map<String, Integer> f29013UY = new ConcurrentHashMap();

    /* renamed from: a */
    public static boolean m29410a(@NonNull String str, String str2, C10404a.C10405a c10405a) {
        String m24144bu = C11010ad.m24144bu(str2);
        long currentTimeMillis = System.currentTimeMillis();
        C10331c.m26248i("VideoCacheHelper", "start cache video key:" + m24144bu + "--url:" + str);
        boolean m26392b = C10291a.m26395Dc().m26392b(str, str2, c10405a);
        long currentTimeMillis2 = System.currentTimeMillis();
        C10331c.m26248i("VideoCacheHelper", "finish cache video key:" + m24144bu + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + m26392b);
        return m26392b;
    }

    /* renamed from: aE */
    private static int m29409aE(String str) {
        Integer num = f29013UY.get(str);
        if (num != null) {
            return num.intValue();
        }
        return C10251d.m26500yU();
    }

    /* renamed from: ax */
    public static boolean m29408ax(@NonNull AdTemplate adTemplate) {
        File m26391bV = C10291a.m26395Dc().m26391bV(C10483a.m25977K(C10487e.m25641dQ(adTemplate)));
        return m26391bV != null && m26391bV.exists();
    }

    /* renamed from: f */
    public static String m29407f(Context context, @NonNull AdTemplate adTemplate) {
        return m29411a(context, C10487e.m25625eg(adTemplate), C10483a.m25977K(C10487e.m25641dQ(adTemplate)));
    }

    /* renamed from: n */
    public static void m29405n(String str, int i) {
        f29013UY.put(str, Integer.valueOf(i));
    }

    /* renamed from: f */
    public static String m29406f(Context context, String str) {
        return m29411a(context, m29409aE(str), str);
    }

    /* renamed from: a */
    private static String m29411a(Context context, int i, String str) {
        if (i >= 0) {
            return i > 0 ? C10562a.m25468bl(context).m25441eA(str) : str;
        }
        File m26391bV = C10291a.m26395Dc().m26391bV(str);
        return (m26391bV == null || !m26391bV.exists()) ? str : m26391bV.getAbsolutePath();
    }
}
