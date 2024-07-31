package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.ImageInfo;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IDetectStrategyCallback {
    public static final String IMAGE_KEY_BEST_CROP_IMAGE = "bestCropDetectImage_";
    public static final String IMAGE_KEY_BEST_SRC_IMAGE = "bestSrcDetectImage_";

    void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2);
}
