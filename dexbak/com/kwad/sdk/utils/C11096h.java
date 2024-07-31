package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* renamed from: com.kwad.sdk.utils.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11096h {
    private AudioManager aBv;
    private AudioManager.OnAudioFocusChangeListener aOx = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (C11096h.this.f29683hq == null) {
                return;
            }
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        C11096h.this.f29683hq.onAudioBeOccupied();
                    } else {
                        C11096h.this.f29683hq.onAudioBeReleased();
                    }
                }
            });
        }
    };

    /* renamed from: hq */
    private InterfaceC11099a f29683hq;

    /* renamed from: com.kwad.sdk.utils.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11099a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public C11096h(Context context) {
        this.aBv = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    /* renamed from: Lf */
    private AudioFocusRequest m23790Lf() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.aOx).build();
    }

    /* renamed from: Le */
    public final boolean m23791Le() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aOx;
        if (onAudioFocusChangeListener != null && (audioManager = this.aBv) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(m23790Lf());
            } else if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final void m23788c(InterfaceC11099a interfaceC11099a) {
        this.f29683hq = interfaceC11099a;
    }
}
