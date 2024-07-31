package com.bytedance.sdk.openadsdk;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TTCodeGroupRit {

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface TTCodeGroupRitListener {
        void onFail(int i, String str);

        void onSuccess(TTCodeGroupRit tTCodeGroupRit);
    }

    String getRit();

    int getSlotType();
}
