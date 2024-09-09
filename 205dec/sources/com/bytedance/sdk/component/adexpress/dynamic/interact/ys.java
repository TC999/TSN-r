package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys implements ev<ShakeAnimationView>, fp {

    /* renamed from: c  reason: collision with root package name */
    private ShakeAnimationView f29293c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f29294f;

    /* renamed from: r  reason: collision with root package name */
    private int f29295r;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.r sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private Context f29296w;
    private DynamicBaseWidget xv;

    public ys(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, String str, int i4, int i5, int i6) {
        this.f29296w = context;
        this.xv = dynamicBaseWidget;
        this.sr = rVar;
        this.ux = str;
        this.f29294f = i4;
        this.f29295r = i5;
        this.ev = i6;
        f();
    }

    private void f() {
        final com.bytedance.sdk.component.adexpress.dynamic.ux.c dynamicClickListener = this.xv.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.c(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.ux)) {
            Context context = this.f29296w;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.xv.c.gd(context), this.f29294f, this.f29295r, this.ev);
            this.f29293c = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.f29293c.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.f29296w;
            this.f29293c = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.xv.c.ev(context2), this.f29294f, this.f29295r, this.ev);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f29293c.setGravity(17);
        layoutParams.gravity = 17;
        this.f29293c.setLayoutParams(layoutParams);
        this.f29293c.setTranslationY(com.bytedance.sdk.component.adexpress.sr.f.c(this.f29296w, this.sr.te()));
        this.f29293c.setShakeText(this.sr.bm());
        this.f29293c.setClipChildren(false);
        this.f29293c.setOnShakeViewListener(new ShakeAnimationView.c() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.ys.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.c
            public void c(boolean z3) {
                com.bytedance.sdk.component.adexpress.dynamic.ux.c cVar = dynamicClickListener;
                if (cVar != null) {
                    cVar.c(z3, ys.this);
                }
                ys.this.f29293c.setOnClickListener((View.OnClickListener) dynamicClickListener);
                ys.this.f29293c.performClick();
                if (ys.this.sr == null || !ys.this.sr.ox()) {
                    return;
                }
                ys.this.f29293c.setOnClickListener(null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public ShakeAnimationView xv() {
        return this.f29293c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.fp
    public void ux() {
        if (this.f29293c.getParent() != null) {
            ((ViewGroup) this.f29293c.getParent()).setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29293c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29293c.clearAnimation();
    }
}
