package com.kwad.components.p208ad.feed;

import android.content.Context;
import com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b;
import com.kwad.components.model.FeedType;
import com.kwad.components.p208ad.feed.p226b.C7527g;
import com.kwad.components.p208ad.feed.p226b.C7529i;
import com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7526f;
import com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7528h;
import com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7530j;
import com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7531k;
import com.kwad.components.p208ad.feed.p226b.View$OnClickListenerC7533l;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.components.ad.feed.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7499b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.feed.b$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static /* synthetic */ class C75001 {

        /* renamed from: dP */
        static final /* synthetic */ int[] f25594dP;

        static {
            int[] iArr = new int[FeedType.values().length];
            f25594dP = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25594dP[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25594dP[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25594dP[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25594dP[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25594dP[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25594dP[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: a */
    public static AbstractDialogInterface$OnDismissListenerC9367b m33145a(Context context, FeedType feedType, int i) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            if (i != 1 && i != 8) {
                return new View$OnClickListenerC7526f(context);
            }
            return new C7527g(context);
        }
        if (i != 1) {
            if (i == 2) {
                return m33146a(context, feedType);
            }
            if (i == 3) {
                return m33144b(context, feedType);
            }
            if (i != 8) {
                C10331c.m26250e("KSFeedFactory", "getNewFeedView materialType is unknown");
                return null;
            }
        }
        return m33143c(context, feedType);
    }

    /* renamed from: b */
    private static AbstractDialogInterface$OnDismissListenerC9367b m33144b(Context context, FeedType feedType) {
        switch (C75001.f25594dP[feedType.ordinal()]) {
            case 1:
                return new View$OnClickListenerC7530j(context);
            case 2:
                return new View$OnClickListenerC7526f(context);
            case 3:
                return new View$OnClickListenerC7528h(context);
            case 4:
                return new View$OnClickListenerC7531k(context);
            case 5:
                return new View$OnClickListenerC7533l(context);
            case 6:
                return new View$OnClickListenerC7528h(context);
            case 7:
                C10331c.m26250e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                return null;
            default:
                return null;
        }
    }

    /* renamed from: c */
    private static AbstractDialogInterface$OnDismissListenerC9367b m33143c(Context context, FeedType feedType) {
        int i = C75001.f25594dP[feedType.ordinal()];
        if (i == 1 || i == 2) {
            return new C7527g(context);
        }
        if (i != 3) {
            C10331c.m26250e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
            return null;
        }
        return new C7529i(context);
    }

    /* renamed from: a */
    private static AbstractDialogInterface$OnDismissListenerC9367b m33146a(Context context, FeedType feedType) {
        switch (C75001.f25594dP[feedType.ordinal()]) {
            case 1:
                return new View$OnClickListenerC7530j(context);
            case 2:
                return new View$OnClickListenerC7526f(context);
            case 3:
                return new View$OnClickListenerC7528h(context);
            case 4:
                return new View$OnClickListenerC7531k(context);
            case 5:
                return new View$OnClickListenerC7533l(context);
            case 6:
            case 7:
                C10331c.m26250e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                return null;
            default:
                return null;
        }
    }
}
