package com.bxkj.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.C3801R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SideBar extends AppCompatTextView {

    /* renamed from: a */
    private String[] f15243a;

    /* renamed from: b */
    private Paint f15244b;

    /* renamed from: c */
    private Paint f15245c;

    /* renamed from: d */
    private Paint f15246d;

    /* renamed from: e */
    private Canvas f15247e;

    /* renamed from: f */
    private int f15248f;

    /* renamed from: g */
    private int f15249g;

    /* renamed from: h */
    private int f15250h;

    /* renamed from: i */
    float f15251i;

    /* renamed from: j */
    private float f15252j;

    /* renamed from: k */
    private float f15253k;

    /* renamed from: l */
    private int f15254l;

    /* renamed from: m */
    private int f15255m;

    /* renamed from: n */
    private InterfaceC3999a f15256n;

    /* renamed from: com.bxkj.base.view.SideBar$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC3999a {
        /* renamed from: a */
        void mo43522a(int i, String str);
    }

    public SideBar(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m43526a(float f) {
        int i;
        int i2 = -1;
        if (f != 0.0f) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.f15243a;
                if (i3 >= strArr.length) {
                    break;
                }
                int i4 = i3 + 1;
                float f2 = this.f15248f * i4;
                if (f >= i * i3 && f < f2) {
                    InterfaceC3999a interfaceC3999a = this.f15256n;
                    if (interfaceC3999a != null) {
                        interfaceC3999a.mo43522a(i3, strArr[i3]);
                    }
                    Paint.FontMetrics fontMetrics = this.f15245c.getFontMetrics();
                    this.f15247e.drawText(this.f15243a[i3], ((this.f15249g - getPaddingRight()) - this.f15252j) - (fontMetrics.descent - fontMetrics.ascent), this.f15251i + (this.f15248f * i3), this.f15245c);
                    i2 = i3;
                }
                i3 = i4;
            }
        }
        m43524c(f, i2);
    }

    /* renamed from: b */
    private int m43525b(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    private void m43524c(float f, int i) {
        int i2;
        int i3 = 0;
        if (i == -1) {
            this.f15249g = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.f15250h = measuredHeight;
            this.f15248f = measuredHeight / this.f15243a.length;
            Paint.FontMetrics fontMetrics = this.f15244b.getFontMetrics();
            this.f15251i = fontMetrics.descent - fontMetrics.ascent;
            while (true) {
                String[] strArr = this.f15243a;
                if (i3 >= strArr.length) {
                    return;
                }
                this.f15247e.drawText(strArr[i3], this.f15249g - getPaddingRight(), this.f15251i + (this.f15248f * i3), this.f15244b);
                i3++;
            }
        } else {
            while (i3 < this.f15243a.length) {
                float f2 = this.f15251i;
                int i4 = this.f15248f;
                float f3 = (i4 * i3) + f2;
                if (i < i3) {
                    i2 = this.f15255m + i;
                } else {
                    i2 = i - this.f15255m;
                }
                float abs = 1.0f - Math.abs((f - f3) / ((f2 + (i4 * i2)) - f3));
                float paddingRight = this.f15249g - getPaddingRight();
                this.f15246d.setTextSize(getTextSize() + (getTextSize() * abs));
                float f4 = paddingRight - (this.f15252j * abs);
                if (f4 > paddingRight) {
                    this.f15247e.drawText(this.f15243a[i3], paddingRight, this.f15251i + (this.f15248f * i3), this.f15244b);
                } else {
                    this.f15247e.drawText(this.f15243a[i3], f4, this.f15251i + (this.f15248f * i3), this.f15246d);
                }
                i3++;
            }
        }
    }

    /* renamed from: d */
    private void m43523d(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C3801R.styleable.SideBar);
            this.f15254l = obtainStyledAttributes.getInteger(C3801R.styleable.SideBar_scaleSize, 1);
            this.f15255m = obtainStyledAttributes.getInteger(C3801R.styleable.SideBar_scaleItemCount, 6);
            this.f15252j = obtainStyledAttributes.getDimensionPixelSize(C3801R.styleable.SideBar_scaleWidth, m43525b(100));
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f15244b = paint;
        paint.setColor(getCurrentTextColor());
        this.f15244b.setTextSize(getTextSize());
        this.f15244b.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(1);
        this.f15245c = paint2;
        paint2.setColor(getCurrentTextColor());
        this.f15245c.setTextSize(getTextSize() * (this.f15254l + 3));
        this.f15245c.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.f15246d = paint3;
        paint3.setColor(getCurrentTextColor());
        this.f15246d.setTextSize(getTextSize() * (this.f15254l + 1));
        this.f15246d.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f15247e = canvas;
        m43526a(this.f15253k);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.f15253k = 0.0f;
                        invalidate();
                        return true;
                    }
                }
            } else if (motionEvent.getX() > ((this.f15249g - getPaddingRight()) - this.f15251i) - 10.0f) {
                this.f15253k = 0.0f;
                invalidate();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getX() > ((this.f15249g - getPaddingRight()) - this.f15251i) - 10.0f) {
            this.f15253k = motionEvent.getY();
            invalidate();
            return true;
        }
        this.f15253k = 0.0f;
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setDataResource(String[] strArr) {
        this.f15243a = strArr;
        invalidate();
    }

    public void setOnStrSelectCallBack(InterfaceC3999a interfaceC3999a) {
        this.f15256n = interfaceC3999a;
    }

    public void setScaleItemCount(int i) {
        this.f15255m = i;
        invalidate();
    }

    public void setScaleSize(int i) {
        this.f15254l = i;
        invalidate();
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15243a = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};
        this.f15253k = 0.0f;
        this.f15254l = 1;
        this.f15255m = 6;
        m43523d(attributeSet);
    }
}
