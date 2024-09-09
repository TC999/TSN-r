package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance(float.class, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setAlpha(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i4, float f4, float f5, int i5, float f6) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            this.mCurveFit.getPos(f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            double d4 = this.last_cycle;
            double d5 = j4 - this.last_time;
            Double.isNaN(d5);
            double d6 = f5;
            Double.isNaN(d6);
            Double.isNaN(d4);
            float f7 = (float) ((d4 + ((d5 * 1.0E-9d) * d6)) % 1.0d);
            this.last_cycle = f7;
            this.last_time = j4;
            float calcWave = calcWave(f7);
            this.mContinue = false;
            int i4 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i4 >= fArr2.length) {
                    break;
                }
                boolean z3 = this.mContinue;
                float[] fArr3 = this.mTempValues;
                this.mContinue = z3 | (((double) fArr3[i4]) != 0.0d);
                fArr2[i4] = (fArr3[i4] * calcWave) + f6;
                i4++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f5 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i4) {
            float[] fArr;
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i5 = noOfInterpValues + 2;
            this.mTempValues = new float[i5];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i5);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                float[] valueAt = this.mWaveProperties.valueAt(i6);
                double d4 = keyAt;
                Double.isNaN(d4);
                dArr[i6] = d4 * 0.01d;
                this.mConstraintAttributeList.valueAt(i6).getValuesToInterpolate(this.mTempValues);
                int i7 = 0;
                while (true) {
                    if (i7 < this.mTempValues.length) {
                        dArr2[i6][i7] = fArr[i7];
                        i7++;
                    }
                }
                dArr2[i6][noOfInterpValues] = valueAt[0];
                dArr2[i6][noOfInterpValues + 1] = valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }

        public void setPoint(int i4, ConstraintAttribute constraintAttribute, float f4, int i5, float f5) {
            this.mConstraintAttributeList.append(i4, constraintAttribute);
            this.mWaveProperties.append(i4, new float[]{f4, f5});
            this.mWaveShape = Math.max(this.mWaveShape, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class ElevationSet extends TimeCycleSplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f4, j4, view, keyCache));
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class PathRotate extends TimeCycleSplineSet {
        PathRotate() {
        }

        public boolean setPathRotate(View view, KeyCache keyCache, float f4, long j4, double d4, double d5) {
            view.setRotation(get(f4, j4, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d5, d4))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f4, j4, view, keyCache));
            } else if (this.mNoMethod) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(get(f4, j4, view, keyCache)));
                    } catch (IllegalAccessException e4) {
                        Log.e("SplineSet", "unable to setProgress", e4);
                    } catch (InvocationTargetException e5) {
                        Log.e("SplineSet", "unable to setProgress", e5);
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class RotationSet extends TimeCycleSplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setRotation(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class RotationXset extends TimeCycleSplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setRotationX(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class RotationYset extends TimeCycleSplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setRotationY(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class ScaleXset extends TimeCycleSplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setScaleX(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class ScaleYset extends TimeCycleSplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setScaleY(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[][] fArr, int i4, int i5) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i5;
            iArr2[1] = i4;
            int i6 = 2;
            while (i6 > 0) {
                int i7 = i6 - 1;
                int i8 = iArr2[i7];
                i6 = i7 - 1;
                int i9 = iArr2[i6];
                if (i8 < i9) {
                    int partition = partition(iArr, fArr, i8, i9);
                    int i10 = i6 + 1;
                    iArr2[i6] = partition - 1;
                    int i11 = i10 + 1;
                    iArr2[i10] = i8;
                    int i12 = i11 + 1;
                    iArr2[i11] = i9;
                    i6 = i12 + 1;
                    iArr2[i12] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i4, int i5) {
            int i6 = iArr[i5];
            int i7 = i4;
            while (i4 < i5) {
                if (iArr[i4] <= i6) {
                    swap(iArr, fArr, i7, i4);
                    i7++;
                }
                i4++;
            }
            swap(iArr, fArr, i7, i5);
            return i7;
        }

        private static void swap(int[] iArr, float[][] fArr, int i4, int i5) {
            int i6 = iArr[i4];
            iArr[i4] = iArr[i5];
            iArr[i5] = i6;
            float[] fArr2 = fArr[i4];
            fArr[i4] = fArr[i5];
            fArr[i5] = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class TranslationXset extends TimeCycleSplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setTranslationX(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class TranslationYset extends TimeCycleSplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            view.setTranslationY(get(f4, j4, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class TranslationZset extends TimeCycleSplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f4, j4, view, keyCache));
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeCycleSplineSet makeSpline(String str, long j4) {
        TimeCycleSplineSet rotationXset;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c4 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c4 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c4 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c4 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c4 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case '\b':
                rotationXset = new RotationSet();
                break;
            case '\t':
                rotationXset = new ElevationSet();
                break;
            case '\n':
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j4);
        return rotationXset;
    }

    protected float calcWave(float f4) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f4 * VAL_2PI);
            case 2:
                abs = Math.abs(f4);
                break;
            case 3:
                return (((f4 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f4 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f4 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f4 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f4 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f4, long j4, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f4, this.mCache);
        float[] fArr = this.mCache;
        boolean z3 = true;
        float f5 = fArr[1];
        if (f5 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        double d4 = this.last_cycle;
        double d5 = j4 - this.last_time;
        Double.isNaN(d5);
        double d6 = f5;
        Double.isNaN(d6);
        Double.isNaN(d4);
        float f6 = (float) ((d4 + ((d5 * 1.0E-9d) * d6)) % 1.0d);
        this.last_cycle = f6;
        keyCache.setFloatValue(view, this.mType, 0, f6);
        this.last_time = j4;
        float f7 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f7) + this.mCache[2];
        if (f7 == 0.0f && f5 == 0.0f) {
            z3 = false;
        }
        this.mContinue = z3;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i4, float f4, float f5, int i5, float f6) {
        int[] iArr = this.mTimePoints;
        int i6 = this.count;
        iArr[i6] = i4;
        float[][] fArr = this.mValues;
        fArr[i6][0] = f4;
        fArr[i6][1] = f5;
        fArr[i6][2] = f6;
        this.mWaveShape = Math.max(this.mWaveShape, i5);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f4, long j4, KeyCache keyCache);

    protected void setStartTime(long j4) {
        this.last_time = j4;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i4) {
        int i5;
        int i6 = this.count;
        if (i6 == 0) {
            Log.e("SplineSet", "Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i6 - 1);
        int i7 = 1;
        int i8 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i7 >= iArr.length) {
                break;
            }
            if (iArr[i7] != iArr[i7 - 1]) {
                i8++;
            }
            i7++;
        }
        if (i8 == 0) {
            i8 = 1;
        }
        double[] dArr = new double[i8];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i8, 3);
        int i9 = 0;
        while (i5 < this.count) {
            if (i5 > 0) {
                int[] iArr2 = this.mTimePoints;
                i5 = iArr2[i5] == iArr2[i5 + (-1)] ? i5 + 1 : 0;
            }
            double d4 = this.mTimePoints[i5];
            Double.isNaN(d4);
            dArr[i9] = d4 * 0.01d;
            double[] dArr3 = dArr2[i9];
            float[][] fArr = this.mValues;
            dArr3[0] = fArr[i5][0];
            dArr2[i9][1] = fArr[i5][1];
            dArr2[i9][2] = fArr[i5][2];
            i9++;
        }
        this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i4 = 0; i4 < this.count; i4++) {
            str = str + "[" + this.mTimePoints[i4] + " , " + decimalFormat.format(this.mValues[i4]) + "] ";
        }
        return str;
    }
}
