package com.bytedance.sdk.component.ux.sr;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends c {
    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        List<com.bytedance.sdk.component.ux.xv.xv> list;
        String ls = xvVar.ls();
        Map<String, List<com.bytedance.sdk.component.ux.xv.xv>> r3 = xvVar.u().r();
        synchronized (r3) {
            list = r3.get(ls);
            if (list == null) {
                list = new LinkedList<>();
            }
        }
        synchronized (list) {
            list.add(xvVar);
            r3.put(ls, list);
            if (list.size() <= 1) {
                xvVar.c(new sr());
            }
        }
    }
}
