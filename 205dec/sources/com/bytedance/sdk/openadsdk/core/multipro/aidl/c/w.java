package com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, RemoteCallbackList<u>> f33917c = Collections.synchronizedMap(new HashMap());

    /* renamed from: w  reason: collision with root package name */
    private static volatile w f33918w;

    public static w w() {
        if (f33918w == null) {
            synchronized (w.class) {
                if (f33918w == null) {
                    f33918w = new w();
                }
            }
        }
        return f33918w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, u uVar) throws RemoteException {
        RemoteCallbackList<u> remoteCallbackList = f33917c.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(uVar);
        f33917c.put(str, remoteCallbackList);
        a.f("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:" + str);
        a.f("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + f33917c.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, String str2, long j4, long j5, String str3, String str4) throws RemoteException {
        w(str, str2, j4, j5, str3, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void w(String str, u uVar) throws RemoteException {
        Map<String, RemoteCallbackList<u>> map = f33917c;
        if (map == null) {
            a.f("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:" + str);
            return;
        }
        RemoteCallbackList<u> remove = map.remove(str);
        if (remove == null) {
            a.f("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:" + str);
            return;
        }
        c(remove);
        a.f("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:" + str);
        a.f("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + f33917c.size());
    }

    private void c(RemoteCallbackList<u> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i4 = 0; i4 < beginBroadcast; i4++) {
                    u broadcastItem = remoteCallbackList.getBroadcastItem(i4);
                    if (broadcastItem != null) {
                        ((com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f) broadcastItem).xv();
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th) {
                a.xv("MultiProcess", "recycleRes2 throw Exception : ", th);
            }
        }
    }

    private synchronized void w(String str, String str2, long j4, long j5, String str3, String str4) {
        u broadcastItem;
        try {
        } catch (Throwable th) {
            a.xv("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th);
        }
        if (f33917c == null) {
            return;
        }
        if ("recycleRes".equals(str2)) {
            c(f33917c.remove(str));
            a.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:" + str);
            a.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + f33917c.size());
            return;
        }
        RemoteCallbackList<u> remoteCallbackList = f33917c.get(str);
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i4 = 0; i4 < beginBroadcast; i4++) {
                try {
                    broadcastItem = remoteCallbackList.getBroadcastItem(i4);
                } catch (Throwable th2) {
                    th = th2;
                }
                if (broadcastItem != null) {
                    if ("onIdle".equals(str2)) {
                        broadcastItem.c();
                    } else if ("onDownloadActive".equals(str2)) {
                        broadcastItem.c(j4, j5, str3, str4);
                    } else if ("onDownloadPaused".equals(str2)) {
                        broadcastItem.w(j4, j5, str3, str4);
                    } else if ("onDownloadFailed".equals(str2)) {
                        broadcastItem.xv(j4, j5, str3, str4);
                    } else {
                        if ("onDownloadFinished".equals(str2)) {
                            try {
                                broadcastItem.c(j4, str3, str4);
                            } catch (Throwable th3) {
                                th = th3;
                                a.xv("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                            }
                        } else if ("onInstalled".equals(str2)) {
                            broadcastItem.c(str3, str4);
                        }
                    }
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }
}
