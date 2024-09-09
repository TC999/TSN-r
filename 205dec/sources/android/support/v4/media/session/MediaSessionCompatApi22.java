package android.support.v4.media.session;

import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RequiresApi(22)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class MediaSessionCompatApi22 {
    private MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object obj, int i4) {
        ((MediaSession) obj).setRatingType(i4);
    }
}
