package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicUnlockView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private final TextView f29536c;
    private final RotateAnimation sr;

    /* renamed from: w  reason: collision with root package name */
    private final ImageView f29537w;
    private final FlowLightView xv;

    public DynamicUnlockView(Context context) {
        super(context);
        addView(com.bytedance.sdk.component.adexpress.xv.c.sr(context));
        this.f29536c = (TextView) findViewById(2097610742);
        this.f29537w = (ImageView) findViewById(2097610745);
        this.xv = (FlowLightView) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.sr = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.f29537w.startAnimation(DynamicUnlockView.this.sr);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.xv.c(4);
                    }
                }, 100L);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.xv.c(4);
                    }
                }, 300L);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
            }
        };
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "\u6ed1\u52a8\u6216\u70b9\u51fb\u8df3\u8f6c\u81f3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
        }
        TextView textView = this.f29536c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void c() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void w() {
        this.sr.cancel();
    }
}
