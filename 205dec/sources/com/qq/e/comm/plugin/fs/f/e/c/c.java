package com.qq.e.comm.plugin.fs.f.e.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.r0.n;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    private final String f43394d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f43395e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43396f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.r0.c f43397c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.fs.f.e.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0832a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f43399a;

            C0832a(int i4) {
                this.f43399a = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!(valueAnimator.getAnimatedValue() instanceof Integer) || c.this.f43391a == null) {
                    return;
                }
                c.this.f43391a.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue() / this.f43399a);
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = c.this.f43391a.getLayoutParams();
                layoutParams.width = -2;
                c.this.f43391a.setLayoutParams(layoutParams);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                c.this.f43391a.setVisibility(0);
            }
        }

        a(com.qq.e.comm.plugin.r0.c cVar) {
            this.f43397c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = (c.this.f43391a.b() == null ? 0 : c.this.f43391a.b().getMeasuredWidth()) + this.f43397c.getWidth() + c.this.f43391a.getPaddingLeft() + c.this.f43391a.getPaddingRight() + f1.a(c.this.f43391a.getContext(), 4);
            n nVar = c.this.f43391a;
            ObjectAnimator duration = ObjectAnimator.ofInt(nVar, "width", f1.a(nVar.getContext(), 20), measuredWidth).setDuration(400L);
            duration.addUpdateListener(new C0832a(measuredWidth));
            duration.addListener(new b());
            duration.start();
        }
    }

    public c(n nVar, com.qq.e.comm.plugin.g0.e eVar) {
        super(nVar, eVar);
        this.f43395e = true;
        this.f43396f = false;
        this.f43394d = com.qq.e.comm.plugin.intersitial2.j.c.b(eVar);
    }

    private void a(int i4) {
        if (this.f43391a.b() == null) {
            this.f43391a.a(m1.a(com.qq.e.comm.plugin.fs.f.c.c.f43364a));
        }
        SpannableString spannableString = new SpannableString(String.format(Locale.getDefault(), "\u79d2\u540e\u53ef\u83b7\u5f97 %s", this.f43394d));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFBE00")), (spannableString.length() - this.f43394d.length()) - 1, spannableString.length(), 33);
        this.f43391a.a("\u89c2\u770b", String.valueOf(i4), spannableString);
        if (this.f43395e) {
            this.f43395e = false;
            e();
        }
    }

    private void e() {
        com.qq.e.comm.plugin.r0.c a4 = this.f43391a.a();
        if (a4 == null) {
            return;
        }
        this.f43391a.setVisibility(4);
        a4.post(new a(a4));
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    public void b(long j4) {
        int a4;
        if (com.qq.e.comm.plugin.fs.e.d.a() < com.qq.e.comm.plugin.fs.e.d.b()) {
            boolean z3 = ((long) com.qq.e.comm.plugin.fs.e.d.a()) - j4 < 1000;
            this.f43396f = z3;
            if (z3 && (a4 = a(j4)) > 0) {
                this.f43392b = true;
                a(a4);
                return;
            }
        }
        super.b(j4);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.b, com.qq.e.comm.plugin.fs.f.e.c.a
    protected void c() {
        if (this.f43391a.b() == null) {
            this.f43391a.a(m1.a(com.qq.e.comm.plugin.fs.f.c.c.f43364a));
        }
        this.f43391a.a(String.format(Locale.getDefault(), "\u5df2\u83b7\u5f97%s", this.f43394d));
        if (this.f43395e) {
            this.f43395e = false;
            e();
        }
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.b, com.qq.e.comm.plugin.fs.f.e.c.a
    public int a() {
        return this.f43396f ? com.qq.e.comm.plugin.fs.e.d.b() : com.qq.e.comm.plugin.fs.e.d.a();
    }
}
