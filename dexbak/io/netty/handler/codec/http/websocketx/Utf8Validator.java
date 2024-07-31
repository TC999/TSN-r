package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.util.ByteProcessor;
import kotlin.UByte;
import okio.Utf8;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class Utf8Validator implements ByteProcessor {
    private static final int UTF8_ACCEPT = 0;
    private static final int UTF8_REJECT = 12;
    private boolean checking;
    private int codep;
    private int state = 0;
    private static final byte[] TYPES = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    private static final byte[] STATES = {0, 12, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.GATKQ, 60, 96, 84, 12, 12, 12, 48, 72, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 0, 12, 0, 12, 12, 12, BinaryMemcacheOpcodes.FLUSHQ, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.FLUSHQ, 12, BinaryMemcacheOpcodes.FLUSHQ, 12, 12, 12, 12, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.FLUSHQ, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.FLUSHQ, 12, 12, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.FLUSHQ, 12, 12, 12, 12, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public void check(ByteBuf byteBuf) {
        this.checking = true;
        byteBuf.forEachByte(this);
    }

    public void finish() {
        this.checking = false;
        this.codep = 0;
        if (this.state == 0) {
            return;
        }
        this.state = 0;
        throw new CorruptedFrameException("bytes are not UTF-8");
    }

    public boolean isChecking() {
        return this.checking;
    }

    @Override // io.netty.util.ByteProcessor
    public boolean process(byte b) throws Exception {
        byte b2 = TYPES[b & UByte.f41242c];
        int i = this.state;
        this.codep = i != 0 ? (b & Utf8.REPLACEMENT_BYTE) | (this.codep << 6) : b & (255 >> b2);
        byte b3 = STATES[i + b2];
        this.state = b3;
        if (b3 != 12) {
            return true;
        }
        this.checking = false;
        throw new CorruptedFrameException("bytes are not UTF-8");
    }
}
