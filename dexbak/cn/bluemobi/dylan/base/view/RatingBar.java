package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.C1108R;
import java.math.BigDecimal;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
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

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface OnRatingChangeListener {
        void onRatingChange(float f);
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum StepSize {
        Half(0),
        Full(1);
        
        int step;

        StepSize(int i) {
            this.step = i;
        }

        public static StepSize fromStep(int i) {
            StepSize[] values;
            for (StepSize stepSize : values()) {
                if (stepSize.step == i) {
                    return stepSize;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1108R.styleable.RatingBar);
        this.starImageSize = obtainStyledAttributes.getDimension(C1108R.styleable.RatingBar_starImageSize, 20.0f);
        this.starPadding = obtainStyledAttributes.getDimension(C1108R.styleable.RatingBar_starPadding, 10.0f);
        this.starStep = obtainStyledAttributes.getFloat(C1108R.styleable.RatingBar_starStep, 1.0f);
        this.stepSize = StepSize.fromStep(obtainStyledAttributes.getInt(C1108R.styleable.RatingBar_stepSize, 1));
        this.starCount = obtainStyledAttributes.getInteger(C1108R.styleable.RatingBar_starCount, 5);
        this.starEmptyDrawable = obtainStyledAttributes.getDrawable(C1108R.styleable.RatingBar_starEmpty);
        this.starFillDrawable = obtainStyledAttributes.getDrawable(C1108R.styleable.RatingBar_starFill);
        this.starHalfDrawable = obtainStyledAttributes.getDrawable(C1108R.styleable.RatingBar_starHalf);
        this.mClickable = obtainStyledAttributes.getBoolean(C1108R.styleable.RatingBar_clickable, true);
        obtainStyledAttributes.recycle();
        for (int i = 0; i < this.starCount; i++) {
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
                        int i2 = (int) RatingBar.this.starStep;
                        if (new BigDecimal(Float.toString(RatingBar.this.starStep)).subtract(new BigDecimal(Integer.toString(i2))).floatValue() == 0.0f) {
                            i2--;
                        }
                        if (RatingBar.this.indexOfChild(view) > i2) {
                            RatingBar.this.setStar(ratingBar4.indexOfChild(view) + 1);
                        } else if (RatingBar.this.indexOfChild(view) == i2) {
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
    public void setClickable(boolean z) {
        this.mClickable = z;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        this.onRatingChangeListener = onRatingChangeListener;
    }

    public void setStar(float f) {
        OnRatingChangeListener onRatingChangeListener = this.onRatingChangeListener;
        if (onRatingChangeListener != null) {
            onRatingChangeListener.onRatingChange(f);
        }
        this.starStep = f;
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        for (int i2 = 0; i2 < i; i2++) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.starFillDrawable);
        }
        for (int i3 = i; i3 < this.starCount; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.starEmptyDrawable);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.starHalfDrawable);
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

    public void setStarImageSize(float f) {
        this.starImageSize = f;
    }

    public void setStepSize(StepSize stepSize) {
        this.stepSize = stepSize;
    }
}
