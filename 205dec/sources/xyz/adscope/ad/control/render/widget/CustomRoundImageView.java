package xyz.adscope.ad.control.render.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CustomRoundImageView extends AppCompatImageView {
    private String borderColor;
    private int borderWidth;
    private final Paint maskPaint;
    private float rectRadius;
    private final RectF roundRect;
    private final Paint zonePaint;

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.roundRect = new RectF();
        this.rectRadius = 0.0f;
        this.borderColor = null;
        this.borderWidth = 0;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        init();
    }

    private void init() {
        this.maskPaint.setAntiAlias(true);
        this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.zonePaint.setAntiAlias(true);
        this.zonePaint.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.roundRect, this.zonePaint, 31);
        RectF rectF = this.roundRect;
        float f4 = this.rectRadius;
        canvas.drawRoundRect(rectF, f4, f4, this.zonePaint);
        canvas.saveLayer(this.roundRect, this.maskPaint, 31);
        super.draw(canvas);
        if (this.borderWidth > 0 && !TextUtils.isEmpty(this.borderColor) && this.borderColor.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.borderColor));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.borderWidth);
            paint.setAntiAlias(true);
            RectF rectF2 = this.roundRect;
            float f5 = this.rectRadius;
            canvas.drawRoundRect(rectF2, f5, f5, paint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.roundRect.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setBorderColor(String str) {
        this.borderColor = str;
        invalidate();
    }

    public void setBorderWidth(int i4) {
        this.borderWidth = i4;
        invalidate();
    }

    public void setRectRadius(float f4) {
        this.rectRadius = f4;
        invalidate();
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.roundRect = new RectF();
        this.rectRadius = 0.0f;
        this.borderColor = null;
        this.borderWidth = 0;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        init();
    }

    public CustomRoundImageView(Context context) {
        super(context);
        this.roundRect = new RectF();
        this.rectRadius = 0.0f;
        this.borderColor = null;
        this.borderWidth = 0;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        init();
    }
}
