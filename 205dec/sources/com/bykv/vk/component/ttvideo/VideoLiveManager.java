package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.LogBundle;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper;
import com.bykv.vk.component.ttvideo.model.LiveInfoSource;
import com.bykv.vk.component.ttvideo.model.LiveStreamInfo;
import com.bykv.vk.component.ttvideo.model.LiveURL;
import com.bykv.vk.component.ttvideo.network.DnsHelper;
import com.bykv.vk.component.ttvideo.network.LiveDataFetcher;
import com.bykv.vk.component.ttvideo.player.Keep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.playerwrapper.PlayerSetting;
import com.bykv.vk.component.ttvideo.retry.RetryProcessor;
import com.bykv.vk.component.ttvideo.utils.LiveThreadPool;
import com.bykv.vk.component.ttvideo.utils.LiveUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.gd.sr.sr;
import com.bytedance.sdk.component.gd.sr.xv;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class VideoLiveManager implements ILivePlayer {
    private static final int AUDIOSTREAM = 1;
    private static final int AV_NO_SYNC_THRESHOLD = 10000;
    private static final int BITRATE_ABNORNAL = 1;
    private static final int BITRATE_NORMAL = 0;
    private static final int BOTHSTREAM = 2;
    private static final int CHECK_SEI_INTERVAL = 3000;
    private static final int DEFAULT_RTC_FALLBACK_THRESHOLD = 5000;
    private static final int DEFAULT_RTC_MIN_JITTER_BUFFER = 300;
    private static final String HTTP_FLV_ABR_PREFIX = "mem://llash/";
    private static final int INIT_MTU = 1200;
    public static final int KeyIsGetSeiDelay = 100;
    public static final int KeyIsGetStreamMaxBitrate = 0;
    private static final int LIVE_ABR_CHECK_DEFAULT_INTERVAL = 1000;
    private static final int MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE = 501;
    private static final int MSG_SEI_CHECK = 110;
    private static final int NOTIFY_ALL_SEI_THRESHOLD = 1000;
    private static final String RTC_LOG_PREFIX = "rtc_log_level";
    private static final int RTC_VENDER_TYPE_ALIBABA = 1;
    private static final int RTC_VENDER_TYPE_BYTE = 0;
    private static final int RTC_VENDER_TYPE_OTHERS = 3;
    private static final int RTC_VENDER_TYPE_TECENT = 2;
    private static final String SEI_PREFIX = "JSON";
    private static final int STALL_RECOVER_FROM_BUFFERINGEND = 1;
    private static final int STALL_RECOVER_FROM_RETRY = 2;
    private static final int STALl_NO_RECOVER = 0;
    private static final String TAG = "VideoLiveManager";
    public static final int TEX_LIVE = 1;
    public static final int TEX_VOD = 0;
    private static final int VIDEOSTREAM = 0;
    private static int mAudioRenderStallThreshold = 200;
    private static int mDecoderStallThreshold = 600;
    private static int mDemuxerStallThreshold = 900;
    private static int mFastOpenDuration = -1;
    private static boolean mIsSettingsUpdate = false;
    private static JSONObject mSettingsInfo = null;
    private static int mVideoRenderStallThreshold = 500;
    private int mABRBufferThreshold;
    private int mABRDisableAlgorithm;
    private int mABRMethod;
    private long mALogWriteAddr;
    private int mAVNoSyncThreshold;
    private int mAVPHAudioMaxDuration;
    private int mAVPHAudioProbesize;
    private int mAVPHAutoExit;
    private int mAVPHDnsParseEnable;
    private int mAVPHDnsTimeout;
    private int mAVPHEnableAutoReopen;
    private int mAVPHMaxAVDiff;
    private int mAVPHOpenVideoFirst;
    private int mAVPHReadErrorExit;
    private int mAVPHReadRetryCount;
    private int mAVPHVideoDiffThreshold;
    private int mAVPHVideoMaxDuration;
    private int mAVPHVideoProbesize;
    private String mAbrStrategy;
    private long mAudioLastRenderTime;
    private String mAudioOnly;
    private int mAudioTimescaleEnable;
    private float mAudioVolumeBalancePredelay;
    private float mAudioVolumeBalancePregain;
    private float mAudioVolumeBalanceRatio;
    private float mAudioVolumeBalanceThreshold;
    private int mBufferDataSeconds;
    private int mBufferTimeout;
    private int mByteVC1DecoderType;
    private int mCacheFileEnable;
    private String mCacheFileKey;
    private String mCacheFilePath;
    private boolean mCancelSDKDNSFailRetry;
    private float mCatchSpeed;
    private String mCdnAbrResolution;
    private String mCdnSessionPath;
    private int mCheckBufferingEndAdvanceEnable;
    private int mCheckBufferingEndIgnoreVideo;
    public boolean mCheckSupportSR;
    private boolean mCmafEnable;
    private final Context mContext;
    private String mCurrentIP;
    private String mCurrentPlayURL;
    private int mCurrentRetryCount;
    private int mDefaultCodecId;
    private int mDefaultResBitrate;
    private final DnsHelper mDnsParser;
    private int mEnableAbrStallDegradeImmediately;
    private int mEnableAudioVolumeBalance;
    private String mEnableAvLines;
    private int mEnableByteVC1HardwareDecode;
    private int mEnableCacheSei;
    private int mEnableCheckDropAudio;
    private int mEnableCheckFrame;
    private int mEnableCheckPacketCorrupt;
    private int mEnableCheckSEI;
    private int mEnableClosePlayRetry;
    private int mEnableCmafFastMode;
    private int mEnableCmafOptimizeRetry;
    private int mEnableDTSCheck;
    private int mEnableDecodeMultiSei;
    private int mEnableDecodeSeiOnce;
    private int mEnableDecoderStall;
    private int mEnableDemuxerStall;
    private boolean mEnableDns;
    private boolean mEnableDnsOptimizer;
    private int mEnableDroppingDTSRollFrame;
    private int mEnableFastOpenStream;
    private int mEnableFlvABR;
    private int mEnableFreeFlow;
    private int mEnableH264HardwareDecode;
    private int mEnableHttpPrepare;
    private int mEnableHttpkDegrade;
    private int mEnableHurryFlag;
    private int mEnableLLASHFastOpen;
    private int mEnableLiveAbrCheckEnhance;
    private int mEnableLiveIOP2P;
    private int mEnableLiveIOPlay;
    private int mEnableLowLatencyFLV;
    private int mEnableMediaCodecASYNCInit;
    private int mEnableNTP;
    private int mEnableNTPTask;
    private int mEnableNotifySeiImmediatelyBeforeFirstFrame;
    private int mEnableOpenLiveIO;
    private int mEnableOpenMDL;
    private int mEnableOptimizeBackup;
    private boolean mEnableOriginResolution;
    private int mEnableP2pUp;
    private int mEnablePreventDTSBack;
    private boolean mEnableQuicCertVerify;
    private int mEnableQuicDegrade;
    private int mEnableQuicMTUDiscovery;
    public int mEnableRadioLiveDisableRender;
    private int mEnableRenderStall;
    private int mEnableReportSessionStop;
    private boolean mEnableResolutionAutoDegrade;
    private int mEnableRtcPlay;
    private boolean mEnableSaveSCFG;
    private boolean mEnableSeiCheck;
    private int mEnableSharp;
    public int mEnableSharpen;
    private int mEnableSkipFindUnnecessaryStream;
    private int mEnableSkipFlvNullTag;
    private int mEnableSplitStream;
    private int mEnableStallCounter;
    private int mEnableStallRetryInstantly;
    private boolean mEnableSwitchMainAndBackupUrl;
    private int mEnableTcpFastOpen;
    private int mEnableTextureRender;
    private int mEnableTextureSR;
    private int mEnableUploadSei;
    private boolean mEnableUploadSessionSeries;
    private int mEnableUseLiveThreadPool;
    private int mEnableVideoMpdRefresh;
    private int mEnhancementType;
    private boolean mEnterStallRetryInstantly;
    private ExecutorService mExecutor;
    private LiveDataFetcher mFetcher;
    private int mForceDecodeMsGaps;
    private int mForceDecodeSwitch;
    private boolean mForceHttpDns;
    private int mForceRenderMsGaps;
    private long mFrameDroppingDTSMaxDiff;
    private Object mFrameMetaDataListener;
    private long mFrameTerminatedDTS;
    private int mFramesDrop;
    private long mGetSeiCurrentTime;
    private int mGopDuration;
    private int mHardwareDecodeEnable;
    private int mHardwareRTCDecodeEnable;
    private boolean mHasAbrInfo;
    private boolean mHasRetry;
    private boolean mHasSeiInfo;
    private int mHlsLiveStartIndex;
    private String mHttpDNSServerHost;
    private int mHurryTime;
    private int mHurryType;
    private MyInvocationHandler mInvocationHandler;
    private int mIsAlwaysDoAVSync;
    private boolean mIsCacheHasComplete;
    private int mIsInMainLooper;
    private boolean mIsLiveIOProtoRegister;
    private boolean mIsLocalURL;
    private boolean mIsMdlProtoRegister;
    private boolean mIsPlayWithLiveIO;
    private boolean mIsPlayWithMdl;
    private boolean mIsRequestCanceled;
    private boolean mIsRetrying;
    private boolean mIsStalling;
    private long mLatestAudioPacketDTS;
    private int mLayoutType;
    private String mLevel;
    private final ILiveListener mListener;
    private int mLiveABRCheckInterval;
    private int mLiveIOABGroupID;
    private LivePlayerState mLivePlayerState;
    private String mLocalURL;
    private LiveLoggerService mLogService;
    private boolean mLooping;
    private JSONObject mLowLatencyFLVStrategy;
    private int mMaxCacheSeconds;
    private int mMaxFileCacheSize;
    private int mMaxTextureHeight;
    private int mMaxTextureWidth;
    public boolean mMediaSupportSR;
    private boolean mMediaSupportSharpen;
    private String mMoudleIDToB;
    private final Handler mMyHandler;
    private final INetworkClient mNetworkClient;
    private int mNetworkTimeout;
    private int mNoSyncReportMinDuration;
    private int mNoSyncReportReportThres;
    private List<String> mNodeOptimizeResults;
    private int mOpenCheckSideData;
    private MediaPlayer mPlayer;
    private int mPlayerCache;
    private int mPlayerDegradeMode;
    private final PlayerSetting mPlayerSetting;
    private final int mPlayerType;
    private PlayerState mPrepareState;
    private int mQuicConfigOptimize;
    private boolean mQuicEnable;
    private int mQuicFixProcessTimer;
    private int mQuicFixStreamFinAndRst;
    private int mQuicFixWillingAndAbleToWrite;
    private int mQuicInitMTU;
    private int mQuicInitRtt;
    private int mQuicMaxAckDelay;
    private int mQuicMaxCryptoRetransmissionTimeMs;
    private int mQuicMaxCryptoRetransmissions;
    private int mQuicMaxRetransmissionTimeMs;
    private int mQuicMaxRetransmissions;
    private int mQuicMinReceivedBeforeAckDecimation;
    private int mQuicPadHello;
    private boolean mQuicPull;
    private int mQuicReadBlockMode;
    private int mQuicReadBlockTimeout;
    private int mQuicTimerVersion;
    private int mQuicVersion;
    private boolean mRedoDns;
    private String mReliable;
    public boolean mRenderStartEntered;
    public long mRenderStartNotifyTimeStamp;
    private int mRenderType;
    private String mResolution;
    private boolean mResolutionDisableSR;
    private int mResolutionIndex;
    private final RetryProcessor mRetryProcessor;
    private long mRetryStartTime;
    private int mRtcEarlyInitRender;
    private int mRtcEnableDtls;
    private int mRtcEnableRtcUninitLockFree;
    private int mRtcEnableSDKDns;
    private int mRtcFallbackThreshold;
    private int mRtcMaxJitterBuffer;
    private int mRtcMaxRetryCount;
    private int mRtcMinJitterBuffer;
    private int mRtcPlayFallBack;
    private int mRtcPlayLogInterval;
    private int mRtcSupportMiniSdp;
    private int mScaleType;
    private long mSeiDiffThres;
    private String mSessionId;
    private int mSessionNum;
    private int mSessionReceiveWindow;
    private long mSessionRenderStartTime;
    private long mSessionStartTime;
    private final ILiveSettingBundle mSettingsBundle;
    private float mSharpenAmount;
    private float mSharpenEdgeWeightGamma;
    private int mSharpenMaxHeight;
    private int mSharpenMaxWidth;
    private int mSharpenMode;
    private float mSharpenOverRatio;
    private int mSharpenPowerLevel;
    private int mSharpenSceneMode;
    private JSONObject mSharpenSdkParams;
    private boolean mShowedFirstFrame;
    private float mSlowPlaySpeed;
    private int mSlowPlayTime;
    private int mStallCount;
    private int mStallCountThresOfResolutionDegrade;
    private Handler mStallCounterHandler;
    private int mStallCounterInterval;
    private volatile boolean mStallCounterIsRunning;
    private final Object mStallCounterLock;
    private HandlerThread mStallCounterThread;
    public long mStallRetryTimeIntervalManager;
    private long mStallStartTime;
    private long mStallTotalTime;
    private int mStartDirectAfterPrepared;
    private long mStartPlayBufferThres;
    private String mStreamFormat;
    private int mStreamReceiveWindow;
    private String mSuggestProtocol;
    private boolean mSupportBackupIp;
    public int mSupportSRScene;
    private int mSupportSharpenScene;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private int mSwitchToB;
    private long mTargetOriginBitRate;
    private int mTestAction;
    private String mTextureRenderErrorMsg;
    private boolean mTextureRenderFirstFrame;
    private String mTextureSRBinPath;
    private String mTextureSRDspModuleName;
    public int mTextureSRMode;
    private String mTextureSROclModuleName;
    private String mTransportProtocol;
    private int mTslMinTimeShit;
    private int mTslTimeShift;
    private int mURLAbility;
    private String mURLHost;
    private String mURLProtocol;
    private final LiveInfoSource mURLSource;
    private int mUrlSettingMethod;
    private int mUseExternalDir;
    private boolean mUsePlayerRenderStart;
    private boolean mUserSwitchResoultion;
    private String mUuid;
    private long mVideoLastRenderTime;
    private String mVideoOnly;
    private final VideoStallCountTask mVideoStallCountTask;

    @Keep
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class Builder {
        final Context mContext;
        boolean mEnableResolutionAutoDegrade;
        boolean mEnableSwitchMainAndBackupUrl;
        boolean mForceHttpDns;
        boolean mForceTTNetHttpDns;
        ILiveListener mListener;
        public ExecutorService mLiveThreadPool;
        INetworkClient mNetworkClient;
        int mPlayerType;
        String mProjectKey;
        public long mRTCUploadLogInterval;
        String mResolution;
        int mRetryTimeout;
        public long mSeiCheckTimeOut;
        ILiveSettingBundle mSettingsBundle;
        public long mStallRetryTimeInterval;
        public long mUploadLogInterval;
        String mVideoFormat;

        public VideoLiveManager build() {
            if (this.mContext != null) {
                if (this.mListener != null) {
                    if (this.mNetworkClient != null) {
                        return new VideoLiveManager(this);
                    }
                    throw new IllegalArgumentException("mNetworkClient should not be null");
                }
                throw new IllegalArgumentException("mListener should not be null");
            }
            throw new IllegalArgumentException("mContext should not be null");
        }

        public Builder setCustomThreadPool(ExecutorService executorService) {
            MyLog.i(VideoLiveManager.TAG, "setCustomThreadPool: " + executorService);
            this.mLiveThreadPool = executorService;
            return this;
        }

        public Builder setEnableResolutionAutoDegrade(boolean z3) {
            this.mEnableResolutionAutoDegrade = z3;
            return this;
        }

        public Builder setEnableSwitchMainAndBackUpURL(boolean z3) {
            this.mEnableSwitchMainAndBackupUrl = z3;
            return this;
        }

        public Builder setForceHttpDns(boolean z3) {
            this.mForceHttpDns = z3;
            return this;
        }

        public Builder setForceTTNetHttpDns(boolean z3) {
            this.mForceTTNetHttpDns = z3;
            return this;
        }

        public Builder setListener(ILiveListener iLiveListener) {
            this.mListener = iLiveListener;
            return this;
        }

        public Builder setNetworkClient(INetworkClient iNetworkClient) {
            this.mNetworkClient = iNetworkClient;
            return this;
        }

        public Builder setPlayerType(int i4) {
            this.mPlayerType = i4;
            return this;
        }

        public Builder setProjectKey(String str) {
            this.mProjectKey = str;
            return this;
        }

        public Builder setResolution(String str) {
            this.mResolution = str;
            return this;
        }

        public Builder setRetryTimeout(int i4) {
            this.mRetryTimeout = i4;
            return this;
        }

        public Builder setSeiCheckTimeOut(long j4) {
            this.mSeiCheckTimeOut = j4;
            return this;
        }

        public Builder setSettingsBundle(ILiveSettingBundle iLiveSettingBundle) {
            this.mSettingsBundle = iLiveSettingBundle;
            return this;
        }

        public Builder setStallRetryInterval(long j4) {
            this.mStallRetryTimeInterval = j4;
            return this;
        }

        public Builder setVideoFormat(String str) {
            this.mVideoFormat = str;
            return this;
        }

        private Builder(Context context) {
            this.mForceHttpDns = false;
            this.mForceTTNetHttpDns = false;
            this.mRetryTimeout = 60000;
            this.mPlayerType = 1;
            this.mResolution = LiveConfigKey.ORIGIN;
            this.mVideoFormat = LiveConfigKey.FLV;
            this.mEnableResolutionAutoDegrade = false;
            this.mEnableSwitchMainAndBackupUrl = true;
            this.mStallRetryTimeInterval = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.mUploadLogInterval = 60000L;
            this.mRTCUploadLogInterval = 5000L;
            this.mSeiCheckTimeOut = 8000L;
            this.mLiveThreadPool = null;
            this.mContext = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public enum LivePlayerState {
        IDLE,
        PLAYED,
        PAUSED,
        STOPPED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class MyCompletionListener implements MediaPlayer.OnCompletionListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyCompletionListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MyLog.d(VideoLiveManager.TAG, "player complete");
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onCompletion");
            videoLiveManager.mListener.onCompletion();
            videoLiveManager.mLogService.onPrepare(LiveError.STREAM_DRYUP);
            videoLiveManager.mSupportBackupIp = false;
            if (videoLiveManager.mIsLocalURL) {
                return;
            }
            if (videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mCacheFileEnable == 1) {
                videoLiveManager.mListener.onCacheFileCompletion();
                videoLiveManager.mIsCacheHasComplete = true;
                if (!videoLiveManager.mLooping || TextUtils.isEmpty(videoLiveManager.mCacheFilePath)) {
                    return;
                }
                videoLiveManager.setLocalURL(videoLiveManager.mCacheFilePath);
                videoLiveManager.setLooping(true);
                videoLiveManager.parsePlayDNS(videoLiveManager.mCacheFilePath);
                return;
            }
            videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.STREAM_DRYUP, "live stream dry up, push stream may occur error", new HashMap()), videoLiveManager.mShowedFirstFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class MyErrorListener implements MediaPlayer.OnErrorListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyErrorListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
            MyLog.e(VideoLiveManager.TAG, "onError " + i4);
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager != null && videoLiveManager.mPlayer != null) {
                if (i4 != 0) {
                    videoLiveManager.mLogService.onPrepare(i4);
                }
                videoLiveManager.mListener.onError(new LiveError(i4, "player on error", null));
                if (videoLiveManager.mIsLocalURL) {
                    return true;
                }
                if (videoLiveManager.mEnableQuicDegrade == 1 && videoLiveManager.QuicDegrade(i4)) {
                    return true;
                }
                if (videoLiveManager.mEnableHttpkDegrade == 1 && videoLiveManager.HttpKDegradeHttp(i4)) {
                    return true;
                }
                if (!(videoLiveManager.mEnableRtcPlay == 1 && videoLiveManager.mRtcPlayFallBack == 0) && videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(i4)) {
                    return true;
                }
                if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(i4)) {
                    return true;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("internalCode", Integer.valueOf(i4));
                hashMap.put("internalExtra", Integer.valueOf(i5));
                hashMap.put("playerType", Integer.valueOf(mediaPlayer.getPlayerType()));
                videoLiveManager.mRetryProcessor.onError(new LiveError(-100003, "player on error", hashMap), videoLiveManager.mShowedFirstFrame);
            }
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static final class MyFetcherCompletionListener implements LiveDataFetcher.OnCompletionListener {
        private final String mLiveInfoAPI;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyFetcherCompletionListener(VideoLiveManager videoLiveManager, String str) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mLiveInfoAPI = str;
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onCompletion(final LiveStreamInfo liveStreamInfo) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    MyLog.d(VideoLiveManager.TAG, "get live data");
                    if (liveStreamInfo == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                        videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "live data is null", hashMap), videoLiveManager.mShowedFirstFrame);
                        return;
                    }
                    videoLiveManager.mURLSource.setStreamInfo(liveStreamInfo);
                    String playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
                    if (playURLForResolution == null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                        videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "play url is null", hashMap2), videoLiveManager.mShowedFirstFrame);
                        return;
                    }
                    videoLiveManager.parsePlayDNS(playURLForResolution);
                }
            });
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onError(final LiveError liveError) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    videoLiveManager.mRetryProcessor.onError(liveError, videoLiveManager.mShowedFirstFrame);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class MyInfoListener implements MediaPlayer.OnInfoListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyInfoListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager != null && videoLiveManager.mPlayer != null) {
                if (i4 != -268435437) {
                    if (i4 != 3) {
                        if (i4 == 251658247) {
                            Log.d(VideoLiveManager.TAG, "speed changed:" + i5);
                            LiveLoggerService liveLoggerService = videoLiveManager.mLogService;
                            liveLoggerService.mSpeedSwitchCount = liveLoggerService.mSpeedSwitchCount + 1;
                            StringBuilder sb = new StringBuilder();
                            LiveLoggerService liveLoggerService2 = videoLiveManager.mLogService;
                            sb.append(liveLoggerService2.mSpeedSwitchInfo);
                            sb.append(",");
                            double d4 = i5;
                            Double.isNaN(d4);
                            sb.append(d4 / 1000.0d);
                            sb.append(":");
                            sb.append(System.currentTimeMillis());
                            liveLoggerService2.mSpeedSwitchInfo = sb.toString();
                        } else if (i4 == 701) {
                            Log.d(VideoLiveManager.TAG, "MEDIA_INFO_BUFFERING_START");
                            VideoLiveManager.access$4408(videoLiveManager);
                            videoLiveManager.getLastRenderTime();
                            videoLiveManager.mIsStalling = true;
                            videoLiveManager.mListener.onStallStart();
                            if (!videoLiveManager.mShowedFirstFrame) {
                                videoLiveManager.mStallStartTime = System.currentTimeMillis();
                                videoLiveManager.mLogService.onStallStart(i5, false);
                            } else {
                                videoLiveManager.mLogService.onStallStart(i5, true);
                                if (videoLiveManager.mIsPlayWithMdl) {
                                    MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoBufferingStart, videoLiveManager.mLogService.mSessionId, i5);
                                }
                            }
                            if ((!videoLiveManager.mEnableResolutionAutoDegrade || videoLiveManager.mURLSource.getSourceType() != 2 || (!videoLiveManager.mAbrStrategy.equals(LiveConfigKey.RAD) || videoLiveManager.mStallCount < videoLiveManager.mStallCountThresOfResolutionDegrade ? !videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || !videoLiveManager.mResolution.equals("auto") || videoLiveManager.mEnableAbrStallDegradeImmediately != 1 || !videoLiveManager.abrDegradeResolution() : !videoLiveManager.degradeResolution())) && !videoLiveManager.mIsLocalURL) {
                                if (videoLiveManager.mEnableStallRetryInstantly == 1 && videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, -1L) == 0 && videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, -1L) == 0) {
                                    videoLiveManager.mEnterStallRetryInstantly = true;
                                }
                                videoLiveManager.mRetryProcessor.onStall(true, videoLiveManager.mEnterStallRetryInstantly);
                            }
                        } else if (i4 != 702) {
                            switch (i4) {
                                case MediaPlayer.MEDIA_INFO_VIDEO_DEMUX_STALL /* -268435442 */:
                                    Log.d(VideoLiveManager.TAG, "MEDIA_INFO_VIDEO_DEMUX_STALL");
                                    videoLiveManager.mLogService.onDemuxerStall(i5, VideoLiveManager.mDemuxerStallThreshold, true);
                                    break;
                                case MediaPlayer.MEDIA_INFO_AUDIO_DEMUX_STALL /* -268435441 */:
                                    Log.d(VideoLiveManager.TAG, "MEDIA_INFO_AUDIO_DEMUX_STALL");
                                    videoLiveManager.mLogService.onDemuxerStall(i5, VideoLiveManager.mDemuxerStallThreshold, false);
                                    break;
                                case MediaPlayer.MEDIA_INFO_VIDEO_DECODE_STALL /* -268435440 */:
                                    Log.d(VideoLiveManager.TAG, "MEDIA_INFO_VIDEO_DECODE_STALL");
                                    videoLiveManager.mLogService.onDecoderStall(i5, VideoLiveManager.mDecoderStallThreshold, true);
                                    break;
                                case MediaPlayer.MEDIA_INFO_AUDIO_DECODE_STALL /* -268435439 */:
                                    Log.d(VideoLiveManager.TAG, "MEDIA_INFO_AUDIO_DECODE_STALL");
                                    videoLiveManager.mLogService.onDecoderStall(i5, VideoLiveManager.mDecoderStallThreshold, false);
                                    break;
                                default:
                                    switch (i4) {
                                        case MediaPlayer.MEDIA_INFO_RTC_VIDEO_DECODE_STALL /* -268435424 */:
                                            Log.i(VideoLiveManager.TAG, "MEDIA_INFO_RTC_VIDEO_DECODE_STALL");
                                            videoLiveManager.mLogService.onRtcDecoderStall(i5, true);
                                            break;
                                        case MediaPlayer.MEDIA_INFO_RTC_AUDIO_DECODE_STALL /* -268435423 */:
                                            Log.i(VideoLiveManager.TAG, "MEDIA_INFO_RTC_AUDIO_DECODE_STALL");
                                            videoLiveManager.mLogService.onRtcDecoderStall(i5, false);
                                            break;
                                        default:
                                            switch (i4) {
                                                case MediaPlayer.MEDIA_INFO_AVOUTSYNC_START /* -268435407 */:
                                                    Log.d(VideoLiveManager.TAG, "av out sync start; time:" + System.currentTimeMillis() + " pts:" + i5);
                                                    videoLiveManager.mLogService.mNoSyncStartTime = System.currentTimeMillis();
                                                    videoLiveManager.mLogService.mNoSyncStartPts = (long) i5;
                                                    break;
                                                case MediaPlayer.MEDIA_INFO_AVOUTSYNC_END /* -268435406 */:
                                                    Log.d(VideoLiveManager.TAG, "av out sync end; time:" + System.currentTimeMillis() + " pts:" + i5);
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    long j4 = ((long) i5) - videoLiveManager.mLogService.mNoSyncStartPts;
                                                    long j5 = currentTimeMillis - videoLiveManager.mLogService.mNoSyncStartTime;
                                                    if (j4 > videoLiveManager.mNoSyncReportMinDuration) {
                                                        videoLiveManager.mLogService.mNoSyncCount++;
                                                        videoLiveManager.mLogService.mNoSyncPlayingCount++;
                                                        videoLiveManager.mLogService.mNoSyncTimeDuration += j5;
                                                        videoLiveManager.mLogService.mNoSyncPlayingTimeDuration += j5;
                                                        videoLiveManager.mLogService.mNoSyncPtsDuration += j4;
                                                        videoLiveManager.mLogService.mNoSyncPlayingPtsDuration += j4;
                                                        try {
                                                            str = new JSONObject().put("start_time", videoLiveManager.mLogService.mNoSyncStartTime).put("end_time", currentTimeMillis).put("start_pts", videoLiveManager.mLogService.mNoSyncStartPts).put("end_pts", i5).put("info", videoLiveManager.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVPTS_DIFF_LIST)).toString();
                                                        } catch (JSONException e4) {
                                                            e4.printStackTrace();
                                                            str = null;
                                                        }
                                                        if (videoLiveManager.mLogService.mNoSyncPlayingInfoStr.length() + str.length() < videoLiveManager.mLogService.mNoSyncPlayingInfoLen) {
                                                            videoLiveManager.mLogService.mNoSyncPlayingInfoStr = videoLiveManager.mLogService.mNoSyncPlayingInfoStr + str;
                                                        }
                                                        if (videoLiveManager.mLogService.mNoSyncInfoStr.length() + str.length() < videoLiveManager.mLogService.mNoSyncInfoLen) {
                                                            videoLiveManager.mLogService.mNoSyncInfoStr = videoLiveManager.mLogService.mNoSyncInfoStr + str;
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    switch (i4) {
                                                        case MediaPlayer.MEDIA_INFO_VIDEO_STREAM_BITRATE_CHANGED /* 251658249 */:
                                                            Log.d(VideoLiveManager.TAG, "now bitrate:" + i5);
                                                            int i6 = i5 / 1000;
                                                            if (videoLiveManager.mEnableResolutionAutoDegrade && videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && videoLiveManager.mURLSource.getSourceType() == 2) {
                                                                long j6 = i6;
                                                                String labelfromBitrate = videoLiveManager.mURLSource.getLabelfromBitrate(j6, videoLiveManager.mLevel);
                                                                if (TextUtils.isEmpty(labelfromBitrate) && videoLiveManager.mLogService.mBitRateAbnormalType == 1 && j6 == videoLiveManager.mTargetOriginBitRate / 1000) {
                                                                    labelfromBitrate = LiveConfigKey.ORIGIN;
                                                                }
                                                                String defaultResolution = videoLiveManager.mURLSource.getDefaultResolution();
                                                                if (defaultResolution != null && !defaultResolution.equals(labelfromBitrate)) {
                                                                    if (labelfromBitrate != null) {
                                                                        videoLiveManager.mLogService.mAbrSwitchInfo = "abr_" + videoLiveManager.mURLSource.getDefaultResolution() + "_to_" + labelfromBitrate;
                                                                        videoLiveManager.mURLSource.setDefaultResolution(labelfromBitrate);
                                                                        videoLiveManager.mLogService.mAutoUsingResolution = labelfromBitrate;
                                                                    } else {
                                                                        videoLiveManager.mLogService.mAbrSwitchInfo = "none";
                                                                    }
                                                                    videoLiveManager.mLogService.mAbrSwitchCount++;
                                                                    StringBuilder sb2 = new StringBuilder();
                                                                    LiveLoggerService liveLoggerService3 = videoLiveManager.mLogService;
                                                                    sb2.append(liveLoggerService3.mAbrSwitchCountInfo);
                                                                    sb2.append(",");
                                                                    sb2.append(i6);
                                                                    sb2.append(":");
                                                                    sb2.append(System.currentTimeMillis());
                                                                    liveLoggerService3.mAbrSwitchCountInfo = sb2.toString();
                                                                    videoLiveManager.mLogService.mCurDownloadSpeed = (videoLiveManager.mPlayer.getLongOption(63, 0L) * 8) / 1000;
                                                                    videoLiveManager.mLogService.mCurAudioBufferTime = videoLiveManager.mPlayer.getLongOption(73, 0L);
                                                                    videoLiveManager.mLogService.mCurVideoBufferTime = videoLiveManager.mPlayer.getLongOption(72, 0L);
                                                                    videoLiveManager.mLogService.mAbrSwitchCost = videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, -1L);
                                                                    videoLiveManager.mListener.onAbrSwitch(labelfromBitrate);
                                                                    Log.d(VideoLiveManager.TAG, "abr switch, bitrate:" + i6);
                                                                    videoLiveManager.mLogService.onAbrSwitch(j6, labelfromBitrate, true);
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case MediaPlayer.MEDIA_INFO_AUDIO_RENDER_STALL /* 251658250 */:
                                                            Log.d(VideoLiveManager.TAG, "MEDIA_INFO_AUDIO_RENDER_STALL");
                                                            videoLiveManager.mListener.onAudioRenderStall(i5);
                                                            videoLiveManager.mLogService.onRenderStall(i5, VideoLiveManager.mAudioRenderStallThreshold, false, true);
                                                            break;
                                                        case MediaPlayer.MEDIA_INFO_VIDEO_RENDER_STALL /* 251658251 */:
                                                            Log.d(VideoLiveManager.TAG, "MEDIA_INFO_VIDEO_RENDER_STALL");
                                                            videoLiveManager.mListener.onVideoRenderStall(i5);
                                                            videoLiveManager.mLogService.onRenderStall(i5, VideoLiveManager.mVideoRenderStallThreshold, true, true);
                                                            break;
                                                        case MediaPlayer.MEDIA_INFO_AUDIO_RENDER_START /* 251658252 */:
                                                            if (videoLiveManager.mPlayer != null) {
                                                                videoLiveManager.mLogService.onAudioRenderStart(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, -1L));
                                                                if (videoLiveManager.mPlayer.getIntOption(62, -1) == 0) {
                                                                    Log.d(VideoLiveManager.TAG, "pure audio");
                                                                    break;
                                                                }
                                                            } else {
                                                                return false;
                                                            }
                                                            break;
                                                        case MediaPlayer.MEDIA_INFO_SILENCE_DETECTED /* 251658253 */:
                                                            videoLiveManager.mLogService.mSilenceDetectedCount++;
                                                            break;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            Log.d(VideoLiveManager.TAG, "MEDIA_INFO_BUFFERING_END");
                            videoLiveManager.mIsStalling = false;
                            videoLiveManager.mListener.onStallEnd();
                            videoLiveManager.mRetryProcessor.onStall(false, videoLiveManager.mEnterStallRetryInstantly);
                            if (videoLiveManager.mShowedFirstFrame && videoLiveManager.mLogService.isStalling()) {
                                videoLiveManager.mLogService.onStallEnd(1);
                            } else if (!videoLiveManager.mShowedFirstFrame && videoLiveManager.mStallStartTime != 0) {
                                videoLiveManager.mStallTotalTime = System.currentTimeMillis() - videoLiveManager.mStallStartTime;
                            }
                            if (videoLiveManager.mIsPlayWithMdl) {
                                MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoBufferingEnd, videoLiveManager.mLogService.mSessionId, i5);
                            }
                        }
                    }
                    Log.d(VideoLiveManager.TAG, "MEDIA_INFO_VIDEO_RENDERING_START");
                    if (videoLiveManager.mEnableRtcPlay == 1 && videoLiveManager.mRtcPlayFallBack == 0 && videoLiveManager.mCurrentRetryCount > 0) {
                        videoLiveManager.mCurrentRetryCount = 0;
                    }
                    if (videoLiveManager.mPlayer == null) {
                        return false;
                    }
                    if (videoLiveManager.mPlayer != null) {
                        String stringOption = videoLiveManager.mPlayer.getStringOption(142);
                        Log.d(VideoLiveManager.TAG, "meta Data:" + stringOption);
                        videoLiveManager.mLogService.onUpdateMetaData(stringOption);
                    }
                    if (videoLiveManager.mPlayer != null) {
                        int intOption = videoLiveManager.mPlayer.getIntOption(141, -1);
                        if (intOption == 0) {
                            videoLiveManager.mLogService.setCodecType("h264");
                        } else if (intOption == 1) {
                            videoLiveManager.mLogService.setCodecType("bytevc1");
                        }
                    }
                    if (videoLiveManager.mPlayer != null) {
                        videoLiveManager.mLogService.mCodecName = videoLiveManager.convertCodecName(videoLiveManager.mPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, -1));
                    }
                    videoLiveManager.mLogService.onPrepare(0);
                    videoLiveManager.mIsStalling = false;
                    if (videoLiveManager.mPlayer != null) {
                        String stringOption2 = videoLiveManager.mPlayer.getStringOption(71);
                        if (videoLiveManager.mCurrentIP != null && videoLiveManager.mCurrentIP.startsWith("[") && stringOption2 != null && !stringOption2.startsWith("[")) {
                            stringOption2 = String.format("[%s]", stringOption2);
                        }
                        if (stringOption2 != null && !stringOption2.equals(videoLiveManager.mCurrentIP)) {
                            videoLiveManager.mLogService.setCdnIp(stringOption2, true);
                            videoLiveManager.mCurrentIP = stringOption2;
                        }
                    }
                    if (videoLiveManager.mEnableReportSessionStop == 1) {
                        videoLiveManager.mLogService.mSessionHasFirstFrame = true;
                        videoLiveManager.mLogService.mSessionVideoRenderStartTime = System.currentTimeMillis();
                        videoLiveManager.updateSessionFirstFrameInfo();
                    }
                    if (!videoLiveManager.mShowedFirstFrame) {
                        if (videoLiveManager.mEnableTextureRender != 1 || videoLiveManager.mUsePlayerRenderStart) {
                            MyLog.i(VideoLiveManager.TAG, "render start report first frame");
                            videoLiveManager.mLogService.onFirstFrame(0L, videoLiveManager.mStallTotalTime);
                            videoLiveManager.mLogService.start();
                            videoLiveManager.mShowedFirstFrame = true;
                            videoLiveManager.mListener.onFirstFrame(true);
                            videoLiveManager.setIntOption(75, 1);
                        }
                        if (videoLiveManager.mIsPlayWithMdl) {
                            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8015, videoLiveManager.mLogService.mSessionId, -1);
                        }
                        if (videoLiveManager.mLogService.isPreview() && videoLiveManager.mIsPlayWithMdl) {
                            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8016, videoLiveManager.mLogService.mSessionId, -1);
                        }
                    } else if (videoLiveManager.mRenderStartEntered && videoLiveManager.mIsRetrying) {
                        videoLiveManager.mListener.onFirstFrame(false);
                        if (videoLiveManager.mUserSwitchResoultion) {
                            videoLiveManager.mUserSwitchResoultion = false;
                        } else {
                            videoLiveManager.mLogService.onRetry(0);
                            if (videoLiveManager.mLogService.isStalling()) {
                                videoLiveManager.mListener.onStallEnd();
                                videoLiveManager.mLogService.onStallEnd(2);
                            }
                        }
                        if (videoLiveManager.mLogService.isInErrorRecovering()) {
                            videoLiveManager.mLogService.onErrorRecovered();
                        }
                        Log.d(VideoLiveManager.TAG, "render stall time (from retry to render new first frame again)");
                        videoLiveManager.onRenderStallForRetryStop();
                    }
                    videoLiveManager.mRenderStartEntered = true;
                    videoLiveManager.mIsRetrying = false;
                    videoLiveManager.mRetryProcessor.reset();
                } else {
                    Log.d(VideoLiveManager.TAG, "MEDIA_INFO_AUDIO_PTS_BACK");
                    videoLiveManager.mLogService.onPtsBack(i5, false);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class MyMediaLoaderListener implements MediaLoaderListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyMediaLoaderListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public long getInt64Value(int i4, long j4) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            return (videoLiveManager == null || videoLiveManager.mPlayer == null || i4 != 0) ? j4 : videoLiveManager.mLogService.getInt64Value(i4, j4);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onDataLoaderError(int i4, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderError(i4, str);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onLogInfo(int i4, String str, JSONObject jSONObject) {
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onNotify(int i4, long j4, long j5, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onSwitchLoaderType(int i4, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderSwitch(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class MyOnVideoSizeChangedListener implements MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyOnVideoSizeChangedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
            MyLog.i(VideoLiveManager.TAG, "onVideoSizeChanged, width: " + i4 + ", height: " + i5);
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null || videoLiveManager.mListener == null) {
                return;
            }
            videoLiveManager.mListener.onVideoSizeChanged(i4, i5);
            videoLiveManager.mLogService.onVideoSizeChanged(i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class MyPreparedListener implements MediaPlayer.OnPreparedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyPreparedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPrepareState != PlayerState.PREPARING || videoLiveManager.mPlayer == null) {
                return;
            }
            Log.d(VideoLiveManager.TAG, "preparing:" + videoLiveManager.mPrepareState);
            videoLiveManager.mLogService.onPrepareEnd();
            videoLiveManager.mPrepareState = PlayerState.PREPARED;
            if (videoLiveManager.mStartDirectAfterPrepared == 0) {
                Log.d(VideoLiveManager.TAG, "prepared:");
                videoLiveManager.mPlayer.start();
            }
            videoLiveManager.mListener.onPrepared();
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static class MyReleaseRunnable implements Runnable {
        private MediaPlayer mPlayer;

        public MyReleaseRunnable(MediaPlayer mediaPlayer) {
            this.mPlayer = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mPlayer != null) {
                try {
                    MyLog.i(VideoLiveManager.TAG, "MyReleaseRunnable release");
                    this.mPlayer.release();
                    this.mPlayer = null;
                } catch (Exception e4) {
                    MyLog.i(VideoLiveManager.TAG, e4.toString());
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static final class MyRetryListener implements RetryProcessor.RetryListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyRetryListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRTCFallBack() {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mIsRetrying = true;
            MyLog.i(VideoLiveManager.TAG, "onRTCFallBack");
            videoLiveManager._stopPlayer();
            if (videoLiveManager.mCurrentRetryCount < videoLiveManager.mRtcMaxRetryCount) {
                videoLiveManager.mCurrentRetryCount++;
            } else {
                videoLiveManager.mRtcPlayFallBack = 1;
                videoLiveManager.mLogService.mRtcPlayFallBack = 1;
                videoLiveManager.mURLSource.setRtcFallback(1);
                if (!videoLiveManager.mShowedFirstFrame) {
                    if (videoLiveManager.mRtcSupportMiniSdp == 1) {
                        videoLiveManager.mRtcSupportMiniSdp = 0;
                        videoLiveManager.mLogService.mEnableMiniSdp = 0;
                    }
                    videoLiveManager.mLogService.mFallbackType = 1;
                } else {
                    videoLiveManager.mLogService.mFallbackType = 2;
                }
            }
            String str = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                str = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                str = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            MyLog.i(VideoLiveManager.TAG, "onRTCFallBack url: " + str + ",mCurrentRetryCount:" + videoLiveManager.mCurrentRetryCount);
            videoLiveManager.mLogService.onSwitchURL(str);
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(str);
                return;
            }
            videoLiveManager._resetPlayer();
            videoLiveManager.parsePlayDNS(str);
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onReportOutToApplication(LiveError liveError) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onReportOutToApplication");
            videoLiveManager.mListener.onError(liveError);
            videoLiveManager.mFetcher.cancel();
            videoLiveManager.mRetryProcessor.reset();
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryNextPlayURL() {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onRetryNextPlayURL");
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.mIsRetrying = true;
            String str = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                str = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                str = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            videoLiveManager.mLogService.onSwitchURL(str);
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L));
            }
            videoLiveManager._stopPlayer();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(str);
                return;
            }
            videoLiveManager._resetPlayer();
            videoLiveManager.parsePlayDNS(str);
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryResetPlayer(boolean z3) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.getLastRenderTime();
            videoLiveManager.mIsRetrying = true;
            MyLog.i(VideoLiveManager.TAG, "onRetryResetPlayer " + z3);
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L));
            }
            videoLiveManager._stopPlayer();
            String str = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                if (videoLiveManager.mURLSource.getPlayLiveURL() != null) {
                    str = videoLiveManager.mURLSource.getPlayLiveURL().mainURL;
                }
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                str = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            MyLog.i(VideoLiveManager.TAG, "retry url: " + str);
            videoLiveManager.mLogService.onSwitchURL(str);
            boolean z4 = false;
            if (videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && videoLiveManager.mResolution.equals("auto")) {
                z4 = true;
            }
            videoLiveManager.mRetryStartTime = System.currentTimeMillis();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z4 || (z4 && !videoLiveManager.abrDegradeResolution())) {
                    videoLiveManager.parsePlayDNS(str);
                    return;
                }
                return;
            }
            videoLiveManager._resetPlayer();
            if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z4 || (z4 && !videoLiveManager.abrDegradeResolution())) {
                videoLiveManager.parsePlayDNS(str);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static class NamedThreadFactory implements ThreadFactory {
        private NamedThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            xv xvVar = new xv(runnable, VideoLiveManager.TAG);
            xvVar.setPriority(10);
            return xvVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class PlayCacheSyncRunner implements Runnable {
        static final long CacheThreadshold = 5000;
        static final long LongDelay = 500;
        static final long ShortDelay = 300;
        boolean mIsLiveIO;
        String mMdlTaskSessionId;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public PlayCacheSyncRunner(VideoLiveManager videoLiveManager, String str, boolean z3) {
            this.mIsLiveIO = false;
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mMdlTaskSessionId = str;
            this.mIsLiveIO = z3;
        }

        private long getPlayCache() {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return -1L;
            }
            long longOption = videoLiveManager.mPlayer.getLongOption(73, -1L);
            long longOption2 = videoLiveManager.mPlayer.getLongOption(72, -1L);
            if (longOption < 0 || longOption2 < 0) {
                if (longOption >= 0) {
                    return longOption;
                }
                if (longOption2 >= 0) {
                    return longOption2;
                }
                return -1L;
            }
            return Math.min(longOption, longOption2);
        }

        private void nextround(long j4) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThreadDelay(new PlayCacheSyncRunner(videoLiveManager, this.mMdlTaskSessionId, this.mIsLiveIO), j4);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || (str = this.mMdlTaskSessionId) == null || !str.equals(videoLiveManager.mSessionId) || this.mMdlTaskSessionId.isEmpty()) {
                return;
            }
            if (videoLiveManager.mLivePlayerState != LivePlayerState.PLAYED) {
                nextround(LongDelay);
                return;
            }
            long playCache = getPlayCache();
            if (playCache == -1) {
                nextround(LongDelay);
                return;
            }
            if (!this.mIsLiveIO) {
                MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoCurrentBuffer, videoLiveManager.mSessionId, (int) playCache);
            }
            MyLog.d(VideoLiveManager.TAG, "sync play cache:" + playCache + "(ms) with session id:" + videoLiveManager.mSessionId);
            if (playCache > 5000) {
                nextround(LongDelay);
            } else {
                nextround(ShortDelay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public enum PlayerState {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class VideoStallCountTask implements Runnable {
        private VideoStallCountTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (VideoLiveManager.this.mStallCounterLock) {
                if (VideoLiveManager.this.mStallCounterIsRunning && VideoLiveManager.this.mPlayer != null) {
                    long uptimeMillis = SystemClock.uptimeMillis() + VideoLiveManager.this.mStallCounterInterval;
                    long longOption = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200, 0L);
                    long longOption2 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 0L);
                    long longOption3 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 0L);
                    long longOption4 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500, 0L);
                    long longOption5 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 0L);
                    long longOption6 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, 0L);
                    long longOption7 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, 0L);
                    if ((longOption != 0 || longOption2 != 0 || longOption3 != 0 || longOption4 != 0 || longOption5 != 0 || longOption6 != 0 || longOption7 != 0) && VideoLiveManager.this.mLogService != null) {
                        VideoLiveManager.this.mLogService.onVideoStallCounter(longOption, longOption2, longOption3, longOption4, longOption5, longOption6, longOption7);
                    }
                    if (VideoLiveManager.this.mStallCounterHandler != null) {
                        VideoLiveManager.this.mStallCounterHandler.postAtTime(this, uptimeMillis);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HttpKDegradeHttp(int i4) {
        String replaceAll;
        String str = this.mCurrentPlayURL;
        if (str == null || !str.startsWith("httpk") || (replaceAll = this.mCurrentPlayURL.replaceAll("httpk", "http").replaceAll(":(\\d+)/", TTPathConst.sSeparator)) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(replaceAll);
        this.mLogService.onSwitch(this.mCurrentPlayURL, replaceAll, "httpk_to_http", i4);
        this.mCurrentPlayURL = replaceAll;
        _stopPlayer();
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(this.mCurrentPlayURL);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QuicDegrade(int i4) {
        String replaceAll;
        if (this.mCurrentPlayURL == null) {
            return false;
        }
        if ((TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUICU)) && i4 == -499499) {
            if (this.mURLProtocol.equals(LiveConfigKey.TLS)) {
                this.mTransportProtocol = LiveConfigKey.TLS;
                replaceAll = this.mCurrentPlayURL.replaceAll("httpq", "https");
            } else if (this.mURLProtocol.equals(LiveConfigKey.KCP)) {
                this.mTransportProtocol = LiveConfigKey.KCP;
                replaceAll = this.mCurrentPlayURL.replaceAll("httpq", "httpk");
            } else {
                this.mTransportProtocol = LiveConfigKey.TCP;
                replaceAll = this.mCurrentPlayURL.replaceAll("httpq", "http");
            }
            String replaceAll2 = replaceAll.replaceAll(":(\\d+)/", TTPathConst.sSeparator);
            updateDownloadSizeStat();
            this.mLogService.onSessionStop();
            this.mIsRetrying = true;
            if (replaceAll2 != null) {
                this.mLogService.onSwitchURL(replaceAll2);
                this.mLogService.onSwitch(this.mCurrentPlayURL, replaceAll2, "quic_library_load_error", i4);
                this.mCurrentPlayURL = replaceAll2;
                _stopPlayer();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                parsePlayDNS(this.mCurrentPlayURL);
            }
            return true;
        }
        return false;
    }

    private String _addParamToURL(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str4 = str2 + "=" + str3;
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            str4 = "?" + str4;
        } else if (indexOf != str.length() - 1) {
            str4 = "&" + str4;
        }
        return str + str4;
    }

    private void _checkStreamData() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        liveInfoSource.setEnableOriginResolution(this.mEnableOriginResolution);
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE)) {
            String defaultResolution = this.mURLSource.getDefaultResolution();
            if (!TextUtils.isEmpty(defaultResolution)) {
                if (!this.mEnableOriginResolution && defaultResolution.equals(LiveConfigKey.ORIGIN)) {
                    _smartResolveDefaultResolution(LiveConfigKey.UHD);
                } else {
                    _smartResolveDefaultResolution(defaultResolution);
                }
            }
            if (this.mURLSource.isABRListMatch() && this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mResolution = this.mURLSource.getDefaultResolution();
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mEnableResolutionAutoDegrade = false;
            if (!this.mURLSource.isABRListMatch()) {
                this.mLogService.mABRListMatch = 0;
            }
            if (this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mLogService.mCodecNotSame = 1;
        }
    }

    private void _checkValidAbrResolution() {
        if (!this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || !this.mEnableResolutionAutoDegrade || this.mURLSource.isEnableAdaptive(this.mResolution)) {
            return;
        }
        int i4 = 0;
        while (true) {
            String[] strArr = LiveConfigKey.resolution;
            if (i4 >= strArr.length) {
                return;
            }
            if (this.mURLSource.isEnableAdaptive(strArr[i4])) {
                MyLog.i(TAG, "Abr res check.modify from " + this.mResolution + " to " + strArr[i4]);
                this.mResolution = strArr[i4];
                return;
            }
            i4++;
        }
    }

    private void _configAbrInfo() {
        JSONObject abrInfo = this.mURLSource.getAbrInfo();
        if (abrInfo != null) {
            boolean z3 = true;
            this.mHasAbrInfo = true;
            try {
                if (abrInfo.has("enable")) {
                    this.mEnableResolutionAutoDegrade = abrInfo.optInt("enable") == 1;
                }
                if (abrInfo.has("strategy")) {
                    this.mAbrStrategy = abrInfo.getString("strategy");
                }
                if (abrInfo.has("enable_origin_resolution")) {
                    if (abrInfo.optInt("enable_origin_resolution") != 1) {
                        z3 = false;
                    }
                    this.mEnableOriginResolution = z3;
                }
                if (abrInfo.has("disable_algorithm")) {
                    this.mABRDisableAlgorithm = abrInfo.optInt("disable_algorithm");
                    return;
                }
                return;
            } catch (JSONException e4) {
                e4.printStackTrace();
                this.mHasAbrInfo = false;
                this.mEnableResolutionAutoDegrade = false;
                this.mAbrStrategy = LiveConfigKey.RAD;
                this.mEnableOriginResolution = false;
                this.mStallCountThresOfResolutionDegrade = 4;
                return;
            }
        }
        this.mHasAbrInfo = false;
        this.mEnableResolutionAutoDegrade = false;
        this.mEnableOriginResolution = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mStallCountThresOfResolutionDegrade = 4;
    }

    private void _configAvphNeqStrategy() {
        JSONObject jSONObject;
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (jSONObject == null && jSONObject.has("net_effective_connection_type_strategy")) {
                try {
                    jSONObject.getJSONObject("net_effective_connection_type_strategy");
                } catch (JSONException e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            return;
        }
        jSONObject = null;
        if (jSONObject == null) {
            return;
        }
        jSONObject.getJSONObject("net_effective_connection_type_strategy");
    }

    private void _configFlvLowLatencyWithSDKParam() {
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject = new JSONObject(sDKParams);
                if (jSONObject.has("NetworkAdapt")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NetworkAdapt"));
                    if (jSONObject2.has("Enabled")) {
                        int optInt = jSONObject2.optInt("Enabled");
                        this.mEnableHurryFlag = optInt;
                        if (optInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject2.has("HurryTime")) {
                            int optInt2 = jSONObject2.optInt("HurryTime");
                            this.mHurryTime = optInt2;
                            this.mPlayer.setIntOption(15, optInt2);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurryMillisecond")) {
                            int optInt3 = jSONObject2.optInt("HurryMillisecond");
                            this.mHurryTime = optInt3;
                            this.mPlayer.setIntOption(397, optInt3);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurrySpeed")) {
                            float parseFloat = Float.parseFloat(jSONObject2.optString("HurrySpeed"));
                            this.mCatchSpeed = parseFloat;
                            this.mPlayer.setFloatOption(80, parseFloat);
                            this.mLogService.mCatchSpeed = this.mCatchSpeed;
                        }
                        if (jSONObject2.has("SlowTime")) {
                            int optInt4 = jSONObject2.optInt("SlowTime");
                            this.mSlowPlayTime = optInt4;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, optInt4);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowMillisecond")) {
                            int optInt5 = jSONObject2.optInt("SlowMillisecond");
                            this.mSlowPlayTime = optInt5;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, optInt5);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowSpeed")) {
                            float parseFloat2 = Float.parseFloat(jSONObject2.optString("SlowSpeed"));
                            this.mSlowPlaySpeed = parseFloat2;
                            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, parseFloat2);
                            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
                        }
                    }
                }
                if (jSONObject.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject.optInt("FastOpenDuration");
                }
                if (jSONObject.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject.optInt("EnableLowLatencyFLV");
                    MyLog.d(TAG, "enable low latency:" + this.mEnableLowLatencyFLV + " stallTotalCount:" + this.mLogService.getStallTotalCount() + " retryTotalCount:" + this.mLogService.getRetryTotalCount());
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void _configLiveSettingBundle() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle == null) {
            return;
        }
        this.mEnableCheckDropAudio = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_enable_check_drop_audio", 0)).intValue();
        this.mRenderType = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_option_render_type", 3)).intValue();
        this.mEnableCmafFastMode = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_cmaf_fast_mode", 0)).intValue();
        this.mStartPlayBufferThres = ((Long) this.mSettingsBundle.getSettingsValueForKey("live_start_play_buffer_thres", 0L)).longValue();
        this.mCheckBufferingEndIgnoreVideo = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_ignore_video", 0)).intValue();
        this.mStartDirectAfterPrepared = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_direct_start_after_prepared", 0)).intValue();
        this.mCheckBufferingEndAdvanceEnable = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_advance", 0)).intValue();
        if (!this.mHasAbrInfo) {
            this.mEnableResolutionAutoDegrade = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_enable_resolution_degrade", Boolean.FALSE)).booleanValue();
            this.mStallCountThresOfResolutionDegrade = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_stall_count_thres_for_degrade", 4)).intValue();
        }
        MyLog.i(TAG, "mEnableResolutionAutoDegrade:" + this.mEnableResolutionAutoDegrade + " mStallCountThresOfResolutionDegrade:" + this.mStallCountThresOfResolutionDegrade);
        this.mEnableOpenMDL = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_open_mdl_enable", 0)).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append("enable mdl:");
        sb.append(this.mEnableOpenMDL);
        MyLog.i(TAG, sb.toString());
        this.mEnableTcpFastOpen = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_tcp_fast_open", 0)).intValue();
        MyLog.i(TAG, "enable tfo:" + this.mEnableTcpFastOpen);
        this.mEnableCheckPacketCorrupt = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_check_packet_corrupt", 0)).intValue();
        this.mEnableFlvABR = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_flv_abr", 0)).intValue();
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        Boolean bool = Boolean.FALSE;
        this.mForceHttpDns = ((Boolean) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_http_dns_enabled", bool)).booleanValue();
        this.mHttpDNSServerHost = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_http_dns_server_host", "null");
        this.mLogService.mEnableHttpDns = this.mForceHttpDns;
        MyLog.i(TAG, "enable http dns:" + this.mForceHttpDns + " http dns server: " + this.mHttpDNSServerHost);
        this.mLogService.mHostNTPUrl = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_ntp_server_name", "null");
        this.mCancelSDKDNSFailRetry = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_sdk_cancel_sdk_dns_fail_retry", bool)).booleanValue();
        this.mEnableClosePlayRetry = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_close_play_retry", 0)).intValue();
        this.mEnableOptimizeBackup = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_optimize_backup_enabled", 0)).intValue();
        MyLog.i(TAG, "enable optimize backup ip:" + this.mEnableOptimizeBackup);
        this.mEnableStallRetryInstantly = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_stall_retry_instantly_enabled", 1)).intValue();
        this.mEnableAudioVolumeBalance = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_enable", 0)).intValue();
        this.mAudioVolumeBalancePregain = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_pregain", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalanceThreshold = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_threshold", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalanceRatio = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_ratio", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalancePredelay = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_predelay", Float.valueOf(-1.0f))).floatValue();
        MyLog.i(TAG, "audio balance:" + this.mEnableAudioVolumeBalance + "," + this.mAudioVolumeBalancePregain + "," + this.mAudioVolumeBalanceThreshold + "," + this.mAudioVolumeBalanceRatio + "," + this.mAudioVolumeBalancePredelay);
        this.mEnableCacheSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_sei_pts_synced", 0)).intValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("enable sei pts sync:");
        sb2.append(this.mEnableCacheSei);
        MyLog.i(TAG, sb2.toString());
        this.mStallRetryTimeIntervalManager = ((Long) this.mSettingsBundle.getSettingsValueForKey("stall_retry_time_interval_manager", Long.valueOf((long) ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT))).longValue();
        this.mEnableDecodeMultiSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_multi_sei", 0)).intValue();
        this.mEnableRadioLiveDisableRender = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_radiolive_disable_render", 0)).intValue();
        this.mEnableOpenLiveIO = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_liveio", 0)).intValue();
        this.mEnableDecodeSeiOnce = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_sei_once", 0)).intValue();
        ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_notify_sei_immediately_before_first_frame_enabled", 0)).intValue();
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableDroppingDTSRollFrame = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_dropping_dts_rollback_frame_enabled", 0)).intValue();
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                this.mLowLatencyFLVStrategy = new JSONObject(str);
            } catch (JSONException e4) {
                this.mLowLatencyFLVStrategy = null;
                e4.printStackTrace();
                MyLog.e(TAG, "strategy settings invalid");
            }
        }
    }

    private void _configWithLowLatencyFLVStrategy(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("net_effective_connection_type_strategy")) {
            try {
                jSONObject.getJSONObject("net_effective_connection_type_strategy");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void _configWithSDKParams() {
        ILiveSettingBundle iLiveSettingBundle;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject4 = new JSONObject(sDKParams);
                if (!this.mHasAbrInfo && jSONObject4.has("Auto") && (jSONObject2 = jSONObject4.getJSONObject("Auto")) != null) {
                    if (jSONObject2.has("Enable")) {
                        this.mEnableResolutionAutoDegrade = jSONObject2.optInt("Enable") == 1;
                    }
                    if (jSONObject2.has("Demotion") && (jSONObject3 = jSONObject2.getJSONObject("Demotion")) != null && jSONObject3.has("StallCount")) {
                        this.mStallCountThresOfResolutionDegrade = jSONObject3.getInt("StallCount");
                    }
                }
                if (jSONObject4.has("vbitrate")) {
                    this.mDefaultResBitrate = jSONObject4.optInt("vbitrate");
                }
                if (jSONObject4.has("FramesDrop")) {
                    this.mFramesDrop = jSONObject4.optInt("FramesDrop");
                }
                if (jSONObject4.has("AVPHDnsParseEnable")) {
                    this.mAVPHDnsParseEnable = jSONObject4.optInt("AVPHDnsParseEnable");
                }
                if (jSONObject4.has("AVPHDnsTimeout")) {
                    this.mAVPHDnsTimeout = jSONObject4.optInt("AVPHDnsTimeout");
                }
                if (jSONObject4.has("AVPHVideoProbesize")) {
                    this.mAVPHVideoProbesize = jSONObject4.optInt("AVPHVideoProbesize");
                }
                if (jSONObject4.has("AVPHVideoMaxDuration")) {
                    this.mAVPHVideoMaxDuration = jSONObject4.optInt("AVPHVideoMaxDuration");
                }
                if (jSONObject4.has("AVPHAudioProbesize")) {
                    this.mAVPHAudioProbesize = jSONObject4.optInt("AVPHAudioProbesize");
                }
                if (jSONObject4.has("AVPHAudioMaxDuration")) {
                    this.mAVPHAudioMaxDuration = jSONObject4.optInt("AVPHAudioMaxDuration");
                }
                if (jSONObject4.has("AVPHOpenVideoFirst")) {
                    this.mAVPHOpenVideoFirst = jSONObject4.optInt("AVPHOpenVideoFirst");
                }
                if (jSONObject4.has("AVPHMaxAVDiff")) {
                    this.mAVPHMaxAVDiff = jSONObject4.optInt("AVPHMaxAVDiff");
                }
                if (jSONObject4.has("AVPHAutoExit")) {
                    this.mAVPHAutoExit = jSONObject4.optInt("AVPHAutoExit");
                }
                if (jSONObject4.has("AVPHAutoReopen")) {
                    this.mAVPHEnableAutoReopen = jSONObject4.optInt("AVPHAutoReopen");
                }
                if (jSONObject4.has("AVPHVideoDiffThreshold")) {
                    this.mAVPHVideoDiffThreshold = jSONObject4.optInt("AVPHVideoDiffThreshold");
                }
                if (jSONObject4.has("AVPHReadRetryCount")) {
                    this.mAVPHReadRetryCount = jSONObject4.optInt("AVPHReadRetryCount");
                }
                if (jSONObject4.has("AVPHReadErrorExit")) {
                    this.mAVPHReadErrorExit = jSONObject4.optInt("AVPHReadErrorExit");
                }
                if (jSONObject4.has("EnableSkipFindUnnecessaryStream")) {
                    this.mEnableSkipFindUnnecessaryStream = jSONObject4.optInt("EnableSkipFindUnnecessaryStream");
                }
                if (jSONObject4.has("EnableRenderStall")) {
                    this.mEnableRenderStall = jSONObject4.optInt("EnableRenderStall");
                }
                if (jSONObject4.has("VideoRenderStallThreshold")) {
                    mVideoRenderStallThreshold = jSONObject4.optInt("VideoRenderStallThreshold");
                }
                if (jSONObject4.has("AudioRenderStallThreshold")) {
                    mAudioRenderStallThreshold = jSONObject4.optInt("AudioRenderStallThreshold");
                }
                if (jSONObject4.has("EnableDemuxerStall")) {
                    this.mEnableDemuxerStall = jSONObject4.optInt("EnableDemuxerStall");
                }
                if (jSONObject4.has("EnableDecoderStall")) {
                    this.mEnableDecoderStall = jSONObject4.optInt("EnableDecoderStall");
                }
                if (jSONObject4.has("DemuxerStallThreshold")) {
                    mDemuxerStallThreshold = jSONObject4.optInt("DemuxerStallThreshold");
                }
                if (jSONObject4.has("DecoderStallThreshold")) {
                    mDecoderStallThreshold = jSONObject4.optInt("DecoderStallThreshold");
                }
                if (jSONObject4.has("StallCounter") && (jSONObject = jSONObject4.getJSONObject("StallCounter")) != null) {
                    if (jSONObject.has("Enable")) {
                        this.mEnableStallCounter = jSONObject.optInt("Enable");
                    }
                    if (jSONObject.has("TimeInterval")) {
                        this.mStallCounterInterval = jSONObject.optInt("TimeInterval");
                    }
                }
                if (jSONObject4.has("DTSCheckEnabled")) {
                    this.mEnableDTSCheck = jSONObject4.optInt("DTSCheckEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataEnabled")) {
                    this.mEnablePreventDTSBack = jSONObject4.optInt("DroppingRepeatingDataEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataDTSMaxDiff")) {
                    this.mFrameDroppingDTSMaxDiff = jSONObject4.optLong("DroppingRepeatingDataDTSMaxDiff");
                }
                if (jSONObject4.has("EnableSaveSCFG")) {
                    this.mEnableSaveSCFG = jSONObject4.optInt("EnableSaveSCFG") == 1;
                }
                if (jSONObject4.has("EnableVideoMpdRefresh")) {
                    this.mEnableVideoMpdRefresh = jSONObject4.optInt("EnableVideoMpdRefresh");
                }
                if (jSONObject4.has("TransInfoCheck")) {
                    JSONObject optJSONObject3 = jSONObject4.optJSONObject("TransInfoCheck");
                    if (optJSONObject3.has("Enabled")) {
                        this.mEnableCheckFrame = optJSONObject3.optInt("Enabled");
                    }
                }
                if (jSONObject4.has("SEICheck")) {
                    JSONObject optJSONObject4 = jSONObject4.optJSONObject("SEICheck");
                    if (optJSONObject4.has("Enabled")) {
                        this.mEnableCheckSEI = optJSONObject4.optInt("Enabled");
                        if (optJSONObject4.optInt("Enabled") == 1 || this.mLogService != null) {
                            this.mLogService.enableCheckSei();
                        }
                    }
                }
                if (jSONObject4.has("EnableCacheSei")) {
                    this.mEnableCacheSei = jSONObject4.optInt("EnableCacheSei");
                }
                if (jSONObject4.has("gop")) {
                    this.mGopDuration = jSONObject4.optInt("gop");
                }
                if (jSONObject4.has("EnableLLASHFastOpen")) {
                    this.mEnableLLASHFastOpen = jSONObject4.optInt("EnableLLASHFastOpen");
                }
                if (jSONObject4.has("EnableABRCheckEnhance")) {
                    this.mEnableLiveAbrCheckEnhance = jSONObject4.optInt("EnableABRCheckEnhance");
                }
                if (jSONObject4.has("ABRCheckInterval")) {
                    this.mLiveABRCheckInterval = jSONObject4.optInt("ABRCheckInterval");
                }
                if (jSONObject4.has("ABRMethod")) {
                    this.mABRMethod = jSONObject4.optInt("ABRMethod");
                }
                if (jSONObject4.has("ABRBufferThreshold")) {
                    this.mABRBufferThreshold = jSONObject4.optInt("ABRBufferThreshold");
                }
                if (jSONObject4.has("MaxCacheSeconds")) {
                    this.mMaxCacheSeconds = jSONObject4.optInt("MaxCacheSeconds");
                }
                if (jSONObject4.has("MainBackupSwitch")) {
                    JSONObject optJSONObject5 = jSONObject4.optJSONObject("MainBackupSwitch");
                    if (optJSONObject5.has("Enabled")) {
                        if (optJSONObject5.optInt("Enabled") == 0) {
                            this.mEnableSwitchMainAndBackupUrl = false;
                        } else {
                            this.mEnableSwitchMainAndBackupUrl = true;
                        }
                    }
                }
                if (jSONObject4.has("MinTimeShift")) {
                    this.mTslMinTimeShit = jSONObject4.optInt("MinTimeShift");
                }
                if (jSONObject4.has("TargetOriginBitRate")) {
                    this.mTargetOriginBitRate = jSONObject4.optInt("TargetOriginBitRate");
                }
                if (jSONObject4.has("AbrStallDegradeImmediately")) {
                    this.mEnableAbrStallDegradeImmediately = jSONObject4.optInt("AbrStallDegradeImmediately");
                }
                if (jSONObject4.has("HASSessionPath")) {
                    this.mCdnSessionPath = jSONObject4.optString("HASSessionPath");
                }
                if (jSONObject4.has("DecodeSEIEnabled")) {
                    this.mEnableUploadSei = jSONObject4.optInt("DecodeSEIEnabled");
                }
                if (jSONObject4.has("NetworkAdapt")) {
                    JSONObject jSONObject5 = new JSONObject(jSONObject4.optString("NetworkAdapt"));
                    if (jSONObject5.has("Enabled")) {
                        int optInt = jSONObject5.optInt("Enabled");
                        this.mEnableHurryFlag = optInt;
                        if (optInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject5.has("HurryTime")) {
                            int optInt2 = jSONObject5.optInt("HurryTime");
                            this.mHurryTime = optInt2;
                            this.mPlayer.setIntOption(15, optInt2);
                        }
                        if (jSONObject5.has("HurryMillisecond")) {
                            int optInt3 = jSONObject5.optInt("HurryMillisecond");
                            this.mHurryTime = optInt3;
                            this.mPlayer.setIntOption(397, optInt3);
                        }
                        if (jSONObject5.has("HurrySpeed")) {
                            this.mCatchSpeed = Float.parseFloat(jSONObject5.optString("HurrySpeed"));
                        }
                        if (jSONObject5.has("SlowTime")) {
                            int optInt4 = jSONObject5.optInt("SlowTime");
                            this.mSlowPlayTime = optInt4;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, optInt4);
                        }
                        if (jSONObject5.has("SlowMillisecond")) {
                            int optInt5 = jSONObject5.optInt("SlowMillisecond");
                            this.mSlowPlayTime = optInt5;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, optInt5);
                        }
                        if (jSONObject5.has("SlowSpeed")) {
                            this.mSlowPlaySpeed = Float.parseFloat(jSONObject5.optString("SlowSpeed"));
                        }
                    }
                }
                if (jSONObject4.has("StartPlayAudioBufferThreshold")) {
                    this.mStartPlayBufferThres = jSONObject4.optInt("StartPlayAudioBufferThreshold");
                }
                if (jSONObject4.has("EnableCertVerify")) {
                    this.mEnableQuicCertVerify = jSONObject4.optInt("EnableCertVerify") == 1;
                }
                if (jSONObject4.has("EnableClosePlayRetry")) {
                    this.mEnableClosePlayRetry = jSONObject4.optInt("EnableClosePlayRetry");
                }
                if (jSONObject4.has("EnableDnsOptimizer")) {
                    boolean z3 = jSONObject4.optInt("EnableDnsOptimizer") == 1;
                    this.mEnableDnsOptimizer = z3;
                    this.mLogService.openNodeOptimizer(z3);
                }
                if (jSONObject4.has("EnableMTUDiscovery")) {
                    this.mEnableQuicMTUDiscovery = jSONObject4.optInt("EnableMTUDiscovery");
                }
                if (jSONObject4.has("InitMTU")) {
                    this.mQuicInitMTU = jSONObject4.optInt("InitMTU");
                }
                if (jSONObject4.has("InitRtt")) {
                    this.mQuicInitRtt = jSONObject4.optInt("InitRtt");
                }
                if (jSONObject4.has("MaxCryptoRetransmissions")) {
                    this.mQuicMaxCryptoRetransmissions = jSONObject4.optInt("MaxCryptoRetransmissions");
                }
                if (jSONObject4.has("MaxCryptoRetransmissionTimeMs")) {
                    this.mQuicMaxCryptoRetransmissionTimeMs = jSONObject4.optInt("MaxCryptoRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxRetransmissions")) {
                    this.mQuicMaxRetransmissions = jSONObject4.optInt("MaxRetransmissions");
                }
                if (jSONObject4.has("MaxRetransmissionTimeMs")) {
                    this.mQuicMaxRetransmissionTimeMs = jSONObject4.optInt("MaxRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxAckDelay")) {
                    this.mQuicMaxAckDelay = jSONObject4.optInt("MaxAckDelay");
                }
                if (jSONObject4.has("MinReceivedBeforeAckDecimation")) {
                    this.mQuicMinReceivedBeforeAckDecimation = jSONObject4.optInt("MinReceivedBeforeAckDecimation");
                }
                if (jSONObject4.has("QuicVersion")) {
                    this.mQuicVersion = jSONObject4.optInt("QuicVersion", 39);
                }
                if (jSONObject4.has("PadHello")) {
                    this.mQuicPadHello = jSONObject4.optInt("PadHello", 1);
                }
                if (jSONObject4.has("FixWillingAndAbleToWrite")) {
                    this.mQuicFixWillingAndAbleToWrite = jSONObject4.optInt("FixWillingAndAbleToWrite", 1);
                }
                if (jSONObject4.has("FixProcessTimer")) {
                    this.mQuicFixProcessTimer = jSONObject4.optInt("FixProcessTimer", 1);
                }
                if (jSONObject4.has("QuicReadBlockTimeout")) {
                    this.mQuicReadBlockTimeout = jSONObject4.optInt("QuicReadBlockTimeout", 100);
                }
                if (jSONObject4.has("QuicReadBlockMode")) {
                    this.mQuicReadBlockMode = jSONObject4.optInt("QuicReadBlockMode", 0);
                }
                if (jSONObject4.has("FixStreamFinAndRst")) {
                    this.mQuicFixStreamFinAndRst = jSONObject4.optInt("FixStreamFinAndRst", 0);
                }
                if (jSONObject4.has("QuicTimerVersion")) {
                    this.mQuicTimerVersion = jSONObject4.optInt("QuicTimerVersion", 1);
                }
                if (jSONObject4.has("QuicConfigOptimize")) {
                    this.mQuicConfigOptimize = jSONObject4.optInt("QuicConfigOptimize", 0);
                }
                if (jSONObject4.has("QuicSessionReceiveWindow")) {
                    this.mSessionReceiveWindow = jSONObject4.optInt("QuicSessionReceiveWindow", 1);
                }
                if (jSONObject4.has("QuicStreamReceiveWindow")) {
                    this.mStreamReceiveWindow = jSONObject4.optInt("QuicStreamReceiveWindow", 1);
                }
                if (jSONObject4.has("EnableCheckDropAudio")) {
                    this.mEnableCheckDropAudio = jSONObject4.optInt("EnableCheckDropAudio");
                }
                if (jSONObject4.has("AVNoSyncThreshold")) {
                    this.mAVNoSyncThreshold = jSONObject4.optInt("AVNoSyncThreshold");
                }
                if (jSONObject4.has("AlwaysDoAVSync")) {
                    this.mIsAlwaysDoAVSync = jSONObject4.optInt("AlwaysDoAVSync");
                }
                if (jSONObject4.has("StallRetryTimeIntervalManager")) {
                    this.mStallRetryTimeIntervalManager = jSONObject4.optLong("StallRetryTimeIntervalManager");
                }
                if (jSONObject4.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject4.optInt("FastOpenDuration");
                }
                if (jSONObject4.has("LLSConfig") && (optJSONObject2 = jSONObject4.optJSONObject("LLSConfig")) != null) {
                    if (optJSONObject2.has("FallbackThreshold")) {
                        this.mRtcFallbackThreshold = optJSONObject2.optInt("FallbackThreshold");
                    }
                    if (optJSONObject2.has("EnableDtls")) {
                        this.mRtcEnableDtls = optJSONObject2.optInt("EnableDtls");
                    }
                    if (optJSONObject2.has("MinJitterBuffer")) {
                        this.mRtcMinJitterBuffer = optJSONObject2.optInt("MinJitterBuffer");
                    }
                    if (optJSONObject2.has("MaxJitterBuffer")) {
                        this.mRtcMaxJitterBuffer = optJSONObject2.optInt("MaxJitterBuffer");
                    }
                    if (optJSONObject2.has("EnableSDKDns")) {
                        this.mRtcEnableSDKDns = optJSONObject2.optInt("EnableSDKDns");
                    }
                    if (optJSONObject2.has("EnableEarlyInitRender")) {
                        this.mRtcEarlyInitRender = optJSONObject2.optInt("EnableEarlyInitRender");
                    }
                    if (optJSONObject2.has("MaxRetryCount")) {
                        this.mRtcMaxRetryCount = optJSONObject2.optInt("MaxRetryCount");
                    }
                    if (optJSONObject2.has("EnableRTCHWDecode")) {
                        this.mHardwareRTCDecodeEnable = optJSONObject2.optInt("EnableRTCHWDecode");
                    }
                    if (optJSONObject2.has("EnableMiniSdp")) {
                        this.mRtcSupportMiniSdp = optJSONObject2.optInt("EnableMiniSdp");
                    }
                    if (optJSONObject2.has("PlayingLogInterval")) {
                        int optInt6 = optJSONObject2.optInt("PlayingLogInterval");
                        this.mRtcPlayLogInterval = optInt6;
                        LiveLoggerService liveLoggerService = this.mLogService;
                        if (liveLoggerService != null) {
                            liveLoggerService.setRtcPlayLogInterval(optInt6);
                        }
                    }
                    if (optJSONObject2.has("EnableRTSFixDeadlock")) {
                        this.mRtcEnableRtcUninitLockFree = optJSONObject2.optInt("EnableRTSFixDeadlock");
                    }
                }
                if (jSONObject4.has("NetWorkTimeoutMs")) {
                    this.mNetworkTimeout = jSONObject4.optInt("NetWorkTimeoutMs");
                }
                if (jSONObject4.has("EnableCheckPacketCorrupt")) {
                    this.mEnableCheckPacketCorrupt = jSONObject4.optInt("EnableCheckPacketCorrupt");
                }
                if (jSONObject4.has("AudioTimescaleEnable")) {
                    this.mAudioTimescaleEnable = jSONObject4.optInt("AudioTimescaleEnable");
                }
                if (jSONObject4.has("EnableTcpFastOpen")) {
                    this.mEnableTcpFastOpen = jSONObject4.optInt("EnableTcpFastOpen");
                }
                if (jSONObject4.has("HlsLiveStartIndex")) {
                    this.mHlsLiveStartIndex = jSONObject4.optInt("HlsLiveStartIndex");
                }
                if (jSONObject4.has("CmafOptimizeRetry")) {
                    this.mEnableCmafOptimizeRetry = jSONObject4.optInt("CmafOptimizeRetry");
                }
                if (jSONObject4.has("EnableFastOpen")) {
                    this.mEnableFastOpenStream = jSONObject4.optInt("EnableFastOpen");
                }
                if (jSONObject4.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject4.optInt("EnableLowLatencyFLV");
                    Log.d(TAG, "enable low latency:" + this.mEnableLowLatencyFLV);
                }
                if (jSONObject4.has("EnableSkipFlvNullTag")) {
                    this.mEnableSkipFlvNullTag = jSONObject4.optInt("EnableSkipFlvNullTag");
                    Log.d(TAG, "enable skip flv null tag:" + this.mEnableSkipFlvNullTag);
                }
                if (jSONObject4.has("LiveIOConfig") && (optJSONObject = jSONObject4.optJSONObject("LiveIOConfig")) != null) {
                    if (optJSONObject.has("EnableLiveIO")) {
                        this.mEnableLiveIOPlay = optJSONObject.optInt("EnableLiveIO");
                    }
                    if (optJSONObject.has("EnableP2P")) {
                        this.mEnableLiveIOP2P = optJSONObject.optInt("EnableP2P");
                    }
                    if (optJSONObject.has("EnableHttpPrepare")) {
                        this.mEnableHttpPrepare = optJSONObject.optInt("EnableHttpPrepare");
                    }
                    if (optJSONObject.has("EnableP2pUp")) {
                        this.mEnableP2pUp = optJSONObject.optInt("EnableP2pUp");
                    }
                    if (optJSONObject.has("LiveIOABGroupID")) {
                        this.mLiveIOABGroupID = optJSONObject.optInt("LiveIOABGroupID");
                    }
                }
                if (jSONObject4.has("EnableNTPByApp")) {
                    int optInt7 = jSONObject4.optInt("EnableNTPByApp");
                    this.mEnableNTP = optInt7;
                    LiveLoggerService liveLoggerService2 = this.mLogService;
                    liveLoggerService2.mEnableNTP = optInt7;
                    if (optInt7 == 1 && (iLiveSettingBundle = this.mSettingsBundle) != null) {
                        liveLoggerService2.mTimeDiff = ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
                        MyLog.d("ntp", "time_diff:" + this.mLogService.mTimeDiff);
                    }
                }
                if (jSONObject4.has("NoSyncReportMinDuration")) {
                    this.mNoSyncReportMinDuration = jSONObject4.optInt("NoSyncReportMinDuration");
                }
                if (jSONObject4.has("NoSyncReportReportThres")) {
                    this.mNoSyncReportReportThres = jSONObject4.optInt("NoSyncReportReportThres");
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        this.mLogService.mDefaultResBitrate = this.mDefaultResBitrate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doRequestSwitchUrlFromServer() {
        MediaPlayer mediaPlayer;
        String stringOption;
        String[] split;
        if (TextUtils.isEmpty(this.mCdnSessionPath) || TextUtils.isEmpty(this.mCdnAbrResolution) || this.mCdnAbrResolution.equals(this.mResolution) || (mediaPlayer = this.mPlayer) == null || (stringOption = mediaPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS)) == null) {
            return;
        }
        MyLog.i(TAG, "responseHeaders: " + stringOption);
        String str = null;
        for (String str2 : stringOption.split("\r\n")) {
            if (str2.startsWith("X-Has-Token: ")) {
                str = str2.split(": ", 2)[1];
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.mLogService.mSessionId)) {
                jSONObject.put("live_stream_session_id", this.mLogService.mSessionId);
            }
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mCdnAbrResolution, LiveConfigKey.FLV, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                return;
            }
            jSONObject.put("play_url", playURLForResolution);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("token", str);
            }
            String substring = playURLForResolution.substring(playURLForResolution.indexOf("//") + 2);
            String substring2 = substring.substring(substring.indexOf(TTPathConst.sSeparator));
            if (!this.mCdnSessionPath.startsWith(TTPathConst.sSeparator)) {
                this.mCdnSessionPath = TTPathConst.sSeparator + this.mCdnSessionPath;
            }
            String str3 = playURLForResolution.substring(0, playURLForResolution.indexOf(substring2)) + this.mCdnSessionPath;
            MyLog.i(TAG, "sending 'POST' request to URL : " + str3);
            MyLog.i(TAG, "httpBody: " + jSONObject);
            INetworkClient.Result doPost = this.mNetworkClient.doPost(str3, jSONObject.toString());
            if (doPost != null) {
                MyLog.i(TAG, "response: " + doPost.response);
                MyLog.i(TAG, "code: " + doPost.code);
                LiveLoggerService liveLoggerService = this.mLogService;
                int i4 = doPost.code;
                liveLoggerService.mCdnAbrSwitchCode = i4;
                if (i4 == 200 && doPost.response.has("code")) {
                    this.mLogService.mCdnAbrSwitchCode = doPost.response.optInt("code");
                    if (this.mLogService.mCdnAbrSwitchCode == 0) {
                        this.mResolution = this.mCdnAbrResolution;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void _play(String str) {
        PlayerState playerState = this.mPrepareState;
        if (playerState == PlayerState.PREPARED && this.mPlayer != null) {
            MyLog.i(TAG, "_play resume");
            String str2 = this.mCurrentIP;
            if (str2 != null) {
                this.mLogService.setCdnIp(str2, false);
            }
            this.mPlayer.start();
        } else if (playerState != PlayerState.IDLE && this.mPlayer != null) {
            configPlayerGlobalOption();
            if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL)) {
                prepareToPlay(this.mLocalURL, null, null, null);
            } else {
                parsePlayDNS(str);
            }
        } else {
            MyLog.i(TAG, "_play start");
            open();
            this.mPrepareState = PlayerState.INITIALIZED;
            if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL)) {
                this.mLogService.onCallPrepare();
                prepareToPlay(this.mLocalURL, null, null, null);
            } else {
                parsePlayDNS(str);
            }
        }
        this.mIsRequestCanceled = false;
    }

    private void _requestSwitchUrlFromServer() {
        this.mLogService.mIsCdnAbrSwitch = true;
        if ((this.mURLSource.getSourceType() != 2 || this.mURLSource.isCodecSame(this.mLevel)) && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveManager.this._doRequestSwitchUrlFromServer();
                }
            });
        }
    }

    private void _reset(String str) {
        MyLog.i(TAG, "_reset");
        _stopPlayer();
        _resetPlayer();
        _stopLiveManager(str);
        this.mResolutionIndex = -1;
        this.mLivePlayerState = LivePlayerState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _resetPlayer() {
        MyLog.i(TAG, "_resetPlayer");
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        this.mPrepareState = PlayerState.INITIALIZED;
    }

    private void _setLooseSync() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        String sDKParams = liveInfoSource.getSDKParams(this.mResolution, this.mLevel);
        if (TextUtils.isEmpty(sDKParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(sDKParams);
            if (jSONObject.has("ForceDecodeSwitch")) {
                this.mForceDecodeSwitch = jSONObject.optInt("ForceDecodeSwitch");
            }
            if (jSONObject.has("ForceDecodeMsGaps")) {
                this.mForceDecodeMsGaps = jSONObject.optInt("ForceDecodeMsGaps");
            }
            if (jSONObject.has("ForceRenderMsGaps")) {
                this.mForceRenderMsGaps = jSONObject.optInt("ForceRenderMsGaps");
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void _setProtocol() {
        String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
        if (playURLForResolution != null) {
            this.mLogService.setOriginUrl(playURLForResolution);
            if (playURLForResolution.startsWith("http")) {
                this.mTransportProtocol = LiveConfigKey.TCP;
            }
            if (playURLForResolution.startsWith("httpk")) {
                this.mTransportProtocol = LiveConfigKey.KCP;
            }
            if (playURLForResolution.startsWith("https")) {
                this.mTransportProtocol = LiveConfigKey.TLS;
            }
            this.mURLProtocol = this.mTransportProtocol;
        }
        String suggestProtocol = this.mURLSource.getSuggestProtocol(this.mResolution, this.mLevel);
        this.mSuggestProtocol = suggestProtocol;
        if (suggestProtocol != null) {
            if ((suggestProtocol.equals(LiveConfigKey.QUIC) || this.mSuggestProtocol.equals(LiveConfigKey.QUICU)) && !this.mQuicEnable) {
                try {
                    LibraryLoader.loadLibrary("ttquic");
                    this.mQuicEnable = true;
                    MyLog.i(TAG, "ttquic lib is load success");
                    this.mLogService.setQuicLibLoader(1);
                } catch (Throwable unused) {
                    suggestProtocol = this.mTransportProtocol;
                    this.mQuicEnable = false;
                    MyLog.i(TAG, "ttquic lib is load failed. change default protocol");
                    this.mLogService.setQuicLibLoader(0);
                }
            }
            this.mTransportProtocol = suggestProtocol;
            return;
        }
        this.mSuggestProtocol = "none";
    }

    private void _setStreamFormat() {
        String str;
        String suggestFormat = this.mURLSource.getSuggestFormat(this.mResolution, this.mLevel);
        if (suggestFormat != null) {
            if (suggestFormat.equals(LiveConfigKey.CMAF) && !this.mCmafEnable) {
                try {
                    LibraryLoader.loadLibrary("ttmcmaf");
                    this.mCmafEnable = true;
                    MyLog.i(TAG, "cmaf lib is load success");
                } catch (Throwable unused) {
                    this.mURLSource.setStreamInfoFlag(1);
                    str = this.mStreamFormat;
                    this.mCmafEnable = false;
                    MyLog.i(TAG, "cmaf lib is load failed. change default format");
                }
            } else if (suggestFormat.equals("lls")) {
                this.mEnableRtcPlay = 1;
                this.mLogService.mEnableRtcPlay = 1;
                try {
                    MyLog.i(TAG, "lls load bytertc library");
                    System.loadLibrary("byteaudio");
                    System.loadLibrary("bytenn");
                    System.loadLibrary("bytertc");
                    MyLog.i(TAG, "lls load bytertc library done");
                } catch (Throwable unused2) {
                    this.mURLSource.setStreamInfoFlag(2);
                    str = this.mStreamFormat;
                    this.mEnableRtcPlay = 0;
                    this.mLogService.mEnableRtcPlay = 0;
                    MyLog.i(TAG, "bytertc lib is load failed. change default format");
                }
            }
            str = suggestFormat;
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(suggestFormat, str);
        } else {
            this.mStreamFormat = LiveConfigKey.FLV;
            this.mLogService.setFormatInfo("none", LiveConfigKey.FLV);
        }
        if (!TextUtils.isEmpty(this.mStreamFormat) && this.mStreamFormat.equals(LiveConfigKey.FLV)) {
            _setAvLines();
            if (!this.mEnableAvLines.isEmpty() && !this.mVideoOnly.isEmpty() && !this.mAudioOnly.isEmpty() && this.mEnableAvLines.equals("true") && this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO) && this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
                this.mStreamFormat = LiveConfigKey.AVPH;
                this.mLogService.setFormatInfo(LiveConfigKey.AVPH, LiveConfigKey.AVPH);
            }
        }
        if (TextUtils.isEmpty(this.mStreamFormat) || !this.mStreamFormat.equals(LiveConfigKey.AVPH)) {
            return;
        }
        _configAvphNeqStrategy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void _smartResolveDefaultResolution(String str) {
        char c4;
        char c5;
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mEnableResolutionAutoDegrade && !TextUtils.isEmpty(str)) {
            String str2 = str;
            if (str2.equals(LiveConfigKey.LOW)) {
                while (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(this.mURLSource.getPlayURLForResolution(str2, this.mStreamFormat, this.mLevel))) {
                        this.mURLSource.setDefaultResolution(str2);
                        this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                        return;
                    }
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -1008619738:
                            if (str2.equals(LiveConfigKey.ORIGIN)) {
                                c5 = 0;
                                break;
                            }
                            c5 = '\uffff';
                            break;
                        case 3324:
                            if (str2.equals(LiveConfigKey.HIGH)) {
                                c5 = 1;
                                break;
                            }
                            c5 = '\uffff';
                            break;
                        case 3448:
                            if (str2.equals(LiveConfigKey.LOW)) {
                                c5 = 2;
                                break;
                            }
                            c5 = '\uffff';
                            break;
                        case 3665:
                            if (str2.equals(LiveConfigKey.STANDARD)) {
                                c5 = 3;
                                break;
                            }
                            c5 = '\uffff';
                            break;
                        case 115761:
                            if (str2.equals(LiveConfigKey.UHD)) {
                                c5 = 4;
                                break;
                            }
                            c5 = '\uffff';
                            break;
                        default:
                            c5 = '\uffff';
                            break;
                    }
                    switch (c5) {
                        case 0:
                        default:
                            str2 = null;
                            break;
                        case 1:
                            str2 = LiveConfigKey.UHD;
                            break;
                        case 2:
                            str2 = LiveConfigKey.STANDARD;
                            break;
                        case 3:
                            str2 = LiveConfigKey.HIGH;
                            break;
                        case 4:
                            str2 = LiveConfigKey.ORIGIN;
                            break;
                    }
                }
                return;
            }
            while (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(this.mURLSource.getPlayURLForResolution(str2, this.mStreamFormat, this.mLevel))) {
                    this.mURLSource.setDefaultResolution(str2);
                    this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                    return;
                }
                str2.hashCode();
                switch (str2.hashCode()) {
                    case -1008619738:
                        if (str2.equals(LiveConfigKey.ORIGIN)) {
                            c4 = 0;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3324:
                        if (str2.equals(LiveConfigKey.HIGH)) {
                            c4 = 1;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3448:
                        if (str2.equals(LiveConfigKey.LOW)) {
                            c4 = 2;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3665:
                        if (str2.equals(LiveConfigKey.STANDARD)) {
                            c4 = 3;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 115761:
                        if (str2.equals(LiveConfigKey.UHD)) {
                            c4 = 4;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    default:
                        c4 = '\uffff';
                        break;
                }
                switch (c4) {
                    case 0:
                        str2 = LiveConfigKey.UHD;
                        break;
                    case 1:
                        str2 = LiveConfigKey.STANDARD;
                        break;
                    case 2:
                    default:
                        str2 = null;
                        break;
                    case 3:
                        str2 = LiveConfigKey.LOW;
                        break;
                    case 4:
                        str2 = LiveConfigKey.HIGH;
                        break;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                MyLog.w(TAG, str2 + " not found");
            }
        }
    }

    private void _stop(boolean z3, String str) {
        MyLog.i(TAG, "_stop");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState != LivePlayerState.PLAYED && livePlayerState != LivePlayerState.PAUSED) {
            this.mLogService.onIllegalAPICall(str);
            ILiveListener iLiveListener = this.mListener;
            iLiveListener.onReportALog(6, "illegal call: " + str + " -- " + hashCode());
            return;
        }
        if (z3) {
            _stopPlayer();
        } else {
            this.mPrepareState = PlayerState.INITIALIZED;
        }
        _stopLiveManager(str);
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mSupportSRScene = 0;
        this.mTextureSRMode = 0;
        this.mEnableReportSessionStop = 0;
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mMuteAudio = -1;
        liveLoggerService.mVolumeSetting = -1.0f;
        liveLoggerService.mPlayerVolumeSetting = -1.0f;
    }

    private void _stopLiveManager(String str) {
        MyLog.i(TAG, "_stopLiveManager");
        LiveDataFetcher liveDataFetcher = this.mFetcher;
        if (liveDataFetcher != null) {
            liveDataFetcher.cancel();
        }
        DnsHelper dnsHelper = this.mDnsParser;
        if (dnsHelper != null) {
            dnsHelper.cancel();
        }
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            Log.d(TAG, "check render stall when play stop");
            onRenderStallForRetryStop();
            if (this.mIsStalling) {
                this.mLogService.onStallEnd(0);
            }
            this.mLogService.close(str);
        }
        setIntOption(75, 0);
        this.mLogService.reset();
        this.mRetryProcessor.reset();
        if (str.equals("reset")) {
            this.mURLSource.reset();
        }
        this.mShowedFirstFrame = false;
        this.mRenderStartEntered = false;
        this.mResolutionDisableSR = true;
        this.mMediaSupportSR = false;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mStallCount = 0;
        this.mIsRequestCanceled = true;
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mIsStalling = false;
        this.mIsRetrying = false;
        this.mHasRetry = false;
        this.mSupportBackupIp = true;
        this.mUrlSettingMethod = -1;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mEnableCheckFrame = 0;
        this.mEnterStallRetryInstantly = false;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableQuicCertVerify = false;
        this.mTextureSRMode = 0;
        this.mSupportSRScene = 0;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mQuicVersion = 39;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mEnableCheckDropAudio = 0;
        this.mIsPlayWithMdl = false;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mRedoDns = false;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mRtcEnableDtls = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcPlayFallBack = 0;
        this.mEnableRtcPlay = 0;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mEnableFreeFlow = 0;
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        mFastOpenDuration = -1;
        this.mMyHandler.removeCallbacksAndMessages(null);
        if (this.mEnableStallCounter == 1) {
            stopStallCounter();
        }
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _stopPlayer() {
        PlayerState playerState;
        MyLog.i(TAG, "_stopPlayer");
        if (this.mPlayer != null && ((playerState = this.mPrepareState) == PlayerState.PREPARED || playerState == PlayerState.PREPARING)) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService != null) {
                liveLoggerService.getABRStreamInfo();
                this.mLogService.getAVPHStreamInfo();
                if (this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
                    this.mLogService.resetStreamCheckParams();
                }
            }
            Log.d(TAG, "call player stop");
            if (this.mLivePlayerState != LivePlayerState.PAUSED) {
                this.mPlayer.stop();
            } else {
                this.mPlayer.reset();
            }
        }
        if (this.mIsPlayWithMdl && this.mSessionId != null) {
            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8018, this.mSessionId, 0);
        }
        this.mPrepareState = PlayerState.INITIALIZED;
        MyLog.i(TAG, "prepareState: " + this.mPrepareState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abrDegradeResolution() {
        String playURLForResolution;
        int length = LiveConfigKey.resolution.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (this.mURLSource.isSupportResolution(LiveConfigKey.resolution[length])) {
                break;
            } else {
                length--;
            }
        }
        if (length == -1) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("abrDegradeResolution, resolution: ");
        String[] strArr = LiveConfigKey.resolution;
        sb.append(strArr[length]);
        sb.append(", auto defalut resolution: ");
        sb.append(this.mURLSource.getDefaultResolution());
        MyLog.i(TAG, sb.toString());
        if (this.mURLSource.getDefaultResolution().equals(strArr[length]) || (playURLForResolution = this.mURLSource.getPlayURLForResolution(strArr[length], this.mStreamFormat, "main")) == null) {
            return false;
        }
        String str = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = length;
        this.mURLSource.setDefaultResolution(strArr[length]);
        this.mLogService.mAutoUsingResolution = strArr[length];
        saveCurrentResolution();
        this.mLogService.onSwitch(str, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mLevel = "main";
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    static /* synthetic */ int access$4408(VideoLiveManager videoLiveManager) {
        int i4 = videoLiveManager.mStallCount;
        videoLiveManager.mStallCount = i4 + 1;
        return i4;
    }

    private void addRtcCodecInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.mLogService.mCodecName) || "none_codec".equals(this.mLogService.mCodecName)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("video_codec_impl_name")) {
                    String optString = jSONObject.optString("video_codec_impl_name");
                    if (!TextUtils.isEmpty(optString)) {
                        if ("MediaCodec".equals(optString)) {
                            LiveLoggerService liveLoggerService = this.mLogService;
                            liveLoggerService.mCodecName = "hardware_codec";
                            liveLoggerService.mHardDecodeEnable = true;
                        } else {
                            LiveLoggerService liveLoggerService2 = this.mLogService;
                            liveLoggerService2.mCodecName = "software_codec";
                            liveLoggerService2.mHardDecodeEnable = false;
                        }
                    }
                }
                if (jSONObject.has("video_codec_name")) {
                    String optString2 = jSONObject.optString("video_codec_name");
                    if (!TextUtils.isEmpty(optString2)) {
                        if ("ByteVC1".equalsIgnoreCase(optString2)) {
                            this.mLogService.mCodecType = "bytevc1";
                        } else {
                            this.mLogService.mCodecType = "h264";
                        }
                    }
                }
                MyLog.i(TAG, "addRtcCodecInfo mCodecName:" + this.mLogService.mCodecName + ", mCodecType:" + this.mLogService.mCodecType + ",mHardDecodeEnable:" + this.mLogService.mHardDecodeEnable);
            } catch (Exception unused) {
            }
        }
    }

    private String addSessionIdToURL(String str, long j4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) {
            return null;
        }
        String str2 = this.mUuid + "." + j4;
        this.mLogService.mSessionId = str2;
        return !str.contains("_session_id") ? _addParamToURL(str, "_session_id", str2) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytevc1DegradeH264(int i4) {
        String str;
        if (this.mURLAbility == 2 && (str = this.mURLSource.getPlayURLByCodec("h264").mainURL) != null) {
            updateDownloadSizeStat();
            this.mLogService.onSessionStop();
            this.mIsRetrying = true;
            this.mLogService.onSwitchURL(str);
            this.mLogService.onSwitch(this.mCurrentPlayURL, str, "bytevc1_to_h264", i4);
            this.mCurrentPlayURL = str;
            this.mURLAbility = 1;
            this.mLogService.mUrlAbility = "h264";
            if (this.mHardwareDecodeEnable != 1 && this.mEnableH264HardwareDecode == 1) {
                this.mHardwareDecodeEnable = 1;
                this.mDefaultCodecId = 0;
                this.mPlayer.setIntOption(59, 1);
                this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
            }
            _resetPlayer();
            this.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(str);
            return true;
        }
        return false;
    }

    private void checkMainLooper(String str) {
        LiveLoggerService liveLoggerService;
        if (this.mIsInMainLooper != 1 || Looper.myLooper() == Looper.getMainLooper() || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.onCallNotInMainThread(str);
    }

    public static void closeDataLoader() {
        MediaLoaderWrapper.getDataLoader().close();
    }

    private void configPlayerEventHandler() {
        this.mPlayer.setOnPreparedListener(new MyPreparedListener(this));
        this.mPlayer.setOnErrorListener(new MyErrorListener(this));
        this.mPlayer.setOnInfoListener(new MyInfoListener(this));
        this.mPlayer.setOnCompletionListener(new MyCompletionListener(this));
        this.mPlayer.setOnVideoSizeChangedListener(new MyOnVideoSizeChangedListener(this));
    }

    private void configPlayerGlobalOption() {
        LiveURL playLiveURL;
        int i4;
        int i5;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        boolean z3;
        int i6;
        this.mPlayer.setIntOption(9, this.mNetworkTimeout * 1000000);
        this.mPlayer.setIntOption(83, this.mTestAction);
        this.mPlayer.setIntOption(37, this.mEnhancementType);
        this.mPlayer.setIntOption(38, this.mScaleType);
        StringBuilder sb = new StringBuilder();
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_PLAY_TYPE, 0);
        this.mPlayer.setIntOption(36, this.mLayoutType);
        this.mPlayer.setIntOption(110, 5000);
        this.mPlayer.setIntOption(64, 0);
        this.mPlayer.setIntOption(94, 1);
        this.mPlayer.setIntOption(56, this.mRenderType);
        _configLiveSettingBundle();
        _configWithSDKParams();
        configToBParams();
        LiveLoggerService liveLoggerService = this.mLogService;
        int i7 = this.mEnableFastOpenStream;
        liveLoggerService.mEnableFastOpenStream = i7;
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, i7);
        MyLog.i(TAG, "set fast open stream");
        this.mPlayer.setIntOption(56, this.mRenderType);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO, this.mEnableCheckDropAudio);
        this.mPlayer.setIntOption(52, this.mEnableUploadSei);
        if (this.mEnableDTSCheck == 1 || this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
            this.mPlayer.setIntOption(640, 1);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 1);
        if (this.mEnableClosePlayRetry == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 0);
            this.mPlayer.setIntOption(82, 0);
        }
        LiveLoggerService liveLoggerService2 = this.mLogService;
        liveLoggerService2.mHasAbrInfo = this.mHasAbrInfo;
        liveLoggerService2.mAbrStrategy = this.mAbrStrategy;
        liveLoggerService2.mEnableResolutionAutoDegrade = this.mEnableResolutionAutoDegrade;
        liveLoggerService2.mStallCountThresOfResolutionDegrade = this.mStallCountThresOfResolutionDegrade;
        long j4 = this.mStallRetryTimeIntervalManager;
        liveLoggerService2.mStallRetryTimeInterval = j4;
        this.mRetryProcessor.setStallRetryTimeInterval(j4);
        int i8 = this.mEnableSharp;
        if (i8 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, i8);
            LiveLoggerService liveLoggerService3 = this.mLogService;
            if (liveLoggerService3 != null) {
                liveLoggerService3.enableSharp();
            }
        }
        String str = null;
        if (this.mURLSource.getSourceType() == 2) {
            str = this.mURLSource.getVCodec(this.mResolution, this.mLevel);
        } else if (this.mURLSource.getSourceType() == 1 && (playLiveURL = this.mURLSource.getPlayLiveURL()) != null) {
            str = playLiveURL.getVCodec();
        }
        if (str != null) {
            if (str.equals("h264")) {
                this.mHardwareDecodeEnable = this.mEnableH264HardwareDecode;
                this.mDefaultCodecId = 0;
            } else if (str.equals("bytevc1")) {
                this.mHardwareDecodeEnable = this.mEnableByteVC1HardwareDecode;
                this.mDefaultCodecId = 1;
            } else {
                this.mHardwareDecodeEnable = 0;
            }
            this.mLogService.mUrlAbility = str;
        } else {
            this.mHardwareDecodeEnable = 0;
        }
        this.mHardwareDecodeEnable = 1;
        this.mEnableMediaCodecASYNCInit = 1;
        this.mPlayer.setIntOption(800, this.mEnableRtcPlay);
        if (this.mEnableRtcPlay == 1) {
            MyLog.i(TAG, "rtc close hardware decode");
            this.mPlayer.setIntOption(59, 0);
            this.mPlayer.setIntOption(181, 0);
            int i9 = (this.mHardwareRTCDecodeEnable == 1 && this.mHardwareDecodeEnable == 1) ? 1 : 0;
            MyLog.i(TAG, "rts decode mHardwareDecodeEnable:" + this.mHardwareDecodeEnable + ", mHardwareRTCDecodeEnable: " + this.mHardwareRTCDecodeEnable);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("rts decode  hardware decode ");
            sb2.append(i9 == 1 ? "True" : "False");
            MyLog.i(TAG, sb2.toString());
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, i9);
        } else {
            this.mPlayer.setIntOption(59, this.mHardwareDecodeEnable);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
            if (this.mHardwareDecodeEnable == 1) {
                MyLog.i(TAG, "enable hardware decode");
                if (this.mDefaultCodecId != -1) {
                    MyLog.i(TAG, "set hardware async init");
                    this.mPlayer.setIntOption(181, this.mEnableMediaCodecASYNCInit);
                    this.mPlayer.setIntOption(182, this.mDefaultCodecId);
                    LiveLoggerService liveLoggerService4 = this.mLogService;
                    liveLoggerService4.mMediaCodecAsyncInit = this.mEnableMediaCodecASYNCInit;
                    liveLoggerService4.mDefaultCodecID = this.mDefaultCodecId;
                }
            }
            this.mPlayer.setIntOption(97, this.mHardwareDecodeEnable);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_SIZE, 500000);
        }
        int i10 = this.mByteVC1DecoderType;
        if (i10 != -1 && this.mEnableByteVC1HardwareDecode != 1) {
            this.mPlayer.setIntOption(67, i10);
        }
        int i11 = this.mBufferTimeout;
        if (i11 != -1) {
            this.mPlayer.setIntOption(81, i11);
        }
        float f4 = this.mCatchSpeed;
        if (f4 > 0.0f) {
            this.mPlayer.setFloatOption(80, f4);
            this.mLogService.mCatchSpeed = this.mCatchSpeed;
        }
        if (this.mCacheFileEnable == -1 && this.mCacheFilePath != null) {
            String str2 = System.currentTimeMillis() + "";
            this.mCacheFileKey = str2;
            this.mPlayer.setStringOption(17, str2);
            this.mPlayer.setIntOption(14, 1);
            this.mPlayer.setCacheFile(this.mCacheFilePath, 1);
        }
        int i12 = this.mHurryType;
        if (i12 != -1) {
            this.mPlayer.setIntOption(84, i12);
            this.mLogService.mEnableHurry = true;
        }
        if (this.mHurryType == 0 && (i6 = this.mHurryTime) != 0) {
            this.mPlayer.setIntOption(15, i6);
            this.mLogService.mHurryTime = this.mHurryTime;
        }
        if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL) && (z3 = this.mLooping)) {
            this.mPlayer.setLooping(z3);
        }
        int i13 = this.mBufferDataSeconds;
        if (i13 != -1) {
            this.mPlayer.setIntOption(86, i13);
        }
        int i14 = this.mSlowPlayTime;
        if (i14 != -1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, i14);
            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
        }
        float f5 = this.mSlowPlaySpeed;
        if (f5 > 0.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f5);
            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
        }
        int i15 = this.mMaxCacheSeconds;
        if (i15 != -1) {
            this.mPlayer.setIntOption(24, i15);
            this.mPlayer.setIntOption(198, this.mMaxCacheSeconds);
            this.mLogService.mMaxCacheSeconds = this.mMaxCacheSeconds;
        }
        int i16 = this.mEnableSplitStream;
        if (i16 != 0) {
            this.mPlayer.setIntOption(87, i16);
            this.mLogService.mEnableSplitStream = this.mEnableSplitStream;
        }
        long j5 = this.mStartPlayBufferThres;
        if (j5 > 0) {
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, j5);
            this.mLogService.mStartPlayBufferThres = this.mStartPlayBufferThres;
        }
        int i17 = this.mCheckBufferingEndIgnoreVideo;
        if (i17 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, i17);
            this.mLogService.mCheckBufferingEndIgnoreVideo = this.mCheckBufferingEndIgnoreVideo;
        }
        int i18 = this.mStartDirectAfterPrepared;
        if (i18 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED, i18);
            this.mLogService.mStartDirectAfterPrepared = this.mStartDirectAfterPrepared;
        }
        int i19 = this.mCheckBufferingEndAdvanceEnable;
        if (i19 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END, i19);
            this.mLogService.mCheckBufferingEndAdvanceEnable = this.mCheckBufferingEndAdvanceEnable;
        }
        int i20 = this.mOpenCheckSideData;
        if (i20 == 1) {
            this.mPlayer.setIntOption(132, i20);
        }
        int i21 = this.mAudioTimescaleEnable;
        if (i21 != -1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE, i21);
            this.mLogService.mAudioTimescaleEnable = this.mAudioTimescaleEnable;
        }
        LiveLoggerService liveLoggerService5 = this.mLogService;
        liveLoggerService5.mEnableUploadSessionSeries = this.mEnableUploadSessionSeries;
        if (this.mEnableNTPTask == 1) {
            liveLoggerService5.openNTP();
        }
        if (this.mEnableOpenMDL == 1) {
            this.mLogService.mEnableOpenMDL = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderEnable);
            this.mLogService.mEnableP2P = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable);
            this.mLogService.mMDLVersion = MediaLoaderWrapper.getDataLoader().getStringValueFromLoader(11);
            this.mLogService.mEnableMdlProto = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102);
            MediaLoaderWrapper.getDataLoader().setListener(new MyMediaLoaderListener(this));
            if (!this.mIsMdlProtoRegister && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102) == 1) {
                long longValueFromLoader = MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
                if (longValueFromLoader != -1) {
                    this.mIsMdlProtoRegister = this.mPlayer.setLongOption(500, longValueFromLoader) == 0;
                }
                MyLog.i(TAG, "get mdl proto ret:" + longValueFromLoader + ", register ret:" + this.mIsMdlProtoRegister);
            }
        }
        this.mEnableOpenLiveIO = 0;
        this.mEnableLiveIOPlay = 0;
        this.mEnableRtcPlay = 0;
        long j6 = this.mALogWriteAddr;
        if (j6 != -1) {
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, j6);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 1);
        }
        String str3 = this.mStreamFormat;
        if (str3 != null) {
            this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str3);
        }
        String str4 = this.mStreamFormat;
        if (str4 != null && str4.equals(LiveConfigKey.AVPH)) {
            prepareAvphPlay();
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, this.mAVNoSyncThreshold);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, this.mIsAlwaysDoAVSync);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, this.mEnableRenderStall);
        if (this.mEnableRenderStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, mAudioRenderStallThreshold);
            this.mPlayer.setIntOption(322, mVideoRenderStallThreshold);
        }
        this.mPlayer.setIntOption(360, this.mEnableDemuxerStall);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, this.mNoSyncReportReportThres);
        if (this.mEnableDemuxerStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, mDemuxerStallThreshold);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, -1L);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, -1L);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, this.mEnableDecoderStall);
        if (this.mEnableDecoderStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, mDecoderStallThreshold);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, -1L);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, -1L);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, this.mEnableStallCounter);
        int i22 = this.mEnableTcpFastOpen;
        if (i22 == 1 && (mediaPlayer2 = this.mPlayer) != null) {
            this.mLogService.mEnableTcpFastOpen = i22;
            mediaPlayer2.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, i22);
            sb.append("live_enable_tcp_fast_open:1,");
        }
        MediaPlayer mediaPlayer3 = this.mPlayer;
        if (mediaPlayer3 != null) {
            int i23 = this.mEnableCmafFastMode;
            if (i23 == 1) {
                mediaPlayer3.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, i23);
                sb.append("live_enable_cmaf_fast_mode:1 ");
            }
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, this.mEnableCmafOptimizeRetry);
        }
        MediaPlayer mediaPlayer4 = this.mPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, this.mEnableVideoMpdRefresh);
        }
        int i24 = this.mEnableCheckPacketCorrupt;
        if (i24 == 1 && (mediaPlayer = this.mPlayer) != null) {
            mediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, i24);
            sb.append("live_enable_check_packet_corrupt:1,");
        }
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE)) {
            i4 = 1;
            if (this.mABRDisableAlgorithm == 1) {
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 1);
            }
        } else {
            i4 = 1;
        }
        if (this.mEnableFlvABR == i4) {
            sb.append("live_enable_flv_abr:1,");
        }
        if (this.mEnableOptimizeBackup == i4) {
            sb.append("live_enable_optimize_backup:1,");
        }
        if (this.mEnableStallRetryInstantly == i4) {
            sb.append("live_enable_stall_retry_instantly:1 ");
        } else {
            sb.append("live_enable_stall_retry_instantly:0 ");
        }
        if (this.mEnableCacheSei == i4) {
            sb.append("live_enable_sei_pts_sync:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, i4);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 1000);
        }
        if (this.mEnableDecodeMultiSei == i4) {
            sb.append("live_enable_decode_multi_sei:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, i4);
        }
        if (this.mEnableDecodeSeiOnce == i4) {
            sb.append("live_enable_decode_sei_once:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, i4);
        }
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            if (((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue() == i4) {
                sb.append("live_sdk_super_resolution_enable:1 ");
            } else {
                sb.append("live_sdk_super_resolution_enable:0 ");
            }
        }
        if (this.mEnableTextureRender == i4) {
            sb.append("live_sdk_texture_render_enable:1 ");
        } else {
            sb.append("live_sdk_texture_render_enable:0 ");
        }
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        if (iLiveSettingBundle2 != null) {
            i5 = 1;
            if (((Integer) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                sb.append("live_sdk_sharpen_enable:1 ");
            } else {
                sb.append("live_sdk_sharpen_enable:0 ");
            }
        } else {
            i5 = 1;
        }
        if (this.mEnableOpenLiveIO == i5) {
            sb.append("live_sdk_enable_liveio:1 ");
        }
        if (this.mEnableAudioVolumeBalance == i5) {
            sb.append("live_sdk_audio_volume_balance_enable:1 ");
            if (this.mAudioVolumeBalancePregain != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_pregain:" + this.mAudioVolumeBalancePregain + " ");
            }
            if (this.mAudioVolumeBalanceThreshold != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_threshold:" + this.mAudioVolumeBalanceThreshold + " ");
            }
            if (this.mAudioVolumeBalanceRatio != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_ratio:" + this.mAudioVolumeBalanceRatio + " ");
            }
            if (this.mAudioVolumeBalancePredelay != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_predelay:" + this.mAudioVolumeBalancePredelay + " ");
            }
        }
        if (this.mEnableNotifySeiImmediatelyBeforeFirstFrame == 1) {
            sb.append("live_sdk_notifysei_immediately_before_firstframe:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 1);
        }
        if (this.mEnableRadioLiveDisableRender == 1) {
            sb.append("live_sdk_enable_radiolive_disable_render:1 ");
        }
        if (this.mLogService.mHostNTPUrl != null) {
            sb.append("live_sdk_ntp_server_name:" + this.mLogService.mHostNTPUrl + " ");
        }
        if (this.mEnableReportSessionStop == 1) {
            sb.append("live_sdk_should_report_session_stop:1 ");
            this.mLogService.mEnableReportSessionStop = 1;
        }
        if (this.mUsePlayerRenderStart) {
            sb.append("live_sdk_texturerender_use_player_renderstart:1 ");
        }
        if (this.mEnableFreeFlow == 1) {
            sb.append("live_sdk_isfreeflow:1 ");
        }
        if (this.mEnableDroppingDTSRollFrame == 1) {
            sb.append("live_sdk_dropping_dts_rollback_frame_enabled:1 ");
            this.mPlayer.setIntOption(148, this.mEnableDroppingDTSRollFrame);
        }
        if (this.mEnableUseLiveThreadPool == 1) {
            sb.append("live_sdk_enable_use_live_threadpool:1 ");
        }
        LiveLoggerService liveLoggerService6 = this.mLogService;
        liveLoggerService6.mIsInMainLooper = this.mIsInMainLooper;
        liveLoggerService6.mSettingsInfo = sb.length() == 0 ? "none" : sb.deleteCharAt(sb.length() - 1).toString();
        if (!TextUtils.isEmpty(this.mStreamFormat) && (this.mStreamFormat.equals(LiveConfigKey.HLS) || this.mStreamFormat.equals(LiveConfigKey.TSL))) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, this.mHlsLiveStartIndex);
        }
        LiveLoggerService liveLoggerService7 = this.mLogService;
        liveLoggerService7.mEnableLowLatencyFLV = this.mEnableLowLatencyFLV;
        liveLoggerService7.mFastOpenDuration = mFastOpenDuration;
    }

    private void configPlayerInstanceOption() {
        String str;
        this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
        this.mLogService.setSdkParams(this.mURLSource.getSDKParams(this.mResolution, this.mLevel));
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && (str = this.mStreamFormat) != null) {
            mediaPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        if (mediaPlayer2 == null || this.mEnableAudioVolumeBalance != 1) {
            return;
        }
        mediaPlayer2.setIntOption(302, 1);
        float f4 = this.mAudioVolumeBalancePregain;
        if (f4 != -1.0f) {
            this.mPlayer.setFloatOption(303, f4);
        }
        float f5 = this.mAudioVolumeBalanceThreshold;
        if (f5 != -1.0f) {
            this.mPlayer.setFloatOption(304, f5);
        }
        float f6 = this.mAudioVolumeBalanceRatio;
        if (f6 != -1.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, f6);
        }
        float f7 = this.mAudioVolumeBalancePredelay;
        if (f7 != -1.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, f7);
        }
    }

    private void configToBParams() {
        MediaPlayer mediaPlayer;
        if (this.mSwitchToB != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setStringOption(509, this.mMoudleIDToB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertCodecName(int i4) {
        switch (i4) {
            case 1:
                return "IOSHWCodec";
            case 2:
                return "hardware_codec";
            case 3:
                return "ff_H264_codec";
            case 4:
                return "ff_ByteVC1_codec";
            case 5:
                return "KS_ByteVC1_codec";
            case 6:
                return "JX_ByteVC1_codec";
            default:
                return "none_codec";
        }
    }

    public static boolean dataLoaderIsRunning() {
        return MediaLoaderWrapper.getDataLoader().isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean degradeResolution() {
        String[] strArr;
        String playURLForResolution;
        if (this.mResolution == LiveConfigKey.LOW) {
            return false;
        }
        if (this.mResolutionIndex == -1) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = LiveConfigKey.resolution;
                if (i4 >= strArr2.length) {
                    break;
                } else if (strArr2[i4].equals(this.mResolution)) {
                    this.mResolutionIndex = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        int i5 = this.mResolutionIndex + 1;
        while (true) {
            strArr = LiveConfigKey.resolution;
            if (i5 >= strArr.length || this.mURLSource.isSupportResolution(strArr[i5])) {
                break;
            }
            i5++;
        }
        if (i5 < strArr.length && (playURLForResolution = this.mURLSource.getPlayURLForResolution(strArr[i5], this.mStreamFormat, this.mLevel)) != null) {
            String str = this.mCurrentPlayURL;
            this.mCurrentPlayURL = playURLForResolution;
            this.mResolutionIndex = i5;
            saveCurrentResolution();
            LiveLoggerService liveLoggerService = this.mLogService;
            String str2 = strArr[i5];
            this.mResolution = str2;
            liveLoggerService.mResolution = str2;
            String str3 = this.mCurrentPlayURL;
            liveLoggerService.onSwitch(str, str3, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
            ILiveListener iLiveListener = this.mListener;
            if (iLiveListener != null) {
                iLiveListener.onResolutionDegrade(this.mResolution);
            }
            this.mLogService.onSwitchURL(this.mCurrentPlayURL);
            this.mStallCount = 0;
            parsePlayDNS(playURLForResolution);
            return true;
        }
        return false;
    }

    public static void enableLoadLibrary() {
        MediaLoaderWrapper.getDataLoader().enableLoadLibrary();
    }

    private JSONObject extractAvphStreamInfo(String str) {
        String[] strArr;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = "audio_find_stream_info_cost";
        String str10 = "audio_open_input_cost";
        String str11 = "av_dts_diff";
        String str12 = "audio_cur_dts";
        String str13 = "video_last_dts";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str14 = "video_find_stream_info_cost";
            String[] split = str.split(",");
            int length = split.length;
            String str15 = "video_open_input_cost";
            int i4 = 0;
            while (i4 < length) {
                int i5 = length;
                String str16 = split[i4];
                if (str16.startsWith("video_key")) {
                    strArr = split;
                    jSONObject.put("video_key", Integer.parseInt(str16.substring(10)));
                } else {
                    strArr = split;
                    if (str16.startsWith(str13)) {
                        jSONObject.put(str13, Integer.parseInt(str16.substring(15)));
                    } else {
                        str2 = str13;
                        if (str16.startsWith("video_cur_dts")) {
                            jSONObject.put("video_cur_dts", Integer.parseInt(str16.substring(14)));
                        } else if (str16.startsWith("vv_dts_diff")) {
                            jSONObject.put("vv_dts_diff", Integer.parseInt(str16.substring(12)));
                        } else if (str16.startsWith(str12)) {
                            jSONObject.put(str12, Integer.parseInt(str16.substring(14)));
                        } else if (str16.startsWith(str11)) {
                            jSONObject.put(str11, Integer.parseInt(str16.substring(12)));
                        } else {
                            if (str16.startsWith("audio_first_pkt_ts")) {
                                str3 = str11;
                                str4 = str12;
                                jSONObject.put("audio_first_pkt_ts", Long.parseLong(str16.substring(19)));
                            } else {
                                str3 = str11;
                                str4 = str12;
                                if (str16.startsWith("audio_first_pkt_dts")) {
                                    jSONObject.put("audio_first_pkt_dts", Long.parseLong(str16.substring(20)));
                                } else if (str16.startsWith("video_first_pkt_ts")) {
                                    jSONObject.put("video_first_pkt_ts", Long.parseLong(str16.substring(19)));
                                } else if (str16.startsWith("video_first_pkt_dts")) {
                                    jSONObject.put("video_first_pkt_dts", Long.parseLong(str16.substring(20)));
                                } else if (str16.startsWith(str10)) {
                                    jSONObject.put(str10, Long.parseLong(str16.substring(22)));
                                } else if (str16.startsWith(str9)) {
                                    jSONObject.put(str9, Long.parseLong(str16.substring(28)));
                                } else {
                                    str5 = str15;
                                    if (str16.startsWith(str5)) {
                                        jSONObject.put(str5, Long.parseLong(str16.substring(22)));
                                        str7 = str9;
                                        str8 = str10;
                                        str6 = str14;
                                    } else {
                                        str6 = str14;
                                        if (str16.startsWith(str6)) {
                                            String substring = str16.substring(28);
                                            str7 = str9;
                                            str8 = str10;
                                            jSONObject.put(str6, Long.parseLong(substring));
                                        } else {
                                            str7 = str9;
                                            str8 = str10;
                                        }
                                    }
                                    i4++;
                                    str15 = str5;
                                    str14 = str6;
                                    str9 = str7;
                                    str10 = str8;
                                    length = i5;
                                    str13 = str2;
                                    str11 = str3;
                                    str12 = str4;
                                    split = strArr;
                                }
                            }
                            str7 = str9;
                            str8 = str10;
                            str6 = str14;
                            str5 = str15;
                            i4++;
                            str15 = str5;
                            str14 = str6;
                            str9 = str7;
                            str10 = str8;
                            length = i5;
                            str13 = str2;
                            str11 = str3;
                            str12 = str4;
                            split = strArr;
                        }
                        str7 = str9;
                        str8 = str10;
                        str3 = str11;
                        str4 = str12;
                        str6 = str14;
                        str5 = str15;
                        i4++;
                        str15 = str5;
                        str14 = str6;
                        str9 = str7;
                        str10 = str8;
                        length = i5;
                        str13 = str2;
                        str11 = str3;
                        str12 = str4;
                        split = strArr;
                    }
                }
                str8 = str10;
                str3 = str11;
                str4 = str12;
                str2 = str13;
                str6 = str14;
                str5 = str15;
                str7 = str9;
                i4++;
                str15 = str5;
                str14 = str6;
                str9 = str7;
                str10 = str8;
                length = i5;
                str13 = str2;
                str11 = str3;
                str12 = str4;
                split = strArr;
            }
            return jSONObject;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private JSONArray formatABRStreamInfoToJSONArray(String str) {
        if (str == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                JSONObject jSONObject = new JSONObject();
                int indexOf = str.indexOf("index:");
                int indexOf2 = str.indexOf(",pts_diff:");
                if (indexOf < 0 || indexOf2 < 0 || indexOf >= indexOf2) {
                    break;
                }
                jSONObject.put("index", Integer.parseInt(str.substring(indexOf + 6, indexOf2)));
                String substring = str.substring(indexOf2);
                int indexOf3 = substring.indexOf(",drop_dur:");
                if (indexOf3 < 0 || 10 >= indexOf3) {
                    break;
                }
                jSONObject.put("pts_diff", Long.parseLong(substring.substring(10, indexOf3)));
                String substring2 = substring.substring(indexOf3);
                int indexOf4 = substring2.indexOf(",key:");
                if (indexOf4 < 0 || 10 >= indexOf4) {
                    break;
                }
                jSONObject.put("drop_dur", Long.parseLong(substring2.substring(10, indexOf4)));
                String substring3 = substring2.substring(indexOf4);
                int indexOf5 = substring3.indexOf(",index:");
                if (indexOf5 == -1) {
                    if (substring3.length() != 0) {
                        String substring4 = substring3.substring(5);
                        jSONObject.put("key_frame", Integer.parseInt(substring4));
                        arrayList.add(jSONObject);
                        Log.i(TAG, "key: " + substring4);
                    }
                } else if (5 >= indexOf5) {
                    break;
                } else {
                    jSONObject.put("key_frame", Integer.parseInt(substring3.substring(5, indexOf5)));
                    arrayList.add(jSONObject);
                    str = substring3.substring(indexOf5 + 1);
                }
            }
            return new JSONArray((Collection) arrayList);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private JSONArray formatAVPHStreamInfoToJSONArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.contains(";")) {
            for (String str2 : str.split(";")) {
                JSONObject extractAvphStreamInfo = extractAvphStreamInfo(str2);
                if (extractAvphStreamInfo != null) {
                    arrayList.add(extractAvphStreamInfo);
                }
            }
        } else {
            JSONObject extractAvphStreamInfo2 = extractAvphStreamInfo(str);
            if (extractAvphStreamInfo2 != null) {
                arrayList.add(extractAvphStreamInfo2);
            }
        }
        return new JSONArray((Collection) arrayList);
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    private void open() {
        TTPlayerConfiger.setValue(1, this.mPlayerType != 0);
        TTPlayerConfiger.setValue(2, this.mPlayerType == 2);
        TTPlayerConfiger.setValue(6, false);
        TTPlayerConfiger.setValue(11, true);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isOSPlayer() ^ (this.mPlayerType == 0)) {
                this.mPlayer.releaseAsync();
                this.mPlayer = null;
            }
        }
        if (this.mPlayer == null) {
            this.mPlayer = MediaPlayerWrapper.create(this.mContext, this.mPlayerDegradeMode);
            MediaLoaderWrapper.getDataLoader().setMediaPlayer(this.mPlayer);
            if (this.mPlayer.getPlayerType() != 1 && this.mPlayer.getPlayerType() != 2) {
                this.mHardwareDecodeEnable = 0;
                this.mEnableH264HardwareDecode = 0;
                this.mEnableByteVC1HardwareDecode = 0;
            }
            configPlayerGlobalOption();
            configPlayerEventHandler();
        }
        if (this.mPlayer.isOSPlayer()) {
            this.mLogService.setPlayerSdkVersion("-1");
        } else {
            this.mLogService.setPlayerSdkVersion(TTPlayerConfiger.getValue(14, "0"));
        }
        this.mDnsParser.configure(this.mForceHttpDns, this.mHttpDNSServerHost);
        if (this.mFetcher == null) {
            this.mFetcher = new LiveDataFetcher(this.mExecutor, this.mNetworkClient);
        }
        this.mPlayerSetting.setPlayer(this.mPlayer);
    }

    private String packAvphHeader(String str, String str2, String str3) {
        if (!str.equals("")) {
            str = str + "&";
        }
        return ((str + str2) + "=") + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r3.equals(com.bykv.vk.component.ttvideo.LiveConfigKey.TLS) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parsePlayDNS(final java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.parsePlayDNS(java.lang.String):void");
    }

    private void parseResponseHeaders(LogBundle logBundle) {
        String[] split;
        String stringOption = this.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS);
        if (stringOption == null) {
            return;
        }
        for (String str : stringOption.split("\r\n")) {
            if (str.startsWith("X-Server-Ip: ")) {
                logBundle.headerXServerIP = str.split(": ", 2)[1];
            } else if (str.startsWith("Via: ")) {
                logBundle.headerVia = str.split(": ", 2)[1];
            }
        }
    }

    private void prepareAvphPlay() {
        this.mPlayer.setIntOption(159, this.mFramesDrop);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, this.mEnableSkipFindUnnecessaryStream);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, this.mAVPHDnsParseEnable);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, this.mAVPHDnsTimeout);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, this.mAVPHVideoProbesize);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, this.mAVPHVideoMaxDuration);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, this.mAVPHAudioProbesize);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, this.mAVPHAudioMaxDuration);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, this.mAVPHOpenVideoFirst);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF, this.mAVPHMaxAVDiff);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, this.mAVPHEnableAutoReopen);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, this.mAVPHAutoExit);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD, this.mAVPHVideoDiffThreshold);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, this.mAVPHReadRetryCount);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT, this.mAVPHReadErrorExit);
        String str = new String();
        String str2 = new String();
        if (this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
            str = packAvphHeader(str, "only_audio", "1");
        }
        if (this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO)) {
            str2 = packAvphHeader(str2, "only_video", "1");
        }
        this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY, str);
        this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, str2);
    }

    private String prepareLiveIOURL(String str, String str2, Map<String, String> map) {
        return str;
    }

    private String prepareProxyURL(String str, String str2, String str3, Map<String, String> map) {
        MyLog.i(TAG, "prepareProxy play url: " + str + ", host: " + str3);
        if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && this.mStreamFormat.equals(LiveConfigKey.FLV) && !this.mEnableResolutionAutoDegrade && !TextUtils.isEmpty(this.mSessionId)) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                try {
                    URL url = new URL(str);
                    String url2 = new URL(url.getProtocol(), str3, url.getPort() == -1 ? url.getDefaultPort() : url.getPort(), url.getFile()).toString();
                    MyLog.i(TAG, "prepareProxy proxy url: " + url2);
                    MyLog.i(TAG, "enable liveio:" + this.mEnableOpenLiveIO + " enable liveio play:" + this.mEnableLiveIOPlay);
                    MyLog.i(TAG, "live mdl enable_from_sdk:" + this.mEnableOpenMDL + " enable_from_app:" + MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderEnable) + " is_running:" + MediaLoaderWrapper.getDataLoader().isRunning());
                    if (this.mEnableOpenMDL == 1 && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderEnable) == 1 && MediaLoaderWrapper.getDataLoader().isRunning()) {
                        if (this.mALogWriteAddr != -1) {
                            MediaLoaderWrapper.getDataLoader().setLongValue(59, this.mALogWriteAddr);
                        }
                        this.mIsPlayWithMdl = true;
                        runOnCurrentThread(new PlayCacheSyncRunner(this, this.mSessionId, false));
                        MyLog.i(TAG, "setup mdl play cache sync runner of :" + this.mSessionId);
                        String proxyUrl = MediaLoaderWrapper.getDataLoader().getProxyUrl(url2, Boolean.valueOf(this.mIsMdlProtoRegister));
                        MyLog.i(TAG, "proxyUrl: " + proxyUrl);
                        if (proxyUrl != null && !proxyUrl.isEmpty()) {
                            map.put("Stream-Type", "live");
                            String str4 = this.mSessionId;
                            if (str4 != null) {
                                map.put("X-Tt-Traceid", str4);
                            }
                            if (str2 != null && !str2.equals("none")) {
                                if (str2.startsWith("[")) {
                                    str2 = str2.substring(1, str2.length() - 1);
                                }
                                map.put("X-Given-IPs", str2);
                            }
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", proxyUrl);
                                if (str2 != null) {
                                    jSONObject.put("ip", str2);
                                }
                                String str5 = this.mSessionId;
                                if (str5 != null) {
                                    jSONObject.put("traceId", str5);
                                }
                                MediaLoaderWrapper.getDataLoader().setStringValue(8017, jSONObject.toString());
                            } catch (Exception unused) {
                                MyLog.w(TAG, "set play info to mdl failed");
                            }
                            return proxyUrl;
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            return null;
        }
        String str6 = "proxy not support format: " + this.mStreamFormat + ", proto: " + this.mTransportProtocol + ", abr: " + this.mEnableResolutionAutoDegrade + ", sessio id invalid: " + TextUtils.isEmpty(this.mSessionId);
        MyLog.i(TAG, str6);
        this.mLogService.mLiveIOErrorMsg = str6;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:136:0x053f A[Catch: Exception -> 0x0765, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0630 A[Catch: Exception -> 0x0765, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0682 A[Catch: Exception -> 0x0765, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06f5 A[Catch: Exception -> 0x0765, TRY_LEAVE, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0731 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0732 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0511 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0390 A[Catch: Exception -> 0x0765, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03c5 A[Catch: Exception -> 0x0765, TRY_ENTER, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03d6 A[Catch: Exception -> 0x0765, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0414 A[Catch: Exception -> 0x0765, TryCatch #3 {Exception -> 0x0765, blocks: (B:68:0x038c, B:70:0x0390, B:71:0x0395, B:74:0x03a0, B:76:0x03a4, B:77:0x03b9, B:80:0x03c5, B:81:0x03cc, B:83:0x03d6, B:85:0x03ec, B:86:0x03f5, B:88:0x03f9, B:89:0x040c, B:91:0x0414, B:92:0x041b, B:94:0x0423, B:96:0x0427, B:98:0x0431, B:100:0x043a, B:102:0x0442, B:104:0x0452, B:106:0x045e, B:107:0x0463, B:112:0x04b7, B:113:0x04c0, B:115:0x04cc, B:117:0x04d0, B:118:0x04d7, B:120:0x04dc, B:121:0x04f0, B:123:0x04f4, B:124:0x04fb, B:126:0x04ff, B:128:0x050b, B:134:0x0537, B:136:0x053f, B:138:0x05b1, B:139:0x05c2, B:141:0x05c7, B:142:0x05e0, B:146:0x05f2, B:148:0x05fa, B:150:0x0629, B:152:0x0649, B:154:0x064e, B:156:0x0652, B:160:0x067b, B:162:0x0682, B:164:0x06a6, B:165:0x06c2, B:169:0x06ca, B:171:0x06f5, B:149:0x0614, B:151:0x0630, B:110:0x04a4), top: B:206:0x038c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepareToPlay(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 1934
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.prepareToPlay(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThread(Runnable runnable) {
        this.mMyHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThreadDelay(Runnable runnable, long j4) {
        this.mMyHandler.postDelayed(runnable, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnFrontCurrentThread(Runnable runnable) {
        this.mMyHandler.postAtFrontOfQueue(runnable);
    }

    private void saveCurrentResolution() {
        LiveLoggerService liveLoggerService;
        if (this.mLivePlayerState == LivePlayerState.IDLE || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.mLastResolution = this.mResolution.equals("auto") ? this.mLogService.mAutoUsingResolution : this.mResolution;
    }

    public static void setAppInfo(Context context, Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        AppInfo.mContext = context;
        AppInfo.mAppName = (String) map.get("app_name");
        Object obj = map.get("app_id");
        MyLog.i(TAG, "set appid:" + ((Integer) obj));
        if (obj != null) {
            AppInfo.mAppID = ((Integer) obj).intValue();
            MyLog.i(TAG, "set appid:" + AppInfo.mAppID);
        }
        AppInfo.mAppChannel = (String) map.get("app_channel");
        AppInfo.mAppVersion = (String) map.get("app_version");
        AppInfo.mDeviceId = (String) map.get("device_id");
    }

    public static void setDataLoaderListener(MediaLoaderListener mediaLoaderListener) {
        MediaLoaderWrapper.getDataLoader().setListener(mediaLoaderListener);
    }

    public static void setIntValue(int i4, int i5) {
        MediaLoaderWrapper.getDataLoader().setIntValue(i4, i5);
    }

    public static void setSettingsParam(Context context, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = (HashMap) map;
        hashMap.put("live_pull_sdk_version", Integer.valueOf(LiveUtils.versionStringToInt("1.4.6.31-lite")));
        hashMap.put("ttm_version", Integer.valueOf(LiveUtils.versionStringToInt(TTPlayerConfiger.getValue(14, ""))));
    }

    public static void startDataLoader(Context context) throws Exception {
        try {
            MediaLoaderWrapper.getDataLoader().start();
        } catch (Exception e4) {
            throw e4;
        }
    }

    private void startStallCounter() {
        synchronized (this.mStallCounterLock) {
            if (this.mStallCounterIsRunning) {
                return;
            }
            if (this.mStallCounterThread == null) {
                HandlerThread handlerThread = new HandlerThread("stallCounter");
                this.mStallCounterThread = handlerThread;
                handlerThread.start();
            }
            if (this.mStallCounterHandler == null) {
                this.mStallCounterHandler = new Handler(this.mStallCounterThread.getLooper());
            }
            this.mStallCounterHandler.post(this.mVideoStallCountTask);
            this.mStallCounterIsRunning = true;
        }
    }

    private void stopStallCounter() {
        synchronized (this.mStallCounterLock) {
            Handler handler = this.mStallCounterHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mStallCounterIsRunning = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchMainAndBackupUrl(int i4) {
        if (this.mLevel.equals("main")) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, LiveConfigKey.BACKUP);
            if (playURLForResolution != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution, "main_to_backup", i4);
                this.mLogService.onSwitchURL(playURLForResolution);
                this.mCurrentPlayURL = playURLForResolution;
                this.mLevel = LiveConfigKey.BACKUP;
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution);
                this.mStallCount = 0;
                return true;
            }
        } else if (this.mLevel.equals(LiveConfigKey.BACKUP)) {
            String playURLForResolution2 = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, "main");
            if (playURLForResolution2 != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution2, "backup_to_main", i4);
                this.mLogService.onSwitchURL(playURLForResolution2);
                this.mCurrentPlayURL = playURLForResolution2;
                this.mLevel = "main";
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution2);
                this.mStallCount = 0;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadSizeStat() {
        long longOption = this.mPlayer.getLongOption(45, 0L);
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mLastTotalDownloadSize += longOption;
        long j4 = liveLoggerService.mLastDownloadSizeDelta;
        if (!liveLoggerService.mHaveResetPlayer) {
            liveLoggerService.mLastDownloadSizeDelta = longOption - liveLoggerService.getPlayingDownloadSize();
            this.mLogService.mHaveResetPlayer = true;
            return;
        }
        liveLoggerService.mLastDownloadSizeDelta = longOption + j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSessionFirstFrameInfo() {
        MediaPlayer mediaPlayer;
        LogBundle logBundle = this.mLogService.mSessionLogBundle;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.downloadSpeedOnFirstFrame = (mediaPlayer.getLongOption(63, 0L) * 8) / 1000;
        this.mLogService.mSessionLogBundle.videoBufferTimeOnFirstFrame = this.mPlayer.getLongOption(72, 0L);
        this.mLogService.mSessionLogBundle.audioBufferTimeOnFirstFrame = this.mPlayer.getLongOption(73, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void _setAvLines() {
        /*
            r6 = this;
            java.lang.String r0 = "AudioOnly"
            java.lang.String r1 = "VideoOnly"
            java.lang.String r2 = "IsEnable"
            com.bykv.vk.component.ttvideo.model.LiveInfoSource r3 = r6.mURLSource
            java.lang.String r4 = r6.mResolution
            java.lang.String r5 = r6.mLevel
            java.lang.String r3 = r3.getAvLinesParams(r4, r5)
            if (r3 != 0) goto L13
            return
        L13:
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L42
            r5.<init>(r3)     // Catch: org.json.JSONException -> L42
            boolean r3 = r5.has(r2)     // Catch: org.json.JSONException -> L42
            if (r3 == 0) goto L24
            java.lang.String r2 = r5.optString(r2)     // Catch: org.json.JSONException -> L42
            goto L25
        L24:
            r2 = r4
        L25:
            boolean r3 = r5.has(r1)     // Catch: org.json.JSONException -> L3f
            if (r3 == 0) goto L30
            java.lang.String r1 = r5.optString(r1)     // Catch: org.json.JSONException -> L3f
            goto L31
        L30:
            r1 = r4
        L31:
            boolean r3 = r5.has(r0)     // Catch: org.json.JSONException -> L3d
            if (r3 == 0) goto L48
            java.lang.String r0 = r5.optString(r0)     // Catch: org.json.JSONException -> L3d
            r4 = r0
            goto L48
        L3d:
            r0 = move-exception
            goto L45
        L3f:
            r0 = move-exception
            r1 = r4
            goto L45
        L42:
            r0 = move-exception
            r1 = r4
            r2 = r1
        L45:
            r0.printStackTrace()
        L48:
            if (r2 == 0) goto L4c
            r6.mEnableAvLines = r2
        L4c:
            if (r1 == 0) goto L50
            r6.mVideoOnly = r1
        L50:
            if (r4 == 0) goto L54
            r6.mAudioOnly = r4
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager._setAvLines():void");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeDNS() {
        this.mEnableDns = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeSeiCheck() {
        this.mEnableSeiCheck = false;
        this.mLogService.mEnableSeiCheck = false;
    }

    public boolean disableSR(int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            arrayList = (ArrayList) iLiveSettingBundle.getSettingsValueForKey("live_sdk_sr_resolution_block_list", new ArrayList());
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split("x");
                if (split.length < 2) {
                    return false;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (i4 == parseInt && i5 == parseInt2) {
                    return true;
                }
            }
        }
        return false;
    }

    void doResolutionChange(String str) {
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableSeiCheck() {
        this.mEnableSeiCheck = true;
        this.mLogService.mEnableSeiCheck = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableUploadSessionSeries() {
        this.mEnableUploadSessionSeries = true;
        this.mLogService.mEnableUploadSessionSeries = true;
    }

    public void frameDTSNotify(int i4, long j4, long j5) {
        if (this.mEnableCheckFrame == 1 && i4 == 0 && this.mResolution.equals(LiveConfigKey.ORIGIN)) {
            this.mLogService.feedVideoDTS(j4);
        }
        if (i4 == 1 && this.mEnableDTSCheck == 1) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService.mFirstAudioPacketDTS < 0) {
                liveLoggerService.mFirstAudioPacketDTS = j4;
            } else {
                long j6 = this.mLatestAudioPacketDTS;
                if (j4 < j6) {
                    liveLoggerService.onAudioDTSRollback(j6, j4);
                }
            }
            this.mLatestAudioPacketDTS = j4;
        }
    }

    public int getEnableSR() {
        return this.mEnableTextureSR;
    }

    public int getEnableTexturerender() {
        return this.mEnableTextureRender;
    }

    public long getIntOption(int i4, long j4) {
        if (i4 == 0) {
            MediaPlayer mediaPlayer = this.mPlayer;
            return mediaPlayer != null ? (mediaPlayer.getLongOption(63, 0L) * 8) / 1000 : j4;
        } else if (i4 == 68) {
            MediaPlayer mediaPlayer2 = this.mPlayer;
            return mediaPlayer2 != null ? (mediaPlayer2.getLongOption(63, 0L) * 8) / 1000 : j4;
        } else if (i4 != 78) {
            return i4 != 79 ? j4 : this.mTslMinTimeShit;
        } else {
            MediaPlayer mediaPlayer3 = this.mPlayer;
            return mediaPlayer3 != null ? mediaPlayer3.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, 0) : j4;
        }
    }

    public void getLastRenderTime() {
        if (this.mIsRetrying || this.mIsStalling) {
            return;
        }
        this.mVideoLastRenderTime = this.mPlayer.getLongOption(320, -1L);
        this.mAudioLastRenderTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0402  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getLogInfo(com.bykv.vk.component.ttvideo.log.LogBundle r17, int r18) {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.getLogInfo(com.bykv.vk.component.ttvideo.log.LogBundle, int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getMaxVolume() {
        return this.mPlayerSetting.getMaxVolume();
    }

    public long getNtpTimeDiff() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            return ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
        }
        return 0L;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getPlayerErrorInfo() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null ? mediaPlayer.getStringOption(5002) : "none";
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getPlayerVolume() {
        return this.mPlayerSetting.getPlayerVolume();
    }

    public boolean getSRState() {
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public long getSeiDelay() {
        return this.mLogService.getInt64Value(100, 0L);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getServerIP() {
        return this.mCurrentIP;
    }

    public void getSessionlogInfo(LogBundle logBundle) {
        MediaPlayer mediaPlayer;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.playerDNSTimestamp = mediaPlayer.getLongOption(68, -1L);
        logBundle.tfoFallBackTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, -1L);
        logBundle.dropAudioPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, -1L);
        logBundle.dropAudioCostTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, -1L);
        logBundle.tcpConnectTimestamp = this.mPlayer.getLongOption(69, -1L);
        logBundle.tcpFirstPacketTimestamp = this.mPlayer.getLongOption(70, -1L);
        logBundle.videoPacketTimestamp = this.mPlayer.getLongOption(75, -1L);
        logBundle.audioPacketTimestamp = this.mPlayer.getLongOption(76, -1L);
        logBundle.videoDecodeTimestamp = this.mPlayer.getLongOption(77, -1L);
        logBundle.audioDecodeTimestamp = this.mPlayer.getLongOption(78, -1L);
        logBundle.videoDeviceOpenTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, -1L);
        logBundle.videoDeviceOpenedTime = this.mPlayer.getLongOption(162, -1L);
        logBundle.audioDeviceOpenTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, -1L);
        logBundle.audioDeviceOpenedTime = this.mPlayer.getLongOption(163, -1L);
        logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
        logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
        logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
        logBundle.resolution = this.mResolution;
        logBundle.videoParamSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, 0L);
        logBundle.firstVideoFrameSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 0L);
        logBundle.renderType = this.mPlayer.getVideoType();
        logBundle.streamInfoFindTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 0L);
        logBundle.streamInfoFoundTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, 0L);
        logBundle.videoDeviceWaitStartTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 0L);
        logBundle.videoDeviceWaitEndTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 0L);
        logBundle.videoFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, -1L);
        logBundle.videoFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, -1L);
        logBundle.audioFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS, -1L);
        logBundle.audioFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, -1L);
        logBundle.httpReqFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 0L);
        logBundle.httpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, 0L);
        logBundle.downloadSize = this.mPlayer.getLongOption(45, 0L);
    }

    public boolean getSharpenState() {
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public JSONObject getStaticLog() {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService == null) {
            return null;
        }
        return liveLoggerService.getStaticLog();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getStringOption(int i4, String str) {
        if (i4 == 57) {
            str = this.mCurrentPlayURL;
        } else if (i4 == 58) {
            str = this.mResolution;
        } else if (i4 == 60) {
            str = this.mStreamFormat;
        } else if (i4 == 65) {
            str = this.mAbrStrategy;
        }
        MyLog.i(TAG, "getStringOption: " + str);
        return str;
    }

    public int getUrlSettingMethod() {
        return this.mUrlSettingMethod;
    }

    public void getVideoCodecType() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || this.mLogService == null) {
            return;
        }
        int intOption = mediaPlayer.getIntOption(141, -1);
        if (intOption == 0) {
            this.mLogService.setCodecType("h264");
        } else if (intOption == 1) {
            this.mLogService.setCodecType("bytevc1");
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getVolume() {
        return this.mPlayerSetting.getVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isIPPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.getPlayerType() == 2;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isOsPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public boolean isRtcPlayAvailable() {
        return this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 0;
    }

    public boolean isUsedSR() {
        return false;
    }

    public boolean isUsedSharpen() {
        return false;
    }

    public JSONObject liveInfoItems() {
        try {
            JSONObject liveInfoItems = this.mLogService.getLiveInfoItems();
            liveInfoItems.put("get_live_info_iterms", "OK");
            return liveInfoItems;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void onRenderStallForRetryStop() {
        if ((this.mIsStalling || this.mIsRetrying) && this.mEnableRenderStall == 1) {
            if (this.mAudioLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mAudioLastRenderTime), 0, false, false);
            }
            if (this.mVideoLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mVideoLastRenderTime), 0, true, false);
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void openNTP() {
        this.mEnableNTPTask = 1;
        this.mLogService.openNTP();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void pause() {
        MyLog.i(TAG, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        checkMainLooper(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mLivePlayerState = LivePlayerState.PAUSED;
        this.mPlayer.pause();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void play() {
        String str;
        ILiveListener iLiveListener = this.mListener;
        iLiveListener.onReportALog(4, "play start -- " + hashCode());
        checkMainLooper("play");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        LivePlayerState livePlayerState2 = LivePlayerState.PLAYED;
        if (livePlayerState == livePlayerState2) {
            this.mLogService.onIllegalAPICall("play");
            ILiveListener iLiveListener2 = this.mListener;
            iLiveListener2.onReportALog(6, "illegal call: play -- " + hashCode());
        } else if (livePlayerState == LivePlayerState.PAUSED) {
            this.mLivePlayerState = livePlayerState2;
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        } else {
            MyLog.i(TAG, "play");
            if (this.mURLSource.getSourceType() == 2) {
                _configAbrInfo();
                _setStreamFormat();
                _setProtocol();
                _checkStreamData();
            }
            ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
            if (iLiveSettingBundle != null) {
                this.mURLSource.setEnableSR(((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue());
                setIntOption(69, ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_texture_render_enable", 0)).intValue());
                if (((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                    JSONObject sharpenParams = this.mURLSource.getSharpenParams(this.mResolution, this.mLevel);
                    this.mSharpenSdkParams = sharpenParams;
                    if (sharpenParams != null) {
                        this.mEnableSharpen = sharpenParams.optInt("Enabled");
                    }
                }
            }
            setIntOption(70, this.mURLSource.getSREnabled(this.mResolution, this.mLevel) ? 1 : 0);
            this.mLivePlayerState = livePlayerState2;
            this.mFrameTerminatedDTS = -1L;
            this.mLatestAudioPacketDTS = -1L;
            String str2 = null;
            LiveInfoSource liveInfoSource = this.mURLSource;
            if (liveInfoSource != null) {
                if (liveInfoSource.getSourceType() == 1 && this.mURLSource.getPlayLiveURL() != null) {
                    str2 = this.mURLSource.getPlayLiveURL().mainURL;
                    String str3 = this.mIsLocalURL ? this.mLocalURL : str2;
                    if (str3 != null) {
                        if (str3.startsWith("http")) {
                            this.mTransportProtocol = LiveConfigKey.TCP;
                        }
                        if (str3.startsWith("https")) {
                            this.mTransportProtocol = LiveConfigKey.TLS;
                        }
                        if (str3.startsWith("httpk")) {
                            this.mTransportProtocol = LiveConfigKey.KCP;
                        }
                        this.mURLProtocol = this.mTransportProtocol;
                    }
                    if (this.mQuicPull) {
                        try {
                            LibraryLoader.loadLibrary("ttquic");
                            this.mQuicEnable = true;
                            MyLog.i(TAG, "ttquic lib is load success");
                            this.mLogService.setQuicLibLoader(1);
                            str = LiveConfigKey.QUIC;
                        } catch (Throwable unused) {
                            String str4 = this.mTransportProtocol;
                            this.mQuicEnable = false;
                            MyLog.i(TAG, "ttquic lib is load failed. change default protocol");
                            this.mLogService.setQuicLibLoader(0);
                            str = str4;
                        }
                    } else {
                        str = "";
                    }
                    if (str.isEmpty()) {
                        str = this.mTransportProtocol;
                    }
                    this.mTransportProtocol = str;
                } else if (this.mURLSource.getSourceType() == 2) {
                    str2 = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
                }
            }
            if (this.mIsLocalURL) {
                str2 = this.mLocalURL;
            }
            if (str2 != null) {
                String sessionID = this.mURLSource.getSessionID();
                this.mUuid = sessionID;
                if (TextUtils.isEmpty(sessionID)) {
                    this.mUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                }
                this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
                this.mLogService.reset();
                LiveLoggerService liveLoggerService = this.mLogService;
                liveLoggerService.mSessionId = this.mUuid + "." + System.currentTimeMillis();
                this.mLogService.mRuleIds = this.mURLSource.getRuleIds();
                LiveLoggerService liveLoggerService2 = this.mLogService;
                liveLoggerService2.mResolution = this.mResolution;
                liveLoggerService2.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                this.mLogService.onPlay(this.mIsLocalURL ? this.mLocalURL : str2, this.mDnsParser.getDNSServerIP());
                _play(str2);
                this.mRetryProcessor.start();
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("url", "no playurl found while play");
                this.mRetryProcessor.onError(new LiveError(-100002, "playURL is null", hashMap), this.mShowedFirstFrame);
            }
            if (this.mEnableStallCounter == 1) {
                startStallCounter();
            }
            ILiveListener iLiveListener3 = this.mListener;
            iLiveListener3.onReportALog(4, "play end -- " + hashCode());
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean playResolution(String str) {
        MyLog.i(TAG, "playResolution:" + str);
        checkMainLooper("playResolution");
        if (this.mURLSource.getSourceType() == 2 && this.mPrepareState == PlayerState.PREPARED) {
            if (this.mResolution.equals(str)) {
                MyLog.i(TAG, "playResolution: same res=" + str);
                return true;
            }
            this.mRetryProcessor.reset();
            this.mResolutionIndex = -1;
            this.mStallCount = 0;
            LiveLoggerService liveLoggerService = this.mLogService;
            String str2 = this.mCurrentPlayURL;
            liveLoggerService.onSwitch(str2, "none", "setting_" + this.mResolution + "_to_" + str, 0);
            LiveLoggerService liveLoggerService2 = this.mLogService;
            liveLoggerService2.mAbrSwitchInfo = "manual_abr_" + this.mResolution + "_to_" + str;
            saveCurrentResolution();
            this.mResolution = str;
            if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || (this.mAbrStrategy.equals(LiveConfigKey.RAD) && !str.equals("auto"))) {
                String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
                if (TextUtils.isEmpty(playURLForResolution)) {
                    MyLog.w(TAG, "" + str + " playUrl not exist");
                    return false;
                }
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                _stopPlayer();
                _resetPlayer();
                this.mLogService.onSwitchURL(playURLForResolution);
                this.mUserSwitchResoultion = true;
                this.mLogService.mSessionStartTime = System.currentTimeMillis();
                parsePlayDNS(playURLForResolution);
            }
            return true;
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void release() {
        MyLog.i(TAG, "release start");
        ILiveListener iLiveListener = this.mListener;
        iLiveListener.onReportALog(4, "release start -- " + hashCode());
        checkMainLooper("release");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            _stop(true, "release");
        }
        releaseTextureRenderRef();
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        MyLog.i(TAG, "release end");
        ILiveListener iLiveListener2 = this.mListener;
        iLiveListener2.onReportALog(4, "release end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void releaseAsync() {
        ILiveListener iLiveListener = this.mListener;
        iLiveListener.onReportALog(4, "releaseAsync start -- " + hashCode());
        MyLog.i(TAG, "releaseAsync");
        checkMainLooper("releaseAsync");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            _stop(false, "releaseAsync");
        }
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (this.mSurfaceHolder != null) {
            mediaPlayer.setDisplay(null);
        }
        releaseTextureRenderRef();
        MediaPlayer mediaPlayer2 = this.mPlayer;
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        LiveThreadPool.addExecuteTask(new MyReleaseRunnable(mediaPlayer2));
        MyLog.i(TAG, "releaseAsync end");
        ILiveListener iLiveListener2 = this.mListener;
        iLiveListener2.onReportALog(4, "releaseAsync end -- " + hashCode());
    }

    public void releaseTextureRenderRef() {
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void reset() {
        MyLog.i(TAG, "reset");
        checkMainLooper("reset");
        if (this.mPlayer == null) {
            return;
        }
        _reset("reset");
        this.mLogService.reset();
        this.mCacheFileKey = null;
        this.mCacheFilePath = null;
        this.mEnableResolutionAutoDegrade = false;
        this.mEnableOriginResolution = false;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mTextureSRMode = 0;
        this.mResolution = LiveConfigKey.ORIGIN;
        this.mResolutionIndex = -1;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mLevel = "main";
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mEnableHurryFlag = 0;
        this.mHurryType = -1;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mShowedFirstFrame = false;
        this.mEnableLLASHFastOpen = 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setAsyncInit(int i4) {
        MyLog.d(TAG, String.format("setAsyncInit enable:%b", Integer.valueOf(i4)));
        this.mEnableMediaCodecASYNCInit = i4;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setCommonFlag(String str) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setCommonFlag(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setDisableVideoRender(Boolean bool) {
        MediaPlayer mediaPlayer;
        MyLog.i(TAG, "setDisableVideoRender: " + bool);
        this.mLogService.mDisableVideoRender = bool.booleanValue() ? 1 : 0;
        if (this.mEnableRadioLiveDisableRender != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, bool.booleanValue() ? 1 : 0);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setFloatOption(int i4, float f4) {
        String str = "";
        if (i4 != 19) {
            if (i4 == 20) {
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, slow_speed:" + f4;
                } else {
                    str = "slow_speed:" + f4;
                    this.mSlowPlaySpeed = f4;
                    MediaPlayer mediaPlayer = this.mPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f4);
                        this.mLogService.mSlowSpeed = f4;
                    }
                }
            }
        } else if (this.mEnableLowLatencyFLV == 1) {
            str = "invalid settings on low latency flv, catch_speed:" + f4;
        } else {
            str = "catch_speed:" + f4;
            this.mCatchSpeed = f4;
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setFloatOption(80, f4);
                this.mLogService.mCatchSpeed = f4;
            }
        }
        MyLog.i(TAG, "setFloatOption " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setIntOption(int i4, int i5) {
        String str = "";
        switch (i4) {
            case 1:
                str = "image_enhancement:" + i5;
                this.mEnhancementType = i5;
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setIntOption(37, i5);
                    break;
                }
                break;
            case 2:
                str = "image_scale:" + i5;
                this.mScaleType = i5;
                MediaPlayer mediaPlayer2 = this.mPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setIntOption(38, i5);
                    break;
                }
                break;
            case 3:
                str = "forbid_os_player:" + i5;
                TTPlayerConfiger.setValue(11, i5);
                break;
            case 4:
                str = "image_layout:" + i5;
                this.mLayoutType = i5;
                MediaPlayer mediaPlayer3 = this.mPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setIntOption(36, i5);
                    break;
                }
                break;
            case 5:
                str = "render_type:" + i5;
                this.mRenderType = i5;
                MediaPlayer mediaPlayer4 = this.mPlayer;
                if (mediaPlayer4 != null) {
                    mediaPlayer4.setIntOption(56, i5);
                    break;
                }
                break;
            case 7:
                str = "hard_decode:" + i5;
                this.mHardwareDecodeEnable = i5;
                MediaPlayer mediaPlayer5 = this.mPlayer;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.setIntOption(59, i5);
                    break;
                }
                break;
            case 8:
                str = "enable_cache_file:" + i5;
                this.mCacheFileEnable = i5;
                MediaPlayer mediaPlayer6 = this.mPlayer;
                if (mediaPlayer6 != null) {
                    mediaPlayer6.setIntOption(14, 1);
                    break;
                }
                break;
            case 9:
                str = "bytevc1_decoder_type:" + i5;
                this.mByteVC1DecoderType = i5;
                MediaPlayer mediaPlayer7 = this.mPlayer;
                if (mediaPlayer7 != null) {
                    mediaPlayer7.setIntOption(67, i5);
                    break;
                }
                break;
            case 10:
                str = "buffering_millSeconds:" + i5;
                this.mBufferDataSeconds = i5;
                MediaPlayer mediaPlayer8 = this.mPlayer;
                if (mediaPlayer8 != null) {
                    mediaPlayer8.setIntOption(86, i5);
                    break;
                }
                break;
            case 11:
                str = "buffering_timeout:" + i5;
                this.mBufferTimeout = i5;
                MediaPlayer mediaPlayer9 = this.mPlayer;
                if (mediaPlayer9 != null) {
                    mediaPlayer9.setIntOption(81, i5);
                    break;
                }
                break;
            case 12:
                str = "network_timeout:" + i5;
                this.mNetworkTimeout = i5;
                MediaPlayer mediaPlayer10 = this.mPlayer;
                if (mediaPlayer10 != null) {
                    mediaPlayer10.setIntOption(9, i5 * 1000000);
                    break;
                }
                break;
            case 15:
                str = "use_external_dir:" + i5;
                this.mUseExternalDir = i5;
                break;
            case 16:
                str = "use_test_action:" + i5;
                this.mTestAction = i5;
                MediaPlayer mediaPlayer11 = this.mPlayer;
                if (mediaPlayer11 != null) {
                    mediaPlayer11.setIntOption(83, i5);
                    break;
                }
                break;
            case 17:
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, hurry_time:" + i5;
                    break;
                } else {
                    str = "hurry_time:" + i5;
                    this.mHurryTime = i5;
                    MediaPlayer mediaPlayer12 = this.mPlayer;
                    if (mediaPlayer12 != null) {
                        mediaPlayer12.setIntOption(15, i5);
                        this.mLogService.mHurryTime = i5;
                        break;
                    }
                }
                break;
            case 18:
                str = "hurry_type:" + i5;
                this.mHurryType = i5;
                MediaPlayer mediaPlayer13 = this.mPlayer;
                if (mediaPlayer13 != null) {
                    mediaPlayer13.setIntOption(84, i5);
                    break;
                }
                break;
            case 21:
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, slow_play_time:" + i5;
                    break;
                } else {
                    str = "slow_play_time:" + i5;
                    this.mSlowPlayTime = i5;
                    MediaPlayer mediaPlayer14 = this.mPlayer;
                    if (mediaPlayer14 != null) {
                        mediaPlayer14.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, i5);
                        this.mLogService.mSlowPlayTime = i5;
                        break;
                    }
                }
                break;
            case 22:
                str = "check side data" + i5;
                this.mOpenCheckSideData = i5;
                MediaPlayer mediaPlayer15 = this.mPlayer;
                if (mediaPlayer15 != null) {
                    mediaPlayer15.setIntOption(132, i5);
                    break;
                }
                break;
            case 25:
                str = "player_degrade_mode:" + i5;
                this.mPlayerDegradeMode = i5;
                break;
            case 31:
                str = "url_ability:" + i5;
                this.mURLAbility = i5;
                if (i5 != 1) {
                    if (i5 == 2) {
                        this.mLogService.mUrlAbility = "bytevc1";
                        break;
                    }
                } else {
                    this.mLogService.mUrlAbility = "h264";
                    break;
                }
                break;
            case 32:
                str = "enable_sharp:" + i5;
                this.mEnableSharp = i5;
                break;
            case 33:
                str = "asyncInit:" + i5;
                this.mEnableMediaCodecASYNCInit = i5;
                MediaPlayer mediaPlayer16 = this.mPlayer;
                if (mediaPlayer16 != null && this.mHardwareDecodeEnable == 1) {
                    mediaPlayer16.setIntOption(181, i5);
                    this.mLogService.mMediaCodecAsyncInit = i5;
                    break;
                }
                break;
            case 34:
                str = "defaultCodecID:" + i5;
                this.mDefaultCodecId = i5;
                MediaPlayer mediaPlayer17 = this.mPlayer;
                if (mediaPlayer17 != null) {
                    mediaPlayer17.setIntOption(182, i5);
                    this.mLogService.mDefaultCodecID = i5;
                    break;
                }
                break;
            case 35:
                str = "enable 264 hardware decode " + i5;
                this.mEnableH264HardwareDecode = i5;
                break;
            case 36:
                str = "enable bytevc1 hardware decode " + i5;
                this.mEnableByteVC1HardwareDecode = i5;
                break;
            case 37:
                str = "set max cache" + i5;
                this.mMaxCacheSeconds = i5;
                MediaPlayer mediaPlayer18 = this.mPlayer;
                if (mediaPlayer18 != null) {
                    mediaPlayer18.setIntOption(198, i5);
                    this.mLogService.mMaxCacheSeconds = i5;
                    break;
                }
                break;
            case 38:
                str = "enable test split " + i5;
                this.mEnableSplitStream = i5;
                MediaPlayer mediaPlayer19 = this.mPlayer;
                if (mediaPlayer19 != null) {
                    mediaPlayer19.setIntOption(87, i5);
                    this.mLogService.mEnableSplitStream = i5;
                    break;
                }
                break;
            case 39:
                str = "enable httpk degrade:" + i5;
                this.mEnableHttpkDegrade = i5;
                break;
            case 40:
                str = "enable fast open:" + i5;
                this.mEnableFastOpenStream = i5;
                break;
            case 41:
                str = "enable upload sei:" + i5;
                this.mEnableUploadSei = i5;
                break;
            case 42:
                str = "enable NTP:" + i5;
                this.mEnableNTPTask = i5;
                break;
            case 44:
                str = "set in main looper:" + i5;
                this.mIsInMainLooper = i5;
                break;
            case 46:
                str = "buffering end ignore video:" + i5;
                this.mCheckBufferingEndIgnoreVideo = i5;
                MediaPlayer mediaPlayer20 = this.mPlayer;
                if (mediaPlayer20 != null) {
                    mediaPlayer20.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, i5);
                    this.mLogService.mCheckBufferingEndIgnoreVideo = i5;
                    break;
                }
                break;
            case 47:
                str = "start direct:" + i5;
                this.mStartDirectAfterPrepared = i5;
                MediaPlayer mediaPlayer21 = this.mPlayer;
                if (mediaPlayer21 != null) {
                    mediaPlayer21.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED, i5);
                    this.mLogService.mStartDirectAfterPrepared = i5;
                    break;
                }
                break;
            case 48:
                str = "enable mediaLoader:" + i5;
                this.mEnableOpenMDL = i5;
                break;
            case 54:
                str = "check buffering end advance:" + i5;
                this.mCheckBufferingEndAdvanceEnable = i5;
                MediaPlayer mediaPlayer22 = this.mPlayer;
                if (mediaPlayer22 != null) {
                    mediaPlayer22.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END, i5);
                    this.mLogService.mCheckBufferingEndAdvanceEnable = i5;
                    break;
                }
                break;
            case 55:
                str = "set stall count thre:" + i5;
                this.mStallCountThresOfResolutionDegrade = i5;
                break;
            case 56:
                str = "enable resolution degrade:" + i5;
                this.mEnableResolutionAutoDegrade = i5 == 1;
                break;
            case 61:
                str = "enable tcp fast open:" + i5;
                this.mEnableTcpFastOpen = i5;
                MediaPlayer mediaPlayer23 = this.mPlayer;
                if (mediaPlayer23 != null) {
                    mediaPlayer23.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, i5);
                    break;
                }
                break;
            case 62:
                str = "enable check packet corrupt:" + i5;
                this.mEnableCheckPacketCorrupt = i5;
                MediaPlayer mediaPlayer24 = this.mPlayer;
                if (mediaPlayer24 != null) {
                    mediaPlayer24.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, i5);
                    break;
                }
                break;
            case 67:
                str = "enable flv abr:" + i5;
                this.mEnableFlvABR = i5;
                break;
            case 69:
                str = "enable texture render:" + i5;
                this.mEnableTextureRender = i5;
                break;
            case 70:
                str = "enable texture sr:" + i5;
                this.mEnableTextureSR = i5;
                break;
            case 77:
                str = "tsl time shift:" + i5;
                this.mTslTimeShift = i5;
                this.mLogService.mTslTimeShift = i5;
                break;
            case 80:
                str = "toB switch :" + i5;
                this.mSwitchToB = i5;
                break;
            case 82:
                str = "enable mult_sei:" + i5;
                this.mEnableDecodeMultiSei = i5;
                break;
            case 83:
                this.mHurryTime = i5;
                str = "hurry_time:" + i5;
                MediaPlayer mediaPlayer25 = this.mPlayer;
                if (mediaPlayer25 != null) {
                    mediaPlayer25.setIntOption(397, i5);
                    this.mLogService.mHurryTime = i5;
                    break;
                }
                break;
            case 84:
                str = "slow_play_time:" + i5;
                this.mSlowPlayTime = i5;
                MediaPlayer mediaPlayer26 = this.mPlayer;
                if (mediaPlayer26 != null) {
                    mediaPlayer26.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, i5);
                    this.mLogService.mSlowPlayTime = i5;
                    break;
                }
                break;
            case 85:
                str = "enable free flow:" + i5;
                this.mEnableFreeFlow = i5;
                break;
        }
        MyLog.i(TAG, "setIntOption " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLocalURL(String str) {
        checkMainLooper("setLocalURL");
        if (str != null && !str.equals(this.mLocalURL) && this.mLocalURL != null) {
            reset();
        }
        this.mLocalURL = str;
        this.mIsLocalURL = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLongOption(int i4, long j4) {
        String str = "";
        if (i4 == 45) {
            str = "startPlayBufferThreshold:" + j4;
            this.mStartPlayBufferThres = j4;
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null && j4 > 0) {
                mediaPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, j4);
                this.mLogService.mStartPlayBufferThres = j4;
            }
        } else if (i4 == 59) {
            str = "set alog func:" + j4;
            this.mALogWriteAddr = j4;
        }
        MyLog.i(TAG, "setLongOptin " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLooping(boolean z3) {
        this.mLooping = z3;
        if (this.mPlayer == null || !this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
            return;
        }
        this.mPlayer.setLooping(this.mLooping);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setMute(Boolean bool) {
        this.mPlayerSetting.setMute(bool.booleanValue());
        this.mLogService.mMuteAudio = bool.booleanValue() ? 1 : 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayURLs(LiveURL[] liveURLArr) {
        MyLog.i(TAG, "setPlayUrls, sdkParam:" + liveURLArr[0].sdkParams);
        checkMainLooper("setPlayURLS");
        this.mURLSource.setPlayURLs(liveURLArr);
        this.mUrlSettingMethod = 0;
        if (this.mCurrentPlayURL == null || this.mURLSource.getPlayLiveURL().mainURL == this.mCurrentPlayURL) {
            return;
        }
        _reset("setPlayURLs");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayerVolume(float f4) {
        this.mPlayerSetting.setPlayerVolume(f4);
        this.mLogService.mPlayerVolumeSetting = f4;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPreviewFlag(boolean z3) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setPreviewFlag(z3);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setProjectKey(String str) {
        this.mLogService.setProjectKey(str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStreamInfo(String str) {
        JSONObject jSONObject;
        MyLog.i(TAG, "setStreamInfo:" + str);
        this.mLogService.mStreamData = str;
        checkMainLooper("setStreamInfo");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            jSONObject = null;
            e4.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        _reset("setStreamInfo");
        this.mURLSource.setStreamInfo(new LiveStreamInfo(jSONObject));
        this.mUrlSettingMethod = 1;
        _setLooseSync();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStringOption(int i4, String str) {
        LiveInfoSource liveInfoSource;
        String str2 = "";
        if (i4 == 26) {
            String str3 = "cacheFilePath:" + str;
            this.mCacheFilePath = str;
            if (this.mPlayer != null) {
                String str4 = System.currentTimeMillis() + "";
                this.mCacheFileKey = str4;
                this.mPlayer.setStringOption(17, str4);
                this.mPlayer.setIntOption(14, 1);
                this.mPlayer.setCacheFile(str, 1);
            }
            str2 = str3;
        } else if (i4 == 43) {
            str2 = "set resolution:" + str;
            saveCurrentResolution();
            this.mResolution = str;
            if (this.mPlayer != null && (liveInfoSource = this.mURLSource) != null && liveInfoSource.getSourceType() == 2) {
                long bitrate = this.mURLSource.getBitrate(this.mResolution, this.mLevel);
                if (bitrate > 0) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, (int) bitrate);
                    this.mLogService.mUseExpectBitrate = 1;
                }
            }
        } else if (i4 == 60) {
            str2 = "set stream format:" + str;
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(str, str);
            if (this.mPlayer != null && (this.mStreamFormat.equals(LiveConfigKey.AVPH) || this.mStreamFormat.equals(LiveConfigKey.CMAF))) {
                this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
            }
        } else if (i4 == 81) {
            str2 = "toB module id:" + str;
            this.mMoudleIDToB = str;
        } else if (i4 == 86) {
            str2 = "switch resolution of cdn abr:" + str;
            this.mCdnAbrResolution = str;
            _requestSwitchUrlFromServer();
        } else if (i4 != 89) {
            switch (i4) {
                case 63:
                    this.mLogService.mEnterMethod = str;
                    break;
                case 64:
                    this.mLogService.mEnterAction = str;
                    break;
                case 65:
                    str2 = " abr strategy:" + str;
                    this.mAbrStrategy = str;
                    break;
                case 66:
                    str2 = "set transport protocol:" + str;
                    if (str.equals(LiveConfigKey.TCP) || str.equals(LiveConfigKey.QUIC)) {
                        this.mTransportProtocol = str;
                    }
                    this.mQuicPull = true;
                    break;
                default:
                    switch (i4) {
                        case 72:
                            str2 = "set sr kernal bin path:" + str;
                            this.mTextureSRBinPath = str;
                            break;
                        case 73:
                            str2 = "set sr ocl module path:" + str;
                            this.mTextureSROclModuleName = str;
                            break;
                        case 74:
                            str2 = "set sr dsp module path:" + str;
                            this.mTextureSRDspModuleName = str;
                            break;
                    }
            }
        } else {
            str2 = "set_url_host:" + str;
            this.mURLHost = str;
        }
        MyLog.i(TAG, "setStringOption " + str2);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurface(Surface surface) {
        checkMainLooper("setSurface");
        MyLog.i(TAG, "setsurface: " + surface);
        this.mSurface = surface;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setSurface(surface);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        checkMainLooper("setSurfaceHolder");
        this.mSurfaceHolder = surfaceHolder;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setDisplay(surfaceHolder);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    public void setTextureRenderLogListener() {
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVideoFormat(String str) {
        this.mStreamFormat = str;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVolume(float f4) {
        this.mPlayerSetting.setVolume(f4);
        this.mLogService.mVolumeSetting = f4;
    }

    public String set_url_port_scheme(String str, String str2) {
        int indexOf;
        int indexOf2 = str.indexOf(".com");
        int indexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            if (indexOf3 != -1) {
                int i4 = indexOf3 + 5;
                int i5 = i4 + 1;
                while (i5 < sb.length() && sb.charAt(i5) - '0' >= 0 && sb.charAt(i5) - '0' <= 9) {
                    i5++;
                }
                sb.replace(i4, i5, str2);
            } else if (indexOf2 != -1 && ((indexOf = str.indexOf("vhost")) == -1 || indexOf > indexOf2)) {
                sb.insert(indexOf2 + 4, ":" + str2);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int indexOf4 = sb2.indexOf("://");
        if (this.mURLSource.getSourceType() == 2) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "https");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && indexOf4 != -1) {
                sb2.replace(0, indexOf4, "http");
            }
        }
        return sb2.toString();
    }

    public void setupTextureRender() {
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void stop() {
        MyLog.i(TAG, "stop");
        ILiveListener iLiveListener = this.mListener;
        iLiveListener.onReportALog(4, "stop start -- " + hashCode());
        checkMainLooper("stop");
        _stop(true, "stop");
        this.mRetryProcessor.stop();
        ILiveListener iLiveListener2 = this.mListener;
        iLiveListener2.onReportALog(4, "stop end-- " + hashCode());
    }

    public void updateFrameTerminatedDTS(int i4, long j4, long j5) {
        this.mFrameTerminatedDTS = j4;
    }

    private VideoLiveManager(Builder builder) {
        this.mMyHandler = new Handler(Looper.myLooper());
        this.mURLSource = new LiveInfoSource();
        this.mEnableTextureRender = 0;
        this.mEnableTextureSR = 0;
        this.mResolutionDisableSR = true;
        this.mTextureSRBinPath = "none";
        this.mTextureSROclModuleName = "test";
        this.mTextureSRDspModuleName = "test";
        this.mTextureRenderErrorMsg = null;
        this.mEnableOpenMDL = 0;
        this.mIsMdlProtoRegister = false;
        this.mIsPlayWithMdl = false;
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        this.mIsRequestCanceled = false;
        this.mShowedFirstFrame = false;
        this.mHasRetry = false;
        this.mLooping = false;
        this.mPlayerCache = 0;
        this.mEnhancementType = 0;
        this.mScaleType = 0;
        this.mLayoutType = 0;
        this.mRenderType = 3;
        this.mHardwareDecodeEnable = 0;
        this.mHardwareRTCDecodeEnable = 0;
        this.mCacheFileEnable = -1;
        this.mTestAction = -1;
        this.mUseExternalDir = -1;
        this.mMaxFileCacheSize = -1;
        this.mByteVC1DecoderType = 1;
        this.mBufferDataSeconds = -1;
        this.mBufferTimeout = -1;
        this.mNetworkTimeout = -1;
        this.mPlayerDegradeMode = 0;
        this.mEnableSharp = 0;
        this.mDefaultCodecId = -1;
        this.mEnableMediaCodecASYNCInit = 0;
        this.mHurryType = -1;
        this.mHurryTime = 0;
        this.mCatchSpeed = -1.0f;
        this.mSlowPlayTime = -1;
        this.mSlowPlaySpeed = -1.0f;
        this.mEnableHurryFlag = -1;
        this.mCacheFilePath = null;
        this.mCacheFileKey = null;
        this.mIsCacheHasComplete = false;
        this.mCurrentPlayURL = null;
        this.mCurrentIP = null;
        this.mStallCount = 0;
        this.mIsStalling = false;
        this.mEnableResolutionAutoDegrade = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mHasAbrInfo = false;
        this.mDefaultResBitrate = -1;
        this.mStallCountThresOfResolutionDegrade = 4;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableCmafFastMode = 0;
        this.mEnableCmafOptimizeRetry = 0;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mFrameDroppingDTSMaxDiff = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.mFrameTerminatedDTS = -1L;
        this.mLatestAudioPacketDTS = -1L;
        this.mSessionId = null;
        this.mEnableCheckFrame = 0;
        this.mEnableCheckSEI = 0;
        this.mGopDuration = 4;
        this.mFrameMetaDataListener = null;
        this.mInvocationHandler = null;
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mALogWriteAddr = -1L;
        this.mResolution = LiveConfigKey.ORIGIN;
        this.mResolutionIndex = -1;
        this.mLevel = "main";
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mSuggestProtocol = "none";
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mURLProtocol = "none";
        this.mEnableAvLines = "";
        this.mVideoOnly = "";
        this.mAudioOnly = "";
        this.mReliable = "";
        this.mForceDecodeSwitch = 0;
        this.mForceDecodeMsGaps = 0;
        this.mForceRenderMsGaps = 0;
        this.mFramesDrop = 15;
        this.mAVPHDnsParseEnable = 0;
        this.mAVPHDnsTimeout = 2000000;
        this.mAVPHVideoProbesize = 4096;
        this.mAVPHVideoMaxDuration = 100000;
        this.mAVPHAudioProbesize = 4096;
        this.mAVPHAudioMaxDuration = 100000;
        this.mAVPHOpenVideoFirst = 1;
        this.mAVPHMaxAVDiff = 10000;
        this.mAVPHAutoExit = 1;
        this.mAVPHEnableAutoReopen = 0;
        this.mAVPHVideoDiffThreshold = 15000;
        this.mAVPHReadRetryCount = 100;
        this.mAVPHReadErrorExit = 1;
        this.mEnableSkipFindUnnecessaryStream = 0;
        this.mEnableRenderStall = 1;
        this.mAudioLastRenderTime = -1L;
        this.mVideoLastRenderTime = -1L;
        this.mIsRetrying = false;
        this.mEnableDemuxerStall = 1;
        this.mEnableDecoderStall = 1;
        this.mEnableStallCounter = 0;
        this.mStallCounterInterval = 2000;
        this.mEnableClosePlayRetry = 0;
        this.mEnableCheckDropAudio = 0;
        this.mURLAbility = 1;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mRetryStartTime = 0L;
        this.mEnableNTP = 0;
        this.mEnableNTPTask = 0;
        this.mEnableDns = true;
        this.mEnableDnsOptimizer = false;
        this.mEnableUploadSessionSeries = false;
        this.mEnableH264HardwareDecode = 0;
        this.mEnableByteVC1HardwareDecode = 0;
        this.mMaxCacheSeconds = -1;
        this.mEnableSplitStream = 0;
        this.mOpenCheckSideData = 1;
        this.mEnableHttpkDegrade = 0;
        this.mEnableQuicDegrade = 1;
        this.mEnableFastOpenStream = 1;
        this.mEnableUploadSei = 1;
        this.mSeiDiffThres = 8000L;
        this.mEnableSeiCheck = false;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mStartPlayBufferThres = 0L;
        this.mCheckBufferingEndIgnoreVideo = 0;
        this.mStartDirectAfterPrepared = 0;
        this.mCheckBufferingEndAdvanceEnable = 0;
        this.mEnableTcpFastOpen = 0;
        this.mEnableCheckPacketCorrupt = 0;
        this.mEnableLowLatencyFLV = 0;
        this.mLowLatencyFLVStrategy = null;
        this.mEnableDroppingDTSRollFrame = 0;
        this.mIsInMainLooper = 1;
        this.mCmafEnable = false;
        this.mQuicEnable = false;
        this.mQuicVersion = 39;
        this.mEnableSaveSCFG = false;
        this.mEnableQuicCertVerify = false;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mQuicTimerVersion = 1;
        this.mQuicPull = false;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mSessionReceiveWindow = -1;
        this.mStreamReceiveWindow = -1;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mEnableFlvABR = 0;
        this.mEnableLLASHFastOpen = 0;
        this.mForceHttpDns = false;
        this.mHttpDNSServerHost = null;
        this.mCancelSDKDNSFailRetry = false;
        this.mUrlSettingMethod = -1;
        this.mUserSwitchResoultion = false;
        this.mEnterStallRetryInstantly = false;
        this.mEnableStallRetryInstantly = 1;
        this.mNodeOptimizeResults = null;
        this.mRedoDns = false;
        this.mEnableOptimizeBackup = 0;
        this.mSupportBackupIp = true;
        this.mTextureSRMode = 0;
        this.mRenderStartNotifyTimeStamp = 0L;
        this.mRenderStartEntered = false;
        this.mEnableAudioVolumeBalance = 0;
        this.mAudioVolumeBalancePregain = -1.0f;
        this.mAudioVolumeBalanceThreshold = -1.0f;
        this.mAudioVolumeBalanceRatio = -1.0f;
        this.mAudioVolumeBalancePredelay = -1.0f;
        this.mEnableCacheSei = 0;
        this.mEnableDecodeMultiSei = 0;
        this.mEnableDecodeSeiOnce = 0;
        this.mEnableSkipFlvNullTag = 0;
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mABRBufferThreshold = -1;
        this.mTslTimeShift = -1;
        this.mTslMinTimeShit = 60;
        this.mEnableOriginResolution = false;
        this.mTargetOriginBitRate = -1L;
        this.mEnableAbrStallDegradeImmediately = 1;
        this.mHlsLiveStartIndex = -3;
        this.mCdnSessionPath = null;
        this.mCdnAbrResolution = null;
        this.mAudioTimescaleEnable = -1;
        this.mStallRetryTimeIntervalManager = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.mMediaSupportSR = false;
        this.mSupportSRScene = 0;
        this.mCheckSupportSR = false;
        this.mStallCounterThread = null;
        this.mStallCounterHandler = null;
        this.mVideoStallCountTask = new VideoStallCountTask();
        this.mStallCounterLock = new Object();
        this.mStallCounterIsRunning = false;
        this.mEnableRtcPlay = 0;
        this.mRtcPlayFallBack = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcEnableDtls = 1;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcMaxJitterBuffer = 2000;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mRtcMaxRetryCount = 0;
        this.mRtcSupportMiniSdp = 0;
        this.mCurrentRetryCount = 0;
        this.mRtcPlayLogInterval = 5000;
        this.mRtcEnableRtcUninitLockFree = 0;
        this.mEnableRadioLiveDisableRender = 0;
        this.mSwitchToB = 0;
        this.mMoudleIDToB = "";
        this.mURLHost = "";
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        this.mMaxTextureWidth = 0;
        this.mMaxTextureHeight = 0;
        this.mEnableReportSessionStop = 0;
        this.mSessionNum = 0;
        this.mSessionStartTime = 0L;
        this.mSessionRenderStartTime = 0L;
        this.mIsLiveIOProtoRegister = false;
        this.mEnableOpenLiveIO = 0;
        this.mIsPlayWithLiveIO = false;
        this.mEnableLiveIOPlay = 0;
        this.mEnableLiveIOP2P = 0;
        this.mEnableHttpPrepare = 0;
        this.mEnableFreeFlow = 0;
        this.mEnableP2pUp = 0;
        this.mLiveIOABGroupID = 0;
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 2000;
        this.mEnableUseLiveThreadPool = 0;
        this.mExecutor = null;
        this.mEnableSharpen = 0;
        this.mSharpenMode = 0;
        this.mMediaSupportSharpen = false;
        this.mSupportSharpenScene = -1;
        this.mSharpenMaxWidth = 1920;
        this.mSharpenMaxHeight = 1080;
        this.mSharpenPowerLevel = 0;
        this.mSharpenAmount = -1.0f;
        this.mSharpenOverRatio = -1.0f;
        this.mSharpenEdgeWeightGamma = 6.0f;
        this.mSharpenSceneMode = 1;
        this.mSharpenSdkParams = null;
        Context context = builder.mContext;
        this.mContext = context;
        ILiveListener iLiveListener = builder.mListener;
        this.mListener = iLiveListener;
        ILiveSettingBundle iLiveSettingBundle = builder.mSettingsBundle;
        this.mSettingsBundle = iLiveSettingBundle;
        builder.setStallRetryInterval(this.mStallRetryTimeIntervalManager);
        if (iLiveSettingBundle != null) {
            this.mEnableReportSessionStop = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_should_report_session_stop", 0)).intValue();
            this.mEnableUseLiveThreadPool = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_enable_use_live_threadpool", 0)).intValue();
        }
        if (this.mEnableUseLiveThreadPool == 1 && builder.mLiveThreadPool != null) {
            MyLog.i(TAG, "use live threadpool");
            this.mExecutor = builder.mLiveThreadPool;
            this.mLogService.mUseLiveThreadPool = 1;
        } else {
            MyLog.i(TAG, "create new threadpool");
            this.mExecutor = new sr(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new NamedThreadFactory() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.1
            });
        }
        LiveLoggerService liveLoggerService = new LiveLoggerService(this, iLiveListener, builder.mUploadLogInterval, builder.mStallRetryTimeInterval, context, this.mEnableReportSessionStop);
        this.mLogService = liveLoggerService;
        liveLoggerService.setProjectKey(builder.mProjectKey);
        MediaLoaderWrapper.getDataLoader().setLogService(this.mLogService);
        this.mRetryProcessor = new RetryProcessor(new MyRetryListener(this), builder.mRetryTimeout, builder.mStallRetryTimeInterval, this.mLogService);
        this.mPlayerSetting = new PlayerSetting(context, null);
        boolean z3 = builder.mForceHttpDns;
        this.mForceHttpDns = z3;
        this.mLogService.mEnableHttpDns = z3;
        INetworkClient iNetworkClient = builder.mNetworkClient;
        this.mNetworkClient = iNetworkClient;
        DnsHelper dnsHelper = new DnsHelper(context, this.mExecutor, iNetworkClient);
        this.mDnsParser = dnsHelper;
        dnsHelper.updateDNSServerIP();
        this.mPlayerType = builder.mPlayerType;
        this.mStreamFormat = builder.mVideoFormat;
        this.mResolution = builder.mResolution;
        this.mStallCount = 0;
        this.mEnableResolutionAutoDegrade = builder.mEnableResolutionAutoDegrade;
        this.mEnableSwitchMainAndBackupUrl = builder.mEnableSwitchMainAndBackupUrl;
        this.mSeiDiffThres = builder.mSeiCheckTimeOut;
    }
}
