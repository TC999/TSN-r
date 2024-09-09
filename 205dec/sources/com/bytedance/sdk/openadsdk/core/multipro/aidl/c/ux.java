package com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.fp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, RemoteCallbackList<fp>> f33915c = Collections.synchronizedMap(new HashMap());

    /* renamed from: w  reason: collision with root package name */
    private static volatile ux f33916w;

    public static ux w() {
        if (f33916w == null) {
            synchronized (ux.class) {
                if (f33916w == null) {
                    f33916w = new ux();
                }
            }
        }
        return f33916w;
    }

    private synchronized void xv(String str, String str2) {
        RemoteCallbackList<fp> remoteCallbackList;
        try {
            if (f33915c != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = f33915c.remove(str);
                } else {
                    remoteCallbackList = f33915c.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i4 = 0; i4 < beginBroadcast; i4++) {
                        fp broadcastItem = remoteCallbackList.getBroadcastItem(i4);
                        if (broadcastItem != null) {
                            if ("onAdShow".equals(str2)) {
                                broadcastItem.w();
                            } else if ("onAdClose".equals(str2)) {
                                broadcastItem.sr();
                            } else if ("onVideoComplete".equals(str2)) {
                                broadcastItem.ux();
                            } else if ("onSkippedVideo".equals(str2)) {
                                broadcastItem.f();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                broadcastItem.xv();
                            } else if ("recycleRes".equals(str2)) {
                                broadcastItem.c();
                            }
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th) {
            a.xv("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public synchronized void c(String str, fp fpVar) throws RemoteException {
        RemoteCallbackList<fp> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(fpVar);
        f33915c.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, String str2) throws RemoteException {
        xv(str, str2);
    }
}
