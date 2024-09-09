package com.mbridge.msdk.thrid.okhttp;

import java.net.Socket;
import javax.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Connection {
    @Nullable
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
