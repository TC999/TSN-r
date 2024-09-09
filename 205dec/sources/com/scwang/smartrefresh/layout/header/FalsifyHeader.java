package com.scwang.smartrefresh.layout.header;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FalsifyHeader extends View implements e {

    /* renamed from: a  reason: collision with root package name */
    protected g f47996a;

    public FalsifyHeader(Context context) {
        super(context);
    }

    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    public void i(float f4, int i4, int i5, int i6) {
    }

    public void j(h hVar, int i4, int i5) {
        g gVar = this.f47996a;
        if (gVar != null) {
            gVar.b(RefreshState.None);
            this.f47996a.b(RefreshState.RefreshFinish);
        }
    }

    public void n(float f4, int i4, int i5) {
    }

    public void o(g gVar, int i4, int i5) {
        this.f47996a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
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
            textView.setText(getClass().getSimpleName() + " \u865a\u5047\u533a\u57df\n\u8fd0\u884c\u65f6\u4ee3\u8868\u4e0b\u62c9Header\u7684\u9ad8\u5ea6\u3010" + c.d(getHeight()) + "dp\u3011\n\u800c\u4e0d\u4f1a\u663e\u793a\u4efb\u4f55\u4e1c\u897f");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    public boolean p() {
        return false;
    }

    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    public void u(h hVar, int i4, int i5) {
    }

    public int v(h hVar, boolean z3) {
        return 0;
    }

    public void w(float f4, int i4, int i5, int i6) {
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(21)
    public FalsifyHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
