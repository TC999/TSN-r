package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper;
import com.bykv.vk.component.ttvideo.network.NetUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LiveLoggerService implements Handler.Callback {
    private static final long INTERVAL = 60000;
    public static final String LIVE_SDK_VERSION = "1.4.6.31-lite";
    private static final String LOG_REPORT_VERSION = "5";
    public static final String MONITOR_LOG_TYPE = "live_client_monitor_log";
    private static final int MSG_DNS = 104;
    private static final int MSG_LOG_SCHEDULE = 101;
    private static final int MSG_NTP_TIME_SYNC = 103;
    private static final int MSG_SESSION_SERIES_SCHEDULE = 102;
    private static final String PRODUCT_LINE = "live";
    public static final String RTC_MONITOR_LOG_TYPE = "live_webrtc_monitor_log";
    private static final long SESSION_TIME_SERIES_INTERVAL = 5000;
    private static final String TAG = LiveLoggerService.class.getCanonicalName();
    private Context mContext;
    private boolean mHasNTP;
    private InetAddress mHostAddr;
    public String mHostNTPUrl;
    private final long mInterval;
    private VideoLiveManager mLiveEngine;
    private LogBundle mLogBundle;
    private ILiveListener mLogUploader;
    private MyNTPTask mNTPTask;
    public LogBundle mSessionLogBundle;
    public long mStallRetryTimeInterval;
    private long playerFromStartToRtsFrame;
    private boolean mStarted = false;
    public String mEnterMethod = "none";
    public String mEnterAction = "none";
    private String mCommonFlag = "none";
    private String mProjectKey = "none";
    private String mCdnPlayURL = "none";
    private String mCurrentPlayURL = "none";
    private String mCdnIp = "none";
    private boolean mIpIsFromPlayerCore = false;
    private String mPlayerVersion = "none";
    private boolean mIsPreview = false;
    private long mLogIndex = 0;
    private String mSdkParams = "none";
    private String mPushClientSDKVersion = "none";
    private String mPushClientPlatform = "none";
    private String mPushClientOSVersion = "none";
    private String mPushClientModel = "none";
    private String mPushClientStartTime = "none";
    private int mPushClientHardwareEncode = -1;
    private int mPushClientMinBitrate = -1;
    private int mPushClientMaxBitrate = -1;
    private int mPushClientDefaultBitrate = -1;
    private int mPushClientHitNodeOptimize = -1;
    private String mPushClientPushProtocal = "none";
    private String mPushClientQId = "none";
    private String mLinkInfo = "";
    private boolean mOpenNodeOptimizer = false;
    private String mEvaluatorSymbol = "none";
    private boolean mHitNodeOptimizer = false;
    private boolean mIsRemoteSorted = false;
    private boolean mIsHitCache = false;
    public String mCodecType = "none";
    public boolean mHardDecodeEnable = false;
    public String mCodecName = "none";
    public boolean mEnableHurry = false;
    public int mHurryTime = -1;
    public float mCatchSpeed = -1.0f;
    public int mSlowPlayTime = -1;
    public float mSlowSpeed = -1.0f;
    public int mSpeedSwitchCount = 0;
    public String mSpeedSwitchInfo = "none";
    public long mStartPlayBufferThres = 0;
    public int mFastOpenDuration = -1;
    public int mCheckBufferingEndIgnoreVideo = 0;
    public int mStartDirectAfterPrepared = 0;
    public int mCheckBufferingEndAdvanceEnable = 0;
    public int mAudioTimescaleEnable = -1;
    public String mRuleIds = "none";
    public String mSessionId = "none";
    private String mStreamFormat = LiveConfigKey.FLV;
    private boolean mHasFirstFrame = false;
    private long mFirstFrameTimestamp = 0;
    public long mLogTotalCount = 0;
    private int mErrorCode = 0;
    private int mRenderFailType = 0;
    private long mStallStartTime = 0;
    private long mPlayingStallStartTime = 0;
    private long mStallReason = -1;
    private long mStallTotalCount = 0;
    private long mStallTotalTime = 0;
    private long mVideoRenderStallTotalCount = 0;
    private long mVideoRenderStallTotalTime = 0;
    private long mAudioRenderStallTotalCount = 0;
    private long mAudioRenderStallTotalTime = 0;
    private boolean mIsStalling = false;
    private int mPlayingStallCount = 0;
    private int mPlayingStallTime = 0;
    private int mPlayingVideoRenderStallCount = 0;
    private int mPlayingVideoRenderStallTime = 0;
    private int mPlayingAudioRenderStallCount = 0;
    private int mPlayingAudioRenderStallTime = 0;
    private long mFirstStallStartTime = 0;
    private long mFirstStallEndTime = 0;
    private int mRetryCount = 0;
    private int mRetryTotalCount = 0;
    private boolean mEnableCheckSilenceInterval = false;
    public int mSilenceDetectedCount = -1;
    private boolean mEnableSharp = false;
    private boolean mEnableCheckSei = false;
    private boolean mIsInErrorRecovering = false;
    private long mErrorStartTime = 0;
    private long mErrorRecoverCount = 0;
    private long mErrorRecoverTime = 0;
    private NTPUDPClient mNTPClient = null;
    private final long mNTPInterval = 300000;
    private int mCurNetType = -1;
    private String mCurNetExtraInfo = null;
    private boolean mNTPRunning = false;
    public int mEnableNTP = 0;
    public int mEnableNTPTask = 0;
    public long mTimeDiff = 0;
    public int mEnableOpenMDL = 0;
    public int mEnableP2P = 0;
    public int mUsedP2P = 0;
    public int mEnableLiveIOPlay = 0;
    public int mP2PLoaderType = -1;
    public String mMDLVersion = null;
    public int mEnableMdlProto = 0;
    public int mWidth = 0;
    public int mHeight = 0;
    private int mPreconnect = -1;
    private ArrayList<Long> mRenderFpsTimeSeries = null;
    private ArrayList<Long> mDownloadSpeedTimeSeries = null;
    private ArrayList<Long> mAudioBufferTimeSeries = null;
    private ArrayList<Long> mStallTimeSeries = null;
    private JSONObject mErrorTimeSeries = null;
    private ArrayList<Integer> mSeiBitrateTimeSeries = null;
    private ArrayList<Integer> mSeiFpsTimeSeries = null;
    private boolean mSeiHasBitrateAndFps = false;
    public boolean mEnableHttpDns = false;
    public int mMediaCodecAsyncInit = 0;
    public int mDefaultCodecID = -1;
    public String mUrlAbility = "none";
    public boolean mEnableUploadSessionSeries = false;
    public int mMaxCacheSeconds = -1;
    public int mEnableSplitStream = 0;
    public int mTslTimeShift = -1;
    public boolean mEnableSeiCheck = false;
    public int mEnableFastOpenStream = 0;
    public int mIsInMainLooper = 1;
    public long mSetSurfaceCost = 0;
    public long mSetSurfaceTime = 0;
    public String mStreamData = "none";
    public int mTextureRenderError = 0;
    public boolean mSRSuccess = false;
    public boolean mUseTextureRender = false;
    public float mContainerFps = -1.0f;
    public long mRenderStartNotifyTimeStamp = 0;
    private String mSuggestFormat = "none";
    private String mProtocol = LiveConfigKey.TCP;
    private String mSuggestProtocol = "none";
    private int mQuicFlag = -1;
    private String mOriginUrl = "none";
    private String mChipBoard = Build.BOARD;
    private String mChipHardware = Build.HARDWARE;
    public String mSettingsInfo = "none";
    public String mTTNetNQEInfo = "none";
    public boolean mEnableResolutionAutoDegrade = false;
    public String mAbrStrategy = LiveConfigKey.RAD;
    public boolean mHasAbrInfo = false;
    public String mResolution = LiveConfigKey.ORIGIN;
    public String mAutoUsingResolution = LiveConfigKey.ORIGIN;
    public String mLastResolution = "none";
    public long mResBitrate = -1;
    public int mDefaultResBitrate = -1;
    public int mAbrSwitchCount = 0;
    public String mAbrSwitchCountInfo = "none";
    public long mCurDownloadSpeed = -1;
    public long mCurAudioBufferTime = -1;
    public long mCurVideoBufferTime = -1;
    public long mAbrSwitchCost = -1;
    public String mAbrSwitchInfo = "none";
    public int mStallCountThresOfResolutionDegrade = 4;
    public boolean mHaveResetPlayer = false;
    public long mLastDownloadSizeDelta = 0;
    public long mLastTotalDownloadSize = 0;
    public long mFirstAudioPacketDTS = -1;
    public long mPreviousAudioPacketDTS = -1;
    private int mFirstFrameRetryCount = 0;
    private long mFirstFramePrepareTime = 0;
    public long mLastPrepareTime = 0;
    public int mNetworkTimeoutMs = -1;
    public int mQuicScfgConfig = -1;
    public int mQuicMtu = -1;
    public int mQuicPadHello = -1;
    public int mQuicTimerVersion = -1;
    public int mEnableTcpFastOpen = 0;
    public int mEnableLowLatencyFLV = 0;
    public List<String> mOptimizeBackupIps = null;
    private final int TYPE_DATA_LOST = 0;
    private final int TYPE_DATA_REPEAT = 1;
    private final int TYPE_SEI_NOT_AVAIL = 2;
    private final int TYPE_SEI_LOST = 3;
    private final int TYPE_SEI_INDEX_ROLLBACK = 4;
    private LinkedBlockingQueue<Long> mVideoDTSQueue = null;
    private final int VIDEO_DTS_QUEUE_MAX_SIZE = 600;
    private int mLastIndex = -1;
    private int mLastSentFrames = -1;
    private long mLastCheckDTS = -1;
    private int mLastSeiIndex = -1;
    private int mExpectedSeiCount = 0;
    private int mReceivedSeiCount = 0;
    private int mExpectedUniqueSeiCount = 0;
    private int mReceivedUniqueSeiCount = 0;
    public int mEnableLiveAbrCheckEnhance = 0;
    public int mEnableRtcPlay = 0;
    public int mEnableMiniSdp = 0;
    public int mRtcPlayFallBack = 0;
    public String mDnsIp = "none";
    public int mRtcUseSdkDns = -1;
    public long mRtcDnsTimeStamp = 0;
    public long mRtcTcpConnectTimeStamp = 0;
    public long mRtcTlsHandshakedTimeStamp = 0;
    public long mRtcTcpFirstPackageTimeStamp = 0;
    public int mFallbackType = 0;
    public String mRtcSessionId = "none";
    public String mRtcPlayStopStatInfo = "none";
    public int mBitRateAbnormalType = 0;
    public int mCodecNotSame = 0;
    public int mABRListMatch = 1;
    public boolean mIsCdnAbrSwitch = false;
    public int mCdnAbrSwitchCode = -1;
    public String mRequestUrl = "none";
    public Map<String, String> mRequestHeaders = null;
    public int mDisableVideoRender = 0;
    public int mMuteAudio = -1;
    public float mVolumeSetting = -1.0f;
    public float mPlayerVolumeSetting = -1.0f;
    public int mUseExpectBitrate = 0;
    public int mFCDNTranscodeMethod = -1;
    public long mTextureRenderFirstFrameTime = 0;
    public int mEnableReportSessionStop = 0;
    public boolean mSessionHasFirstFrame = false;
    public long mSessionStartTime = 0;
    public long mSessionVideoRenderStartTime = 0;
    public long mSessionAudioRenderStartTime = 0;
    private int mSessionNum = 0;
    private long mSessionStallTotalCount = 0;
    private long mSessionStallTotalTime = 0;
    private long mSessionVideoRenderStallTotalCount = 0;
    private long mSessionVideoRenderStallTotalTime = 0;
    private long mSessionAudioRenderStallTotalCount = 0;
    private long mSessionAudioRenderStallTotalTime = 0;
    private long mSessionFirstStallStartTime = 0;
    private long mSessionFirstStallEndTime = 0;
    private int mSessionRenderFailType = -1;
    private int mSessionErrorCode = -1;
    private String mSessionErrorMsg = "none";
    private long mVideoDecodeStallTotalCount = 0;
    private long mVideoDecodeStallTotalTime = 0;
    private long mAudioDecodeStallTotalCount = 0;
    private long mAudioDecodeStallTotalTime = 0;
    private long mVideoDemuxStallTotalCount = 0;
    private long mVideoDemuxStallTotalTime = 0;
    private long mAudioDemuxStallTotalCount = 0;
    private long mAudioDemuxStallTotalTime = 0;
    public int mLiveIOPlay = 0;
    public int mLiveIOP2P = 0;
    public String mLiveIOErrorMsg = "none";
    public long mFirstFrameView = 0;
    public String mLiveIOVersion = "none";
    private boolean mHasUsedSharpen = false;
    public long mNoSyncStartTime = 0;
    public long mNoSyncStartPts = 0;
    public int mNoSyncCount = 0;
    public int mNoSyncPlayingCount = 0;
    public long mNoSyncTimeDuration = 0;
    public long mNoSyncPlayingTimeDuration = 0;
    public long mNoSyncPtsDuration = 0;
    public long mNoSyncPlayingPtsDuration = 0;
    public int mNoSyncInfoLen = 4096;
    public int mNoSyncPlayingInfoLen = 512;
    public String mNoSyncInfoStr = "";
    public String mNoSyncPlayingInfoStr = "";
    private long mRtcPlayingLogInterval = 5000;
    public int mUseLiveThreadPool = 0;
    private Handler mHandler = new Handler(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class MyNTPTask {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        public MyNTPTask(final LiveLoggerService liveLoggerService) {
            HandlerThread handlerThread = new HandlerThread("DnsHandlerThread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.bykv.vk.component.ttvideo.log.LiveLoggerService.MyNTPTask.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    String str;
                    if (message == null || (str = liveLoggerService.mHostNTPUrl) == null || str.equals("null")) {
                        return;
                    }
                    if ((message.what == 104 && liveLoggerService.mCurNetType == -1) || liveLoggerService.isNetWorkChanged() || liveLoggerService.mHostAddr == null) {
                        try {
                            LiveLoggerService liveLoggerService2 = liveLoggerService;
                            liveLoggerService2.mHostAddr = InetAddress.getByName(liveLoggerService2.mHostNTPUrl);
                        } catch (UnknownHostException e4) {
                            liveLoggerService.mHostAddr = null;
                            e4.printStackTrace();
                        }
                    }
                    if (message.what == 103) {
                        liveLoggerService.ntp();
                        if (liveLoggerService.mNTPRunning) {
                            MyNTPTask.this.mHandler.sendEmptyMessageDelayed(103, 300000L);
                        }
                    }
                }
            };
        }

        public void sendEmptyMessageDelayed(int i4, long j4) {
            Handler handler;
            if (this.mHandlerThread == null || (handler = this.mHandler) == null) {
                return;
            }
            if (j4 == 0) {
                handler.sendEmptyMessage(i4);
            } else {
                handler.sendEmptyMessageDelayed(i4, j4);
            }
        }
    }

    public LiveLoggerService(VideoLiveManager videoLiveManager, ILiveListener iLiveListener, long j4, long j5, Context context, int i4) {
        this.mStallRetryTimeInterval = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.mContext = context;
        this.mInterval = j4 <= 0 ? 60000L : j4;
        this.mLogUploader = iLiveListener;
        this.mLiveEngine = videoLiveManager;
        this.mLogBundle = new LogBundle();
        this.mStallRetryTimeInterval = j5;
        String str = TAG;
        MyLog.i(str, "enable report sessionstop: " + i4);
        if (i4 == 1) {
            this.mSessionLogBundle = new LogBundle();
        }
    }

    private JSONObject _createSessionTimeSeries() {
        updateSessionSeries();
        try {
            JSONObject put = new JSONObject().put("start_time", this.mLogBundle.startPlayTime).put("duration", System.currentTimeMillis() - this.mLogBundle.startPlayTime).put("render_fps_series", new JSONArray((Collection) this.mRenderFpsTimeSeries)).put("download_bitrate_series", new JSONArray((Collection) this.mDownloadSpeedTimeSeries)).put("play_buffer_series", new JSONArray((Collection) this.mAudioBufferTimeSeries)).put("push_bitrate_series", this.mSeiBitrateTimeSeries == null ? new JSONArray() : new JSONArray((Collection) this.mSeiBitrateTimeSeries)).put("push_fps_series", this.mSeiFpsTimeSeries == null ? new JSONArray() : new JSONArray((Collection) this.mSeiFpsTimeSeries)).put("stall_series", this.mStallTimeSeries == null ? new JSONArray() : new JSONArray((Collection) this.mStallTimeSeries));
            JSONObject jSONObject = this.mErrorTimeSeries;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            return put.put("error_series", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void checkSeiIndex(int i4) {
        this.mReceivedSeiCount++;
        this.mExpectedSeiCount++;
        int i5 = this.mLastSeiIndex;
        if (i5 >= 0) {
            if (i4 <= i5) {
                onStreamAbnormalSEI(4, i4, i5);
                if (i4 == 1) {
                    this.mExpectedUniqueSeiCount++;
                    this.mReceivedUniqueSeiCount++;
                }
            } else {
                this.mExpectedUniqueSeiCount++;
                this.mReceivedUniqueSeiCount++;
                if (i4 - i5 > 1) {
                    onStreamAbnormalSEI(3, i4, i5);
                    int i6 = this.mExpectedSeiCount;
                    int i7 = this.mLastSeiIndex;
                    this.mExpectedSeiCount = i6 + ((i4 - i7) - 1);
                    this.mExpectedUniqueSeiCount += (i4 - i7) - 1;
                }
            }
        }
        this.mLastSeiIndex = i4;
    }

    private void checkVideoFrame(int i4, int i5, long j4) {
        LinkedBlockingQueue<Long> linkedBlockingQueue;
        if (i4 < 0 || i5 <= 0 || j4 < 0 || (linkedBlockingQueue = this.mVideoDTSQueue) == null) {
            return;
        }
        int i6 = this.mLastIndex;
        if (i6 == -1) {
            this.mLastIndex = i4;
            this.mLastSentFrames = i5;
            this.mLastCheckDTS = j4;
        } else if (i4 == i6) {
        } else {
            long longValue = linkedBlockingQueue.size() > 0 ? this.mVideoDTSQueue.peek().longValue() : -1L;
            if (longValue > 0 && longValue <= this.mLastCheckDTS) {
                boolean z3 = false;
                int i7 = 0;
                while (this.mVideoDTSQueue.size() > 0) {
                    long longValue2 = this.mVideoDTSQueue.peek().longValue();
                    long j5 = this.mLastCheckDTS;
                    if (longValue2 == j5) {
                        z3 = true;
                    }
                    if (z3 && longValue2 > j5 && longValue2 <= j4) {
                        i7++;
                        if (longValue2 == j4) {
                            break;
                        }
                    }
                    this.mVideoDTSQueue.poll().longValue();
                }
                if (i4 - this.mLastIndex == 1 && i7 > 0 && i7 != i5) {
                    onStreamAbnormalFrame(i7 < i5 ? 0 : 1, i5, i7);
                }
            }
            int i8 = this.mLastIndex;
            if (i4 - i8 != 1) {
                onStreamAbnormalSEI(i4 <= i8 ? 1 : 0, i4, i8);
            }
            this.mLastIndex = i4;
            this.mLastSentFrames = i5;
            this.mLastCheckDTS = j4;
        }
    }

    private JSONObject createFirstFrameLog(LogBundle logBundle, long j4, boolean z3, long j5) throws JSONException {
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            JSONObject put = createCommonLog.put("event_key", "first_frame").put("last_retry_end", j4).put("hit_cache", z3 ? 1 : 0).put(CampaignEx.JSON_NATIVE_VIDEO_START, logBundle.startPlayTime).put("sdk_dns_analysis_end", logBundle.SDKDNSTimeStamp).put("prepare_block_end", logBundle.callPrepareTime);
            long j6 = logBundle.tfoFallBackTime;
            if (j6 <= 0) {
                j6 = logBundle.playerDNSTimestamp;
            }
            put.put("tfo_fall_back_time", j6).put("pre_connect", this.mPreconnect).put("http_req_finish_time", logBundle.httpReqFinishTimestamp).put("http_res_finish_time", logBundle.httpResFinishTimestamp).put("first_video_package_end", logBundle.videoPacketTimestamp).put("first_audio_package_end", logBundle.audioPacketTimestamp).put("first_video_frame_decode_end", logBundle.videoDecodeTimestamp).put("first_audio_frame_decode_end", logBundle.audioDecodeTimestamp).put("first_frame_from_player_core", logBundle.videoRenderTimeForPlayerCore).put("first_frame_render_end", logBundle.videoRenderTimestamp).put("video_param_send_outlet_time", logBundle.videoParamSendOutletTime).put("first_video_frame_send_outlet_time", logBundle.firstVideoFrameSendOutletTime).put("set_surface_time", this.mSetSurfaceTime).put("set_surface_cost", this.mSetSurfaceCost).put("video_render_type", logBundle.renderType).put("video_device_open_start", logBundle.videoDeviceOpenTime).put("video_device_open_end", logBundle.videoDeviceOpenedTime).put("audio_device_open_start", logBundle.audioDeviceOpenTime).put("audio_device_open_end", logBundle.audioDeviceOpenedTime).put("video_device_wait_start", logBundle.videoDeviceWaitStartTime).put("video_device_wait_end", logBundle.videoDeviceWaitEndTime).put("find_stream_info_start", logBundle.streamInfoFindTime).put("find_stream_info_end", logBundle.streamInfoFoundTime).put("video_first_pkt_pos", logBundle.videoFirstPacketPos).put("video_first_pkt_pts", logBundle.videoFirstPacketPts).put("audio_first_pkt_pos", logBundle.audioFirstPacketPos).put("audio_first_pkt_pts", logBundle.audioFirstPacketPts).put("video_buffer_time", this.mLogBundle.videoBufferTime).put("audio_buffer_time", this.mLogBundle.audioBufferTime).put("download_speed", this.mLogBundle.downloadSpeed).put("stall_time", j5).put("first_sei_delay", this.mLogBundle.delay).put("response_header_X-Server-IP", this.mLogBundle.headerXServerIP).put("response_header_Via", this.mLogBundle.headerVia).put("prepare_end", logBundle.prepareEndTimestamp).put("drop_audio_pts_diff", logBundle.dropAudioPts).put("drop_audio_cost", logBundle.dropAudioCostTime).put("enable_tcp_fast_open", this.mEnableTcpFastOpen).put("tfo_success", logBundle.tfoSuccess).put("abr_check_enhance", this.mEnableLiveAbrCheckEnhance).put("optimize_backup_ips", this.mOptimizeBackupIps == null ? new JSONArray() : new JSONArray((Collection) this.mOptimizeBackupIps)).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("container_fps", this.mContainerFps);
            if (isRtcPlayAvailable()) {
                createCommonLog.put("player_dns_analysis_end", this.mRtcDnsTimeStamp);
                createCommonLog.put("rtc_use_sdk_dns", this.mRtcUseSdkDns);
                createCommonLog.put("tcp_connect_end", this.mRtcTcpConnectTimeStamp);
                createCommonLog.put("rtc_tls_handshake_end", this.mRtcTlsHandshakedTimeStamp);
                createCommonLog.put("tcp_first_package_end", this.mRtcTcpFirstPackageTimeStamp);
                createCommonLog.put("rtc_inited_end", logBundle.rtcInitedTime);
                createCommonLog.put("rtc_offer_send_end", logBundle.rtcOfferSendTime);
                createCommonLog.put("rtc_answer_recv_end", logBundle.rtcAnswerRecvTime);
                createCommonLog.put("rtc_start_end", logBundle.rtcStartTime);
            } else {
                createCommonLog.put("player_dns_analysis_end", logBundle.playerDNSTimestamp);
                createCommonLog.put("tcp_connect_end", this.mProtocol.equals(LiveConfigKey.KCP) ? logBundle.playerDNSTimestamp : logBundle.tcpConnectTimestamp);
                createCommonLog.put("tcp_first_package_end", logBundle.tcpFirstPacketTimestamp);
            }
            int i4 = this.mAudioTimescaleEnable;
            if (i4 != -1) {
                createCommonLog.put("audio_timescale_enable", i4);
            }
            return createCommonLog;
        }
        return null;
    }

    private JSONObject createPlayingLog(LogBundle logBundle, long j4, long j5, long j6, long j7, boolean z3) throws JSONException {
        long j8;
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            long j9 = logBundle.playTime - j6;
            long j10 = logBundle.currentPosition - j7;
            long j11 = logBundle.playedSize - j5;
            long j12 = (j10 <= 0 || j11 <= 0) ? 0L : (j11 * 8) / j10;
            this.mLogIndex++;
            int i4 = this.mPlayingStallCount;
            int i5 = this.mPlayingStallTime;
            if (this.mIsStalling && this.mPlayingStallStartTime != 0) {
                i4++;
                i5 = (int) (i5 + (System.currentTimeMillis() - this.mPlayingStallStartTime));
                this.mPlayingStallStartTime = System.currentTimeMillis();
            }
            long j13 = logBundle.downloadSize;
            long j14 = this.mLastTotalDownloadSize + j13;
            if (this.mHaveResetPlayer) {
                j8 = j13 + this.mLastDownloadSizeDelta;
                this.mLastDownloadSizeDelta = 0L;
            } else {
                j8 = j13 - j4;
            }
            this.mHaveResetPlayer = false;
            createCommonLog.put("event_key", "playing").put("download_size_delta", j8).put("download_size", j14).put("video_play_size", logBundle.playedSize).put("render_fps", logBundle.fps).put("video_rate", j12).put("download_speed", this.mLogBundle.downloadSpeed).put("play_time", j9).put("retry_count", this.mRetryCount).put("stall_count", i4).put("stall_time", i5).put("audio_render_stall_count", this.mPlayingAudioRenderStallCount).put("audio_render_stall_time", this.mPlayingAudioRenderStallTime).put("video_render_stall_count", this.mPlayingVideoRenderStallCount).put("video_render_stall_time", this.mPlayingVideoRenderStallTime).put("silence_detected_count", this.mSilenceDetectedCount).put("is_last", z3 ? 1 : 0).put("index", this.mLogIndex).put("speed_switch_count", this.mSpeedSwitchCount).put("speed_switch_info", this.mSpeedSwitchInfo).put("video_buffer_time", this.mLogBundle.videoBufferTime).put("audio_buffer_time", this.mLogBundle.audioBufferTime).put("enable_sei_check", this.mEnableSeiCheck ? 1 : 0).put("ntp_sync", this.mHasNTP ? 1 : 0).put("rtc_stat_info", this.mLogBundle.rtcStatInfo).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol);
            int i6 = this.mNoSyncPlayingCount;
            if (i6 > 0) {
                createCommonLog.put("av_out_sync_count", i6).put("av_out_sync_duration", this.mNoSyncPlayingTimeDuration).put("av_out_sync_info", this.mNoSyncPlayingInfoStr);
            }
            this.mNoSyncPlayingCount = 0;
            this.mNoSyncPlayingTimeDuration = 0L;
            this.mNoSyncPlayingInfoStr = "";
            this.mRetryCount = 0;
            this.mPlayingStallCount = 0;
            this.mPlayingStallTime = 0;
            this.mPlayingAudioRenderStallCount = 0;
            this.mPlayingAudioRenderStallTime = 0;
            this.mPlayingVideoRenderStallCount = 0;
            this.mPlayingVideoRenderStallTime = 0;
            this.mSpeedSwitchCount = 0;
            this.mSpeedSwitchInfo = "none";
            this.mSilenceDetectedCount = this.mEnableCheckSilenceInterval ? 0 : -1;
            return createCommonLog;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNetWorkChanged() {
        NetworkInfo networkInfo = NetUtils.getNetworkInfo(this.mContext);
        int type = (networkInfo == null || !networkInfo.isAvailable()) ? -1 : networkInfo.getType();
        if (type != -1) {
            if (type != this.mCurNetType) {
                this.mCurNetType = type;
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ntp() {
        NTPUDPClient nTPUDPClient = this.mNTPClient;
        if (nTPUDPClient == null) {
            return;
        }
        TimeInfo timeInfo = null;
        try {
            nTPUDPClient.open();
            InetAddress inetAddress = this.mHostAddr;
            if (inetAddress != null) {
                timeInfo = this.mNTPClient.getTime(inetAddress);
            }
        } catch (SocketException e4) {
            e4.printStackTrace();
            return;
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        if (timeInfo == null) {
            return;
        }
        long time = timeInfo.getMessage().getOriginateTimeStamp().getTime();
        long time2 = timeInfo.getMessage().getReceiveTimeStamp().getTime();
        long time3 = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        long currentTimeMillis = System.currentTimeMillis();
        this.mTimeDiff = ((time2 - time) + (time3 - currentTimeMillis)) / 2;
        Log.d("zdh", "ori:" + time + " rec:" + time2 + " trans:" + time3 + " destTs:" + currentTimeMillis + " diff:" + this.mTimeDiff);
    }

    private void onLink(boolean z3) {
        if (this.mEnableOpenMDL == 1) {
            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(z3 ? 8013 : 8014, this.mSessionId, -1);
        }
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "link").put("info", z3 ? CampaignEx.JSON_NATIVE_VIDEO_START : "end");
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void onStreamAbnormalFrame(int i4, int i5, int i6) {
        JSONObject createCommonLog;
        if (this.mLiveEngine == null || (createCommonLog = createCommonLog()) == null) {
            return;
        }
        try {
            createCommonLog.put("event_key", "stream_abnormal").put("stream_type", "video").put("type", i4).put("sent_frames", i5).put("received_frames", i6);
            this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            long j4 = this.mLogTotalCount;
            if (j4 > 0) {
                this.mLogTotalCount = j4 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void onStreamAbnormalSEI(int i4, int i5, int i6) {
        JSONObject createCommonLog;
        if (this.mLiveEngine == null || (createCommonLog = createCommonLog()) == null) {
            return;
        }
        try {
            createCommonLog.put("event_key", "stream_abnormal").put("stream_type", "video").put("type", i4).put("cur_index", i5).put("last_index", i6);
            this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            long j4 = this.mLogTotalCount;
            if (j4 > 0) {
                this.mLogTotalCount = j4 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void report(boolean z3) {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || this.mLogUploader == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        try {
            long j4 = logBundle.downloadSize;
            long j5 = logBundle.playedSize;
            long j6 = logBundle.playTime;
            long j7 = logBundle.currentPosition;
            videoLiveManager.getLogInfo(logBundle, 1);
            this.mLogUploader.onMonitorLog(createPlayingLog(this.mLogBundle, j4, j5, j6, j7, z3), MONITOR_LOG_TYPE);
            long j8 = this.mLogTotalCount;
            if (j8 > 0) {
                this.mLogTotalCount = j8 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        long j9 = this.mInterval;
        if (isRtcPlayAvailable()) {
            j9 = this.mRtcPlayingLogInterval;
        }
        if (this.mStarted) {
            this.mHandler.sendEmptyMessageDelayed(101, j9);
        }
    }

    private void reportQuicOpenResult(JSONObject jSONObject) throws JSONException {
        if (TextUtils.equals(this.mProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mProtocol, LiveConfigKey.QUICU)) {
            jSONObject.put("quic_open_result", this.mLogBundle.quicOpenResult);
            String str = TAG;
            MyLog.i(str, "quic_open_result = " + this.mLogBundle.quicOpenResult);
        }
    }

    private void reportUpdateSessionSeries() {
        updateSessionSeries();
        MyLog.i("zdh", "update session series");
        if (this.mStarted) {
            this.mHandler.sendEmptyMessageDelayed(102, 5000L);
        }
    }

    private void resetSessionInfo() {
        LogBundle logBundle;
        if (this.mEnableReportSessionStop == 0 || (logBundle = this.mSessionLogBundle) == null) {
            return;
        }
        this.mSessionHasFirstFrame = false;
        this.mSessionFirstStallStartTime = 0L;
        this.mSessionFirstStallEndTime = 0L;
        this.mSessionStallTotalCount = 0L;
        this.mSessionStallTotalTime = 0L;
        this.mSessionStartTime = 0L;
        this.mSessionVideoRenderStartTime = 0L;
        this.mSessionAudioRenderStartTime = 0L;
        this.mSessionVideoRenderStallTotalCount = 0L;
        this.mSessionVideoRenderStallTotalTime = 0L;
        this.mSessionAudioRenderStallTotalCount = 0L;
        this.mSessionAudioRenderStallTotalTime = 0L;
        this.mSessionRenderFailType = -1;
        this.mSessionErrorCode = 0;
        this.mSessionErrorMsg = "none";
        logBundle.reset();
    }

    private void updateRequestTimeFieldInRtcPlay(JSONObject jSONObject) {
        if (jSONObject.has("event_message")) {
            String optString = jSONObject.optString("event_message");
            String str = TAG;
            MyLog.i(str, "eventMessage:" + optString);
            if (TextUtils.isEmpty(optString) || !jSONObject.has("phase_timestamp")) {
                return;
            }
            if (TextUtils.equals("dns resolved", optString)) {
                if (jSONObject.has("request_ip")) {
                    String optString2 = jSONObject.optString("request_ip");
                    if (!optString2.equals(this.mDnsIp)) {
                        this.mCdnIp = optString2;
                        this.mRtcUseSdkDns = 0;
                    } else {
                        this.mRtcUseSdkDns = 1;
                    }
                }
                this.mRtcDnsTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                MyLog.i(str, "mRtcDnsTimeStamp:" + this.mRtcDnsTimeStamp);
            } else if (!TextUtils.equals("tcp connected", optString) && !TextUtils.equals("send request", optString)) {
                if (TextUtils.equals("tls handshaked", optString)) {
                    this.mRtcTlsHandshakedTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                    MyLog.i(str, "mRtcTlsHandshakedTimeStamp:" + this.mRtcTlsHandshakedTimeStamp);
                } else if (TextUtils.equals("response received", optString) || TextUtils.equals("remote answer got", optString)) {
                    this.mRtcTcpFirstPackageTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                    MyLog.i(str, "mRtcTcpFirstPackageTimeStamp:" + this.mRtcTcpFirstPackageTimeStamp);
                }
            } else {
                this.mRtcTcpConnectTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                MyLog.i(str, "mRtcTcpConnectTimeStamp:" + this.mRtcTcpConnectTimeStamp);
            }
        }
    }

    private void updateSessionSeries() {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || this.mLogUploader == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        videoLiveManager.getLogInfo(logBundle, 3);
        if (this.mRenderFpsTimeSeries == null) {
            this.mRenderFpsTimeSeries = new ArrayList<>();
            this.mAudioBufferTimeSeries = new ArrayList<>();
            this.mDownloadSpeedTimeSeries = new ArrayList<>();
        }
        this.mRenderFpsTimeSeries.add(Long.valueOf(this.mLogBundle.fps));
        this.mAudioBufferTimeSeries.add(Long.valueOf(this.mLogBundle.audioBufferTime));
        this.mDownloadSpeedTimeSeries.add(Long.valueOf(this.mLogBundle.downloadSpeed));
        if (this.mSeiHasBitrateAndFps) {
            if (this.mSeiFpsTimeSeries == null) {
                this.mSeiFpsTimeSeries = new ArrayList<>();
                this.mSeiBitrateTimeSeries = new ArrayList<>();
            }
            this.mSeiFpsTimeSeries.add(Integer.valueOf(this.mLogBundle.seiFps));
            this.mSeiBitrateTimeSeries.add(Integer.valueOf(this.mLogBundle.seiBitrate));
        }
    }

    public void calculateRenderFailType() {
        LogBundle logBundle = this.mLogBundle;
        long j4 = logBundle.audioRenderTimestamp;
        if (j4 > 0 && logBundle.videoRenderTimestamp > 0) {
            this.mRenderFailType = 0;
        } else if (j4 > 0 && logBundle.videoRenderTimestamp <= 0) {
            this.mRenderFailType = 1;
        } else if (j4 <= 0 && logBundle.videoRenderTimestamp > 0) {
            this.mRenderFailType = 2;
        } else {
            this.mRenderFailType = 3;
        }
    }

    public void calculateSessionRenderFailType() {
        long j4 = this.mSessionAudioRenderStartTime;
        if (j4 > 0 && this.mSessionVideoRenderStartTime > 0) {
            this.mSessionRenderFailType = 0;
        } else if (j4 > 0 && this.mSessionVideoRenderStartTime <= 0) {
            this.mSessionRenderFailType = 1;
        } else if (j4 <= 0 && this.mSessionVideoRenderStartTime > 0) {
            this.mSessionRenderFailType = 2;
        } else {
            this.mSessionRenderFailType = 3;
        }
    }

    public void close(String str) {
        if (this.mStarted) {
            this.mStarted = false;
            this.mHandler.removeCallbacksAndMessages(null);
            MyNTPTask myNTPTask = this.mNTPTask;
            if (myNTPTask != null) {
                myNTPTask.mHandler.removeCallbacksAndMessages(null);
            }
            this.mNTPRunning = false;
        }
        resetStreamCheckParams();
        onStop(str);
        reset();
    }

    public JSONObject createCommonLog() {
        this.mLiveEngine.getVideoCodecType();
        try {
            JSONObject put = new JSONObject().put("report_version", "5").put("live_sdk_version", "1.4.6.31-lite").put("product_line", "live").put("client_timestamp", System.currentTimeMillis());
            String str = this.mPlayerVersion;
            String str2 = "-1";
            if (str == null) {
                str = "-1";
            }
            JSONObject put2 = put.put("player_sdk_version", str);
            String str3 = this.mProjectKey;
            if (str3 == null) {
                str3 = "-1";
            }
            JSONObject put3 = put2.put("project_key", str3);
            String str4 = this.mEnterMethod;
            if (str4 == null) {
                str4 = "none";
            }
            JSONObject put4 = put3.put("live_stream_enter_method", str4);
            String str5 = this.mEnterAction;
            if (str5 == null) {
                str5 = "none";
            }
            JSONObject put5 = put4.put("live_stream_enter_action", str5);
            String str6 = this.mCdnPlayURL;
            if (str6 != null) {
                str2 = str6;
            }
            JSONObject put6 = put5.put("cdn_play_url", str2);
            String str7 = this.mCdnIp;
            if (str7 == null) {
                str7 = "none";
            }
            JSONObject put7 = put6.put("cdn_ip", str7).put("request_url", this.mRequestUrl).put("ip_from_player_core", this.mIpIsFromPlayerCore ? 1 : 0).put("is_preview", this.mIsPreview ? 1 : 0).put("push_client_sdk_version", this.mPushClientSDKVersion).put("push_client_platform", this.mPushClientPlatform).put("push_client_os_version", this.mPushClientOSVersion).put("push_client_model", this.mPushClientModel).put("push_client_start_time", this.mPushClientStartTime).put("push_client_is_hardware_encode", this.mPushClientHardwareEncode).put("push_client_min_bitrate", this.mPushClientMinBitrate).put("push_client_max_bitrate", this.mPushClientMaxBitrate).put("push_client_default_bitrate", this.mPushClientDefaultBitrate).put("push_client_push_protocol", this.mPushClientPushProtocal).put("push_client_qid", this.mPushClientQId).put("push_client_hit_node_optimize", this.mPushClientHitNodeOptimize).put("open_dns_optimizer", this.mOpenNodeOptimizer ? 1 : 0).put("hit_node_optimize", this.mHitNodeOptimizer ? 1 : 0).put("evaluator_symbol", this.mEvaluatorSymbol).put("remote_sorted", this.mIsRemoteSorted ? 1 : 0).put("common_tag", this.mCommonFlag).put("codec_type", this.mCodecType).put("codec_name", this.mCodecName).put("hardware_decode", this.mHardDecodeEnable ? 1 : 0).put("sharp", this.mEnableSharp ? 1 : 0).put("enable_hurry", this.mEnableHurry ? 1 : 0).put("hurry_time", this.mHurryTime).put("catch_speed", new DecimalFormat("0.00").format(this.mCatchSpeed)).put("slow_play_time", this.mSlowPlayTime).put("slow_speed", new DecimalFormat("0.00").format(this.mSlowSpeed)).put("first_screen", this.mHasFirstFrame ? 1 : 0).put("enable_httpDns", this.mEnableHttpDns ? 1 : 0).put("enable_ntp", this.mEnableNTP).put("enable_media_codec_async", this.mMediaCodecAsyncInit).put("default_codec_id", this.mDefaultCodecID).put("url_ability", this.mUrlAbility).put("max_cache_seconds", this.mMaxCacheSeconds).put("enable_fast_open", this.mEnableFastOpenStream).put("enable_mdl", this.mEnableOpenMDL).put("enable_p2p", this.mEnableP2P).put("p2p_loader_type", this.mP2PLoaderType).put("used_p2p", this.mUsedP2P);
            String str8 = this.mMDLVersion;
            if (str8 == null) {
                str8 = "none";
            }
            JSONObject put8 = put7.put("mdl_version", str8).put("enable_mdl_proto", this.mEnableMdlProto).put("enable_low_latency_flv", this.mEnableLowLatencyFLV);
            String str9 = this.mLogBundle.dnsIP;
            if (str9 == null) {
                str9 = "none";
            }
            JSONObject put9 = put8.put("dns_ip", str9).put("in_main_looper", this.mIsInMainLooper).put("start_play_buffer_threshold", this.mStartPlayBufferThres).put("fast_open_gop_cache", this.mFastOpenDuration).put("buffering_end_ignore_video", this.mCheckBufferingEndIgnoreVideo).put("start_direct_after_prepared", this.mStartDirectAfterPrepared).put("check_buffering_end_advance", this.mCheckBufferingEndAdvanceEnable).put("channel_id", this.mLogBundle.channelId);
            LogBundle logBundle = this.mSessionLogBundle;
            if (logBundle == null) {
                logBundle = this.mLogBundle;
            }
            JSONObject put10 = put9.put("sei_delay", logBundle.delay);
            LogBundle logBundle2 = this.mSessionLogBundle;
            if (logBundle2 == null) {
                logBundle2 = this.mLogBundle;
            }
            JSONObject put11 = put10.put("sei_source", logBundle2.seiSource).put("chip_board", this.mChipBoard).put("chip_hardware", this.mChipHardware).put("width", this.mWidth).put("height", this.mHeight).put("settings_info", this.mSettingsInfo).put("ttnet_nqe_info", this.mTTNetNQEInfo).put("play_format", this.mStreamFormat).put("play_protocol", this.mProtocol).put("url_set_method", this.mLiveEngine.getUrlSettingMethod()).put("enable_resolution_auto_degrade", this.mEnableResolutionAutoDegrade).put("has_abr_info", this.mHasAbrInfo).put("quic_load_succ", this.mQuicFlag).put("link_info", this.mLinkInfo).put("used_texturerender", this.mUseTextureRender ? 1 : 0).put("settings_res", this.mResolution).put("is_too_large_av_diff", this.mLogBundle.isTooLargeAVDiff).put("stall_retry_time_interval", this.mStallRetryTimeInterval).put("is_too_large_av_diff", this.mLogBundle.isTooLargeAVDiff).put("enable_rtc_play", this.mEnableRtcPlay).put("enable_mini_sdp", this.mEnableMiniSdp).put("rtc_play_fallback", this.mRtcPlayFallBack).put("fallback_type", this.mFallbackType).put("mute_audio", this.mMuteAudio).put("volume_setting", this.mVolumeSetting).put("player_volume_setting", this.mPlayerVolumeSetting).put("enable_liveio_play", this.mEnableLiveIOPlay).put("liveio_play", this.mLiveIOPlay).put("liveio_p2p", this.mLiveIOP2P);
            if (this.mEnableLiveIOPlay == 1) {
                put11.put("liveio_error_msg", this.mLiveIOErrorMsg);
                put11.put("liveio_version", this.mLiveIOVersion);
            }
            if (isRtcPlayAvailable()) {
                put11.put("rtc_get_width", this.mLiveEngine.getVideoWidth());
                put11.put("rtc_get_height", this.mLiveEngine.getVideoHeight());
            }
            if (!this.mRtcSessionId.equals("none")) {
                put11.put("live_stream_session_id", this.mRtcSessionId);
            } else {
                put11.put("live_stream_session_id", this.mSessionId);
            }
            if (this.mResolution.equals("auto")) {
                put11.put("auto_res", this.mAutoUsingResolution);
            }
            if (this.mLiveEngine.getEnableTexturerender() == 1) {
                put11.put("texturerender_error", this.mTextureRenderError);
            }
            if (this.mLiveEngine.getEnableSR() == 1 && this.mLiveEngine.getEnableTexturerender() == 1) {
                if (this.mLiveEngine.isUsedSR()) {
                    put11.put("sr_width", this.mWidth * 2).put("sr_height", this.mHeight * 2);
                    this.mSRSuccess = true;
                } else {
                    put11.put("sr_width", this.mWidth).put("sr_height", this.mHeight);
                }
            }
            VideoLiveManager videoLiveManager = this.mLiveEngine;
            if (videoLiveManager.mEnableSharpen == 1 && videoLiveManager.getEnableTexturerender() == 1) {
                put11.put("used_sharpen", this.mLiveEngine.isUsedSharpen() ? 1 : 0);
                if (!this.mHasUsedSharpen) {
                    this.mHasUsedSharpen = this.mLiveEngine.isUsedSharpen();
                }
            }
            if ((this.mEnableResolutionAutoDegrade || this.mHasAbrInfo) && put11 != null) {
                put11.put("abr_strategy", this.mAbrStrategy).put("defualt_res_bitrate", this.mDefaultResBitrate).put("stall_count_rad", this.mStallCountThresOfResolutionDegrade);
            }
            if (TextUtils.equals(this.mProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mProtocol, LiveConfigKey.QUICU)) {
                put11.put("quic_config_cached", this.mLogBundle.quicConfigCached).put("quic_CHLO_count", this.mLogBundle.quicCHLOCount);
            }
            if (this.mLiveEngine.mEnableRadioLiveDisableRender == 1) {
                put11.put("disable_video_render", this.mDisableVideoRender);
            }
            int i4 = this.mTslTimeShift;
            if (i4 > 0) {
                put11.put("tsl_timeshift", i4);
            }
            Map<String, String> map = this.mRequestHeaders;
            if (map != null) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    if (next.getKey().equals("Host")) {
                        put11.put("headers_host", next.getValue().replace(" ", ""));
                        break;
                    }
                }
            }
            int i5 = this.mFCDNTranscodeMethod;
            if (i5 != -1) {
                put11.put("fcdn_res_type", i5);
            }
            return put11;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void enableCheckSei() {
        this.mEnableCheckSei = true;
    }

    public void enableHardDecode(boolean z3) {
        this.mHardDecodeEnable = z3;
    }

    public void enableSharp() {
        this.mEnableSharp = true;
    }

    public void feedVideoDTS(long j4) {
        if (this.mVideoDTSQueue == null) {
            this.mVideoDTSQueue = new LinkedBlockingQueue<>(600);
        }
        if (this.mVideoDTSQueue.remainingCapacity() == 0 && this.mVideoDTSQueue.size() > 0) {
            this.mVideoDTSQueue.poll();
        }
        this.mVideoDTSQueue.offer(Long.valueOf(j4));
    }

    public void getABRStreamInfo() {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        videoLiveManager.getLogInfo(logBundle, 8);
    }

    public void getAVPHStreamInfo() {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        videoLiveManager.getLogInfo(logBundle, 9);
    }

    public long getInt64Value(int i4, long j4) {
        VideoLiveManager videoLiveManager;
        if (i4 != 0) {
            return i4 != 100 ? j4 : this.mLogBundle.delay;
        }
        int i5 = this.mPushClientMaxBitrate;
        return (i5 != -1 || (videoLiveManager = this.mLiveEngine) == null) ? i5 : videoLiveManager.getIntOption(i4, j4);
    }

    public JSONObject getLiveInfoItems() {
        Long l4 = 0L;
        ArrayList<Long> arrayList = this.mDownloadSpeedTimeSeries;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Long> it = this.mDownloadSpeedTimeSeries.iterator();
            while (it.hasNext()) {
                l4 = Long.valueOf(l4.longValue() + it.next().longValue());
            }
            l4 = Long.valueOf(l4.longValue() / this.mDownloadSpeedTimeSeries.size());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.mCdnPlayURL;
            if (str == null) {
                str = "-1";
            }
            JSONObject put = jSONObject.put("cdn_play_url", str);
            String str2 = this.mCdnIp;
            if (str2 == null) {
                str2 = "none";
            }
            return put.put("cdn_ip", str2).put("pull_stream_bitrate", l4);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public long getPlayingDownloadSize() {
        return this.mLogBundle.downloadSize;
    }

    public int getRetryTotalCount() {
        return this.mRetryTotalCount;
    }

    public int getStallTotalCount() {
        return (int) this.mStallTotalCount;
    }

    public JSONObject getStaticLog() {
        LogBundle logBundle = new LogBundle();
        this.mLiveEngine.getLogInfo(logBundle, 1);
        try {
            JSONObject put = new JSONObject().put("playing_time:", System.currentTimeMillis() - this.mFirstFrameTimestamp).put("live_sdk_version:", "1.4.6.31-lite");
            String str = this.mPlayerVersion;
            String str2 = "-1";
            if (str == null) {
                str = "-1";
            }
            JSONObject put2 = put.put("player_sdk_version:", str);
            String str3 = this.mCdnIp;
            if (str3 != null) {
                str2 = str3;
            }
            JSONObject put3 = put2.put("cdn_ip:", str2).put("push_client_sdk_version:", this.mPushClientSDKVersion).put("push_client_platform:", this.mPushClientPlatform).put("push_client_model:", this.mPushClientModel).put("push_client_os_version:", this.mPushClientOSVersion).put("push_client_is_hardware_encode:", this.mPushClientHardwareEncode).put("push_client_push_protocol:", this.mPushClientPushProtocal).put("push_client_qid:", this.mPushClientQId).put("push_client_bitrate:", this.mLogBundle.seiBitrate).put("push_client_fps:", this.mLogBundle.seiFps).put("Hit_Node_Optimizer:", this.mHitNodeOptimizer ? 1 : 0).put("Evaluator_Symbol:", this.mEvaluatorSymbol).put("Is_Remote_Sorted:", this.mIsRemoteSorted ? 1 : 0).put("Stall_Total_Count:", this.mStallTotalCount).put("Stall_Total_Time:", this.mStallTotalTime);
            long j4 = this.mStallReason;
            JSONObject put4 = put3.put("Stall_Reason:", j4 == -1 ? "no stall" : j4 == 0 ? "network stall" : "decode stall").put("audio_Render_Stall_Total_Count\uff1a", this.mAudioRenderStallTotalCount).put("audio_Render_Stall_Total_Time\uff1a", this.mAudioRenderStallTotalTime).put("video_Render_Stall_Total_Count\uff1a", this.mVideoRenderStallTotalCount).put("video_Render_Stall_Total_Time\uff1a", this.mVideoRenderStallTotalTime);
            LogBundle logBundle2 = this.mLogBundle;
            return put4.put("first_frame_time:", logBundle2.videoRenderTimestamp - logBundle2.startPlayTime).put("video_Buffer_Time:", logBundle.videoBufferTime).put("audio_Buffer_Time:", logBundle.audioBufferTime).put("delay:", this.mLogBundle.delay).put("render_fps:", logBundle.fps).put("sei_source:", this.mLogBundle.seiSource).put("download_Speed:", logBundle.downloadSpeed).put("Error_Code:", this.mErrorCode).put("HardDecode:", this.mHardDecodeEnable).put("Codec_Type:", this.mCodecType).put("Codec_Name:", this.mCodecName).put("MDL_Vendor:", this.mUsedP2P == 1 ? "PCDN" : this.mEnableOpenMDL == 1 ? "Http-CDN" : "none").put("audio_Buffer_Time_On_First_Frame:", this.mLogBundle.audioBufferTimeOnFirstFrame).put("waiting_Time_After_First_Frame:", this.mLogBundle.waitingTimeAfterFirstFrame).put("dns_ip:", this.mLogBundle.dnsIP).put("url:", this.mCdnPlayURL).put("width:", this.mWidth).put("height:", this.mHeight).put("resolution:", logBundle.resolution).put("play_format:", this.mStreamFormat).put("play_protocol:", this.mProtocol).put("settings_res:", this.mResolution).put("enable_resolution_auto_degrade:", this.mEnableResolutionAutoDegrade);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i4 = message.what;
        if (101 == i4) {
            report(false);
        }
        if (102 == i4) {
            reportUpdateSessionSeries();
            return true;
        }
        return true;
    }

    public boolean isInErrorRecovering() {
        return this.mIsInErrorRecovering;
    }

    public boolean isPreview() {
        return this.mIsPreview;
    }

    public boolean isRtcPlayAvailable() {
        return this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 0;
    }

    public boolean isStalling() {
        return this.mIsStalling;
    }

    public void onAbrSwitch(long j4, String str, boolean z3) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject createCommonLog = createCommonLog();
            createCommonLog.put("event_key", "abr_switch").put("auto_switch", z3 ? 1 : 0).put("target_resoultion", str).put("predict_bitrate", j4).put("abr_switch_info", this.mAbrSwitchInfo).put("cur_download_speed", this.mCurDownloadSpeed).put("cur_audio_buffer_time", this.mCurAudioBufferTime).put("cur_video_buffer_time", this.mCurVideoBufferTime).put("stall_count", this.mStallTotalCount).put("switch_cost", this.mAbrSwitchCost).put("use_expect_bitrate", this.mUseExpectBitrate);
            this.mUseExpectBitrate = 0;
            this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            long j5 = this.mLogTotalCount;
            if (j5 > 0) {
                this.mLogTotalCount = j5 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onAudioDTSRollback(long j4, long j5) {
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "timestamp_rollback").put("packet_type", "audio").put("timestamp_type", "dts").put("latest_ts", j5).put("previous_ts", j4);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j6 = this.mLogTotalCount;
                if (j6 > 0) {
                    this.mLogTotalCount = j6 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onAudioRenderStart(long j4) {
        this.mLogBundle.audioRenderTimestamp = j4;
        if (this.mEnableReportSessionStop == 1) {
            this.mSessionAudioRenderStartTime = j4;
        }
    }

    public void onCallNotInMainThread(String str) {
        JSONObject createCommonLog;
        if (this.mLiveEngine == null || this.mLogUploader == null || (createCommonLog = createCommonLog()) == null) {
            return;
        }
        try {
            createCommonLog.put("event_key", "call_not_in_main_thread").put("api_name", str);
            this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            long j4 = this.mLogTotalCount;
            if (j4 > 0) {
                this.mLogTotalCount = j4 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onCallPrepare() {
        if (this.mHasFirstFrame) {
            return;
        }
        this.mLogBundle.callPrepareTime = System.currentTimeMillis();
        LogBundle logBundle = this.mSessionLogBundle;
        if (logBundle != null) {
            logBundle.callPrepareTime = System.currentTimeMillis();
        }
    }

    public void onDecoderStall(long j4, int i4, boolean z3) {
        if (j4 <= System.currentTimeMillis() - this.mLogBundle.startPlayTime && j4 > i4) {
            if (z3) {
                this.mVideoDecodeStallTotalCount++;
                this.mVideoDecodeStallTotalTime += j4;
            } else {
                this.mAudioDecodeStallTotalCount++;
                this.mAudioDecodeStallTotalTime += j4;
            }
            JSONObject createCommonLog = createCommonLog();
            if (createCommonLog != null) {
                try {
                    createCommonLog.put("event_key", "decode_stall").put("type", z3 ? "video" : "audio").put("decode_stall_time", j4);
                    this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                    long j5 = this.mLogTotalCount;
                    if (j5 > 0) {
                        this.mLogTotalCount = j5 + 1;
                        return;
                    }
                    return;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            return;
        }
        MyLog.i(TAG, "abnormal decode stall time" + j4);
    }

    public void onDemuxerStall(long j4, int i4, boolean z3) {
        if (j4 <= System.currentTimeMillis() - this.mLogBundle.startPlayTime && j4 > i4) {
            if (z3) {
                this.mVideoDemuxStallTotalCount++;
                this.mVideoDemuxStallTotalTime += j4;
            } else {
                this.mAudioDemuxStallTotalCount++;
                this.mAudioDemuxStallTotalTime += j4;
            }
            JSONObject createCommonLog = createCommonLog();
            if (createCommonLog != null) {
                try {
                    createCommonLog.put("event_key", "demux_stall").put("type", z3 ? "video" : "audio").put("demux_stall_time", j4);
                    this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                    long j5 = this.mLogTotalCount;
                    if (j5 > 0) {
                        this.mLogTotalCount = j5 + 1;
                        return;
                    }
                    return;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            return;
        }
        MyLog.i(TAG, "abnormal demux stall time" + j4);
    }

    public void onError(int i4, String str) {
        if (this.mErrorTimeSeries == null) {
            this.mErrorTimeSeries = new JSONObject();
        }
        try {
            this.mErrorTimeSeries.put(Long.toString(System.currentTimeMillis() - this.mLogBundle.startPlayTime), i4);
        } catch (JSONException e4) {
            this.mErrorTimeSeries = null;
            e4.printStackTrace();
        }
        this.mLiveEngine.getLogInfo(this.mLogBundle, 2);
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "play_error").put("code", i4).put("info", str);
                reportQuicOpenResult(createCommonLog);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
                this.mErrorCode = i4;
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    public void onErrorRecovered() {
        this.mIsInErrorRecovering = false;
        long currentTimeMillis = System.currentTimeMillis() - this.mErrorStartTime;
        Log.i(TAG, "recover from error time " + currentTimeMillis);
        if (this.mErrorStartTime != 0) {
            this.mErrorRecoverCount++;
            this.mErrorRecoverTime += System.currentTimeMillis() - this.mErrorStartTime;
        }
    }

    public void onFirstFrame(long j4, long j5) {
        LogBundle logBundle;
        this.mHasFirstFrame = true;
        this.mFirstFrameRetryCount = this.mRetryTotalCount;
        this.mFirstFramePrepareTime = this.mLastPrepareTime;
        this.mFirstFrameTimestamp = System.currentTimeMillis();
        if (this.mLiveEngine == null || this.mLogUploader == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        try {
            logBundle.playTime = System.currentTimeMillis();
            this.mLiveEngine.getLogInfo(this.mLogBundle, 0);
            JSONObject createFirstFrameLog = createFirstFrameLog(this.mLogBundle, j4, this.mIsHitCache, j5);
            this.mFirstFrameView = this.mFirstFrameTimestamp - this.mLogBundle.startPlayTime;
            String str = this.mStreamFormat;
            if (str != null && (str.equals(LiveConfigKey.CMAF) || this.mStreamFormat.equals(LiveConfigKey.AVPH))) {
                createFirstFrameLog.put("video_dns_analysis_end", this.mLogBundle.videoDNSTimestamp).put("audio_dns_analysis_end", this.mLogBundle.audioDNSTimestamp).put("video_tcp_connect_time", this.mLogBundle.videoTcpConnectTimestamp).put("audio_tcp_connect_time", this.mLogBundle.audioTcpConnectTimestamp).put("video_tcp_first_packet_time", this.mLogBundle.videoTcpFirstPacketTimestamp).put("audio_tcp_first_packet_time", this.mLogBundle.audioTcpFirstPacketTimestamp).put("video_http_req_finish_time", this.mLogBundle.videoHttpReqFinishTimestamp).put("audio_http_req_finish_time", this.mLogBundle.audioHttpReqFinishTimestamp).put("video_http_res_finish_time", this.mLogBundle.videoHttpResFinishTimestamp).put("audio_http_res_finish_time", this.mLogBundle.audioHttpResFinishTimestamp);
                if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                    createFirstFrameLog.put("cmaf_mpd_dns_analysis_end", this.mLogBundle.cmafMpdDNSTimestamp).put("cmaf_mpd_tcp_connect_time", this.mLogBundle.cmafMpdTcpConntectTimestamp).put("cmaf_mpd_tcp_first_package_end", this.mLogBundle.cmafMdpTcpFirstPacketTimestamp).put("cmaf_mpd_http_req_finish_time", this.mLogBundle.cmafMdpHttpReqFinishTimestamp).put("cmaf_mpd_http_res_finish_time", this.mLogBundle.cmafMdpHttpResFinishTimestamp).put("cmaf_audio_firstseg_connect_time", this.mLogBundle.cmafAudioFirstSegConntectTimestamp).put("cmaf_video_firstseg_connect_time", this.mLogBundle.cmafVideoFirstSegConntectTimestamp).put("cmaf_mpd_connect_time", this.mLogBundle.cmafMpdConntectTimestamp);
                }
                reportQuicOpenResult(createFirstFrameLog);
            }
            this.mLogUploader.onMonitorLog(createFirstFrameLog, MONITOR_LOG_TYPE);
            long j6 = this.mLogTotalCount;
            if (j6 > 0) {
                this.mLogTotalCount = j6 + 1;
            }
            this.mSpeedSwitchInfo = "1.0:" + this.mFirstFrameTimestamp;
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onFirstFrameFail(int i4) {
        VideoLiveManager videoLiveManager;
        if (this.mHasFirstFrame || (videoLiveManager = this.mLiveEngine) == null || this.mLogUploader == null) {
            return;
        }
        videoLiveManager.getLogInfo(this.mLogBundle, 2);
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "first_frame_failed").put("start_time", System.currentTimeMillis()).put("reason", i4);
                reportQuicOpenResult(createCommonLog);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onIllegalAPICall(String str) {
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || this.mLogUploader == null) {
            return;
        }
        videoLiveManager.getLogInfo(this.mLogBundle, 2);
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "illegal_call").put("api_name", str);
                reportQuicOpenResult(createCommonLog);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onLoaderError(int i4, String str) {
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "p2p_error").put("error_msg", str).put("code", i4);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onLoaderSwitch(int i4, String str) {
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                if (str.equals("cdn_to_p2p")) {
                    this.mUsedP2P = 1;
                }
                createCommonLog.put("event_key", "p2p_switch").put("switch_info", str).put("p2p_vendor", "none").put("reason", i4);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onPlay(String str, String str2) {
        if (this.mSessionLogBundle != null) {
            this.mSessionStartTime = System.currentTimeMillis();
        }
        this.mLogBundle.startPlayTime = System.currentTimeMillis();
        this.mLogBundle.dnsIP = str2;
        this.mCdnPlayURL = str;
        this.mCurrentPlayURL = str;
        JSONObject createCommonLog = createCommonLog();
        this.mLogTotalCount = 0L;
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "start_play").put("rule_ids", this.mRuleIds).put("set_surface_cost", this.mSetSurfaceCost).put("start_play_time", this.mLogBundle.startPlayTime).put("stream_data", this.mStreamData).put("suggest_format", this.mSuggestFormat).put("play_format", this.mStreamFormat).put("suggest_protocol", this.mSuggestProtocol).put("origin_url", this.mOriginUrl).put("log_total_count_when_playing", this.mLogTotalCount);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                this.mLogTotalCount++;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[Catch: JSONException -> 0x00c7, TryCatch #0 {JSONException -> 0x00c7, blocks: (B:13:0x0028, B:15:0x0031, B:21:0x003e, B:23:0x004a, B:25:0x0052, B:29:0x0064, B:33:0x006f, B:35:0x00a7, B:39:0x00b1, B:41:0x00c1), top: B:46:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1 A[Catch: JSONException -> 0x00c7, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00c7, blocks: (B:13:0x0028, B:15:0x0031, B:21:0x003e, B:23:0x004a, B:25:0x0052, B:29:0x0064, B:33:0x006f, B:35:0x00a7, B:39:0x00b1, B:41:0x00c1), top: B:46:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPrepare(int r12) {
        /*
            r11 = this;
            com.bykv.vk.component.ttvideo.VideoLiveManager r0 = r11.mLiveEngine
            if (r0 != 0) goto L5
            return
        L5:
            org.json.JSONObject r0 = r11.createCommonLog()
            com.bykv.vk.component.ttvideo.VideoLiveManager r1 = r11.mLiveEngine
            com.bykv.vk.component.ttvideo.log.LogBundle r2 = r11.mLogBundle
            r3 = 7
            r1.getLogInfo(r2, r3)
            int r1 = r11.mEnableReportSessionStop
            java.lang.String r2 = "none"
            r3 = 1
            if (r1 != r3) goto L26
            r11.mSessionErrorCode = r12
            if (r12 == 0) goto L23
            com.bykv.vk.component.ttvideo.VideoLiveManager r1 = r11.mLiveEngine
            java.lang.String r1 = r1.getPlayerErrorInfo()
            goto L24
        L23:
            r1 = r2
        L24:
            r11.mSessionErrorMsg = r1
        L26:
            if (r0 == 0) goto Lcb
            long r4 = r11.mFirstAudioPacketDTS     // Catch: org.json.JSONException -> Lc7
            r6 = 0
            r1 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L3d
            long r8 = r11.mPreviousAudioPacketDTS     // Catch: org.json.JSONException -> Lc7
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 <= 0) goto L3d
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 >= 0) goto L3d
            r4 = 1
            goto L3e
        L3d:
            r4 = 0
        L3e:
            java.lang.String r5 = "event_key"
            java.lang.String r8 = "prepare_result"
            org.json.JSONObject r5 = r0.put(r5, r8)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r8 = "error_msg"
            if (r12 == 0) goto L51
            com.bykv.vk.component.ttvideo.VideoLiveManager r9 = r11.mLiveEngine     // Catch: org.json.JSONException -> Lc7
            java.lang.String r9 = r9.getPlayerErrorInfo()     // Catch: org.json.JSONException -> Lc7
            goto L52
        L51:
            r9 = r2
        L52:
            org.json.JSONObject r5 = r5.put(r8, r9)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r8 = "result"
            org.json.JSONObject r12 = r5.put(r8, r12)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r5 = "sdk_params"
            java.lang.String r8 = r11.mSdkParams     // Catch: org.json.JSONException -> Lc7
            if (r8 != 0) goto L63
            goto L64
        L63:
            r2 = r8
        L64:
            org.json.JSONObject r12 = r12.put(r5, r2)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "first_audio_packet_dts_rollback"
            if (r4 == 0) goto L6e
            r4 = 1
            goto L6f
        L6e:
            r4 = 0
        L6f:
            org.json.JSONObject r12 = r12.put(r2, r4)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "first_audio_packet_dts"
            long r4 = r11.mFirstAudioPacketDTS     // Catch: org.json.JSONException -> Lc7
            org.json.JSONObject r12 = r12.put(r2, r4)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "previous_audio_packet_dts"
            long r4 = r11.mPreviousAudioPacketDTS     // Catch: org.json.JSONException -> Lc7
            org.json.JSONObject r12 = r12.put(r2, r4)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "stream_type"
            com.bykv.vk.component.ttvideo.log.LogBundle r4 = r11.mLogBundle     // Catch: org.json.JSONException -> Lc7
            int r4 = r4.mStreamType     // Catch: org.json.JSONException -> Lc7
            org.json.JSONObject r12 = r12.put(r2, r4)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "suggest_format"
            java.lang.String r4 = r11.mSuggestFormat     // Catch: org.json.JSONException -> Lc7
            org.json.JSONObject r12 = r12.put(r2, r4)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "suggest_protocol"
            java.lang.String r4 = r11.mSuggestProtocol     // Catch: org.json.JSONException -> Lc7
            org.json.JSONObject r12 = r12.put(r2, r4)     // Catch: org.json.JSONException -> Lc7
            java.lang.String r2 = "nnsr_enabled"
            com.bykv.vk.component.ttvideo.VideoLiveManager r4 = r11.mLiveEngine     // Catch: org.json.JSONException -> Lc7
            boolean r4 = r4.getSRState()     // Catch: org.json.JSONException -> Lc7
            if (r4 != 0) goto Lb1
            com.bykv.vk.component.ttvideo.VideoLiveManager r4 = r11.mLiveEngine     // Catch: org.json.JSONException -> Lc7
            boolean r4 = r4.getSharpenState()     // Catch: org.json.JSONException -> Lc7
            if (r4 == 0) goto Lb0
            goto Lb1
        Lb0:
            r3 = 0
        Lb1:
            r12.put(r2, r3)     // Catch: org.json.JSONException -> Lc7
            com.bykv.vk.component.ttvideo.ILiveListener r12 = r11.mLogUploader     // Catch: org.json.JSONException -> Lc7
            java.lang.String r1 = "live_client_monitor_log"
            r12.onMonitorLog(r0, r1)     // Catch: org.json.JSONException -> Lc7
            long r0 = r11.mLogTotalCount     // Catch: org.json.JSONException -> Lc7
            int r12 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r12 <= 0) goto Lcb
            r2 = 1
            long r0 = r0 + r2
            r11.mLogTotalCount = r0     // Catch: org.json.JSONException -> Lc7
            goto Lcb
        Lc7:
            r12 = move-exception
            r12.printStackTrace()
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.LiveLoggerService.onPrepare(int):void");
    }

    public void onPrepareEnd() {
        LogBundle logBundle = this.mSessionLogBundle;
        if (logBundle != null) {
            logBundle.prepareEndTimestamp = System.currentTimeMillis();
        }
        if (this.mHasFirstFrame) {
            return;
        }
        this.mLogBundle.prepareEndTimestamp = System.currentTimeMillis();
    }

    public void onPtsBack(long j4, boolean z3) {
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "pts_back").put("type", z3 ? "video" : "audio").put("pts_back_diff", j4);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onRecvRtcEventNotify(String str) {
        if (this.mLiveEngine == null || this.mLogUploader == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = TAG;
            MyLog.i(str2, "recv event notify: " + jSONObject);
            updateRequestTimeFieldInRtcPlay(jSONObject);
        } catch (Exception e4) {
            String str3 = TAG;
            MyLog.e(str3, "recv event notify error occurs error:" + e4.toString());
        }
    }

    public void onRecvedRtcTraceInfo(String str) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put("product_line", "rts");
                jSONObject.put("rtc_trace_info", str);
                if (!str.isEmpty() && str.contains("rts_play_stop")) {
                    this.mRtcPlayStopStatInfo = new JSONObject(str).optString("event_message");
                }
            }
            this.mLogUploader.onMonitorLog(jSONObject, RTC_MONITOR_LOG_TYPE);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onRecvedSPSPPS(String str) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject createCommonLog = createCommonLog();
            createCommonLog.put("event_key", "recved_spspps").put("spspps", str);
            this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            long j4 = this.mLogTotalCount;
            if (j4 > 0) {
                this.mLogTotalCount = j4 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onRenderStall(long j4, int i4, boolean z3, boolean z4) {
        if (j4 > System.currentTimeMillis() - this.mLogBundle.startPlayTime || j4 <= i4) {
            MyLog.i(TAG, "abnormal render stall time" + j4);
            return;
        }
        if (z3) {
            MyLog.i(TAG, "video render stall time " + j4);
            this.mPlayingVideoRenderStallCount = this.mPlayingVideoRenderStallCount + 1;
            this.mVideoRenderStallTotalCount = this.mVideoRenderStallTotalCount + 1;
            this.mPlayingVideoRenderStallTime = (int) (((long) this.mPlayingVideoRenderStallTime) + j4);
            this.mVideoRenderStallTotalTime += j4;
            if (this.mEnableReportSessionStop == 1) {
                this.mSessionVideoRenderStallTotalCount++;
                this.mSessionVideoRenderStallTotalTime += j4;
            }
        } else {
            MyLog.i(TAG, "audio render stall time " + j4);
            this.mPlayingAudioRenderStallCount = this.mPlayingAudioRenderStallCount + 1;
            this.mAudioRenderStallTotalCount = this.mAudioRenderStallTotalCount + 1;
            this.mPlayingAudioRenderStallTime = (int) (((long) this.mPlayingAudioRenderStallTime) + j4);
            this.mAudioRenderStallTotalTime += j4;
            if (this.mEnableReportSessionStop == 1) {
                this.mSessionAudioRenderStallTotalCount++;
                this.mSessionAudioRenderStallTotalTime += j4;
            }
        }
        if (z4) {
            JSONObject createCommonLog = createCommonLog();
            this.mLiveEngine.getLogInfo(this.mLogBundle, 4);
            if (createCommonLog != null) {
                try {
                    createCommonLog.put("event_key", "render_stall").put("type", z3 ? "video" : "audio").put("render_stall_time", j4).put("video_buffer_time", this.mLogBundle.videoBufferTime).put("audio_buffer_time", this.mLogBundle.audioBufferTime);
                    this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                    long j5 = this.mLogTotalCount;
                    if (j5 > 0) {
                        this.mLogTotalCount = j5 + 1;
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void onRetry(int i4) {
        this.mRetryCount++;
        this.mRetryTotalCount++;
        this.mLiveEngine.getLogInfo(this.mLogBundle, 2);
        JSONObject createCommonLog = createCommonLog();
        calculateRenderFailType();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", AdLogEventRepo.COL_RETRY_COUNT).put("reason", this.mErrorCode).put("code", i4).put("render_fail_type", this.mRenderFailType);
                reportQuicOpenResult(createCommonLog);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onRtcDecoderStall(long j4, boolean z3) {
        if (j4 > System.currentTimeMillis() - this.mLogBundle.startPlayTime) {
            String str = TAG;
            MyLog.i(str, "abnormal rtc decode stall time" + j4);
            return;
        }
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "rtc_decode_stall").put("type", z3 ? "video" : "audio").put("decode_stall_time", j4);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j5 = this.mLogTotalCount;
                if (j5 > 0) {
                    this.mLogTotalCount = j5 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onSDKDNSComplete(boolean z3, boolean z4) {
        this.mLogBundle.SDKDNSTimeStamp = System.currentTimeMillis();
        LogBundle logBundle = this.mSessionLogBundle;
        if (logBundle != null) {
            logBundle.SDKDNSTimeStamp = System.currentTimeMillis();
        }
        this.mHitNodeOptimizer = z4;
        this.mIsHitCache = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: JSONException -> 0x0074, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0074, blocks: (B:4:0x0006, B:7:0x0028, B:9:0x0050, B:14:0x005c, B:16:0x006e), top: B:21:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSDKDNSError(com.bykv.vk.component.ttvideo.log.LiveError r5) {
        /*
            r4 = this;
            org.json.JSONObject r0 = r4.createCommonLog()
            if (r0 == 0) goto L78
            java.lang.String r1 = "event_key"
            java.lang.String r2 = "prepare_result"
            org.json.JSONObject r1 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L74
            java.lang.String r2 = "error_msg"
            java.lang.String r3 = r5.getInfoJSON()     // Catch: org.json.JSONException -> L74
            org.json.JSONObject r1 = r1.put(r2, r3)     // Catch: org.json.JSONException -> L74
            java.lang.String r2 = "result"
            int r5 = r5.code     // Catch: org.json.JSONException -> L74
            org.json.JSONObject r5 = r1.put(r2, r5)     // Catch: org.json.JSONException -> L74
            java.lang.String r1 = "sdk_params"
            java.lang.String r2 = r4.mSdkParams     // Catch: org.json.JSONException -> L74
            if (r2 != 0) goto L28
            java.lang.String r2 = "none"
        L28:
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L74
            java.lang.String r1 = "stream_type"
            com.bykv.vk.component.ttvideo.log.LogBundle r2 = r4.mLogBundle     // Catch: org.json.JSONException -> L74
            int r2 = r2.mStreamType     // Catch: org.json.JSONException -> L74
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L74
            java.lang.String r1 = "suggest_format"
            java.lang.String r2 = r4.mSuggestFormat     // Catch: org.json.JSONException -> L74
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L74
            java.lang.String r1 = "suggest_protocol"
            java.lang.String r2 = r4.mSuggestProtocol     // Catch: org.json.JSONException -> L74
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L74
            java.lang.String r1 = "nnsr_enabled"
            com.bykv.vk.component.ttvideo.VideoLiveManager r2 = r4.mLiveEngine     // Catch: org.json.JSONException -> L74
            boolean r2 = r2.getSRState()     // Catch: org.json.JSONException -> L74
            if (r2 != 0) goto L5b
            com.bykv.vk.component.ttvideo.VideoLiveManager r2 = r4.mLiveEngine     // Catch: org.json.JSONException -> L74
            boolean r2 = r2.getSharpenState()     // Catch: org.json.JSONException -> L74
            if (r2 == 0) goto L59
            goto L5b
        L59:
            r2 = 0
            goto L5c
        L5b:
            r2 = 1
        L5c:
            r5.put(r1, r2)     // Catch: org.json.JSONException -> L74
            com.bykv.vk.component.ttvideo.ILiveListener r5 = r4.mLogUploader     // Catch: org.json.JSONException -> L74
            java.lang.String r1 = "live_client_monitor_log"
            r5.onMonitorLog(r0, r1)     // Catch: org.json.JSONException -> L74
            long r0 = r4.mLogTotalCount     // Catch: org.json.JSONException -> L74
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L78
            r2 = 1
            long r0 = r0 + r2
            r4.mLogTotalCount = r0     // Catch: org.json.JSONException -> L74
            goto L78
        L74:
            r5 = move-exception
            r5.printStackTrace()
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.LiveLoggerService.onSDKDNSError(com.bykv.vk.component.ttvideo.log.LiveError):void");
    }

    public void onSessionStop() {
        LogBundle logBundle;
        long currentTimeMillis;
        long j4;
        long j5;
        long j6;
        if (this.mEnableReportSessionStop == 0 || (logBundle = this.mSessionLogBundle) == null) {
            return;
        }
        this.mLiveEngine.getSessionlogInfo(logBundle);
        JSONObject createCommonLog = createCommonLog();
        if (this.mSessionHasFirstFrame) {
            j4 = System.currentTimeMillis() - this.mSessionVideoRenderStartTime;
            currentTimeMillis = 0;
        } else {
            currentTimeMillis = System.currentTimeMillis() - this.mSessionStartTime;
            j4 = 0;
        }
        this.mSessionNum++;
        long j7 = this.mSessionFirstStallStartTime;
        if (j7 > 0) {
            j5 = j7 - this.mSessionVideoRenderStartTime;
            j6 = this.mSessionFirstStallEndTime - j7;
        } else {
            j5 = 0;
            j6 = 0;
        }
        if (isStalling()) {
            this.mSessionStallTotalCount++;
            this.mSessionStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
        }
        calculateSessionRenderFailType();
        long j8 = this.mSessionLogBundle.downloadSize;
        if (createCommonLog != null) {
            try {
                JSONObject put = createCommonLog.put("event_key", "session_stop").put("index", this.mSessionNum).put("stop_time", System.currentTimeMillis()).put("play_time", j4).put("is_stream_received", this.mSessionHasFirstFrame ? 1 : 0).put("render_fail_type", this.mSessionRenderFailType).put("code", this.mSessionErrorCode).put("stall_count", this.mSessionStallTotalCount).put("stall_time", this.mSessionStallTotalTime).put("audio_render_stall_count", this.mSessionAudioRenderStallTotalCount).put("audio_render_stall_time", this.mSessionAudioRenderStallTotalTime).put("video_render_stall_count", this.mSessionVideoRenderStallTotalCount).put("video_render_stall_time", this.mSessionVideoRenderStallTotalTime).put(CampaignEx.JSON_NATIVE_VIDEO_START, this.mSessionStartTime).put("sdk_dns_analysis_end", this.mSessionLogBundle.SDKDNSTimeStamp).put("player_dns_analysis_end", this.mLogBundle.playerDNSTimestamp).put("http_req_finish_time", this.mSessionLogBundle.httpReqFinishTimestamp).put("http_res_finish_time", this.mSessionLogBundle.httpResFinishTimestamp).put("tcp_first_package_end", this.mLogBundle.tcpFirstPacketTimestamp).put("first_video_package_end", this.mSessionLogBundle.videoPacketTimestamp).put("first_audio_package_end", this.mSessionLogBundle.audioPacketTimestamp).put("first_video_frame_decode_end", this.mSessionLogBundle.videoDecodeTimestamp).put("first_audio_frame_decode_end", this.mSessionLogBundle.audioDecodeTimestamp).put("video_device_open_start", this.mSessionLogBundle.videoDeviceOpenTime).put("video_device_open_end", this.mSessionLogBundle.videoDeviceOpenedTime).put("audio_device_open_start", this.mSessionLogBundle.audioDeviceOpenTime).put("audio_device_open_end", this.mSessionLogBundle.audioDeviceOpenedTime).put("video_device_wait_start", this.mSessionLogBundle.videoDeviceWaitStartTime).put("video_device_wait_end", this.mSessionLogBundle.videoDeviceWaitEndTime).put("find_stream_info_start", this.mSessionLogBundle.streamInfoFindTime).put("find_stream_info_end", this.mSessionLogBundle.streamInfoFoundTime).put("video_param_send_outlet_time", this.mSessionLogBundle.videoParamSendOutletTime).put("first_video_frame_send_outlet_time", this.mSessionLogBundle.firstVideoFrameSendOutletTime).put("first_frame_render_end", this.mSessionVideoRenderStartTime).put("first_audio_frame_end", this.mSessionAudioRenderStartTime).put("prepare_end", this.mSessionLogBundle.prepareEndTimestamp).put("prepare_block_end", this.mSessionLogBundle.callPrepareTime).put("video_first_pkt_pos", this.mSessionLogBundle.videoFirstPacketPos).put("video_first_pkt_pts", this.mSessionLogBundle.videoFirstPacketPts).put("audio_first_pkt_pos", this.mSessionLogBundle.audioFirstPacketPos).put("audio_first_pkt_pts", this.mSessionLogBundle.audioFirstPacketPts).put("video_render_type", this.mSessionLogBundle.renderType).put("download_speed", this.mSessionLogBundle.downloadSpeedOnFirstFrame).put("video_buffer_time", this.mSessionLogBundle.videoBufferTimeOnFirstFrame).put("audio_buffer_time", this.mSessionLogBundle.audioBufferTimeOnFirstFrame).put("wait_time", this.mSessionLogBundle.waitingTimeAfterFirstFrame > 0 ? this.mLogBundle.waitingTimeAfterFirstFrame : -this.mLogBundle.waitingTimeAfterFirstFrame).put("is_waiting", this.mSessionLogBundle.waitingTimeAfterFirstFrame >= 0 ? 0 : 1).put("first_stall_time", j5).put("first_stall_duration", j6).put("play_time_on_no_frame", currentTimeMillis);
                String str = this.mSdkParams;
                if (str == null) {
                    str = "none";
                }
                put.put("sdk_params", str).put("total_download_size", j8).put("drop_audio_pts_diff", this.mSessionLogBundle.dropAudioPts).put("drop_audio_cost", this.mSessionLogBundle.dropAudioCostTime).put("sr_used", this.mSRSuccess ? 1 : 0).put("sharpen_used", this.mHasUsedSharpen ? 1 : 0).put("network_timeout", this.mNetworkTimeoutMs).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("error_msg", this.mSessionErrorMsg);
                if (this.mCdnPlayURL == null) {
                    createCommonLog.put("tcp_connect_end", this.mSessionLogBundle.tcpConnectTimestamp);
                } else {
                    createCommonLog.put("tcp_connect_end", this.mProtocol.equals(LiveConfigKey.KCP) ? this.mSessionLogBundle.playerDNSTimestamp : this.mSessionLogBundle.tcpConnectTimestamp);
                }
                this.mLogTotalCount++;
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        resetSessionInfo();
    }

    public void onStallEnd(int i4) {
        if (this.mErrorCode == -100015) {
            this.mErrorCode = 0;
        }
        if (this.mIsStalling) {
            this.mIsStalling = false;
            JSONObject createCommonLog = createCommonLog();
            if (this.mStallTimeSeries == null) {
                this.mStallTimeSeries = new ArrayList<>();
            }
            this.mStallTimeSeries.add(Long.valueOf(-(System.currentTimeMillis() - this.mLogBundle.startPlayTime)));
            if (this.mFirstStallEndTime == 0) {
                this.mFirstStallEndTime = System.currentTimeMillis();
            }
            if (this.mEnableReportSessionStop == 1 && this.mSessionFirstStallEndTime == 0) {
                this.mSessionFirstStallEndTime = System.currentTimeMillis();
            }
            this.mLiveEngine.getLogInfo(this.mLogBundle, 6);
            if (createCommonLog == null || this.mStallStartTime == 0) {
                return;
            }
            try {
                if (this.mPlayingStallStartTime != 0) {
                    this.mPlayingStallCount++;
                    this.mPlayingStallTime = (int) (this.mPlayingStallTime + (System.currentTimeMillis() - this.mPlayingStallStartTime));
                }
                this.mStallTotalCount++;
                this.mStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
                if (this.mEnableReportSessionStop == 1) {
                    this.mSessionStallTotalCount++;
                    this.mSessionStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
                }
                createCommonLog.put("event_key", "stall").put("stall_start", this.mStallStartTime).put("stall_end", System.currentTimeMillis()).put("video_buffer_time_stall_start", this.mLogBundle.videoBufferTimeOnStallStart).put("audio_buffer_time_stall_start", this.mLogBundle.audioBufferTimeOnStallStart).put("video_buffer_time_stall_end", this.mLogBundle.videoBufferTimeOnStallEnd).put("audio_buffer_time_stall_end", this.mLogBundle.audioBufferTimeOnStallEnd).put("last_res", this.mLastResolution).put("reason", this.mStallReason).put("recover_reason", i4);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j4 = this.mLogTotalCount;
                if (j4 > 0) {
                    this.mLogTotalCount = j4 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onStallStart(int i4, boolean z3) {
        this.mErrorCode = LiveError.PLAYER_STALL;
        if (z3) {
            this.mLiveEngine.getLogInfo(this.mLogBundle, 5);
            long currentTimeMillis = System.currentTimeMillis();
            this.mStallStartTime = currentTimeMillis;
            if (this.mFirstStallStartTime == 0) {
                this.mFirstStallStartTime = currentTimeMillis;
            }
            if (this.mEnableReportSessionStop == 1) {
                if (this.mSessionFirstStallStartTime == 0) {
                    this.mSessionFirstStallStartTime = currentTimeMillis;
                }
                this.mSessionErrorCode = this.mErrorCode;
            }
            this.mPlayingStallStartTime = currentTimeMillis;
            this.mStallReason = i4;
            this.mIsStalling = true;
            if (this.mStallTimeSeries == null) {
                this.mStallTimeSeries = new ArrayList<>();
            }
            this.mStallTimeSeries.add(Long.valueOf(this.mStallStartTime - this.mLogBundle.startPlayTime));
        }
    }

    public void onStop(String str) {
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        int i4;
        if (this.mHasFirstFrame) {
            report(true);
        } else {
            this.mLiveEngine.getLogInfo(this.mLogBundle, 2);
            this.mFirstFrameRetryCount = this.mRetryTotalCount;
            this.mFirstFramePrepareTime = this.mLastPrepareTime;
        }
        onSessionStop();
        resetSessionInfo();
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                if (this.mHasFirstFrame) {
                    j4 = System.currentTimeMillis() - this.mFirstFrameTimestamp;
                    j5 = 0;
                } else if (this.mErrorCode != 0 || this.mLogBundle.startPlayTime == 0) {
                    j4 = 0;
                    j5 = 0;
                } else {
                    j5 = System.currentTimeMillis() - this.mLogBundle.startPlayTime;
                    j4 = 0;
                }
                long j9 = this.mFirstStallStartTime;
                if (j9 > 0) {
                    j7 = j9 - this.mLogBundle.videoRenderTimestamp;
                    j6 = this.mFirstStallEndTime - j9;
                } else {
                    j6 = 0;
                    j7 = 0;
                }
                if (isStalling()) {
                    this.mStallTotalCount++;
                    this.mStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
                }
                if (!isInErrorRecovering() || this.mErrorStartTime == 0) {
                    j8 = j5;
                } else {
                    this.mErrorRecoverCount++;
                    j8 = j5;
                    this.mErrorRecoverTime += System.currentTimeMillis() - this.mErrorStartTime;
                }
                calculateRenderFailType();
                long j10 = this.mLastTotalDownloadSize + this.mLogBundle.downloadSize;
                JSONObject put = createCommonLog.put("event_key", "play_stop").put("stop_time", System.currentTimeMillis()).put("play_time", j4).put("is_stream_received", this.mHasFirstFrame ? 1 : 0).put("render_fail_type", this.mRenderFailType).put("code", this.mErrorCode).put("stall_count", this.mStallTotalCount).put("stall_time", this.mStallTotalTime).put("audio_render_stall_count", this.mAudioRenderStallTotalCount).put("audio_render_stall_time", this.mAudioRenderStallTotalTime).put("video_render_stall_count", this.mVideoRenderStallTotalCount).put("video_render_stall_time", this.mVideoRenderStallTotalTime).put("video_decode_stall_count", this.mVideoDecodeStallTotalCount).put("video_decode_stall_time", this.mVideoDecodeStallTotalTime).put("audio_decode_stall_count", this.mAudioDecodeStallTotalCount).put("audio_decode_stall_time", this.mAudioDecodeStallTotalTime).put("video_demux_stall_count", this.mVideoDemuxStallTotalCount).put("video_demux_stall_time", this.mVideoDemuxStallTotalTime).put("audio_demux_stall_count", this.mAudioDemuxStallTotalCount).put("audio_demux_stall_time", this.mAudioDemuxStallTotalTime).put("error_recover_count", this.mErrorRecoverCount).put("error_recover_time", this.mErrorRecoverTime).put(CampaignEx.JSON_NATIVE_VIDEO_START, this.mLogBundle.startPlayTime).put("sdk_dns_analysis_end", this.mLogBundle.SDKDNSTimeStamp).put("http_req_finish_time", this.mLogBundle.httpReqFinishTimestamp).put("http_res_finish_time", this.mLogBundle.httpResFinishTimestamp).put("first_video_package_end", this.mLogBundle.videoPacketTimestamp).put("first_audio_package_end", this.mLogBundle.audioPacketTimestamp).put("first_video_frame_decode_end", this.mLogBundle.videoDecodeTimestamp).put("first_audio_frame_decode_end", this.mLogBundle.audioDecodeTimestamp).put("first_frame_render_end", this.mLogBundle.videoRenderTimestamp).put("first_audio_frame_end", this.mLogBundle.audioRenderTimestamp).put("video_device_open_start", this.mLogBundle.videoDeviceOpenTime).put("video_device_open_end", this.mLogBundle.videoDeviceOpenedTime).put("audio_device_open_start", this.mLogBundle.audioDeviceOpenTime).put("audio_device_open_end", this.mLogBundle.audioDeviceOpenedTime).put("video_device_wait_start", this.mLogBundle.videoDeviceWaitStartTime).put("video_device_wait_end", this.mLogBundle.videoDeviceWaitEndTime).put("find_stream_info_start", this.mLogBundle.streamInfoFindTime).put("find_stream_info_end", this.mLogBundle.streamInfoFoundTime).put("video_param_send_outlet_time", this.mLogBundle.videoParamSendOutletTime).put("first_video_frame_send_outlet_time", this.mLogBundle.firstVideoFrameSendOutletTime).put("video_first_pkt_pos", this.mLogBundle.videoFirstPacketPos).put("video_first_pkt_pts", this.mLogBundle.videoFirstPacketPts).put("audio_first_pkt_pos", this.mLogBundle.audioFirstPacketPos).put("audio_first_pkt_pts", this.mLogBundle.audioFirstPacketPts).put("set_surface_time", this.mSetSurfaceTime).put("set_surface_cost", this.mSetSurfaceCost).put("video_render_type", this.mLogBundle.renderType).put("prepare_block_end", this.mLogBundle.callPrepareTime).put("prepare_end", this.mLogBundle.prepareEndTimestamp).put("retry_count", this.mRetryTotalCount).put("download_speed", this.mLogBundle.downloadSpeedOnFirstFrame).put("video_buffer_time", this.mLogBundle.videoBufferTimeOnFirstFrame).put("audio_buffer_time", this.mLogBundle.audioBufferTimeOnFirstFrame);
                long j11 = this.mLogBundle.waitingTimeAfterFirstFrame;
                if (j11 <= 0) {
                    j11 = -j11;
                }
                JSONObject put2 = put.put("wait_time", j11).put("is_waiting", this.mLogBundle.waitingTimeAfterFirstFrame >= 0 ? 0 : 1).put("first_stall_time", j7).put("first_stall_duration", j6).put("call_api_name", str).put("play_time_on_no_frame", j8).put("abr_switch_count", this.mAbrSwitchCount).put("abr_switch_count_info", this.mAbrSwitchCountInfo);
                String str2 = this.mSdkParams;
                if (str2 == null) {
                    str2 = "none";
                }
                put2.put("sdk_params", str2).put("total_download_size", j10).put("drop_audio_pts_diff", this.mLogBundle.dropAudioPts).put("drop_audio_cost", this.mLogBundle.dropAudioCostTime).put("first_frame_retry_count", this.mFirstFrameRetryCount).put("first_frame_retry_duration", this.mFirstFramePrepareTime).put("abr_check_enhance", this.mEnableLiveAbrCheckEnhance).put("sr_used", this.mSRSuccess ? 1 : 0).put("sharpen_used", this.mHasUsedSharpen ? 1 : 0).put("network_timeout", this.mNetworkTimeoutMs).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("session_num", this.mSessionNum).put("use_live_threadpool", this.mUseLiveThreadPool);
                JSONArray jSONArray = this.mLogBundle.mABRStreamInfo;
                if (jSONArray != null) {
                    createCommonLog.put("abr_stream_info", jSONArray);
                }
                int i5 = this.mAudioTimescaleEnable;
                if (i5 != -1) {
                    createCommonLog.put("audio_timescale_enable", i5);
                }
                JSONArray jSONArray2 = this.mLogBundle.avphStreamInfo;
                if (jSONArray2 != null) {
                    createCommonLog.put("avph_stream_info", jSONArray2);
                }
                if (this.mLiveEngine.getEnableTexturerender() == 1) {
                    createCommonLog.put("render_start_timestamp", this.mRenderStartNotifyTimeStamp);
                    createCommonLog.put("texturerender_renderstart_timestamp", this.mTextureRenderFirstFrameTime);
                }
                int i6 = this.mNoSyncCount;
                if (i6 > 0) {
                    createCommonLog.put("av_out_sync_count", i6).put("av_out_sync_duration", this.mNoSyncTimeDuration).put("av_out_sync_info", this.mNoSyncInfoStr);
                }
                reportQuicOpenResult(createCommonLog);
                if (isRtcPlayAvailable()) {
                    createCommonLog.put("player_dns_analysis_end", this.mRtcDnsTimeStamp);
                    createCommonLog.put("rtc_use_sdk_dns", this.mRtcUseSdkDns);
                    createCommonLog.put("tcp_connect_end", this.mRtcTcpConnectTimeStamp);
                    createCommonLog.put("rtc_tls_handshake_end", this.mRtcTlsHandshakedTimeStamp);
                    createCommonLog.put("tcp_first_package_end", this.mRtcTcpFirstPackageTimeStamp);
                    createCommonLog.put("rtc_inited_end", this.mLogBundle.rtcInitedTime);
                    createCommonLog.put("rtc_offer_send_end", this.mLogBundle.rtcOfferSendTime);
                    createCommonLog.put("rtc_answer_recv_end", this.mLogBundle.rtcAnswerRecvTime);
                    createCommonLog.put("rtc_start_end", this.mLogBundle.rtcStartTime);
                    createCommonLog.put("rtc_playstop_info", this.mRtcPlayStopStatInfo);
                } else {
                    createCommonLog.put("tcp_first_package_end", this.mLogBundle.tcpFirstPacketTimestamp);
                    createCommonLog.put("player_dns_analysis_end", this.mLogBundle.playerDNSTimestamp);
                    if (this.mCdnPlayURL == null) {
                        createCommonLog.put("tcp_connect_end", this.mLogBundle.tcpConnectTimestamp);
                    } else {
                        createCommonLog.put("tcp_connect_end", this.mProtocol.equals(LiveConfigKey.KCP) ? this.mLogBundle.playerDNSTimestamp : this.mLogBundle.tcpConnectTimestamp);
                    }
                }
                String str3 = this.mStreamFormat;
                if (str3 != null && (str3.equals(LiveConfigKey.CMAF) || this.mStreamFormat.equals(LiveConfigKey.AVPH))) {
                    createCommonLog.put("video_dns_analysis_end", this.mLogBundle.videoDNSTimestamp).put("audio_dns_analysis_end", this.mLogBundle.audioDNSTimestamp).put("video_tcp_connect_time", this.mLogBundle.videoTcpConnectTimestamp).put("audio_tcp_connect_time", this.mLogBundle.audioTcpConnectTimestamp).put("video_tcp_first_packet_time", this.mLogBundle.videoTcpFirstPacketTimestamp).put("audio_tcp_first_packet_time", this.mLogBundle.audioTcpFirstPacketTimestamp).put("video_http_req_finish_time", this.mLogBundle.videoHttpReqFinishTimestamp).put("audio_http_req_finish_time", this.mLogBundle.audioHttpReqFinishTimestamp).put("video_http_res_finish_time", this.mLogBundle.videoHttpResFinishTimestamp).put("audio_http_res_finish_time", this.mLogBundle.audioHttpResFinishTimestamp);
                    if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                        createCommonLog.put("cmaf_mpd_dns_analysis_end", this.mLogBundle.cmafMpdDNSTimestamp).put("cmaf_mpd_tcp_connect_time", this.mLogBundle.cmafMpdTcpConntectTimestamp).put("cmaf_mpd_tcp_first_package_end", this.mLogBundle.cmafMdpTcpFirstPacketTimestamp).put("cmaf_mpd_http_req_finish_time", this.mLogBundle.cmafMdpHttpReqFinishTimestamp).put("cmaf_mpd_http_res_finish_time", this.mLogBundle.cmafMdpHttpResFinishTimestamp).put("cmaf_audio_firstseg_connect_time", this.mLogBundle.cmafAudioFirstSegConntectTimestamp).put("cmaf_video_firstseg_connect_time", this.mLogBundle.cmafVideoFirstSegConntectTimestamp).put("cmaf_mpd_connect_time", this.mLogBundle.cmafMpdConntectTimestamp);
                    }
                }
                if (this.mEnableUploadSessionSeries) {
                    createCommonLog.put("session_time_series", _createSessionTimeSeries());
                }
                if (this.mEnableCheckSei) {
                    createCommonLog.put("expected_sei_count", this.mExpectedSeiCount);
                    createCommonLog.put("received_sei_count", this.mReceivedSeiCount);
                    createCommonLog.put("expected_unique_sei_count", this.mExpectedUniqueSeiCount);
                    createCommonLog.put("received_unique_sei_count", this.mReceivedUniqueSeiCount);
                }
                int i7 = this.mBitRateAbnormalType;
                if (i7 != 0) {
                    createCommonLog.put("bitrate_amnormal", i7);
                }
                int i8 = this.mCodecNotSame;
                if (i8 != 0) {
                    createCommonLog.put("abr_codec_not_same", i8);
                }
                if (this.mABRListMatch == 0) {
                    i4 = 1;
                    createCommonLog.put("abr_list_not_match", 1);
                } else {
                    i4 = 1;
                }
                if (TextUtils.equals(this.mProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mProtocol, LiveConfigKey.QUICU)) {
                    createCommonLog.put("scfg", this.mQuicScfgConfig).put("mtu", this.mQuicMtu).put("pad_hello", this.mQuicPadHello).put("timer_version", this.mQuicTimerVersion);
                }
                boolean z3 = this.mIsCdnAbrSwitch;
                if (z3) {
                    if (!z3) {
                        i4 = 0;
                    }
                    createCommonLog.put("cdn_abr_switch_performed", i4).put("cdn_abr_switch_code", this.mCdnAbrSwitchCode);
                }
                long j12 = this.mLogTotalCount + 1;
                this.mLogTotalCount = j12;
                createCommonLog.put("log_total_count_when_playing", j12);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                this.mLogTotalCount = 0L;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onSwitch(String str, String str2, String str3, int i4) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject createCommonLog = createCommonLog();
            JSONObject put = createCommonLog.put("event_key", "switch_url");
            if (str == null) {
                str = "null";
            }
            JSONObject put2 = put.put("last_cdn_play_url", str);
            if (str2 == null) {
                str2 = "null";
            }
            put2.put("next_cdn_play_url", str2).put("res_bitrate", this.mResBitrate).put("last_res", this.mLastResolution).put("code", i4).put("reason", str3);
            this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
            long j4 = this.mLogTotalCount;
            if (j4 > 0) {
                this.mLogTotalCount = j4 + 1;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onSwitchURL(String str) {
        this.mCurrentPlayURL = str;
    }

    public void onUpdateMetaData(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("sdk_version")) {
                this.mPushClientSDKVersion = jSONObject.getString("sdk_version");
            }
            if (jSONObject.has("platform")) {
                this.mPushClientPlatform = jSONObject.getString("platform");
            }
            if (jSONObject.has("os_version")) {
                this.mPushClientOSVersion = jSONObject.getString("os_version");
            }
            if (jSONObject.has("model")) {
                this.mPushClientModel = jSONObject.getString("model");
            }
            if (jSONObject.has("start_time")) {
                this.mPushClientStartTime = jSONObject.getString("start_time");
            }
            if (jSONObject.has("is_hardware_encode")) {
                this.mPushClientHardwareEncode = jSONObject.getInt("is_hardware_encode");
            }
            if (jSONObject.has("min_bitrate")) {
                this.mPushClientMinBitrate = jSONObject.getInt("min_bitrate");
            }
            if (jSONObject.has("max_bitrate")) {
                this.mPushClientMaxBitrate = jSONObject.getInt("max_bitrate");
            }
            if (jSONObject.has("default_bitrate")) {
                this.mPushClientDefaultBitrate = jSONObject.getInt("default_bitrate");
            }
            if (jSONObject.has("hit_node_optimize")) {
                this.mPushClientHitNodeOptimize = jSONObject.getInt("hit_node_optimize");
            }
            if (jSONObject.has("push_protocol")) {
                this.mPushClientPushProtocal = jSONObject.getString("push_protocol");
            }
            if (jSONObject.has("qId")) {
                this.mPushClientQId = jSONObject.getString("qId");
            }
            if (jSONObject.has("link_info")) {
                this.mLinkInfo = jSONObject.getString("link_info");
            }
            if (jSONObject.has("h_id")) {
                this.mFCDNTranscodeMethod = jSONObject.getInt("h_id");
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onUpdateSeiInfo(String str) {
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z3;
        MyNTPTask myNTPTask;
        if (TextUtils.isEmpty(str) || this.mLogBundle == null || this.mLiveEngine == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("ts")) {
                long j4 = jSONObject2.getLong("ts");
                str2 = "real_video_framerate";
                str3 = "channel_id";
                long j5 = 0;
                if (this.mEnableNTPTask == 1 && jSONObject2.has("tt_ntp") && jSONObject2.getInt("tt_ntp") == 1) {
                    if (!this.mNTPRunning && (myNTPTask = this.mNTPTask) != null) {
                        myNTPTask.sendEmptyMessageDelayed(103, 0L);
                        this.mNTPRunning = true;
                    }
                    j5 = this.mTimeDiff;
                    this.mHasNTP = true;
                } else {
                    if (!this.mNTPRunning || jSONObject2.has("tt_ntp")) {
                        z3 = false;
                    } else {
                        MyNTPTask myNTPTask2 = this.mNTPTask;
                        if (myNTPTask2 != null) {
                            myNTPTask2.mHandler.removeCallbacksAndMessages(null);
                        }
                        z3 = false;
                        this.mNTPRunning = false;
                    }
                    this.mHasNTP = z3;
                }
                if (this.mEnableNTP == 1 && jSONObject2.has("tt_ntp") && jSONObject2.getInt("tt_ntp") == 1) {
                    VideoLiveManager videoLiveManager = this.mLiveEngine;
                    if (videoLiveManager != null) {
                        this.mTimeDiff = videoLiveManager.getNtpTimeDiff();
                        MyLog.d("ntp", "ntp_time_diff:" + this.mTimeDiff);
                    }
                    j5 = this.mTimeDiff;
                    this.mHasNTP = true;
                }
                this.mLogBundle.delay = (System.currentTimeMillis() - j4) + j5;
                LogBundle logBundle = this.mSessionLogBundle;
                if (logBundle != null) {
                    logBundle.delay = (System.currentTimeMillis() - j4) + j5;
                }
            } else {
                str2 = "real_video_framerate";
                str3 = "channel_id";
            }
            String str4 = this.mLogBundle.seiSource;
            if (jSONObject2.has("source")) {
                this.mLogBundle.seiSource = jSONObject2.getString("source");
            } else if (jSONObject2.has("app_data")) {
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("app_data"));
                if (jSONObject3.has("vendor")) {
                    this.mLogBundle.seiSource = jSONObject3.getString("vendor");
                }
            }
            LogBundle logBundle2 = this.mSessionLogBundle;
            if (logBundle2 != null) {
                logBundle2.seiSource = this.mLogBundle.seiSource;
            }
            if (!str4.equals("none") && !this.mLogBundle.seiSource.equals(str4)) {
                if (str4.startsWith("TTLiveSDK")) {
                    onLink(true);
                } else {
                    onLink(false);
                }
            }
            if (jSONObject2.has("app_data")) {
                JSONObject jSONObject4 = new JSONObject(jSONObject2.optString("app_data"));
                String str5 = str3;
                if (jSONObject4.has(str5)) {
                    this.mLogBundle.channelId = jSONObject4.getString(str5);
                }
            } else {
                this.mLogBundle.channelId = "none";
            }
            if (jSONObject2.has("real_bitrate")) {
                this.mLogBundle.seiBitrate = jSONObject2.getInt("real_bitrate");
                this.mSeiHasBitrateAndFps = true;
            }
            if (jSONObject2.has(str2)) {
                this.mLogBundle.seiFps = jSONObject2.getInt(str2);
                this.mSeiHasBitrateAndFps = true;
            }
            if (jSONObject2.has("trans_info") || jSONObject2.has("tans_info")) {
                if (jSONObject2.has("trans_info")) {
                    jSONObject = jSONObject2.getJSONObject("trans_info");
                } else {
                    jSONObject = jSONObject2.getJSONObject("tans_info");
                }
                if (jSONObject != null) {
                    checkVideoFrame(jSONObject.getInt("index"), jSONObject.getInt("sent_frames"), jSONObject.getInt("checked_dts"));
                }
            }
            if (this.mEnableCheckSei && jSONObject2.has("sei_index")) {
                checkSeiIndex(jSONObject2.getInt("sei_index"));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void onVideoSizeChanged(int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
    }

    public void onVideoStallCounter(long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        JSONObject createCommonLog = createCommonLog();
        if (createCommonLog != null) {
            try {
                createCommonLog.put("event_key", "stall_counter").put("type", "video").put("render_stall_200_duration", j4 / 1000).put("render_stall_200_count", j4 % 1000).put("render_stall_300_duration", j5 / 1000).put("render_stall_300_count", j5 % 1000).put("render_stall_400_duration", j6 / 1000).put("render_stall_400_count", j6 % 1000).put("render_stall_500_duration", j7 / 1000).put("render_stall_500_count", j7 % 1000).put("demuxer_stall_500_duration", j8 / 1000).put("demuxer_stall_500_count", j8 % 1000).put("decode_pre_stall_500_duration", j9 / 1000).put("decode_pre_stall_500_count", j9 % 1000).put("decode_post_stall_500_duration", j10 / 1000).put("decode_post_stall_500_count", j10 % 1000);
                this.mLogUploader.onMonitorLog(createCommonLog, MONITOR_LOG_TYPE);
                long j11 = this.mLogTotalCount;
                if (j11 > 0) {
                    this.mLogTotalCount = j11 + 1;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void openNTP() {
        this.mEnableNTPTask = 1;
        this.mEnableNTP = 1;
        if (this.mNTPTask == null) {
            MyNTPTask myNTPTask = new MyNTPTask(this);
            this.mNTPTask = myNTPTask;
            myNTPTask.sendEmptyMessageDelayed(104, 0L);
        }
    }

    public void openNodeOptimizer(boolean z3) {
        this.mOpenNodeOptimizer = z3;
    }

    public void reset() {
        this.mCdnPlayURL = "none";
        this.mCurrentPlayURL = "none";
        this.mCdnIp = "none";
        this.mIpIsFromPlayerCore = false;
        this.mLogIndex = 0L;
        this.mPushClientSDKVersion = "none";
        this.mPushClientPlatform = "none";
        this.mPushClientOSVersion = "none";
        this.mPushClientModel = "none";
        this.mPushClientStartTime = "none";
        this.mPushClientHardwareEncode = -1;
        this.mPushClientMinBitrate = -1;
        this.mPushClientMaxBitrate = -1;
        this.mPushClientDefaultBitrate = -1;
        this.mPushClientHitNodeOptimize = -1;
        this.mPushClientPushProtocal = "none";
        this.mPushClientQId = "none";
        this.mEvaluatorSymbol = "none";
        this.mHitNodeOptimizer = false;
        this.mIsRemoteSorted = false;
        this.mIsHitCache = false;
        this.mHaveResetPlayer = false;
        this.mPreconnect = -1;
        this.mEnableHurry = false;
        this.mHurryTime = -1;
        this.mCatchSpeed = -1.0f;
        this.mSlowPlayTime = -1;
        this.mSlowSpeed = -1.0f;
        this.mSpeedSwitchCount = 0;
        this.mSpeedSwitchInfo = "none";
        this.mStartPlayBufferThres = 0L;
        this.mFastOpenDuration = -1;
        this.mCheckBufferingEndIgnoreVideo = 0;
        this.mStartDirectAfterPrepared = 0;
        this.mCheckBufferingEndAdvanceEnable = 0;
        this.mDefaultCodecID = -1;
        this.mMediaCodecAsyncInit = 0;
        this.mHasFirstFrame = false;
        this.mFirstFrameTimestamp = 0L;
        this.mErrorCode = 0;
        this.mStallStartTime = 0L;
        this.mStallReason = -1L;
        this.mStallTotalCount = 0L;
        this.mStallTotalTime = 0L;
        this.mVideoRenderStallTotalTime = 0L;
        this.mVideoRenderStallTotalCount = 0L;
        this.mAudioRenderStallTotalTime = 0L;
        this.mAudioRenderStallTotalCount = 0L;
        this.mErrorRecoverCount = 0L;
        this.mErrorRecoverTime = 0L;
        this.mIsInErrorRecovering = false;
        this.mIsStalling = false;
        this.mPlayingStallCount = 0;
        this.mPlayingStallTime = 0;
        this.mPlayingAudioRenderStallCount = 0;
        this.mPlayingAudioRenderStallTime = 0;
        this.mPlayingVideoRenderStallCount = 0;
        this.mPlayingVideoRenderStallTime = 0;
        this.mPlayingStallStartTime = 0L;
        this.mFirstStallStartTime = 0L;
        this.mFirstStallEndTime = 0L;
        this.mRetryCount = 0;
        this.mRetryTotalCount = 0;
        this.mSilenceDetectedCount = -1;
        this.mHasNTP = false;
        this.mTimeDiff = 0L;
        this.mEnableNTP = 0;
        this.mEnableNTPTask = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mMaxCacheSeconds = -1;
        this.mSRSuccess = false;
        this.mTextureRenderError = 0;
        this.mUseTextureRender = false;
        this.mContainerFps = -1.0f;
        this.mRenderStartNotifyTimeStamp = 0L;
        this.mTextureRenderFirstFrameTime = 0L;
        this.mRenderFpsTimeSeries = null;
        this.mDownloadSpeedTimeSeries = null;
        this.mAudioBufferTimeSeries = null;
        this.mSeiBitrateTimeSeries = null;
        this.mSeiFpsTimeSeries = null;
        this.mErrorTimeSeries = null;
        this.mStallTimeSeries = null;
        LogBundle logBundle = this.mLogBundle;
        if (logBundle != null) {
            logBundle.reset();
        }
        this.mCodecName = "none";
        this.mCodecType = "none";
        this.mIsInMainLooper = 1;
        this.mRuleIds = "none";
        this.mSessionId = "none";
        this.mSettingsInfo = "none";
        this.mTTNetNQEInfo = "none";
        this.mEnableP2P = 0;
        this.mEnableOpenMDL = 0;
        this.mUsedP2P = 0;
        this.mP2PLoaderType = -1;
        this.mLastTotalDownloadSize = 0L;
        this.mLastDownloadSizeDelta = 0L;
        this.mEnableResolutionAutoDegrade = false;
        this.mHasAbrInfo = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mResolution = LiveConfigKey.ORIGIN;
        this.mAutoUsingResolution = LiveConfigKey.ORIGIN;
        this.mLastResolution = "none";
        this.mDefaultResBitrate = -1;
        this.mResBitrate = -1L;
        this.mAbrSwitchCount = 0;
        this.mAbrSwitchCountInfo = "none";
        this.mAbrSwitchInfo = "none";
        this.mCurDownloadSpeed = -1L;
        this.mCurAudioBufferTime = -1L;
        this.mCurVideoBufferTime = -1L;
        this.mAbrSwitchCost = -1L;
        this.mStallCountThresOfResolutionDegrade = 4;
        this.mNetworkTimeoutMs = -1;
        this.mQuicMtu = -1;
        this.mQuicScfgConfig = -1;
        this.mQuicPadHello = -1;
        this.mQuicTimerVersion = -1;
        this.mFirstFrameRetryCount = 0;
        this.mFirstFramePrepareTime = 0L;
        this.mLastPrepareTime = 0L;
        this.mEnableTcpFastOpen = 0;
        this.mEnableLowLatencyFLV = 0;
        this.mOptimizeBackupIps = null;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mRtcTcpConnectTimeStamp = 0L;
        this.mRtcTcpFirstPackageTimeStamp = 0L;
        this.mRtcTlsHandshakedTimeStamp = 0L;
        this.mRtcPlayFallBack = 0;
        this.mFallbackType = 0;
        this.mRtcSessionId = "none";
        this.mRtcPlayStopStatInfo = "none";
        this.mDisableVideoRender = 0;
        this.mRequestUrl = "none";
        this.mRequestHeaders = null;
        this.mUseExpectBitrate = 0;
        this.mFCDNTranscodeMethod = -1;
        this.mEnableReportSessionStop = 0;
        this.mSessionNum = 0;
        this.mVideoDecodeStallTotalCount = 0L;
        this.mVideoDecodeStallTotalTime = 0L;
        this.mAudioDecodeStallTotalCount = 0L;
        this.mAudioDecodeStallTotalTime = 0L;
        this.mVideoDemuxStallTotalCount = 0L;
        this.mVideoDemuxStallTotalTime = 0L;
        this.mAudioDemuxStallTotalCount = 0L;
        this.mAudioDemuxStallTotalTime = 0L;
        this.mNoSyncCount = 0;
        this.mNoSyncPlayingCount = 0;
        this.mNoSyncTimeDuration = 0L;
        this.mNoSyncPlayingTimeDuration = 0L;
        this.mNoSyncPtsDuration = 0L;
        this.mNoSyncPlayingPtsDuration = 0L;
        this.mNoSyncPlayingInfoStr = "";
        this.mNoSyncInfoStr = "";
        this.mEnableLiveIOPlay = 0;
        this.mLiveIOPlay = 0;
        this.mLiveIOP2P = 0;
        this.mLiveIOErrorMsg = "none";
        this.mFirstFrameView = 0L;
        this.mLiveIOVersion = "none";
        this.mUseLiveThreadPool = 0;
    }

    public void resetLog() {
    }

    public void resetStreamCheckParams() {
        LinkedBlockingQueue<Long> linkedBlockingQueue = this.mVideoDTSQueue;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.mVideoDTSQueue = null;
        }
        this.mLastSentFrames = -1;
        this.mLastCheckDTS = -1L;
        this.mLastSeiIndex = -1;
        this.mLastIndex = -1;
    }

    public void setCdnIp(String str, boolean z3) {
        this.mCdnIp = str;
        this.mIpIsFromPlayerCore = z3;
    }

    public void setCheckSilenceInterval(int i4) {
        this.mEnableCheckSilenceInterval = i4 > 0;
        this.mSilenceDetectedCount = i4 <= 0 ? -1 : 0;
    }

    public void setCodecType(String str) {
        this.mCodecType = str;
    }

    public void setCommonFlag(String str) {
        if (str != null) {
            this.mCommonFlag = str;
        }
    }

    public void setEvaluatorSymbol(String str) {
        if (str != null) {
            this.mEvaluatorSymbol = str;
        }
    }

    public void setFormatInfo(String str, String str2) {
        this.mSuggestFormat = str;
        this.mStreamFormat = str2;
    }

    public void setInErrorRecovering() {
        this.mIsInErrorRecovering = true;
        this.mErrorStartTime = System.currentTimeMillis();
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public void setPlayerSdkVersion(String str) {
        this.mPlayerVersion = str;
    }

    public void setPreconnect(int i4) {
        this.mPreconnect = i4;
    }

    public void setPreviewFlag(boolean z3) {
        this.mIsPreview = z3;
    }

    public void setProjectKey(String str) {
        this.mProjectKey = str;
    }

    public void setProtocolInfo(String str, String str2) {
        this.mSuggestProtocol = str;
        this.mProtocol = str2;
    }

    public void setQuicLibLoader(int i4) {
        this.mQuicFlag = i4;
    }

    public void setRemoteSorted(boolean z3) {
        this.mIsRemoteSorted = z3;
    }

    public void setRtcPlayLogInterval(long j4) {
        if (j4 >= 1000) {
            this.mRtcPlayingLogInterval = j4;
        }
    }

    public void setSdkParams(String str) {
        this.mSdkParams = str;
    }

    public void setWaitTime(long j4) {
        LogBundle logBundle = this.mLogBundle;
        if (logBundle != null) {
            logBundle.waitingTimeAfterFirstFrame = j4;
        }
        LogBundle logBundle2 = this.mSessionLogBundle;
        if (logBundle2 != null) {
            logBundle2.waitingTimeAfterFirstFrame = j4;
        }
    }

    public void start() {
        MyNTPTask myNTPTask;
        if (this.mStarted) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(101, this.mInterval);
        if (this.mEnableUploadSessionSeries) {
            this.mHandler.sendEmptyMessageDelayed(102, 5000L);
        }
        if (this.mEnableNTPTask == 1 && !this.mNTPRunning && (myNTPTask = this.mNTPTask) != null) {
            myNTPTask.sendEmptyMessageDelayed(103, 0L);
            this.mNTPRunning = true;
        }
        this.mStarted = true;
    }
}
