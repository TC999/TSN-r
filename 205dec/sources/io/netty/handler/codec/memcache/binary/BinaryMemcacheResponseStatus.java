package io.netty.handler.codec.memcache.binary;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class BinaryMemcacheResponseStatus {
    public static final short AUTH_CONTINUE = 33;
    public static final short AUTH_ERROR = 32;
    public static final short DELTA_BADVAL = 6;
    public static final short E2BIG = 3;
    public static final short EINVA = 4;
    public static final short ENOMEM = 130;
    public static final short KEY_EEXISTS = 2;
    public static final short KEY_ENOENT = 1;
    public static final short NOT_STORED = 5;
    public static final short SUCCESS = 0;
    public static final short UNKNOWN_COMMAND = 129;

    private BinaryMemcacheResponseStatus() {
    }
}
