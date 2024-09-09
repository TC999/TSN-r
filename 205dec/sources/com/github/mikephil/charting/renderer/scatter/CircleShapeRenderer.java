package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class CircleShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f4, float f5, Paint paint) {
        float scatterShapeSize = iScatterDataSet.getScatterShapeSize();
        float f6 = scatterShapeSize / 2.0f;
        float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius());
        float f7 = (scatterShapeSize - (convertDpToPixel * 2.0f)) / 2.0f;
        float f8 = f7 / 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        if (scatterShapeSize > 0.0d) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f7);
            canvas.drawCircle(f4, f5, f8 + convertDpToPixel, paint);
            if (scatterShapeHoleColor != 1122867) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(scatterShapeHoleColor);
                canvas.drawCircle(f4, f5, convertDpToPixel, paint);
                return;
            }
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f4, f5, f6, paint);
    }
}
