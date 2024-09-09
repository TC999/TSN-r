package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.ux {

    /* renamed from: c  reason: collision with root package name */
    TextView f29217c;

    /* renamed from: u  reason: collision with root package name */
    boolean f29218u;

    /* renamed from: w  reason: collision with root package name */
    FrameLayout f29219w;

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29218u = false;
        View view = new View(context);
        this.ys = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.f29217c = new TextView(context);
        this.f29219w = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.c(context, 40.0f), (int) f.c(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.f29217c.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f29217c.setBackground(gradientDrawable);
        this.f29217c.setTextSize(10.0f);
        this.f29217c.setGravity(17);
        this.f29217c.setTextColor(-1);
        this.f29217c.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            addView(this.f29219w, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.f29217c);
        addView(this.ys, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.sr.c()) {
            addView(this.f29219w, getWidgetLayoutParams());
        }
        dynamicRootView.xv = this.f29219w;
        dynamicRootView.setVideoListener(this);
    }

    private void xv(View view) {
        if (view == this.f29217c || view == ((DynamicBaseWidgetImp) this).fz) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.c.f29089f)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i4 = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i4 >= viewGroup.getChildCount()) {
                return;
            }
            xv(viewGroup.getChildAt(i4));
            i4++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        double d4 = 0.0d;
        double d5 = 0.0d;
        for (ev evVar = this.bk; evVar != null; evVar = evVar.a()) {
            double f4 = evVar.f();
            Double.isNaN(f4);
            double d6 = d5 + f4;
            double r3 = evVar.r();
            Double.isNaN(r3);
            double d7 = d4 + r3;
            double sr = evVar.sr();
            Double.isNaN(sr);
            d5 = d6 - sr;
            double ux = evVar.ux();
            Double.isNaN(ux);
            d4 = d7 - ux;
        }
        try {
            float f5 = (float) d5;
            int c4 = (int) f.c(getContext(), f5);
            int c5 = (int) f.c(getContext(), f5 + this.ux);
            if (com.bytedance.sdk.component.adexpress.sr.w.c(getContext())) {
                int dynamicWidth = ((DynamicRoot) this.f29140t.getChildAt(0)).getDynamicWidth();
                int i4 = dynamicWidth - c5;
                c5 = dynamicWidth - c4;
                c4 = i4;
            }
            if (!"open_ad".equals(this.f29140t.getRenderRequest().sr())) {
                float f6 = (float) d4;
                ((DynamicRoot) this.f29140t.getChildAt(0)).f29178c.update(c4, (int) f.c(getContext(), f6), c5, (int) f.c(getContext(), f6 + this.f29134f));
            } else {
                this.f29140t.xv = this.f29219w;
            }
        } catch (Exception unused) {
        }
        this.f29140t.c(d5, d4, this.ux, this.f29134f, this.f29132a.ys());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ux
    public void setTimeUpdate(int i4) {
        if (this.bk.p().sr().pu() && i4 > 0 && !this.f29218u) {
            String str = (i4 >= 60 ? "0" + (i4 / 60) : "00") + ":";
            int i5 = i4 % 60;
            this.f29217c.setText(i5 > 9 ? str + i5 : str + "0" + i5);
            this.f29217c.setVisibility(0);
            return;
        }
        this.f29218u = true;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            xv(getChildAt(i6));
        }
        this.f29217c.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean sr() {
        return true;
    }
}
