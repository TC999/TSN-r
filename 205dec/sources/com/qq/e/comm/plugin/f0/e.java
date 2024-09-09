package com.qq.e.comm.plugin.f0;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f43105c;

    /* renamed from: d  reason: collision with root package name */
    private View f43106d;

    /* renamed from: e  reason: collision with root package name */
    private String f43107e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43108f;

    public e(Context context, String str) {
        super(context);
        setOrientation(1);
        setGravity(17);
        this.f43107e = str;
        this.f43108f = false;
        a();
        b();
    }

    private void a() {
        Context context = getContext();
        TextView textView = new TextView(context);
        this.f43105c = textView;
        textView.setText(this.f43107e);
        this.f43105c.setTextSize(2, 16.0f);
        this.f43105c.setTypeface(Typeface.defaultFromStyle(1));
        addView(this.f43105c, new LinearLayout.LayoutParams(-2, -2));
        this.f43106d = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f1.a(context, 20), f1.a(context, 2));
        layoutParams.topMargin = f1.a(context, 4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13531652);
        gradientDrawable.setCornerRadius(50.0f);
        this.f43106d.setBackgroundDrawable(gradientDrawable);
        addView(this.f43106d, layoutParams);
    }

    public void b() {
        if (this.f43108f) {
            this.f43106d.setVisibility(0);
            this.f43105c.setTextColor(-13531652);
            return;
        }
        this.f43106d.setVisibility(8);
        this.f43105c.setTextColor(-6710887);
    }

    public void a(boolean z3) {
        this.f43108f = z3;
        b();
    }
}
