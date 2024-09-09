package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.aw;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File bk(Context context) {
        return new File(aw.cK(context), "video-cache");
    }
}
