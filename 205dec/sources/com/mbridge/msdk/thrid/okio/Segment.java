package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        if (segment != this) {
            if (segment.owner) {
                int i4 = this.limit - this.pos;
                if (i4 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                    return;
                }
                writeTo(segment, i4);
                pop();
                SegmentPool.recycle(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.prev;
        segment3.next = segment;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment2;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i4) {
        Segment take;
        if (i4 > 0 && i4 <= this.limit - this.pos) {
            if (i4 >= 1024) {
                take = sharedCopy();
            } else {
                take = SegmentPool.take();
                System.arraycopy(this.data, this.pos, take.data, 0, i4);
            }
            take.limit = take.pos + i4;
            this.pos += i4;
            this.prev.push(take);
            return take;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i4) {
        if (segment.owner) {
            int i5 = segment.limit;
            if (i5 + i4 > 8192) {
                if (!segment.shared) {
                    int i6 = segment.pos;
                    if ((i5 + i4) - i6 <= 8192) {
                        byte[] bArr = segment.data;
                        System.arraycopy(bArr, i6, bArr, 0, i5 - i6);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.data, this.pos, segment.data, segment.limit, i4);
            segment.limit += i4;
            this.pos += i4;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i4, int i5, boolean z3, boolean z4) {
        this.data = bArr;
        this.pos = i4;
        this.limit = i5;
        this.shared = z3;
        this.owner = z4;
    }
}
