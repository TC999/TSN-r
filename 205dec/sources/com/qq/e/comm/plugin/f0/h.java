package com.qq.e.comm.plugin.f0;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.r0.m;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.p;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends com.qq.e.comm.plugin.f0.a implements g.b, com.qq.e.comm.plugin.apkmanager.w.a {
    private static final String F = h.class.getSimpleName();
    private p.h A;
    private boolean B;
    private View.OnClickListener C;
    private final String D;
    private final boolean E;

    /* renamed from: g  reason: collision with root package name */
    private final Context f43115g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43116h;

    /* renamed from: i  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.a f43117i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f43118j;

    /* renamed from: k  reason: collision with root package name */
    private final int f43119k;

    /* renamed from: l  reason: collision with root package name */
    private final int f43120l;

    /* renamed from: m  reason: collision with root package name */
    private final int f43121m;

    /* renamed from: n  reason: collision with root package name */
    private final int f43122n;

    /* renamed from: o  reason: collision with root package name */
    private final int f43123o;

    /* renamed from: p  reason: collision with root package name */
    private final int f43124p;

    /* renamed from: q  reason: collision with root package name */
    private final int f43125q;

    /* renamed from: r  reason: collision with root package name */
    private final int f43126r;

    /* renamed from: s  reason: collision with root package name */
    private final int f43127s;

    /* renamed from: t  reason: collision with root package name */
    private final int f43128t;

    /* renamed from: u  reason: collision with root package name */
    private final int f43129u;

    /* renamed from: v  reason: collision with root package name */
    private final int f43130v;

    /* renamed from: w  reason: collision with root package name */
    private final int f43131w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f43132x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f43133y;

    /* renamed from: z  reason: collision with root package name */
    private c2 f43134z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements p.h {
        a() {
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            if (h.this.f43134z == null || h.this.B) {
                return false;
            }
            h.this.f43134z.f();
            return false;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            if (h.this.f43134z != null) {
                h.this.f43134z.e();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends c2 {
        b(long j4, long j5) {
            super(j4, j5);
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void a(long j4) {
            int ceil = (int) Math.ceil(((float) j4) / 1000.0f);
            d1.a(h.F, String.format("\u4e94\u8981\u7d20\u5f39\u7a97\u5012\u8ba1\u65f6 %ss, %sms", Integer.valueOf(ceil), Long.valueOf(j4)));
            h.this.d(String.format(Locale.getDefault(), "\u7acb\u5373\u4e0b\u8f7d\uff08%ds \u540e\u81ea\u52a8\u4e0b\u8f7d\uff09", Integer.valueOf(ceil)));
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void d() {
            d1.a(h.F, "\u4e94\u8981\u7d20\u5f39\u7a97\u5012\u8ba1\u65f6\u7ed3\u675f\uff0c\u5f00\u59cb\u8fdb\u5165\u4e0b\u8f7d");
            v.a(1100927, com.qq.e.comm.plugin.n0.c.a(h.this.f43116h));
            c cVar = h.this.f43057e;
            if (cVar == null || !cVar.isShowing()) {
                return;
            }
            h.this.C.onClick(h.this.f43056d);
        }
    }

    public h(Context context, c cVar, com.qq.e.comm.plugin.g0.e eVar, boolean z3, int i4, int i5) {
        super(context, cVar);
        this.B = false;
        this.f43115g = context;
        this.f43116h = eVar;
        this.f43117i = eVar.q().b();
        this.D = this.f43116h.q().e();
        this.f43118j = z3;
        this.f43119k = i4;
        this.E = com.qq.e.comm.plugin.apkmanager.w.d.e(i5);
        this.f43120l = (int) f1.a(this.f43115g, 0.5f);
        this.f43121m = f1.a(this.f43115g, 4);
        this.f43122n = f1.a(this.f43115g, 12);
        this.f43123o = f1.a(this.f43115g, 16);
        this.f43124p = f1.a(this.f43115g, 20);
        this.f43125q = f1.a(this.f43115g, 21);
        this.f43126r = f1.a(this.f43115g, 48);
        this.f43127s = f1.a(this.f43115g, 64);
        this.f43128t = f1.a(this.f43115g, 85);
        this.f43129u = f1.a(this.f43115g, 88);
        this.f43130v = f1.a(this.f43115g, 104);
        this.f43131w = f1.a(this.f43115g, 146);
        o();
        if (this.E) {
            k.e().a(this.D, this);
        }
    }

    private void k() {
        FrameLayout frameLayout = new FrameLayout(this.f43115g);
        Button button = new Button(this.f43115g, null, 16843563);
        this.f43056d = button;
        button.setAllCaps(false);
        this.f43056d.setTextSize(1, 14.0f);
        this.f43056d.setTextColor(-1);
        this.f43056d.setTypeface(Typeface.defaultFromStyle(1));
        this.f43056d.setPadding(0, 0, 0, 0);
        this.f43056d.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f43126r / 2.0f);
        gradientDrawable.setColor(-13531652);
        this.f43056d.setBackgroundDrawable(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f43126r);
        layoutParams.gravity = 49;
        frameLayout.addView(this.f43056d, layoutParams);
        if (this.f43118j) {
            TextView textView = new TextView(this.f43115g);
            this.f43133y = textView;
            textView.setText("\u53d6\u6d88\u81ea\u52a8\u4e0b\u8f7d");
            this.f43133y.setTextColor(-6710887);
            this.f43133y.setTextSize(1, 14.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, this.f43125q);
            layoutParams2.gravity = 49;
            layoutParams2.setMargins(0, this.f43127s, 0, 0);
            frameLayout.addView(this.f43133y, layoutParams2);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, this.f43118j ? this.f43128t : this.f43126r);
        layoutParams3.weight = 0.0f;
        addView(frameLayout, layoutParams3);
    }

    private void l() {
        FrameLayout frameLayout = new FrameLayout(this.f43115g);
        m mVar = new m(this.f43115g);
        mVar.a(this.f43122n);
        int i4 = this.f43129u;
        frameLayout.addView(mVar, new FrameLayout.LayoutParams(i4, i4));
        com.qq.e.comm.plugin.b0.b.a().a(this.f43116h.Y(), mVar);
        LinearLayout linearLayout = new LinearLayout(this.f43115g);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.f43115g);
        textView.setText(this.f43117i.a());
        textView.setTextSize(1, 18.0f);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(-13421773);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i5 = this.f43123o;
        layoutParams.setMargins(i5, 0, i5, 0);
        layoutParams.gravity = 51;
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.f43115g);
        textView2.setText(this.f43117i.b());
        textView2.setTextSize(1, 12.0f);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(-6710887);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.f43123o);
        int i6 = this.f43123o;
        layoutParams2.setMargins(i6, this.f43121m, i6, 0);
        layoutParams2.gravity = 51;
        linearLayout.addView(textView2, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(this.f43129u, 0, this.f43123o, 0);
        layoutParams3.gravity = 51;
        frameLayout.addView(linearLayout, layoutParams3);
        TextView textView3 = new TextView(this.f43115g);
        textView3.setText(String.format(Locale.getDefault(), "\u7248\u672c\u53f7  %s", this.f43117i.i()));
        textView3.setTextSize(1, 12.0f);
        textView3.setTextColor(-6710887);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, this.f43123o);
        layoutParams4.setMargins(this.f43130v, 0, this.f43123o, 0);
        layoutParams4.gravity = 83;
        frameLayout.addView(textView3, layoutParams4);
        ImageView imageView = new ImageView(this.f43115g);
        this.f43055c = imageView;
        imageView.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAWVJREFUWEfN19FtgzAQBmAfC7USmOd2g2zSZgJggmSTqhO0z9hImchXETkIHBvf2ZYojzjy/2FyPgPi4AsOzhf/CzCO42tVVR0A3Oq6Hkqujtb6QwhxMsac27a9PeberIDW+kcI8TYPAkBfCjFNU4eI/TwvIn5LKU9egFLqEwAuy2ABxDrcAgYp5R1zf1B3mZVSPQB0JRCxcC9gvlkCQQkPAnIR1PBdQCqCEx4FcBHccBKAikgJJwNiiNRwFiCEsLW91DUibuo8tpuye4FbousAbjh7BR5hPkRKeDLAfec5vYP9CnzhOds2C+D7t9unT+4dZMBeqeX0DhKAUuepiCiAEh6qDsqhZhfACU9FBAEp4SkILyAnnIt4ApQI5yA2gJLhIQQinqWU12XzWjcTrfXXfHa3HY7V1fa6nlOiv03TvHsB9sPkYs/uizLWUinjFvFijBmCHyaUiUr/JroRlQ505zsc8AdNqnUwkcs5DQAAAABJRU5ErkJggg=="));
        int i7 = this.f43123o;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i7, i7);
        layoutParams5.gravity = 53;
        frameLayout.addView(this.f43055c, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, this.f43129u);
        layoutParams6.bottomMargin = this.f43124p;
        layoutParams6.weight = 0.0f;
        addView(frameLayout, layoutParams6);
    }

    private void m() {
        FrameLayout frameLayout = new FrameLayout(this.f43115g);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (Build.VERSION.SDK_INT >= 21) {
            spannableStringBuilder.append("\u9690\u79c1\u534f\u8bae", new UnderlineSpan(), 33);
            spannableStringBuilder.append((CharSequence) "    ");
            spannableStringBuilder.append("\u6743\u9650\u8be6\u60c5", new UnderlineSpan(), 33);
            spannableStringBuilder.append((CharSequence) "    ");
            spannableStringBuilder.append("\u529f\u80fd\u4ecb\u7ecd", new UnderlineSpan(), 33);
        } else {
            spannableStringBuilder.append((CharSequence) String.format("%s >   %s >   %s >", "\u9690\u79c1\u534f\u8bae", "\u6743\u9650\u8be6\u60c5", "\u529f\u80fd\u4ecb\u7ecd"));
        }
        TextView a4 = a(spannableStringBuilder);
        this.f43132x = a4;
        a(frameLayout, a4, 20.0f);
        a(frameLayout, 65.0f);
        String d4 = this.f43117i.d();
        if (TextUtils.isEmpty(d4)) {
            d4 = "\u672a\u5907\u6848";
        }
        a(frameLayout, a(String.format("\u5907\u6848\u53f7\uff1a%s", d4)), 75.0f);
        a(frameLayout, a(String.format("\u9002\u7528\u5e74\u9f84\uff1a%s", this.f43117i.h())), 100.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f43131w);
        layoutParams.bottomMargin = this.f43124p;
        layoutParams.weight = 1.0f;
        addView(frameLayout, layoutParams);
    }

    private void p() {
        d(String.format(Locale.getDefault(), "\u7acb\u5373\u4e0b\u8f7d\uff08%ds \u540e\u81ea\u52a8\u4e0b\u8f7d\uff09", Integer.valueOf(this.f43119k)));
        this.A = new a();
        p.b().a(this.A);
        b bVar = new b(this.f43119k * 1000, 1000L);
        this.f43134z = bVar;
        bVar.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void e() {
        if (this.f43118j) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void f() {
        c2 c2Var = this.f43134z;
        if (c2Var != null) {
            c2Var.h();
            this.f43134z = null;
        }
        if (this.A != null) {
            p.b().b(this.A);
            this.A = null;
        }
        if (this.E) {
            k.e().b(this.D, this);
        }
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void h() {
        c2 c2Var = this.f43134z;
        if (c2Var != null) {
            this.B = true;
            c2Var.e();
        }
    }

    void o() {
        int i4 = this.f43124p;
        setPadding(i4, i4, i4, this.f43123o);
        setOrientation(1);
        l();
        m();
        k();
    }

    private void a(FrameLayout frameLayout, float f4) {
        View view = new View(this.f43115g);
        view.setBackgroundColor(-1644825);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f43120l);
        layoutParams.gravity = 48;
        layoutParams.setMargins(0, (int) f1.a(this.f43115g, f4), 0, 0);
        frameLayout.addView(view, layoutParams);
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void c() {
        c2 c2Var = this.f43134z;
        if (c2Var != null) {
            this.B = false;
            c2Var.f();
        }
    }

    private TextView a(CharSequence charSequence) {
        TextView textView = new TextView(this.f43115g);
        textView.setText(charSequence);
        textView.setTextColor(-6710887);
        textView.setTextSize(1, 14.0f);
        return textView;
    }

    private void a(FrameLayout frameLayout, TextView textView, float f4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, this.f43125q);
        layoutParams.gravity = 51;
        layoutParams.setMargins(0, (int) f1.a(this.f43115g, f4), 0, 0);
        frameLayout.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void a(View.OnClickListener onClickListener) {
        super.a(onClickListener);
        this.C = onClickListener;
        this.f43132x.setOnClickListener(onClickListener);
        if (this.f43118j) {
            this.f43133y.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void a(View view) {
        if (view == this.f43132x) {
            d1.a(F, "\u4e94\u8981\u7d20\u5f39\u7a97\u5c55\u793a\u4e94\u8981\u7d20\u8be6\u60c5\u9875");
            f.a(this.f43116h, this);
        } else if (view == this.f43133y) {
            d1.a(F, "\u4e94\u8981\u7d20\u5f39\u7a97\u53d6\u6d88\u81ea\u52a8\u4e0b\u8f7d");
            f();
            this.f43133y.setVisibility(8);
            d("\u7acb\u5373\u4e0b\u8f7d");
            v.a(1100928, com.qq.e.comm.plugin.n0.c.a(this.f43116h));
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.w.a
    public void a(String str, int i4, int i5, long j4) {
        if (i5 == 100) {
            try {
                if (this.f43057e.isShowing()) {
                    this.f43057e.dismiss();
                }
            } catch (Exception unused) {
            }
        } else if (com.qq.e.comm.plugin.apkmanager.w.d.b(i4)) {
            d("\u7ee7\u7eed\u4e0b\u8f7d");
        } else {
            d(String.format("\u4e0b\u8f7d\u4e2d(%d%%)", Integer.valueOf(i5)));
        }
    }
}
