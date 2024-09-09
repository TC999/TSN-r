package com.mbridge.msdk.mbdownload.manager;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.mbdownload.DownloadNetWorkChangeReceiver;
import com.mbridge.msdk.mbdownload.f;
import com.mbridge.msdk.out.IDownloadListener;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ADownloadManager {
    private ConcurrentHashMap<String, com.mbridge.msdk.mbdownload.manager.a> apkConcurrentHashMap;
    private ConcurrentHashMap<IDownloadListener, b> listenerConcurrentHashMap;
    private ConcurrentHashMap<b, String> listenerUniqueKeyConcurrentHashMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ADownloadManager f40159a = new ADownloadManager();
    }

    private void addPreListener(com.mbridge.msdk.mbdownload.manager.a aVar, String str) {
        if (this.listenerUniqueKeyConcurrentHashMap.containsValue(str)) {
            for (Map.Entry<b, String> entry : this.listenerUniqueKeyConcurrentHashMap.entrySet()) {
                String value = entry.getValue();
                if (str.equals(value)) {
                    aVar.addObserver(entry.getKey());
                    this.listenerUniqueKeyConcurrentHashMap.remove(entry.getKey(), value);
                }
            }
        }
    }

    public static ADownloadManager getInstance() {
        return a.f40159a;
    }

    private static String getTaskUniqueKey(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            String akdlui = campaignEx.getAkdlui();
            return (!TextUtils.isEmpty(akdlui) || TextUtils.isEmpty(str)) ? akdlui : SameMD5.getMD5(str);
        }
        return "";
    }

    private void register() {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (j4 != null) {
            DownloadNetWorkChangeReceiver downloadNetWorkChangeReceiver = new DownloadNetWorkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            j4.registerReceiver(downloadNetWorkChangeReceiver, intentFilter);
        }
    }

    private void startNotice(CampaignEx campaignEx, String str) {
        f fVar = new f(getTaskUniqueKey(campaignEx, str), str);
        fVar.setCanPause(campaignEx.getNtbarpasbl() == 1);
        fVar.setOnGoingStatus(campaignEx.getNtbarpt() == 0);
        fVar.setTargetAppIconUrl(campaignEx.getIconUrl());
        fVar.setTitle(campaignEx.getAppName());
        fVar.start();
    }

    public boolean addDownloadListener(String str, IDownloadListener iDownloadListener) {
        b bVar;
        if (iDownloadListener != null && !TextUtils.isEmpty(str)) {
            if (!this.listenerConcurrentHashMap.containsKey(iDownloadListener)) {
                bVar = new b(iDownloadListener);
                this.listenerConcurrentHashMap.put(iDownloadListener, bVar);
            } else {
                bVar = this.listenerConcurrentHashMap.get(iDownloadListener);
            }
            com.mbridge.msdk.mbdownload.manager.a aVar = this.apkConcurrentHashMap.get(str);
            if (aVar != null) {
                aVar.addObserver(bVar);
                return true;
            }
            ConcurrentHashMap<b, String> concurrentHashMap = this.listenerUniqueKeyConcurrentHashMap;
            if (concurrentHashMap != null && bVar != null) {
                concurrentHashMap.put(bVar, str);
            }
        }
        return false;
    }

    public void cancelAllTask() {
        ConcurrentHashMap<String, com.mbridge.msdk.mbdownload.manager.a> concurrentHashMap = this.apkConcurrentHashMap;
        if (concurrentHashMap != null) {
            for (com.mbridge.msdk.mbdownload.manager.a aVar : concurrentHashMap.values()) {
                if (aVar != null && aVar.d() == 2) {
                    aVar.b();
                }
            }
        }
    }

    public boolean deleteDownloadListener(String str, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null && !TextUtils.isEmpty(str)) {
            b remove = this.listenerConcurrentHashMap.containsKey(iDownloadListener) ? this.listenerConcurrentHashMap.remove(iDownloadListener) : null;
            if (remove != null) {
                remove.a(null);
            }
            com.mbridge.msdk.mbdownload.manager.a aVar = this.apkConcurrentHashMap.get(str);
            if (aVar != null) {
                aVar.deleteObserver(remove);
                return true;
            }
        }
        return false;
    }

    public int getTaskProgressByUniqueKey(String str) {
        com.mbridge.msdk.mbdownload.manager.a aVar;
        if (TextUtils.isEmpty(str) || !this.apkConcurrentHashMap.containsKey(str) || (aVar = this.apkConcurrentHashMap.get(str)) == null) {
            return 0;
        }
        return aVar.e();
    }

    public int getTaskStatusByUniqueKey(String str) {
        com.mbridge.msdk.mbdownload.manager.a aVar;
        if (TextUtils.isEmpty(str) || !this.apkConcurrentHashMap.containsKey(str) || (aVar = this.apkConcurrentHashMap.get(str)) == null) {
            return -1;
        }
        return aVar.d();
    }

    public String initAPKDownloadTask(CampaignEx campaignEx, String str, IDownloadListener iDownloadListener) {
        String taskUniqueKey = getTaskUniqueKey(campaignEx, str);
        if (!TextUtils.isEmpty(taskUniqueKey)) {
            e a4 = e.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            int c4 = a4.c(taskUniqueKey);
            if (c4 != 1 && c4 != 10 && c4 != 11) {
                if (c4 == 0) {
                    campaignEx.setAkdlui(taskUniqueKey);
                    a4.a(campaignEx);
                    g.b(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(campaignEx);
                }
                com.mbridge.msdk.mbdownload.manager.a aVar = null;
                if (!this.apkConcurrentHashMap.containsKey(taskUniqueKey)) {
                    aVar = new com.mbridge.msdk.mbdownload.manager.a(taskUniqueKey, str);
                    this.apkConcurrentHashMap.put(taskUniqueKey, aVar);
                    addPreListener(aVar, taskUniqueKey);
                } else {
                    com.mbridge.msdk.mbdownload.manager.a aVar2 = this.apkConcurrentHashMap.get(taskUniqueKey);
                    int d4 = aVar2.d();
                    if (d4 == 1 || d4 == 10 || d4 == 11) {
                        String f4 = aVar2.f();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.a.f().j(), Uri.fromFile(new File(f4)), str, taskUniqueKey);
                        a4.b(taskUniqueKey, f4);
                        return taskUniqueKey;
                    }
                }
                if (aVar != null && aVar.d() != 2) {
                    startNotice(campaignEx, str);
                }
                addDownloadListener(taskUniqueKey, iDownloadListener);
            } else {
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.a.f().j(), Uri.fromFile(new File(a4.i(taskUniqueKey))), str, taskUniqueKey);
            }
        }
        return taskUniqueKey;
    }

    public void installApkByUniqueKey(String str, String str2) {
        com.mbridge.msdk.mbdownload.manager.a aVar;
        if (TextUtils.isEmpty(str) || !this.apkConcurrentHashMap.containsKey(str) || (aVar = this.apkConcurrentHashMap.get(str)) == null) {
            return;
        }
        String f4 = aVar.f();
        if (TextUtils.isEmpty(f4) || !new File(f4).exists()) {
            return;
        }
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.a.f().j(), Uri.fromFile(new File(f4)), str2, str);
    }

    public void installed(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.mbridge.msdk.mbdownload.manager.a aVar = this.apkConcurrentHashMap.containsKey(str) ? this.apkConcurrentHashMap.get(str) : null;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void pause(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.mbridge.msdk.mbdownload.manager.a aVar = this.apkConcurrentHashMap.containsKey(str) ? this.apkConcurrentHashMap.get(str) : null;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void reStartAllTask() {
        int d4;
        ConcurrentHashMap<String, com.mbridge.msdk.mbdownload.manager.a> concurrentHashMap = this.apkConcurrentHashMap;
        if (concurrentHashMap != null) {
            for (com.mbridge.msdk.mbdownload.manager.a aVar : concurrentHashMap.values()) {
                if (aVar != null && ((d4 = aVar.d()) == 5 || d4 == 6 || d4 == -1 || d4 == 8 || d4 == 2)) {
                    aVar.a();
                }
            }
        }
    }

    public void start(String str, String str2) {
        com.mbridge.msdk.mbdownload.manager.a aVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.apkConcurrentHashMap.containsKey(str)) {
            aVar = new com.mbridge.msdk.mbdownload.manager.a(str, str2);
            this.apkConcurrentHashMap.put(str, aVar);
        } else {
            aVar = this.apkConcurrentHashMap.get(str);
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    private ADownloadManager() {
        this.apkConcurrentHashMap = new ConcurrentHashMap<>();
        this.listenerConcurrentHashMap = new ConcurrentHashMap<>();
        this.listenerUniqueKeyConcurrentHashMap = new ConcurrentHashMap<>();
        register();
    }
}
