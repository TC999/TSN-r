package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser;
import com.bykv.vk.component.ttvideo.mediakit.net.IPCache;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.gd.sr.xv;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLDataLoader implements Handler.Callback {
    public static final int AVMDLErrorIsCreateTask = -1000;
    public static final int AVMDLErrorIsInvalidContentLenth = -2000;
    public static final int AVMDLErrorIsInvalidFileWrite = -5000;
    public static final int AVMDLErrorIsInvalidRequestInfo = -4000;
    public static final int AVMDLErrorIsStatusCodeMoreThan400 = -3000;
    public static final int AVMDLErrorIsStatusCodeMoreThan500 = -3001;
    public static final int AVMDLErrorIsTheSameKeyTask = -1001;
    public static final int AVMDLErrorIsTooManyTask = -1002;
    public static final int AVMDLLoaderTypeNone = 10000;
    public static final int AVMDLTaskStateStart = 1;
    public static final int AVMDLTaskStateStop = 2;
    public static final int AVMDLTaskTypeDownloadTask = 3;
    public static final int AVMDLTaskTypePlayTask = 1;
    public static final int AVMDLTaskTypePreloadTask = 2;
    public static final int AVMDLoaderTypeAliP2P = 5;
    public static final int AVMDLoaderTypeHttp = 0;
    public static final int AVMDLoaderTypeKsyP2P = 3;
    public static final int AVMDLoaderTypeOwnLiveVDP = 7;
    public static final int AVMDLoaderTypeOwnVDP = 2;
    public static final int AVMDLoaderTypeWsuP2P = 6;
    public static final int AVMDLoaderTypeXYVod = 1;
    public static final int AVMDLoaderTypeYFP2P = 4;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeyIsAccessCheckLevel = 3511;
    public static final int KeyIsAllowTryTheLastUrl = 7357;
    public static final int KeyIsAlogEnable = 7225;
    public static final int KeyIsAlogInfo = 14;
    public static final int KeyIsCDNLog = 6;
    public static final int KeyIsCacheDirListsStr = 7399;
    public static final int KeyIsCloseFileCache = 800;
    public static final int KeyIsConnectPoolStragetyValue = 7363;
    public static final int KeyIsControlCDNRangeType = 703;
    public static final int KeyIsDNSLog = 15;
    public static final int KeyIsDownloadDir = 7300;
    public static final int KeyIsDownloadEnd = 21;
    public static final int KeyIsDownloadSuspend = 22;
    public static final int KeyIsDownloaderLog = 19;
    public static final int KeyIsDownloaderLogTTNet = 16;
    public static final int KeyIsEnableCacheReqRange = 7358;
    public static final int KeyIsEnableDynamicSocketTimeout = 7362;
    public static final int KeyIsEnableEarlyData = 8219;
    public static final int KeyIsEnableEventInfo = 9999;
    public static final int KeyIsEnableExternDNS = 700;
    public static final int KeyIsEnableFileCacheV2 = 7222;
    public static final int KeyIsEnableFileRingBuffer = 7228;
    public static final int KeyIsEnableIOManager = 7391;
    public static final int KeyIsEnableIpBucket = 901;
    public static final int KeyIsEnableLazyBufferpool = 7332;
    public static final int KeyIsEnableLoaderPreempt = 2510;
    public static final int KeyIsEnableLoaderSeek = 7369;
    public static final int KeyIsEnableNetScheduler = 7342;
    public static final int KeyIsEnableNewBufferpool = 7334;
    public static final int KeyIsEnableP2PPreDown = 7340;
    public static final int KeyIsEnablePlayInfoCache = 7339;
    public static final int KeyIsEnablePlayLog = 7341;
    public static final int KeyIsEnablePreconnect = 2508;
    public static final int KeyIsEnablePreloadReUse = 105;
    public static final int KeyIsEnableSessionReuse = 5511;
    public static final int KeyIsEnableSocketReuse = 701;
    public static final int KeyIsEnableStorageModule = 10000;
    public static final int KeyIsEnableSyncDnsForPcdn = 7226;
    public static final int KeyIsEnableUseFileExtendLoaderBuffer = 7229;
    public static final int KeyIsErrorStateTrustTime = 902;
    public static final int KeyIsFileCacheProgress = 3;
    public static final int KeyIsFirstRangeLeftThreshold = 7346;
    public static final int KeyIsForbidByPassCookie = 1510;
    public static final int KeyIsGetAllCacheSize = 100;
    public static final int KeyIsGetCacheInfo = 101;
    public static final int KeyIsGetCacheSize = 103;
    public static final int KeyIsGetCostLog = 1011;
    public static final int KeyIsGetCustomHttpHeader = 1509;
    public static final int KeyIsGetEnableHls = 9407;
    public static final int KeyIsGetIOManagerHandle = 7390;
    public static final int KeyIsGetLoaderVersion = 11;
    public static final int KeyIsGetLocalAddr = 4;
    public static final int KeyIsGetMdlProtocolHandle = 7218;
    public static final int KeyIsGetPlayLog = 1010;
    public static final int KeyIsGetResStatus = 7231;
    public static final int KeyIsGetSpeedStatus = 7230;
    public static final int KeyIsGetVersionInfo = 830;
    public static final int KeyIsGlobalSpeedSample = 703;
    public static final int KeyIsHeartBeatLog = 70;
    public static final int KeyIsHiJackError = 701;
    public static final int KeyIsIOSpeedInfo = 5;
    public static final int KeyIsIgnorePlayInfo = 9400;
    public static final int KeyIsInitialSocketTimeout = 7360;
    public static final int KeyIsIsCheckPreloadLevel = 6512;
    public static final int KeyIsIsChecksumLevel = 1504;
    public static final int KeyIsIsDownloadSource = 1506;
    public static final int KeyIsIsEnableDownloaderLog = 7347;
    public static final int KeyIsIsEnableTTNetLoader = 7348;
    public static final int KeyIsIsEncryptVersion = 1505;
    public static final int KeyIsIsGetChecksumInfo = 1503;
    public static final int KeyIsIsMaxTlsVersion = 5512;
    public static final int KeyIsIsPreloadCancel = 7;
    public static final int KeyIsIsTestSpeedVersion = 1502;
    public static final int KeyIsLiveCacheThresholdHttpToP2p = 8006;
    public static final int KeyIsLiveCacheThresholdP2pToHttp = 8007;
    public static final int KeyIsLiveContainerString = 8021;
    public static final int KeyIsLiveEnableMdlProto = 8102;
    public static final int KeyIsLiveGetCurrentBitRate = 8004;
    public static final int KeyIsLiveGetLoaderType = 8103;
    public static final int KeyIsLiveGetP2pState = 8002;
    public static final int KeyIsLiveGetPlayCacheSec = 8003;
    public static final int KeyIsLiveLoaderEnable = 8100;
    public static final int KeyIsLiveLoaderP2pEnable = 8101;
    public static final int KeyIsLiveMaxTrySwitchP2pTimes = 8008;
    public static final int KeyIsLiveMobileDownloadAllow = 8011;
    public static final int KeyIsLiveMobileUploadAllow = 8010;
    public static final int KeyIsLivePlayInfoAudioMixingEnd = 8014;
    public static final int KeyIsLivePlayInfoAudioMixingStart = 8013;
    public static final int KeyIsLivePlayInfoIsPreview = 8016;
    public static final int KeyIsLivePlayInfoIsStreamReceived = 8015;
    public static final int KeyIsLiveRecvDataTimeout = 8012;
    public static final int KeyIsLiveSetLoaderType = 8000;
    public static final int KeyIsLiveSetP2pAllow = 8001;
    public static final int KeyIsLiveSetPrepareTask = 8017;
    public static final int KeyIsLiveSetTaskFinish = 8018;
    public static final int KeyIsLiveWaitP2pReadyThreshold = 8009;
    public static final int KeyIsLiveWatchDurationThreshold = 8005;
    public static final int KeyIsLoadMonitorMinAllowLoadSize = 7397;
    public static final int KeyIsLoadMonitorTimeInternal = 7396;
    public static final int KeyIsLoaderCacheSize = 9216;
    public static final int KeyIsLoaderEventCancel = 72;
    public static final int KeyIsLoaderEventCompleted = 73;
    public static final int KeyIsLoaderEventStart = 71;
    public static final int KeyIsLoaderEventUnKnown = 74;
    public static final int KeyIsLoaderFactoryP2PLevel = 8216;
    public static final int KeyIsLoaderFactoryP2PStragetyLevel = 8218;
    public static final int KeyIsLoaderFactoryXYLibValue = 8217;
    public static final int KeyIsLoaderTypeSwitch = 12;
    public static final int KeyIsMAXIPV4Num = 7331;
    public static final int KeyIsMAXIPV6Num = 7330;
    public static final int KeyIsMarkedFileIOSpeed = 1508;
    public static final int KeyIsMaxFileMemCacheNum = 5515;
    public static final int KeyIsMaxFileMemCacheSize = 5513;
    public static final int KeyIsMaxIpCountEachDomain = 900;
    public static final int KeyIsMaxKeepAliveHostNum = 7364;
    public static final int KeyIsMaxSocketReuseNum = 7361;
    public static final int KeyIsNetCacheDir = 5510;
    public static final int KeyIsNetSchedulerBlockAllNetErr = 7343;
    public static final int KeyIsNetSchedulerBlockDurationMs = 7345;
    public static final int KeyIsNetSchedulerBlockErrCount = 7344;
    public static final int KeyIsNetworkAccessType = 7219;
    public static final int KeyIsNetworkChanged = 7217;
    public static final int KeyIsNewBufferPoolGrowBlockCount = 7337;
    public static final int KeyIsNewBufferpoolBlockSize = 7335;
    public static final int KeyIsNewBufferpoolResidentSize = 7336;
    public static final int KeyIsNewPreloadLog = 1002;
    public static final int KeyIsNewProtocolLog = 1001;
    public static final int KeyIsNewProxyLog = 1000;
    public static final int KeyIsNewTaskLog = 1003;
    public static final int KeyIsNextDownloadThreshold = 2511;
    public static final int KeyIsOnLiveLoaderError = 9;
    public static final int KeyIsOwnLiveLoaderLog = 10;
    public static final int KeyIsOwnLiveLoaderLogSample = 11;
    public static final int KeyIsOwnVdpLog = 1;
    public static final int KeyIsP2PFirstRangeLoaderType = 7372;
    public static final int KeyIsP2PPredownPeerCount = 7359;
    public static final int KeyIsPlayInfoBufferingEnd = 7214;
    public static final int KeyIsPlayInfoBufferingStart = 7213;
    public static final int KeyIsPlayInfoCurrentBuffer = 7215;
    public static final int KeyIsPlayInfoLoadPercent = 7212;
    public static final int KeyIsPlayInfoPlayingPos = 7211;
    public static final int KeyIsPlayInfoRenderStart = 7210;
    public static final int KeyIsPlayTaskState = 50;
    public static final int KeyIsPreconnectNum = 2509;
    public static final int KeyIsPreloadEnd = 4;
    public static final int KeyIsPreloadFail = 8;
    public static final int KeyIsPreloadStragetyWhenPlay = 1030;
    public static final int KeyIsPreloadWaitListType = 1040;
    public static final int KeyIsRingBufferSizeKB = 7221;
    public static final int KeyIsSessionTimeout = 7333;
    public static final int KeyIsSetAlogFuncPtr = 1100;
    public static final int KeyIsSetBackupLoaderType = 7227;
    public static final int KeyIsSetCacheDir = 0;
    public static final int KeyIsSetDMDomain = 9402;
    public static final int KeyIsSetDomains = 9404;
    public static final int KeyIsSetEnableOwnVdpPreloadNotify = 7395;
    public static final int KeyIsSetEnableReportTaskLog = 7371;
    public static final int KeyIsSetFileExtendSize = 7392;
    public static final int KeyIsSetForesightDomain = 9403;
    public static final int KeyIsSetGlobalSpeedSampleInterval = 7370;
    public static final int KeyIsSetKeyDomain = 9405;
    public static final int KeyIsSetKeyToken = 9406;
    public static final int KeyIsSetLiveListener = 107;
    public static final int KeyIsSetLoaderFactoryAppInfo = 10;
    public static final int KeyIsSetLoaderFactoryCacheDir = 9;
    public static final int KeyIsSetLoaderFactoryMaxCacheSize = 7;
    public static final int KeyIsSetLoaderFactoryMaxMemorySize = 8;
    public static final int KeyIsSetLoaderType = 6;
    public static final int KeyIsSetMaxCacheAge = 104;
    public static final int KeyIsSetMaxCacheSize = 1;
    public static final int KeyIsSetMinAllowSpeed = 7393;
    public static final int KeyIsSetNetSchedulerBlockHostErrIpCount = 7394;
    public static final int KeyIsSetOnlyUseCdn = 7216;
    public static final int KeyIsSetOpenTimeOut = 3;
    public static final int KeyIsSetPlayInfoSeekAction = 7338;
    public static final int KeyIsSetPreloadParallelNum = 102;
    public static final int KeyIsSetRWTimeOut = 2;
    public static final int KeyIsSetSettingsDomain = 9401;
    public static final int KeyIsSetSpeedSampleInterval = 7368;
    public static final int KeyIsSetTryCount = 5;
    public static final int KeyIsSocketIdleTimeout = 702;
    public static final int KeyIsSocketSendBufferKB = 7220;
    public static final int KeyIsSocketTrainingCenterConfigStr = 7398;
    public static final int KeyIsSpeedCoefficientValue = 1507;
    public static final int KeyIsSpeedInfo = 2;
    public static final int KeyIsSpeedTestSampledByTime = 700;
    public static final int KeyIsSpeedTestSampledByTimeV2 = 702;
    public static final int KeyIsStoIoWriteLimitKBTh1 = 10004;
    public static final int KeyIsStoIoWriteLimitKBTh2 = 10005;
    public static final int KeyIsStoMaxIdleTimeSec = 10006;
    public static final int KeyIsStoPlayDldWinSizeKBLS = 10002;
    public static final int KeyIsStoPlayDldWinSizeKBNM = 10001;
    public static final int KeyIsStoRingBufferSizeKB = 10003;
    public static final int KeyIsTTNetLoaderCronetBufSizeKB = 7349;
    public static final int KeyIsTaskFail = 20;
    public static final int KeyIsTaskLog = 0;
    public static final int KeyIsVdpABTestId = 7223;
    public static final int KeyIsVdpGroupId = 7224;
    public static final int KeyIsWriteFileNotifyIntervalMS = 110;
    public static final int LogInfoKeyIsPcdnTaskLog = 13;
    public static final long LongValueViaConfigNotReady = -998;
    public static final long LongValueViaUnknownKey = -1;
    public static final int S_FAIL = -1;
    public static final int S_OK = 0;
    private static final String TAG = "AVMDLDataLoader";
    private static boolean isSupportQueryEncode = true;
    private static AVMDLDataLoader mInstance;
    private static volatile boolean mIsLibraryLoaded;
    private static volatile boolean mIsMdlTtnetPluginLoaded;
    private boolean isSupportGetAuth;
    private AVMDLDataLoaderConfigure mConfigure;
    private long mEndTime;
    private LoaderListener mEventListener;
    private long mHandle;
    private AVMDLDataLoaderListener mLiveListener;
    private Thread mMsgThread;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private AVMDLStartCompleteListener mStartCompleteListener;
    private volatile int mState;
    private AVMDLDataLoaderListener mVodListener;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private Handler mHandler = null;
    private Handler mLogHandler = null;

    private AVMDLDataLoader(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) throws Exception {
        this.mState = -1;
        this.mConfigure = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mMsgThread = null;
        this.isSupportGetAuth = true;
        this.mStartCompleteListener = null;
        initNativeHandle();
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        if (this.mHandle != 0) {
            initLogThread(this);
            this.mConfigure = aVMDLDataLoaderConfigure;
            this.mState = 0;
            this.isSupportGetAuth = true;
            return;
        }
        throw new Exception("create native mdl fail");
    }

    private static native void _addDataSource(long j4, int i4, String str);

    private static native void _cancel(long j4, String str);

    private static native void _cancelAll(long j4);

    private static native void _cancelAllPreloadWaitReqs(long j4);

    private static native void _clearAllCaches(long j4);

    private static native void _clearCachesByUsedTime(long j4, long j5);

    private static native void _clearNetinfoCache(long j4);

    private static native void _close(long j4);

    private final native long _create();

    private static native void _downloadResource(long j4, String str);

    private static native String _encodeUrl(String str, int i4);

    private static native void _forceRemoveCacheFile(long j4, String str);

    private static native String _getAuth(long j4, String str);

    private static native String _getCDNLog(long j4, String str);

    private static native long _getLongValue(long j4, int i4);

    private static native long _getLongValueByStr(long j4, String str, int i4);

    private static native long _getLongValueByStrStr(long j4, String str, String str2, int i4);

    private static native String _getStringValue(long j4, int i4);

    private static native String _getStringValueByStr(long j4, String str, int i4);

    private static native String _getStringValueByStrStr(long j4, String str, String str2, int i4);

    private static native void _makeFileAutoDeleteFlag(long j4, String str, int i4);

    private static native String _makeTsFileKey(String str, String str2);

    private static native void _p2pPredown(long j4, String str);

    private static native void _preConnectByHost(long j4, String str, int i4);

    private static native void _preloadGroupResource(long j4, String str, String str2, int i4, int i5);

    private static native void _preloadResource(long j4, String str, int i4);

    private static native void _preloadResourceWithOffset(long j4, String str, int i4, int i5);

    private static native void _removeCacheFile(long j4, String str);

    private static native void _resumeFileWriteIO(long j4);

    private static native void _setInt64Value(long j4, int i4, long j5);

    private static native void _setInt64ValueByStrKey(long j4, int i4, String str, long j5);

    private static native void _setIntValue(long j4, int i4, int i5);

    private static native void _setStringValue(long j4, int i4, String str);

    private static native int _start(long j4);

    private static native void _stop(long j4);

    private static native void _suspendedDownload(long j4, String str);

    private static native void _updateDNSInfo(long j4, String str, String str2, long j5, String str3, int i4);

    private String createFilePathBaseDir(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str3 = str + str2;
        } else {
            str3 = str + TTPathConst.sSeparator + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str3;
    }

    private String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static AVMDLDataLoader getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDataLoader.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDataLoader(null);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        Log.e("ttmdl", "create native exception" + e4);
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    private void hijack() {
        AVMDLLog.d("ttmn", "----hijack start");
        AVMDLDNSParser.processHijack();
        AVMDLLog.d("ttmn", "hijack clear net cache: ");
        clearNetinfoCache();
        AVMDLLog.d("ttmn", "****hijack end");
    }

    public static synchronized int init(boolean z3) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z3;
            if (!mIsLibraryLoaded) {
                try {
                    System.loadLibrary("avmdl_lite");
                    mIsLibraryLoaded = true;
                } catch (UnsatisfiedLinkError e4) {
                    Log.e("ttmn", "Can't load avmdl library: " + e4);
                } catch (Throwable th) {
                    Log.e("ttmn", "other exception when loading avmdl library: " + th);
                }
                tryLoadTTNetLoaderPlugin();
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }

    private void initLogThread(final Handler.Callback callback) {
        if (this.mMsgThread == null) {
            xv xvVar = new xv() { // from class: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super("AVMDLDataLoader$1");
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    AVMDLDataLoader.this.mLogHandler = new Handler(callback);
                    Looper.loop();
                }
            };
            this.mMsgThread = xvVar;
            xvVar.setName("mdl_log_handler");
            this.mMsgThread.start();
        }
    }

    private void initNativeHandle() {
        if (this.mHandle != 0) {
            return;
        }
        try {
            this.mHandle = _create();
        } catch (Throwable th) {
            this.mHandle = 0L;
            th.printStackTrace();
        }
        if (this.mHandle == 0 || this.mHandler != null) {
            return;
        }
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
    }

    private boolean isNotifyInfo(int i4) {
        return i4 == 4 || i4 == 20 || i4 == 50 || i4 == 8 || i4 == 3 || i4 == 21 || i4 == 7 || i4 == 22;
    }

    public static String makeTsFileKey(String str, String str2) {
        try {
            return _makeTsFileKey(str, str2);
        } catch (Exception e4) {
            AVMDLLog.e(TAG, "makeTsFileKey failed, other reason:  " + e4.getMessage());
            return null;
        } catch (UnsatisfiedLinkError e5) {
            AVMDLLog.e(TAG, "makeTsFileKey failed, native not support: " + e5.getMessage());
            return null;
        }
    }

    private boolean postMessage(AVMDLDataLoaderListener aVMDLDataLoaderListener, Message message) {
        Object obj;
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo;
        if (message.what == 701) {
            AVMDLLog.d("ttmn", "receive hijack err: ");
            hijack();
            return true;
        }
        if (aVMDLDataLoaderListener != null && (obj = message.obj) != null && (aVMDLDataLoaderNotifyInfo = (AVMDLDataLoaderNotifyInfo) obj) != null) {
            aVMDLDataLoaderListener.onNotify(aVMDLDataLoaderNotifyInfo);
        }
        return true;
    }

    public static String queryComponentEncode(String str) {
        if (isSupportQueryEncode && !TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, "before encode, src: " + str);
            try {
                return _encodeUrl(str, 4);
            } catch (Exception e4) {
                AVMDLLog.d(TAG, "query ComponentEncode:err " + e4.getMessage());
                AVMDLLog.d(TAG, "query ComponentEncode:stacktrace " + e4.getStackTrace());
            } catch (UnsatisfiedLinkError e5) {
                isSupportQueryEncode = false;
                AVMDLLog.d(TAG, "query ComponentEncode:err " + e5.getMessage());
                AVMDLLog.d(TAG, "query ComponentEncode:stacktrace " + e5.getStackTrace());
            }
        }
        return null;
    }

    private void setConfigureInternal(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        if (this.mHandle == 0 || aVMDLDataLoaderConfigure == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mCacheDir)) {
            String createFilePathBaseDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "loaderFactory");
            if (!TextUtils.isEmpty(createFilePathBaseDir)) {
                _setStringValue(this.mHandle, 9, createFilePathBaseDir);
            }
            if (TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
                aVMDLDataLoaderConfigure.mNetCacheDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "netCache");
            }
            _setStringValue(this.mHandle, 0, aVMDLDataLoaderConfigure.mCacheDir);
        }
        if (!TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
            _setStringValue(this.mHandle, KeyIsNetCacheDir, aVMDLDataLoaderConfigure.mNetCacheDir);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mAppInfo)) {
            _setStringValue(this.mHandle, 10, aVMDLDataLoaderConfigure.mAppInfo);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDownloadDir)) {
            _setStringValue(this.mHandle, KeyIsDownloadDir, aVMDLDataLoaderConfigure.mDownloadDir);
        }
        _setIntValue(this.mHandle, KeyIsLiveSetP2pAllow, aVMDLDataLoaderConfigure.mLiveP2pAllow);
        _setIntValue(this.mHandle, KeyIsLiveSetLoaderType, aVMDLDataLoaderConfigure.mLiveLoaderType);
        _setIntValue(this.mHandle, KeyIsLiveWatchDurationThreshold, aVMDLDataLoaderConfigure.mLiveWatchDurationThreshold);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdHttpToP2p, aVMDLDataLoaderConfigure.mLiveCacheThresholdHttpToP2p);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdP2pToHttp, aVMDLDataLoaderConfigure.mLiveCacheThresholdP2pToHttp);
        _setIntValue(this.mHandle, KeyIsLiveMaxTrySwitchP2pTimes, aVMDLDataLoaderConfigure.mLiveMaxTrySwitchP2pTimes);
        _setIntValue(this.mHandle, KeyIsLiveWaitP2pReadyThreshold, aVMDLDataLoaderConfigure.mLiveWaitP2pReadyThreshold);
        _setIntValue(this.mHandle, KeyIsLiveMobileUploadAllow, aVMDLDataLoaderConfigure.mLiveMobileUploadAllow);
        _setIntValue(this.mHandle, KeyIsLiveMobileDownloadAllow, aVMDLDataLoaderConfigure.mLiveMobileDownloadAllow);
        _setIntValue(this.mHandle, KeyIsLiveRecvDataTimeout, aVMDLDataLoaderConfigure.mLiveRecvDataTimeout);
        _setStringValue(this.mHandle, KeyIsLiveContainerString, aVMDLDataLoaderConfigure.mLiveContainerString);
        _setIntValue(this.mHandle, 1, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 2, aVMDLDataLoaderConfigure.mRWTimeOut);
        _setIntValue(this.mHandle, 3, aVMDLDataLoaderConfigure.mOpenTimeOut);
        _setIntValue(this.mHandle, 5, aVMDLDataLoaderConfigure.mTryCount);
        _setIntValue(this.mHandle, 7, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 8, aVMDLDataLoaderConfigure.mLoaderFactoryMaxMemorySize);
        _setIntValue(this.mHandle, 6, aVMDLDataLoaderConfigure.mLoaderType);
        _setIntValue(this.mHandle, 102, aVMDLDataLoaderConfigure.mPreloadParallelNum);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        int i4 = aVMDLDataLoaderConfigure.mMaxCacheAge;
        if (i4 > 0) {
            _setIntValue(this.mHandle, 104, i4);
        }
        _setIntValue(this.mHandle, 1030, aVMDLDataLoaderConfigure.mPreloadStrategy);
        _setIntValue(this.mHandle, KeyIsPreloadWaitListType, aVMDLDataLoaderConfigure.mPreloadWaitListType);
        _setIntValue(this.mHandle, 105, aVMDLDataLoaderConfigure.mEnablePreloadReUse);
        _setIntValue(this.mHandle, 700, aVMDLDataLoaderConfigure.mEnableExternDNS);
        _setIntValue(this.mHandle, 701, aVMDLDataLoaderConfigure.mEnableSocketReuse);
        _setIntValue(this.mHandle, 703, aVMDLDataLoaderConfigure.mControlCDNRangeType);
        _setIntValue(this.mHandle, 702, aVMDLDataLoaderConfigure.mSocketIdleTimeOut);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryP2PLevel, aVMDLDataLoaderConfigure.mLoaderFactoryP2PLevel);
        _setIntValue(this.mHandle, KeyIsIsTestSpeedVersion, aVMDLDataLoaderConfigure.mTestSpeedTypeVersion);
        _setIntValue(this.mHandle, KeyIsIsChecksumLevel, aVMDLDataLoaderConfigure.mCheckSumLevel);
        _setIntValue(this.mHandle, KeyIsIsEncryptVersion, aVMDLDataLoaderConfigure.mEncryptVersion);
        _setIntValue(this.mHandle, KeyIsSpeedCoefficientValue, aVMDLDataLoaderConfigure.mSpeedCoefficientValue);
        _setIntValue(this.mHandle, 900, aVMDLDataLoaderConfigure.mMaxIpCountEachDomain);
        _setIntValue(this.mHandle, 901, aVMDLDataLoaderConfigure.mEnableIpBucket);
        _setIntValue(this.mHandle, 902, aVMDLDataLoaderConfigure.mErrorStateTrustTime);
        _setIntValue(this.mHandle, KeyIsEnablePreconnect, aVMDLDataLoaderConfigure.mEnablePreconnect);
        _setIntValue(this.mHandle, KeyIsPreconnectNum, aVMDLDataLoaderConfigure.mPreconnectNum);
        _setIntValue(this.mHandle, KeyIsEnableLoaderPreempt, aVMDLDataLoaderConfigure.mEnableLoaderPreempt);
        _setIntValue(this.mHandle, KeyIsNextDownloadThreshold, aVMDLDataLoaderConfigure.mNextDownloadThreshold);
        _setIntValue(this.mHandle, KeyIsSetOnlyUseCdn, aVMDLDataLoaderConfigure.mOnlyUseCdn);
        _setIntValue(this.mHandle, KeyIsAccessCheckLevel, aVMDLDataLoaderConfigure.mAccessCheckLevel);
        _setIntValue(this.mHandle, KeyIsEnableSessionReuse, aVMDLDataLoaderConfigure.mEnableSessionReuse);
        _setIntValue(this.mHandle, KeyIsIsMaxTlsVersion, aVMDLDataLoaderConfigure.mMaxTlsVersion);
        _setIntValue(this.mHandle, KeyIsIsCheckPreloadLevel, aVMDLDataLoaderConfigure.mCheckPreloadLevel);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryXYLibValue, aVMDLDataLoaderConfigure.mXYLibValue);
        _setIntValue(this.mHandle, KeyIsEnableP2PPreDown, aVMDLDataLoaderConfigure.mEnableP2PPreDown);
        _setIntValue(this.mHandle, KeyIsEnablePlayLog, aVMDLDataLoaderConfigure.mEnablePlayLog);
        _setIntValue(this.mHandle, KeyIsEnableNetScheduler, aVMDLDataLoaderConfigure.mEnableNetScheduler);
        _setIntValue(this.mHandle, KeyIsEnableCacheReqRange, aVMDLDataLoaderConfigure.mEnableCacheReqRange);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockAllNetErr, aVMDLDataLoaderConfigure.mNetSchedulerBlockAllNetErr);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockErrCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockErrCount);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockDurationMs, aVMDLDataLoaderConfigure.mNetSChedulerBlockDurationMs);
        _setIntValue(this.mHandle, KeyIsFirstRangeLeftThreshold, aVMDLDataLoaderConfigure.mFirstRangeLeftThreshold);
        _setIntValue(this.mHandle, KeyIsSetNetSchedulerBlockHostErrIpCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockHostIpErrCount);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheSize, aVMDLDataLoaderConfigure.mMaxFileMemCacheSize);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheNum, aVMDLDataLoaderConfigure.mMaxFileMemCacheNum);
        _setIntValue(this.mHandle, 110, aVMDLDataLoaderConfigure.mWriteFileNotifyIntervalMS);
        _setIntValue(this.mHandle, KeyIsP2PPredownPeerCount, aVMDLDataLoaderConfigure.mP2PPreDownPeerCount);
        _setIntValue(this.mHandle, KeyIsP2PFirstRangeLoaderType, aVMDLDataLoaderConfigure.mP2PFirstRangeLoaderType);
        int i5 = aVMDLDataLoaderConfigure.mSocketSendBufferKB;
        if (i5 > 0) {
            _setIntValue(this.mHandle, KeyIsSocketSendBufferKB, i5);
        }
        int i6 = aVMDLDataLoaderConfigure.mRingBufferSizeKB;
        if (i6 > 0) {
            _setIntValue(this.mHandle, KeyIsRingBufferSizeKB, i6);
        }
        _setIntValue(this.mHandle, KeyIsEnableFileCacheV2, aVMDLDataLoaderConfigure.mEnableFileCacheV2);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpABTestId)) {
            _setStringValue(this.mHandle, KeyIsVdpABTestId, aVMDLDataLoaderConfigure.mVdpABTestId);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpGroupId)) {
            _setStringValue(this.mHandle, KeyIsVdpGroupId, aVMDLDataLoaderConfigure.mVdpGroupId);
        }
        _setIntValue(this.mHandle, KeyIsAlogEnable, aVMDLDataLoaderConfigure.mAlogEnable);
        _setIntValue(this.mHandle, KeyIsEnableSyncDnsForPcdn, aVMDLDataLoaderConfigure.mEnableSyncDnsForPcdn);
        _setIntValue(this.mHandle, KeyIsEnableFileRingBuffer, aVMDLDataLoaderConfigure.mEnableFileRingBuffer);
        _setIntValue(this.mHandle, KeyIsEnableLazyBufferpool, aVMDLDataLoaderConfigure.mEnableLazyBufferpool);
        _setIntValue(this.mHandle, KeyIsEnableNewBufferpool, aVMDLDataLoaderConfigure.mEnableNewBufferpool);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolBlockSize, aVMDLDataLoaderConfigure.mNewBufferPoolBlockSize);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolResidentSize, aVMDLDataLoaderConfigure.mNewBufferPoolResidentSize);
        _setIntValue(this.mHandle, KeyIsNewBufferPoolGrowBlockCount, aVMDLDataLoaderConfigure.mNewBufferPoolGrowBlockCount);
        _setIntValue(this.mHandle, KeyIsEnableUseFileExtendLoaderBuffer, aVMDLDataLoaderConfigure.mEnableUseFileExtendLoaderBuffer);
        _setIntValue(this.mHandle, KeyIsMAXIPV6Num, aVMDLDataLoaderConfigure.mMaxIPV6Num);
        _setIntValue(this.mHandle, KeyIsMAXIPV4Num, aVMDLDataLoaderConfigure.mMaxIPV4Num);
        _setIntValue(this.mHandle, KeyIsForbidByPassCookie, aVMDLDataLoaderConfigure.mForbidByPassCookie);
        _setIntValue(this.mHandle, KeyIsSessionTimeout, aVMDLDataLoaderConfigure.mSessionTimeout);
        _setIntValue(this.mHandle, KeyIsEnablePlayInfoCache, aVMDLDataLoaderConfigure.mEnablePlayInfoCache);
        _setIntValue(this.mHandle, KeyIsIsEnableDownloaderLog, aVMDLDataLoaderConfigure.mEnableDownloaderLog);
        _setIntValue(this.mHandle, KeyIsIsEnableTTNetLoader, aVMDLDataLoaderConfigure.mEnableTTNetLoader);
        _setIntValue(this.mHandle, KeyIsTTNetLoaderCronetBufSizeKB, aVMDLDataLoaderConfigure.mTTNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsAllowTryTheLastUrl, aVMDLDataLoaderConfigure.mIsAllowTryTheLastUrl);
        _setIntValue(this.mHandle, KeyIsSetSpeedSampleInterval, aVMDLDataLoaderConfigure.mSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableIOManager, aVMDLDataLoaderConfigure.mEnableIOManager);
        _setIntValue(this.mHandle, KeyIsEnableLoaderSeek, aVMDLDataLoaderConfigure.mEnableLoaderSeek);
        _setIntValue(this.mHandle, KeyIsSetGlobalSpeedSampleInterval, aVMDLDataLoaderConfigure.mGlobalSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableDynamicSocketTimeout, aVMDLDataLoaderConfigure.mEnableDynamicTimeout);
        _setIntValue(this.mHandle, KeyIsInitialSocketTimeout, aVMDLDataLoaderConfigure.mSocketInitialTimeout);
        _setIntValue(this.mHandle, KeyIsMaxSocketReuseNum, aVMDLDataLoaderConfigure.mMaxSocketReuseCount);
        _setIntValue(this.mHandle, KeyIsSetEnableReportTaskLog, aVMDLDataLoaderConfigure.mEnableReportTaskLog);
        _setInt64Value(this.mHandle, KeyIsLoaderFactoryP2PStragetyLevel, aVMDLDataLoaderConfigure.mP2PStragetyLevel);
        _setInt64Value(this.mHandle, KeyIsConnectPoolStragetyValue, aVMDLDataLoaderConfigure.mConnectPoolStragetyValue);
        _setIntValue(this.mHandle, KeyIsMaxKeepAliveHostNum, aVMDLDataLoaderConfigure.mMaxAliveHostNum);
        _setIntValue(this.mHandle, KeyIsSetFileExtendSize, aVMDLDataLoaderConfigure.mFileExtendSizeKB);
        _setIntValue(this.mHandle, KeyIsSetMinAllowSpeed, aVMDLDataLoaderConfigure.mMinAllowSpeed);
        _setIntValue(this.mHandle, KeyIsSetEnableOwnVdpPreloadNotify, aVMDLDataLoaderConfigure.mEnableOwnVDPPreloadNotify);
        _setIntValue(this.mHandle, KeyIsEnableEarlyData, aVMDLDataLoaderConfigure.mEnableEarlyData);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorMinAllowLoadSize, aVMDLDataLoaderConfigure.mMonitorMinAllowLoadSize);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorTimeInternal, aVMDLDataLoaderConfigure.mMonitorTimeInternal);
        _setStringValue(this.mHandle, KeyIsSocketTrainingCenterConfigStr, aVMDLDataLoaderConfigure.mSocketTraingCenterConfigStr);
        _setStringValue(this.mHandle, KeyIsCacheDirListsStr, aVMDLDataLoaderConfigure.mCacheDirListsStr);
        int i7 = aVMDLDataLoaderConfigure.mEnableEventInfo;
        if (i7 > 0) {
            _setIntValue(this.mHandle, KeyIsEnableEventInfo, i7);
        }
        int i8 = aVMDLDataLoaderConfigure.mEnableStorageModule;
        if (i8 > 0) {
            _setIntValue(this.mHandle, 10000, i8);
            int i9 = aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBNM;
            if (i9 > 0) {
                _setIntValue(this.mHandle, 10001, i9);
            }
            int i10 = aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBLS;
            if (i10 > 0) {
                _setIntValue(this.mHandle, 10002, i10);
            }
            int i11 = aVMDLDataLoaderConfigure.mStoRingBufferSizeKB;
            if (i11 > 0) {
                _setIntValue(this.mHandle, 10003, i11);
            }
            int i12 = aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh1;
            if (i12 > 0) {
                _setIntValue(this.mHandle, 10004, i12);
            }
            int i13 = aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh2;
            if (i13 > 0) {
                _setIntValue(this.mHandle, 10005, i13);
            }
            int i14 = aVMDLDataLoaderConfigure.mStoMaxIdleTimeSec;
            if (i14 > 0) {
                _setIntValue(this.mHandle, 10006, i14);
            }
        }
        _setIntValue(this.mHandle, KeyIsIgnorePlayInfo, aVMDLDataLoaderConfigure.mIgnorePlayInfo);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mSettingsDomain)) {
            _setStringValue(this.mHandle, KeyIsSetSettingsDomain, aVMDLDataLoaderConfigure.mSettingsDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDmDomain)) {
            _setStringValue(this.mHandle, KeyIsSetDMDomain, aVMDLDataLoaderConfigure.mDmDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mForesightDomain)) {
            _setStringValue(this.mHandle, KeyIsSetForesightDomain, aVMDLDataLoaderConfigure.mForesightDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDomains)) {
            _setStringValue(this.mHandle, KeyIsSetDomains, aVMDLDataLoaderConfigure.mDomains);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyDomain)) {
            _setStringValue(this.mHandle, KeyIsSetKeyDomain, aVMDLDataLoaderConfigure.mKeyDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyToken)) {
            _setStringValue(this.mHandle, KeyIsSetKeyToken, aVMDLDataLoaderConfigure.mKeyToken);
        }
        AVMDLDNSParser.setIntValue(0, this.mConfigure.mDNSMainType);
        AVMDLDNSParser.setIntValue(1, this.mConfigure.mDNSBackType);
        AVMDLDNSParser.setIntValue(2, this.mConfigure.mDefaultExpiredTime);
        AVMDLDNSParser.setIntValue(3, this.mConfigure.mMainToBackUpDelayedTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                initLogThread(this);
                if (this.mHandle != 0) {
                    setConfigureInternal(this.mConfigure);
                    if (_start(this.mHandle) >= 0) {
                        this.mState = 1;
                    }
                }
            }
            this.mWriteLock.unlock();
            if (this.mConfigure.mEnableBenchMarkIOSpeed > 0) {
                int testFileIOSpeed = testFileIOSpeed();
                AVMDLLog.d("BENCHMARKIO", String.format("test io average speed:%d", Integer.valueOf(testFileIOSpeed)));
                if (testFileIOSpeed > 0) {
                    setIntValue(KeyIsMarkedFileIOSpeed, testFileIOSpeed);
                }
            }
            AVMDLStartCompleteListener aVMDLStartCompleteListener = this.mStartCompleteListener;
            if (aVMDLStartCompleteListener != null) {
                aVMDLStartCompleteListener.onStartComplete();
            }
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    private double testFileIO(String str, int i4, RandomAccessFile randomAccessFile) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return -1.0d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        randomAccessFile.seek(i4);
        byte[] bArr = new byte[4096];
        for (int i5 = 0; i5 < 200; i5++) {
            Thread.sleep(5);
            randomAccessFile.write(bArr, 0, 1024);
        }
        long currentTimeMillis2 = ((System.currentTimeMillis() - currentTimeMillis) - 1000) + 0;
        if (currentTimeMillis2 > 0) {
            AVMDLLog.d("BENCHMARKIO", String.format("size:%d costtime:%d", 819200, Long.valueOf(currentTimeMillis2)));
            return 819200 / currentTimeMillis2;
        }
        return -1.0d;
    }

    private int testFileIOSpeed() {
        double d4;
        if (TextUtils.isEmpty(this.mConfigure.mCacheDir)) {
            return -1;
        }
        String str = this.mConfigure.mCacheDir;
        String format = str.charAt(str.length() - 1) == '/' ? String.format("%siospeed", this.mConfigure.mCacheDir) : String.format("%s/iospeed", this.mConfigure.mCacheDir);
        File file = new File(format);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(format, "iospeed.cach");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            double d5 = 0.0d;
            double d6 = 0.0d;
            for (int i4 = 0; i4 < 30; i4++) {
                try {
                    d4 = testFileIO(format, i4, randomAccessFile);
                    try {
                        AVMDLLog.d("BENCHMARKIO", String.format("num:%d result:%f", Integer.valueOf(i4), Double.valueOf(d4)));
                    } catch (Exception e4) {
                        e = e4;
                        AVMDLLog.d("BENCHMARKIO", "test fileio exception:" + e);
                        e.printStackTrace();
                        if (d4 > 0.0d) {
                            try {
                                d6 += d4;
                                d5 += 1.0d;
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    d4 = 0.0d;
                }
                if (d4 > 0.0d && i4 >= 20) {
                    d6 += d4;
                    d5 += 1.0d;
                }
            }
            randomAccessFile.close();
            file2.delete();
            if (d5 > 0.0d) {
                return (int) (d6 / d5);
            }
            return 0;
        } catch (Exception e6) {
            AVMDLLog.d("BENCHMARKIO", "create accefile exception:" + e6);
            return -1;
        }
    }

    public static synchronized boolean tryLoadTTNetLoaderPlugin() {
        boolean z3;
        synchronized (AVMDLDataLoader.class) {
            z3 = mIsMdlTtnetPluginLoaded;
        }
        return z3;
    }

    public static boolean tryLoadVcnverifylib() {
        AVMDLLog.d("vcn", "load vcnverify suc");
        return true;
    }

    public void addDataSource(int i4, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AVMDLLog.d(TAG, "addDataSource: id: " + i4 + ", queyr: " + str);
        this.mWriteLock.lock();
        try {
            _addDataSource(this.mHandle, i4, str);
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void cancel(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _cancel(j4, str);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAll() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _cancelAll(j4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAllPreloadWaitReqs() {
        if (this.mState != 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _cancelAllPreloadWaitReqs(j4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void clearAllCaches() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _clearAllCaches(j4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void clearNetinfoCache() {
        if (this.mState != 1) {
            return;
        }
        IPCache.getInstance().clear();
        this.mWriteLock.lock();
        try {
            try {
                _clearNetinfoCache(this.mHandle);
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void close() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _close(j4);
                    this.mHandle = 0L;
                    this.mState = 5;
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.mHandler = null;
                    }
                    Handler handler2 = this.mLogHandler;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        this.mLogHandler.getLooper().quit();
                        this.mLogHandler = null;
                        this.mMsgThread = null;
                    }
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void doParseHosts(String[] strArr) {
        AVMDLDNSParser.getInstance().doParseHosts(strArr);
    }

    public void downloadResource(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        _downloadResource(j4, str);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void forceRemoveFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        _forceRemoveCacheFile(j4, str);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public long getAllCacheSize() {
        long j4 = -1;
        if (this.mState != 1) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j5 = this.mHandle;
                if (j5 != 0) {
                    j4 = _getLongValue(j5, 100);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
            return j4;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getAuth(String str) {
        String str2 = null;
        if (this.mState == 1 && this.isSupportGetAuth) {
            this.mReadLock.lock();
            try {
                try {
                    str2 = _getAuth(this.mHandle, str);
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                    this.isSupportGetAuth = false;
                }
                return str2;
            } finally {
                this.mReadLock.unlock();
            }
        }
        return null;
    }

    public String getCDNLog(String str) {
        String str2 = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                str2 = _getCDNLog(this.mHandle, str);
            } catch (UnsatisfiedLinkError e4) {
                AVMDLLog.d(TAG, "not support get cdnlog," + e4.toString());
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public AVMDLFileInfo getCacheInfo(String str) {
        AVMDLFileInfo aVMDLFileInfo = null;
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mReadLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        String[] split = _getStringValueByStr(j4, str, 101).split(",");
                        if (split.length >= 3) {
                            AVMDLFileInfo aVMDLFileInfo2 = new AVMDLFileInfo();
                            try {
                                aVMDLFileInfo2.mFilePath = split[2];
                                if (!TextUtils.isEmpty(split[0])) {
                                    aVMDLFileInfo2.mCacheSize = Long.valueOf(split[0]).longValue();
                                }
                                if (!TextUtils.isEmpty(split[1])) {
                                    aVMDLFileInfo2.mContentLenght = Long.valueOf(split[1]).longValue();
                                }
                                aVMDLFileInfo = aVMDLFileInfo2;
                            } catch (UnsatisfiedLinkError e4) {
                                e = e4;
                                aVMDLFileInfo = aVMDLFileInfo2;
                                e.printStackTrace();
                                return aVMDLFileInfo;
                            }
                        }
                    }
                } catch (UnsatisfiedLinkError e5) {
                    e = e5;
                }
                return aVMDLFileInfo;
            } finally {
                this.mReadLock.unlock();
            }
        }
        return null;
    }

    public long getCacheSize(String str, String str2) {
        long j4 = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j5 = this.mHandle;
                if (j5 != 0) {
                    j4 = _getLongValueByStrStr(j5, str, str2, 103);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
            return j4;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public AVMDLDataLoaderConfigure getConfig() {
        if (this.mState != 1) {
            return null;
        }
        return this.mConfigure;
    }

    public long getInt64Value(int i4, long j4) {
        if (i4 == 8003 || i4 == 8004) {
            AVMDLDataLoaderListener aVMDLDataLoaderListener = this.mLiveListener;
            if (aVMDLDataLoaderListener != null) {
                return aVMDLDataLoaderListener.getInt64Value(i4, j4);
            }
            AVMDLLog.e("ttmn", "getInt64Value mLiveListener is nullptr, code: " + i4);
        }
        AVMDLLog.d("ttmn", "getInt64Value code: " + i4 + " defaultValue: " + j4);
        return j4;
    }

    public String getLocalAddr() {
        String str = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    str = _getStringValue(j4, 4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getLongValue(int i4) {
        int i5;
        long j4;
        long j5 = -1;
        if (i4 != 7218 && i4 != 7390 && i4 != 9407) {
            if (this.mState != 1) {
                AVMDLLog.d("ttmn", "getLongValue key: " + i4 + " result: -1");
                return -1L;
            } else if (this.mConfigure == null) {
                AVMDLLog.d("ttmn", "getLongValue key: " + i4 + " result: -998");
                return -998L;
            } else {
                this.mReadLock.lock();
                try {
                    try {
                        switch (i4) {
                            case KeyIsLiveLoaderEnable /* 8100 */:
                                i5 = this.mConfigure.mLiveLoaderEnable;
                                j4 = i5;
                                j5 = j4;
                                break;
                            case KeyIsLiveLoaderP2pEnable /* 8101 */:
                                i5 = this.mConfigure.mLiveP2pAllow;
                                j4 = i5;
                                j5 = j4;
                                break;
                            case 8102:
                                i5 = this.mConfigure.mLiveEnableMdlProto;
                                j4 = i5;
                                j5 = j4;
                                break;
                            case KeyIsLiveGetLoaderType /* 8103 */:
                                i5 = this.mConfigure.mLiveLoaderType;
                                j4 = i5;
                                j5 = j4;
                                break;
                            default:
                                long j6 = this.mHandle;
                                if (j6 != 0) {
                                    j4 = _getLongValue(j6, i4);
                                    j5 = j4;
                                    break;
                                }
                                break;
                        }
                    } catch (UnsatisfiedLinkError e4) {
                        e4.printStackTrace();
                    }
                    AVMDLLog.d("ttmn", "getLongValue key: " + i4 + " result: " + j5);
                    return j5;
                } finally {
                    this.mReadLock.unlock();
                }
            }
        }
        long j7 = this.mHandle;
        if (j7 != 0) {
            return _getLongValue(j7, i4);
        }
        return -1L;
    }

    public long getLongValueByStr(String str, int i4) {
        long j4 = -1;
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j5 = this.mHandle;
                    if (j5 != 0) {
                        j4 = _getLongValueByStr(j5, str, i4);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
                return j4;
            } finally {
                this.mWriteLock.unlock();
            }
        }
        return -1L;
    }

    public String getStringCacheInfo(String str) {
        String str2 = null;
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mReadLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        str2 = _getStringValueByStr(j4, str, 101);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
                return str2;
            } finally {
                this.mReadLock.unlock();
            }
        }
        return null;
    }

    public String getStringValue(int i4) {
        String str = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    str = _getStringValue(j4, i4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValueByStr(String str, int i4) {
        String str2 = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    str2 = _getStringValueByStr(j4, str, i4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValueByStrkey(int i4, long j4, String str) {
        if (this.mState != 1) {
            return null;
        }
        if (i4 != 1503) {
            if ((i4 != 1506 && i4 != 1509) || this.mVodListener == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mVodListener.getStringValue(i4, j4, str);
        } else if (this.mVodListener == null || TextUtils.isEmpty(str)) {
            return null;
        } else {
            return this.mVodListener.getCheckSumInfo(str);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 12 || i4 == 9) {
            return postMessage(this.mLiveListener, message);
        }
        if (i4 != 71 && i4 != 72 && i4 != 73 && i4 != 74) {
            return postMessage(this.mVodListener, message);
        }
        return postMessage(this.mEventListener, message);
    }

    public boolean isRunning() {
        return this.mState == 1;
    }

    public void makeFileAutoDeleteFlag(String str, int i4) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        _makeFileAutoDeleteFlag(j4, str, i4);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void onEventInfo(Object obj) {
        String str;
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        LoaderEventInfo loaderEventInfo = new LoaderEventInfo();
        loaderEventInfo.what = 74;
        try {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("what")) {
                loaderEventInfo.what = ((Integer) hashMap.get("what")).intValue();
                AVMDLLog.d(TAG, "[debugUI] eventMap contains What" + loaderEventInfo.what);
            }
            if (hashMap.containsKey("taskType")) {
                loaderEventInfo.taskType = ((Integer) hashMap.get("taskType")).intValue();
                AVMDLLog.d(TAG, "[debugUI] eventMap contains taskType" + loaderEventInfo.taskType);
            }
            if (hashMap.containsKey("off")) {
                loaderEventInfo.off = ((Long) hashMap.get("off")).longValue();
                AVMDLLog.d(TAG, "[debugUI] eventMap contains off" + loaderEventInfo.off);
            }
            if (hashMap.containsKey("endOff")) {
                loaderEventInfo.endOff = ((Long) hashMap.get("endOff")).longValue();
                AVMDLLog.d(TAG, "[debugUI] eventMap contains endOff" + loaderEventInfo.endOff);
            }
            if (hashMap.containsKey("fileHash")) {
                loaderEventInfo.fileHash = String.valueOf(hashMap.get("fileHash"));
                AVMDLLog.d(TAG, "[debugUI] eventMap contains fileHash" + loaderEventInfo.fileHash);
            }
            if (hashMap.containsKey("bytesLoaded")) {
                loaderEventInfo.bytesLoaded = ((Long) hashMap.get("bytesLoaded")).longValue();
                AVMDLLog.d(TAG, "[debugUI] eventMap contains bytesLoaded" + loaderEventInfo.bytesLoaded);
            }
            if (hashMap.containsKey("headers")) {
                str = String.valueOf(hashMap.get("headers"));
                AVMDLLog.d(TAG, "[debugUI] eventMap contains headers" + str);
            } else {
                str = "";
            }
            if (str != "") {
                for (String str2 : str.split("\r\n")) {
                    String[] split = str2.split(":");
                    loaderEventInfo.mHeaders.put(split[0], split[1]);
                }
            } else {
                AVMDLLog.d(TAG, "[debugUI] what" + loaderEventInfo.what);
                AVMDLLog.d(TAG, "[debugUI]no headers");
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Message obtainMessage = this.mLogHandler.obtainMessage();
        obtainMessage.what = loaderEventInfo.what;
        obtainMessage.obj = loaderEventInfo;
        obtainMessage.sendToTarget();
    }

    public void onLogInfo(int i4, int i5, int i6, String str) {
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        if (!isNotifyInfo(i4)) {
            AVMDLLog.d("ttmn", i4 + " is not a notify ");
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i4;
        aVMDLDataLoaderNotifyInfo.code = i5;
        aVMDLDataLoaderNotifyInfo.parameter = i6;
        aVMDLDataLoaderNotifyInfo.logInfo = str;
        Message obtainMessage = this.mLogHandler.obtainMessage();
        obtainMessage.what = i4;
        obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage.sendToTarget();
    }

    public void onNotify(int i4, long j4, int i5) {
        if (this.mState != 1 || this.mHandler == null) {
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i4;
        aVMDLDataLoaderNotifyInfo.parameter = j4;
        aVMDLDataLoaderNotifyInfo.code = i5;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage.what = i4;
        obtainMessage.sendToTarget();
    }

    public void p2pPredown(String str) {
        if (this.mState != 1) {
            return;
        }
        if (this.mConfigure.mLoaderType <= 0) {
            AVMDLLog.d(TAG, "not enable p2p,not need p2ppredown, configure loader type" + this.mConfigure.mLoaderType);
            return;
        }
        String encodeUrl = encodeUrl(str);
        if (TextUtils.isEmpty(encodeUrl)) {
            AVMDLLog.d(TAG, "encode url null, not need p2p predown");
            return;
        }
        AVMDLLog.d(TAG, "p2p predown start");
        this.mReadLock.lock();
        try {
            try {
                _p2pPredown(this.mHandle, encodeUrl);
            } catch (UnsatisfiedLinkError e4) {
                AVMDLLog.d(TAG, "p2p predown exception" + e4.toString());
            }
            AVMDLLog.d(TAG, "p2p predown end");
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void preConnectByHost(String str, int i4) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _preConnectByHost(this.mHandle, str, i4);
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadGroupResource(String str, String str2, int i4, int i5) {
        if (this.mState != 1 || TextUtils.isEmpty(str2) || i5 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _preloadGroupResource(j4, str, str2, i4, i5);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadResource(String str, int i4) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i4 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _preloadResource(j4, str, i4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void removeFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        _removeCacheFile(j4, str);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void resumeFileWriteIO() {
        if (this.mState != 1) {
            return;
        }
        AVMDLLog.d(TAG, "resume file write io: ");
        this.mWriteLock.lock();
        try {
            if (this.mConfigure.mMaxFileMemCacheSize > 0) {
                _resumeFileWriteIO(this.mHandle);
                this.mConfigure.mMaxFileMemCacheSize = 0;
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void setBackUpIp(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null));
    }

    public void setConfigure(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                this.mConfigure = aVMDLDataLoaderConfigure;
                aVMDLDataLoaderConfigure.ParseJsonConfig();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setEventListener(LoaderListener loaderListener) {
        this.mWriteLock.lock();
        try {
            this.mEventListener = loaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setInt64ValueByStrKey(int i4, String str, long j4) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j5 = this.mHandle;
                if (j5 != 0) {
                    _setInt64ValueByStrKey(j5, i4, str, j4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setIntValue(int i4, int i5) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _setIntValue(j4, i4, i5);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        try {
            this.mVodListener = aVMDLDataLoaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setLongValue(int i4, long j4) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j5 = this.mHandle;
                if (j5 != 0) {
                    _setInt64Value(j5, i4, j4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setStartCompleteListener(AVMDLStartCompleteListener aVMDLStartCompleteListener) {
        this.mStartCompleteListener = aVMDLStartCompleteListener;
    }

    public void setStringValue(int i4, String str) {
        if (!TextUtils.isEmpty(str) && this.mState == 1) {
            this.mWriteLock.lock();
            try {
                try {
                    long j4 = this.mHandle;
                    if (j4 != 0) {
                        _setStringValue(j4, i4, str);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public int start() {
        if (this.mState == 1) {
            return 0;
        }
        initNativeHandle();
        new xv(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.2
            @Override // java.lang.Runnable
            public void run() {
                AVMDLDataLoader.this.startInternal();
            }
        }, TAG).start();
        return 0;
    }

    public void stop() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _stop(j4);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void suspendDownload(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _suspendedDownload(j4, str);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void tryToClearCachesByUsedTime(long j4) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            long j5 = this.mHandle;
            if (j5 != 0) {
                _clearCachesByUsedTime(j5, j4);
            }
        } catch (UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void updateDNSInfo(String str, String str2, long j4, String str3, int i4) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _updateDNSInfo(this.mHandle, str, str2, j4, str3, i4);
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(int i4, AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        if (i4 == 107) {
            try {
                this.mLiveListener = aVMDLDataLoaderListener;
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    private boolean postMessage(LoaderListener loaderListener, Message message) {
        Object obj;
        LoaderEventInfo loaderEventInfo;
        if (loaderListener != null && (obj = message.obj) != null && (loaderEventInfo = (LoaderEventInfo) obj) != null) {
            int i4 = message.what;
            if (i4 == 71) {
                loaderListener.onLoaderTaskStart(loaderEventInfo);
                AVMDLLog.d("ttmn", "receive eventLog KeyIsLoaderEventStart");
            } else if (i4 == 72) {
                loaderListener.onLoaderTaskCancel(loaderEventInfo);
                AVMDLLog.d("ttmn", "receive eventLog KeyIsLoaderEventCancel");
            } else if (i4 == 73) {
                loaderListener.onLoaderTaskCompleted(loaderEventInfo);
                AVMDLLog.d("ttmn", "receive eventLog KeyIsLoaderEventCompleted");
            } else {
                AVMDLLog.d("ttmn", "receive eventLog fail");
            }
        }
        return true;
    }

    public String getStringCacheInfo(String str, String str2) {
        String str3 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    str3 = _getStringValueByStrStr(j4, str, str2, 101);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
            return str3;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void preloadResource(String str, int i4, int i5) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i5 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _preloadResourceWithOffset(j4, str, i4, i5);
                }
            } catch (UnsatisfiedLinkError e4) {
                e4.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public long getCacheSize(String str) {
        long j4 = -1;
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mReadLock.lock();
            try {
                try {
                    long j5 = this.mHandle;
                    if (j5 != 0) {
                        j4 = _getLongValueByStr(j5, str, 103);
                    }
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                }
                return j4;
            } finally {
                this.mReadLock.unlock();
            }
        }
        return -1L;
    }

    public static synchronized int init(boolean z3, boolean z4) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z3;
            if (!mIsLibraryLoaded) {
                try {
                    System.loadLibrary("avmdl_lite");
                    mIsLibraryLoaded = true;
                } catch (UnsatisfiedLinkError e4) {
                    Log.e("ttmn", "Can't load avmdl library: " + e4);
                } catch (Throwable th) {
                    Log.e("ttmn", "other exception when loading avmdl library: " + th);
                }
                if (z4) {
                    Log.e("ttmn", "try to load pcdn lib");
                    try {
                        System.loadLibrary("avmdlp2p");
                    } catch (UnsatisfiedLinkError e5) {
                        Log.e("ttmn", "Can't load avmdlp2p library: " + e5);
                    }
                }
                tryLoadTTNetLoaderPlugin();
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }

    public void onLogInfo(int i4, int i5, String str) {
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i4;
        aVMDLDataLoaderNotifyInfo.code = i5;
        aVMDLDataLoaderNotifyInfo.logInfo = str;
        if (isNotifyInfo(i4)) {
            AVMDLLog.d("ttmn", i4 + " is a notify.");
            return;
        }
        if (i4 != 4 && i4 != 14) {
            aVMDLDataLoaderNotifyInfo.logToJson();
        }
        AVMDLLog.d("ttmn", "onLogInfo what:" + aVMDLDataLoaderNotifyInfo.what);
        boolean z3 = false;
        if (i4 != 0) {
            if (i4 == 1) {
                aVMDLDataLoaderNotifyInfo.logType = "own_vdp";
            } else if (i4 == 10) {
                aVMDLDataLoaderNotifyInfo.logType = "own_live_loader";
            } else if (i4 == 11) {
                aVMDLDataLoaderNotifyInfo.logType = "own_live_loader_sample";
            } else if (i4 == 19) {
                aVMDLDataLoaderNotifyInfo.logType = "mdl_downloader_log";
            } else if (i4 == 70) {
                aVMDLDataLoaderNotifyInfo.logType = "heart_beat";
                z3 = true;
            } else if (i4 == 700) {
                try {
                    if (!TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
                        String[] split = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                        if (split.length >= 4) {
                            aVMDLDataLoaderNotifyInfo.logType = "unknown";
                            if (split[0].equals("0")) {
                                aVMDLDataLoaderNotifyInfo.logType = "video";
                            } else if (split[0].equals("1")) {
                                aVMDLDataLoaderNotifyInfo.logType = "audio";
                            }
                            aVMDLDataLoaderNotifyInfo.logInfo = split[1];
                            try {
                                aVMDLDataLoaderNotifyInfo.code = Integer.parseInt(split[2]);
                            } catch (NumberFormatException unused) {
                            }
                            try {
                                aVMDLDataLoaderNotifyInfo.parameter = Integer.parseInt(split[3]);
                            } catch (NumberFormatException unused2) {
                            }
                            String str2 = split[4];
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("tcpRtt", str2);
                            jSONObject.put("tcpInfo", jSONObject2);
                            aVMDLDataLoaderNotifyInfo.logExtraJsonStr = jSONObject.toString();
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException | Exception unused3) {
                }
            } else if (i4 == 702) {
                aVMDLDataLoaderNotifyInfo.logType = "speed_info";
            } else if (i4 != 703) {
                switch (i4) {
                    case 13:
                        aVMDLDataLoaderNotifyInfo.logType = "pcdn_task";
                        break;
                    case 14:
                        aVMDLDataLoaderNotifyInfo.logType = "alog_info";
                        break;
                    case 15:
                        aVMDLDataLoaderNotifyInfo.logInfo = "mdl_dns_log";
                        break;
                    case 16:
                        break;
                    default:
                        switch (i4) {
                            case 1000:
                                aVMDLDataLoaderNotifyInfo.logType = "bb_proxy";
                                break;
                            case 1001:
                                aVMDLDataLoaderNotifyInfo.logType = "bb_protocol";
                                break;
                            case 1002:
                                aVMDLDataLoaderNotifyInfo.logType = "bb_preload";
                                break;
                            case 1003:
                                aVMDLDataLoaderNotifyInfo.logType = "bb_task";
                                break;
                        }
                }
            } else {
                aVMDLDataLoaderNotifyInfo.logType = "global_speed";
            }
            if (z3 || aVMDLDataLoaderNotifyInfo.jsonLog != null) {
                Message obtainMessage = this.mLogHandler.obtainMessage();
                obtainMessage.what = i4;
                obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
                obtainMessage.sendToTarget();
            }
            return;
        }
        aVMDLDataLoaderNotifyInfo.logType = "media_loader";
        z3 = true;
        if (z3) {
        }
        Message obtainMessage2 = this.mLogHandler.obtainMessage();
        obtainMessage2.what = i4;
        obtainMessage2.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage2.sendToTarget();
    }

    public static synchronized int init(boolean z3, boolean z4, boolean z5) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z3;
            if (!mIsLibraryLoaded) {
                if (z5) {
                    try {
                        System.loadLibrary("avmdlv2");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e4) {
                        Log.e("ttmn", "load avmdlv2 failed: " + e4);
                    }
                }
                if (!mIsLibraryLoaded) {
                    try {
                        System.loadLibrary("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e5) {
                        Log.e("ttmn", "Can't load avmdl library: " + e5);
                    } catch (Throwable th) {
                        Log.e("ttmn", "other exception when loading avmdl library: " + th);
                    }
                    if (z4) {
                        Log.e("ttmn", "try to load pcdn lib");
                        try {
                            System.loadLibrary("avmdlp2p");
                        } catch (UnsatisfiedLinkError e6) {
                            Log.e("ttmn", "Can't load avmdlp2p library: " + e6);
                        } catch (Throwable th2) {
                            Log.e("ttmn", "other exception when loading avmdl library: " + th2);
                        }
                    }
                    tryLoadTTNetLoaderPlugin();
                }
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }
}
