package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver.1
        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onRequest(int i, List<Header> list) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public void onReset(int i, ErrorCode errorCode) {
        }
    };

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
