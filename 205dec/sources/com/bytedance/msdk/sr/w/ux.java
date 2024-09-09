package com.bytedance.msdk.sr.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.api.sr.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends r {
        public c(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar) {
            super(wVar);
        }

        @Override // com.bytedance.msdk.sr.w.r
        public boolean c() {
            int au = com.bytedance.msdk.core.c.w().au();
            if (au > 0) {
                return true;
            }
            if (au < 0) {
                return false;
            }
            return super.c();
        }

        @Override // com.bytedance.msdk.sr.w.r
        public boolean w() {
            int bj = com.bytedance.msdk.core.c.w().bj();
            if (bj > 0) {
                return false;
            }
            if (bj < 0) {
                return true;
            }
            return super.w();
        }
    }

    public static void c(b bVar) {
        com.bytedance.sdk.openadsdk.ys.w.xv.c cVar = new com.bytedance.sdk.openadsdk.ys.w.xv.c(com.bytedance.msdk.core.w.k().up());
        bVar.h(8475, c(cVar.a()));
        bVar.h(8457, c(cVar.ys()));
        bVar.j(1, cVar.ev());
    }

    public static ValueSet c(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c cVar) {
        if (cVar != null) {
            b a4 = b.a();
            a4.j(8458, cVar.ux());
            a4.i(8459, cVar.k());
            a4.i(8460, cVar.c());
            a4.j(8461, cVar.w());
            a4.h(8310, new ev(cVar.xv()));
            a4.h(8462, cVar.sr());
            a4.h(8463, cVar.f());
            a4.i(8464, cVar.r());
            a4.j(8465, cVar.ev());
            a4.j(8466, cVar.gd());
            a4.j(8467, cVar.p());
            return a4.l();
        }
        return null;
    }

    public static ValueSet c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        b a4 = b.a();
        if (srVar != null) {
            a4.h(8311, new c(srVar.bk()));
            a4.j(8023, srVar.xv());
            a4.j(8024, srVar.c());
            a4.j(8025, srVar.ux());
            a4.j(8026, srVar.w());
            a4.j(8480, srVar.sr());
            a4.j(8479, srVar.f());
            a4.h(8312, new f(srVar.ev()));
            a4.h(8483, srVar.ev());
            a4.i(8484, srVar.gd());
            a4.i(8485, srVar.a());
            a4.i(8486, srVar.k());
            a4.i(8487, srVar.p());
            a4.j(8549, srVar.r());
        } else {
            a4.h(8311, new c(null));
            a4.j(8023, true);
            a4.j(8024, true);
            a4.j(8025, true);
            a4.j(8026, true);
            a4.j(8480, true);
            a4.j(8479, true);
            a4.h(8312, new f(null));
            a4.h(8483, new ValueSet.ValueGetter<com.bytedance.sdk.openadsdk.ys.w.xv.xv>() { // from class: com.bytedance.msdk.sr.w.ux.1
                @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
                /* renamed from: c */
                public com.bytedance.sdk.openadsdk.ys.w.xv.xv get() {
                    return null;
                }
            });
            a4.i(8484, "");
            a4.i(8485, "");
            a4.i(8486, "");
            a4.i(8487, "");
            a4.j(8549, true);
        }
        return a4.l();
    }

    public static void c() {
        gd.c(new com.bytedance.sdk.openadsdk.ys.w.xv.c(com.bytedance.msdk.core.w.k().up()).a());
    }
}
