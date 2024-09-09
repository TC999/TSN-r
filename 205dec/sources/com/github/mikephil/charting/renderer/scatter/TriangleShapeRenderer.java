package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TriangleShapeRenderer implements IShapeRenderer {
    protected Path mTrianglePathBuffer = new Path();

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f4, float f5, Paint paint) {
        float scatterShapeSize = iScatterDataSet.getScatterShapeSize();
        float f6 = scatterShapeSize / 2.0f;
        float convertDpToPixel = (scatterShapeSize - (Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius()) * 2.0f)) / 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.mTrianglePathBuffer;
        path.reset();
        float f7 = f5 - f6;
        path.moveTo(f4, f7);
        float f8 = f4 + f6;
        float f9 = f5 + f6;
        path.lineTo(f8, f9);
        float f10 = f4 - f6;
        path.lineTo(f10, f9);
        double d4 = scatterShapeSize;
        if (d4 > 0.0d) {
            path.lineTo(f4, f7);
            float f11 = f10 + convertDpToPixel;
            float f12 = f9 - convertDpToPixel;
            path.moveTo(f11, f12);
            path.lineTo(f8 - convertDpToPixel, f12);
            path.lineTo(f4, f7 + convertDpToPixel);
            path.lineTo(f11, f12);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (d4 <= 0.0d || scatterShapeHoleColor == 1122867) {
            return;
        }
        paint.setColor(scatterShapeHoleColor);
        path.moveTo(f4, f7 + convertDpToPixel);
        float f13 = f9 - convertDpToPixel;
        path.lineTo(f8 - convertDpToPixel, f13);
        path.lineTo(f10 + convertDpToPixel, f13);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
    }
}
