package com.bytedance.pangle.res;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        String a4 = g.a(Zeus.getAppApplication());
        String b4 = g.b(Zeus.getAppApplication());
        List<String> b5 = j.b();
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(j.a(assets));
        List<String> a5 = j.a(assets2);
        for (String str : b5) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (String str2 : a5) {
            if (!isOtherPlugin(str2, a4, b4) && !hashSet.contains(str2) && !b5.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        ZeusLogger.i("Zeus/resources_pangle", "pluginAssets = " + j.b(assets));
        return assets;
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException notFoundException) {
        return new Resources.NotFoundException(("Resources#Assets: " + j.b(getAssets())) + "," + notFoundException.getMessage());
    }

    private static boolean isOtherPlugin(String str, String str2, String str3) {
        String packageResourcePath = Zeus.getAppApplication().getPackageResourcePath();
        if (!TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        ZeusLogger.d("Zeus/resources_pangle", str + " " + packageResourcePath + " " + str2 + " " + str3);
        if (TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return !TextUtils.isEmpty(str3) && str.contains(str3);
        }
        return true;
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getAnimation(int i4) {
        try {
            return super.getAnimation(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i4) {
        try {
            return super.getBoolean(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i4) {
        try {
            return super.getColor(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i4) {
        try {
            return super.getColorStateList(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i4) {
        try {
            return super.getDimension(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i4) {
        try {
            return super.getDimensionPixelOffset(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i4) {
        try {
            return super.getDimensionPixelSize(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i4) {
        try {
            return super.getDrawable(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i4, int i5) {
        try {
            return super.getDrawableForDensity(i4, i5);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public float getFloat(int i4) {
        try {
            return super.getFloat(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public Typeface getFont(int i4) {
        try {
            return super.getFont(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i4, int i5, int i6) {
        try {
            return super.getFraction(i4, i5, i6);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public int[] getIntArray(int i4) {
        try {
            return super.getIntArray(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i4) {
        try {
            return super.getInteger(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getLayout(int i4) {
        try {
            return super.getLayout(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i4) {
        try {
            return super.getMovie(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i4, int i5, Object... objArr) {
        try {
            return super.getQuantityString(i4, i5, objArr);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getQuantityText(int i4, int i5) {
        try {
            return super.getQuantityText(i4, i5);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i4) {
        try {
            return super.getResourceEntryName(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i4) {
        try {
            return super.getResourceName(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i4) {
        try {
            return super.getResourcePackageName(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i4) {
        try {
            return super.getResourceTypeName(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i4) {
        try {
            return super.getString(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String[] getStringArray(int i4) {
        try {
            return super.getStringArray(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getText(int i4) {
        try {
            return super.getText(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence[] getTextArray(int i4) {
        try {
            return super.getTextArray(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i4, TypedValue typedValue, boolean z3) {
        try {
            super.getValue(i4, typedValue, z3);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i4, int i5, TypedValue typedValue, boolean z3) {
        try {
            super.getValueForDensity(i4, i5, typedValue, z3);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getXml(int i4) {
        try {
            return super.getXml(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public TypedArray obtainTypedArray(int i4) {
        try {
            return super.obtainTypedArray(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i4) {
        try {
            return super.openRawResource(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i4) {
        try {
            return super.openRawResourceFd(i4);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i4, @Nullable Resources.Theme theme) {
        try {
            return super.getColor(i4, theme);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i4, @Nullable Resources.Theme theme) {
        try {
            return super.getColorStateList(i4, theme);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i4, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawable(i4, theme);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i4, int i5, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i4, i5, theme);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i4, int i5) {
        try {
            return super.getQuantityString(i4, i5);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i4, Object... objArr) {
        try {
            return super.getString(i4, objArr);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i4, CharSequence charSequence) {
        try {
            return super.getText(i4, charSequence);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z3) {
        try {
            super.getValue(str, typedValue, z3);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i4, TypedValue typedValue) {
        try {
            return super.openRawResource(i4, typedValue);
        } catch (Resources.NotFoundException e4) {
            throw handleException(e4);
        }
    }
}
