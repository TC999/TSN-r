package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final int DEFAULT_STROKE_VALUE = -1;
    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    @Nullable
    private Drawable checkedIcon;
    @Dimension
    private final int checkedIconMargin;
    @Dimension
    private final int checkedIconSize;
    @Nullable
    private ColorStateList checkedIconTint;
    @Nullable
    private LayerDrawable clickableForegroundDrawable;
    @Nullable
    private MaterialShapeDrawable compatRippleDrawable;
    @Nullable
    private Drawable fgDrawable;
    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;
    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;
    @NonNull
    private final MaterialCardView materialCardView;
    @Nullable
    private ColorStateList rippleColor;
    @Nullable
    private Drawable rippleDrawable;
    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    private ColorStateList strokeColor;
    @Dimension
    private int strokeWidth;
    @NonNull
    private final Rect userContentPadding = new Rect();
    private boolean isBackgroundOverwritten = false;

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i4, @StyleRes int i5) {
        this.materialCardView = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i4, i5);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i4, R.style.CardView);
        int i6 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i6)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i6, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        Resources resources = materialCardView.getResources();
        this.checkedIconMargin = resources.getDimensionPixelSize(R.dimen.mtrl_card_checked_icon_margin);
        this.checkedIconSize = resources.getDimensionPixelSize(R.dimen.mtrl_card_checked_icon_size);
        obtainStyledAttributes.recycle();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f4) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            double d4 = f4;
            Double.isNaN(d4);
            return (float) ((1.0d - COS_45) * d4);
        } else if (cornerTreatment instanceof CutCornerTreatment) {
            return f4 / 2.0f;
        } else {
            return 0.0f;
        }
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * 1.5f) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private boolean canClipToOutline() {
        return Build.VERSION.SDK_INT >= 21 && this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createCheckedIconLayer() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            stateListDrawable.addState(CHECKED_STATE_SET, drawable);
        }
        return stateListDrawable;
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable createForegroundShapeDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable;
        createForegroundShapeDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{16842919}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.foregroundShapeDrawable = createForegroundShapeDrawable();
            return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
        }
        return createCompatRippleDrawable();
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, createCheckedIconLayer()});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap()) {
            if (Build.VERSION.SDK_INT < 21 || this.materialCardView.getUseCompatPadding()) {
                double d4 = 1.0d - COS_45;
                double cardViewRadius = this.materialCardView.getCardViewRadius();
                Double.isNaN(cardViewRadius);
                return (float) (d4 * cardViewRadius);
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @NonNull
    private Drawable insetDrawable(Drawable drawable) {
        int ceil;
        int i4;
        if ((Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
            int ceil2 = (int) Math.ceil(calculateVerticalBackgroundPadding());
            ceil = (int) Math.ceil(calculateHorizontalBackgroundPadding());
            i4 = ceil2;
        } else {
            ceil = 0;
            i4 = 0;
        }
        return new InsetDrawable(drawable, ceil, i4, ceil, i4) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private void updateInsetForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.materialCardView.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        } else {
            this.materialCardView.setForeground(insetDrawable(drawable));
        }
    }

    private void updateRippleColor() {
        Drawable drawable;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.rippleDrawable) != null) {
            ((RippleDrawable) drawable).setColor(this.rippleColor);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.rippleColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 23)
    public void forceRippleRedraw() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i4 = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i4 - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int getStrokeColor() {
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCheckable() {
        return this.checkable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(@NonNull TypedArray typedArray) {
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = colorStateList;
        if (colorStateList == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z3 = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = z3;
        this.materialCardView.setLongClickable(z3);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        this.materialCardView.setForeground(insetDrawable(clickableForeground));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        if (this.clickableForegroundDrawable != null) {
            int i8 = this.checkedIconMargin;
            int i9 = this.checkedIconSize;
            int i10 = (i4 - i8) - i9;
            int i11 = (i5 - i8) - i9;
            if ((Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
                i11 -= (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
                i10 -= (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
            }
            int i12 = i11;
            int i13 = this.checkedIconMargin;
            if (ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
                i7 = i10;
                i6 = i13;
            } else {
                i6 = i10;
                i7 = i13;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i6, this.checkedIconMargin, i7, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundOverwritten(boolean z3) {
        this.isBackgroundOverwritten = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckable(boolean z3) {
        this.checkable = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.checkedIcon = wrap;
            DrawableCompat.setTintList(wrap, this.checkedIconTint);
        }
        if (this.clickableForegroundDrawable != null) {
            this.clickableForegroundDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, createCheckedIconLayer());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCornerRadius(float f4) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f4));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.bgDrawable.setInterpolation(f4);
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f4);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundContentDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.foregroundShapeDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.compatRippleDrawable;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrokeWidth(@Dimension int i4) {
        if (i4 == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i4;
        updateStroke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserContentPadding(int i4, int i5, int i6, int i7) {
        this.userContentPadding.set(i4, i5, i6, i7);
        updateContentPadding();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateClickable() {
        Drawable drawable = this.fgDrawable;
        Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        if (drawable != clickableForeground) {
            updateInsetForeground(clickableForeground);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateContentPadding() {
        int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
        MaterialCardView materialCardView = this.materialCardView;
        Rect rect = this.userContentPadding;
        materialCardView.setAncestorContentPadding(rect.left + calculateActualCornerPadding, rect.top + calculateActualCornerPadding, rect.right + calculateActualCornerPadding, rect.bottom + calculateActualCornerPadding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
}
