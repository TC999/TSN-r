package com.baidu.idl.face.platform.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.utils.SoundPlayer;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SoundPoolHelper {
    private static final String TAG = "SoundPoolHelper";
    private Context mContext;
    private FaceStatusNewEnum mPlaySoundStatusNewEnum;
    private volatile long mPlayDuration = 0;
    private volatile long mPlayTime = 0;
    private volatile boolean mIsPlaying = false;
    private volatile boolean mIsEnableSound = true;
    private HashMap<Integer, Long> mPlayDurationMap = new HashMap<>();

    public SoundPoolHelper(Context context) {
        this.mContext = context;
    }

    private long getSoundDuration(int i) {
        long j;
        if (this.mPlayDurationMap.containsKey(Integer.valueOf(i))) {
            return this.mPlayDurationMap.get(Integer.valueOf(i)).longValue();
        }
        System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            j = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
        } catch (IllegalArgumentException e) {
            e = e;
            j = 600;
        } catch (IllegalStateException e2) {
            e = e2;
            j = 600;
        } catch (Exception e3) {
            e = e3;
            j = 600;
        }
        try {
            this.mPlayDurationMap.put(Integer.valueOf(i), Long.valueOf(j));
            return j;
        } catch (IllegalArgumentException e4) {
            e = e4;
            e.printStackTrace();
            return j;
        } catch (IllegalStateException e5) {
            e = e5;
            e.printStackTrace();
            return j;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return j;
        }
    }

    public boolean getEnableSound() {
        return this.mIsEnableSound;
    }

    public long getPlayDuration() {
        return this.mPlayDuration;
    }

    public boolean playSound(FaceStatusNewEnum faceStatusNewEnum) {
        if (!this.mIsEnableSound) {
            SoundPlayer.release();
        }
        if (this.mContext == null) {
            SoundPlayer.release();
        }
        this.mIsPlaying = System.currentTimeMillis() - SoundPlayer.playTime < this.mPlayDuration;
        if (this.mIsPlaying || (this.mPlaySoundStatusNewEnum == faceStatusNewEnum && System.currentTimeMillis() - this.mPlayTime < FaceEnvironment.TIME_TIPS_REPEAT)) {
            return false;
        }
        this.mIsPlaying = true;
        this.mPlaySoundStatusNewEnum = faceStatusNewEnum;
        this.mPlayDuration = 0L;
        this.mPlayTime = System.currentTimeMillis();
        int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
        if (soundId > 0) {
            this.mPlayDuration = getSoundDuration(soundId);
            SoundPlayer.playTime = System.currentTimeMillis();
            if (this.mIsEnableSound) {
                SoundPlayer.play(this.mContext, soundId);
            }
        }
        return this.mIsPlaying;
    }

    public void release() {
        SoundPlayer.release();
        this.mPlayDuration = 0L;
        this.mPlayTime = 0L;
        this.mContext = null;
    }

    public void setEnableSound(boolean z) {
        this.mIsEnableSound = z;
    }
}
