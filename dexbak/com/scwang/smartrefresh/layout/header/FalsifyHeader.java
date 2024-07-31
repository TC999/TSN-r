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
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FalsifyHeader extends View implements RefreshHeader {

    /* renamed from: a */
    protected RefreshKernel f33662a;

    public FalsifyHeader(Context context) {
        super(context);
    }

    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
    }

    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        RefreshKernel refreshKernel = this.f33662a;
        if (refreshKernel != null) {
            refreshKernel.mo2093b(RefreshState.None);
            this.f33662a.mo2093b(RefreshState.RefreshFinish);
        }
    }

    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        this.f33662a = refreshKernel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    @SuppressLint({"DrawAllocation", "SetTextI18n"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            int m19766b = C11925c.m19766b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(1157627903);
            paint.setStrokeWidth(C11925c.m19766b(1.0f));
            float f = m19766b;
            paint.setPathEffect(new DashPathEffect(new float[]{f, f, f, f}, 1.0f));
            canvas.drawRect(f, f, getWidth() - m19766b, getBottom() - m19766b, paint);
            TextView textView = new TextView(getContext());
            textView.setText(getClass().getSimpleName() + " 虚假区域\n运行时代表下拉Header的高度【" + C11925c.m19764d(getHeight()) + "dp】\n而不会显示任何东西");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        return 0;
    }

    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(21)
    public FalsifyHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
