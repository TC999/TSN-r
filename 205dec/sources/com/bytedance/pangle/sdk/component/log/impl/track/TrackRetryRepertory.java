package com.bytedance.pangle.sdk.component.log.impl.track;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface TrackRetryRepertory {
    void delete(TrackInfo trackInfo);

    void insert(TrackInfo trackInfo);

    List<TrackInfo> queryAll();

    void update(TrackInfo trackInfo);
}
