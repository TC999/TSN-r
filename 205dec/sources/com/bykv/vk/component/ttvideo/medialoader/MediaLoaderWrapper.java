package com.bykv.vk.component.ttvideo.medialoader;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.AppInfo;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class MediaLoaderWrapper implements AVMDLDataLoaderListener {
    public static final int DATALOADER_KEY_NOTIFY_OWNVDPLOG = 1;
    public static final int DATALOADER_KEY_NOTIFY_SPEEDINFO = 2;
    public static final int DATALOADER_KEY_NOTIFY_TASKLOG = 0;
    static final String HTTP_PROTO_PREFIX = "http://";
    static final String MDL_PROTO_PREFIX = "mdl://";
    static final String TAG = "MediaLoaderWrapper";
    private volatile boolean isProxyLibraryLoaded;
    public AVMDLDataLoaderConfigure mConfigure;
    private boolean mEnableLoadLibrary;
    private boolean mIsRunning;
    private MediaLoaderListener mListener;
    private LiveLoggerService mLogService;
    private MediaPlayer mPlayer;
    private volatile LibraryLoadProxy mProxy;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class Holder {
        private static MediaLoaderWrapper instance = new MediaLoaderWrapper();

        private Holder() {
        }
    }

    public static MediaLoaderWrapper getDataLoader() {
        return Holder.instance;
    }

    private boolean initInternal() {
        if (this.mEnableLoadLibrary) {
            if (!loadLibrary()) {
                MyLog.i(TAG, String.format("library load fail", new Object[0]));
                return false;
            }
            if (AVMDLDataLoader.init(this.mProxy != null) != 0) {
                MyLog.d(TAG, String.format("library has not been loaded", new Object[0]));
                return false;
            }
        }
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            MyLog.i(TAG, String.format("create loader failed: exception is" + e4.toString(), new Object[0]));
            return false;
        }
    }

    private boolean loadLibrary() {
        if (this.mProxy == null) {
            return true;
        }
        if (this.mProxy != null && !this.isProxyLibraryLoaded) {
            this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdl");
        }
        return this.isProxyLibraryLoaded;
    }

    private boolean supportProxy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith("file://") || lowerCase.startsWith(TTPathConst.sSeparator) || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?") || lowerCase.contains(".m3u8?") || lowerCase.endsWith(".m3u8")) ? false : true;
    }

    public void close() {
        if (!this.mIsRunning) {
            MyLog.e(TAG, "MediaLoader not started, not need close");
            return;
        }
        this.mListener = null;
        AVMDLDataLoader.getInstance().close();
        AVMDLDataLoader.getInstance().cancelAll();
        this.mIsRunning = false;
    }

    public void enableLoadLibrary() {
        this.mEnableLoadLibrary = true;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i4, long j4) {
        MediaLoaderListener mediaLoaderListener;
        MyLog.i(TAG, "getInt64Value:" + i4);
        if (i4 != 8003) {
            return (i4 == 8004 && (mediaLoaderListener = this.mListener) != null) ? mediaLoaderListener.getInt64Value(0, j4) : j4;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null ? mediaPlayer.getLongOption(73, 0L) : j4;
    }

    public long getLongValueFromLoader(int i4) {
        MyLog.i(TAG, "get long value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i4 == 7218) {
            if (aVMDLDataLoader == null) {
                return -1L;
            }
            return aVMDLDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
        }
        switch (i4) {
            case AVMDLDataLoader.KeyIsLiveLoaderEnable /* 8100 */:
                if (aVMDLDataLoader == null) {
                    return -1L;
                }
                return aVMDLDataLoader.getLongValue(AVMDLDataLoader.KeyIsLiveLoaderEnable);
            case AVMDLDataLoader.KeyIsLiveLoaderP2pEnable /* 8101 */:
                if (aVMDLDataLoader == null) {
                    return -1L;
                }
                return aVMDLDataLoader.getLongValue(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable);
            case 8102:
                return (aVMDLDataLoader != null ? aVMDLDataLoader.getLongValue(8102) : -1L) == 1 ? 1L : 0L;
            default:
                return -1L;
        }
    }

    public String getProxyUrl(String str, Boolean bool) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        if (supportProxy(str)) {
            String localAddr = AVMDLDataLoader.getInstance().getLocalAddr();
            if (TextUtils.isEmpty(localAddr)) {
                return null;
            }
            try {
                str2 = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            String str3 = localAddr + "?rk=v02004b50000bh9ajqhdli3lfv2rgsgg&k=426161df8c5ce110209a6fc6641e049ddfrfgaf&u0=" + str2;
            if (bool.booleanValue()) {
                return "mdl://" + str3;
            }
            return "http://" + str3;
        }
        return str;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i4, long j4, String str) {
        return null;
    }

    public String getStringValueFromLoader(int i4) {
        MyLog.i(TAG, "get string value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i4 == 11 && aVMDLDataLoader != null) {
            return aVMDLDataLoader.getStringValue(11);
        }
        return null;
    }

    public boolean isRunning() {
        if (AVMDLDataLoader.getInstance() == null) {
            return false;
        }
        return AVMDLDataLoader.getInstance().isRunning();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        if (aVMDLDataLoaderNotifyInfo == null || this.mListener == null) {
            return;
        }
        MyLog.i(TAG, "what:" + aVMDLDataLoaderNotifyInfo.what);
        int i4 = aVMDLDataLoaderNotifyInfo.what;
        if (i4 == 9) {
            MediaLoaderListener mediaLoaderListener = this.mListener;
            if (mediaLoaderListener != null) {
                mediaLoaderListener.onDataLoaderError((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
            }
            MyLog.i(TAG, "live loader errorCode:" + aVMDLDataLoaderNotifyInfo.parameter + " errorInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
        } else if (i4 != 12) {
        } else {
            MediaLoaderListener mediaLoaderListener2 = this.mListener;
            if (mediaLoaderListener2 != null) {
                mediaLoaderListener2.onSwitchLoaderType((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
            }
            MyLog.i(TAG, "switch reason:" + aVMDLDataLoaderNotifyInfo.parameter + " switchInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
        }
    }

    public void setInt64ValueByStrKey(int i4, String str, int i5) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        if (i4 != 7213 && i4 != 7215) {
            aVMDLDataLoader.setInt64ValueByStrKey(i4, str, System.currentTimeMillis());
        } else {
            aVMDLDataLoader.setInt64ValueByStrKey(i4, str, i5);
        }
    }

    public void setIntValue(int i4, int i5) {
        if (i4 == 51) {
            this.mConfigure.mRWTimeOut = i5;
        } else if (i4 == 52) {
            this.mConfigure.mOpenTimeOut = i5;
        } else if (i4 == 53) {
            this.mConfigure.mTryCount = i5;
        } else if (i4 == 49) {
            MyLog.i(TAG, "allow p2p:" + i5);
            this.mConfigure.mLiveP2pAllow = i5;
        } else if (i4 == 50) {
            MyLog.i(TAG, "loader type:" + i5);
            this.mConfigure.mLiveLoaderType = i5;
        }
    }

    public void setListener(MediaLoaderListener mediaLoaderListener) {
        this.mListener = mediaLoaderListener;
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
        } catch (Exception e4) {
            e4.printStackTrace();
            MyLog.i(TAG, String.format("create loader failed: exception is" + e4.toString(), new Object[0]));
        }
    }

    public void setLoadProxy(LibraryLoadProxy libraryLoadProxy) {
        this.mProxy = libraryLoadProxy;
    }

    public void setLogService(LiveLoggerService liveLoggerService) {
        this.mLogService = liveLoggerService;
    }

    public void setLongValue(int i4, long j4) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader != null && i4 == 59) {
            aVMDLDataLoader.setLongValue(1100, j4);
        }
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void setStringValue(int i4, String str) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.setStringValue(i4, str);
    }

    public void start() throws Exception {
        if (this.mIsRunning) {
            return;
        }
        if (initInternal()) {
            JSONObject jSONObject = new JSONObject();
            try {
                String str = AppInfo.mAppChannel;
                if (str != null) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_channel", AppInfo.mAppChannel);
                    }
                    if (!TextUtils.isEmpty(AppInfo.mAppName)) {
                        jSONObject.put("app_name", AppInfo.mAppName);
                    }
                    if (!TextUtils.isEmpty(AppInfo.mDeviceId)) {
                        jSONObject.put("device_id", AppInfo.mDeviceId);
                    }
                    if (!TextUtils.isEmpty(AppInfo.mAppVersion)) {
                        jSONObject.put("app_version", AppInfo.mAppVersion);
                    }
                    jSONObject.put("app_id", AppInfo.mAppID);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return;
            }
            this.mConfigure.mAppInfo = jSONObject.toString();
            if (AppInfo.mAppID != -1) {
                MyLog.i(TAG, "set config");
                AVMDLDataLoader.getInstance().setConfigure(this.mConfigure);
            }
            if (AVMDLDataLoader.getInstance().start() >= 0) {
                this.mIsRunning = true;
                return;
            }
            throw new Exception("start mediaLoader fail");
        }
        throw new Exception("init mediaLoader fail");
    }

    private MediaLoaderWrapper() {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mIsRunning = false;
        this.mEnableLoadLibrary = false;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
    }

    public MediaLoaderWrapper(MediaLoaderListener mediaLoaderListener) {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mIsRunning = false;
        this.mEnableLoadLibrary = false;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
        this.mListener = mediaLoaderListener;
    }
}
