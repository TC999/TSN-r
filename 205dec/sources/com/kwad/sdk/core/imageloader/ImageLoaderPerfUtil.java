package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = y.LS();
        imageLoaderInfo.successCount = y.LT();
        imageLoaderInfo.failedCount = y.LU();
        imageLoaderInfo.duration = y.LR();
        return imageLoaderInfo;
    }

    public static void report() {
        g.execute(new ay() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                    return;
                }
                String str = ImageLoaderPerfUtil.TAG;
                c.d(str, "ImageLoaderInfo:" + info.toJson().toString());
                b.q(info);
            }
        });
    }
}
