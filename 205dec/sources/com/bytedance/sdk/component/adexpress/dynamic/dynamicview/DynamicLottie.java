package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.dynamic.xv.f;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {

    /* renamed from: c  reason: collision with root package name */
    String f29170c;

    /* renamed from: w  reason: collision with root package name */
    ev f29171w;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, ev evVar, String str) {
        super(context, dynamicRootView, evVar);
        this.f29170c = str;
        this.f29171w = evVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        ev evVar = this.bk;
        if (evVar == null || evVar.p() == null || this.f29136k == null || TextUtils.isEmpty(this.f29170c)) {
            return null;
        }
        f sr = this.bk.p().sr();
        String te = sr != null ? sr.te() : "";
        if (TextUtils.isEmpty(te)) {
            return null;
        }
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.f29136k);
        dynamicLottieView.setImageLottieTosPath(this.f29170c + "static/lotties/" + te + ".json");
        dynamicLottieView.f();
        return dynamicLottieView;
    }
}
