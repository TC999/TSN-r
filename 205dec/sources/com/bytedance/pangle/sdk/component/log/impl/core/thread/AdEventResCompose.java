package com.bytedance.pangle.sdk.component.log.impl.core.thread;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdEventResCompose {
    private final List<AdLogEventFace> faceList;
    private final AdEventUploadResult result;

    public AdEventResCompose(AdEventUploadResult adEventUploadResult, List<AdLogEventFace> list) {
        this.result = adEventUploadResult;
        this.faceList = list;
    }

    public List<AdLogEventFace> getFaceList() {
        return this.faceList;
    }

    public AdEventUploadResult getResult() {
        return this.result;
    }
}
