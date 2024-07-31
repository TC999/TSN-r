package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.ImageInfo;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ILivenessStrategyCallback {
    public static final String IMAGE_KEY_BEST_CROP_IMAGE = "bestCropImage_";
    public static final String IMAGE_KEY_BEST_SRC_IMAGE = "bestSrcImage_";

    void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i);
}
