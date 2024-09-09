package com.bytedance.pangle.sdk.component.log.impl.event;

import com.bytedance.pangle.sdk.component.log.impl.event.ad.IAdEvent;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface AdLogEventFace {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface AdType {
        public static final byte TYPE_AD_EVENT = 0;
        public static final byte TYPE_AD_V3_EVENT = 3;
        public static final byte TYPE_OTHER_EVENT = 2;
        public static final byte TYPE_STATS_EVENT = 1;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface Priority {
        public static final byte PRIORITY_HIGH = 1;
        public static final byte PRIORITY_IMMEDIATE = 0;
        public static final byte PRIORITY_LESS_NORMAL = 3;
        public static final byte PRIORITY_LOW = 4;
        public static final byte PRIORITY_NORMAL = 2;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface VERSION {
        public static final byte V1 = 0;
        public static final byte V3 = 3;
    }

    byte getAdType();

    long getCreateTime();

    IAdEvent getDelayAdEvent();

    JSONObject getEvent();

    byte getEventVersion();

    String getLocalId();

    byte getPriority();

    long getSaveTime();

    long getUploadTime();

    void setAdType(byte b4);

    void setCreateTime(long j4);

    void setEvent(JSONObject jSONObject);

    void setEventVersion(byte b4);

    void setGenTime(String str);

    void setLocalId(String str);

    void setPriority(byte b4);

    void setSaveTime(long j4);

    void setUploadTime(long j4);

    String toJsonString();
}
