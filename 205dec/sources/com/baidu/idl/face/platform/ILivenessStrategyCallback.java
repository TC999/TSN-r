package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.ImageInfo;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface ILivenessStrategyCallback {
    public static final String IMAGE_KEY_BEST_CROP_IMAGE = "bestCropImage_";
    public static final String IMAGE_KEY_BEST_SRC_IMAGE = "bestSrcImage_";

    void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i4);
}
