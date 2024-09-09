package com.kwad.sdk.core.imageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) {
        long j5 = 0;
        while (j5 < j4) {
            long skip = ((FilterInputStream) this).in.skip(j4 - j5);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j5 += skip;
        }
        return j5;
    }
}
