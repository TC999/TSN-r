package com.bykv.vk.component.ttvideo.player;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface FrameMetadataListener {
    void frameDTSNotify(int i4, long j4, long j5);

    void onFrameAboutToBeRendered(int i4, long j4, long j5, Map<Integer, String> map);

    void updateFrameTerminatedDTS(int i4, long j4, long j5);
}
