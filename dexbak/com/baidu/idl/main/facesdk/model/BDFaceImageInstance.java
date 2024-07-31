package com.baidu.idl.main.facesdk.model;

import android.graphics.Bitmap;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDFaceImageInstance {
    public byte[] data;
    public int height;
    public BDFaceSDKCommon.BDFaceImageType imageType;
    private long index = 0;
    public int width;

    public BDFaceImageInstance(byte[] bArr, int i, int i2, int i3) {
        this.height = i;
        this.width = i2;
        this.data = bArr;
        this.imageType = BDFaceSDKCommon.BDFaceImageType.values()[i3];
    }

    private native int create(byte[] bArr, int i, int i2, int i3, float f, int i4);

    private native int createInt(int[] iArr, int i, int i2, int i3, float f, int i4);

    public native int destory();

    public native BDFaceImageInstance getImage();

    public BDFaceImageInstance(byte[] bArr, int i, int i2, BDFaceSDKCommon.BDFaceImageType bDFaceImageType, float f, int i3) {
        if (bArr == null || i <= 0 || i2 <= 0) {
            return;
        }
        create(bArr, i, i2, bDFaceImageType.ordinal(), f, i3);
    }

    public BDFaceImageInstance(Bitmap bitmap) {
        if (bitmap != null) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            createInt(iArr, bitmap.getHeight(), bitmap.getWidth(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGRA.ordinal(), 0.0f, 0);
        }
    }
}
