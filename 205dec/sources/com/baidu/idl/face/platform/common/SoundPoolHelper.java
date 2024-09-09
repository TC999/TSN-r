package com.baidu.idl.face.platform.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.utils.SoundPlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    private long getSoundDuration(int i4) {
        long j4;
        if (this.mPlayDurationMap.containsKey(Integer.valueOf(i4))) {
            return this.mPlayDurationMap.get(Integer.valueOf(i4)).longValue();
        }
        System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + TTPathConst.sSeparator + i4));
            j4 = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
        } catch (IllegalArgumentException e4) {
            e = e4;
            j4 = 600;
        } catch (IllegalStateException e5) {
            e = e5;
            j4 = 600;
        } catch (Exception e6) {
            e = e6;
            j4 = 600;
        }
        try {
            this.mPlayDurationMap.put(Integer.valueOf(i4), Long.valueOf(j4));
            return j4;
        } catch (IllegalArgumentException e7) {
            e = e7;
            e.printStackTrace();
            return j4;
        } catch (IllegalStateException e8) {
            e = e8;
            e.printStackTrace();
            return j4;
        } catch (Exception e9) {
            e = e9;
            e.printStackTrace();
            return j4;
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

    public void setEnableSound(boolean z3) {
        this.mIsEnableSound = z3;
    }
}
