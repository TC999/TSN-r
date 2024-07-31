package com.mbridge.msdk.mbdownload.manager;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CampaignReportDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.mbdownload.DownloadNetWorkChangeReceiver;
import com.mbridge.msdk.mbdownload.MBDownloadAgent;
import com.mbridge.msdk.out.IDownloadListener;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ADownloadManager {
    private ConcurrentHashMap<String, ApkDownloadTaskObservable> apkConcurrentHashMap;
    private ConcurrentHashMap<IDownloadListener, ApkDownloadTaskObserver> listenerConcurrentHashMap;
    private ConcurrentHashMap<ApkDownloadTaskObserver, String> listenerUniqueKeyConcurrentHashMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mbridge.msdk.mbdownload.manager.ADownloadManager$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11473a {

        /* renamed from: a */
        private static final ADownloadManager f31387a = new ADownloadManager();
    }

    private void addPreListener(ApkDownloadTaskObservable apkDownloadTaskObservable, String str) {
        if (this.listenerUniqueKeyConcurrentHashMap.containsValue(str)) {
            for (Map.Entry<ApkDownloadTaskObserver, String> entry : this.listenerUniqueKeyConcurrentHashMap.entrySet()) {
                String value = entry.getValue();
                if (str.equals(value)) {
                    apkDownloadTaskObservable.addObserver(entry.getKey());
                    this.listenerUniqueKeyConcurrentHashMap.remove(entry.getKey(), value);
                }
            }
        }
    }

    public static ADownloadManager getInstance() {
        return C11473a.f31387a;
    }

    private static String getTaskUniqueKey(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            String akdlui = campaignEx.getAkdlui();
            return (!TextUtils.isEmpty(akdlui) || TextUtils.isEmpty(str)) ? akdlui : SameMD5.getMD5(str);
        }
        return "";
    }

    private void register() {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m22861j != null) {
            DownloadNetWorkChangeReceiver downloadNetWorkChangeReceiver = new DownloadNetWorkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            m22861j.registerReceiver(downloadNetWorkChangeReceiver, intentFilter);
        }
    }

    private void startNotice(CampaignEx campaignEx, String str) {
        MBDownloadAgent mBDownloadAgent = new MBDownloadAgent(getTaskUniqueKey(campaignEx, str), str);
        mBDownloadAgent.setCanPause(campaignEx.getNtbarpasbl() == 1);
        mBDownloadAgent.setOnGoingStatus(campaignEx.getNtbarpt() == 0);
        mBDownloadAgent.setTargetAppIconUrl(campaignEx.getIconUrl());
        mBDownloadAgent.setTitle(campaignEx.getAppName());
        mBDownloadAgent.start();
    }

    public boolean addDownloadListener(String str, IDownloadListener iDownloadListener) {
        ApkDownloadTaskObserver apkDownloadTaskObserver;
        if (iDownloadListener != null && !TextUtils.isEmpty(str)) {
            if (!this.listenerConcurrentHashMap.containsKey(iDownloadListener)) {
                apkDownloadTaskObserver = new ApkDownloadTaskObserver(iDownloadListener);
                this.listenerConcurrentHashMap.put(iDownloadListener, apkDownloadTaskObserver);
            } else {
                apkDownloadTaskObserver = this.listenerConcurrentHashMap.get(iDownloadListener);
            }
            ApkDownloadTaskObservable apkDownloadTaskObservable = this.apkConcurrentHashMap.get(str);
            if (apkDownloadTaskObservable != null) {
                apkDownloadTaskObservable.addObserver(apkDownloadTaskObserver);
                return true;
            }
            ConcurrentHashMap<ApkDownloadTaskObserver, String> concurrentHashMap = this.listenerUniqueKeyConcurrentHashMap;
            if (concurrentHashMap != null && apkDownloadTaskObserver != null) {
                concurrentHashMap.put(apkDownloadTaskObserver, str);
            }
        }
        return false;
    }

    public void cancelAllTask() {
        ConcurrentHashMap<String, ApkDownloadTaskObservable> concurrentHashMap = this.apkConcurrentHashMap;
        if (concurrentHashMap != null) {
            for (ApkDownloadTaskObservable apkDownloadTaskObservable : concurrentHashMap.values()) {
                if (apkDownloadTaskObservable != null && apkDownloadTaskObservable.m21561d() == 2) {
                    apkDownloadTaskObservable.m21568b();
                }
            }
        }
    }

    public boolean deleteDownloadListener(String str, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null && !TextUtils.isEmpty(str)) {
            ApkDownloadTaskObserver remove = this.listenerConcurrentHashMap.containsKey(iDownloadListener) ? this.listenerConcurrentHashMap.remove(iDownloadListener) : null;
            if (remove != null) {
                remove.m21551a(null);
            }
            ApkDownloadTaskObservable apkDownloadTaskObservable = this.apkConcurrentHashMap.get(str);
            if (apkDownloadTaskObservable != null) {
                apkDownloadTaskObservable.deleteObserver(remove);
                return true;
            }
        }
        return false;
    }

    public int getTaskProgressByUniqueKey(String str) {
        ApkDownloadTaskObservable apkDownloadTaskObservable;
        if (TextUtils.isEmpty(str) || !this.apkConcurrentHashMap.containsKey(str) || (apkDownloadTaskObservable = this.apkConcurrentHashMap.get(str)) == null) {
            return 0;
        }
        return apkDownloadTaskObservable.m21558e();
    }

    public int getTaskStatusByUniqueKey(String str) {
        ApkDownloadTaskObservable apkDownloadTaskObservable;
        if (TextUtils.isEmpty(str) || !this.apkConcurrentHashMap.containsKey(str) || (apkDownloadTaskObservable = this.apkConcurrentHashMap.get(str)) == null) {
            return -1;
        }
        return apkDownloadTaskObservable.m21561d();
    }

    public String initAPKDownloadTask(CampaignEx campaignEx, String str, IDownloadListener iDownloadListener) {
        String taskUniqueKey = getTaskUniqueKey(campaignEx, str);
        if (!TextUtils.isEmpty(taskUniqueKey)) {
            CampaignDAIDao m22789a = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            int m22781c = m22789a.m22781c(taskUniqueKey);
            if (m22781c != 1 && m22781c != 10 && m22781c != 11) {
                if (m22781c == 0) {
                    campaignEx.setAkdlui(taskUniqueKey);
                    m22789a.m22788a(campaignEx);
                    CampaignReportDao.m22726b(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22727a(campaignEx);
                }
                ApkDownloadTaskObservable apkDownloadTaskObservable = null;
                if (!this.apkConcurrentHashMap.containsKey(taskUniqueKey)) {
                    apkDownloadTaskObservable = new ApkDownloadTaskObservable(taskUniqueKey, str);
                    this.apkConcurrentHashMap.put(taskUniqueKey, apkDownloadTaskObservable);
                    addPreListener(apkDownloadTaskObservable, taskUniqueKey);
                } else {
                    ApkDownloadTaskObservable apkDownloadTaskObservable2 = this.apkConcurrentHashMap.get(taskUniqueKey);
                    int m21561d = apkDownloadTaskObservable2.m21561d();
                    if (m21561d == 1 || m21561d == 10 || m21561d == 11) {
                        String m21556f = apkDownloadTaskObservable2.m21556f();
                        CommonClickUtil.m23077a(MBSDKContext.m22865f().m22861j(), Uri.fromFile(new File(m21556f)), str, taskUniqueKey);
                        m22789a.m22782b(taskUniqueKey, m21556f);
                        return taskUniqueKey;
                    }
                }
                if (apkDownloadTaskObservable != null && apkDownloadTaskObservable.m21561d() != 2) {
                    startNotice(campaignEx, str);
                }
                addDownloadListener(taskUniqueKey, iDownloadListener);
            } else {
                CommonClickUtil.m23077a(MBSDKContext.m22865f().m22861j(), Uri.fromFile(new File(m22789a.m22775i(taskUniqueKey))), str, taskUniqueKey);
            }
        }
        return taskUniqueKey;
    }

    public void installApkByUniqueKey(String str, String str2) {
        ApkDownloadTaskObservable apkDownloadTaskObservable;
        if (TextUtils.isEmpty(str) || !this.apkConcurrentHashMap.containsKey(str) || (apkDownloadTaskObservable = this.apkConcurrentHashMap.get(str)) == null) {
            return;
        }
        String m21556f = apkDownloadTaskObservable.m21556f();
        if (TextUtils.isEmpty(m21556f) || !new File(m21556f).exists()) {
            return;
        }
        CommonClickUtil.m23077a(MBSDKContext.m22865f().m22861j(), Uri.fromFile(new File(m21556f)), str2, str);
    }

    public void installed(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApkDownloadTaskObservable apkDownloadTaskObservable = this.apkConcurrentHashMap.containsKey(str) ? this.apkConcurrentHashMap.get(str) : null;
        if (apkDownloadTaskObservable != null) {
            apkDownloadTaskObservable.m21564c();
        }
    }

    public void pause(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApkDownloadTaskObservable apkDownloadTaskObservable = this.apkConcurrentHashMap.containsKey(str) ? this.apkConcurrentHashMap.get(str) : null;
        if (apkDownloadTaskObservable != null) {
            apkDownloadTaskObservable.m21568b();
        }
    }

    public void reStartAllTask() {
        int m21561d;
        ConcurrentHashMap<String, ApkDownloadTaskObservable> concurrentHashMap = this.apkConcurrentHashMap;
        if (concurrentHashMap != null) {
            for (ApkDownloadTaskObservable apkDownloadTaskObservable : concurrentHashMap.values()) {
                if (apkDownloadTaskObservable != null && ((m21561d = apkDownloadTaskObservable.m21561d()) == 5 || m21561d == 6 || m21561d == -1 || m21561d == 8 || m21561d == 2)) {
                    apkDownloadTaskObservable.m21573a();
                }
            }
        }
    }

    public void start(String str, String str2) {
        ApkDownloadTaskObservable apkDownloadTaskObservable;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.apkConcurrentHashMap.containsKey(str)) {
            apkDownloadTaskObservable = new ApkDownloadTaskObservable(str, str2);
            this.apkConcurrentHashMap.put(str, apkDownloadTaskObservable);
        } else {
            apkDownloadTaskObservable = this.apkConcurrentHashMap.get(str);
        }
        if (apkDownloadTaskObservable != null) {
            apkDownloadTaskObservable.m21573a();
        }
    }

    private ADownloadManager() {
        this.apkConcurrentHashMap = new ConcurrentHashMap<>();
        this.listenerConcurrentHashMap = new ConcurrentHashMap<>();
        this.listenerUniqueKeyConcurrentHashMap = new ConcurrentHashMap<>();
        register();
    }
}
