package com.bytedance.sdk.openadsdk.core.w.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.u.gd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    private View sr;
    private gd xv;

    /* renamed from: c  reason: collision with root package name */
    private List<c> f35353c = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Object> f35354w = new HashMap();

    public void c(View view) {
        this.sr = view;
    }

    public void c(c cVar) {
        this.f35353c.add(cVar);
    }

    public void c(gd gdVar) {
        this.xv = gdVar;
        for (c cVar : this.f35353c) {
            cVar.c(this.xv);
        }
    }

    public void c() {
        for (c cVar : this.f35353c) {
            cVar.c(this.sr);
            if (cVar.c(this.f35354w)) {
                return;
            }
        }
    }
}
