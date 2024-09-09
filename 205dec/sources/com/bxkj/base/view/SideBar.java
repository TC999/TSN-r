package com.bxkj.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.bxkj.base.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SideBar extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private String[] f18813a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f18814b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f18815c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f18816d;

    /* renamed from: e  reason: collision with root package name */
    private Canvas f18817e;

    /* renamed from: f  reason: collision with root package name */
    private int f18818f;

    /* renamed from: g  reason: collision with root package name */
    private int f18819g;

    /* renamed from: h  reason: collision with root package name */
    private int f18820h;

    /* renamed from: i  reason: collision with root package name */
    float f18821i;

    /* renamed from: j  reason: collision with root package name */
    private float f18822j;

    /* renamed from: k  reason: collision with root package name */
    private float f18823k;

    /* renamed from: l  reason: collision with root package name */
    private int f18824l;

    /* renamed from: m  reason: collision with root package name */
    private int f18825m;

    /* renamed from: n  reason: collision with root package name */
    private a f18826n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a(int i4, String str);
    }

    public SideBar(Context context) {
        this(context, null);
    }

    private void a(float f4) {
        int i4;
        int i5 = -1;
        if (f4 != 0.0f) {
            int i6 = 0;
            while (true) {
                String[] strArr = this.f18813a;
                if (i6 >= strArr.length) {
                    break;
                }
                int i7 = i6 + 1;
                float f5 = this.f18818f * i7;
                if (f4 >= i4 * i6 && f4 < f5) {
                    a aVar = this.f18826n;
                    if (aVar != null) {
                        aVar.a(i6, strArr[i6]);
                    }
                    Paint.FontMetrics fontMetrics = this.f18815c.getFontMetrics();
                    this.f18817e.drawText(this.f18813a[i6], ((this.f18819g - getPaddingRight()) - this.f18822j) - (fontMetrics.descent - fontMetrics.ascent), this.f18821i + (this.f18818f * i6), this.f18815c);
                    i5 = i6;
                }
                i6 = i7;
            }
        }
        c(f4, i5);
    }

    private int b(int i4) {
        return (int) ((i4 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void c(float f4, int i4) {
        int i5;
        int i6 = 0;
        if (i4 == -1) {
            this.f18819g = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.f18820h = measuredHeight;
            this.f18818f = measuredHeight / this.f18813a.length;
            Paint.FontMetrics fontMetrics = this.f18814b.getFontMetrics();
            this.f18821i = fontMetrics.descent - fontMetrics.ascent;
            while (true) {
                String[] strArr = this.f18813a;
                if (i6 >= strArr.length) {
                    return;
                }
                this.f18817e.drawText(strArr[i6], this.f18819g - getPaddingRight(), this.f18821i + (this.f18818f * i6), this.f18814b);
                i6++;
            }
        } else {
            while (i6 < this.f18813a.length) {
                float f5 = this.f18821i;
                int i7 = this.f18818f;
                float f6 = (i7 * i6) + f5;
                if (i4 < i6) {
                    i5 = this.f18825m + i4;
                } else {
                    i5 = i4 - this.f18825m;
                }
                float abs = 1.0f - Math.abs((f4 - f6) / ((f5 + (i7 * i5)) - f6));
                float paddingRight = this.f18819g - getPaddingRight();
                this.f18816d.setTextSize(getTextSize() + (getTextSize() * abs));
                float f7 = paddingRight - (this.f18822j * abs);
                if (f7 > paddingRight) {
                    this.f18817e.drawText(this.f18813a[i6], paddingRight, this.f18821i + (this.f18818f * i6), this.f18814b);
                } else {
                    this.f18817e.drawText(this.f18813a[i6], f7, this.f18821i + (this.f18818f * i6), this.f18816d);
                }
                i6++;
            }
        }
    }

    private void d(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SideBar);
            this.f18824l = obtainStyledAttributes.getInteger(R.styleable.SideBar_scaleSize, 1);
            this.f18825m = obtainStyledAttributes.getInteger(R.styleable.SideBar_scaleItemCount, 6);
            this.f18822j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SideBar_scaleWidth, b(100));
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f18814b = paint;
        paint.setColor(getCurrentTextColor());
        this.f18814b.setTextSize(getTextSize());
        this.f18814b.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(1);
        this.f18815c = paint2;
        paint2.setColor(getCurrentTextColor());
        this.f18815c.setTextSize(getTextSize() * (this.f18824l + 3));
        this.f18815c.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.f18816d = paint3;
        paint3.setColor(getCurrentTextColor());
        this.f18816d.setTextSize(getTextSize() * (this.f18824l + 1));
        this.f18816d.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f18817e = canvas;
        a(this.f18823k);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.f18823k = 0.0f;
                        invalidate();
                        return true;
                    }
                }
            } else if (motionEvent.getX() > ((this.f18819g - getPaddingRight()) - this.f18821i) - 10.0f) {
                this.f18823k = 0.0f;
                invalidate();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getX() > ((this.f18819g - getPaddingRight()) - this.f18821i) - 10.0f) {
            this.f18823k = motionEvent.getY();
            invalidate();
            return true;
        }
        this.f18823k = 0.0f;
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setDataResource(String[] strArr) {
        this.f18813a = strArr;
        invalidate();
    }

    public void setOnStrSelectCallBack(a aVar) {
        this.f18826n = aVar;
    }

    public void setScaleItemCount(int i4) {
        this.f18825m = i4;
        invalidate();
    }

    public void setScaleSize(int i4) {
        this.f18824l = i4;
        invalidate();
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SideBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18813a = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.f18823k = 0.0f;
        this.f18824l = 1;
        this.f18825m = 6;
        d(attributeSet);
    }
}
