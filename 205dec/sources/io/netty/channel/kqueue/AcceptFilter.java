package io.netty.channel.kqueue;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class AcceptFilter {
    static final AcceptFilter PLATFORM_UNSUPPORTED = new AcceptFilter("", "");
    private final String filterArgs;
    private final String filterName;

    public AcceptFilter(String str, String str2) {
        this.filterName = (String) ObjectUtil.checkNotNull(str, "filterName");
        this.filterArgs = (String) ObjectUtil.checkNotNull(str2, "filterArgs");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AcceptFilter) {
            AcceptFilter acceptFilter = (AcceptFilter) obj;
            return this.filterName.equals(acceptFilter.filterName) && this.filterArgs.equals(acceptFilter.filterArgs);
        }
        return false;
    }

    public String filterArgs() {
        return this.filterArgs;
    }

    public String filterName() {
        return this.filterName;
    }

    public int hashCode() {
        return ((this.filterName.hashCode() + 31) * 31) + this.filterArgs.hashCode();
    }

    public String toString() {
        return this.filterName + ", " + this.filterArgs;
    }
}
