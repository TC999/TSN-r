package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class AvailableProcessorsHolder {
        private int availableProcessors;

        AvailableProcessorsHolder() {
        }

        @SuppressForbidden(reason = "to obtain default number of available processors")
        synchronized int availableProcessors() {
            if (this.availableProcessors == 0) {
                setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
            }
            return this.availableProcessors;
        }

        synchronized void setAvailableProcessors(int i4) {
            ObjectUtil.checkPositive(i4, "availableProcessors");
            int i5 = this.availableProcessors;
            if (i5 == 0) {
                this.availableProcessors = i4;
            } else {
                throw new IllegalStateException(String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", Integer.valueOf(i5), Integer.valueOf(i4)));
            }
        }
    }

    private NettyRuntime() {
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }

    public static void setAvailableProcessors(int i4) {
        holder.setAvailableProcessors(i4);
    }
}
