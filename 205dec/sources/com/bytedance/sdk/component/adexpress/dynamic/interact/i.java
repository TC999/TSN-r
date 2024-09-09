package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i implements ev<WriggleGuideAnimationView> {

    /* renamed from: c  reason: collision with root package name */
    private WriggleGuideAnimationView f29275c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.xv.p f29276f;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.r sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private Context f29277w;
    private DynamicBaseWidget xv;

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, String str, com.bytedance.sdk.component.adexpress.dynamic.xv.p pVar) {
        this.f29277w = context;
        this.xv = dynamicBaseWidget;
        this.sr = rVar;
        this.ux = str;
        this.f29276f = pVar;
        ux();
    }

    private void ux() {
        int mt = this.sr.mt();
        final com.bytedance.sdk.component.adexpress.dynamic.ux.c dynamicClickListener = this.xv.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.c(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.ux)) {
            Context context = this.f29277w;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.xv.c.p(context), this.f29276f);
            this.f29275c = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.f29275c.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.f29275c.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.sr.ge())) {
                    this.f29275c.getTopTextView().setText(com.bytedance.sdk.component.utils.i.w(this.f29277w, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.f29275c.getTopTextView().setText(this.sr.ge());
                }
            }
        } else {
            Context context2 = this.f29277w;
            this.f29275c = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.xv.c.p(context2), this.f29276f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.f29275c.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29277w, mt)));
        this.f29275c.setLayoutParams(layoutParams);
        this.f29275c.setShakeText(this.sr.bm());
        this.f29275c.setClipChildren(false);
        final View wriggleProgressIv = this.f29275c.getWriggleProgressIv();
        this.f29275c.setOnShakeViewListener(new WriggleGuideAnimationView.c() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.i.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.c
            public void c() {
                if (wriggleProgressIv != null) {
                    if (i.this.f29275c != null) {
                        i.this.f29275c.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        i.this.f29275c.performClick();
                    }
                    if (i.this.sr == null || !i.this.sr.ox()) {
                        return;
                    }
                    i.this.f29275c.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public WriggleGuideAnimationView xv() {
        return this.f29275c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29275c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29275c.clearAnimation();
    }
}
