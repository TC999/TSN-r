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
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshFooter;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FalsifyFooter extends FalsifyHeader implements RefreshFooter {
    public FalsifyFooter(Context context) {
        super(context);
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: c */
    public boolean mo2106c(boolean z) {
        return false;
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: d */
    public void mo2105d(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: f */
    public void mo2104f(RefreshLayout refreshLayout, int i, int i2) {
        RefreshKernel refreshKernel = this.f33662a;
        if (refreshKernel != null) {
            refreshKernel.mo2093b(RefreshState.None);
            this.f33662a.mo2093b(RefreshState.LoadFinish);
        }
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        super.mo2098o(refreshKernel, i, i2);
        refreshKernel.mo2081n().mo2022s(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, android.view.View
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
            textView.setText(getClass().getSimpleName() + " 虚假区域\n运行时代表上拉Footer的高度【" + C11925c.m19764d(getHeight()) + "dp】\n而不会显示任何东西");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: t */
    public void mo2103t(float f, int i, int i2, int i3) {
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(21)
    public FalsifyFooter(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
