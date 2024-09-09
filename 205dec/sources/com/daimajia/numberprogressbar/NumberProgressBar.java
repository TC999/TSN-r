package com.daimajia.numberprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class NumberProgressBar extends View {
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_REACHED_BAR_COLOR = "reached_bar_color";
    private static final String INSTANCE_REACHED_BAR_HEIGHT = "reached_bar_height";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_TEXT_VISIBILITY = "text_visibility";
    private static final String INSTANCE_UNREACHED_BAR_COLOR = "unreached_bar_color";
    private static final String INSTANCE_UNREACHED_BAR_HEIGHT = "unreached_bar_height";
    private static final int PROGRESS_TEXT_VISIBLE = 0;
    private final float default_progress_text_offset;
    private final float default_reached_bar_height;
    private final int default_reached_color;
    private final int default_text_color;
    private final float default_text_size;
    private final float default_unreached_bar_height;
    private final int default_unreached_color;
    private String mCurrentDrawText;
    private int mCurrentProgress;
    private boolean mDrawReachedBar;
    private float mDrawTextEnd;
    private float mDrawTextStart;
    private float mDrawTextWidth;
    private boolean mDrawUnreachedBar;
    private boolean mIfDrawText;
    private OnProgressBarListener mListener;
    private int mMaxProgress;
    private float mOffset;
    private String mPrefix;
    private int mReachedBarColor;
    private float mReachedBarHeight;
    private Paint mReachedBarPaint;
    private RectF mReachedRectF;
    private String mSuffix;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;
    private int mUnreachedBarColor;
    private float mUnreachedBarHeight;
    private Paint mUnreachedBarPaint;
    private RectF mUnreachedRectF;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum ProgressTextVisibility {
        Visible,
        Invisible
    }

    public NumberProgressBar(Context context) {
        this(context, null);
    }

    private void calculateDrawRectF() {
        this.mCurrentDrawText = String.format("%d", Integer.valueOf((getProgress() * 100) / getMax()));
        String str = this.mPrefix + this.mCurrentDrawText + this.mSuffix;
        this.mCurrentDrawText = str;
        this.mDrawTextWidth = this.mTextPaint.measureText(str);
        if (getProgress() == 0) {
            this.mDrawReachedBar = false;
            this.mDrawTextStart = getPaddingLeft();
        } else {
            this.mDrawReachedBar = true;
            this.mReachedRectF.left = getPaddingLeft();
            this.mReachedRectF.top = (getHeight() / 2.0f) - (this.mReachedBarHeight / 2.0f);
            this.mReachedRectF.right = (((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (getMax() * 1.0f)) * getProgress()) - this.mOffset) + getPaddingLeft();
            this.mReachedRectF.bottom = (getHeight() / 2.0f) + (this.mReachedBarHeight / 2.0f);
            this.mDrawTextStart = this.mReachedRectF.right + this.mOffset;
        }
        this.mDrawTextEnd = (int) ((getHeight() / 2.0f) - ((this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0f));
        if (this.mDrawTextStart + this.mDrawTextWidth >= getWidth() - getPaddingRight()) {
            float width = (getWidth() - getPaddingRight()) - this.mDrawTextWidth;
            this.mDrawTextStart = width;
            this.mReachedRectF.right = width - this.mOffset;
        }
        float f4 = this.mDrawTextStart + this.mDrawTextWidth + this.mOffset;
        if (f4 >= getWidth() - getPaddingRight()) {
            this.mDrawUnreachedBar = false;
            return;
        }
        this.mDrawUnreachedBar = true;
        RectF rectF = this.mUnreachedRectF;
        rectF.left = f4;
        rectF.right = getWidth() - getPaddingRight();
        this.mUnreachedRectF.top = (getHeight() / 2.0f) + ((-this.mUnreachedBarHeight) / 2.0f);
        this.mUnreachedRectF.bottom = (getHeight() / 2.0f) + (this.mUnreachedBarHeight / 2.0f);
    }

    private void calculateDrawRectFWithoutProgressText() {
        this.mReachedRectF.left = getPaddingLeft();
        this.mReachedRectF.top = (getHeight() / 2.0f) - (this.mReachedBarHeight / 2.0f);
        this.mReachedRectF.right = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (getMax() * 1.0f)) * getProgress()) + getPaddingLeft();
        this.mReachedRectF.bottom = (getHeight() / 2.0f) + (this.mReachedBarHeight / 2.0f);
        RectF rectF = this.mUnreachedRectF;
        rectF.left = this.mReachedRectF.right;
        rectF.right = getWidth() - getPaddingRight();
        this.mUnreachedRectF.top = (getHeight() / 2.0f) + ((-this.mUnreachedBarHeight) / 2.0f);
        this.mUnreachedRectF.bottom = (getHeight() / 2.0f) + (this.mUnreachedBarHeight / 2.0f);
    }

    private void initializePainters() {
        Paint paint = new Paint(1);
        this.mReachedBarPaint = paint;
        paint.setColor(this.mReachedBarColor);
        Paint paint2 = new Paint(1);
        this.mUnreachedBarPaint = paint2;
        paint2.setColor(this.mUnreachedBarColor);
        Paint paint3 = new Paint(1);
        this.mTextPaint = paint3;
        paint3.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(this.mTextSize);
    }

    private int measure(int i4, boolean z3) {
        int paddingTop;
        int paddingBottom;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (z3) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i5 = paddingTop + paddingBottom;
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = (z3 ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight()) + i5;
        if (mode == Integer.MIN_VALUE) {
            if (z3) {
                return Math.max(suggestedMinimumWidth, size);
            }
            return Math.min(suggestedMinimumWidth, size);
        }
        return suggestedMinimumWidth;
    }

    public float dp2px(float f4) {
        return (f4 * getResources().getDisplayMetrics().density) + 0.5f;
    }

    public int getMax() {
        return this.mMaxProgress;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public int getProgress() {
        return this.mCurrentProgress;
    }

    public float getProgressTextSize() {
        return this.mTextSize;
    }

    public boolean getProgressTextVisibility() {
        return this.mIfDrawText;
    }

    public int getReachedBarColor() {
        return this.mReachedBarColor;
    }

    public float getReachedBarHeight() {
        return this.mReachedBarHeight;
    }

    public String getSuffix() {
        return this.mSuffix;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) this.mTextSize, Math.max((int) this.mReachedBarHeight, (int) this.mUnreachedBarHeight));
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) this.mTextSize;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getUnreachedBarColor() {
        return this.mUnreachedBarColor;
    }

    public float getUnreachedBarHeight() {
        return this.mUnreachedBarHeight;
    }

    public void incrementProgressBy(int i4) {
        if (i4 > 0) {
            setProgress(getProgress() + i4);
        }
        OnProgressBarListener onProgressBarListener = this.mListener;
        if (onProgressBarListener != null) {
            onProgressBarListener.onProgressChange(getProgress(), getMax());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mIfDrawText) {
            calculateDrawRectF();
        } else {
            calculateDrawRectFWithoutProgressText();
        }
        if (this.mDrawReachedBar) {
            canvas.drawRect(this.mReachedRectF, this.mReachedBarPaint);
        }
        if (this.mDrawUnreachedBar) {
            canvas.drawRect(this.mUnreachedRectF, this.mUnreachedBarPaint);
        }
        if (this.mIfDrawText) {
            canvas.drawText(this.mCurrentDrawText, this.mDrawTextStart, this.mDrawTextEnd, this.mTextPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(measure(i4, true), measure(i5, false));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mTextColor = bundle.getInt("text_color");
            this.mTextSize = bundle.getFloat("text_size");
            this.mReachedBarHeight = bundle.getFloat("reached_bar_height");
            this.mUnreachedBarHeight = bundle.getFloat("unreached_bar_height");
            this.mReachedBarColor = bundle.getInt("reached_bar_color");
            this.mUnreachedBarColor = bundle.getInt("unreached_bar_color");
            initializePainters();
            setMax(bundle.getInt("max"));
            setProgress(bundle.getInt("progress"));
            setPrefix(bundle.getString("prefix"));
            setSuffix(bundle.getString("suffix"));
            setProgressTextVisibility(bundle.getBoolean("text_visibility") ? ProgressTextVisibility.Visible : ProgressTextVisibility.Invisible);
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getProgressTextSize());
        bundle.putFloat("reached_bar_height", getReachedBarHeight());
        bundle.putFloat("unreached_bar_height", getUnreachedBarHeight());
        bundle.putInt("reached_bar_color", getReachedBarColor());
        bundle.putInt("unreached_bar_color", getUnreachedBarColor());
        bundle.putInt("max", getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffix());
        bundle.putString("prefix", getPrefix());
        bundle.putBoolean("text_visibility", getProgressTextVisibility());
        return bundle;
    }

    public void setMax(int i4) {
        if (i4 > 0) {
            this.mMaxProgress = i4;
            invalidate();
        }
    }

    public void setOnProgressBarListener(OnProgressBarListener onProgressBarListener) {
        this.mListener = onProgressBarListener;
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.mPrefix = "";
        } else {
            this.mPrefix = str;
        }
    }

    public void setProgress(int i4) {
        if (i4 > getMax() || i4 < 0) {
            return;
        }
        this.mCurrentProgress = i4;
        invalidate();
    }

    public void setProgressTextColor(int i4) {
        this.mTextColor = i4;
        this.mTextPaint.setColor(i4);
        invalidate();
    }

    public void setProgressTextSize(float f4) {
        this.mTextSize = f4;
        this.mTextPaint.setTextSize(f4);
        invalidate();
    }

    public void setProgressTextVisibility(ProgressTextVisibility progressTextVisibility) {
        this.mIfDrawText = progressTextVisibility == ProgressTextVisibility.Visible;
        invalidate();
    }

    public void setReachedBarColor(int i4) {
        this.mReachedBarColor = i4;
        this.mReachedBarPaint.setColor(i4);
        invalidate();
    }

    public void setReachedBarHeight(float f4) {
        this.mReachedBarHeight = f4;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.mSuffix = "";
        } else {
            this.mSuffix = str;
        }
    }

    public void setUnreachedBarColor(int i4) {
        this.mUnreachedBarColor = i4;
        this.mUnreachedBarPaint.setColor(i4);
        invalidate();
    }

    public void setUnreachedBarHeight(float f4) {
        this.mUnreachedBarHeight = f4;
    }

    public float sp2px(float f4) {
        return f4 * getResources().getDisplayMetrics().scaledDensity;
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mMaxProgress = 100;
        this.mCurrentProgress = 0;
        this.mSuffix = "%";
        this.mPrefix = "";
        int rgb = Color.rgb(66, 145, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE);
        this.default_text_color = rgb;
        int rgb2 = Color.rgb(66, 145, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE);
        this.default_reached_color = rgb2;
        int rgb3 = Color.rgb(204, 204, 204);
        this.default_unreached_color = rgb3;
        this.mUnreachedRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mReachedRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mDrawUnreachedBar = true;
        this.mDrawReachedBar = true;
        this.mIfDrawText = true;
        float dp2px = dp2px(1.5f);
        this.default_reached_bar_height = dp2px;
        float dp2px2 = dp2px(1.0f);
        this.default_unreached_bar_height = dp2px2;
        float sp2px = sp2px(10.0f);
        this.default_text_size = sp2px;
        float dp2px3 = dp2px(3.0f);
        this.default_progress_text_offset = dp2px3;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.NumberProgressBar, i4, 0);
        this.mReachedBarColor = obtainStyledAttributes.getColor(R.styleable.NumberProgressBar_progress_reached_color, rgb2);
        this.mUnreachedBarColor = obtainStyledAttributes.getColor(R.styleable.NumberProgressBar_progress_unreached_color, rgb3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.NumberProgressBar_progress_text_color, rgb);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_text_size, sp2px);
        this.mReachedBarHeight = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_reached_bar_height, dp2px);
        this.mUnreachedBarHeight = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_unreached_bar_height, dp2px2);
        this.mOffset = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_text_offset, dp2px3);
        if (obtainStyledAttributes.getInt(R.styleable.NumberProgressBar_progress_text_visibility, 0) != 0) {
            this.mIfDrawText = false;
        }
        setProgress(obtainStyledAttributes.getInt(R.styleable.NumberProgressBar_progress_current, 0));
        setMax(obtainStyledAttributes.getInt(R.styleable.NumberProgressBar_progress_max, 100));
        obtainStyledAttributes.recycle();
        initializePainters();
    }
}
