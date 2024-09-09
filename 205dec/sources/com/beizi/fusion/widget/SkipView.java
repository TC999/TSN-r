package com.beizi.fusion.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.fusion.g.aw;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SkipView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f15251a;

    /* renamed from: b  reason: collision with root package name */
    private TextPaint f15252b;

    /* renamed from: c  reason: collision with root package name */
    private float f15253c;

    /* renamed from: d  reason: collision with root package name */
    private float f15254d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15255e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f15256f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f15257g;

    /* renamed from: h  reason: collision with root package name */
    private int f15258h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15259i;

    /* renamed from: j  reason: collision with root package name */
    private SparseIntArray f15260j;

    /* renamed from: k  reason: collision with root package name */
    private final a f15261k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        int a(int i4, RectF rectF);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15254d = 20.0f;
        this.f15256f = new RectF();
        this.f15259i = true;
        this.f15261k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i5, RectF rectF) {
                SkipView.this.f15252b.setTextSize(i5);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f15256f.bottom = SkipView.this.f15252b.getFontSpacing();
                SkipView.this.f15256f.right = SkipView.this.f15252b.measureText(charSequence);
                SkipView.this.f15256f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f15256f) ? -1 : 1;
            }
        };
        init(context);
    }

    public void init(Context context) {
        setGravity(17);
        setLines(1);
        setMaxLines(1);
        setTextColor(-1);
        a(context, 0);
        TextPaint textPaint = new TextPaint();
        this.f15252b = textPaint;
        textPaint.set(getPaint());
        this.f15253c = getTextSize();
        this.f15257g = new RectF();
        this.f15260j = new SparseIntArray();
        this.f15255e = true;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        SparseIntArray sparseIntArray = this.f15260j;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 == i6 && i5 == i7) {
            return;
        }
        a();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        a();
    }

    public void setData(int i4, int i5) {
        a(getContext(), i4);
        this.f15251a = i5;
    }

    private void a(Context context, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i4 == 1) {
            gradientDrawable.setStroke(1, Color.parseColor("#C0C0C0"));
        }
        gradientDrawable.setCornerRadius(aw.a(context, 45.0f));
        setBackgroundDrawable(gradientDrawable);
    }

    private static int b(int i4, int i5, a aVar, RectF rectF) {
        int i6 = i5 - 1;
        int i7 = i4;
        while (i4 <= i6) {
            i7 = (i4 + i6) >>> 1;
            int a4 = aVar.a(i7, rectF);
            if (a4 >= 0) {
                if (a4 <= 0) {
                    break;
                }
                i7--;
                i6 = i7;
            } else {
                int i8 = i7 + 1;
                i7 = i4;
                i4 = i8;
            }
        }
        return i7;
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15254d = 20.0f;
        this.f15256f = new RectF();
        this.f15259i = true;
        this.f15261k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i5, RectF rectF) {
                SkipView.this.f15252b.setTextSize(i5);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f15256f.bottom = SkipView.this.f15252b.getFontSpacing();
                SkipView.this.f15256f.right = SkipView.this.f15252b.measureText(charSequence);
                SkipView.this.f15256f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f15256f) ? -1 : 1;
            }
        };
        init(context);
    }

    private void a() {
        a(getText().toString());
    }

    private void a(String str) {
        if (this.f15255e) {
            int measuredHeight = ((getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop()) - this.f15251a;
            int measuredWidth = ((getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - aw.a(getContext(), 8.0f);
            this.f15258h = measuredWidth;
            RectF rectF = this.f15257g;
            rectF.right = measuredWidth;
            rectF.bottom = measuredHeight;
            super.setTextSize(0, a((int) this.f15254d, (int) this.f15253c, this.f15261k, rectF));
        }
    }

    public SkipView(Context context) {
        super(context);
        this.f15254d = 20.0f;
        this.f15256f = new RectF();
        this.f15259i = true;
        this.f15261k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i5, RectF rectF) {
                SkipView.this.f15252b.setTextSize(i5);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f15256f.bottom = SkipView.this.f15252b.getFontSpacing();
                SkipView.this.f15256f.right = SkipView.this.f15252b.measureText(charSequence);
                SkipView.this.f15256f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f15256f) ? -1 : 1;
            }
        };
        init(context);
    }

    private int a(int i4, int i5, a aVar, RectF rectF) {
        if (!this.f15259i) {
            return b(i4, i5, aVar, rectF);
        }
        String charSequence = getText().toString();
        int length = charSequence == null ? 0 : charSequence.length();
        int i6 = this.f15260j.get(length);
        if (i6 != 0) {
            return i6;
        }
        int b4 = b(i4, i5, aVar, rectF);
        this.f15260j.put(length, b4);
        return b4;
    }
}
