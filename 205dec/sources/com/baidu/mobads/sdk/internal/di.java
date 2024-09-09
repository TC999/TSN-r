package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class di implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RelativeLayout f12760a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ de f12761b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(de deVar, RelativeLayout relativeLayout) {
        this.f12761b = deVar;
        this.f12760a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z3) {
        if (z3) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.f12761b.f12481h);
            hashMap.put("banner_container", this.f12760a);
            hashMap.put("entry", Integer.valueOf(this.f12761b.D));
            hashMap.put("channelId", Integer.valueOf(this.f12761b.E));
            hashMap.put("novel_id", this.f12761b.F);
            hashMap.put("isnight", Boolean.valueOf(this.f12761b.x()));
            this.f12761b.a("request_bookstore_bottom_view", hashMap);
        }
    }
}
