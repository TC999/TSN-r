package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.Feature;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceFeature {
    private static final String TAG = "FaceFeature";
    private BDFaceInstance bdFaceInstance;

    public FaceFeature(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeFeature(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr);

    private native float nativeFeatureCompare(long j, int i, byte[] bArr, byte[] bArr2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFeatureModelInit(long j, byte[] bArr, int i);

    private native ArrayList<Feature> nativeFeatureSearch(long j, byte[] bArr, int i, int i2, int i3);

    private native float nativeRGBDFeature(long j, int i, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr);

    private native int nativeUninitModel(long j);

    private native int nativefeaturePush(List<? extends Feature> list);

    public float feature(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr) {
        if (featureType != null && fArr != null && bArr != null && bDFaceImageInstance != null && fArr.length >= 0) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeFeature(index, featureType.ordinal(), bDFaceImageInstance, fArr, bArr);
        }
        Log.v(TAG, "Parameter is null");
        return -1.0f;
    }

    public float featureCompare(BDFaceSDKCommon.FeatureType featureType, byte[] bArr, byte[] bArr2, boolean z) {
        if (featureType != null && bArr != null && bArr2 != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeFeatureCompare(index, featureType.ordinal(), bArr, bArr2, z ? 1 : 0);
        }
        Log.v(TAG, "Parameter is null");
        return -1.0f;
    }

    public int featurePush(List<? extends Feature> list) {
        return -1;
    }

    public float featureRGBD(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr) {
        if (featureType != null && fArr != null && bArr != null && bDFaceImageInstance != null && bDFaceImageInstance2 != null && fArr.length >= 0) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeRGBDFeature(index, featureType.ordinal(), bDFaceImageInstance, bDFaceImageInstance2, fArr, bArr);
        }
        Log.v(TAG, "Parameter is null");
        return -1.0f;
    }

    public ArrayList<Feature> featureSearch(byte[] bArr, BDFaceSDKCommon.FeatureType featureType, int i, boolean z) {
        return null;
    }

    public void initModel(final Context context, final String str, final String str2, String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceFeature.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceFeature.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i2 = -1;
                if (modelContent.length != 0) {
                    i = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                    if (i != 0) {
                        callback.onResponse(i, "证件照识别模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i2 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal())) != 0) {
                    callback.onResponse(i2, "Vis 识别模型加载失败");
                    return;
                }
                if (i != 0 && i2 != 0) {
                    callback.onResponse(1, "识别模型加载失败");
                } else {
                    callback.onResponse(0, "识别模型加载成功");
                }
                Log.v(FaceFeature.TAG, "FaceFeature initModel");
            }
        });
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public FaceFeature() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public void initModel(final Context context, final String str, final String str2, final String str3, final String str4, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceFeature.2
            @Override // java.lang.Runnable
            public void run() {
                if (str.length() == 0 && str2.length() == 0 && str3.length() == 0 && str4.length() == 0) {
                    Log.v(FaceFeature.TAG, "FaceFeature未设置模型路径");
                    callback.onResponse(1, "FaceFeature未设置模型路径");
                } else if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                } else {
                    long index = FaceFeature.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    if (str.length() != 0) {
                        byte[] modelContent = FileUitls.getModelContent(context, str);
                        if (modelContent.length == 0) {
                            Log.v(FaceFeature.TAG, "证件照识别模型读取失败");
                            callback.onResponse(-1, "证件照识别模型读取失败");
                            return;
                        }
                        int nativeFeatureModelInit = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                        if (nativeFeatureModelInit != 0) {
                            String str5 = FaceFeature.TAG;
                            Log.v(str5, "证件照识别模型加载失败: " + nativeFeatureModelInit);
                            callback.onResponse(nativeFeatureModelInit, "证件照识别模型加载失败");
                            return;
                        }
                    }
                    if (str2.length() != 0) {
                        byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                        if (modelContent2.length == 0) {
                            Log.v(FaceFeature.TAG, "生活照识别模型读取失败");
                            callback.onResponse(-1, "生活照识别模型读取失败");
                            return;
                        }
                        int nativeFeatureModelInit2 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal());
                        if (nativeFeatureModelInit2 != 0) {
                            String str6 = FaceFeature.TAG;
                            Log.v(str6, "生活照识别模型加载失败: " + nativeFeatureModelInit2);
                            callback.onResponse(nativeFeatureModelInit2, "生活照识别模型加载失败");
                            return;
                        }
                    }
                    if (str3.length() != 0) {
                        byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                        if (modelContent3.length == 0) {
                            Log.v(FaceFeature.TAG, "Nir识别模型读取失败");
                            callback.onResponse(-1, "Nir识别模型读取失败");
                            return;
                        }
                        int nativeFeatureModelInit3 = FaceFeature.this.nativeFeatureModelInit(index, modelContent3, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_NIR.ordinal());
                        if (nativeFeatureModelInit3 != 0) {
                            String str7 = FaceFeature.TAG;
                            Log.v(str7, "Nir识别模型加载失败: " + nativeFeatureModelInit3);
                            callback.onResponse(nativeFeatureModelInit3, "Nir识别模型加载失败");
                            return;
                        }
                    }
                    if (str4.length() != 0) {
                        byte[] modelContent4 = FileUitls.getModelContent(context, str4);
                        if (modelContent4.length == 0) {
                            Log.v(FaceFeature.TAG, "rgbd识别模型读取失败");
                            callback.onResponse(-1, "rgbd识别模型读取失败");
                            return;
                        }
                        int nativeFeatureModelInit4 = FaceFeature.this.nativeFeatureModelInit(index, modelContent4, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_RGBD.ordinal());
                        if (nativeFeatureModelInit4 != 0) {
                            String str8 = FaceFeature.TAG;
                            Log.v(str8, "rgbd识别模型加载失败: " + nativeFeatureModelInit4);
                            callback.onResponse(nativeFeatureModelInit4, "rgbd识别模型加载失败");
                            return;
                        }
                    }
                    Log.v(FaceFeature.TAG, "FaceFeature initModel");
                    callback.onResponse(0, "识别模型加载成功");
                }
            }
        });
    }
}
