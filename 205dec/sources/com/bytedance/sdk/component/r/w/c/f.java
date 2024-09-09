package com.bytedance.sdk.component.r.w.c;

import com.acse.ottn.f3;
import com.bytedance.sdk.component.r.w.c.w.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements ux {

    /* renamed from: c  reason: collision with root package name */
    private List<com.bytedance.sdk.component.r.w.c.w.c> f30066c = new ArrayList();

    public f(Queue<String> queue, com.bytedance.sdk.component.r.c.ux uxVar) {
        com.bytedance.sdk.component.r.w.sr.w.c ev;
        if (com.bytedance.sdk.component.r.w.w.c.c(uxVar)) {
            this.f30066c.add(new com.bytedance.sdk.component.r.w.c.w.xv(uxVar.r(), queue, uxVar));
        }
        if (com.bytedance.sdk.component.r.w.w.c.ux(uxVar)) {
            uxVar.ev();
            if (uxVar.c() != null) {
                ev = uxVar.c();
            } else {
                ev = uxVar.ev();
            }
            this.f30066c.add(new com.bytedance.sdk.component.r.w.c.w.sr(ev, queue, uxVar));
        }
        if (com.bytedance.sdk.component.r.w.w.c.w(uxVar)) {
            this.f30066c.add(new com.bytedance.sdk.component.r.w.c.w.ux(uxVar.ev(), queue, uxVar));
        }
        if (com.bytedance.sdk.component.r.w.w.c.xv(uxVar)) {
            this.f30066c.add(new com.bytedance.sdk.component.r.w.c.w.f(uxVar.ev(), queue, uxVar));
        }
        if (com.bytedance.sdk.component.r.w.w.c.sr(uxVar)) {
            this.f30066c.add(new com.bytedance.sdk.component.r.w.c.w.w(uxVar.gd(), queue, uxVar));
        }
        if (com.bytedance.sdk.component.r.w.w.c.f(uxVar)) {
            this.f30066c.add(new r(uxVar.f(), queue, uxVar));
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public void c(com.bytedance.sdk.component.r.c.w wVar, int i4) {
        for (com.bytedance.sdk.component.r.w.c.w.c cVar : this.f30066c) {
            cVar.w(wVar);
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public w c(int i4, List<com.bytedance.sdk.component.r.c.w> list) {
        w wVar = null;
        for (com.bytedance.sdk.component.r.w.c.w.c cVar : this.f30066c) {
            wVar = cVar.c(i4, list);
            if (wVar.c()) {
                break;
            }
        }
        return wVar;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list) {
        for (com.bytedance.sdk.component.r.w.c.w.c cVar : this.f30066c) {
            List<com.bytedance.sdk.component.r.c.w> c4 = cVar.c(i4, wVar, list, f3.f5657f);
            if (c4 != null && c4.size() != 0) {
                return c4;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public boolean c(int i4, boolean z3, String str, com.bytedance.sdk.component.r.c.w wVar) {
        for (com.bytedance.sdk.component.r.w.c.w.c cVar : this.f30066c) {
            if (cVar.c(i4, str, wVar)) {
                return true;
            }
        }
        return false;
    }
}
