package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.thrid.okio.Sink;
import java.io.IOException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
