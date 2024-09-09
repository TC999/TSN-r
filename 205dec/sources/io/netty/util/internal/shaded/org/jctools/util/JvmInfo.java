package io.netty.util.internal.shaded.org.jctools.util;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public interface JvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int PAGE_SIZE = UnsafeAccess.UNSAFE.pageSize();
    public static final int CPUs = Runtime.getRuntime().availableProcessors();
}
