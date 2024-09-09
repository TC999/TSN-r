package com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, RemoteCallbackList<s>> f33909c = Collections.synchronizedMap(new HashMap());

    /* renamed from: w  reason: collision with root package name */
    private static volatile f f33910w;

    public static f w() {
        if (f33910w == null) {
            synchronized (f.class) {
                if (f33910w == null) {
                    f33910w = new f();
                }
            }
        }
        return f33910w;
    }

    private synchronized Bundle xv(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        RemoteCallbackList<s> remoteCallbackList;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<s>> map = f33909c;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = map.remove(str);
                } else {
                    remoteCallbackList = map.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i4 = 0; i4 < beginBroadcast; i4++) {
                        try {
                            s broadcastItem = remoteCallbackList.getBroadcastItem(i4);
                            if (broadcastItem != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = broadcastItem.c(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, s sVar) throws RemoteException {
        RemoteCallbackList<s> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(sVar);
        f33909c.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public Bundle w(String str, String str2, Bundle bundle) throws RemoteException {
        return xv(str, str2, bundle);
    }
}
