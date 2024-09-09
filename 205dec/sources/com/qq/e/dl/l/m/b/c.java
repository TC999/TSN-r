package com.qq.e.dl.l.m.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.MetricAffectingSpan;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.qq.e.dl.l.e;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends TextView implements e {

    /* renamed from: c  reason: collision with root package name */
    private h f47253c;

    public c(Context context) {
        super(context);
        getPaint().setAntiAlias(true);
        setIncludeFontPadding(false);
    }

    private void a(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
            MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(0, spanned.length(), MetricAffectingSpan.class);
            if (metricAffectingSpanArr != null && metricAffectingSpanArr.length > 0) {
                for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                    int spanStart = spannableStringBuilder.getSpanStart(metricAffectingSpan);
                    if (a(spannableStringBuilder, spanStart - 1)) {
                        spannableStringBuilder.insert(spanStart, (CharSequence) " ");
                    }
                    int spanEnd = spannableStringBuilder.getSpanEnd(metricAffectingSpan);
                    if (a(spannableStringBuilder, spanEnd)) {
                        spannableStringBuilder.insert(spanEnd, (CharSequence) " ");
                    }
                }
            }
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i4;
        h hVar = this.f47253c;
        com.qq.e.dl.l.i.d g4 = hVar == null ? null : hVar.g();
        int i5 = 0;
        if (g4 != null) {
            i5 = getWidth();
            i4 = getHeight();
            g4.a(canvas, i5, i4);
        } else {
            i4 = 0;
        }
        super.draw(canvas);
        if (g4 != null) {
            g4.b(canvas, i5, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i4, int i5) {
        com.qq.e.dl.l.k.a i6 = this.f47253c.i();
        Pair<Integer, Integer> d4 = i6.d(i4, i5);
        super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
        Pair<Integer, Integer> c4 = i6.c(i4, i5);
        if (c4 != null) {
            super.setMeasuredDimension(View.MeasureSpec.getSize(((Integer) c4.first).intValue()), View.MeasureSpec.getSize(((Integer) c4.second).intValue()));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        this.f47253c.a(view, i4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f47253c.e(i4);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (IndexOutOfBoundsException unused) {
            a(charSequence, bufferType);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        try {
            super.setTypeface(typeface);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private boolean a(CharSequence charSequence, int i4) {
        return i4 < 0 || i4 >= charSequence.length() || charSequence.charAt(i4) != ' ';
    }

    @Override // com.qq.e.dl.l.e
    public void a(h hVar) {
        this.f47253c = hVar;
    }
}
