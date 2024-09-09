package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f4, float f5, float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f4, float f5, float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i4, float[] fArr2, int i5, int i6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f4, float f5, float f6) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f4, float f5, float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f4, float f5, float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f4, float f5, float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f4, float f5) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
