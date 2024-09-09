package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ReferenceCounted {
    int refCnt();

    boolean release();

    boolean release(int i4);

    ReferenceCounted retain();

    ReferenceCounted retain(int i4);

    ReferenceCounted touch();

    ReferenceCounted touch(Object obj);
}
