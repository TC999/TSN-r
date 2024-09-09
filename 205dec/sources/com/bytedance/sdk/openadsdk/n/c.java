package com.bytedance.sdk.openadsdk.n;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private AudioAttributes f36240c;
    private AudioManager.OnAudioFocusChangeListener sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private AudioFocusRequest f36241w;
    private AudioManager xv;

    public c() {
        this.ux = false;
        boolean s3 = ls.w().s();
        this.ux = s3;
        if (s3) {
            this.sr = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.n.c.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i4) {
                    a.c("xaudf:" + i4);
                }
            };
            this.xv = (AudioManager) ls.getContext().getSystemService("audio");
        }
    }

    public int c() {
        if (this.ux) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                this.f36240c = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
            }
            if (i4 >= 26) {
                AudioFocusRequest build = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.sr).setAudioAttributes(this.f36240c).build();
                this.f36241w = build;
                AudioManager audioManager = this.xv;
                if (audioManager != null) {
                    return audioManager.requestAudioFocus(build);
                }
                return -1;
            }
            AudioManager audioManager2 = this.xv;
            if (audioManager2 != null) {
                return audioManager2.requestAudioFocus(this.sr, 3, 2);
            }
            return -1;
        }
        return -1;
    }

    public void w() {
        if (this.ux) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioManager audioManager = this.xv;
                if (audioManager != null) {
                    audioManager.abandonAudioFocusRequest(this.f36241w);
                    return;
                }
                return;
            }
            AudioManager audioManager2 = this.xv;
            if (audioManager2 != null) {
                audioManager2.abandonAudioFocus(this.sr);
            }
        }
    }
}
