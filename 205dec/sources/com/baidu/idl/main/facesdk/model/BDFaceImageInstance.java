package com.baidu.idl.main.facesdk.model;

import android.graphics.Bitmap;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BDFaceImageInstance {
    public byte[] data;
    public int height;
    public BDFaceSDKCommon.BDFaceImageType imageType;
    private long index = 0;
    public int width;

    public BDFaceImageInstance(byte[] bArr, int i4, int i5, int i6) {
        this.height = i4;
        this.width = i5;
        this.data = bArr;
        this.imageType = BDFaceSDKCommon.BDFaceImageType.values()[i6];
    }

    private native int create(byte[] bArr, int i4, int i5, int i6, float f4, int i7);

    private native int createInt(int[] iArr, int i4, int i5, int i6, float f4, int i7);

    public native int destory();

    public native BDFaceImageInstance getImage();

    public BDFaceImageInstance(byte[] bArr, int i4, int i5, BDFaceSDKCommon.BDFaceImageType bDFaceImageType, float f4, int i6) {
        if (bArr == null || i4 <= 0 || i5 <= 0) {
            return;
        }
        create(bArr, i4, i5, bDFaceImageType.ordinal(), f4, i6);
    }

    public BDFaceImageInstance(Bitmap bitmap) {
        if (bitmap != null) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            createInt(iArr, bitmap.getHeight(), bitmap.getWidth(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGRA.ordinal(), 0.0f, 0);
        }
    }
}
