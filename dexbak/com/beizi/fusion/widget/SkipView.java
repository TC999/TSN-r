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
import com.beizi.fusion.p072g.C3138av;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SkipView extends TextView {

    /* renamed from: a */
    private int f11663a;

    /* renamed from: b */
    private TextPaint f11664b;

    /* renamed from: c */
    private float f11665c;

    /* renamed from: d */
    private float f11666d;

    /* renamed from: e */
    private boolean f11667e;

    /* renamed from: f */
    private RectF f11668f;

    /* renamed from: g */
    private RectF f11669g;

    /* renamed from: h */
    private int f11670h;

    /* renamed from: i */
    private boolean f11671i;

    /* renamed from: j */
    private SparseIntArray f11672j;

    /* renamed from: k */
    private final InterfaceC3223a f11673k;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.fusion.widget.SkipView$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3223a {
        /* renamed from: a */
        int mo48044a(int i, RectF rectF);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11666d = 20.0f;
        this.f11668f = new RectF();
        this.f11671i = true;
        this.f11673k = new InterfaceC3223a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.InterfaceC3223a
            @TargetApi(16)
            /* renamed from: a */
            public int mo48044a(int i2, RectF rectF) {
                SkipView.this.f11664b.setTextSize(i2);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f11668f.bottom = SkipView.this.f11664b.getFontSpacing();
                SkipView.this.f11668f.right = SkipView.this.f11664b.measureText(charSequence);
                SkipView.this.f11668f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f11668f) ? -1 : 1;
            }
        };
        init(context);
    }

    public void init(Context context) {
        setGravity(17);
        setLines(1);
        setMaxLines(1);
        setTextColor(-1);
        m48049a(context, 0);
        TextPaint textPaint = new TextPaint();
        this.f11664b = textPaint;
        textPaint.set(getPaint());
        this.f11665c = getTextSize();
        this.f11669g = new RectF();
        this.f11672j = new SparseIntArray();
        this.f11667e = true;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        SparseIntArray sparseIntArray = this.f11672j;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        m48051a();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m48051a();
    }

    public void setData(int i, int i2) {
        m48049a(getContext(), i);
        this.f11663a = i2;
    }

    /* renamed from: a */
    private void m48049a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            gradientDrawable.setStroke(1, Color.parseColor("#C0C0C0"));
        }
        gradientDrawable.setCornerRadius(C3138av.m48304a(context, 45.0f));
        setBackgroundDrawable(gradientDrawable);
    }

    /* renamed from: b */
    private static int m48046b(int i, int i2, InterfaceC3223a interfaceC3223a, RectF rectF) {
        int i3 = i2 - 1;
        int i4 = i;
        while (i <= i3) {
            i4 = (i + i3) >>> 1;
            int mo48044a = interfaceC3223a.mo48044a(i4, rectF);
            if (mo48044a >= 0) {
                if (mo48044a <= 0) {
                    break;
                }
                i4--;
                i3 = i4;
            } else {
                int i5 = i4 + 1;
                i4 = i;
                i = i5;
            }
        }
        return i4;
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11666d = 20.0f;
        this.f11668f = new RectF();
        this.f11671i = true;
        this.f11673k = new InterfaceC3223a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.InterfaceC3223a
            @TargetApi(16)
            /* renamed from: a */
            public int mo48044a(int i2, RectF rectF) {
                SkipView.this.f11664b.setTextSize(i2);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f11668f.bottom = SkipView.this.f11664b.getFontSpacing();
                SkipView.this.f11668f.right = SkipView.this.f11664b.measureText(charSequence);
                SkipView.this.f11668f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f11668f) ? -1 : 1;
            }
        };
        init(context);
    }

    /* renamed from: a */
    private void m48051a() {
        m48047a(getText().toString());
    }

    /* renamed from: a */
    private void m48047a(String str) {
        if (this.f11667e) {
            int measuredHeight = ((getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop()) - this.f11663a;
            int measuredWidth = ((getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - C3138av.m48304a(getContext(), 8.0f);
            this.f11670h = measuredWidth;
            RectF rectF = this.f11669g;
            rectF.right = measuredWidth;
            rectF.bottom = measuredHeight;
            super.setTextSize(0, m48050a((int) this.f11666d, (int) this.f11665c, this.f11673k, rectF));
        }
    }

    public SkipView(Context context) {
        super(context);
        this.f11666d = 20.0f;
        this.f11668f = new RectF();
        this.f11671i = true;
        this.f11673k = new InterfaceC3223a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.InterfaceC3223a
            @TargetApi(16)
            /* renamed from: a */
            public int mo48044a(int i2, RectF rectF) {
                SkipView.this.f11664b.setTextSize(i2);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f11668f.bottom = SkipView.this.f11664b.getFontSpacing();
                SkipView.this.f11668f.right = SkipView.this.f11664b.measureText(charSequence);
                SkipView.this.f11668f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f11668f) ? -1 : 1;
            }
        };
        init(context);
    }

    /* renamed from: a */
    private int m48050a(int i, int i2, InterfaceC3223a interfaceC3223a, RectF rectF) {
        if (!this.f11671i) {
            return m48046b(i, i2, interfaceC3223a, rectF);
        }
        String charSequence = getText().toString();
        int length = charSequence == null ? 0 : charSequence.length();
        int i3 = this.f11672j.get(length);
        if (i3 != 0) {
            return i3;
        }
        int m48046b = m48046b(i, i2, interfaceC3223a, rectF);
        this.f11672j.put(length, m48046b);
        return m48046b;
    }
}
