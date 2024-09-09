package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ShapeAppearancePathProvider {
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final PointF pointF = new PointF();
    private final Path overlappedEdgePath = new Path();
    private final Path boundsPath = new Path();
    private final ShapePath shapePath = new ShapePath();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private boolean edgeIntersectionCheckEnabled = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i4);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class ShapeAppearancePathSpec {
        @NonNull
        public final RectF bounds;
        public final float interpolation;
        @NonNull
        public final Path path;
        @Nullable
        public final PathListener pathListener;
        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, @Nullable PathListener pathListener, Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f4;
            this.bounds = rectF;
            this.path = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i4 = 0; i4 < 4; i4++) {
            this.cornerPaths[i4] = new ShapePath();
            this.cornerTransforms[i4] = new Matrix();
            this.edgeTransforms[i4] = new Matrix();
        }
    }

    private float angleOfEdge(int i4) {
        return (i4 + 1) * 90;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        this.scratch[0] = this.cornerPaths[i4].getStartX();
        this.scratch[1] = this.cornerPaths[i4].getStartY();
        this.cornerTransforms[i4].mapPoints(this.scratch);
        if (i4 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i4].applyToPath(this.cornerTransforms[i4], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i4], this.cornerTransforms[i4], i4);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        int i5 = (i4 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i4].getEndX();
        this.scratch[1] = this.cornerPaths[i4].getEndY();
        this.cornerTransforms[i4].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i5].getStartX();
        this.scratch2[1] = this.cornerPaths[i5].getStartY();
        this.cornerTransforms[i5].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f4 = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot(f4 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i4);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i4, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        Path path = new Path();
        this.shapePath.applyToPath(this.edgeTransforms[i4], path);
        if (this.edgeIntersectionCheckEnabled && Build.VERSION.SDK_INT >= 19 && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(path, i4) || pathOverlapsCorner(path, i5))) {
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i4].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr3 = this.scratch;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i4], this.overlappedEdgePath);
        } else {
            this.shapePath.applyToPath(this.edgeTransforms[i4], shapeAppearancePathSpec.path);
        }
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i4], i4);
        }
    }

    private void getCoordinatesOfCorner(int i4, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i4 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i4 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i4 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return shapeAppearanceModel.getTopRightCornerSize();
                }
                return shapeAppearanceModel.getTopLeftCornerSize();
            }
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        return shapeAppearanceModel.getBottomRightCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return shapeAppearanceModel.getTopRightCorner();
                }
                return shapeAppearanceModel.getTopLeftCorner();
            }
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        return shapeAppearanceModel.getBottomRightCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i4) {
        float[] fArr = this.scratch;
        ShapePath[] shapePathArr = this.cornerPaths;
        fArr[0] = shapePathArr[i4].endX;
        fArr[1] = shapePathArr[i4].endY;
        this.cornerTransforms[i4].mapPoints(fArr);
        if (i4 != 1 && i4 != 3) {
            return Math.abs(rectF.centerY() - this.scratch[1]);
        }
        return Math.abs(rectF.centerX() - this.scratch[0]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return shapeAppearanceModel.getRightEdge();
                }
                return shapeAppearanceModel.getTopEdge();
            }
            return shapeAppearanceModel.getLeftEdge();
        }
        return shapeAppearanceModel.getBottomEdge();
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path path, int i4) {
        Path path2 = new Path();
        this.cornerPaths[i4].applyToPath(this.cornerTransforms[i4], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        getCornerTreatmentForIndex(i4, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i4], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i4, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i4);
        this.cornerTransforms[i4].reset();
        getCoordinatesOfCorner(i4, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i4];
        PointF pointF = this.pointF;
        matrix.setTranslate(pointF.x, pointF.y);
        this.cornerTransforms[i4].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i4) {
        this.scratch[0] = this.cornerPaths[i4].getEndX();
        this.scratch[1] = this.cornerPaths[i4].getEndY();
        this.cornerTransforms[i4].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i4);
        this.edgeTransforms[i4].reset();
        Matrix matrix = this.edgeTransforms[i4];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i4].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f4, rectF, null, path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEdgeIntersectionCheckEnable(boolean z3) {
        this.edgeIntersectionCheckEnabled = z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f4, rectF, pathListener, path);
        for (int i4 = 0; i4 < 4; i4++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i4);
            setEdgePathAndTransform(i4);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            appendCornerPath(shapeAppearancePathSpec, i5);
            appendEdgePath(shapeAppearancePathSpec, i5);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (Build.VERSION.SDK_INT < 19 || this.overlappedEdgePath.isEmpty()) {
            return;
        }
        path.op(this.overlappedEdgePath, Path.Op.UNION);
    }
}
