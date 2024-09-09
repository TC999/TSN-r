package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends RecyclerView.j {

    /* renamed from: c  reason: collision with root package name */
    private LoadingMoreView f34147c;

    /* renamed from: i  reason: collision with root package name */
    private View f34148i;

    /* renamed from: j  reason: collision with root package name */
    private String f34149j;

    /* renamed from: q  reason: collision with root package name */
    private String f34150q;

    /* renamed from: u  reason: collision with root package name */
    private View f34151u;

    /* renamed from: w  reason: collision with root package name */
    private TextView f34152w;
    private View xv;

    public c(View view) {
        super(view);
        this.f34150q = "";
        this.f34149j = "";
        view.getContext();
        this.f34152w = (TextView) view.findViewById(2114387762);
        this.f34147c = (LoadingMoreView) view.findViewById(2114387706);
        this.xv = view.findViewById(2114387825);
        this.f34151u = view.findViewById(2114387776);
        this.f34148i = view.findViewById(2114387668);
        view.setVisibility(0);
    }

    public void c(String str, String str2) {
        this.f34150q = str2;
        this.f34149j = str;
        w();
    }

    public void w(View view) {
        w();
        this.f34147c.c();
        View view2 = this.xv;
        if (view2 != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.width = 0;
            this.xv.setLayoutParams(layoutParams);
        }
        View view3 = this.f34151u;
        if (view3 != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
            layoutParams2.width = 0;
            this.f34151u.setLayoutParams(layoutParams2);
        }
        if (view != null) {
            view.scrollTo(0, view.getScrollY());
        }
    }

    public void xv() {
        c(this.f34152w, 200L, 1.0f, 1.05f);
    }

    public void c(double d4) {
        int length = this.f34150q.length();
        try {
            this.sr.setLayoutParams(new RecyclerView.p(-2, (int) d4));
            int i4 = 14;
            int c4 = c(xk.c(this.sr.getContext(), 14));
            double d5 = 0.75d * d4;
            while (c4 * length > d5) {
                i4--;
                c4 = c(xk.c(this.sr.getContext(), i4));
            }
            double d6 = d4 * 0.25d;
            while (c4 * length < d6) {
                i4++;
                c4 = c(xk.c(this.sr.getContext(), i4));
            }
            if (i4 <= 0) {
                return;
            }
            this.f34152w.setTextSize(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static int c(float f4) {
        Paint paint = new Paint();
        paint.setTextSize(f4);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
    }

    private void w(int i4, View view) {
        int abs = Math.abs(i4);
        View view2 = this.xv;
        int i5 = 0;
        if (view2 != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            int i6 = (int) (abs / 8.0f);
            layoutParams.width = i6;
            i5 = 0 + i6;
            this.xv.setLayoutParams(layoutParams);
        }
        View view3 = this.f34151u;
        if (view3 != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
            int i7 = (int) (abs / 8.0f);
            layoutParams2.width = i7;
            i5 += i7;
            this.f34151u.setLayoutParams(layoutParams2);
        }
        if (view != null) {
            view.scrollTo(i5, view.getScrollY());
        }
    }

    public void c(final View view) {
        if (this.f34151u != null) {
            w();
            final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34151u.getLayoutParams();
            final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.xv.getLayoutParams();
            final LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f34148i.getLayoutParams();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(layoutParams.width, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.f34147c.setMoveSpace(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    LinearLayout.LayoutParams layoutParams4 = layoutParams;
                    float f4 = 1.0f - animatedFraction;
                    int i4 = (int) (layoutParams4.width * f4);
                    layoutParams4.width = i4;
                    LinearLayout.LayoutParams layoutParams5 = layoutParams2;
                    int i5 = (int) (layoutParams5.width * f4);
                    layoutParams5.width = i5;
                    int i6 = i4 + 0 + i5;
                    LinearLayout.LayoutParams layoutParams6 = layoutParams3;
                    int i7 = (int) (layoutParams6.width * f4);
                    layoutParams6.width = i7;
                    int i8 = i6 + i7;
                    c.this.f34151u.setLayoutParams(layoutParams);
                    c.this.xv.setLayoutParams(layoutParams2);
                    c.this.f34148i.setLayoutParams(layoutParams3);
                    View view2 = view;
                    if (view2 != null) {
                        view2.scrollTo(i8, view2.getScrollY());
                    }
                }
            });
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    public void w() {
        TextView textView = this.f34152w;
        if (textView != null) {
            textView.setText(this.f34150q);
        }
    }

    public void c(int i4, View view) {
        this.f34147c.setMoveSpace(i4);
        w(i4, view);
    }

    public void c() {
        TextView textView = this.f34152w;
        if (textView != null) {
            textView.setText(this.f34149j);
        }
    }

    private void c(View view, long j4, float f4, float f5) {
        if (this.f34152w != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f4, f5);
            ofFloat.setDuration(j4);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f4, f5);
            ofFloat2.setDuration(j4);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleX", f5, f4);
            ofFloat3.setDuration(j4);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleY", f5, f4);
            ofFloat4.setDuration(j4);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.play(ofFloat3).with(ofFloat4);
            animatorSet.play(ofFloat).before(ofFloat3);
            animatorSet.start();
        }
    }
}
