package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.u uVar, ev evVar, View view, View view2, RecyclerView.gd gdVar, boolean z3, boolean z4) {
        if (gdVar.i() == 0 || uVar.sr() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z4 ? Math.max(0, (uVar.sr() - Math.max(gdVar.sr(view), gdVar.sr(view2))) - 1) : Math.max(0, Math.min(gdVar.sr(view), gdVar.sr(view2)));
        if (z3) {
            return Math.round((max * (Math.abs(evVar.w(view2) - evVar.c(view)) / (Math.abs(gdVar.sr(view) - gdVar.sr(view2)) + 1))) + (evVar.xv() - evVar.c(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(RecyclerView.u uVar, ev evVar, View view, View view2, RecyclerView.gd gdVar, boolean z3) {
        if (gdVar.i() == 0 || uVar.sr() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return uVar.sr();
        }
        return (int) (((evVar.w(view2) - evVar.c(view)) / (Math.abs(gdVar.sr(view) - gdVar.sr(view2)) + 1)) * uVar.sr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.u uVar, ev evVar, View view, View view2, RecyclerView.gd gdVar, boolean z3) {
        if (gdVar.i() == 0 || uVar.sr() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return Math.abs(gdVar.sr(view) - gdVar.sr(view2)) + 1;
        }
        return Math.min(evVar.f(), evVar.w(view2) - evVar.c(view));
    }
}
