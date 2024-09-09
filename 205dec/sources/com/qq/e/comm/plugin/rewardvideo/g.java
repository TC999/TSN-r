package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.b.k;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.r0.c f45926c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f45927d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f45928e;

    /* renamed from: f  reason: collision with root package name */
    private final f0 f45929f;

    /* renamed from: g  reason: collision with root package name */
    private b f45930g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f45930g != null) {
                g.this.f45930g.b();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void b();
    }

    public g(Context context, f0 f0Var) {
        super(context);
        this.f45929f = f0Var;
        a(context, f0Var);
    }

    public void b() {
        this.f45926c.a().setVisibility(8);
    }

    public void c(int i4) {
        this.f45926c.a((CharSequence) String.valueOf(i4));
    }

    private void a(Context context, f0 f0Var) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        int a4 = f1.a(context, 14);
        linearLayout.setPadding(a4, 0, a4, 0);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.qq.e.comm.plugin.util.l.b(), com.qq.e.comm.plugin.util.l.a());
        layoutParams.gravity = 21;
        linearLayout.addView(imageView, layoutParams);
        boolean a5 = com.qq.e.comm.plugin.util.l.a(this.f45929f);
        com.qq.e.comm.plugin.util.l.a(imageView, a5);
        if (a5) {
            imageView.setOnClickListener(new a());
        }
        View view = new View(context);
        view.setId(-1894776829);
        view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 0.67f, getResources().getDisplayMetrics()));
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(6, -1894776828);
        view.setLayoutParams(layoutParams2);
        addView(view);
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        this.f45927d = progressBar;
        progressBar.setId(-1894776828);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.34f, getResources().getDisplayMetrics()));
        layoutParams3.addRule(12, -1);
        this.f45927d.setLayoutParams(layoutParams3);
        this.f45927d.setMax(100);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(0), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
        clipDrawable.setLevel(10000);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f45927d.setProgressDrawable(layerDrawable);
        addView(this.f45927d);
        k.b a6 = com.qq.e.comm.plugin.b.k.a(k.c.REWARD_PAGE, f0Var);
        int a7 = f1.a(context, 17) - a6.f42016a;
        this.f45926c = new com.qq.e.comm.plugin.r0.c(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.gravity = 17;
        layoutParams4.weight = 1.0f;
        layoutParams4.rightMargin = -a7;
        this.f45926c.setLayoutParams(layoutParams4);
        linearLayout.addView(this.f45926c);
        ImageView imageView2 = new ImageView(context);
        this.f45928e = imageView2;
        imageView2.setImageBitmap(m1.a("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"));
        this.f45928e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f45928e.setPadding(a6.f42016a, a6.f42017b, a6.f42018c, a6.f42019d);
        int a8 = f1.a(getContext(), 16);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(a6.f42016a + a8 + a6.f42018c, a8 + a6.f42017b + a6.f42019d);
        layoutParams5.leftMargin = a7;
        layoutParams5.topMargin = -a6.f42017b;
        layoutParams5.rightMargin = f1.a(context, 7) - a6.f42018c;
        layoutParams5.bottomMargin = -a6.f42019d;
        layoutParams5.gravity = 16;
        this.f45928e.setVisibility(4);
        linearLayout.addView(this.f45928e, layoutParams5);
    }

    public void b(int i4) {
        if (this.f45927d.getVisibility() != 0) {
            this.f45927d.setVisibility(0);
        }
        a(i4);
    }

    public void c() {
        if (this.f45927d.getVisibility() == 0) {
            this.f45927d.setVisibility(8);
            this.f45927d.setProgress(0);
        }
    }

    public ImageView a() {
        return this.f45928e;
    }

    public void a(String str, int i4, String str2) {
        a(str, String.valueOf(i4), str2);
    }

    public void a(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str)) {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFBE00")), 0, str.length(), 18);
        }
        this.f45926c.a(spannableString, str2, str3);
    }

    public void a(String str) {
        this.f45926c.a(str);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f45928e.setClickable(true);
        this.f45928e.setOnClickListener(onClickListener);
    }

    private void a(int i4) {
        ProgressBar progressBar = this.f45927d;
        if (i4 < 0) {
            i4 = 0;
        } else if (i4 > 100) {
            i4 = 100;
        }
        progressBar.setProgress(i4);
    }

    public void a(b bVar) {
        this.f45930g = bVar;
    }
}
