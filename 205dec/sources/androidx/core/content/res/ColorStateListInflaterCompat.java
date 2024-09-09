package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ColorStateListInflaterCompat {
    private ColorStateListInflaterCompat() {
    }

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources resources, @XmlRes int i4, @Nullable Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i4), theme);
        } catch (Exception e4) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e4);
            return null;
        }
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int i4, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return (i4 & 16777215) | (Math.round(Color.alpha(i4) * f4) << 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static ColorStateList inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i4 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i5 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i4 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.ColorStateListItem);
                int color = obtainAttributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                float f4 = 1.0f;
                int i6 = R.styleable.ColorStateListItem_android_alpha;
                if (obtainAttributes.hasValue(i6)) {
                    f4 = obtainAttributes.getFloat(i6, 1.0f);
                } else {
                    int i7 = R.styleable.ColorStateListItem_alpha;
                    if (obtainAttributes.hasValue(i7)) {
                        f4 = obtainAttributes.getFloat(i7, 1.0f);
                    }
                }
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i8 = 0;
                for (int i9 = 0; i9 < attributeCount; i9++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i9);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha) {
                        int i10 = i8 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i9, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i8] = attributeNameResource;
                        i8 = i10;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i8);
                iArr2 = GrowingArrayUtils.append(iArr2, i5, modulateColorAlpha(color, f4));
                iArr = (int[][]) GrowingArrayUtils.append(iArr, i5, trimStateSet);
                i5++;
            }
            i4 = 1;
        }
        int[] iArr4 = new int[i5];
        int[][] iArr5 = new int[i5];
        System.arraycopy(iArr2, 0, iArr4, 0, i5);
        System.arraycopy(iArr, 0, iArr5, 0, i5);
        return new ColorStateList(iArr5, iArr4);
    }
}
