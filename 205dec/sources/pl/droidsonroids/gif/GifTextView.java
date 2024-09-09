package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import pl.droidsonroids.gif.k;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class GifTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private k.b f61798a;

    public GifTextView(Context context) {
        super(context);
    }

    private void a() {
        if (this.f61798a.f61862b < 0) {
            return;
        }
        for (Drawable drawable : getCompoundDrawables()) {
            k.a(this.f61798a.f61862b, drawable);
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            k.a(this.f61798a.f61862b, drawable2);
        }
        k.a(this.f61798a.f61862b, getBackground());
    }

    private Drawable b(int i4) {
        if (i4 == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i4);
        if (!isInEditMode() && k.f61858b.contains(resourceTypeName)) {
            try {
                return new e(resources, i4);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i4, getContext().getTheme());
        }
        return resources.getDrawable(i4);
    }

    private void c(AttributeSet attributeSet, int i4, int i5) {
        if (attributeSet != null) {
            Drawable b4 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable b5 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable b6 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable b7 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable b8 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable b9 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (b8 != null) {
                    b4 = b8;
                }
                if (b9 == null) {
                    b9 = b6;
                }
            } else {
                if (b8 != null) {
                    b6 = b8;
                }
                if (b9 == null) {
                    b9 = b4;
                }
                b4 = b6;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(b4, b5, b9, b7);
            setBackground(b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.f61798a = new k.b(this, attributeSet, i4, i5);
            a();
        }
        this.f61798a = new k.b();
    }

    private static void d(Drawable[] drawableArr, boolean z3) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z3, false);
            }
        }
    }

    private void setCompoundDrawablesVisible(boolean z3) {
        d(getCompoundDrawables(), z3);
        d(getCompoundDrawablesRelative(), z3);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.a(compoundDrawablesRelative[0], 4);
        gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        gifViewSavedState.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f61798a.f61861a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        setBackground(b(i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(b(i4), b(i5), b(i6), b(i7));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        setCompoundDrawablesWithIntrinsicBounds(b(i4), b(i5), b(i6), b(i7));
    }

    public void setFreezesAnimation(boolean z3) {
        this.f61798a.f61861a = z3;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        c(attributeSet, i4, 0);
    }

    @RequiresApi(21)
    public GifTextView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        c(attributeSet, i4, i5);
    }
}
