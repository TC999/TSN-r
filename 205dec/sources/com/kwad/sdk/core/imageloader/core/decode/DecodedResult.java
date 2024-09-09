package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequence;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DecodedResult {
    public Bitmap mBitmap;
    public FrameSequence mFrameSequence;

    public int getByteSize() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getRowBytes() * this.mBitmap.getHeight();
        }
        return 0;
    }

    public boolean isDecoded() {
        Bitmap bitmap = this.mBitmap;
        return (bitmap != null && !bitmap.isRecycled()) || (this.mFrameSequence != null);
    }
}
