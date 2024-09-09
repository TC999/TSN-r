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
public class ChevronUpShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f4, float f5, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
        float scatterShapeSize = (iScatterDataSet.getScatterShapeSize() / 2.0f) * 2.0f;
        float f6 = f5 - scatterShapeSize;
        canvas.drawLine(f4, f6, f4 + scatterShapeSize, f5, paint);
        canvas.drawLine(f4, f6, f4 - scatterShapeSize, f5, paint);
    }
}
