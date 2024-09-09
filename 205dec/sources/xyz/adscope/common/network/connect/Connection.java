package xyz.adscope.common.network.connect;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Connection extends Closeable {
    void disconnect();

    int getCode();

    Map<String, List<String>> getHeaders();

    InputStream getInputStream();

    String getLocationUrl();

    OutputStream getOutputStream();
}
