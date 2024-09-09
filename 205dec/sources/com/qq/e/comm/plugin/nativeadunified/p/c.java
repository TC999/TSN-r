package com.qq.e.comm.plugin.nativeadunified.p;

import android.content.Context;
import android.view.View;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.nativeadunified.g;
import com.qq.e.comm.plugin.o0.h.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    public static b a(Context context, g gVar, VideoOption videoOption, a.d dVar, f.p pVar, com.qq.e.comm.plugin.nativeadunified.e eVar, View.OnTouchListener onTouchListener, MediaView mediaView) {
        if (!gVar.l1()) {
            return new f(context, gVar, eVar, mediaView);
        }
        boolean z3 = (com.qq.e.comm.plugin.t.a.b().a(gVar.p0(), "nunrcfg", 3) & 1) == 1;
        if (gVar.i0() != null && z3) {
            e eVar2 = new e(context, gVar, videoOption, dVar, pVar, eVar, onTouchListener, mediaView);
            if (eVar2.q()) {
                return eVar2;
            }
        }
        return new d(context, gVar, videoOption, dVar, pVar, eVar, onTouchListener, mediaView);
    }
}
