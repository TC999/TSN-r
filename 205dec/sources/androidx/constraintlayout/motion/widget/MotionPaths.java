package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x  reason: collision with root package name */
    float f141x;

    /* renamed from: y  reason: collision with root package name */
    float f142y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f4, float f5) {
        return (Float.isNaN(f4) || Float.isNaN(f5)) ? Float.isNaN(f4) != Float.isNaN(f5) : Math.abs(f4 - f5) > 1.0E-6f;
    }

    private static final float xRotate(float f4, float f5, float f6, float f7, float f8, float f9) {
        return (((f8 - f6) * f5) - ((f9 - f7) * f4)) + f6;
    }

    private static final float yRotate(float f4, float f5, float f6, float f7, float f8, float f9) {
        return ((f8 - f6) * f4) + ((f9 - f7) * f5) + f7;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z3) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.f141x, motionPaths.f141x) | z3;
        zArr[2] = z3 | diff(this.f142y, motionPaths.f142y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f141x, this.f142y, this.width, this.height, this.mPathRotate};
        int i4 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] < 6) {
                dArr[i4] = fArr[iArr[i5]];
                i4++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i4) {
        float f4 = this.width;
        float f5 = this.height;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f6 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 == 3) {
                f4 = f6;
            } else if (i6 == 4) {
                f5 = f6;
            }
        }
        fArr[i4] = f4;
        fArr[i4 + 1] = f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i4) {
        float f4 = this.f141x;
        float f5 = this.f142y;
        float f6 = this.width;
        float f7 = this.height;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 == 1) {
                f4 = f8;
            } else if (i6 == 2) {
                f5 = f8;
            } else if (i6 == 3) {
                f6 = f8;
            } else if (i6 == 4) {
                f7 = f8;
            }
        }
        fArr[i4] = f4 + (f6 / 2.0f) + 0.0f;
        fArr[i4 + 1] = f5 + (f7 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i4) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i4] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        float[] fArr = new float[noOfInterpValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i5 = 0;
        while (i5 < noOfInterpValues) {
            dArr[i4] = fArr[i5];
            i5++;
            i4++;
        }
        return noOfInterpValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i4) {
        float f4 = this.f141x;
        float f5 = this.f142y;
        float f6 = this.width;
        float f7 = this.height;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 == 1) {
                f4 = f8;
            } else if (i6 == 2) {
                f5 = f8;
            } else if (i6 == 3) {
                f6 = f8;
            } else if (i6 == 4) {
                f7 = f8;
            }
        }
        float f9 = f6 + f4;
        float f10 = f7 + f5;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i7 = i4 + 1;
        fArr[i4] = f4 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f5 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f9 + 0.0f;
        int i10 = i9 + 1;
        fArr[i9] = f5 + 0.0f;
        int i11 = i10 + 1;
        fArr[i10] = f9 + 0.0f;
        int i12 = i11 + 1;
        fArr[i11] = f10 + 0.0f;
        fArr[i12] = f4 + 0.0f;
        fArr[i12 + 1] = f10 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4 = keyPosition.mFramePosition / 100.0f;
        this.time = f4;
        this.mDrawPath = keyPosition.mDrawPath;
        float f5 = Float.isNaN(keyPosition.mPercentWidth) ? f4 : keyPosition.mPercentWidth;
        float f6 = Float.isNaN(keyPosition.mPercentHeight) ? f4 : keyPosition.mPercentHeight;
        float f7 = motionPaths2.width;
        float f8 = motionPaths.width;
        float f9 = motionPaths2.height;
        float f10 = motionPaths.height;
        this.position = this.time;
        float f11 = motionPaths.f141x;
        float f12 = motionPaths.f142y;
        float f13 = (motionPaths2.f141x + (f7 / 2.0f)) - ((f8 / 2.0f) + f11);
        float f14 = (motionPaths2.f142y + (f9 / 2.0f)) - (f12 + (f10 / 2.0f));
        float f15 = (f7 - f8) * f5;
        float f16 = f15 / 2.0f;
        this.f141x = (int) ((f11 + (f13 * f4)) - f16);
        float f17 = (f9 - f10) * f6;
        float f18 = f17 / 2.0f;
        this.f142y = (int) ((f12 + (f14 * f4)) - f18);
        this.width = (int) (f8 + f15);
        this.height = (int) (f10 + f17);
        float f19 = Float.isNaN(keyPosition.mPercentX) ? f4 : keyPosition.mPercentX;
        float f20 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f4 = keyPosition.mPercentY;
        }
        float f21 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 2;
        this.f141x = (int) (((motionPaths.f141x + (f19 * f13)) + (f21 * f14)) - f16);
        this.f142y = (int) (((motionPaths.f142y + (f13 * f20)) + (f14 * f4)) - f18);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width - motionPaths.width;
        float f10 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f6 = keyPosition.mPercentX;
        }
        float f11 = motionPaths.f141x;
        float f12 = motionPaths.width;
        float f13 = motionPaths.f142y;
        float f14 = motionPaths.height;
        float f15 = (motionPaths2.f141x + (motionPaths2.width / 2.0f)) - ((f12 / 2.0f) + f11);
        float f16 = (motionPaths2.f142y + (motionPaths2.height / 2.0f)) - ((f14 / 2.0f) + f13);
        float f17 = f15 * f6;
        float f18 = (f9 * f7) / 2.0f;
        this.f141x = (int) ((f11 + f17) - f18);
        float f19 = f6 * f16;
        float f20 = (f10 * f8) / 2.0f;
        this.f142y = (int) ((f13 + f19) - f20);
        this.width = (int) (f12 + f4);
        this.height = (int) (f14 + f5);
        float f21 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f22 = (int) ((motionPaths.f141x + f17) - f18);
        float f23 = (int) ((motionPaths.f142y + f19) - f20);
        this.f141x = f22 + ((-f16) * f21);
        this.f142y = f23 + (f15 * f21);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initScreen(int i4, int i5, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4 = keyPosition.mFramePosition / 100.0f;
        this.time = f4;
        this.mDrawPath = keyPosition.mDrawPath;
        float f5 = Float.isNaN(keyPosition.mPercentWidth) ? f4 : keyPosition.mPercentWidth;
        float f6 = Float.isNaN(keyPosition.mPercentHeight) ? f4 : keyPosition.mPercentHeight;
        float f7 = motionPaths2.width;
        float f8 = motionPaths.width;
        float f9 = motionPaths2.height;
        float f10 = motionPaths.height;
        this.position = this.time;
        float f11 = motionPaths.f141x;
        float f12 = motionPaths.f142y;
        float f13 = motionPaths2.f141x + (f7 / 2.0f);
        float f14 = motionPaths2.f142y + (f9 / 2.0f);
        float f15 = (f7 - f8) * f5;
        this.f141x = (int) ((f11 + ((f13 - ((f8 / 2.0f) + f11)) * f4)) - (f15 / 2.0f));
        float f16 = (f9 - f10) * f6;
        this.f142y = (int) ((f12 + ((f14 - (f12 + (f10 / 2.0f))) * f4)) - (f16 / 2.0f));
        this.width = (int) (f8 + f15);
        this.height = (int) (f10 + f16);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f141x = (int) (keyPosition.mPercentX * ((int) (i4 - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f142y = (int) (keyPosition.mPercentY * ((int) (i5 - this.height)));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBounds(float f4, float f5, float f6, float f7) {
        this.f141x = f4;
        this.f142y = f5;
        this.width = f6;
        this.height = f7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDpDt(float f4, float f5, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f10 = (float) dArr[i4];
            double d4 = dArr2[i4];
            int i5 = iArr[i4];
            if (i5 == 1) {
                f6 = f10;
            } else if (i5 == 2) {
                f8 = f10;
            } else if (i5 == 3) {
                f7 = f10;
            } else if (i5 == 4) {
                f9 = f10;
            }
        }
        float f11 = f6 - ((0.0f * f7) / 2.0f);
        float f12 = f8 - ((0.0f * f9) / 2.0f);
        fArr[0] = (f11 * (1.0f - f4)) + (((f7 * 1.0f) + f11) * f4) + 0.0f;
        fArr[1] = (f12 * (1.0f - f5)) + (((f9 * 1.0f) + f12) * f5) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f4;
        float f5 = this.f141x;
        float f6 = this.f142y;
        float f7 = this.width;
        float f8 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i4 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i4];
            this.mTempDelta = new double[i4];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.mTempValue[iArr[i5]] = dArr[i5];
            this.mTempDelta[iArr[i5]] = dArr2[i5];
        }
        int i6 = 0;
        float f9 = Float.NaN;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr4 = this.mTempValue;
            if (i6 >= dArr4.length) {
                break;
            }
            if (Double.isNaN(dArr4[i6]) && (dArr3 == null || dArr3[i6] == 0.0d)) {
                f4 = f5;
            } else {
                double d4 = dArr3 != null ? dArr3[i6] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i6])) {
                    d4 = this.mTempValue[i6] + d4;
                }
                f4 = f5;
                float f14 = (float) d4;
                float f15 = (float) this.mTempDelta[i6];
                if (i6 == 1) {
                    f10 = f15;
                    f5 = f14;
                } else if (i6 == 2) {
                    f6 = f14;
                    f12 = f15;
                } else if (i6 == 3) {
                    f7 = f14;
                    f11 = f15;
                } else if (i6 == 4) {
                    f8 = f14;
                    f13 = f15;
                } else if (i6 == 5) {
                    f5 = f4;
                    f9 = f14;
                }
                i6++;
            }
            f5 = f4;
            i6++;
        }
        float f16 = f5;
        if (Float.isNaN(f9)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            double d5 = Float.isNaN(Float.NaN) ? 0.0f : Float.NaN;
            double d6 = f9;
            double degrees = Math.toDegrees(Math.atan2(f12 + (f13 / 2.0f), f10 + (f11 / 2.0f)));
            Double.isNaN(d6);
            Double.isNaN(d5);
            view.setRotation((float) (d5 + d6 + degrees));
        }
        float f17 = f16 + 0.5f;
        int i7 = (int) f17;
        float f18 = f6 + 0.5f;
        int i8 = (int) f18;
        int i9 = (int) (f17 + f7);
        int i10 = (int) (f18 + f8);
        int i11 = i9 - i7;
        int i12 = i10 - i8;
        if ((i11 == view.getMeasuredWidth() && i12 == view.getMeasuredHeight()) ? false : true) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        }
        view.layout(i7, i8, i9, i10);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i4, int i5, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i6 = keyPosition.mPositionType;
        if (i6 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i6 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i4, i5, keyPosition, motionPaths, motionPaths2);
        }
    }
}
