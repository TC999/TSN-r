package com.bykv.vk.component.ttvideo.player;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class MediaFormat {
    public static final String KEY_AUDIO = "audio";
    public static final String KEY_BIT_RATE = "bitrate";
    public static final String KEY_CHANNEL_COUNT = "channel-count";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_SAMPLE_RATE = "sample-rate";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_TRACK_ID = "track-id";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_WIDTH = "width";
    private Map<String, Object> mMap;

    public MediaFormat() {
        this.mMap = new HashMap();
    }

    public static final MediaFormat createAudioFormat(int i4, int i5, int i6) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(KEY_TRACK_ID, i4);
        mediaFormat.setInteger(KEY_SAMPLE_RATE, i5);
        mediaFormat.setInteger(KEY_CHANNEL_COUNT, i6);
        return mediaFormat;
    }

    public static final MediaFormat createSubtitleFormat(int i4, String str) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(KEY_TRACK_ID, i4);
        mediaFormat.setString("language", str);
        return mediaFormat;
    }

    public static final MediaFormat createVideoFormat(int i4, int i5, int i6, int i7) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(KEY_TRACK_ID, i4);
        mediaFormat.setInteger("width", i5);
        mediaFormat.setInteger("height", i6);
        mediaFormat.setInteger("bitrate", i7);
        return mediaFormat;
    }

    public final float getFloat(String str) {
        return ((Float) this.mMap.get(str)).floatValue();
    }

    public final int getInteger(String str) {
        return ((Integer) this.mMap.get(str)).intValue();
    }

    public final long getLong(String str) {
        return ((Long) this.mMap.get(str)).longValue();
    }

    public final String getString(String str) {
        return (String) this.mMap.get(str);
    }

    public Map<String, Object> getValues() {
        return this.mMap;
    }

    public final void setFloat(String str, float f4) {
        this.mMap.put(str, Float.valueOf(f4));
    }

    public final void setInteger(String str, int i4) {
        this.mMap.put(str, Integer.valueOf(i4));
    }

    public final void setLong(String str, long j4) {
        this.mMap.put(str, Long.valueOf(j4));
    }

    public final void setString(String str, String str2) {
        this.mMap.put(str, str2);
    }

    public String toString() {
        return this.mMap.toString();
    }

    public MediaFormat(Map<String, Object> map) {
        this.mMap = map;
    }

    public static final MediaFormat createSubtitleFormat(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return createSubtitleFormat(jSONObject.optInt(KEY_TRACK_ID), jSONObject.optString("language"));
    }

    public static final MediaFormat createAudioFormat(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return createAudioFormat(jSONObject.optInt(KEY_TRACK_ID), jSONObject.optInt(KEY_SAMPLE_RATE), jSONObject.optInt(KEY_CHANNEL_COUNT));
    }

    public static final MediaFormat createVideoFormat(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return createVideoFormat(jSONObject.optInt(KEY_TRACK_ID), jSONObject.optInt("width"), jSONObject.optInt("height"), jSONObject.optInt("bitrate"));
    }

    public static final MediaFormat createSubtitleFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return null;
        }
        return createSubtitleFormat(mediaFormat.getInteger(KEY_TRACK_ID), mediaFormat.getString("language"));
    }

    public static final MediaFormat createAudioFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return null;
        }
        return createAudioFormat(mediaFormat.getInteger(KEY_TRACK_ID), mediaFormat.getInteger(KEY_SAMPLE_RATE), mediaFormat.getInteger(KEY_CHANNEL_COUNT));
    }

    public static final MediaFormat createVideoFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return null;
        }
        return createVideoFormat(mediaFormat.getInteger(KEY_TRACK_ID), mediaFormat.getInteger("width"), mediaFormat.getInteger("height"), mediaFormat.getInteger("bitrate"));
    }
}
