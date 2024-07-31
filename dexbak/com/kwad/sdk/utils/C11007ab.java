package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.C11008ac;

/* renamed from: com.kwad.sdk.utils.ab */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11007ab {
    @WorkerThread
    /* renamed from: a */
    public static String m24157a(Context context, String str, C11008ac.C11009a c11009a, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String m24155am = C11008ac.m24155am(context, C11008ac.m24156a(str, c11009a));
        String m24031cx = C11029av.m24031cx(context);
        if (!TextUtils.isEmpty(m24031cx)) {
            m24155am = m24155am.replace("__MAC__", m24031cx).replace("__MAC2__", C11010ad.m24144bu(m24031cx)).replace("__MAC3__", C11010ad.m24144bu(m24031cx.replace(":", "")));
        }
        String m24033cv = C11029av.m24033cv(context);
        if (!TextUtils.isEmpty(m24033cv)) {
            m24155am = m24155am.replace("__IMEI__", m24033cv).replace("__IMEI2__", C11010ad.m24144bu(m24033cv)).replace("__IMEI3__", C11010ad.m24143gy(m24033cv));
        }
        String oaid = C11029av.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            m24155am = m24155am.replace("__OAID__", oaid).replace("__OAID2__", C11010ad.m24144bu(oaid));
        }
        String m24032cw = C11029av.m24032cw(context);
        if (!TextUtils.isEmpty(m24032cw)) {
            m24155am = m24155am.replace("__ANDROIDID2__", C11010ad.m24144bu(m24032cw)).replace("__ANDROIDID3__", C11010ad.m24143gy(m24032cw)).replace("__ANDROIDID__", m24032cw);
        }
        return C11008ac.m24154c(context, m24155am, z);
    }
}
