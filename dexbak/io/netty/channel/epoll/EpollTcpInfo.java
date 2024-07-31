package io.netty.channel.epoll;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class EpollTcpInfo {
    final int[] info = new int[32];

    public long advmss() {
        return this.info[27] & 4294967295L;
    }

    public long ato() {
        return this.info[9] & 4294967295L;
    }

    public int backoff() {
        return this.info[4] & 255;
    }

    public int caState() {
        return this.info[1] & 255;
    }

    public long fackets() {
        return this.info[16] & 4294967295L;
    }

    public long lastAckRecv() {
        return this.info[20] & 4294967295L;
    }

    public long lastAckSent() {
        return this.info[18] & 4294967295L;
    }

    public long lastDataRecv() {
        return this.info[19] & 4294967295L;
    }

    public long lastDataSent() {
        return this.info[17] & 4294967295L;
    }

    public long lost() {
        return this.info[14] & 4294967295L;
    }

    public int options() {
        return this.info[5] & 255;
    }

    public long pmtu() {
        return this.info[21] & 4294967295L;
    }

    public int probes() {
        return this.info[3] & 255;
    }

    public long rcvMss() {
        return this.info[11] & 4294967295L;
    }

    public long rcvRtt() {
        return this.info[29] & 4294967295L;
    }

    public long rcvSpace() {
        return this.info[30] & 4294967295L;
    }

    public long rcvSsthresh() {
        return this.info[22] & 4294967295L;
    }

    public int rcvWscale() {
        return this.info[7] & 255;
    }

    public long reordering() {
        return this.info[28] & 4294967295L;
    }

    public long retrans() {
        return this.info[15] & 4294967295L;
    }

    public int retransmits() {
        return this.info[2] & 255;
    }

    public long rto() {
        return this.info[8] & 4294967295L;
    }

    public long rtt() {
        return this.info[23] & 4294967295L;
    }

    public long rttvar() {
        return this.info[24] & 4294967295L;
    }

    public long sacked() {
        return this.info[13] & 4294967295L;
    }

    public long sndCwnd() {
        return this.info[26] & 4294967295L;
    }

    public long sndMss() {
        return this.info[10] & 4294967295L;
    }

    public long sndSsthresh() {
        return this.info[25] & 4294967295L;
    }

    public int sndWscale() {
        return this.info[6] & 255;
    }

    public int state() {
        return this.info[0] & 255;
    }

    public long totalRetrans() {
        return this.info[31] & 4294967295L;
    }

    public long unacked() {
        return this.info[12] & 4294967295L;
    }
}
