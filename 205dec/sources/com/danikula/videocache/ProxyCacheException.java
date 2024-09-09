package com.danikula.videocache;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 2.7.0";

    public ProxyCacheException(String str) {
        super(str + ". Version: 2.7.0");
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + ". Version: 2.7.0", th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 2.7.0", th);
    }
}
