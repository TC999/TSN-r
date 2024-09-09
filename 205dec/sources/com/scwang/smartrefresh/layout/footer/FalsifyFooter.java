package com.scwang.smartrefresh.layout.footer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.util.c;
import r0.d;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FalsifyFooter extends FalsifyHeader implements d {
    public FalsifyFooter(Context context) {
        super(context);
    }

    @Override // r0.d
    public boolean c(boolean z3) {
        return false;
    }

    @Override // r0.d
    public void d(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.d
    public void f(h hVar, int i4, int i5) {
        g gVar = this.f47996a;
        if (gVar != null) {
            gVar.b(RefreshState.None);
            this.f47996a.b(RefreshState.LoadFinish);
        }
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, r0.f
    public void o(g gVar, int i4, int i5) {
        super.o(gVar, i4, i5);
        gVar.n().s(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, android.view.View
    @SuppressLint({"DrawAllocation", "SetTextI18n"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            int b4 = c.b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(1157627903);
            paint.setStrokeWidth(c.b(1.0f));
            float f4 = b4;
            paint.setPathEffect(new DashPathEffect(new float[]{f4, f4, f4, f4}, 1.0f));
            canvas.drawRect(f4, f4, getWidth() - b4, getBottom() - b4, paint);
            TextView textView = new TextView(getContext());
            textView.setText(getClass().getSimpleName() + " \u865a\u5047\u533a\u57df\n\u8fd0\u884c\u65f6\u4ee3\u8868\u4e0a\u62c9Footer\u7684\u9ad8\u5ea6\u3010" + c.d(getHeight()) + "dp\u3011\n\u800c\u4e0d\u4f1a\u663e\u793a\u4efb\u4f55\u4e1c\u897f");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // r0.d
    public void t(float f4, int i4, int i5, int i6) {
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(21)
    public FalsifyFooter(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
