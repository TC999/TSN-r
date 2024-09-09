package xyz.adscope.common.network;

import java.io.Closeable;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface ResponseBody extends Closeable {
    byte[] byteArray();

    InputStream stream();

    String string();
}
