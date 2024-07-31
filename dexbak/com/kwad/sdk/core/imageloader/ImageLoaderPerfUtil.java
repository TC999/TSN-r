package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11137y;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = C11137y.m23626LS();
        imageLoaderInfo.successCount = C11137y.m23625LT();
        imageLoaderInfo.failedCount = C11137y.m23624LU();
        imageLoaderInfo.duration = C11137y.m23627LR();
        return imageLoaderInfo;
    }

    public static void report() {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    C10331c.m26246w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                    return;
                }
                String str = ImageLoaderPerfUtil.TAG;
                C10331c.m26254d(str, "ImageLoaderInfo:" + info.toJson().toString());
                C9815b.m27652q(info);
            }
        });
    }
}
