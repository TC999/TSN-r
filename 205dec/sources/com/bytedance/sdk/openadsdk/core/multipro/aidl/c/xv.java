package com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends c {

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<t>> f33919c = new HashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private static volatile xv f33920w;

    public static xv w() {
        if (f33920w == null) {
            synchronized (xv.class) {
                if (f33920w == null) {
                    f33920w = new xv();
                }
            }
        }
        return f33920w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, t tVar) throws RemoteException {
        if (tVar == null) {
            return;
        }
        RemoteCallbackList<t> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(tVar);
        f33919c.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, int i4) throws RemoteException {
        RemoteCallbackList<t> remove = f33919c.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i5 = 0; i5 < beginBroadcast; i5++) {
            t broadcastItem = remove.getBroadcastItem(i5);
            if (broadcastItem != null) {
                if (i4 == 1) {
                    broadcastItem.c();
                } else if (i4 == 2) {
                    broadcastItem.w();
                } else if (i4 != 3) {
                    broadcastItem.xv();
                } else {
                    broadcastItem.xv();
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
