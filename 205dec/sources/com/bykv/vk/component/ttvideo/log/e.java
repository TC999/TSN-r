package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum e {
    instance;
    

    /* renamed from: a  reason: collision with root package name */
    private VideoEventEngineUploader f24888a;

    /* renamed from: b  reason: collision with root package name */
    private Context f24889b;

    private void a(JSONObject jSONObject) {
        String[] split;
        if (((TTVideoEngineLog.LogNotifyLevel >> 2) & 1) == 1 || ((TTVideoEngineLog.LogTurnOn >> 2) & 1) == 1) {
            TTVideoEngineLog.i("VideoEventManager", jSONObject.toString());
        }
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.f24889b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        TTVideoEngineLog.i("VideoEventManager", str + ":" + jSONObject.opt(str));
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.f24889b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.f24888a = videoEventEngineUploader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z3, JSONObject jSONObject) {
        synchronized (e.class) {
            if (jSONObject == null) {
                return;
            }
            a(jSONObject);
            VideoEventEngineUploader videoEventEngineUploader = this.f24888a;
            if (videoEventEngineUploader != null) {
                videoEventEngineUploader.onEvent("video_playq", jSONObject);
            }
        }
    }
}
