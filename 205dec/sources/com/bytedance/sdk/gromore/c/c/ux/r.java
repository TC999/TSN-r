package com.bytedance.sdk.gromore.c.c.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {
    public static void c(com.bytedance.msdk.api.xv.c cVar, String str) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe_reward", "RewardUtils  " + str);
        if (cVar != null) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe_reward", "rewardItem.getRewardName " + cVar.getRewardName());
            com.bytedance.msdk.adapter.sr.xv.w("TMe_reward", "rewardItem.getAmount " + cVar.getAmount());
            com.bytedance.msdk.adapter.sr.xv.w("TMe_reward", "rewardItem.getCustomData() " + cVar.getCustomData());
            com.bytedance.msdk.adapter.sr.xv.w("TMe_reward", "rewardItem.rewardVerify() " + cVar.rewardVerify());
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TMe_reward", "rewardItem is null ");
    }
}
