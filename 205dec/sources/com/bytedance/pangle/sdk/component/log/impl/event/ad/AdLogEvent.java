package com.bytedance.pangle.sdk.component.log.impl.event.ad;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdLogEvent implements AdLogEventFace {
    protected JSONObject event;
    private byte eventVersion;
    private String localId;
    private long mCreateTime;
    private IAdEvent mDelayAdEvent;
    private String mGenTime;
    private byte mPriority;
    private long mSaveTime;
    private long mUploadTime;
    private String moveLables;
    private byte type;

    public AdLogEvent(String str, JSONObject jSONObject) {
        this.localId = str;
        this.event = jSONObject;
    }

    public static AdLogEventFace toEventObj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("priority");
            AdLogEvent adLogEvent = new AdLogEvent();
            adLogEvent.setAdType((byte) optInt);
            adLogEvent.setPriority((byte) optInt2);
            adLogEvent.setEvent(jSONObject.optJSONObject("event"));
            adLogEvent.setLocalId(jSONObject.optString("localId"));
            adLogEvent.setGenTime(jSONObject.optString("genTime"));
            return adLogEvent;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public byte getAdType() {
        return this.type;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public long getCreateTime() {
        return this.mCreateTime;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public IAdEvent getDelayAdEvent() {
        return this.mDelayAdEvent;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public synchronized JSONObject getEvent() {
        IAdEvent iAdEvent;
        if (this.event == null && (iAdEvent = this.mDelayAdEvent) != null) {
            this.event = iAdEvent.getDelayEvent(getMoveLables());
        }
        return this.event;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public byte getEventVersion() {
        return this.eventVersion;
    }

    public String getGenTime() {
        return this.mGenTime;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public String getLocalId() {
        return this.localId;
    }

    public String getMoveLables() {
        return this.moveLables;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public byte getPriority() {
        return this.mPriority;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public long getSaveTime() {
        return this.mSaveTime;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public long getUploadTime() {
        return this.mUploadTime;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setAdType(byte b4) {
        this.type = b4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setCreateTime(long j4) {
        this.mCreateTime = j4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setEvent(JSONObject jSONObject) {
        this.event = jSONObject;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setEventVersion(byte b4) {
        this.eventVersion = b4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setGenTime(String str) {
        this.mGenTime = str;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setLocalId(String str) {
        this.localId = str;
    }

    public void setMoveLables(String str) {
        this.moveLables = str;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setPriority(byte b4) {
        this.mPriority = b4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setSaveTime(long j4) {
        this.mSaveTime = j4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setUploadTime(long j4) {
        this.mUploadTime = j4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public String toJsonString() {
        if (TextUtils.isEmpty(this.localId)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.localId);
            jSONObject.put("event", getEvent());
            jSONObject.put("genTime", getGenTime());
            jSONObject.put("priority", (int) this.mPriority);
            jSONObject.put("type", (int) this.type);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public AdLogEvent(String str, IAdEvent iAdEvent) {
        this.localId = str;
        this.mDelayAdEvent = iAdEvent;
    }

    private AdLogEvent() {
    }
}
