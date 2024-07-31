package com.beizi.p051ad.internal.p058b.p060b;

import android.content.Context;

/* renamed from: com.beizi.ad.internal.b.b.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SourceInfoStorageFactory {
    /* renamed from: a */
    public static SourceInfoStorage m49622a(Context context) {
        return new DatabaseSourceInfoStorage(context);
    }

    /* renamed from: a */
    public static SourceInfoStorage m49623a() {
        return new NoSourceInfoStorage();
    }
}
