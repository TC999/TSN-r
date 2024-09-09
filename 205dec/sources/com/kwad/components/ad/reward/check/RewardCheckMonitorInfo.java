package com.kwad.components.ad.reward.check;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RewardCheckMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int CHECK_TYPE_EXPOSURE = 1;
    public static final int CHECK_TYPE_REWARD = 2;
    public static final int ENVI_TYPE_NATIVE = 0;
    public static final int ENVI_TYPE_TK = 1;
    public static final int REQUEST_STATE_END = 2;
    public static final int REQUEST_STATE_START = 1;
    public static final long serialVersionUID = 1080394611500009098L;
    public int checkType;
    public int code;
    public long creativeId;
    public long dataLoadInterval;
    public int enviType;
    public long posId;
    public int requestStatus;

    public RewardCheckMonitorInfo setCheckType(int i4) {
        this.checkType = i4;
        return this;
    }

    public RewardCheckMonitorInfo setCode(int i4) {
        this.code = i4;
        return this;
    }

    public RewardCheckMonitorInfo setCreativeId(long j4) {
        this.creativeId = j4;
        return this;
    }

    public RewardCheckMonitorInfo setDataLoadInterval(long j4) {
        this.dataLoadInterval = j4;
        return this;
    }

    public RewardCheckMonitorInfo setEnviType(int i4) {
        this.enviType = i4;
        return this;
    }

    public RewardCheckMonitorInfo setRequestStatus(int i4) {
        this.requestStatus = i4;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardCheckMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
