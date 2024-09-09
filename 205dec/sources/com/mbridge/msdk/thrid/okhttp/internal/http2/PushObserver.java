package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver.1
        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onData(int i4, BufferedSource bufferedSource, int i5, boolean z3) throws IOException {
            bufferedSource.skip(i5);
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onHeaders(int i4, List<Header> list, boolean z3) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public boolean onRequest(int i4, List<Header> list) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.PushObserver
        public void onReset(int i4, ErrorCode errorCode) {
        }
    };

    boolean onData(int i4, BufferedSource bufferedSource, int i5, boolean z3) throws IOException;

    boolean onHeaders(int i4, List<Header> list, boolean z3);

    boolean onRequest(int i4, List<Header> list);

    void onReset(int i4, ErrorCode errorCode);
}
