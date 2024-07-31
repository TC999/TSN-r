package com.kwad.sdk.p445n;

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
import com.kwad.sdk.core.p397e.C10331c;
import java.io.InputStream;

/* renamed from: com.kwad.sdk.n.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10877h extends Resources {
    private final Resources aTd;

    public C10877h(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aTd = resources2;
    }

    /* renamed from: aA */
    private static boolean m24597aA(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    /* renamed from: eq */
    private static boolean m24596eq(int i) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i) {
        C10331c.m26254d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getAnimation(i);
        }
        return super.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i) {
        C10331c.m26254d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getBoolean(i);
        }
        return super.getBoolean(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i) {
        C10331c.m26254d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getColor(i);
        }
        return super.getColor(i);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i) {
        C10331c.m26254d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDimension(i);
        }
        return super.getDimension(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i) {
        C10331c.m26254d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDimensionPixelOffset(i);
        }
        return super.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i) {
        C10331c.m26254d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDimensionPixelSize(i);
        }
        return super.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i) {
        C10331c.m26254d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDrawable(i);
        }
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i, int i2) {
        C10331c.m26254d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDrawableForDensity(i, i2);
        }
        return super.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i) {
        C10331c.m26254d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getFloat(i);
        }
        return super.getFloat(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i) {
        C10331c.m26254d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getFont(i);
        }
        return super.getFont(i);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i, int i2, int i3) {
        C10331c.m26254d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getFraction(i, i2, i3);
        }
        return super.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        C10331c.m26254d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        if (m24597aA(str, str3)) {
            return this.aTd.getIdentifier(str, str2, str3);
        }
        return super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i) {
        C10331c.m26254d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getIntArray(i);
        }
        return super.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i) {
        C10331c.m26254d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getInteger(i);
        }
        return super.getInteger(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i) {
        C10331c.m26254d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getLayout(i);
        }
        return super.getLayout(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i) {
        C10331c.m26254d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getMovie(i);
        }
        return super.getMovie(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i, int i2) {
        C10331c.m26254d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getQuantityString(i, i2);
        }
        return super.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i, int i2) {
        C10331c.m26254d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getQuantityText(i, i2);
        }
        return super.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i) {
        C10331c.m26254d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getResourceEntryName(i);
        }
        return super.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i) {
        C10331c.m26254d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getResourceName(i);
        }
        return super.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i) {
        C10331c.m26254d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getResourcePackageName(i);
        }
        return super.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i) {
        C10331c.m26254d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getResourceTypeName(i);
        }
        return super.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i) {
        C10331c.m26254d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getString(i);
        }
        return super.getString(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i) {
        C10331c.m26254d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getStringArray(i);
        }
        return super.getStringArray(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i) {
        C10331c.m26254d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getText(i);
        }
        return super.getText(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i) {
        C10331c.m26254d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getTextArray(i);
        }
        return super.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i, TypedValue typedValue, boolean z) {
        C10331c.m26254d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            this.aTd.getValue(i, typedValue, z);
        } else {
            super.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        C10331c.m26254d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            this.aTd.getValueForDensity(i, i2, typedValue, z);
        } else {
            super.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i) {
        C10331c.m26254d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getXml(i);
        }
        return super.getXml(i);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i) {
        C10331c.m26254d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.obtainTypedArray(i);
        }
        return super.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i) {
        C10331c.m26254d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.openRawResource(i);
        }
        return super.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i) {
        C10331c.m26254d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.openRawResourceFd(i);
        }
        return super.openRawResourceFd(i);
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
    public final int getColor(int i, @Nullable Resources.Theme theme) {
        C10331c.m26254d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getColor(i, theme);
        }
        return super.getColor(i, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i, @Nullable Resources.Theme theme) {
        C10331c.m26254d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDrawable(i);
        }
        return super.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i, int i2, @Nullable Resources.Theme theme) {
        C10331c.m26254d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getDrawableForDensity(i, i2, theme);
        }
        return super.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i, int i2, Object... objArr) {
        C10331c.m26254d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getQuantityString(i, i2, objArr);
        }
        return super.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i, Object... objArr) {
        C10331c.m26254d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getString(i, objArr);
        }
        return super.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i, CharSequence charSequence) {
        C10331c.m26254d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.getText(i, charSequence);
        }
        return super.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) {
        int identifier = getIdentifier(str, "string", null);
        C10331c.m26254d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (m24596eq(identifier)) {
            this.aTd.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i, TypedValue typedValue) {
        C10331c.m26254d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (m24596eq(i)) {
            return this.aTd.openRawResource(i, typedValue);
        }
        return super.openRawResource(i, typedValue);
    }
}
