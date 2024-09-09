package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.f.c;
import com.bytedance.sdk.openadsdk.core.ugeno.r.ux;
import com.bytedance.sdk.openadsdk.core.w.w;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UgenBanner extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private i f32680c;
    private final AtomicBoolean sr;

    /* renamed from: w  reason: collision with root package name */
    private View f32681w;
    private boolean xv;

    public UgenBanner(Context context) {
        super(context);
        this.sr = new AtomicBoolean(false);
    }

    public void w() {
        View view = this.f32681w;
        if (view == null || this.xv) {
            return;
        }
        addView(view);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32681w, "translationY", -400.0f, 0.0f);
        ofFloat.setDuration(600L);
        ofFloat.start();
    }

    public void c(final me meVar, final w wVar) {
        c a4 = fp.a(meVar);
        if (a4 == null || meVar.ix() == null || TextUtils.isEmpty(meVar.ix().xv()) || meVar.kr() == null || TextUtils.isEmpty(meVar.kr().c()) || this.sr.getAndSet(true)) {
            return;
        }
        ux.c(a4, new ux.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c
            public void c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(RewardPlus.ICON, meVar.kr().c());
                    jSONObject2.put("app_name", meVar.ix().xv());
                    jSONObject2.put("title", meVar.ny());
                    jSONObject2.put("button_text", TextUtils.isEmpty(meVar.dk()) ? "\u7acb\u5373\u4e0b\u8f7d" : meVar.dk());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.f32681w = ugenBanner.c(jSONObject, jSONObject2, new b() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1.1
                    @Override // com.bytedance.adsdk.ugeno.w.b
                    public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
                        if (hVar.i() != null && "banner_click".equals(hVar.i().optString("type"))) {
                            UgenBanner.this.f32681w.setTag(2114387593, Boolean.TRUE);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            wVar.c(UgenBanner.this.f32681w, null);
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.w();
            }
        }, 3000L);
    }

    public void c() {
        this.xv = true;
        View view = this.f32681w;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View c(JSONObject jSONObject, JSONObject jSONObject2, b bVar) {
        i iVar = new i(getContext());
        this.f32680c = iVar;
        com.bytedance.adsdk.ugeno.component.b<View> c4 = iVar.c(jSONObject);
        this.f32680c.g(bVar);
        this.f32680c.k(jSONObject2);
        if (c4 == null) {
            return null;
        }
        View gd = c4.gd();
        if (gd != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c4.fp(), c4.ia());
            layoutParams.leftMargin = xk.ux(getContext(), 16.0f);
            layoutParams.rightMargin = xk.ux(getContext(), 16.0f);
            gd.setLayoutParams(layoutParams);
        }
        return gd;
    }
}
