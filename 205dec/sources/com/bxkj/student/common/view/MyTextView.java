package com.bxkj.student.common.view;

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
    private int color;

    public MyTextView(Context context) {
        super(context);
        this.color = -65536;
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
                this.color = color;
            }
            setBackgroundColor(0);
        }
        Paint paint = new Paint();
        paint.setColor(this.color);
        canvas.drawPath(path, paint);
        canvas.rotate(45.0f, u.a(40.0f, getContext()), u.a(30.0f, getContext()));
        super.onDraw(canvas);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.color = -65536;
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.color = -65536;
    }
}
