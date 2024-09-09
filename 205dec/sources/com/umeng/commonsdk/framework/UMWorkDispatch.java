package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMWorkDispatch {
    public static final String GENERAL_CONTENT = "content";
    public static final String GENERAL_HEADER = "header";
    public static final String KEY_EXCEPTION = "exception";
    private static final int MSG_AUTO_PROCESS = 769;
    private static final int MSG_CHECKER_TIMER = 771;
    private static final int MSG_DELAY_PROCESS = 770;
    private static final int MSG_QUIT = 784;
    private static final int MSG_SEND_EVENT = 768;
    private static HandlerThread mNetTask;
    private static a mSender;
    private static Object mSenderInitLock = new Object();
    private static Handler mTaskHandler;

    private UMWorkDispatch() {
    }

    public static void Quit() {
        Handler handler = mTaskHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 784;
            mTaskHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delayProcess() {
        JSONObject buildEnvelopeWithExtHeader;
        ULog.d("--->>> delayProcess Enter...");
        UMRTLog.i("MobclickRT", "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long maxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        JSONObject jSONObject = null;
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(maxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.i("MobclickRT", "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
                return;
            }
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
        JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
        if (jSONObject2 == null || jSONObject3 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i("MobclickRT", "--->>> autoProcess: Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i("MobclickRT", "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(buildEnvelopeWithExtHeader);
    }

    public static synchronized boolean eventHasExist(int i4) {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return false;
            }
            return handler.hasMessages(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleEvent(Message message) {
        int i4 = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i4));
        if (callbackFromModuleName != null) {
            ULog.d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i4) + "]");
            callbackFromModuleName.workEvent(obj, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleQuit() {
        if (mSender == null || mNetTask == null) {
            return;
        }
        a.c();
        ULog.d("--->>> handleQuit: Quit dispatch thread.");
        mNetTask.quit();
        teardown();
    }

    private static synchronized void init() {
        synchronized (UMWorkDispatch.class) {
            ULog.d("--->>> Dispatch: init Enter...");
            if (mNetTask == null) {
                HandlerThread handlerThread = new HandlerThread("work_thread");
                mNetTask = handlerThread;
                handlerThread.start();
                if (mTaskHandler == null) {
                    mTaskHandler = new Handler(mNetTask.getLooper()) { // from class: com.umeng.commonsdk.framework.UMWorkDispatch.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i4 = message.what;
                            if (i4 == 768) {
                                UMWorkDispatch.handleEvent(message);
                            } else if (i4 == 784) {
                                UMWorkDispatch.handleQuit();
                            } else if (i4 == 770) {
                                UMWorkDispatch.delayProcess();
                            } else if (i4 != 771) {
                            } else {
                                UMWorkDispatch.handleEvent(message);
                            }
                        }
                    };
                }
            }
            ULog.d("--->>> Dispatch: init Exit...");
        }
    }

    public static void registerConnStateObserver(UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            a.a(uMSenderStateNotify);
        }
    }

    public static synchronized void removeEvent() {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(771);
        }
    }

    public static void sendDelayProcessMsg(long j4) {
        Handler handler = mTaskHandler;
        if (handler != null) {
            if (handler.hasMessages(770)) {
                UMRTLog.i("MobclickRT", "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.i("MobclickRT", "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message obtainMessage = mTaskHandler.obtainMessage();
            obtainMessage.what = 770;
            mTaskHandler.sendMessageDelayed(obtainMessage, j4);
        }
    }

    public static void sendEvent(Context context, int i4, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        sendEventInternal(context, 768, i4, uMLogDataProtocol, obj, 0L);
    }

    public static void sendEventEx(Context context, int i4, UMLogDataProtocol uMLogDataProtocol, Object obj, long j4) {
        sendEventInternal(context, 771, i4, uMLogDataProtocol, obj, j4);
    }

    public static void sendEventInternal(Context context, int i4, int i5, UMLogDataProtocol uMLogDataProtocol, Object obj, long j4) {
        if (context != null && uMLogDataProtocol != null) {
            UMModuleRegister.registerAppContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            if (UMModuleRegister.registerCallback(i5, uMLogDataProtocol)) {
                if (mNetTask == null || mTaskHandler == null) {
                    init();
                }
                try {
                    if (mTaskHandler != null) {
                        if (UMUtils.isMainProgress(context)) {
                            synchronized (mSenderInitLock) {
                                if (mSender == null) {
                                    UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                                    mSender = new a(context, mTaskHandler);
                                }
                            }
                        }
                        Message obtainMessage = mTaskHandler.obtainMessage();
                        obtainMessage.what = i4;
                        obtainMessage.arg1 = i5;
                        obtainMessage.obj = obj;
                        mTaskHandler.sendMessageDelayed(obtainMessage, j4);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
                    return;
                }
            }
            return;
        }
        ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
    }

    private static void teardown() {
        if (mNetTask != null) {
            mNetTask = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler = null;
        }
        if (mSender != null) {
            mSender = null;
        }
    }

    public static void sendEvent(Context context, int i4, UMLogDataProtocol uMLogDataProtocol, Object obj, long j4) {
        sendEventInternal(context, 768, i4, uMLogDataProtocol, obj, j4);
    }

    public static synchronized boolean eventHasExist() {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return false;
            }
            return handler.hasMessages(771);
        }
    }

    public static synchronized void removeEvent(int i4) {
        synchronized (UMWorkDispatch.class) {
            Handler handler = mTaskHandler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(i4);
        }
    }
}
