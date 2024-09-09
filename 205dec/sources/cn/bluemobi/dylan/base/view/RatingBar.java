package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.R;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class RatingBar extends LinearLayout {
    private boolean mClickable;
    private OnRatingChangeListener onRatingChangeListener;
    private int starCount;
    private Drawable starEmptyDrawable;
    private Drawable starFillDrawable;
    private Drawable starHalfDrawable;
    private float starImageSize;
    private float starPadding;
    private float starStep;
    private StepSize stepSize;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnRatingChangeListener {
        void onRatingChange(float f4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public enum StepSize {
        Half(0),
        Full(1);
        
        int step;

        StepSize(int i4) {
            this.step = i4;
        }

        public static StepSize fromStep(int i4) {
            StepSize[] values;
            for (StepSize stepSize : values()) {
                if (stepSize.step == i4) {
                    return stepSize;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatingBar);
        this.starImageSize = obtainStyledAttributes.getDimension(R.styleable.RatingBar_starImageSize, 20.0f);
        this.starPadding = obtainStyledAttributes.getDimension(R.styleable.RatingBar_starPadding, 10.0f);
        this.starStep = obtainStyledAttributes.getFloat(R.styleable.RatingBar_starStep, 1.0f);
        this.stepSize = StepSize.fromStep(obtainStyledAttributes.getInt(R.styleable.RatingBar_stepSize, 1));
        this.starCount = obtainStyledAttributes.getInteger(R.styleable.RatingBar_starCount, 5);
        this.starEmptyDrawable = obtainStyledAttributes.getDrawable(R.styleable.RatingBar_starEmpty);
        this.starFillDrawable = obtainStyledAttributes.getDrawable(R.styleable.RatingBar_starFill);
        this.starHalfDrawable = obtainStyledAttributes.getDrawable(R.styleable.RatingBar_starHalf);
        this.mClickable = obtainStyledAttributes.getBoolean(R.styleable.RatingBar_clickable, true);
        obtainStyledAttributes.recycle();
        for (int i4 = 0; i4 < this.starCount; i4++) {
            final ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(this.starEmptyDrawable);
            starImageView.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.RatingBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RatingBar ratingBar;
                    RatingBar ratingBar2;
                    RatingBar ratingBar3;
                    RatingBar ratingBar4;
                    if (RatingBar.this.mClickable) {
                        int i5 = (int) RatingBar.this.starStep;
                        if (new BigDecimal(Float.toString(RatingBar.this.starStep)).subtract(new BigDecimal(Integer.toString(i5))).floatValue() == 0.0f) {
                            i5--;
                        }
                        if (RatingBar.this.indexOfChild(view) > i5) {
                            RatingBar.this.setStar(ratingBar4.indexOfChild(view) + 1);
                        } else if (RatingBar.this.indexOfChild(view) == i5) {
                            if (RatingBar.this.stepSize == StepSize.Full) {
                                return;
                            }
                            if (starImageView.getDrawable().getCurrent().getConstantState().equals(RatingBar.this.starHalfDrawable.getConstantState())) {
                                RatingBar.this.setStar(ratingBar3.indexOfChild(view) + 1);
                                return;
                            }
                            RatingBar.this.setStar(ratingBar2.indexOfChild(view) + 0.5f);
                        } else {
                            RatingBar.this.setStar(ratingBar.indexOfChild(view) + 1.0f);
                        }
                    }
                }
            });
            addView(starImageView);
        }
        setStar(this.starStep);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(this.starImageSize), Math.round(this.starImageSize));
        layoutParams.setMargins(0, 0, Math.round(this.starPadding), 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(this.starEmptyDrawable);
        imageView.setMinimumWidth(10);
        imageView.setMaxHeight(10);
        return imageView;
    }

    @Override // android.view.View
    public void setClickable(boolean z3) {
        this.mClickable = z3;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        this.onRatingChangeListener = onRatingChangeListener;
    }

    public void setStar(float f4) {
        OnRatingChangeListener onRatingChangeListener = this.onRatingChangeListener;
        if (onRatingChangeListener != null) {
            onRatingChangeListener.onRatingChange(f4);
        }
        this.starStep = f4;
        int i4 = (int) f4;
        float floatValue = new BigDecimal(Float.toString(f4)).subtract(new BigDecimal(Integer.toString(i4))).floatValue();
        for (int i5 = 0; i5 < i4; i5++) {
            ((ImageView) getChildAt(i5)).setImageDrawable(this.starFillDrawable);
        }
        for (int i6 = i4; i6 < this.starCount; i6++) {
            ((ImageView) getChildAt(i6)).setImageDrawable(this.starEmptyDrawable);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.starHalfDrawable);
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.starEmptyDrawable = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.starFillDrawable = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.starHalfDrawable = drawable;
    }

    public void setStarImageSize(float f4) {
        this.starImageSize = f4;
    }

    public void setStepSize(StepSize stepSize) {
        this.stepSize = stepSize;
    }
}
