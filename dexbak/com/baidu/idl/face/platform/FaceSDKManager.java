package com.baidu.idl.face.platform;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.strategy.FaceDetectStrategyExtModule;
import com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.baidu.idl.main.facesdk.FaceActionLive;
import com.baidu.idl.main.facesdk.FaceAuth;
import com.baidu.idl.main.facesdk.FaceCrop;
import com.baidu.idl.main.facesdk.FaceDetect;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.FaceSec;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceCropParam;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.BDFaceSDKConfig;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceSDKManager {
    private static FaceSDKManager instance;
    private Context mContext;
    private FaceActionLive mFaceActionLive;
    private FaceAuth mFaceAuth;
    private FaceConfig mFaceConfig = new FaceConfig();
    private FaceCrop mFaceCrop;
    private FaceDetect mFaceDetect;
    private FaceSec mFaceSec;
    private boolean mInitFlag;

    private FaceSDKManager() {
        FaceAuth faceAuth = new FaceAuth();
        this.mFaceAuth = faceAuth;
        faceAuth.setActiveLog(BDFaceSDKCommon.BDFaceLogInfo.BDFACE_LOG_TYPE_DEBUG, 1);
        this.mFaceAuth.setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode.BDFACE_LITE_POWER_NO_BIND, 2);
        this.mFaceSec = new FaceSec();
    }

    public static FaceSDKManager getInstance() {
        if (instance == null) {
            synchronized (FaceSDKManager.class) {
                if (instance == null) {
                    instance = new FaceSDKManager();
                }
            }
        }
        return instance;
    }

    public static String getVersion() {
        return FaceEnvironment.SDK_VERSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel(Context context, final IInitCallback iInitCallback) {
        this.mFaceDetect = new FaceDetect();
        this.mFaceCrop = new FaceCrop();
        this.mFaceActionLive = new FaceActionLive();
        BDFaceSDKConfig bDFaceSDKConfig = new BDFaceSDKConfig();
        bDFaceSDKConfig.minFaceSize = this.mFaceConfig.getMinFaceSize();
        bDFaceSDKConfig.notRGBFaceThreshold = this.mFaceConfig.getNotFaceValue();
        bDFaceSDKConfig.isMouthClose = true;
        bDFaceSDKConfig.isEyeClose = true;
        bDFaceSDKConfig.isCropFace = true;
        bDFaceSDKConfig.isCheckBlur = true;
        bDFaceSDKConfig.isIllumination = true;
        bDFaceSDKConfig.isOcclusion = true;
        bDFaceSDKConfig.isHeadPose = true;
        bDFaceSDKConfig.maxDetectNum = 1;
        this.mFaceDetect.loadConfig(bDFaceSDKConfig);
        this.mFaceDetect.initModel(context, "detect/detect_rgb-customized-pa-faceid4_0.model.int8.0.0.6.1", "align/align-customized-pa-offlineCapture_withScore_quant_20200909.model.int8.6.4.7.1", BDFaceSDKCommon.DetectType.DETECT_VIS, BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE, new Callback() { // from class: com.baidu.idl.face.platform.FaceSDKManager.2
            @Override // com.baidu.idl.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i, str);
            }
        });
        this.mFaceDetect.initQuality(context, "blur/blur-customized-pa-blurnet_9768.model.int8-3.0.9.1", "occlusion/occlusion-customized-pa-occ.model.float32.2.0.6.1", new Callback() { // from class: com.baidu.idl.face.platform.FaceSDKManager.3
            @Override // com.baidu.idl.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i, str);
            }
        });
        this.mFaceCrop.initFaceCrop(new Callback() { // from class: com.baidu.idl.face.platform.FaceSDKManager.4
            @Override // com.baidu.idl.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i, str);
            }
        });
        this.mFaceActionLive.initActionLiveModel(context, "eyes_close/eyes-customized-pa-caiji.model.float32.1.0.3.1", "mouth_close/mouth-customized-pa-caiji.model.float32.1.0.3.1", new Callback() { // from class: com.baidu.idl.face.platform.FaceSDKManager.5
            @Override // com.baidu.idl.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i != 0 && (iInitCallback2 = iInitCallback) != null) {
                    iInitCallback2.initFailure(i, str);
                }
                if (i != 0 || iInitCallback == null) {
                    return;
                }
                FaceSDKManager.this.mInitFlag = true;
                iInitCallback.initSuccess();
            }
        });
    }

    private void releaseModel() {
        FaceDetect faceDetect = this.mFaceDetect;
        if (faceDetect != null) {
            faceDetect.uninitModel();
        }
        FaceCrop faceCrop = this.mFaceCrop;
        if (faceCrop != null) {
            faceCrop.uninitFaceCrop();
        }
        FaceActionLive faceActionLive = this.mFaceActionLive;
        if (faceActionLive != null) {
            faceActionLive.uninitActionLiveModel();
        }
        if (this.mFaceConfig != null) {
            this.mFaceConfig = null;
        }
    }

    public String bitmapToBase64(byte[] bArr) {
        return Base64Utils.encodeToString(bArr, 2);
    }

    public void clearActionHistory() {
        FaceActionLive faceActionLive = this.mFaceActionLive;
        if (faceActionLive != null) {
            faceActionLive.clearHistory();
        }
    }

    public byte[] compressImage(Bitmap bitmap, int i) {
        return BitmapUtils.bitmapCompress(bitmap, i);
    }

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i, int i2) {
        BDFaceCropParam bDFaceCropParam = new BDFaceCropParam();
        bDFaceCropParam.foreheadExtend = 0.22222222f;
        bDFaceCropParam.chinExtend = 0.11111111f;
        bDFaceCropParam.enlargeRatio = getFaceConfig().getEnlargeRatio();
        bDFaceCropParam.height = i;
        bDFaceCropParam.width = i2;
        if (this.mFaceCrop.cropFaceByLandmarkIsOutofBoundary(bDFaceImageInstance, fArr, bDFaceCropParam) == null) {
            return null;
        }
        return this.mFaceCrop.cropFaceByLandmarkParam(bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public FaceInfo[] detect(BDFaceImageInstance bDFaceImageInstance) {
        FaceDetect faceDetect = this.mFaceDetect;
        if (faceDetect == null) {
            return null;
        }
        return faceDetect.track(BDFaceSDKCommon.DetectType.DETECT_VIS, bDFaceImageInstance);
    }

    public IDetectStrategy getDetectStrategyModule() {
        FaceDetectStrategyExtModule faceDetectStrategyExtModule = new FaceDetectStrategyExtModule(this.mContext);
        faceDetectStrategyExtModule.setConfigValue(this.mFaceConfig);
        return faceDetectStrategyExtModule;
    }

    public FaceConfig getFaceConfig() {
        return this.mFaceConfig;
    }

    public boolean getInitFlag() {
        return this.mInitFlag;
    }

    public ILivenessStrategy getLivenessStrategyModule(ILivenessViewCallback iLivenessViewCallback) {
        FaceLivenessStrategyExtModule faceLivenessStrategyExtModule = new FaceLivenessStrategyExtModule(this.mContext);
        faceLivenessStrategyExtModule.setILivenessViewCallback(iLivenessViewCallback);
        faceLivenessStrategyExtModule.setConfig(this.mFaceConfig);
        return faceLivenessStrategyExtModule;
    }

    public String getZid(Context context) {
        return "";
    }

    public String imageSec(byte[] bArr) {
        return this.mFaceSec.m51131e(bArr);
    }

    public void initialize(Context context, String str, IInitCallback iInitCallback) {
        initialize(context, str, "", iInitCallback);
    }

    public int processLiveness(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, AtomicInteger atomicInteger) {
        return this.mFaceActionLive.actionLive(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo.getmLandmarks(), atomicInteger);
    }

    public void release() {
        synchronized (FaceSDKManager.class) {
            FaceSDKManager faceSDKManager = instance;
            if (faceSDKManager != null) {
                faceSDKManager.mInitFlag = false;
                faceSDKManager.mContext = null;
                faceSDKManager.releaseModel();
                instance = null;
            }
        }
    }

    public Bitmap scaleImage(Bitmap bitmap, int i, int i2) {
        return BitmapUtils.scale(bitmap, i, i2);
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    public void initialize(final Context context, String str, String str2, final IInitCallback iInitCallback) {
        if (iInitCallback == null) {
            return;
        }
        if (context != null && str != null && str2 != null) {
            this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.mFaceAuth.initLicense(context, str, str2, true, new Callback() { // from class: com.baidu.idl.face.platform.FaceSDKManager.1
                @Override // com.baidu.idl.main.facesdk.callback.Callback
                public void onResponse(int i, String str3) {
                    if (i == 0) {
                        FaceSDKManager.this.initModel(context, iInitCallback);
                        return;
                    }
                    IInitCallback iInitCallback2 = iInitCallback;
                    if (iInitCallback2 != null) {
                        iInitCallback2.initFailure(i, str3);
                    }
                }
            });
            return;
        }
        iInitCallback.initFailure(-1, "参数不能为空");
    }

    public Bitmap scaleImage(Bitmap bitmap, float f) {
        return BitmapUtils.scale(bitmap, f);
    }
}
