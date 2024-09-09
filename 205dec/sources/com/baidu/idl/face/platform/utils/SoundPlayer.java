package com.baidu.idl.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class SoundPlayer {
    private static final boolean DEBUG = false;
    private static final long LOAD_SOUND_MILLIS = 100;
    public static final int MAX_STREAMS = 5;
    private static final String TAG = "SoundPlayer";
    public static long playTime;
    private static SoundPlayer sSoundPlayer;
    private SoundPool mSoundPool = new SoundPool(5, 3, 0);
    private SparseIntArray mSoundPoolCache = new SparseIntArray();

    private SoundPlayer() {
        playTime = 0L;
    }

    @SuppressLint({"NewApi"})
    public static void play(Context context, int i4) {
        if (sSoundPlayer == null) {
            sSoundPlayer = new SoundPlayer();
        }
        int i5 = sSoundPlayer.mSoundPoolCache.get(i4);
        if (i5 != 0) {
            try {
                sSoundPlayer.mSoundPool.play(i5, 1.0f, 1.0f, 5, 0, 1.0f);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else if (context == null) {
        } else {
            final int load = sSoundPlayer.mSoundPool.load(context, i4, 1);
            sSoundPlayer.mSoundPoolCache.put(i4, load);
            if (APIUtils.hasFroyo()) {
                sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.baidu.idl.face.platform.utils.SoundPlayer.1
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public void onLoadComplete(SoundPool soundPool, int i6, int i7) {
                        if (i7 == 0 && load == i6) {
                            try {
                                SoundPlayer.playTime = System.currentTimeMillis();
                                SoundPlayer.sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            try {
                Thread.currentThread().join(100L);
            } catch (InterruptedException e5) {
                e5.printStackTrace();
            }
            playTime = System.currentTimeMillis();
            sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
        }
    }

    public static void release() {
        SoundPlayer soundPlayer = sSoundPlayer;
        if (soundPlayer != null) {
            int size = soundPlayer.mSoundPoolCache.size();
            for (int i4 = 0; i4 < size; i4++) {
                SoundPlayer soundPlayer2 = sSoundPlayer;
                soundPlayer2.mSoundPool.unload(soundPlayer2.mSoundPoolCache.valueAt(i4));
            }
            sSoundPlayer.mSoundPool.release();
            SoundPlayer soundPlayer3 = sSoundPlayer;
            soundPlayer3.mSoundPool = null;
            soundPlayer3.mSoundPoolCache.clear();
            sSoundPlayer.mSoundPoolCache = null;
            sSoundPlayer = null;
        }
        playTime = 0L;
    }
}
