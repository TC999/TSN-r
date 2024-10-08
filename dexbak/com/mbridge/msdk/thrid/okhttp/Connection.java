package com.mbridge.msdk.thrid.okhttp;

import java.net.Socket;
import javax.annotation.Nullable;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Connection {
    @Nullable
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
