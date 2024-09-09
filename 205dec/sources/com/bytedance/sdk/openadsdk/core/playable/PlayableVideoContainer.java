package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PlayableVideoContainer extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private final Paint f34401c;
    private View.OnClickListener ev;

    /* renamed from: f  reason: collision with root package name */
    private View f34402f;

    /* renamed from: r  reason: collision with root package name */
    private long f34403r;
    private FrameLayout sr;
    private View ux;

    /* renamed from: w  reason: collision with root package name */
    private float f34404w;
    private float xv;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.f34401c = new Paint();
        this.f34403r = 0L;
        w();
    }

    private void f() {
        int height;
        final int i4;
        final int i5;
        int width;
        int sr = xk.sr(getContext());
        int ux = xk.ux(getContext());
        final int left = getLeft();
        final int top2 = getTop();
        int left2 = getLeft();
        int right = sr - getRight();
        int top3 = getTop();
        int ux2 = xk.ux(getContext(), 20.0f);
        int min = Math.min(Math.min(left2, right), Math.min(top3, ux - getBottom()));
        if (left2 == min) {
            getWidth();
            int top4 = getTop();
            int bottom = getBottom();
            if (top4 < 0) {
                bottom = ux2 + getHeight();
                top4 = ux2;
            }
            i4 = bottom > ux ? (ux - ux2) - getHeight() : top4;
            i5 = ux2;
        } else if (right == min) {
            width = (sr - ux2) - getWidth();
            int top5 = getTop();
            int bottom2 = getBottom();
            if (top5 < 0) {
                bottom2 = ux2 + getHeight();
                top5 = ux2;
            }
            if (bottom2 > ux) {
                height = (ux - ux2) - getHeight();
                i5 = width;
                i4 = height;
            } else {
                i5 = width;
                i4 = top5;
            }
        } else if (top3 == min) {
            int left3 = getLeft();
            int right2 = getRight();
            getHeight();
            if (left3 < 0) {
                right2 = ux2 + getWidth();
                left3 = ux2;
            }
            i5 = right2 > sr ? (sr - ux2) - getWidth() : left3;
            i4 = ux2;
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            height = (ux - ux2) - getHeight();
            if (left4 < 0) {
                right3 = ux2 + getWidth();
                left4 = ux2;
            }
            if (right3 > sr) {
                width = (sr - ux2) - getWidth();
                i5 = width;
                i4 = height;
            } else {
                i4 = height;
                i5 = left4;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i6 = left;
                int i7 = (int) (i6 + ((i5 - i6) * animatedFraction));
                int i8 = top2;
                int i9 = (int) (i8 + ((i4 - i8) * animatedFraction));
                PlayableVideoContainer.this.c(i7, i9, PlayableVideoContainer.this.getWidth() + i7, PlayableVideoContainer.this.getHeight() + i9);
            }
        });
        duration.start();
    }

    private View sr() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387592);
        textView.setText("\u89c6\u9891\u5f02\u5e38\n\u65e0\u6cd5\u64ad\u653e");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private void ux() {
        View.OnClickListener onClickListener = this.ev;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void w() {
        int ux = xk.ux(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(ux, ux, ux, ux);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.sr = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.ux = xv();
        frameLayout.addView(this.ux, new ViewGroup.MarginLayoutParams(-1, -1));
        this.f34402f = sr();
        frameLayout.addView(this.f34402f, new ViewGroup.MarginLayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), xk.xv(ls.getContext(), 12.0f));
                }
            });
            setClipToOutline(true);
        }
    }

    private View xv() {
        int ux = xk.ux(getContext(), 8.0f);
        int ux2 = xk.ux(getContext(), 7.0f);
        int ux3 = xk.ux(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387592);
        textView.setText("\u53ef\u4ee5\n\u62d6\u52a8");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(i.xv(getContext(), "tt_arrow_up"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ux2, ux3);
        layoutParams2.setMargins(ux, ux, ux, ux);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageDrawable(i.xv(getContext(), "tt_arrow_down"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ux2, ux3);
        layoutParams3.setMargins(ux, ux, ux, ux);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        imageView3.setImageDrawable(i.xv(getContext(), "tt_arrow_left"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ux3, ux2);
        layoutParams4.setMargins(ux, ux, ux, ux);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        imageView4.setImageDrawable(i.xv(getContext(), "tt_arrow_right"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ux3, ux2);
        layoutParams5.setMargins(ux, ux, ux, ux);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    public void c() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = xk.ux(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = xk.ux(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j4) {
        boolean drawChild = super.drawChild(canvas, view, j4);
        this.f34401c.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.f34401c.setColor(-65536);
        this.f34401c.setStyle(Paint.Style.STROKE);
        this.f34401c.setAntiAlias(true);
        this.f34401c.setStrokeWidth(xk.xv(getContext(), 4.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), xk.xv(getContext(), 12.0f), xk.xv(getContext(), 12.0f), this.f34401c);
        }
        return drawChild;
    }

    public FrameLayout getVideoContainer() {
        return this.sr;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            super.onTouchEvent(r7)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto L80
            if (r0 == r1) goto L47
            r2 = 2
            if (r0 == r2) goto L14
            r7 = 3
            if (r0 == r7) goto L78
            goto L92
        L14:
            float r0 = r7.getX()
            float r2 = r6.f34404w
            float r0 = r0 - r2
            float r7 = r7.getY()
            float r2 = r6.xv
            float r7 = r7 - r2
            r2 = 0
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L92
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L92
            int r2 = r6.getLeft()
            float r2 = (float) r2
            float r2 = r2 + r0
            int r0 = (int) r2
            int r2 = r6.getWidth()
            int r2 = r2 + r0
            int r3 = r6.getTop()
            float r3 = (float) r3
            float r3 = r3 + r7
            int r7 = (int) r3
            int r3 = r6.getHeight()
            int r3 = r3 + r7
            r6.c(r0, r7, r2, r3)
            goto L92
        L47:
            float r0 = r7.getX()
            float r2 = r6.f34404w
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r7 = r7.getY()
            float r2 = r6.xv
            float r7 = r7 - r2
            float r7 = java.lang.Math.abs(r7)
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.f34403r
            long r2 = r2 - r4
            r4 = 1092616192(0x41200000, float:10.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L78
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L78
            r4 = 200(0xc8, double:9.9E-322)
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L78
            r6.ux()
            return r1
        L78:
            r6.f()
            r7 = 0
            r6.setPressed(r7)
            goto L92
        L80:
            float r0 = r7.getX()
            r6.f34404w = r0
            float r7 = r7.getY()
            r6.xv = r7
            long r2 = android.os.SystemClock.elapsedRealtime()
            r6.f34403r = r2
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.ev = onClickListener;
    }

    public void c(boolean z3) {
        if (z3) {
            xk.c(this.f34402f, 0);
            xk.c(this.ux, 8);
            return;
        }
        xk.c(this.f34402f, 8);
    }

    public void c(int i4, int i5, int i6, int i7) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = i5;
        layoutParams.gravity = 0;
        layout(i4, i5, i6, i7);
    }

    public void w(boolean z3) {
        if (z3) {
            xk.c(this.ux, 0);
            xk.c(this.f34402f, 8);
            return;
        }
        xk.c(this.ux, 8);
    }
}
