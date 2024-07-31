package com.beizi.p051ad.internal.p058b;

import android.content.Context;
import com.beizi.p051ad.lance.p062a.FileUtil;
import java.io.File;

/* renamed from: com.beizi.ad.internal.b.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class StorageUtils {
    /* renamed from: a */
    public static File m49541a(Context context) {
        return new File(m49540a(context, true), "video-cache");
    }

    /* renamed from: a */
    private static File m49540a(Context context, boolean z) {
        return FileUtil.m49055c(context);
    }
}
