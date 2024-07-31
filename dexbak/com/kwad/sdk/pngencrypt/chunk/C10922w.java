package com.kwad.sdk.pngencrypt.chunk;

import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10922w {
    private final C10902e aMP;
    private final boolean aMQ;

    public C10922w(C10902e c10902e) {
        this.aMP = c10902e;
        if (c10902e instanceof C10905f) {
            this.aMQ = false;
        } else {
            this.aMQ = true;
        }
    }

    /* renamed from: gm */
    private List<? extends AbstractC10919t> m24457gm(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aMP.m24480am("tEXt", str));
        arrayList.addAll(this.aMP.m24480am("zTXt", str));
        arrayList.addAll(this.aMP.m24480am("iTXt", str));
        return arrayList;
    }

    /* renamed from: gn */
    public final String m24456gn(String str) {
        List<? extends AbstractC10919t> m24457gm = m24457gm(str);
        if (m24457gm.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (AbstractC10919t abstractC10919t : m24457gm) {
            sb.append(abstractC10919t.m24459Kx());
            sb.append(ShellAdbUtils.f33810d);
        }
        return sb.toString().trim();
    }
}
