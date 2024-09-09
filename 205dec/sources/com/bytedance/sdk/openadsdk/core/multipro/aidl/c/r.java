package com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.fz;
import com.bytedance.sdk.openadsdk.core.u.yu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, RemoteCallbackList<fz>> f33911c = Collections.synchronizedMap(new HashMap());

    /* renamed from: w  reason: collision with root package name */
    private static volatile r f33912w;

    public static r w() {
        if (f33912w == null) {
            synchronized (r.class) {
                if (f33912w == null) {
                    f33912w = new r();
                }
            }
        }
        return f33912w;
    }

    private synchronized void xv(String str, String str2, Bundle bundle) {
        RemoteCallbackList<fz> remoteCallbackList;
        RemoteCallbackList<fz> remoteCallbackList2;
        try {
            if (f33911c != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = f33911c.remove(str);
                    remoteCallbackList2 = f33911c.remove(yu.c(str));
                } else {
                    remoteCallbackList = f33911c.get(str);
                    remoteCallbackList2 = null;
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i4 = 0; i4 < beginBroadcast; i4++) {
                        fz broadcastItem = remoteCallbackList.getBroadcastItem(i4);
                        if (broadcastItem != null) {
                            if ("onAdShow".equals(str2)) {
                                broadcastItem.w();
                            } else if ("onAdClose".equals(str2)) {
                                broadcastItem.sr();
                            } else if ("onVideoComplete".equals(str2)) {
                                broadcastItem.ux();
                            } else if ("onVideoError".equals(str2)) {
                                broadcastItem.f();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                broadcastItem.xv();
                            } else if ("onRewardVerify".equals(str2)) {
                                c(broadcastItem, bundle);
                            } else if ("onRewardArrived".equals(str2)) {
                                w(broadcastItem, bundle);
                            } else if ("onSkippedVideo".equals(str2)) {
                                broadcastItem.r();
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
                if (remoteCallbackList2 != null) {
                    int beginBroadcast2 = remoteCallbackList2.beginBroadcast();
                    for (int i5 = 0; i5 < beginBroadcast2; i5++) {
                        try {
                            fz broadcastItem2 = remoteCallbackList2.getBroadcastItem(i5);
                            if (broadcastItem2 != null && "recycleRes".equals(str2)) {
                                broadcastItem2.c();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackList2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList2.kill();
                    }
                }
            }
        } catch (Throwable th) {
            a.xv("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public synchronized void c(String str, fz fzVar) throws RemoteException {
        RemoteCallbackList<fz> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(fzVar);
        f33911c.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, String str2, Bundle bundle) throws RemoteException {
        xv(str, str2, bundle);
    }

    private void c(fz fzVar, Bundle bundle) throws RemoteException {
        boolean z3 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i4 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i5 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        fzVar.c(z3, i4, string != null ? string : "", i5, string2 != null ? string2 : "");
    }

    private void w(fz fzVar, Bundle bundle) throws RemoteException {
        boolean z3 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i4 = bundle.getInt("callback_extra_key_reward_type");
        fzVar.c(z3, i4, wv.c(i4, bundle));
    }
}
