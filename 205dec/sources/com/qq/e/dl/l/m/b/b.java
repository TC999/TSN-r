package com.qq.e.dl.l.m.b;

import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.dl.l.m.b.a {

    /* renamed from: w  reason: collision with root package name */
    protected c f47252w;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public h a(com.qq.e.dl.a aVar) {
            return new b(aVar);
        }
    }

    public b(com.qq.e.dl.a aVar) {
        super(aVar);
        c cVar = new c(aVar.b());
        this.f47252w = cVar;
        cVar.a(this);
        this.f47070h = new d(this, this.f47252w);
    }

    @Override // com.qq.e.dl.l.h
    public void b(int[] iArr) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        this.f47252w.setShadowLayer(iArr[2], iArr[0], iArr[1], iArr[3]);
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void i(int i4) {
        this.f47252w.setGravity(i4);
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void j(int i4) {
        this.f47252w.setMaxLines(i4);
        this.f47252w.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void k(int i4) {
        this.f47252w.setTextColor(i4);
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void l(int i4) {
        this.f47252w.setTextSize(1, i4);
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void m(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0) {
            if (i5 == 1) {
                this.f47252w.setTypeface(Typeface.defaultFromStyle(1));
            } else if (i5 == 2) {
                this.f47252w.setTypeface(Typeface.defaultFromStyle(2));
            } else if (i5 == 3) {
                this.f47252w.setTypeface(Typeface.defaultFromStyle(3));
            }
        }
        int i6 = (i4 & 4) != 0 ? 16 : 0;
        if ((i4 & 8) != 0) {
            i6 |= 8;
        }
        if (i6 != 0) {
            TextPaint paint = this.f47252w.getPaint();
            paint.setFlags(i6 | paint.getFlags());
        }
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void a(CharSequence charSequence) {
        b(charSequence);
    }

    private void b(CharSequence charSequence) {
        this.f47252w.setText(charSequence);
    }

    @Override // com.qq.e.dl.l.m.b.a
    protected void a(boolean z3) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.f47252w.setAutoSizeTextTypeWithDefaults(z3 ? 1 : 0);
        this.f47252w.setAutoSizeTextTypeUniformWithConfiguration(12, 400, 1, 0);
    }

    @Override // com.qq.e.dl.l.h
    public View m() {
        return this.f47252w;
    }
}
