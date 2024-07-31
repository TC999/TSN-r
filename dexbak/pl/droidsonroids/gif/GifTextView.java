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
import pl.droidsonroids.gif.GifViewUtils;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifTextView extends TextView {

    /* renamed from: a */
    private GifViewUtils.C15447b f44385a;

    public GifTextView(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m2496a() {
        if (this.f44385a.f44449b < 0) {
            return;
        }
        for (Drawable drawable : getCompoundDrawables()) {
            GifViewUtils.m2376a(this.f44385a.f44449b, drawable);
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            GifViewUtils.m2376a(this.f44385a.f44449b, drawable2);
        }
        GifViewUtils.m2376a(this.f44385a.f44449b, getBackground());
    }

    /* renamed from: b */
    private Drawable m2495b(int i) {
        if (i == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i);
        if (!isInEditMode() && GifViewUtils.f44445b.contains(resourceTypeName)) {
            try {
                return new GifDrawable(resources, i);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, getContext().getTheme());
        }
        return resources.getDrawable(i);
    }

    /* renamed from: c */
    private void m2494c(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            Drawable m2495b = m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable m2495b2 = m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable m2495b3 = m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable m2495b4 = m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable m2495b5 = m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable m2495b6 = m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (m2495b5 != null) {
                    m2495b = m2495b5;
                }
                if (m2495b6 == null) {
                    m2495b6 = m2495b3;
                }
            } else {
                if (m2495b5 != null) {
                    m2495b3 = m2495b5;
                }
                if (m2495b6 == null) {
                    m2495b6 = m2495b;
                }
                m2495b = m2495b3;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(m2495b, m2495b2, m2495b6, m2495b4);
            setBackground(m2495b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.f44385a = new GifViewUtils.C15447b(this, attributeSet, i, i2);
            m2496a();
        }
        this.f44385a = new GifViewUtils.C15447b();
    }

    /* renamed from: d */
    private static void m2493d(Drawable[] drawableArr, boolean z) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
    }

    private void setCompoundDrawablesVisible(boolean z) {
        m2493d(getCompoundDrawables(), z);
        m2493d(getCompoundDrawablesRelative(), z);
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
        gifViewSavedState.m2479a(compoundDrawables[0], 0);
        gifViewSavedState.m2479a(compoundDrawables[1], 1);
        gifViewSavedState.m2479a(compoundDrawables[2], 2);
        gifViewSavedState.m2479a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.m2479a(compoundDrawablesRelative[0], 4);
        gifViewSavedState.m2479a(compoundDrawablesRelative[2], 5);
        gifViewSavedState.m2479a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f44385a.f44448a) {
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
    public void setBackgroundResource(int i) {
        setBackground(m2495b(i));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(m2495b(i), m2495b(i2), m2495b(i3), m2495b(i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(m2495b(i), m2495b(i2), m2495b(i3), m2495b(i4));
    }

    public void setFreezesAnimation(boolean z) {
        this.f44385a.f44448a = z;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2494c(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2494c(attributeSet, i, 0);
    }

    @RequiresApi(21)
    public GifTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2494c(attributeSet, i, i2);
    }
}
