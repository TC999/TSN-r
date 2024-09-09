package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LoaderEventInfo {
    public int what = -1;
    public String fileHash = null;
    public HashMap<String, String> mHeaders = new HashMap<>();
    public int taskType = -1;
    public int dataType = -1;
    public long bytesLoaded = -1;
    public long bitrate = -1;
    public long elapsedRealtimeMs = -1;
    public long loadDurationMs = -1;
    public long off = -1;
    public long endOff = -1;
}
