package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class w {
    private final e aMP;
    private final boolean aMQ;

    public w(e eVar) {
        this.aMP = eVar;
        if (eVar instanceof f) {
            this.aMQ = false;
        } else {
            this.aMQ = true;
        }
    }

    private List<? extends t> gm(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aMP.am("tEXt", str));
        arrayList.addAll(this.aMP.am("zTXt", str));
        arrayList.addAll(this.aMP.am("iTXt", str));
        return arrayList;
    }

    public final String gn(String str) {
        List<? extends t> gm = gm(str);
        if (gm.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (t tVar : gm) {
            sb.append(tVar.Kx());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
