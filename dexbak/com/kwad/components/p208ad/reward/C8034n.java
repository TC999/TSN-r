package com.kwad.components.p208ad.reward;

import com.kwad.components.p208ad.reward.model.C8028c;
import com.kwad.sdk.core.adlog.C9908c;

/* renamed from: com.kwad.components.ad.reward.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8034n {
    /* renamed from: a */
    public static void m31744a(int i, int i2, C7907g c7907g, C8028c c8028c) {
        if (i == 0) {
            C9908c.m27293l(c8028c.getAdTemplate(), 1);
        } else if (i == 1) {
            if (i2 == 0) {
                if (c7907g.f26569pr.m31884jB()) {
                    C9908c.m27293l(c8028c.getAdTemplate(), 1);
                }
            } else if (c7907g.f26569pr.m31884jB()) {
                C9908c.m27293l(c8028c.getAdTemplate(), 5);
            } else {
                C9908c.m27293l(c8028c.getAdTemplate(), 4);
            }
        } else if (i != 2) {
        } else {
            if (i2 == 0) {
                if (c7907g.f26568pq.m31876jB()) {
                    C9908c.m27293l(c8028c.getAdTemplate(), 1);
                }
            } else if (c7907g.f26568pq.m31876jB()) {
                C9908c.m27293l(c8028c.getAdTemplate(), 3);
            } else {
                C9908c.m27293l(c8028c.getAdTemplate(), 2);
            }
        }
    }
}
