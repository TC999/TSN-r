package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

@Keep
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface ILiveListener {

    @Keep
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class Stub implements ILiveListener {
        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i4) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z3) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i4, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i4) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i4, int i5) {
        }
    }

    void onAbrSwitch(String str);

    void onAudioRenderStall(int i4);

    void onCacheFileCompletion();

    void onCompletion();

    void onError(LiveError liveError);

    void onFirstFrame(boolean z3);

    void onMonitorLog(JSONObject jSONObject, String str);

    void onPrepared();

    void onReportALog(int i4, String str);

    void onResolutionDegrade(String str);

    void onSeiUpdate(String str);

    void onStallEnd();

    void onStallStart();

    void onVideoRenderStall(int i4);

    void onVideoSizeChanged(int i4, int i5);
}
