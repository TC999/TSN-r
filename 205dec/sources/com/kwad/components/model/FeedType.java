package com.kwad.components.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7),
    FEED_TYPE_CONTENT_11(11),
    FEED_TYPE_CONTENT_12(12),
    FEED_TYPE_CONTENT_13(13);
    
    private int type;

    FeedType(int i4) {
        this.type = i4;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int be = a.be(e.dQ(adTemplate));
        int i4 = adTemplate.type;
        FeedType feedType = FEED_TYPE_TEXT_ABOVE_GROUP;
        if (i4 > feedType.type) {
            return true;
        }
        FeedType fromInt = fromInt(i4);
        if (be != 1) {
            if (be == 2) {
                return (fromInt == FEED_TYPE_UNKNOWN || fromInt == feedType) ? false : true;
            } else if (be == 3) {
                return fromInt != FEED_TYPE_UNKNOWN;
            } else if (be != 8) {
                return false;
            }
        }
        return fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW || fromInt == FEED_TYPE_TEXT_IMMERSE;
    }

    @NonNull
    public static FeedType fromInt(int i4) {
        FeedType[] values;
        for (FeedType feedType : values()) {
            if (feedType.type == i4) {
                return feedType;
            }
        }
        if (isH5Type(i4)) {
            return FEED_TYPE_TEXT_NEW;
        }
        return FEED_TYPE_UNKNOWN;
    }

    private static boolean isH5Type(int i4) {
        return i4 == 7 || i4 == 8 || i4 == 14 || i4 == 15 || i4 == 16 || i4 == 17 || i4 == 18 || i4 == 19 || i4 >= 2000;
    }

    public final int getType() {
        return this.type;
    }
}
