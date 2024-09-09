package com.bytedance.pangle.sdk.component.log.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.core.IUploader;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApi;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import com.bytedance.pangle.sdk.component.log.impl.track.MyTrack;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LogInternalManager implements IAdLog {
    private static LogInternalManager sManager;
    private static volatile EventNetApi sNetApi;
    private volatile IAdLogDepend adLogDepend;
    private volatile PolicyConfig batchPolicyConfig;
    private volatile PolicyConfig highPolicyConfig;
    private volatile Context mContext;
    private volatile IDBCallback mDbCallback;
    private volatile boolean mSupportMultiProcess;
    private volatile IUploader mUpLoader;
    private volatile PolicyConfig normalPolicyConfig;
    private volatile PolicyConfig otherConfig;

    private LogInternalManager() {
    }

    private Uri getContentUri() {
        return Uri.parse(TTPathConst.sAuthority + TTPathConst.sSeparator + "message" + TTPathConst.sSeparator);
    }

    public static synchronized LogInternalManager getInstance() {
        LogInternalManager logInternalManager;
        synchronized (LogInternalManager.class) {
            if (sManager == null) {
                sManager = new LogInternalManager();
            }
            logInternalManager = sManager;
        }
        return logInternalManager;
    }

    public static EventNetApi getNetApi() {
        if (sNetApi == null) {
            synchronized (LogInternalManager.class) {
                if (sNetApi == null) {
                    sNetApi = new EventNetApiImpl();
                }
            }
        }
        return sNetApi;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void flushMemoryAndDB() {
        LogThreadCenter.instance.flushMemoryAndDB();
    }

    public IAdLogDepend getAdLogDepend() {
        return this.adLogDepend;
    }

    public PolicyConfig getBatchPolicyConfig() {
        return this.batchPolicyConfig;
    }

    public Context getContext() {
        return this.mContext;
    }

    public IDBCallback getDbCallback() {
        return this.mDbCallback;
    }

    public PolicyConfig getHighPolicyConfig() {
        return this.highPolicyConfig;
    }

    public PolicyConfig getNormalPolicyConfig() {
        return this.normalPolicyConfig;
    }

    public PolicyConfig getOtherConfig() {
        return this.otherConfig;
    }

    public IUploader getUpLoader() {
        return this.mUpLoader;
    }

    public boolean isSupportMultiProcess() {
        return this.mSupportMultiProcess;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportBatchStatsEvent(AdLogEventFace adLogEventFace) {
        reportEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportEvent(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null) {
            return;
        }
        adLogEventFace.setCreateTime(System.currentTimeMillis());
        LogThreadCenter.instance.report(adLogEventFace, adLogEventFace.getAdType());
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportHighPriorityEvent(AdLogEventFace adLogEventFace) {
        reportEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportRealStatsEvent(AdLogEventFace adLogEventFace) {
        reportEvent(adLogEventFace);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void reportRealTimeAdEvent(AdLogEventFace adLogEventFace) {
        reportEvent(adLogEventFace);
    }

    public void setAdLogDepend(IAdLogDepend iAdLogDepend) {
        this.adLogDepend = iAdLogDepend;
    }

    public void setBatchPolicyConfig(PolicyConfig policyConfig) {
        this.batchPolicyConfig = policyConfig;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setDbCallback(IDBCallback iDBCallback) {
        this.mDbCallback = iDBCallback;
    }

    public void setHighPolicyConfig(PolicyConfig policyConfig) {
        this.highPolicyConfig = policyConfig;
    }

    public void setNormalPolicyConfig(PolicyConfig policyConfig) {
        this.normalPolicyConfig = policyConfig;
    }

    public void setOtherConfig(PolicyConfig policyConfig) {
        this.otherConfig = policyConfig;
    }

    public void setSupportMultiProcess(boolean z3) {
        this.mSupportMultiProcess = z3;
    }

    public void setUpLoader(IUploader iUploader) {
        this.mUpLoader = iUploader;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void start() {
        LogThreadCenter.instance.start();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void stop() {
        LogThreadCenter.instance.stopLogThread();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void track(String str, List<String> list, boolean z3) {
        MyTrack.getTrackAdUrl().track(str, list, z3);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void trackFailedUrls(String str) {
        MyTrack.getTrackAdUrl().trackFailedUrls(str);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.IAdLog
    public void trackStop() {
        MyTrack.getTrackAdUrl().stop();
    }
}
