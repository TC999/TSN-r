package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    private static float toTangent(float f4) {
        if (f4 >= 0.0f && f4 <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f4 / 2.0f));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f4, f5);
        float f11 = f6 - f4;
        float f12 = f7 - f5;
        float f13 = (f11 * f11) + (f12 * f12);
        float f14 = (f4 + f6) / 2.0f;
        float f15 = (f5 + f7) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z3 = f5 > f7;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (f12 * 2.0f));
            if (z3) {
                f9 = abs + f7;
                f8 = f6;
            } else {
                f9 = abs + f5;
                f8 = f4;
            }
            f10 = this.mMinimumVerticalTangent;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z3) {
                f9 = f5;
                f8 = f17 + f4;
            } else {
                f8 = f6 - f17;
                f9 = f7;
            }
            f10 = this.mMinimumHorizontalTangent;
        }
        float f18 = f16 * f10 * f10;
        float f19 = f14 - f8;
        float f20 = f15 - f9;
        float f21 = (f19 * f19) + (f20 * f20);
        float f22 = this.mMaximumTangent;
        float f23 = f16 * f22 * f22;
        if (f21 >= f18) {
            f18 = f21 > f23 ? f23 : 0.0f;
        }
        if (f18 != 0.0f) {
            float sqrt = (float) Math.sqrt(f18 / f21);
            f8 = ((f8 - f14) * sqrt) + f14;
            f9 = f15 + (sqrt * (f9 - f15));
        }
        path.cubicTo((f4 + f8) / 2.0f, (f5 + f9) / 2.0f, (f8 + f6) / 2.0f, (f9 + f7) / 2.0f, f6, f7);
        return path;
    }

    public void setMaximumAngle(float f4) {
        this.mMaximumAngle = f4;
        this.mMaximumTangent = toTangent(f4);
    }

    public void setMinimumHorizontalAngle(float f4) {
        this.mMinimumHorizontalAngle = f4;
        this.mMinimumHorizontalTangent = toTangent(f4);
    }

    public void setMinimumVerticalAngle(float f4) {
        this.mMinimumVerticalAngle = f4;
        this.mMinimumVerticalTangent = toTangent(f4);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
