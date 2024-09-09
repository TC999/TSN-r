package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLDNSParser {
    public static final int AVMDL_DNS_BACKUP_TYPE = 1;
    public static final int AVMDL_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int AVMDL_DNS_ENABLE_BACKUP_IP = 5;
    public static final int AVMDL_DNS_ENABLE_DNS_LOG = 7;
    public static final int AVMDL_DNS_ENABLE_PARALLEL = 4;
    public static final int AVMDL_DNS_ENABLE_REFRESH = 6;
    public static final int AVMDL_DNS_FORCE_EXPIRED_TIME = 10;
    public static final int AVMDL_DNS_GOOGLE_PARSE_HOST = 9;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int AVMDL_DNS_MAIN_TYPE = 0;
    public static final int AVMDL_DNS_OWN_PARSE_HOST = 8;
    public static final int DNS_TYPE_BACKUP_IP = 11;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_CUSTOM = 4;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_HTTP_SERVER = 10;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "AVMDLDNSParser";
    public static AVMDLCustomHTTPDNSParser mCustomHttpDNSParser = null;
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalEnableBackUpIp = 0;
    public static int mGlobalEnableDNSLog = 0;
    public static int mGlobalEnableParallel = 0;
    public static int mGlobalEnableRefresh = 0;
    public static int mGlobalForceExpiredTime = 0;
    public static String mGlobalGoogleDNSParseHost = "";
    public static int mGlobalMainType = 0;
    public static String mGlobalOwnDNSParseHost = "";
    private static AVMDLDNSParser mInstance;
    public static AVMDLNetClientMaker mNetClientMaker;
    private Handler mHandler;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mType;
    private int mTimeOut = 5;
    private Lock mLock = new ReentrantLock();
    private Map<String, AVMDLHostProcessor> mProcessors = new HashMap();

    public AVMDLDNSParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper()) { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.1
            @Override // android.os.Handler
            @SuppressLint({"CI_DefaultLocale"})
            public void handleMessage(Message message) {
                Object obj = message.obj;
                AVMDLDNSInfo aVMDLDNSInfo = obj != null ? (AVMDLDNSInfo) obj : null;
                AVMDLLog.d(AVMDLDNSParser.TAG, String.format("----receive msg what:%d info:%s", Integer.valueOf(message.what), aVMDLDNSInfo));
                int i4 = message.what;
                if (i4 == 2) {
                    AVMDLDNSParser.this.proccessFailMsg(i4, aVMDLDNSInfo);
                } else if (i4 == 3) {
                    AVMDLDNSParser.this.proccessSucMsg(i4, aVMDLDNSInfo);
                } else if (i4 == 4) {
                    AVMDLDNSParser.this.proccessPreParseMsg(i4, aVMDLDNSInfo);
                } else if (i4 == 6) {
                    AVMDLDNSParser.this.processParseMsg(i4, aVMDLDNSInfo);
                } else if (i4 == 7) {
                    AVMDLDNSParser.this.processBatchParseMsg(i4, aVMDLDNSInfo);
                }
                AVMDLLog.d(AVMDLDNSParser.TAG, String.format("****end proc msg what:%d info:%s", Integer.valueOf(message.what), aVMDLDNSInfo));
            }
        };
    }

    private void addListenerInternal(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        boolean z3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AVMDLLog.d(TAG, String.format("---add listener:%s for host:%s", aVMDLDNSParserListener, str));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(str);
            AVMDLLog.d(TAG, String.format("get processor:%s", aVMDLHostProcessor));
            if (aVMDLHostProcessor == null) {
                aVMDLHostProcessor = new AVMDLHostProcessor(str, this.mHandler, mGlobalMainType, mGlobalBackType, mGlobalBackUpDelayedTime, mGlobalEnableParallel);
                AVMDLLog.d(TAG, String.format("create processor:%s", aVMDLHostProcessor));
                z3 = true;
            } else {
                z3 = false;
            }
            if (aVMDLDNSParserListener != null && !aVMDLHostProcessor.mListeners.containsKey(aVMDLDNSParserListener)) {
                AVMDLLog.d(TAG, String.format("add listener", new Object[0]));
                aVMDLHostProcessor.mListeners.put(aVMDLDNSParserListener, 1);
            }
            this.mProcessors.put(str, aVMDLHostProcessor);
            if (z3) {
                AVMDLLog.d(TAG, String.format("new processor implement parse", new Object[0]));
                aVMDLHostProcessor.processMsg(5, new AVMDLDNSInfo(mGlobalMainType, str, (String) null, 0L, (String) null));
            }
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format("****end add listener", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public static AVMDLDNSParser getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSParser.class) {
                if (mInstance == null) {
                    mInstance = new AVMDLDNSParser();
                }
            }
        }
        return mInstance;
    }

    public static int getIntValue(int i4) {
        int i5;
        AVMDLLog.d(TAG, String.format("----get value for key:%d", Integer.valueOf(i4)));
        synchronized (AVMDLDNSParser.class) {
            if (i4 != 10) {
                switch (i4) {
                    case 0:
                        i5 = mGlobalMainType;
                        break;
                    case 1:
                        i5 = mGlobalBackType;
                        break;
                    case 2:
                        i5 = mGlobalDefaultExpiredTime;
                        break;
                    case 3:
                        i5 = mGlobalBackUpDelayedTime;
                        break;
                    case 4:
                        i5 = mGlobalEnableParallel;
                        break;
                    case 5:
                        i5 = mGlobalEnableBackUpIp;
                        break;
                    case 6:
                        i5 = mGlobalEnableRefresh;
                        break;
                    case 7:
                        i5 = mGlobalEnableDNSLog;
                        break;
                    default:
                        i5 = Integer.MIN_VALUE;
                        break;
                }
            } else {
                i5 = mGlobalForceExpiredTime;
            }
        }
        AVMDLLog.d(TAG, String.format("****get value:%d for key:%d", Integer.valueOf(i5), Integer.valueOf(i4)));
        return i5;
    }

    public static AVMDLNetClient getNetClient() {
        AVMDLNetClient netClient;
        synchronized (AVMDLDNSParser.class) {
            AVMDLNetClientMaker aVMDLNetClientMaker = mNetClientMaker;
            netClient = aVMDLNetClientMaker != null ? aVMDLNetClientMaker.getNetClient() : null;
        }
        return netClient == null ? new AVMDLHTTPNetwork() : netClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessFailMsg(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo != null && aVMDLDNSInfo.mHost != null) {
            AVMDLLog.d(TAG, String.format("----proc fail msg what:%d host:%s", Integer.valueOf(i4), aVMDLDNSInfo.mHost));
            this.mLock.lock();
            try {
                AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
                AVMDLLog.d(TAG, String.format("get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost));
                if (aVMDLHostProcessor != null && aVMDLHostProcessor.isValidSourceId(aVMDLDNSInfo.mId)) {
                    aVMDLHostProcessor.processResult(i4, aVMDLDNSInfo);
                    if (aVMDLHostProcessor.isEnd()) {
                        AVMDLLog.d(TAG, String.format("processor end, notify result", new Object[0]));
                        for (AVMDLDNSParserListener aVMDLDNSParserListener : aVMDLHostProcessor.mListeners.keySet()) {
                            if (aVMDLDNSParserListener != null) {
                                AVMDLLog.d(TAG, String.format("listener:%s oncompletion fail", aVMDLDNSParserListener));
                                aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, null, 0L, null, aVMDLDNSInfo.mType);
                            }
                        }
                        aVMDLHostProcessor.mListeners.clear();
                        this.mProcessors.remove(aVMDLDNSInfo.mHost);
                    } else {
                        AVMDLLog.d(TAG, String.format("processor is not end", new Object[0]));
                    }
                }
                this.mLock.unlock();
                AVMDLLog.d(TAG, String.format("****end proc fail msg what", new Object[0]));
                return;
            } catch (Throwable th) {
                this.mLock.unlock();
                throw th;
            }
        }
        AVMDLLog.d(TAG, String.format("proc fail msg  fail, info or host is null", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessPreParseMsg(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        if (mGlobalEnableRefresh <= 0) {
            AVMDLLog.d(TAG, "not support preparse");
        } else if (aVMDLDNSInfo != null && aVMDLDNSInfo.mHost != null) {
            AVMDLLog.d(TAG, String.format("----proc pre parse msg what:%d host:%s", Integer.valueOf(i4), aVMDLDNSInfo.mHost));
            AVMDLDNSInfo aVMDLDNSInfo2 = IPCache.getInstance().get(aVMDLDNSInfo.mHost);
            long currentTimeMillis = System.currentTimeMillis();
            Object[] objArr = new Object[2];
            objArr[0] = aVMDLDNSInfo2;
            objArr[1] = Long.valueOf(aVMDLDNSInfo2 == null ? -1L : aVMDLDNSInfo2.mExpiredTime);
            AVMDLLog.d(TAG, String.format("cache:%s expiredT:%d", objArr));
            if (aVMDLDNSInfo2 == null || aVMDLDNSInfo2.mExpiredTime < currentTimeMillis) {
                AVMDLLog.d(TAG, "add host for preparse");
                addListenerInternal(aVMDLDNSInfo.mHost, null);
            }
            AVMDLLog.d(TAG, "****proc pre parse msg what:%d host:%s");
        } else {
            AVMDLLog.d(TAG, String.format("proc pre msg  fail, info or host is null", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public void proccessSucMsg(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        HashMap<AVMDLDNSParserListener, Integer> hashMap;
        if (aVMDLDNSInfo != null && aVMDLDNSInfo.mHost != null) {
            AVMDLLog.d(TAG, String.format("----proc suc msg what:%d host:%s", Integer.valueOf(i4), aVMDLDNSInfo.mHost));
            this.mLock.lock();
            try {
                AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
                AVMDLLog.d(TAG, String.format("get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost));
                if (aVMDLHostProcessor != null && (hashMap = aVMDLHostProcessor.mListeners) != null) {
                    for (AVMDLDNSParserListener aVMDLDNSParserListener : hashMap.keySet()) {
                        if (aVMDLDNSParserListener != null) {
                            AVMDLLog.d(TAG, String.format("listener:%s oncompletion suc", aVMDLDNSParserListener));
                            aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, aVMDLDNSInfo.mIpList, aVMDLDNSInfo.mExpiredTime, null, aVMDLDNSInfo.mType);
                        }
                    }
                    aVMDLHostProcessor.mListeners.clear();
                    this.mProcessors.remove(aVMDLDNSInfo.mHost);
                    AVMDLLog.d(TAG, String.format("remove all listeners and remove host", new Object[0]));
                }
                sendPreParseMsg(aVMDLDNSInfo.mHost, aVMDLDNSInfo.mExpiredTime - System.currentTimeMillis());
                reportLog(aVMDLDNSInfo);
                this.mLock.unlock();
                AVMDLLog.d(TAG, String.format("****end proc suc msg", new Object[0]));
                return;
            } catch (Throwable th) {
                this.mLock.unlock();
                throw th;
            }
        }
        AVMDLLog.d(TAG, String.format("proc suc msg  fail, info or host is null", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public void processBatchParseMsg(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        String[] strArr;
        if (aVMDLDNSInfo != null && (strArr = aVMDLDNSInfo.mHosts) != null && strArr.length != 0) {
            AVMDLLog.d(TAG, String.format("----proc batch parse msg what:%d", Integer.valueOf(i4)));
            if (mGlobalEnableParallel <= 0 && mGlobalMainType != 2) {
                new LocalDNSHosts(aVMDLDNSInfo.mHosts, this.mHandler).start();
                AVMDLLog.d(TAG, String.format("****end proc batch parser msg", new Object[0]));
                return;
            }
            try {
                new HTTPDNSHosts(aVMDLDNSInfo.mHosts, null, 2, this.mHandler).start();
                return;
            } catch (Exception e4) {
                AVMDLLog.d(TAG, String.format("parse end create httpdnshosts fail" + e4, new Object[0]));
                return;
            }
        }
        AVMDLLog.d(TAG, String.format("proc parser msg  fail, info or host is null", new Object[0]));
    }

    public static void processHijack() {
        AVMDLLog.d(TAG, String.format("----process hijack old dnsmain:%d back:%d", Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType)));
        int i4 = mGlobalMainType;
        if (i4 == 0) {
            mGlobalMainType = mGlobalBackType;
            mGlobalBackType = i4;
        }
        AVMDLLog.d(TAG, String.format("****process hijack new dnsmain:%d back:%d", Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public void processParseMsg(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo != null && aVMDLDNSInfo.mHost != null) {
            AVMDLLog.d(TAG, String.format("----proc parser msg what:%d host:%s", Integer.valueOf(i4), aVMDLDNSInfo.mHost));
            this.mLock.lock();
            try {
                AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
                if (aVMDLHostProcessor != null) {
                    AVMDLLog.d(TAG, String.format("----get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost));
                    aVMDLHostProcessor.processMsg(i4, aVMDLDNSInfo);
                } else {
                    AVMDLLog.d(TAG, String.format("****get processor null for host:%s", aVMDLDNSInfo.mHost));
                }
                this.mLock.unlock();
                AVMDLLog.d(TAG, String.format("****end proc parser msg", new Object[0]));
                return;
            } catch (Throwable th) {
                this.mLock.unlock();
                throw th;
            }
        }
        AVMDLLog.d(TAG, String.format("proc parser msg  fail, info or host is null", new Object[0]));
    }

    private void removeListenerInternal(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        if (TextUtils.isEmpty(str) || aVMDLDNSParserListener == null) {
            return;
        }
        AVMDLLog.d(TAG, String.format("---remove listener:%s for host:%s", aVMDLDNSParserListener, str));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(str);
            AVMDLLog.d(TAG, String.format("get processor:%s", aVMDLHostProcessor));
            if (aVMDLHostProcessor != null) {
                AVMDLLog.d(TAG, String.format("remove listener", new Object[0]));
                aVMDLHostProcessor.mListeners.remove(aVMDLDNSParserListener);
            }
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.mListeners.size() == 0) {
                AVMDLLog.d(TAG, String.format("listeners empty for processors", new Object[0]));
            }
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format("****end remove listener", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void reportLog(AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(aVMDLDNSInfo.mIpList) || mGlobalEnableDNSLog <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "mdl_dns_log");
            jSONObject.put("dns_type", aVMDLDNSInfo.mType);
            jSONObject.put("ip_list", aVMDLDNSInfo.mIpList);
            AVMDLDataLoader.getInstance().onLogInfo(15, 0, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    private void sendBatchParseMsg(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, strArr, (String) null, 0L, (String) null);
            Message message = new Message();
            message.what = 7;
            message.obj = aVMDLDNSInfo;
            AVMDLLog.d(TAG, String.format("send msg for batch parse", new Object[0]));
            this.mHandler.sendMessage(message);
            return;
        }
        AVMDLLog.d(TAG, "hosts null not need do batch parse");
    }

    private void sendPreParseMsg(String str, long j4) {
        if (!TextUtils.isEmpty(str) && j4 > 0) {
            if (mGlobalEnableRefresh > 0) {
                AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, str, (String) null, 0L, (String) null);
                Message message = new Message();
                message.what = 4;
                message.obj = aVMDLDNSInfo;
                long j5 = j4 + 3000;
                AVMDLLog.d(TAG, String.format("send preparse for host:%s delayTime:%d", aVMDLDNSInfo.mHost, Long.valueOf(j5)));
                this.mHandler.sendMessageDelayed(message, j5);
                return;
            }
            return;
        }
        AVMDLLog.d(TAG, "host is null or delayTimeMs invalid,not support preparse");
    }

    public static void setClientMaker(AVMDLNetClientMaker aVMDLNetClientMaker) {
        synchronized (AVMDLDNSParser.class) {
            if (aVMDLNetClientMaker != null) {
                mNetClientMaker = aVMDLNetClientMaker;
            }
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static void setCustomHttpDNSParser(AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser) {
        synchronized (AVMDLDNSParser.class) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVMDLCustomHTTPDNSParser == null ? 0 : 1);
            AVMDLLog.d(TAG, String.format("set custom http dns parser:%d", objArr));
            if (aVMDLCustomHTTPDNSParser != null) {
                mCustomHttpDNSParser = aVMDLCustomHTTPDNSParser;
            }
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static void setIntValue(int i4, int i5) {
        AVMDLLog.d(TAG, String.format("****set value:%d for key:%d", Integer.valueOf(i5), Integer.valueOf(i4)));
        synchronized (AVMDLDNSParser.class) {
            if (i4 != 10) {
                switch (i4) {
                    case 0:
                        mGlobalMainType = i5;
                        break;
                    case 1:
                        mGlobalBackType = i5;
                        break;
                    case 2:
                        mGlobalDefaultExpiredTime = i5;
                        break;
                    case 3:
                        mGlobalBackUpDelayedTime = i5;
                        break;
                    case 4:
                        mGlobalEnableParallel = i5;
                        break;
                    case 5:
                        mGlobalEnableBackUpIp = i5;
                        break;
                    case 6:
                        mGlobalEnableRefresh = i5;
                        break;
                    case 7:
                        mGlobalEnableDNSLog = i5;
                        break;
                }
            } else {
                mGlobalForceExpiredTime = i5;
            }
        }
    }

    public static void setStringValue(int i4, String str) {
        AVMDLLog.d(TAG, String.format("****set value:%s for key:%d", str, Integer.valueOf(i4)));
        synchronized (AVMDLDNSParser.class) {
            if (i4 != 8) {
                if (i4 == 9 && !TextUtils.isEmpty(str)) {
                    mGlobalGoogleDNSParseHost = str;
                }
            } else if (!TextUtils.isEmpty(str)) {
                mGlobalOwnDNSParseHost = str;
            }
        }
    }

    public static void updateDNSInfo(String str, String str2, long j4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(10, str, str2, (j4 + mGlobalDefaultExpiredTime) * 1000, (String) null);
            AVMDLLog.d(TAG, "server iplist, host = " + str + " type = 10 iplist = " + str2);
            IPCache.getInstance().put(str, aVMDLDNSInfo);
            return;
        }
        AVMDLLog.d(TAG, "ip direct info invalid");
    }

    public void addHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        addListenerInternal(str, aVMDLDNSParserListener);
    }

    public void doParseHosts(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!TextUtils.isEmpty(strArr[i4])) {
                    if (IPCache.getInstance().get(strArr[i4]) != null) {
                        AVMDLLog.d(TAG, String.format("for host:%s has dns info not need do batch parse", strArr[i4]));
                        strArr[i4] = null;
                        length--;
                    } else {
                        this.mLock.lock();
                        try {
                            if (this.mProcessors.get(strArr[i4]) != null) {
                                AVMDLLog.d(TAG, String.format("for host:%s has processor not need do batch parse", strArr[i4]));
                                strArr[i4] = null;
                                length--;
                            }
                        } finally {
                            this.mLock.unlock();
                        }
                    }
                }
            }
            if (length == 0) {
                AVMDLLog.d(TAG, "has no hosts need do batch parse");
                return;
            } else {
                sendBatchParseMsg(strArr);
                return;
            }
        }
        AVMDLLog.d(TAG, "hosts is null, not need do batch host parse");
    }

    public void postParseHostMsg(String str, int i4) {
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i4, str, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 5;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    public void release() {
    }

    public void removeHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        removeListenerInternal(str, aVMDLDNSParserListener);
    }

    public void setBackUpIP(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null));
    }
}
