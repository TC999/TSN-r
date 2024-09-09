package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class PeerCredentials {
    private final int[] gids;
    private final int pid;
    private final int uid;

    PeerCredentials(int i4, int i5, int... iArr) {
        this.pid = i4;
        this.uid = i5;
        this.gids = iArr == null ? EmptyArrays.EMPTY_INTS : iArr;
    }

    public int[] gids() {
        return (int[]) this.gids.clone();
    }

    public int pid() {
        return this.pid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("UserCredentials[pid=");
        sb.append(this.pid);
        sb.append("; uid=");
        sb.append(this.uid);
        sb.append("; gids=[");
        int[] iArr = this.gids;
        if (iArr.length > 0) {
            sb.append(iArr[0]);
            for (int i4 = 1; i4 < this.gids.length; i4++) {
                sb.append(", ");
                sb.append(this.gids[i4]);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public int uid() {
        return this.uid;
    }
}
