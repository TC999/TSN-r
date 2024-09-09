package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int O(long j4) {
        if (j4 < 1048576) {
            return 1;
        }
        if (j4 < 5242880) {
            return 2;
        }
        if (j4 < 52428800) {
            return 3;
        }
        return j4 < 104857600 ? 4 : 5;
    }
}
