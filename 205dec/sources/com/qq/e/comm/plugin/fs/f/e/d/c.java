package com.qq.e.comm.plugin.fs.f.e.d;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.r0.m;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private m f43403c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f43404d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f43405e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f43406f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f43407g;

    /* renamed from: h  reason: collision with root package name */
    private Context f43408h;

    /* renamed from: i  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f43409i;

    public c(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        super(context);
        setGravity(17);
        this.f43408h = context;
        this.f43409i = eVar;
        a();
    }

    private void a() {
        if (this.f43409i == null) {
            return;
        }
        d1.a("EndCardFallbackView init", new Object[0]);
        setBackgroundColor(-1);
        int a4 = f1.a(this.f43408h, 40);
        setPadding(a4, 0, a4, 0);
        int a5 = f1.a(this.f43408h, 100);
        int a6 = f1.a(this.f43408h, 28);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a5, a5);
        layoutParams.addRule(14);
        m mVar = new m(this.f43408h);
        this.f43403c = mVar;
        mVar.setId(1);
        this.f43403c.a(a6);
        addView(this.f43403c, layoutParams);
        com.qq.e.comm.plugin.b0.b.a().a(this.f43409i.Y(), this.f43403c);
        String J0 = this.f43409i.J0();
        String F = this.f43409i.F();
        String B = this.f43409i.B();
        if (this.f43409i.X0()) {
            com.qq.e.comm.plugin.g0.b q3 = this.f43409i.q();
            if (q3 != null) {
                String a7 = q3.a();
                if (!TextUtils.isEmpty(a7)) {
                    J0 = a7;
                }
            }
            B = "";
        }
        TextView textView = new TextView(this.f43408h);
        this.f43404d = textView;
        textView.setId(2);
        this.f43404d.setText(J0);
        this.f43404d.setTextSize(2, 24.0f);
        this.f43404d.setTypeface(null, 1);
        this.f43404d.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 1);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = f1.a(this.f43408h, 10);
        addView(this.f43404d, layoutParams2);
        TextView textView2 = new TextView(this.f43408h);
        this.f43405e = textView2;
        textView2.setId(3);
        this.f43405e.setText(F);
        this.f43405e.setMaxLines(2);
        this.f43405e.setEllipsize(TextUtils.TruncateAt.END);
        this.f43405e.setTextColor(-10066330);
        this.f43405e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = f1.a(this.f43408h, 10);
        addView(this.f43405e, layoutParams3);
        ImageView imageView = new ImageView(this.f43408h);
        this.f43406f = imageView;
        imageView.setId(4);
        this.f43406f.setImageBitmap(m1.a("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"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(f1.a(this.f43408h, 168), f1.a(this.f43408h, 24));
        layoutParams4.addRule(3, 3);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = f1.a(this.f43408h, 16);
        addView(this.f43406f, layoutParams4);
        TextView textView3 = new TextView(this.f43408h);
        this.f43407g = textView3;
        textView3.setId(5);
        this.f43407g.setText(B);
        this.f43407g.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13531652);
        gradientDrawable.setCornerRadius(80.0f);
        this.f43407g.setBackgroundDrawable(gradientDrawable);
        this.f43407g.setGravity(17);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(f1.a(this.f43408h, 160), f1.a(this.f43408h, 45));
        layoutParams5.addRule(3, 4);
        layoutParams5.addRule(14);
        layoutParams5.topMargin = f1.a(this.f43408h, 30);
        addView(this.f43407g, layoutParams5);
    }

    public static int b() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("rvewt", 5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this);
        if (d4 != null) {
            d4.a(motionEvent, false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.qq.e.comm.plugin.e.a.a().a(this, this.f43409i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.qq.e.comm.plugin.e.a.a().b(this);
    }

    public static boolean a(int i4) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("rvnec", 1) == 1 && i4 != 1;
    }
}
