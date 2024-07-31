package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdGlobalConfigInfo extends C10482a implements Serializable {
    private static final long serialVersionUID = -2622260965144406821L;
    @Nullable
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public int neoPageType;
    public NeoScanAggregationSceneInfo neoScanAggregationSceneInfo;

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class NeoScanAggregationSceneInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -4381505798843439175L;
        public boolean guidSwipezShowMore;
        public boolean mute;
        public boolean neoCountDownNeedSwipeTrigger;
        public int neoCountDownTime;
        public boolean noActionStopCountDown;
        public int noActionTime;
    }

    public boolean isNeoScan() {
        return this.neoPageType == 1;
    }
}
