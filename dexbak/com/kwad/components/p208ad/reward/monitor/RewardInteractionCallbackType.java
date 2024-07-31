package com.kwad.components.p208ad.reward.monitor;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* renamed from: com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum RewardInteractionCallbackType implements InterfaceC8030a {
    AD_CLICK("ad_click"),
    PAGE_DISMISS("page_close"),
    VIDEO_PLAY_ERROR("play_error"),
    VIDEO_PLAY_END("play_end"),
    VIDEO_SKIP_TO_END("skip_to_end"),
    VIDEO_PLAY_START("play_start"),
    REWARD_VERIFY(MediationConstant.REWARD_VERIFY),
    REWARD_STEP_VERIFY("reward_step_verify"),
    EXTRA_REWARD_VERIFY("extra_reward_verify");
    
    private String typeValue;

    RewardInteractionCallbackType(String str) {
        this.typeValue = str;
    }

    @Override // com.kwad.components.p208ad.reward.monitor.InterfaceC8030a
    public final String getTypeValue() {
        return this.typeValue;
    }
}
