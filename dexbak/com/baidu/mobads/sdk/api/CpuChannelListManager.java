package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2716m;
import com.baidu.mobads.sdk.internal.EnumC2629bo;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CpuChannelListManager {
    private static final String TAG = "CpuChannelListManager";
    private C2716m mCPUChannelListProd;
    private CpuChannelListListener mChannelIdListListener;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface CpuChannelListListener {
        void onChannelListError(String str, int i);

        void onChannelListLoaded(List<CpuChannelResponse> list);
    }

    public CpuChannelListManager(Context context, CpuChannelListListener cpuChannelListListener) {
        C2716m c2716m = new C2716m(context);
        this.mCPUChannelListProd = c2716m;
        this.mChannelIdListListener = cpuChannelListListener;
        c2716m.m50355a(cpuChannelListListener);
    }

    public void loadChannelList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C2634bs.m50744a().m50728c(TAG, "SubChannelId is null!");
            CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
            if (cpuChannelListListener != null) {
                cpuChannelListListener.onChannelListError("SubChannelId is null.", EnumC2629bo.INTERFACE_USE_PROBLEM.m50776b());
            }
        } else if (TextUtils.isEmpty(str)) {
            C2634bs.m50744a().m50728c(TAG, "appsid is null!");
            CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
            if (cpuChannelListListener2 != null) {
                cpuChannelListListener2.onChannelListError("appsid is null.", EnumC2629bo.INTERFACE_USE_PROBLEM.m50776b());
            }
        } else {
            try {
                int parseInt = Integer.parseInt(str2);
                C2716m c2716m = this.mCPUChannelListProd;
                if (c2716m != null) {
                    c2716m.m50353a(str, parseInt);
                    this.mCPUChannelListProd.mo50356a();
                }
            } catch (Exception unused) {
                C2634bs.m50744a().m50728c(TAG, "SubChannelId is not Integer!");
                if (this.mChannelIdListListener != null) {
                    this.mChannelIdListListener.onChannelListError("SubChannelId is not Integer!", EnumC2629bo.INTERFACE_USE_PROBLEM.m50776b());
                }
            }
        }
    }
}
