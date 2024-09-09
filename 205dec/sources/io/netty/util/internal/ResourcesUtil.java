package io.netty.util.internal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ResourcesUtil {
    private ResourcesUtil() {
    }

    public static File getFile(Class cls, String str) {
        try {
            return new File(URLDecoder.decode(cls.getResource(str).getFile(), "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return new File(cls.getResource(str).getFile());
        }
    }
}
