package com.bytedance.adsdk.ugeno.component.scroll;

import android.content.Context;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.component.a;
import com.bytedance.adsdk.ugeno.component.frame.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.adsdk.ugeno.component.a<ScrollView> {
    public a(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public ScrollView xv() {
        UGScrollView uGScrollView = new UGScrollView(this.f26040w);
        uGScrollView.a(this);
        return uGScrollView;
    }

    @Override // com.bytedance.adsdk.ugeno.component.a
    public a.C0358a c() {
        return new a.C0361a();
    }
}
