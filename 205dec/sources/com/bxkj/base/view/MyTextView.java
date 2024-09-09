package com.bxkj.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import cn.bluemobi.dylan.base.utils.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private int f18808a;

    public MyTextView(Context context) {
        super(context);
        this.f18808a = -65536;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(u.a(0.0f, getContext()), u.a(0.0f, getContext()));
        path.lineTo(u.a(50.0f, getContext()), u.a(0.0f, getContext()));
        path.lineTo(u.a(50.0f, getContext()), u.a(50.0f, getContext()));
        path.close();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            if (color != 0) {
                this.f18808a = color;
            }
            setBackgroundColor(0);
        }
        Paint paint = new Paint();
        paint.setColor(this.f18808a);
        canvas.drawPath(path, paint);
        canvas.rotate(45.0f, u.a(40.0f, getContext()), u.a(30.0f, getContext()));
        super.onDraw(canvas);
    }

    public MyTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18808a = -65536;
    }

    public MyTextView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18808a = -65536;
    }
}
