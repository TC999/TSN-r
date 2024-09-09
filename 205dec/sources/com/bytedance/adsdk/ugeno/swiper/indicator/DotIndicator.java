package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import l0.b;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DotIndicator extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f26259a;

    /* renamed from: b  reason: collision with root package name */
    private int f26260b;

    /* renamed from: c  reason: collision with root package name */
    private int f26261c;

    /* renamed from: d  reason: collision with root package name */
    private Context f26262d;

    /* renamed from: e  reason: collision with root package name */
    private int f26263e;

    /* renamed from: f  reason: collision with root package name */
    private int f26264f;

    /* renamed from: g  reason: collision with root package name */
    private int f26265g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26266h;

    /* renamed from: i  reason: collision with root package name */
    private int f26267i;

    public DotIndicator(Context context) {
        super(context);
        this.f26260b = -65536;
        this.f26261c = -16776961;
        this.f26263e = 5;
        this.f26264f = 20;
        this.f26265g = 20;
        this.f26262d = context;
        this.f26259a = new ArrayList();
        a();
    }

    private GradientDrawable d(int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i4);
        return gradientDrawable;
    }

    public void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        setGravity(17);
        setOrientation(0);
        layoutParams.bottomMargin = (int) b.a(this.f26262d, 10.0f);
        setLayoutParams(layoutParams);
    }

    public void b(int i4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f26264f, this.f26265g);
        int i5 = this.f26263e;
        layoutParams.leftMargin = i5;
        layoutParams.rightMargin = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f26264f, this.f26265g);
        int i6 = this.f26263e;
        layoutParams2.leftMargin = i6;
        layoutParams2.rightMargin = i6;
        int a4 = com.bytedance.adsdk.ugeno.swiper.a.a(this.f26266h, this.f26267i, this.f26259a.size());
        int a5 = com.bytedance.adsdk.ugeno.swiper.a.a(this.f26266h, i4, this.f26259a.size());
        if (this.f26259a.size() == 0) {
            a5 = 0;
        }
        if (!this.f26259a.isEmpty() && com.bytedance.adsdk.ugeno.swiper.a.b(a4, this.f26259a) && com.bytedance.adsdk.ugeno.swiper.a.b(a5, this.f26259a)) {
            this.f26259a.get(a4).setBackground(d(this.f26261c));
            this.f26259a.get(a4).setLayoutParams(layoutParams2);
            this.f26259a.get(a5).setBackground(d(this.f26260b));
            this.f26259a.get(a5).setLayoutParams(layoutParams);
            this.f26267i = i4;
        }
    }

    public void c(int i4, int i5) {
        for (View view : this.f26259a) {
            view.setBackground(d(this.f26261c));
        }
        i4 = (i4 < 0 || i4 >= this.f26259a.size()) ? 0 : 0;
        if (this.f26259a.size() > 0) {
            this.f26259a.get(i4).setBackground(d(this.f26260b));
            this.f26267i = i5;
        }
    }

    public void e() {
        View view = new View(getContext());
        view.setClickable(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f26264f, this.f26265g);
        int i4 = this.f26263e;
        layoutParams.leftMargin = i4;
        layoutParams.rightMargin = i4;
        addView(view, layoutParams);
        view.setBackground(d(this.f26261c));
        this.f26259a.add(view);
    }

    public int getSize() {
        return this.f26259a.size();
    }

    public void setLoop(boolean z3) {
        this.f26266h = z3;
    }

    public void setSelectedColor(int i4) {
        this.f26260b = i4;
    }

    public void setUnSelectedColor(int i4) {
        this.f26261c = i4;
    }
}
