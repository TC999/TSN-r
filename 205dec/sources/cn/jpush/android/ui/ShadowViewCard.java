package cn.jpush.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ShadowViewCard extends RelativeLayout {
    private static final int DEFAULT_VALUE_SHADOW_BOTTOM_HEIGHT = 20;
    private static final int DEFAULT_VALUE_SHADOW_COLOR = Color.parseColor("#1f253044");
    private static final int DEFAULT_VALUE_SHADOW_LEFT_HEIGHT = 5;
    private static final int DEFAULT_VALUE_SHADOW_OFFSET_X = 0;
    private static final int DEFAULT_VALUE_SHADOW_OFFSET_Y = 8;
    private static final int DEFAULT_VALUE_SHADOW_RADIUS = 11;
    private static final int DEFAULT_VALUE_SHADOW_RIGHT_HEIGHT = 5;
    private static final int DEFAULT_VALUE_SHADOW_ROUND = 52;
    private static final int DEFAULT_VALUE_SHADOW_TOP_HEIGHT = 15;
    private int shadowBottomHeight;
    private int shadowColor;
    private int shadowLeftHeight;
    private int shadowOffsetX;
    private int shadowOffsetY;
    private int shadowRadius;
    private int shadowRightHeight;
    private int shadowRound;
    private int shadowTopHeight;

    public ShadowViewCard(Context context) {
        this(context, null);
    }

    public ShadowViewCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowViewCard(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        initView(context, attributeSet);
    }

    public static int dp2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.shadowRound = 52;
        this.shadowColor = DEFAULT_VALUE_SHADOW_COLOR;
        this.shadowTopHeight = 15;
        this.shadowRightHeight = 5;
        this.shadowLeftHeight = 5;
        this.shadowBottomHeight = 20;
        this.shadowOffsetX = 0;
        this.shadowOffsetY = 8;
        this.shadowRadius = 11;
        setPadding(5, 15, 5, 20);
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setShadowLayer(this.shadowRadius, this.shadowOffsetX, this.shadowOffsetY, this.shadowColor);
        RectF rectF = new RectF(this.shadowLeftHeight, this.shadowTopHeight, getWidth() - this.shadowRightHeight, getHeight() - this.shadowBottomHeight);
        int i4 = this.shadowRound;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        canvas.save();
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }
}
