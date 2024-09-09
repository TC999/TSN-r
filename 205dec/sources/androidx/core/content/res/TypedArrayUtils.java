package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i4, int i5) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i4, typedValue, true);
        return typedValue.resourceId != 0 ? i4 : i5;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5, boolean z3) {
        return typedArray.getBoolean(i4, typedArray.getBoolean(i5, z3));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5) {
        Drawable drawable = typedArray.getDrawable(i4);
        return drawable == null ? typedArray.getDrawable(i5) : drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5, int i6) {
        return typedArray.getInt(i4, typedArray.getInt(i5, i6));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i4, boolean z3) {
        return !hasAttribute(xmlPullParser, str) ? z3 : typedArray.getBoolean(i4, z3);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i4, @ColorInt int i5) {
        return !hasAttribute(xmlPullParser, str) ? i5 : typedArray.getColor(i4, i5);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i4) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i4, typedValue);
            int i5 = typedValue.type;
            if (i5 != 2) {
                if (i5 >= 28 && i5 <= 31) {
                    return getNamedColorStateListFromInt(typedValue);
                }
                return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i4, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i4 + ": " + typedValue);
        }
        return null;
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i4, @ColorInt int i5) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i4, typedValue);
            int i6 = typedValue.type;
            if (i6 >= 28 && i6 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i4, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(i5);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i4, float f4) {
        return !hasAttribute(xmlPullParser, str) ? f4 : typedArray.getFloat(i4, f4);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i4, int i5) {
        return !hasAttribute(xmlPullParser, str) ? i5 : typedArray.getInt(i4, i5);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i4, @AnyRes int i5) {
        return !hasAttribute(xmlPullParser, str) ? i5 : typedArray.getResourceId(i4, i5);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i4) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.getString(i4);
        }
        return null;
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5, @AnyRes int i6) {
        return typedArray.getResourceId(i4, typedArray.getResourceId(i5, i6));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5) {
        String string = typedArray.getString(i4);
        return string == null ? typedArray.getString(i5) : string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5) {
        CharSequence text = typedArray.getText(i4);
        return text == null ? typedArray.getText(i5) : text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i4, @StyleableRes int i5) {
        CharSequence[] textArray = typedArray.getTextArray(i4);
        return textArray == null ? typedArray.getTextArray(i5) : textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i4) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.peekValue(i4);
        }
        return null;
    }
}
