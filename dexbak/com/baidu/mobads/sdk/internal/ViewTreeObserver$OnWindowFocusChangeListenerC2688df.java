package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.df */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewTreeObserver$OnWindowFocusChangeListenerC2688df implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ RelativeLayout f8949a;

    /* renamed from: b */
    final /* synthetic */ C2684db f8950b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnWindowFocusChangeListenerC2688df(C2684db c2684db, RelativeLayout relativeLayout) {
        this.f8950b = c2684db;
        this.f8949a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.f8950b.f8663h);
            hashMap.put("banner_container", this.f8949a);
            hashMap.put("entry", Integer.valueOf(this.f8950b.f8940D));
            hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8950b.f8941E));
            hashMap.put("novel_id", this.f8950b.f8942F);
            hashMap.put("isnight", Boolean.valueOf(this.f8950b.m50556x()));
            this.f8950b.m50824a(C2684db.f8932u, hashMap);
        }
    }
}
