package com.kwad.components.p208ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.p208ad.splashscreen.widget.SkipView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CircleSkipView extends KSFrameLayout implements InterfaceC8512a {

    /* renamed from: FA */
    private int f27898FA;

    /* renamed from: FB */
    private ValueAnimator f27899FB;

    /* renamed from: FC */
    private boolean f27900FC;

    /* renamed from: FD */
    private SkipView.InterfaceC8510a f27901FD;

    /* renamed from: FE */
    private long f27902FE;

    /* renamed from: FF */
    private float f27903FF;

    /* renamed from: Fy */
    private float f27904Fy;

    /* renamed from: Fz */
    private float f27905Fz;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;

    /* renamed from: sB */
    private boolean f27906sB;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    /* renamed from: S */
    private void m30542S(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        m30541T(context);
        addView(m30540U(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.f27901FD != null) {
                    CircleSkipView.this.f27901FD.mo30482la();
                }
            }
        });
    }

    /* renamed from: T */
    private void m30541T(Context context) {
        this.f27898FA = C10751a.m24924a(context, 2.0f);
        int m24924a = C10751a.m24924a(context, 32.0f);
        int i = this.f27898FA;
        this.radius = m24924a - i;
        this.padding = i / 2;
        int i2 = this.padding;
        int i3 = this.radius;
        this.mRectF = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    /* renamed from: U */
    private static TextView m30540U(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(C9659R.C9664string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m30539X(int i) {
        SkipView.InterfaceC8510a interfaceC8510a = this.f27901FD;
        if (interfaceC8510a != null) {
            interfaceC8510a.mo30483Y(i);
        }
    }

    /* renamed from: lP */
    private void m30530lP() {
        this.f27900FC = true;
        ValueAnimator valueAnimator = this.f27899FB;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.f27902FE);
            this.f27899FB.start();
        }
    }

    /* renamed from: lQ */
    private void m30529lQ() {
        this.f27900FC = false;
        ValueAnimator valueAnimator = this.f27899FB;
        if (valueAnimator != null) {
            this.f27902FE = valueAnimator.getCurrentPlayTime();
            this.f27899FB.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f27898FA);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f27898FA);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: A */
    public final void mo30464A(AdInfo adInfo) {
        m30529lQ();
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: B */
    public final void mo30463B(AdInfo adInfo) {
        m30530lP();
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: aa */
    public final int mo30461aa(int i) {
        getLayoutParams().height = C10751a.m24924a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: bf */
    public final void mo30460bf() {
        m30529lQ();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.f27898FA, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.f27900FC) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.f27904Fy, -this.f27905Fz, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    public void setOnViewListener(SkipView.InterfaceC8510a interfaceC8510a) {
        this.f27901FD = interfaceC8510a;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: c */
    private void m30532c(final int i, final boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f27899FB = ofFloat;
        ofFloat.setDuration(i);
        this.f27899FB.setInterpolator(new LinearInterpolator());
        this.f27899FB.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.f27903FF != 1.0f || CircleSkipView.this.f27901FD == null) {
                    return;
                }
                CircleSkipView.this.f27901FD.mo30481lb();
            }
        });
        this.f27899FB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.f27903FF = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.m30539X((int) ((i / 1000) * circleSkipView.f27903FF));
                if (z) {
                    CircleSkipView.m30535a(CircleSkipView.this, true);
                    float f = floatValue * 360.0f;
                    CircleSkipView.this.f27904Fy = 270.0f - f;
                    CircleSkipView.this.f27905Fz = 360.0f - f;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.f27904Fy = 270.0f;
        this.f27905Fz = 360.0f;
        this.radius = 0;
        this.f27898FA = 0;
        this.f27900FC = false;
        this.f27902FE = 0L;
        this.f27903FF = 0.0f;
        this.padding = 0;
        this.f27906sB = true;
        m30542S(context);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m30535a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.f27900FC = true;
        return true;
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: a */
    public final void mo30462a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.f27906sB = C10483a.m25802cx(adInfo);
        boolean m25801cy = C10483a.m25801cy(adInfo);
        if (this.f27906sB) {
            setVisibility(0);
        }
        m30532c(splashSkipViewModel.skipSecond * 1000, m25801cy);
    }
}
