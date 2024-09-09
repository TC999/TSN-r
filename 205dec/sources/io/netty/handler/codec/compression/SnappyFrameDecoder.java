package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SnappyFrameDecoder extends ByteToMessageDecoder {
    private static final int MAX_UNCOMPRESSED_DATA_SIZE = 65540;
    private static final int SNAPPY_IDENTIFIER_LEN = 6;
    private boolean corrupted;
    private final Snappy snappy;
    private boolean started;
    private final boolean validateChecksums;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.compression.SnappyFrameDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType;

        static {
            int[] iArr = new int[ChunkType.values().length];
            $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType = iArr;
            try {
                iArr[ChunkType.STREAM_IDENTIFIER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType[ChunkType.RESERVED_SKIPPABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType[ChunkType.RESERVED_UNSKIPPABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType[ChunkType.UNCOMPRESSED_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType[ChunkType.COMPRESSED_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum ChunkType {
        STREAM_IDENTIFIER,
        COMPRESSED_DATA,
        UNCOMPRESSED_DATA,
        RESERVED_UNSKIPPABLE,
        RESERVED_SKIPPABLE
    }

    public SnappyFrameDecoder() {
        this(false);
    }

    private static void checkByte(byte b4, byte b5) {
        if (b4 != b5) {
            throw new DecompressionException("Unexpected stream identifier contents. Mismatched snappy protocol version?");
        }
    }

    private static ChunkType mapChunkType(byte b4) {
        if (b4 == 0) {
            return ChunkType.COMPRESSED_DATA;
        }
        if (b4 == 1) {
            return ChunkType.UNCOMPRESSED_DATA;
        }
        if (b4 == -1) {
            return ChunkType.STREAM_IDENTIFIER;
        }
        if ((b4 & 128) == 128) {
            return ChunkType.RESERVED_SKIPPABLE;
        }
        return ChunkType.RESERVED_UNSKIPPABLE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.corrupted) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        try {
            int readerIndex = byteBuf.readerIndex();
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes < 4) {
                return;
            }
            short unsignedByte = byteBuf.getUnsignedByte(readerIndex);
            ChunkType mapChunkType = mapChunkType((byte) unsignedByte);
            int unsignedMediumLE = byteBuf.getUnsignedMediumLE(readerIndex + 1);
            int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType[mapChunkType.ordinal()];
            if (i4 == 1) {
                if (unsignedMediumLE != 6) {
                    throw new DecompressionException("Unexpected length of stream identifier: " + unsignedMediumLE);
                } else if (readableBytes < 10) {
                } else {
                    byteBuf.skipBytes(4);
                    int readerIndex2 = byteBuf.readerIndex();
                    byteBuf.skipBytes(6);
                    int i5 = readerIndex2 + 1;
                    checkByte(byteBuf.getByte(readerIndex2), (byte) 115);
                    int i6 = i5 + 1;
                    checkByte(byteBuf.getByte(i5), (byte) 78);
                    int i7 = i6 + 1;
                    checkByte(byteBuf.getByte(i6), (byte) 97);
                    int i8 = i7 + 1;
                    checkByte(byteBuf.getByte(i7), (byte) 80);
                    checkByte(byteBuf.getByte(i8), (byte) 112);
                    checkByte(byteBuf.getByte(i8 + 1), (byte) 89);
                    this.started = true;
                }
            } else if (i4 == 2) {
                if (!this.started) {
                    throw new DecompressionException("Received RESERVED_SKIPPABLE tag before STREAM_IDENTIFIER");
                }
                int i9 = unsignedMediumLE + 4;
                if (readableBytes < i9) {
                    return;
                }
                byteBuf.skipBytes(i9);
            } else if (i4 == 3) {
                throw new DecompressionException("Found reserved unskippable chunk type: 0x" + Integer.toHexString(unsignedByte));
            } else if (i4 == 4) {
                if (!this.started) {
                    throw new DecompressionException("Received UNCOMPRESSED_DATA tag before STREAM_IDENTIFIER");
                }
                if (unsignedMediumLE > 65540) {
                    throw new DecompressionException("Received UNCOMPRESSED_DATA larger than 65540 bytes");
                }
                if (readableBytes < unsignedMediumLE + 4) {
                    return;
                }
                byteBuf.skipBytes(4);
                if (this.validateChecksums) {
                    Snappy.validateChecksum(byteBuf.readIntLE(), byteBuf, byteBuf.readerIndex(), unsignedMediumLE - 4);
                } else {
                    byteBuf.skipBytes(4);
                }
                list.add(byteBuf.readRetainedSlice(unsignedMediumLE - 4));
            } else if (i4 != 5) {
            } else {
                if (!this.started) {
                    throw new DecompressionException("Received COMPRESSED_DATA tag before STREAM_IDENTIFIER");
                }
                if (readableBytes < unsignedMediumLE + 4) {
                    return;
                }
                byteBuf.skipBytes(4);
                int readIntLE = byteBuf.readIntLE();
                ByteBuf buffer = channelHandlerContext.alloc().buffer();
                if (this.validateChecksums) {
                    int writerIndex = byteBuf.writerIndex();
                    byteBuf.writerIndex((byteBuf.readerIndex() + unsignedMediumLE) - 4);
                    this.snappy.decode(byteBuf, buffer);
                    byteBuf.writerIndex(writerIndex);
                    Snappy.validateChecksum(readIntLE, buffer, 0, buffer.writerIndex());
                } else {
                    this.snappy.decode(byteBuf.readSlice(unsignedMediumLE - 4), buffer);
                }
                list.add(buffer);
                this.snappy.reset();
            }
        } catch (Exception e4) {
            this.corrupted = true;
            throw e4;
        }
    }

    public SnappyFrameDecoder(boolean z3) {
        this.snappy = new Snappy();
        this.validateChecksums = z3;
    }
}
