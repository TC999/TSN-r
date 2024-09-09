package com.kwad.components.ad.reward;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n {
    public static void a(int i4, int i5, g gVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i4 == 0) {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
        } else if (i4 == 1) {
            if (i5 == 0) {
                if (gVar.pr.jB()) {
                    com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
                }
            } else if (gVar.pr.jB()) {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 5);
            } else {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 4);
            }
        } else if (i4 != 2) {
        } else {
            if (i5 == 0) {
                if (gVar.pq.jB()) {
                    com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
                }
            } else if (gVar.pq.jB()) {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 3);
            } else {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 2);
            }
        }
    }
}
