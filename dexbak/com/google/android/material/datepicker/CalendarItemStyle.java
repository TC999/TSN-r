package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.C6711R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class CalendarItemStyle {
    private final ColorStateList backgroundColor;
    @NonNull
    private final Rect insets;
    private final ShapeAppearanceModel itemShape;
    private final ColorStateList strokeColor;
    private final int strokeWidth;
    private final ColorStateList textColor;

    private CalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, ShapeAppearanceModel shapeAppearanceModel, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.insets = rect;
        this.textColor = colorStateList2;
        this.backgroundColor = colorStateList;
        this.strokeColor = colorStateList3;
        this.strokeWidth = i;
        this.itemShape = shapeAppearanceModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static CalendarItemStyle create(@NonNull Context context, @StyleRes int i) {
        Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C6711R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(C6711R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(C6711R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(C6711R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(C6711R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, C6711R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, C6711R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, C6711R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C6711R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(C6711R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(C6711R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        obtainStyledAttributes.recycle();
        return new CalendarItemStyle(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, build, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBottomInset() {
        return this.insets.bottom;
    }

    int getLeftInset() {
        return this.insets.left;
    }

    int getRightInset() {
        return this.insets.right;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTopInset() {
        return this.insets.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void styleItem(@NonNull TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable2.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable.setFillColor(this.backgroundColor);
        materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
        textView.setTextColor(this.textColor);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.textColor.withAlpha(30), materialShapeDrawable, materialShapeDrawable2) : materialShapeDrawable;
        Rect rect = this.insets;
        ViewCompat.setBackground(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}