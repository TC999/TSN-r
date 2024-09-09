package com.bytedance.sdk.openadsdk.core.k;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.c.w.r;
import com.bytedance.sdk.component.adexpress.c.xv.sr;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static void c(List<me> list, final r.c cVar) {
        if (cVar == null) {
            return;
        }
        if (list != null && list.size() > 0) {
            ArrayList<sr> arrayList = new ArrayList();
            for (me meVar : list) {
                if (meVar != null && (meVar.rh() == null || !meVar.rh().a())) {
                    sr lw = meVar.lw();
                    if (lw != null || (lw = meVar.kn()) != null) {
                        arrayList.add(lw);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                cVar.w();
                return;
            }
            for (sr srVar : arrayList) {
                String str = srVar.f29053f;
                final String str2 = srVar.f29052c;
                final String str3 = srVar.xv;
                final String str4 = srVar.f29054w;
                final String str5 = srVar.sr;
                final String str6 = srVar.ux;
                final String r3 = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.c.c.c.c().xv() != null ? com.bytedance.sdk.component.adexpress.c.c.c.c().xv().r() : "" : str;
                ev.c(new p("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        r.c().c(str2, str3, str4, str5, str6, r3, cVar);
                    }
                }, 10);
            }
            return;
        }
        cVar.w();
        cVar.w();
    }
}
