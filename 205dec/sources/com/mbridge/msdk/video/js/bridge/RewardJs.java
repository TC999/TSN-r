package com.mbridge.msdk.video.js.bridge;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.ac;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RewardJs extends BaseRewardJs implements IRewardBridge {

    /* renamed from: b  reason: collision with root package name */
    private Handler f40891b = new Handler(Looper.getMainLooper());

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void cai(final Object obj, final String str) {
        if (ac.b()) {
            super.cai(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.10
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.cai(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void getEndScreenInfo(final Object obj, final String str) {
        if (ac.b()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.1
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void gial(final Object obj, final String str) {
        if (ac.b()) {
            super.gial(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.2
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.gial(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void handlerPlayableException(final Object obj, final String str) {
        if (ac.b()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.8
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.handlerPlayableException(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void install(final Object obj, final String str) {
        if (ac.b()) {
            super.install(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.3
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.install(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void notifyCloseBtn(final Object obj, final String str) {
        if (ac.b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.4
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void openURL(final Object obj, final String str) {
        if (ac.b()) {
            super.openURL(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.9
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.openURL(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void setOrientation(final Object obj, final String str) {
        if (ac.b()) {
            super.setOrientation(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.7
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.setOrientation(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void toggleCloseBtn(final Object obj, final String str) {
        if (ac.b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.5
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.BaseRewardJs, com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void triggerCloseBtn(final Object obj, final String str) {
        if (ac.b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.f40891b.post(new Runnable() { // from class: com.mbridge.msdk.video.js.bridge.RewardJs.6
                @Override // java.lang.Runnable
                public final void run() {
                    RewardJs.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }
}
