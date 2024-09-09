package tv.danmaku.ijk.media.player.misc;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public interface ITrackInfo {
    public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int MEDIA_TRACK_TYPE_METADATA = 5;
    public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
    public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
    public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TRACK_TYPE_VIDEO = 1;

    IMediaFormat getFormat();

    String getInfoInline();

    String getLanguage();

    int getTrackType();
}
