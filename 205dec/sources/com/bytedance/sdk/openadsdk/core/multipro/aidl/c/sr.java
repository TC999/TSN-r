package com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ys;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, RemoteCallbackList<ys>> f33913c = new HashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private static volatile sr f33914w;

    public static sr w() {
        if (f33914w == null) {
            synchronized (sr.class) {
                if (f33914w == null) {
                    f33914w = new sr();
                }
            }
        }
        return f33914w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void c(String str, ys ysVar) throws RemoteException {
        if (ysVar == null) {
            return;
        }
        a.w("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
        RemoteCallbackList<ys> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(ysVar);
        f33913c.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c, com.bytedance.sdk.openadsdk.core.ia
    public void w(String str, String str2) throws RemoteException {
        a.w("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + ", " + str2);
        RemoteCallbackList<ys> remove = f33913c.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i4 = 0; i4 < beginBroadcast; i4++) {
            ys broadcastItem = remove.getBroadcastItem(i4);
            if (broadcastItem != null) {
                a.w("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + ", " + str2);
                if (str2 == null) {
                    broadcastItem.c();
                } else {
                    broadcastItem.c(str2);
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
