package io.netty.util.internal.shaded.org.jctools.util;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int CPUs;
    public static final int RECOMENDED_OFFER_BATCH;
    public static final int RECOMENDED_POLL_BATCH;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPUs = availableProcessors;
        RECOMENDED_OFFER_BATCH = availableProcessors * 4;
        RECOMENDED_POLL_BATCH = availableProcessors * 4;
    }
}
