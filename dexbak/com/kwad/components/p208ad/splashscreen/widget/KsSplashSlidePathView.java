package com.kwad.components.p208ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsSplashSlidePathView extends ImageView {

    /* renamed from: GM */
    private Path f27943GM;

    /* renamed from: GN */
    private Paint f27944GN;

    /* renamed from: GO */
    private float f27945GO;

    /* renamed from: GP */
    private float f27946GP;

    /* renamed from: GQ */
    private float f27947GQ;

    /* renamed from: GR */
    private float f27948GR;

    /* renamed from: GS */
    private int f27949GS;

    /* renamed from: GT */
    private InterfaceC8507a f27950GT;

    /* renamed from: GU */
    private GestureDetector f27951GU;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8507a {
        /* renamed from: a */
        void mo30498a(float f, float f2, float f3, float f4);

        /* renamed from: lu */
        void mo30497lu();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.f27949GS = Color.parseColor("#66ffffff");
        init();
    }

    /* renamed from: b */
    private void m30500b(MotionEvent motionEvent) {
        if (this.f27951GU.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f27943GM.reset();
            this.f27945GO = motionEvent.getX();
            float y = motionEvent.getY();
            this.f27946GP = y;
            float f = this.f27945GO;
            this.f27947GQ = f;
            this.f27948GR = y;
            this.f27943GM.moveTo(f, y);
            invalidate();
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            m30499c(motionEvent.getX(), motionEvent.getY());
            invalidate();
        } else {
            this.f27943GM.reset();
            invalidate();
            InterfaceC8507a interfaceC8507a = this.f27950GT;
            if (interfaceC8507a != null) {
                interfaceC8507a.mo30498a(this.f27945GO, this.f27946GP, motionEvent.getX(), motionEvent.getY());
            }
        }
    }

    /* renamed from: c */
    private void m30499c(float f, float f2) {
        float abs = Math.abs(f - this.f27947GQ);
        float abs2 = Math.abs(f2 - this.f27948GR);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.f27943GM;
            float f3 = this.f27947GQ;
            float f4 = this.f27948GR;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.f27947GQ = f;
            this.f27948GR = f2;
        }
    }

    private void init() {
        this.f27943GM = new Path();
        Paint paint = new Paint();
        this.f27944GN = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f27944GN.setStrokeWidth(C10751a.m24924a(getContext(), 15.0f));
        this.f27944GN.setStyle(Paint.Style.STROKE);
        this.f27944GN.setColor(this.f27949GS);
        this.f27944GN.setDither(true);
        this.f27951GU = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.f27950GT != null) {
                    KsSplashSlidePathView.this.f27950GT.mo30497lu();
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f27943GM, this.f27944GN);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        m30500b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(InterfaceC8507a interfaceC8507a) {
        this.f27950GT = interfaceC8507a;
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27949GS = Color.parseColor("#66ffffff");
        init();
    }
}
