package com.bxkj.student.common.view;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.DisplayUtil;
import com.bxkj.student.C4215R;
import com.google.android.material.snackbar.Snackbar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SnackBarUtils {
    private final Builder builder;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {
        private View.OnClickListener actionClickListener;
        private CharSequence actionText;
        private Integer actionTextColor;
        private ColorStateList actionTextColors;
        private int actionTextResId;
        private Float actionTextSize;
        private Integer actionTextSizeUnit;
        private Typeface actionTextTypeface;
        private Integer actionTextTypefaceStyle;
        private Integer backgroundColor;
        private boolean centerText;
        private int duration;
        private Drawable icon;
        private int iconResId;
        private int maxLines;
        private CharSequence text;
        private Integer textColor;
        private ColorStateList textColors;
        private int textResId;
        private Float textSize;
        private Integer textSizeUnit;
        private Typeface textTypeface;
        private Integer textTypefaceStyle;
        private View view;

        private Snackbar make() {
            View view = this.view;
            if (view != null) {
                if (this.textResId != 0) {
                    this.text = view.getResources().getText(this.textResId);
                }
                if (this.actionTextResId != 0) {
                    this.actionText = this.view.getResources().getText(this.actionTextResId);
                }
                if (this.iconResId != 0) {
                    this.icon = ContextCompat.getDrawable(this.view.getContext(), this.iconResId);
                }
                return new SnackBarUtils(this).make();
            }
            throw new IllegalStateException("must set an Activity or a View before making a snack");
        }

        public Snackbar build() {
            return make();
        }

        public Builder centerText() {
            this.centerText = true;
            return this;
        }

        public Builder setActionClickListener(View.OnClickListener listener) {
            this.actionClickListener = listener;
            return this;
        }

        public Builder setActionText(@StringRes int resId) {
            this.actionTextResId = resId;
            return this;
        }

        public Builder setActionTextColor(ColorStateList colorStateList) {
            this.actionTextColor = null;
            this.actionTextColors = colorStateList;
            return this;
        }

        public Builder setActionTextSize(float textSize) {
            this.actionTextSizeUnit = null;
            this.actionTextSize = Float.valueOf(textSize);
            return this;
        }

        public Builder setActionTextTypeface(Typeface typeface) {
            this.actionTextTypeface = typeface;
            return this;
        }

        public Builder setActionTextTypefaceStyle(int style) {
            this.actionTextTypefaceStyle = Integer.valueOf(style);
            return this;
        }

        public Builder setActivity(Activity activity) {
            return setView(((ViewGroup) activity.findViewById(16908290)).getChildAt(0));
        }

        public Builder setBackgroundColor(@ColorInt int color) {
            this.backgroundColor = Integer.valueOf(color);
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setIcon(@DrawableRes int resId) {
            this.iconResId = resId;
            return this;
        }

        public Builder setMaxLines(int maxLines) {
            this.maxLines = maxLines;
            return this;
        }

        public Builder setText(@StringRes int resId) {
            this.textResId = resId;
            return this;
        }

        public Builder setTextColor(@ColorInt int color) {
            this.textColor = Integer.valueOf(color);
            return this;
        }

        public Builder setTextSize(float textSize) {
            this.textSizeUnit = null;
            this.textSize = Float.valueOf(textSize);
            return this;
        }

        public Builder setTextTypeface(Typeface typeface) {
            this.textTypeface = typeface;
            return this;
        }

        public Builder setTextTypefaceStyle(int style) {
            this.textTypefaceStyle = Integer.valueOf(style);
            return this;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        private Builder() {
            this.view = null;
            this.duration = -1;
            this.text = "";
            this.textResId = 0;
            this.textColor = null;
            this.textColors = null;
            this.textSizeUnit = null;
            this.textSize = null;
            this.textTypefaceStyle = null;
            this.textTypeface = null;
            this.actionTextSizeUnit = null;
            this.actionTextSize = null;
            this.actionText = "";
            this.actionTextResId = 0;
            this.actionTextTypefaceStyle = null;
            this.actionTextTypeface = null;
            this.actionClickListener = null;
            this.actionTextColor = null;
            this.actionTextColors = null;
            this.maxLines = Integer.MAX_VALUE;
            this.centerText = false;
            this.icon = null;
            this.iconResId = 0;
            this.backgroundColor = null;
        }

        public Builder setActionText(CharSequence text) {
            this.textResId = 0;
            this.actionText = text;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public Builder setText(CharSequence text) {
            this.textResId = 0;
            this.text = text;
            return this;
        }

        public Builder setTextColor(ColorStateList colorStateList) {
            this.textColor = null;
            this.textColors = colorStateList;
            return this;
        }

        public Builder setActionTextColor(@ColorInt int color) {
            this.actionTextColor = Integer.valueOf(color);
            return this;
        }

        public Builder setActionTextSize(int unit, float textSize) {
            this.actionTextSizeUnit = Integer.valueOf(unit);
            this.actionTextSize = Float.valueOf(textSize);
            return this;
        }

        public Builder setTextSize(int unit, float textSize) {
            this.textSizeUnit = Integer.valueOf(unit);
            this.textSize = Float.valueOf(textSize);
            return this;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private @interface Duration {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface DurationType {
        public static final int LENGTH_INDEFINITE = -2;
        public static final int LENGTH_LONG = 0;
        public static final int LENGTH_SHORT = -1;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Snackbar make() {
        Snackbar make = Snackbar.make(this.builder.view, this.builder.text, this.builder.duration);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) make.getView();
        Button button = (Button) snackbarLayout.findViewById(2131232632);
        TextView textView = (TextView) snackbarLayout.findViewById(2131232633);
        if (this.builder.actionClickListener != null || this.builder.actionText != null) {
            if (this.builder.actionClickListener == null) {
                this.builder.actionClickListener = new View.OnClickListener() { // from class: com.bxkj.student.common.view.SnackBarUtils.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                    }
                };
            }
            make.setAction(this.builder.actionText, this.builder.actionClickListener);
            if (this.builder.actionTextColors != null) {
                make.setActionTextColor(this.builder.actionTextColors);
            } else if (this.builder.actionTextColor != null) {
                make.setActionTextColor(this.builder.actionTextColor.intValue());
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        snackbarLayout.setLayoutParams(layoutParams);
        snackbarLayout.setMinimumWidth(DisplayUtil.m57760a(this.builder.view.getContext(), 600.0f));
        snackbarLayout.setMinimumHeight(DisplayUtil.m57760a(this.builder.view.getContext(), 80.0f));
        if (this.builder.backgroundColor != null) {
            snackbarLayout.setBackgroundColor(this.builder.backgroundColor.intValue());
        }
        if (this.builder.actionTextSize != null) {
            if (this.builder.actionTextSizeUnit != null) {
                button.setTextSize(this.builder.actionTextSizeUnit.intValue(), this.builder.actionTextSize.floatValue());
            } else {
                button.setTextSize(this.builder.actionTextSize.floatValue());
            }
        }
        Typeface typeface = button.getTypeface();
        if (this.builder.actionTextTypeface != null) {
            typeface = this.builder.actionTextTypeface;
        }
        if (this.builder.actionTextTypefaceStyle != null) {
            button.setTypeface(typeface, this.builder.actionTextTypefaceStyle.intValue());
        } else {
            button.setTypeface(typeface);
        }
        if (this.builder.textSize != null) {
            if (this.builder.textSizeUnit != null) {
                textView.setTextSize(this.builder.textSizeUnit.intValue(), this.builder.textSize.floatValue());
            } else {
                textView.setTextSize(this.builder.textSize.floatValue());
            }
        }
        Typeface typeface2 = textView.getTypeface();
        if (this.builder.textTypeface != null) {
            typeface2 = this.builder.textTypeface;
        }
        if (this.builder.textTypefaceStyle != null) {
            textView.setTypeface(typeface2, this.builder.textTypefaceStyle.intValue());
        } else {
            textView.setTypeface(typeface2);
        }
        if (this.builder.textColors != null) {
            textView.setTextColor(this.builder.textColors);
        } else if (this.builder.textColor != null) {
            textView.setTextColor(this.builder.textColor.intValue());
        }
        textView.setMaxLines(this.builder.maxLines);
        textView.setGravity(this.builder.centerText ? 17 : 16);
        if (this.builder.centerText) {
            textView.setTextAlignment(4);
        }
        if (this.builder.icon != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(this.builder.icon, (Drawable) null, (this.builder.centerText && TextUtils.isEmpty(this.builder.actionText)) ? new BitmapDrawable(this.builder.view.getContext().getResources(), Bitmap.createBitmap(this.builder.icon.getIntrinsicWidth(), this.builder.icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888)) : null, (Drawable) null);
            textView.setCompoundDrawablePadding(10);
        }
        return make;
    }

    public static Snackbar show(Activity activity, boolean isOK, String message) {
        Snackbar build = builder().setBackgroundColor(ContextCompat.getColor(activity, isOK ? 17170451 : 2131034177)).setTextSize(30.0f).setTextColor(ContextCompat.getColor(activity, 2131034196)).setTextTypefaceStyle(1).setText(message).setMaxLines(4).centerText().setIcon(isOK ? C4215R.mipmap.toast_y : 2131559043).setActivity(activity).setDuration(0).build();
        build.show();
        return build;
    }

    public static void showSnackBar(Activity activity, String text) {
        if (activity == null || text == null || text.length() == 0) {
            return;
        }
        builder().setBackgroundColor(activity.getResources().getColor(17170444)).setTextSize(14.0f).setTextColor(activity.getResources().getColor(2131034575)).setTextTypefaceStyle(1).setText(text).setMaxLines(1).setActivity(activity).setDuration(-1).build().show();
    }

    private SnackBarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private SnackBarUtils(Builder builder) {
        this.builder = builder;
    }

    public static void showSnackBar(Activity activity, String text, String action, View.OnClickListener listener) {
        if (activity == null || text == null || text.length() == 0 || action == null || action.length() == 0) {
            return;
        }
        builder().setBackgroundColor(activity.getResources().getColor(17170444)).setTextSize(14.0f).setTextColor(activity.getResources().getColor(2131034575)).setTextTypefaceStyle(1).setText(text).setMaxLines(1).setActionText(action).setActionTextColor(activity.getResources().getColor(17170444)).setActionTextSize(14.0f).setActionTextTypefaceStyle(1).setActionClickListener(listener).setActivity(activity).setDuration(-2).build().show();
    }

    public static Snackbar show(Activity activity, boolean isOK, String message, int dismissTime) {
        final Snackbar build = builder().setBackgroundColor(ContextCompat.getColor(activity, isOK ? 17170451 : 2131034177)).setTextSize(30.0f).setTextColor(ContextCompat.getColor(activity, 2131034196)).setTextTypefaceStyle(1).setText(message).setMaxLines(4).centerText().setIcon(isOK ? C4215R.mipmap.toast_y : 2131559043).setActivity(activity).setDuration(-2).build();
        build.show();
        new CountDownTimer(dismissTime, 1000L) { // from class: com.bxkj.student.common.view.SnackBarUtils.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                build.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }
        }.start();
        return build;
    }

    public static void showSnackBar(Activity activity, String text, String action, @DrawableRes int resId, View.OnClickListener listener) {
        if (activity == null || text == null || text.length() == 0 || action == null || action.length() == 0 || resId != 0) {
            return;
        }
        builder().setBackgroundColor(activity.getResources().getColor(17170444)).setTextSize(14.0f).setTextColor(activity.getResources().getColor(2131034575)).setTextTypefaceStyle(1).setText(text).setMaxLines(1).setActionText(action).setActionTextColor(activity.getResources().getColor(17170451)).setActionTextSize(14.0f).setActionTextTypefaceStyle(1).setActionClickListener(listener).setActivity(activity).setDuration(-2).setIcon(resId).build().show();
    }
}
