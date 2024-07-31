package io.netty.util;

import java.util.Arrays;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        int i = 0;
        for (StackTraceElement stackTraceElement : this.cachedStackTrace) {
            i = (i * 31) + stackTraceElement.hashCode();
        }
        return i;
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
