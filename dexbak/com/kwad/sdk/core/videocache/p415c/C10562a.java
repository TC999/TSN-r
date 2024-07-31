package com.kwad.sdk.core.videocache.p415c;

import android.content.Context;
import com.kwad.sdk.core.videocache.C10569f;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.kwad.sdk.core.videocache.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10562a {
    private static C10569f aCC;

    /* renamed from: b */
    public static C10569f m25469b(Context context, int i, int i2) {
        C10569f c10569f = aCC;
        if (c10569f == null) {
            C10569f m25467c = m25467c(context, i, i2);
            aCC = m25467c;
            return m25467c;
        }
        return c10569f;
    }

    /* renamed from: bl */
    public static C10569f m25468bl(Context context) {
        return m25469b(context, 0, 0);
    }

    /* renamed from: c */
    private static C10569f m25467c(Context context, int i, int i2) {
        return new C10569f.C10570a(context).m25430as(IjkMediaMeta.AV_CH_STEREO_LEFT).m25429ds(i).m25428dt(i2).m25432Gr();
    }
}
