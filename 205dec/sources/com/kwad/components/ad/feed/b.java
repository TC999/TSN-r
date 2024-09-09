package com.kwad.components.ad.feed;

import android.content.Context;
import com.kwad.components.ad.feed.b.g;
import com.kwad.components.ad.feed.b.h;
import com.kwad.components.ad.feed.b.i;
import com.kwad.components.ad.feed.b.j;
import com.kwad.components.ad.feed.b.k;
import com.kwad.components.ad.feed.b.l;
import com.kwad.components.model.FeedType;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.feed.b$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] dP;

        static {
            int[] iArr = new int[FeedType.values().length];
            dP = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                dP[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                dP[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                dP[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                dP[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                dP[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                dP[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType, int i4) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            if (i4 != 1 && i4 != 8) {
                return new com.kwad.components.ad.feed.b.f(context);
            }
            return new g(context);
        }
        if (i4 != 1) {
            if (i4 == 2) {
                return a(context, feedType);
            }
            if (i4 == 3) {
                return b(context, feedType);
            }
            if (i4 != 8) {
                com.kwad.sdk.core.e.c.e("KSFeedFactory", "getNewFeedView materialType is unknown");
                return null;
            }
        }
        return c(context, feedType);
    }

    private static com.kwad.components.core.widget.b b(Context context, FeedType feedType) {
        switch (AnonymousClass1.dP[feedType.ordinal()]) {
            case 1:
                return new j(context);
            case 2:
                return new com.kwad.components.ad.feed.b.f(context);
            case 3:
                return new h(context);
            case 4:
                return new k(context);
            case 5:
                return new l(context);
            case 6:
                return new h(context);
            case 7:
                com.kwad.sdk.core.e.c.e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                return null;
            default:
                return null;
        }
    }

    private static com.kwad.components.core.widget.b c(Context context, FeedType feedType) {
        int i4 = AnonymousClass1.dP[feedType.ordinal()];
        if (i4 == 1 || i4 == 2) {
            return new g(context);
        }
        if (i4 != 3) {
            com.kwad.sdk.core.e.c.e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
            return null;
        }
        return new i(context);
    }

    private static com.kwad.components.core.widget.b a(Context context, FeedType feedType) {
        switch (AnonymousClass1.dP[feedType.ordinal()]) {
            case 1:
                return new j(context);
            case 2:
                return new com.kwad.components.ad.feed.b.f(context);
            case 3:
                return new h(context);
            case 4:
                return new k(context);
            case 5:
                return new l(context);
            case 6:
            case 7:
                com.kwad.sdk.core.e.c.e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                return null;
            default:
                return null;
        }
    }
}
