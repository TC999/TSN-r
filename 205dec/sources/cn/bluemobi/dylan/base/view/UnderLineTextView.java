package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import cn.bluemobi.dylan.base.R;
import cn.bluemobi.dylan.base.utils.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
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

    private void init(Context context, AttributeSet attributeSet, int i4) {
        this.spase = u.a(1.0f, context);
        this.density = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, i4, 0);
        this.mColor = obtainStyledAttributes.getColor(R.styleable.UnderlinedTextView_underlineColor, -65536);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.UnderlinedTextView_underlineWidth, this.density * 2.0f);
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
        for (int i4 = 0; i4 < lineCount; i4++) {
            int lineBounds = getLineBounds(i4, this.mRect);
            int lineStart = layout.getLineStart(i4);
            int lineEnd = layout.getLineEnd(i4);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            float f4 = lineBounds;
            float f5 = this.mStrokeWidth;
            float f6 = this.spase;
            canvas.drawLine(primaryHorizontal, f4 + f5 + f6, primaryHorizontal2, f4 + f5 + f6, this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void setUnderLineColor(int i4) {
        this.mColor = i4;
        invalidate();
    }

    public void setUnderlineWidth(float f4) {
        this.mStrokeWidth = f4;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context, attributeSet, i4);
    }
}
