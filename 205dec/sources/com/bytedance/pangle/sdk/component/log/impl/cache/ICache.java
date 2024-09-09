package com.bytedance.pangle.sdk.component.log.impl.cache;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ICache {
    void add(AdLogEventFace adLogEventFace, int i4);

    boolean checkNeedUpload(int i4, boolean z3);

    List<AdLogEventFace> get(int i4, int i5);

    void handleResult(int i4, List<AdLogEventFace> list);

    String printBatchEvent();

    String printHighEvent();

    String printRealAdEvent();

    String printRealStatsEvent();
}
