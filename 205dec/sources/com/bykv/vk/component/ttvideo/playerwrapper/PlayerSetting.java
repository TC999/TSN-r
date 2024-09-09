package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.media.AudioManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class PlayerSetting {
    private final Context mContext;
    private float mCurrentPlayerVolume = 1.0f;
    private float mLastVolume;
    private MediaPlayer mPlayer;

    public PlayerSetting(Context context, MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
        this.mContext = context;
    }

    public float getMaxVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : 0;
        return streamMaxVolume >= 0 ? streamMaxVolume : 0;
    }

    public float getPlayerVolume() {
        return this.mCurrentPlayerVolume;
    }

    public float getVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamVolume = audioManager != null ? audioManager.getStreamVolume(3) : 0;
        return streamVolume >= 0 ? streamVolume : 0;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isOSPlayer() ? getVolume() < 0.001f : this.mPlayer.isMute();
    }

    public void setMute(boolean z3) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (mediaPlayer.isOSPlayer()) {
            float maxVolume = getMaxVolume();
            if (maxVolume > 0.0f) {
                this.mLastVolume = getVolume() / maxVolume;
            }
            if (z3) {
                this.mPlayer.setVolume(0.0f, 0.0f);
                return;
            }
            MediaPlayer mediaPlayer2 = this.mPlayer;
            float f4 = this.mLastVolume;
            mediaPlayer2.setVolume(f4, f4);
            return;
        }
        this.mPlayer.setIsMute(z3);
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void setPlayerVolume(float f4) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.mCurrentPlayerVolume = f4;
        mediaPlayer.setVolume(f4, f4);
    }

    public void setVolume(float f4) {
        AudioManager audioManager;
        if (this.mPlayer == null || (audioManager = (AudioManager) this.mContext.getSystemService("audio")) == null) {
            return;
        }
        audioManager.setStreamVolume(3, (int) f4, 0);
    }
}
