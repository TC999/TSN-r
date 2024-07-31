package com.baidu.idl.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
    public static void play(Context context, int i) {
        if (sSoundPlayer == null) {
            sSoundPlayer = new SoundPlayer();
        }
        int i2 = sSoundPlayer.mSoundPoolCache.get(i);
        if (i2 != 0) {
            try {
                sSoundPlayer.mSoundPool.play(i2, 1.0f, 1.0f, 5, 0, 1.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (context == null) {
        } else {
            final int load = sSoundPlayer.mSoundPool.load(context, i, 1);
            sSoundPlayer.mSoundPoolCache.put(i, load);
            if (APIUtils.hasFroyo()) {
                sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.baidu.idl.face.platform.utils.SoundPlayer.1
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public void onLoadComplete(SoundPool soundPool, int i3, int i4) {
                        if (i4 == 0 && load == i3) {
                            try {
                                SoundPlayer.playTime = System.currentTimeMillis();
                                SoundPlayer.sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            try {
                Thread.currentThread().join(100L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            playTime = System.currentTimeMillis();
            sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
        }
    }

    public static void release() {
        SoundPlayer soundPlayer = sSoundPlayer;
        if (soundPlayer != null) {
            int size = soundPlayer.mSoundPoolCache.size();
            for (int i = 0; i < size; i++) {
                SoundPlayer soundPlayer2 = sSoundPlayer;
                soundPlayer2.mSoundPool.unload(soundPlayer2.mSoundPoolCache.valueAt(i));
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
