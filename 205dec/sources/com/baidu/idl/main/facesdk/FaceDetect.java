package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceDetectListConf;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceDetect {
    private static final String TAG = "FaceDetect";
    private BDFaceInstance bdFaceInstance;
    private ReentrantLock lock;

    public FaceDetect(BDFaceInstance bDFaceInstance) {
        this.lock = null;
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
        this.lock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAlignModelInit(long j4, int i4, int i5, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAttributeModelInit(long j4, byte[] bArr);

    private native BDFaceImageInstance nativeCropFace(long j4, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    private native FaceInfo[] nativeDetect(long j4, int i4, int i5, BDFaceImageInstance bDFaceImageInstance);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeDetectModelInit(long j4, byte[] bArr, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeEmotionsModelInit(long j4, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFaceCloseModelInit(long j4, byte[] bArr, int i4);

    private native FaceInfo[] nativeFastTrack(long j4, int i4, int i5, BDFaceImageInstance bDFaceImageInstance);

    private native FaceInfo[] nativeFlexibleDetect(long j4, int i4, int i5, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf);

    private native void nativeLoadConfig(long j4, BDFaceSDKConfig bDFaceSDKConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLoadTrack(long j4, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeQualityModelInit(long j4, byte[] bArr, int i4);

    private native FaceInfo[] nativeTrack(long j4, int i4, BDFaceImageInstance bDFaceImageInstance);

    private native int nativeUninitModel(long j4);

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance != null && fArr != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFace(index, bDFaceImageInstance, fArr);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType != null && bDFaceImageInstance != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeDetect = nativeDetect(index, detectType.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), bDFaceImageInstance);
                this.lock.unlock();
                return nativeDetect;
            }
            return null;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public void initAttrEmo(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.4
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i5 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceDetect.this.nativeAttributeModelInit(index, modelContent);
                    if (i4 != 0) {
                        callback.onResponse(i4, "\u5c5e\u6027\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i5 = FaceDetect.this.nativeEmotionsModelInit(index, modelContent2)) != 0) {
                    callback.onResponse(i5, "\u60c5\u7eea\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 != 0 && i5 != 0) {
                    callback.onResponse(1, "\u5c5e\u6027\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else {
                    callback.onResponse(0, "\u5c5e\u6027\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                }
                Log.e("bdface", "FaceAttributes initModel");
            }
        });
    }

    public void initFaceClose(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.5
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i5 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent, 0);
                    if (i4 != 0) {
                        callback.onResponse(i4, "\u773c\u775b\u95ed\u5408\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i5 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent2, 1)) != 0) {
                    callback.onResponse(i5, "\u5634\u5df4\u95ed\u5408\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 != 0 && i5 != 0) {
                    callback.onResponse(1, "\u95ed\u773c\u95ed\u5634\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else {
                    callback.onResponse(0, "\u95ed\u773c\u95ed\u5634\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                }
                Log.e("bdface", "FaceClose initModel");
            }
        });
    }

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.1
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                int i5;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i6 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceDetect.this.nativeDetectModelInit(index, modelContent, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal());
                    if (i4 != 0) {
                        callback.onResponse(i4, "Vis\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0) {
                    int nativeDetectModelInit = FaceDetect.this.nativeDetectModelInit(index, modelContent2, BDFaceSDKCommon.DetectType.DETECT_NIR.ordinal());
                    if (nativeDetectModelInit != 0) {
                        callback.onResponse(nativeDetectModelInit, "Nir\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                    i5 = nativeDetectModelInit;
                } else {
                    i5 = -1;
                }
                byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                if (modelContent3.length != 0 && (i6 = FaceDetect.this.nativeAlignModelInit(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), modelContent3)) != 0) {
                    callback.onResponse(i6, "\u5bf9\u9f50\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal());
                if (nativeLoadTrack != 0) {
                    callback.onResponse(nativeLoadTrack, "\u8ddf\u8e2a\u80fd\u529b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if ((i4 == 0 || i5 == 0) && i6 == 0) {
                    callback.onResponse(0, "\u68c0\u6d4b\u5bf9\u9f50\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                } else {
                    callback.onResponse(1, "\u68c0\u6d4b\u5bf9\u9f50\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                }
                Log.e(FaceDetect.TAG, "FaceDetect initModel");
            }
        });
    }

    public void initQuality(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.3
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i5 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceDetect.this.nativeQualityModelInit(index, modelContent, BDFaceSDKCommon.FaceQualityType.BLUR.ordinal());
                    if (i4 != 0) {
                        callback.onResponse(i4, "\u6a21\u7cca\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i5 = FaceDetect.this.nativeQualityModelInit(index, modelContent2, BDFaceSDKCommon.FaceQualityType.OCCLUSION.ordinal())) != 0) {
                    callback.onResponse(i5, "\u906e\u6321\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 != 0 && i5 != 0) {
                    callback.onResponse(1, "\u8d28\u91cf\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else {
                    callback.onResponse(0, "\u8d28\u91cf\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                }
                Log.e(FaceDetect.TAG, "FaceDetect initQuality");
            }
        });
    }

    public void loadConfig(BDFaceSDKConfig bDFaceSDKConfig) {
        BDFaceInstance bDFaceInstance = this.bdFaceInstance;
        if (bDFaceInstance == null) {
            return;
        }
        long index = bDFaceInstance.getIndex();
        if (index == 0) {
            return;
        }
        nativeLoadConfig(index, bDFaceSDKConfig);
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType != null && bDFaceImageInstance != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeTrack = nativeTrack(index, detectType.ordinal(), bDFaceImageInstance);
                this.lock.unlock();
                return nativeTrack;
            }
            return null;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public void initModel(final Context context, final String str, final String str2, final BDFaceSDKCommon.DetectType detectType, final BDFaceSDKCommon.AlignType alignType, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.2
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i5 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceDetect.this.nativeDetectModelInit(index, modelContent, detectType.ordinal());
                    if (i4 != 0) {
                        callback.onResponse(i4, "\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i5 = FaceDetect.this.nativeAlignModelInit(index, detectType.ordinal(), alignType.ordinal(), modelContent2)) != 0) {
                    callback.onResponse(i5, "\u5bf9\u9f50\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, detectType.ordinal(), alignType.ordinal());
                if (nativeLoadTrack != 0) {
                    callback.onResponse(nativeLoadTrack, "\u8ddf\u8e2a\u80fd\u529b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 == 0 && i5 == 0) {
                    callback.onResponse(0, "\u68c0\u6d4b\u5bf9\u9f50\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                } else {
                    callback.onResponse(1, "\u68c0\u6d4b\u5bf9\u9f50\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                }
                Log.e(FaceDetect.TAG, "FaceDetect initModel");
            }
        });
    }

    public FaceDetect() {
        this.lock = null;
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
        this.lock = new ReentrantLock();
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType != null && bDFaceImageInstance != null && alignType != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeFastTrack(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf) {
        if (detectType != null && bDFaceImageInstance != null && alignType != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeFlexibleDetect = nativeFlexibleDetect(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf);
                this.lock.unlock();
                return nativeFlexibleDetect;
            }
            return null;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }
}
