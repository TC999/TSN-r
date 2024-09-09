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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceFeature {
    private static final String TAG = "FaceFeature";
    private BDFaceInstance bdFaceInstance;

    public FaceFeature(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeFeature(long j4, int i4, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr);

    private native float nativeFeatureCompare(long j4, int i4, byte[] bArr, byte[] bArr2, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFeatureModelInit(long j4, byte[] bArr, int i4);

    private native ArrayList<Feature> nativeFeatureSearch(long j4, byte[] bArr, int i4, int i5, int i6);

    private native float nativeRGBDFeature(long j4, int i4, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr);

    private native int nativeUninitModel(long j4);

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

    public float featureCompare(BDFaceSDKCommon.FeatureType featureType, byte[] bArr, byte[] bArr2, boolean z3) {
        if (featureType != null && bArr != null && bArr2 != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeFeatureCompare(index, featureType.ordinal(), bArr, bArr2, z3 ? 1 : 0);
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

    public ArrayList<Feature> featureSearch(byte[] bArr, BDFaceSDKCommon.FeatureType featureType, int i4, boolean z3) {
        return null;
    }

    public void initModel(final Context context, final String str, final String str2, String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceFeature.1
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceFeature.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i5 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                    if (i4 != 0) {
                        callback.onResponse(i4, "\u8bc1\u4ef6\u7167\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i5 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal())) != 0) {
                    callback.onResponse(i5, "Vis \u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 != 0 && i5 != 0) {
                    callback.onResponse(1, "\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else {
                    callback.onResponse(0, "\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
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
                    Log.v(FaceFeature.TAG, "FaceFeature\u672a\u8bbe\u7f6e\u6a21\u578b\u8def\u5f84");
                    callback.onResponse(1, "FaceFeature\u672a\u8bbe\u7f6e\u6a21\u578b\u8def\u5f84");
                } else if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                } else {
                    long index = FaceFeature.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    if (str.length() != 0) {
                        byte[] modelContent = FileUitls.getModelContent(context, str);
                        if (modelContent.length == 0) {
                            Log.v(FaceFeature.TAG, "\u8bc1\u4ef6\u7167\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            callback.onResponse(-1, "\u8bc1\u4ef6\u7167\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            return;
                        }
                        int nativeFeatureModelInit = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                        if (nativeFeatureModelInit != 0) {
                            String str5 = FaceFeature.TAG;
                            Log.v(str5, "\u8bc1\u4ef6\u7167\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25: " + nativeFeatureModelInit);
                            callback.onResponse(nativeFeatureModelInit, "\u8bc1\u4ef6\u7167\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                            return;
                        }
                    }
                    if (str2.length() != 0) {
                        byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                        if (modelContent2.length == 0) {
                            Log.v(FaceFeature.TAG, "\u751f\u6d3b\u7167\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            callback.onResponse(-1, "\u751f\u6d3b\u7167\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            return;
                        }
                        int nativeFeatureModelInit2 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal());
                        if (nativeFeatureModelInit2 != 0) {
                            String str6 = FaceFeature.TAG;
                            Log.v(str6, "\u751f\u6d3b\u7167\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25: " + nativeFeatureModelInit2);
                            callback.onResponse(nativeFeatureModelInit2, "\u751f\u6d3b\u7167\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                            return;
                        }
                    }
                    if (str3.length() != 0) {
                        byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                        if (modelContent3.length == 0) {
                            Log.v(FaceFeature.TAG, "Nir\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            callback.onResponse(-1, "Nir\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            return;
                        }
                        int nativeFeatureModelInit3 = FaceFeature.this.nativeFeatureModelInit(index, modelContent3, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_NIR.ordinal());
                        if (nativeFeatureModelInit3 != 0) {
                            String str7 = FaceFeature.TAG;
                            Log.v(str7, "Nir\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25: " + nativeFeatureModelInit3);
                            callback.onResponse(nativeFeatureModelInit3, "Nir\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                            return;
                        }
                    }
                    if (str4.length() != 0) {
                        byte[] modelContent4 = FileUitls.getModelContent(context, str4);
                        if (modelContent4.length == 0) {
                            Log.v(FaceFeature.TAG, "rgbd\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            callback.onResponse(-1, "rgbd\u8bc6\u522b\u6a21\u578b\u8bfb\u53d6\u5931\u8d25");
                            return;
                        }
                        int nativeFeatureModelInit4 = FaceFeature.this.nativeFeatureModelInit(index, modelContent4, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_RGBD.ordinal());
                        if (nativeFeatureModelInit4 != 0) {
                            String str8 = FaceFeature.TAG;
                            Log.v(str8, "rgbd\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25: " + nativeFeatureModelInit4);
                            callback.onResponse(nativeFeatureModelInit4, "rgbd\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                            return;
                        }
                    }
                    Log.v(FaceFeature.TAG, "FaceFeature initModel");
                    callback.onResponse(0, "\u8bc6\u522b\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                }
            }
        });
    }
}
