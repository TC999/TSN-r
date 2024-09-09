package com.baidu.idl.face.platform.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.baidu.idl.face.platform.ILivenessStrategyCallback;
import com.baidu.idl.face.platform.ILivenessViewCallback;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.common.LogHelper;
import com.baidu.idl.face.platform.common.SoundPoolHelper;
import com.baidu.idl.face.platform.decode.FaceModuleNew;
import com.baidu.idl.face.platform.manager.TimeManager;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.model.FaceModel;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceLivenessStrategyExtModule implements ILivenessStrategy {
    private static final String TAG = "FaceLivenessStrategyExtModule";
    private static volatile int mProcessCount;
    private Handler mAnimHandler;
    private Context mContext;
    private int mCropCount;
    private Rect mDetectRect;
    private DetectStrategy mDetectStrategy;
    private FaceConfig mFaceConfig;
    private FaceModuleNew mFaceModule;
    private ILivenessStrategyCallback mILivenessStrategyCallback;
    private ILivenessViewCallback mILivenessViewCallback;
    private volatile boolean mIsCompletion;
    private boolean mIsFirstLivenessSuccessTipsed;
    private boolean mIsFirstTipsed;
    private volatile boolean mIsProcessing;
    private LivenessStatusStrategy mLivenessStrategy;
    private int mPreviewDegree;
    private Rect mPreviewRect;
    private SoundPoolHelper mSoundPlayHelper;
    private boolean mTipLiveTimeout;
    private volatile boolean mIsEnableSound = true;
    private Map<FaceStatusNewEnum, String> mTipsMap = new HashMap();
    private HashMap<String, ImageInfo> mBase64ImageCropMap = new HashMap<>();
    private HashMap<String, ImageInfo> mBase64ImageSrcMap = new HashMap<>();
    private long mNoFaceTime = 0;
    private volatile LivenessStatus mLivenessStatus = LivenessStatus.LivenessCrop;
    private long mFaceID = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus;

        static {
            int[] iArr = new int[LivenessStatus.values().length];
            $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus = iArr;
            try {
                iArr[LivenessStatus.LivenessReady.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[LivenessStatus.LivenessTips.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[LivenessStatus.LivenessOK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = iArr2;
            try {
                iArr2[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum LivenessStatus {
        LivenessReady,
        LivenessTips,
        LivenessOK,
        LivenessCourse,
        LivenessCrop
    }

    public FaceLivenessStrategyExtModule(Context context) {
        this.mSoundPlayHelper = null;
        LogHelper.clear();
        LogHelper.addLog("ca", "Baidu-IDL-FaceSDK4.1.5");
        LogHelper.addLog("system", Integer.valueOf(Build.VERSION.SDK_INT));
        LogHelper.addLog("version", "4.1.5");
        LogHelper.addLog("device", Build.MODEL + " " + Build.MANUFACTURER);
        LogHelper.addLog("stm", Long.valueOf(System.currentTimeMillis()));
        this.mContext = context;
        this.mDetectStrategy = new DetectStrategy();
        this.mLivenessStrategy = new LivenessStatusStrategy();
        this.mFaceModule = new FaceModuleNew();
        this.mSoundPlayHelper = new SoundPoolHelper(context);
        this.mAnimHandler = new Handler(Looper.getMainLooper());
    }

    private boolean cropStrategy(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, LivenessTypeEnum livenessTypeEnum, int i4) {
        FaceStatusNewEnum cropStatus = this.mDetectStrategy.getCropStatus(faceExtInfo, this.mFaceConfig);
        if (cropStatus != FaceStatusNewEnum.OK) {
            ILivenessStrategyCallback iLivenessStrategyCallback = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback != null) {
                iLivenessStrategyCallback.onLivenessCompletion(cropStatus, getStatusTextResId(cropStatus), null, null, 0);
            }
            return false;
        }
        float totalCropScore = this.mDetectStrategy.getTotalCropScore();
        this.mFaceModule.setFaceConfig(this.mFaceConfig);
        BDFaceImageInstance cropFace = FaceSDKManager.getInstance().cropFace(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.mFaceConfig.getCropHeight(), this.mFaceConfig.getCropWidth());
        if (cropFace == null) {
            return false;
        }
        saveCropImageInstance(faceExtInfo, cropFace, i4, totalCropScore);
        cropFace.destory();
        saveSrcImageInstance(faceExtInfo, bDFaceImageInstance.getImage(), i4, totalCropScore);
        return true;
    }

    private String getStatusTextResId(FaceStatusNewEnum faceStatusNewEnum) {
        String str = "";
        try {
            if (this.mTipsMap.containsKey(faceStatusNewEnum)) {
                str = this.mTipsMap.get(faceStatusNewEnum);
            } else {
                int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
                if (tipsId > 0) {
                    String string = this.mContext.getResources().getString(tipsId);
                    this.mTipsMap.put(faceStatusNewEnum, string);
                    str = string;
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private void judgeLivenessTimeout() {
        if (!this.mLivenessStrategy.isCourseTimeout(this.mFaceConfig) || this.mTipLiveTimeout) {
            return;
        }
        ILivenessViewCallback iLivenessViewCallback = this.mILivenessViewCallback;
        if (iLivenessViewCallback != null) {
            iLivenessViewCallback.setCurrentLiveType(this.mLivenessStrategy.getCurrentLivenessType());
        }
        processUICallback(FaceStatusNewEnum.FaceLivenessActionCodeTimeout, null);
        this.mAnimHandler.postDelayed(new Runnable() { // from class: com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule.1
            @Override // java.lang.Runnable
            public void run() {
                FaceLivenessStrategyExtModule.this.mLivenessStrategy.resetState();
                TimeManager.getInstance().setActiveAnimTime(0);
                if (FaceLivenessStrategyExtModule.this.mILivenessViewCallback != null) {
                    FaceLivenessStrategyExtModule.this.mILivenessViewCallback.animStop();
                }
                FaceLivenessStrategyExtModule.this.mTipLiveTimeout = false;
            }
        }, TimeManager.getInstance().getActiveAnimTime() + 1000);
        this.mTipLiveTimeout = true;
    }

    private void process(byte[] bArr) {
        if (mProcessCount > 0) {
            return;
        }
        mProcessCount++;
        processStrategy(bArr);
        mProcessCount--;
    }

    private void processStrategy(byte[] bArr) {
        BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.mPreviewDegree, 1);
        processUIResult(setFaceModel(FaceSDKManager.getInstance().detect(bDFaceImageInstance)), bDFaceImageInstance);
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            LogHelper.addLogWithKey("etm", Long.valueOf(System.currentTimeMillis()));
        }
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            Log.e(TAG, "processUICompletion");
            this.mIsProcessing = true;
            this.mIsCompletion = true;
            LogHelper.addLogWithKey("etm", Long.valueOf(System.currentTimeMillis()));
            LogHelper.addLogWithKey("finish", 1);
            ILivenessStrategyCallback iLivenessStrategyCallback = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback != null) {
                iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount());
            }
        } else if (faceStatusNewEnum == FaceStatusNewEnum.FaceLivenessActionComplete) {
            ILivenessStrategyCallback iLivenessStrategyCallback2 = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback2 != null) {
                iLivenessStrategyCallback2.onLivenessCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount());
            }
        } else {
            ILivenessStrategyCallback iLivenessStrategyCallback3 = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback3 != null) {
                iLivenessStrategyCallback3.onLivenessCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount() - 1);
            }
        }
    }

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        if (bDFaceImageInstance == null) {
            return;
        }
        if (this.mIsProcessing) {
            bDFaceImageInstance.destory();
        } else if (faceModel != null && faceModel.getFaceInfos() != null && faceModel.getFaceInfos().length != 0) {
            FaceStatusNewEnum faceModuleStateNew = faceModel.getFaceModuleStateNew();
            FaceExtInfo faceExtInfo = faceModel.getFaceInfos()[0];
            FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
            if (faceModuleStateNew != faceStatusNewEnum) {
                if (this.mDetectStrategy.isTimeout()) {
                    bDFaceImageInstance.destory();
                    this.mIsProcessing = true;
                    processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                } else if (AnonymousClass2.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceModuleStateNew.ordinal()] != 1) {
                    bDFaceImageInstance.destory();
                    processUITips(faceModuleStateNew, faceExtInfo);
                    this.mDetectStrategy.reset();
                    this.mLivenessStrategy.resetState();
                } else {
                    if (this.mNoFaceTime == 0) {
                        this.mNoFaceTime = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - this.mNoFaceTime > this.mFaceConfig.getTimeDetectModule()) {
                        bDFaceImageInstance.destory();
                        this.mIsProcessing = true;
                        processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                    } else if (this.mIsFirstLivenessSuccessTipsed && this.mNoFaceTime != 0 && System.currentTimeMillis() - this.mNoFaceTime < FaceEnvironment.TIME_DETECT_NO_FACE_CONTINUOUS) {
                        bDFaceImageInstance.destory();
                    } else {
                        this.mIsFirstLivenessSuccessTipsed = false;
                        bDFaceImageInstance.destory();
                        this.mDetectStrategy.reset();
                        this.mLivenessStrategy.resetState();
                        processUITips(faceModuleStateNew, null);
                    }
                }
            } else if (faceExtInfo == null) {
            } else {
                ILivenessViewCallback iLivenessViewCallback = this.mILivenessViewCallback;
                if (iLivenessViewCallback != null) {
                    iLivenessViewCallback.setFaceInfo(faceExtInfo);
                }
                LivenessStatus livenessStatus = this.mLivenessStatus;
                LivenessStatus livenessStatus2 = LivenessStatus.LivenessCrop;
                if (livenessStatus == livenessStatus2) {
                    if (this.mCropCount < this.mFaceConfig.getCacheImageNum()) {
                        if (cropStrategy(bDFaceImageInstance, faceExtInfo, this.mLivenessStrategy.getCurrentLivenessType(), this.mCropCount)) {
                            this.mCropCount++;
                        }
                    } else {
                        this.mLivenessStatus = LivenessStatus.LivenessReady;
                    }
                }
                LivenessStatus livenessStatus3 = this.mLivenessStatus;
                LivenessStatus livenessStatus4 = LivenessStatus.LivenessReady;
                if (livenessStatus3 == livenessStatus4 || this.mLivenessStatus == LivenessStatus.LivenessTips) {
                    if (faceExtInfo.getFaceId() != this.mFaceID) {
                        this.mLivenessStrategy.reset();
                        FaceSDKManager.getInstance().clearActionHistory();
                        if (this.mFaceID != -1) {
                            this.mLivenessStatus = livenessStatus2;
                            this.mCropCount = 0;
                            HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                            HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
                            if (hashMap2 != null) {
                                hashMap2.clear();
                            }
                        }
                        ILivenessViewCallback iLivenessViewCallback2 = this.mILivenessViewCallback;
                        if (iLivenessViewCallback2 != null) {
                            iLivenessViewCallback2.viewReset();
                        }
                        this.mFaceID = faceExtInfo.getFaceId();
                    }
                    this.mLivenessStrategy.processLiveness(faceExtInfo, bDFaceImageInstance, this.mPreviewRect);
                }
                this.mNoFaceTime = 0L;
                LogHelper.addLogWithKey("btm", Long.valueOf(System.currentTimeMillis()));
                Log.e(TAG, "switch start");
                int i4 = AnonymousClass2.$SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[this.mLivenessStatus.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3 && processUITips(FaceStatusNewEnum.FaceLivenessActionComplete, faceExtInfo)) {
                            if (!this.mIsFirstLivenessSuccessTipsed) {
                                this.mIsFirstLivenessSuccessTipsed = true;
                            }
                            if (this.mLivenessStrategy.isExistNextLiveness()) {
                                this.mLivenessStrategy.startNextLiveness();
                                this.mLivenessStatus = livenessStatus4;
                            } else if (this.mLivenessStrategy.isLivenessSuccess()) {
                                processUICallback(faceStatusNewEnum, faceExtInfo);
                            }
                        }
                    } else if (this.mLivenessStrategy.isCurrentLivenessSuccess()) {
                        this.mLivenessStatus = LivenessStatus.LivenessOK;
                    } else {
                        processUITips(this.mLivenessStrategy.getCurrentLivenessNewStatus(), faceExtInfo);
                        judgeLivenessTimeout();
                        if (this.mLivenessStrategy.isTimeout()) {
                            bDFaceImageInstance.destory();
                            this.mIsProcessing = true;
                            processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                            return;
                        }
                    }
                } else if (processUITips(this.mLivenessStrategy.getCurrentLivenessNewStatus(), faceExtInfo)) {
                    this.mLivenessStatus = LivenessStatus.LivenessTips;
                }
                bDFaceImageInstance.destory();
            }
        } else {
            bDFaceImageInstance.destory();
            DetectStrategy detectStrategy = this.mDetectStrategy;
            if (detectStrategy != null) {
                detectStrategy.reset();
            }
        }
    }

    private boolean processUITips(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum != null) {
            this.mSoundPlayHelper.setEnableSound(this.mIsEnableSound);
            boolean playSound = this.mSoundPlayHelper.playSound(faceStatusNewEnum);
            if (playSound) {
                LogHelper.addTipsLogWithKey(faceStatusNewEnum.name());
                processUICallback(faceStatusNewEnum, faceExtInfo);
                return playSound;
            }
            return playSound;
        }
        return false;
    }

    private void saveCropImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i4, float f4) {
        ArrayList<ImageInfo> detectBestCropImageList = this.mFaceModule.getDetectBestCropImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestCropImageList == null || detectBestCropImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        hashMap.put("bestCropImage_" + i4 + "_" + f4, detectBestCropImageList.get(0));
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i4, float f4) {
        ArrayList<ImageInfo> detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestSrcImageList == null || detectBestSrcImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
        hashMap.put("bestSrcImage_" + i4 + "_" + f4, detectBestSrcImageList.get(0));
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr) {
        FaceExtInfo[] faceExtInfo = this.mFaceModule.getFaceExtInfo(faceInfoArr);
        FaceModel faceModel = new FaceModel();
        faceModel.setFaceInfos(faceExtInfo);
        faceModel.setFaceModuleStateNew(this.mDetectStrategy.checkDetect(this.mDetectRect, faceExtInfo, this.mFaceConfig));
        faceModel.setFrameTime(System.currentTimeMillis());
        return faceModel;
    }

    @Override // com.baidu.idl.face.platform.ILivenessStrategy
    public void livenessStrategy(byte[] bArr) {
        if (!this.mIsFirstTipsed) {
            this.mIsFirstTipsed = true;
            processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, null);
        } else if (this.mIsProcessing) {
        } else {
            process(bArr);
        }
    }

    @Override // com.baidu.idl.face.platform.ILivenessStrategy
    public void reset() {
        FaceSDKManager.getInstance().clearActionHistory();
        LivenessStatusStrategy livenessStatusStrategy = this.mLivenessStrategy;
        if (livenessStatusStrategy != null) {
            livenessStatusStrategy.reset();
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        SoundPoolHelper soundPoolHelper = this.mSoundPlayHelper;
        if (soundPoolHelper != null) {
            soundPoolHelper.release();
        }
        Handler handler = this.mAnimHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mAnimHandler = null;
        }
        this.mIsFirstTipsed = false;
        this.mIsProcessing = false;
    }

    public void setConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    public void setILivenessViewCallback(ILivenessViewCallback iLivenessViewCallback) {
        this.mILivenessViewCallback = iLivenessViewCallback;
    }

    @Override // com.baidu.idl.face.platform.ILivenessStrategy
    public void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback) {
        this.mLivenessStrategy.setLivenessList(list);
        this.mPreviewRect = rect;
        this.mDetectRect = rect2;
        this.mILivenessStrategyCallback = iLivenessStrategyCallback;
    }

    @Override // com.baidu.idl.face.platform.ILivenessStrategy
    public void setLivenessStrategySoundEnable(boolean z3) {
        this.mIsEnableSound = z3;
    }

    @Override // com.baidu.idl.face.platform.ILivenessStrategy
    public void setPreviewDegree(int i4) {
        this.mPreviewDegree = i4;
    }
}
