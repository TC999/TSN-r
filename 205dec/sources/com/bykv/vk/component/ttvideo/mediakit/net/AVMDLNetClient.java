package com.bykv.vk.component.ttvideo.mediakit.net;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class AVMDLNetClient {
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface CompletionListener {
        void onCompletion(JSONObject jSONObject, Error error);
    }

    public void cancel() {
    }

    public void startTask(String str, CompletionListener completionListener) {
    }

    public void startTask(String str, Map<String, String> map, CompletionListener completionListener) {
    }

    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i4, CompletionListener completionListener) {
    }
}
