package com.bytedance.pangle.sdk.component.log.impl;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.MyDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.core.multi.EventProviderImpl;
import com.bytedance.pangle.sdk.component.log.impl.core.multi.OverSeasEventProviderImpl;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.net.TTRunnable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EventMultiUtils implements IAdLog {
    public static final EventMultiUtils INSTANCE = new EventMultiUtils();

    private void checkParams(AdLogConfig adLogConfig, Context context) {
        AssertUtils.assertParams(context, "context == null");
        AssertUtils.assertParams(adLogConfig, "AdLogConfig == null");
        AssertUtils.assertParams(adLogConfig.getAdLogDepend(), "AdLogDepend ==null");
    }

    private void dispatchEvent(final AdLogEventFace adLogEventFace) {
        final IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogEventFace == null || adLogDepend == null || LogInternalManager.getInstance().getContext() == null || adLogDepend.providerLogExecutor() == null) {
            return;
        }
        if (LogInternalManager.getInstance().isSupportMultiProcess()) {
            boolean isMainProcess = isMainProcess(LogInternalManager.getInstance().getContext(), adLogDepend);
            LDebug.d("dispatchEvent mainProcess:" + isMainProcess);
            if (isMainProcess) {
                LogInternalManager.getInstance().reportEvent(adLogEventFace);
                return;
            }
            LDebug.d("sub thread dispatch:" + isMainThread());
            if (isMainThread()) {
                adLogDepend.providerLogExecutor().execute(new TTRunnable("dispatchEvent") { // from class: com.bytedance.pangle.sdk.component.log.impl.EventMultiUtils.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EventMultiUtils.this.subDispatchAdEvent(adLogEventFace, adLogDepend.sdkType());
                    }
                });
                return;
            } else {
                subDispatchAdEvent(adLogEventFace, adLogDepend.sdkType());
                return;
            }
        }
        LogInternalManager.getInstance().reportEvent(adLogEventFace);
    }

    private boolean isMainProcess(Context context, IAdLogDepend iAdLogDepend) {
        if (context == null || iAdLogDepend == null) {
            return false;
        }
        try {
            return ProcessUtils.isMainProcess(context);
        } catch (Throwable th) {
            LDebug.e(th.getMessage());
            return true;
        }
    }

    private boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void loadDebugEvent(AdLogConfig adLogConfig) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subDispatchAdEvent(AdLogEventFace adLogEventFace, int i4) {
        if (i4 == 0 || i4 == 2) {
            EventProviderImpl.dispatchAdEvent(adLogEventFace);
        } else if (i4 == 1) {
            OverSeasEventProviderImpl.dispatchAdEvent(adLogEventFace);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subStart(int i4) {
        if (i4 == 0 || i4 == 2) {
            EventProviderImpl.start();
        } else if (i4 == 1) {
            OverSeasEventProviderImpl.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subStop(int i4) {
        if (i4 == 0 || i4 == 2) {
            EventProviderImpl.stop();
        } else if (i4 == 1) {
            OverSeasEventProviderImpl.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subThreadTrack(String str, List<String> list, boolean z3, int i4) {
        if (i4 == 0 || i4 == 2) {
            EventProviderImpl.track(str, list, z3);
        } else if (i4 == 1) {
            OverSeasEventProviderImpl.track(str, list, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subTrackFailUrls(String str, int i4) {
        if (i4 == 0 || i4 == 2) {
            EventProviderImpl.trackFailed(str);
        } else if (i4 == 1) {
            OverSeasEventProviderImpl.trackFailed(str);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void flushMemoryAndDB() {
        LDebug.d("flushMemoryAndDB");
        LogInternalManager.getInstance().flushMemoryAndDB();
    }

    public void initHelper(AdLogConfig adLogConfig, Context context) {
        checkParams(adLogConfig, context);
        LogInternalManager.getInstance().setContext(context);
        LogInternalManager.getInstance().setUpLoader(adLogConfig.getUploader());
        LogInternalManager.getInstance().setHighPolicyConfig(adLogConfig.getHighPolicyConfig());
        LogInternalManager.getInstance().setNormalPolicyConfig(adLogConfig.getNormalPolicyConfig());
        LogInternalManager.getInstance().setBatchPolicyConfig(adLogConfig.getBatchPolicyConfig());
        LogInternalManager.getInstance().setOtherConfig(adLogConfig.getOtherConfig());
        LogInternalManager.getInstance().setDbCallback(adLogConfig.getDbCallback() == null ? MyDBCallback.INSTANCE : adLogConfig.getDbCallback());
        LogInternalManager.getInstance().setSupportMultiProcess(adLogConfig.isSupportMultiProcess());
        LogInternalManager.getInstance().setAdLogDepend(adLogConfig.getAdLogDepend());
        loadDebugEvent(adLogConfig);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportBatchStatsEvent(AdLogEventFace adLogEventFace) {
        adLogEventFace.setAdType((byte) 1);
        adLogEventFace.setPriority((byte) 3);
        dispatchEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportEvent(AdLogEventFace adLogEventFace) {
        dispatchEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportHighPriorityEvent(AdLogEventFace adLogEventFace) {
        adLogEventFace.setAdType((byte) 0);
        adLogEventFace.setPriority((byte) 1);
        dispatchEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportRealStatsEvent(AdLogEventFace adLogEventFace) {
        adLogEventFace.setAdType((byte) 1);
        adLogEventFace.setPriority((byte) 2);
        dispatchEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportRealTimeAdEvent(AdLogEventFace adLogEventFace) {
        adLogEventFace.setAdType((byte) 0);
        adLogEventFace.setPriority((byte) 2);
        dispatchEvent(adLogEventFace);
    }

    public void setDBCallback(IDBCallback iDBCallback) {
        LogInternalManager logInternalManager = LogInternalManager.getInstance();
        if (iDBCallback == null) {
            iDBCallback = MyDBCallback.INSTANCE;
        }
        logInternalManager.setDbCallback(iDBCallback);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void start() {
        LDebug.d("EventMultiUtils start");
        final IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || adLogDepend.providerLogExecutor() == null) {
            return;
        }
        if (LogInternalManager.getInstance().isSupportMultiProcess()) {
            if (isMainProcess(LogInternalManager.getInstance().getContext(), adLogDepend)) {
                LogInternalManager.getInstance().start();
                return;
            } else if (isMainThread()) {
                adLogDepend.providerLogExecutor().execute(new TTRunnable(CampaignEx.JSON_NATIVE_VIDEO_START) { // from class: com.bytedance.pangle.sdk.component.log.impl.EventMultiUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LDebug.d("TTExecutor start");
                        EventMultiUtils.this.subStart(adLogDepend.sdkType());
                    }
                });
                return;
            } else {
                subStart(adLogDepend.sdkType());
                return;
            }
        }
        LogInternalManager.getInstance().start();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void stop() {
        final IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || adLogDepend.providerLogExecutor() == null) {
            return;
        }
        if (LogInternalManager.getInstance().isSupportMultiProcess()) {
            if (isMainProcess(LogInternalManager.getInstance().getContext(), adLogDepend)) {
                LogInternalManager.getInstance().stop();
                return;
            } else if (isMainThread()) {
                adLogDepend.providerLogExecutor().execute(new TTRunnable("stop") { // from class: com.bytedance.pangle.sdk.component.log.impl.EventMultiUtils.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EventMultiUtils.this.subStop(adLogDepend.sdkType());
                    }
                });
                return;
            } else {
                subStop(adLogDepend.sdkType());
                return;
            }
        }
        LogInternalManager.getInstance().stop();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void track(final String str, final List<String> list, final boolean z3) {
        final IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || adLogDepend.providerLogExecutor() == null || !adLogDepend.enableTrack()) {
            return;
        }
        if (adLogDepend.sdkType() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if ((adLogDepend.sdkType() == 0 || adLogDepend.sdkType() == 2) && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (LogInternalManager.getInstance().isSupportMultiProcess() && !isMainProcess(LogInternalManager.getInstance().getContext(), adLogDepend)) {
            if (isMainThread()) {
                adLogDepend.providerLogExecutor().execute(new TTRunnable("trackFailed") { // from class: com.bytedance.pangle.sdk.component.log.impl.EventMultiUtils.4
                    @Override // java.lang.Runnable
                    public void run() {
                        EventMultiUtils.this.subThreadTrack(str, list, z3, adLogDepend.sdkType());
                    }
                });
                return;
            } else {
                subThreadTrack(str, list, z3, adLogDepend.sdkType());
                return;
            }
        }
        LogInternalManager.getInstance().track(str, list, z3);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void trackFailedUrls(final String str) {
        final IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || adLogDepend.providerLogExecutor() == null || !adLogDepend.enableTrack()) {
            return;
        }
        if ((adLogDepend.sdkType() == 0 || adLogDepend.sdkType() == 2) && TextUtils.isEmpty(str)) {
            return;
        }
        if (LogInternalManager.getInstance().isSupportMultiProcess() && !isMainProcess(LogInternalManager.getInstance().getContext(), adLogDepend)) {
            if (isMainThread()) {
                adLogDepend.providerLogExecutor().execute(new TTRunnable("trackFailed") { // from class: com.bytedance.pangle.sdk.component.log.impl.EventMultiUtils.5
                    @Override // java.lang.Runnable
                    public void run() {
                        EventMultiUtils.this.subTrackFailUrls(str, adLogDepend.sdkType());
                    }
                });
                return;
            } else {
                subTrackFailUrls(str, adLogDepend.sdkType());
                return;
            }
        }
        LogInternalManager.getInstance().trackFailedUrls(str);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void trackStop() {
    }
}
