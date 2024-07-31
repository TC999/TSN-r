package com.mbridge.msdk.video.p511js.bridge;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.SameTool;

/* renamed from: com.mbridge.msdk.video.js.bridge.RewardJs */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RewardJs extends BaseRewardJs implements IRewardBridge {

    /* renamed from: b */
    private Handler f32144b = new Handler(Looper.getMainLooper());

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void cai(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.cai(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.10
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.cai(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void getEndScreenInfo(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.1
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void gial(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.gial(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.2
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.gial(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void handlerPlayableException(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.8
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.handlerPlayableException(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void install(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.install(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.3
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.install(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void notifyCloseBtn(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.4
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void openURL(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.openURL(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.9
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.openURL(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void setOrientation(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.setOrientation(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.7
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.setOrientation(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void toggleCloseBtn(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.5
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.BaseRewardJs, com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void triggerCloseBtn(final Object obj, final String str) {
        if (SameTool.m22004b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.f32144b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.6
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }
}
