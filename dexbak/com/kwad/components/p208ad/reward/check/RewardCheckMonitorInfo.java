package com.kwad.components.p208ad.reward.check;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.io.Serializable;

@KsJson
/* renamed from: com.kwad.components.ad.reward.check.RewardCheckMonitorInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RewardCheckMonitorInfo extends AbstractC9822a implements Serializable {
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

    public RewardCheckMonitorInfo setCheckType(int i) {
        this.checkType = i;
        return this;
    }

    public RewardCheckMonitorInfo setCode(int i) {
        this.code = i;
        return this;
    }

    public RewardCheckMonitorInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public RewardCheckMonitorInfo setDataLoadInterval(long j) {
        this.dataLoadInterval = j;
        return this;
    }

    public RewardCheckMonitorInfo setEnviType(int i) {
        this.enviType = i;
        return this;
    }

    public RewardCheckMonitorInfo setRequestStatus(int i) {
        this.requestStatus = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public RewardCheckMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
