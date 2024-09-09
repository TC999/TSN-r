package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i4) throws Resources.NotFoundException {
        return this.mResources.getAnimation(i4);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i4) throws Resources.NotFoundException {
        return this.mResources.getBoolean(i4);
    }

    @Override // android.content.res.Resources
    public int getColor(int i4) throws Resources.NotFoundException {
        return this.mResources.getColor(i4);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i4) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(i4);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i4) throws Resources.NotFoundException {
        return this.mResources.getDimension(i4);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i4) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(i4);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i4) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(i4);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i4) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i4);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public Drawable getDrawableForDensity(int i4, int i5) throws Resources.NotFoundException {
        return this.mResources.getDrawableForDensity(i4, i5);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i4, int i5, int i6) {
        return this.mResources.getFraction(i4, i5, i6);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i4) throws Resources.NotFoundException {
        return this.mResources.getIntArray(i4);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i4) throws Resources.NotFoundException {
        return this.mResources.getInteger(i4);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i4) throws Resources.NotFoundException {
        return this.mResources.getLayout(i4);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i4) throws Resources.NotFoundException {
        return this.mResources.getMovie(i4);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i4, int i5, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i4, i5, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i4, int i5) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(i4, i5);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(i4);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourceName(i4);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(i4);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(i4);
    }

    @Override // android.content.res.Resources
    public String getString(int i4) throws Resources.NotFoundException {
        return this.mResources.getString(i4);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i4) throws Resources.NotFoundException {
        return this.mResources.getStringArray(i4);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i4) throws Resources.NotFoundException {
        return this.mResources.getText(i4);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i4) throws Resources.NotFoundException {
        return this.mResources.getTextArray(i4);
    }

    @Override // android.content.res.Resources
    public void getValue(int i4, TypedValue typedValue, boolean z3) throws Resources.NotFoundException {
        this.mResources.getValue(i4, typedValue, z3);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public void getValueForDensity(int i4, int i5, TypedValue typedValue, boolean z3) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(i4, i5, typedValue, z3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i4) throws Resources.NotFoundException {
        return this.mResources.getXml(i4);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i4) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(i4);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i4) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i4);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i4) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(i4);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int i4, Resources.Theme theme) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i4, theme);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i4, int i5, Resources.Theme theme) {
        return this.mResources.getDrawableForDensity(i4, i5, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i4, int i5) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i4, i5);
    }

    @Override // android.content.res.Resources
    public String getString(int i4, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getString(i4, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i4, CharSequence charSequence) {
        return this.mResources.getText(i4, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z3) throws Resources.NotFoundException {
        this.mResources.getValue(str, typedValue, z3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i4, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i4, typedValue);
    }
}
