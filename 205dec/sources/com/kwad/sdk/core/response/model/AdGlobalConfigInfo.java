package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdGlobalConfigInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -2622260965144406821L;
    @Nullable
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public int neoPageType;
    public NeoScanAggregationSceneInfo neoScanAggregationSceneInfo;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class NeoScanAggregationSceneInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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
