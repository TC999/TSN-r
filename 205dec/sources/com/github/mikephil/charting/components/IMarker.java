package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface IMarker {
    void draw(Canvas canvas, float f4, float f5);

    MPPointF getOffset();

    MPPointF getOffsetForDrawingAtPoint(float f4, float f5);

    void refreshContent(Entry entry, Highlight highlight);
}
