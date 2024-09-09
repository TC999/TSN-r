package com.umeng.socialize.media;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface UMediaObject {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum MediaType {
        IMAGE { // from class: com.umeng.socialize.media.UMediaObject.MediaType.1
            @Override // java.lang.Enum
            public String toString() {
                return "0";
            }
        },
        VEDIO { // from class: com.umeng.socialize.media.UMediaObject.MediaType.2
            @Override // java.lang.Enum
            public String toString() {
                return "1";
            }
        },
        MUSIC { // from class: com.umeng.socialize.media.UMediaObject.MediaType.3
            @Override // java.lang.Enum
            public String toString() {
                return "2";
            }
        },
        TEXT { // from class: com.umeng.socialize.media.UMediaObject.MediaType.4
            @Override // java.lang.Enum
            public String toString() {
                return "3";
            }
        },
        TEXT_IMAGE { // from class: com.umeng.socialize.media.UMediaObject.MediaType.5
            @Override // java.lang.Enum
            public String toString() {
                return "4";
            }
        },
        WEBPAGE { // from class: com.umeng.socialize.media.UMediaObject.MediaType.6
            @Override // java.lang.Enum
            public String toString() {
                return "5";
            }
        }
    }

    MediaType getMediaType();

    boolean isUrlMedia();

    byte[] toByte();

    String toUrl();

    Map<String, Object> toUrlExtraParams();
}
