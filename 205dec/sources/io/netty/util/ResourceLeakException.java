package io.netty.util;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ResourceLeakException extends RuntimeException {
    private static final long serialVersionUID = 7186453858343358280L;
    private final StackTraceElement[] cachedStackTrace;

    public ResourceLeakException() {
        this.cachedStackTrace = getStackTrace();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ResourceLeakException) {
            if (obj == this) {
                return true;
            }
            return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException) obj).cachedStackTrace);
        }
        return false;
    }

    public int hashCode() {
        int i4 = 0;
        for (StackTraceElement stackTraceElement : this.cachedStackTrace) {
            i4 = (i4 * 31) + stackTraceElement.hashCode();
        }
        return i4;
    }

    public ResourceLeakException(String str) {
        super(str);
        this.cachedStackTrace = getStackTrace();
    }

    public ResourceLeakException(String str, Throwable th) {
        super(str, th);
        this.cachedStackTrace = getStackTrace();
    }

    public ResourceLeakException(Throwable th) {
        super(th);
        this.cachedStackTrace = getStackTrace();
    }
}
