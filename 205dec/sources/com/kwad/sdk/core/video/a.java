package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends TextureView {
    private int videoHeight;
    private int videoWidth;

    public a(Context context) {
        super(context);
    }

    public final void adaptVideoSize(int i4, int i5) {
        if (this.videoWidth == i4 || this.videoHeight == i5) {
            return;
        }
        this.videoWidth = i4;
        this.videoHeight = i5;
        requestLayout();
    }

    @Override // android.view.View
    protected final void onMeasure(int i4, int i5) {
        int i6;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i5 = i4;
            i4 = i5;
        }
        int defaultSize = TextureView.getDefaultSize(this.videoWidth, i4);
        int defaultSize2 = TextureView.getDefaultSize(this.videoHeight, i5);
        if (this.videoWidth > 0 && this.videoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            int size2 = View.MeasureSpec.getSize(i5);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i7 = this.videoWidth;
                int i8 = i7 * size2;
                int i9 = this.videoHeight;
                if (i8 < size * i9) {
                    defaultSize = (i7 * size2) / i9;
                } else if (i7 * size2 > size * i9) {
                    defaultSize2 = (i9 * size) / i7;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i10 = this.videoHeight;
                int i11 = this.videoWidth;
                int i12 = (size * i10) / i11;
                if (mode2 != Integer.MIN_VALUE || i12 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i12;
                } else {
                    defaultSize = (i11 * size2) / i10;
                    defaultSize2 = size2;
                }
            } else {
                if (mode2 == 1073741824) {
                    int i13 = this.videoWidth;
                    int i14 = this.videoHeight;
                    int i15 = (size2 * i13) / i14;
                    if (mode != Integer.MIN_VALUE || i15 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i15;
                    } else {
                        defaultSize2 = (i14 * size) / i13;
                    }
                } else {
                    int i16 = this.videoWidth;
                    int i17 = this.videoHeight;
                    if (mode2 != Integer.MIN_VALUE || i17 <= size2) {
                        i6 = i16;
                        size2 = i17;
                    } else {
                        i6 = (size2 * i16) / i17;
                    }
                    if (mode != Integer.MIN_VALUE || i6 <= size) {
                        defaultSize = i6;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = (i17 * size) / i16;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public final void setRotation(float f4) {
        if (f4 != getRotation()) {
            super.setRotation(f4);
            requestLayout();
        }
    }
}
