package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ChevronUpShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f, float f2, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
        float scatterShapeSize = (iScatterDataSet.getScatterShapeSize() / 2.0f) * 2.0f;
        float f3 = f2 - scatterShapeSize;
        canvas.drawLine(f, f3, f + scatterShapeSize, f2, paint);
        canvas.drawLine(f, f3, f - scatterShapeSize, f2, paint);
    }
}
