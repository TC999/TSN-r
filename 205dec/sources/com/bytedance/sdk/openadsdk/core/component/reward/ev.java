package com.bytedance.sdk.openadsdk.core.component.reward;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.ia;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    protected static HashMap<Integer, ia> f32369c = new HashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private static final ExecutorService f32370w = com.bytedance.sdk.component.gd.sr.c(new com.bytedance.sdk.component.gd.k("RewardFullCallback"));

    public static void c(final int i4, final String str, final String str2, final Bundle bundle) {
        f32370w.execute(new com.bytedance.sdk.component.gd.p("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ev.1
            @Override // java.lang.Runnable
            public void run() {
                ia iaVar = ev.f32369c.get(Integer.valueOf(i4));
                if (iaVar == null) {
                    iaVar = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(i4));
                    ev.f32369c.put(Integer.valueOf(i4), iaVar);
                }
                if (iaVar == null) {
                    com.bytedance.sdk.component.utils.a.w("RewardFullCallback", "listenerManager == null callback error");
                    return;
                }
                try {
                    int i5 = i4;
                    if (i5 == 0) {
                        iaVar.c(str, str2, bundle);
                    } else if (i5 == 1) {
                        iaVar.c(str, str2);
                    } else if (i5 == 5) {
                        iaVar.w(str, str2, bundle);
                    }
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public static void c(final String str, final com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar) {
        f32370w.execute(new com.bytedance.sdk.component.gd.p("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ev.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.c c4 = com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext());
                if (cVar != null) {
                    com.bytedance.sdk.component.utils.a.w("MultiProcess", "start registerRewardVideoListener ! ");
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux uxVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.ux(cVar);
                    ia c5 = ia.c.c(c4.c(0));
                    if (c5 != null) {
                        try {
                            c5.c(str, uxVar);
                            com.bytedance.sdk.component.utils.a.w("MultiProcess", "end registerRewardVideoListener ! ");
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static void c(final String str, final com.bytedance.sdk.openadsdk.gb.c.w.c.w wVar) {
        f32370w.execute(new com.bytedance.sdk.component.gd.p("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ev.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.c c4 = com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext());
                if (wVar != null) {
                    com.bytedance.sdk.component.utils.a.w("MultiProcess", "start registerRewardVideoListener ! ");
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.w.sr srVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.sr(wVar);
                    ia c5 = ia.c.c(c4.c(5));
                    if (c5 != null) {
                        try {
                            c5.c(str, srVar);
                            com.bytedance.sdk.component.utils.a.w("MultiProcess", "end registerRewardVideoListener ! ");
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static void c(final String str, final com.bytedance.sdk.openadsdk.q.c.w.c.c cVar) {
        f32370w.execute(new com.bytedance.sdk.component.gd.p("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ev.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.c c4 = com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext());
                if (cVar != null) {
                    com.bytedance.sdk.component.utils.a.w("MultiProcess", "start registerFullScreenVideoListener ! ");
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv xvVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.xv(cVar);
                    ia c5 = ia.c.c(c4.c(1));
                    if (c5 != null) {
                        try {
                            c5.c(str, xvVar);
                            com.bytedance.sdk.component.utils.a.w("MultiProcess", "end registerFullScreenVideoListener ! ");
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
