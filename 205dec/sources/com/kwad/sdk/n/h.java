package com.kwad.sdk.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h extends Resources {
    private final Resources aTd;

    public h(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aTd = resources2;
    }

    private static boolean aA(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    private static boolean eq(int i4) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i4));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getAnimation(i4);
        }
        return super.getAnimation(i4);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getBoolean(i4);
        }
        return super.getBoolean(i4);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getColor(i4);
        }
        return super.getColor(i4);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDimension(i4);
        }
        return super.getDimension(i4);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDimensionPixelOffset(i4);
        }
        return super.getDimensionPixelOffset(i4);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDimensionPixelSize(i4);
        }
        return super.getDimensionPixelSize(i4);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDrawable(i4);
        }
        return super.getDrawable(i4);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i4, int i5) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDrawableForDensity(i4, i5);
        }
        return super.getDrawableForDensity(i4, i5);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getFloat(i4);
        }
        return super.getFloat(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getFont(i4);
        }
        return super.getFont(i4);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i4, int i5, int i6) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getFraction(i4, i5, i6);
        }
        return super.getFraction(i4, i5, i6);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        if (aA(str, str3)) {
            return this.aTd.getIdentifier(str, str2, str3);
        }
        return super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getIntArray(i4);
        }
        return super.getIntArray(i4);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getInteger(i4);
        }
        return super.getInteger(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getLayout(i4);
        }
        return super.getLayout(i4);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getMovie(i4);
        }
        return super.getMovie(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i4, int i5) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getQuantityString(i4, i5);
        }
        return super.getQuantityString(i4, i5);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i4, int i5) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getQuantityText(i4, i5);
        }
        return super.getQuantityText(i4, i5);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getResourceEntryName(i4);
        }
        return super.getResourceEntryName(i4);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getResourceName(i4);
        }
        return super.getResourceName(i4);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getResourcePackageName(i4);
        }
        return super.getResourcePackageName(i4);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getResourceTypeName(i4);
        }
        return super.getResourceTypeName(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getString(i4);
        }
        return super.getString(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getStringArray(i4);
        }
        return super.getStringArray(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getText(i4);
        }
        return super.getText(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getTextArray(i4);
        }
        return super.getTextArray(i4);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i4, TypedValue typedValue, boolean z3) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            this.aTd.getValue(i4, typedValue, z3);
        } else {
            super.getValue(i4, typedValue, z3);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i4, int i5, TypedValue typedValue, boolean z3) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            this.aTd.getValueForDensity(i4, i5, typedValue, z3);
        } else {
            super.getValueForDensity(i4, i5, typedValue, z3);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getXml(i4);
        }
        return super.getXml(i4);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.obtainTypedArray(i4);
        }
        return super.obtainTypedArray(i4);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.openRawResource(i4);
        }
        return super.openRawResource(i4);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i4) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.openRawResourceFd(i4);
        }
        return super.openRawResourceFd(i4);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 23)
    public final int getColor(int i4, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getColor(i4, theme);
        }
        return super.getColor(i4, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i4, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDrawable(i4);
        }
        return super.getDrawable(i4, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i4, int i5, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getDrawableForDensity(i4, i5, theme);
        }
        return super.getDrawableForDensity(i4, i5, theme);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i4, int i5, Object... objArr) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getQuantityString(i4, i5, objArr);
        }
        return super.getQuantityString(i4, i5, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i4, Object... objArr) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getString(i4, objArr);
        }
        return super.getString(i4, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i4, CharSequence charSequence) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.getText(i4, charSequence);
        }
        return super.getText(i4, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z3) {
        int identifier = getIdentifier(str, "string", null);
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (eq(identifier)) {
            this.aTd.getValue(str, typedValue, z3);
        } else {
            super.getValue(str, typedValue, z3);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i4, TypedValue typedValue) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i4));
        if (eq(i4)) {
            return this.aTd.openRawResource(i4, typedValue);
        }
        return super.openRawResource(i4, typedValue);
    }
}
