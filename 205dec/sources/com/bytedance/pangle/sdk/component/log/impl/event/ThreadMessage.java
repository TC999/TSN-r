package com.bytedance.pangle.sdk.component.log.impl.event;

import com.bytedance.pangle.sdk.component.log.impl.event.ad.IAdEvent;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ThreadMessage implements AdLogEventFace {
    public static final int MESSAGE_FLUSH_MEMORY = 3;
    public static final int MESSAGE_FLUSH_MEMORY_DB = 2;
    public static final int MESSAGE_NEW_EVENT = 4;
    public static final int MESSAGE_QUIT = 6;
    public static final int MESSAGE_ROUTINE_BATCH_ONCE = 1;
    public static final int MESSAGE_SERVER_BUSY_NEW_EVENT = 5;
    public static final int MESSAGE_SERVER_ROUTINE_ERROR_NEW_EVENT = 7;
    private int Message;
    private byte type;

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public byte getAdType() {
        return this.type;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public long getCreateTime() {
        return 0L;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public IAdEvent getDelayAdEvent() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public JSONObject getEvent() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public byte getEventVersion() {
        return (byte) 0;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public String getLocalId() {
        return null;
    }

    public int getMessage() {
        return this.Message;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public byte getPriority() {
        return (byte) 0;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public long getSaveTime() {
        return 0L;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public long getUploadTime() {
        return 0L;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setAdType(byte b4) {
        this.type = b4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setCreateTime(long j4) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setEvent(JSONObject jSONObject) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setEventVersion(byte b4) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setGenTime(String str) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setLocalId(String str) {
    }

    public void setMessage(int i4) {
        this.Message = i4;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setPriority(byte b4) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setSaveTime(long j4) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public void setUploadTime(long j4) {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace
    public String toJsonString() {
        return null;
    }
}
