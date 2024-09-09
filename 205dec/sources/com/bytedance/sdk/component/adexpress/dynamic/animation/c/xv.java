package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f29078c;

    private xv() {
    }

    public static xv c() {
        if (f29078c == null) {
            synchronized (xv.class) {
                if (f29078c == null) {
                    f29078c = new xv();
                }
            }
        }
        return f29078c;
    }

    public sr c(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(cVar.gd())) {
            return new k(view, cVar);
        }
        if ("translate".equals(cVar.gd())) {
            return new ys(view, cVar);
        }
        if ("ripple".equals(cVar.gd())) {
            return new ev(view, cVar);
        }
        if ("marquee".equals(cVar.gd())) {
            return new r(view, cVar);
        }
        if ("waggle".equals(cVar.gd())) {
            return new fp(view, cVar);
        }
        if ("shine".equals(cVar.gd())) {
            return new a(view, cVar);
        }
        if ("swing".equals(cVar.gd())) {
            return new t(view, cVar);
        }
        if ("fade".equals(cVar.gd())) {
            return new c(view, cVar);
        }
        if ("rubIn".equals(cVar.gd())) {
            return new p(view, cVar);
        }
        if ("rotate".equals(cVar.gd())) {
            return new gd(view, cVar);
        }
        if ("cutIn".equals(cVar.gd())) {
            return new f(view, cVar);
        }
        if ("stretch".equals(cVar.gd())) {
            return new bk(view, cVar);
        }
        if ("bounce".equals(cVar.gd())) {
            return new ux(view, cVar);
        }
        return null;
    }
}
