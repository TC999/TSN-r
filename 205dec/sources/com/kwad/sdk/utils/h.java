package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    private AudioManager aBv;
    private AudioManager.OnAudioFocusChangeListener aOx = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i4) {
            if (h.this.hq == null) {
                return;
            }
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i4 < 0) {
                        h.this.hq.onAudioBeOccupied();
                    } else {
                        h.this.hq.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a hq;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.aBv = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest Lf() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.aOx).build();
    }

    public final boolean Le() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aOx;
        if (onAudioFocusChangeListener != null && (audioManager = this.aBv) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(Lf());
            } else if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(a aVar) {
        this.hq = aVar;
    }
}
