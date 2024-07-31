package com.mbridge.msdk.thrid.okhttp.internal.platform;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"NewApi"})
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Android10Platform extends AndroidPlatform {
    Android10Platform(Class<?> cls) {
        super(cls, null, null, null, null);
    }

    @Nullable
    public static Platform buildIfSupported() {
        if (Platform.isAndroid()) {
            try {
                if (AndroidPlatform.getSdkInt() >= 29) {
                    return new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
                }
            } catch (ClassNotFoundException unused) {
            }
            return null;
        }
        return null;
    }

    private void enableSessionTickets(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.AndroidPlatform, com.mbridge.msdk.thrid.okhttp.internal.platform.Platform
    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        try {
            enableSessionTickets(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.AndroidPlatform, com.mbridge.msdk.thrid.okhttp.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }
}
