package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import cn.bluemobi.dylan.base.C1108R;
import cn.bluemobi.dylan.base.utils.Tools;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class UnderLineTextView extends AppCompatTextView {
    private float density;
    private int mColor;
    private Paint mPaint;
    private Rect mRect;
    private float mStrokeWidth;
    private float spase;

    public UnderLineTextView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.spase = Tools.m57620a(1.0f, context);
        this.density = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1108R.styleable.UnderlinedTextView, i, 0);
        this.mColor = obtainStyledAttributes.getColor(C1108R.styleable.UnderlinedTextView_underlineColor, SupportMenu.CATEGORY_MASK);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(C1108R.styleable.UnderlinedTextView_underlineWidth, this.density * 2.0f);
        obtainStyledAttributes.recycle();
        this.mRect = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
    }

    public int getUnderLineColor() {
        return this.mColor;
    }

    public float getUnderlineWidth() {
        return this.mStrokeWidth;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i = 0; i < lineCount; i++) {
            int lineBounds = getLineBounds(i, this.mRect);
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            float f = lineBounds;
            float f2 = this.mStrokeWidth;
            float f3 = this.spase;
            canvas.drawLine(primaryHorizontal, f + f2 + f3, primaryHorizontal2, f + f2 + f3, this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void setUnderLineColor(int i) {
        this.mColor = i;
        invalidate();
    }

    public void setUnderlineWidth(float f) {
        this.mStrokeWidth = f;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }
}
