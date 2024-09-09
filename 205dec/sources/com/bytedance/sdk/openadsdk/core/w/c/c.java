package com.bytedance.sdk.openadsdk.core.w.c;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    protected me f35278c;
    protected View sr;

    /* renamed from: w  reason: collision with root package name */
    protected Context f35279w;
    protected gd xv;

    public void c(gd gdVar) {
        this.xv = gdVar;
    }

    public abstract boolean c(Map<String, Object> map);

    public void c(View view) {
        this.sr = view;
    }
}
