package com.kwad.components.ad.splashscreen.widget;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path GM;
    private Paint GN;
    private float GO;
    private float GP;
    private float GQ;
    private float GR;
    private int GS;
    private a GT;
    private GestureDetector GU;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(float f4, float f5, float f6, float f7);

        void lu();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.GS = Color.parseColor("#66ffffff");
        init();
    }

    private void b(MotionEvent motionEvent) {
        if (this.GU.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.GM.reset();
            this.GO = motionEvent.getX();
            float y3 = motionEvent.getY();
            this.GP = y3;
            float f4 = this.GO;
            this.GQ = f4;
            this.GR = y3;
            this.GM.moveTo(f4, y3);
            invalidate();
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            c(motionEvent.getX(), motionEvent.getY());
            invalidate();
        } else {
            this.GM.reset();
            invalidate();
            a aVar = this.GT;
            if (aVar != null) {
                aVar.a(this.GO, this.GP, motionEvent.getX(), motionEvent.getY());
            }
        }
    }

    private void c(float f4, float f5) {
        float abs = Math.abs(f4 - this.GQ);
        float abs2 = Math.abs(f5 - this.GR);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.GM;
            float f6 = this.GQ;
            float f7 = this.GR;
            path.quadTo(f6, f7, (f4 + f6) / 2.0f, (f5 + f7) / 2.0f);
            this.GQ = f4;
            this.GR = f5;
        }
    }

    private void init() {
        this.GM = new Path();
        Paint paint = new Paint();
        this.GN = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.GN.setStrokeWidth(com.kwad.sdk.d.a.a.a(getContext(), 15.0f));
        this.GN.setStyle(Paint.Style.STROKE);
        this.GN.setColor(this.GS);
        this.GN.setDither(true);
        this.GU = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.GT != null) {
                    KsSplashSlidePathView.this.GT.lu();
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.GM, this.GN);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.GT = aVar;
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = Color.parseColor("#66ffffff");
        init();
    }
}
