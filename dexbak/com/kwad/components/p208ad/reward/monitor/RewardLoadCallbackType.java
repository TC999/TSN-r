package com.kwad.components.p208ad.reward.monitor;

/* renamed from: com.kwad.components.ad.reward.monitor.RewardLoadCallbackType */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum RewardLoadCallbackType implements InterfaceC8030a {
    LOAD_SUCCESS_BEFORE("load_success_before"),
    LOAD_SUCCESS("load_success"),
    LOAD_ERROR("load_error"),
    LOAD_CACHE_SUCCESS_BEFORE("load_cache_success_before"),
    LOAD_CACHE_SUCCESS("load_cache_success");
    
    private String typeValue;

    RewardLoadCallbackType(String str) {
        this.typeValue = str;
    }

    @Override // com.kwad.components.p208ad.reward.monitor.InterfaceC8030a
    public final String getTypeValue() {
        return this.typeValue;
    }
}
