package okio;

import com.acse.ottn.f3;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.l;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.s0;
import kotlin.text.d;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Buffer.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0095\u0001B\t\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0001H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J$\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J \u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u0007J\u001a\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\b\u0010#\u001a\u00020\"H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020(H\u0016J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\u000fH\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020*2\u0006\u00104\u001a\u000203H\u0016J\u0018\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u00109\u001a\u00020\u00072\u0006\u00106\u001a\u000208H\u0016J\b\u0010:\u001a\u00020\rH\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020\r2\u0006\u0010<\u001a\u00020;H\u0016J\u0018\u0010=\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010?\u001a\u00020\rH\u0016J\u0010\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007H\u0016J\b\u0010A\u001a\u00020*H\u0016J\b\u0010C\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020B2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010D\u001a\u00020*2\u0006\u00106\u001a\u00020BH\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u00020BH\u0016J \u0010D\u001a\u00020*2\u0006\u00106\u001a\u00020B2\u0006\u0010\u001e\u001a\u00020*2\u0006\u0010\b\u001a\u00020*H\u0016J\u0010\u0010D\u001a\u00020*2\u0006\u00106\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020\u000bJ\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010I\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u000fH\u0016J \u0010I\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020*2\u0006\u0010\b\u001a\u00020*H\u0016J\u0010\u0010K\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\rH\u0016J \u0010K\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\r2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0016J\u0010\u0010O\u001a\u00020\u00002\u0006\u0010N\u001a\u00020*H\u0016J\u0018\u0010P\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\r2\u0006\u0010<\u001a\u00020;H\u0016J(\u0010P\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\r2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*2\u0006\u0010<\u001a\u00020;H\u0016J\u0010\u0010I\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020BH\u0016J \u0010I\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020B2\u0006\u0010\u001e\u001a\u00020*2\u0006\u0010\b\u001a\u00020*H\u0016J\u0010\u0010I\u001a\u00020*2\u0006\u0010Q\u001a\u00020EH\u0016J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010I\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020R2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010U\u001a\u00020\u00002\u0006\u0010T\u001a\u00020*H\u0016J\u0010\u0010W\u001a\u00020\u00002\u0006\u0010V\u001a\u00020*H\u0016J\u0010\u0010X\u001a\u00020\u00002\u0006\u0010V\u001a\u00020*H\u0016J\u0010\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020*H\u0016J\u0010\u0010[\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020*H\u0016J\u0010\u0010]\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u0010\u0010_\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u0010\u0010`\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u0017\u0010e\u001a\u00020b2\u0006\u0010a\u001a\u00020*H\u0000\u00a2\u0006\u0004\bc\u0010dJ\u0018\u0010I\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010D\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\"H\u0016J\u0018\u0010f\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\"2\u0006\u0010g\u001a\u00020\u0007H\u0016J \u0010f\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\"2\u0006\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0007H\u0016J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u0007H\u0016J\u0010\u0010k\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u000fH\u0016J\u0018\u0010k\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u0007H\u0016J\u0018\u0010l\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u000fH\u0016J(\u0010l\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020*2\u0006\u0010\b\u001a\u00020*H\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\b\u0010o\u001a\u00020\tH\u0016J\b\u0010p\u001a\u00020\u000bH\u0016J\b\u0010r\u001a\u00020qH\u0016J\u0006\u0010s\u001a\u00020\u000fJ\u0006\u0010t\u001a\u00020\u000fJ\u0006\u0010u\u001a\u00020\u000fJ\u0006\u0010v\u001a\u00020\u000fJ\u000e\u0010w\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010x\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010y\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0013\u0010|\u001a\u00020\t2\b\u0010{\u001a\u0004\u0018\u00010zH\u0096\u0002J\b\u0010}\u001a\u00020*H\u0016J\b\u0010~\u001a\u00020\rH\u0016J\u0006\u0010\u007f\u001a\u00020\u0000J\t\u0010\u0080\u0001\u001a\u00020\u0000H\u0016J\u0007\u0010\u0081\u0001\u001a\u00020\u000fJ\u000f\u0010\u0081\u0001\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020*J\u0016\u0010\u0084\u0001\u001a\u00030\u0082\u00012\n\b\u0002\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0007J\u0016\u0010\u0085\u0001\u001a\u00030\u0082\u00012\n\b\u0002\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0007J\u0019\u0010%\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0007\u00a2\u0006\u0005\b\u0087\u0001\u0010&J\u0012\u0010\u008a\u0001\u001a\u00020\u0007H\u0007\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010b8\u0000@\u0000X\u0081\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R2\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u008d\u0001\u001a\u00020\u00078G@@X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008e\u0001\u001a\u0006\b\u008a\u0001\u0010\u0089\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0016\u0010\u0013\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/InputStream;", "input", "", "byteCount", "", "forever", "Lkotlin/f1;", "readFrom", "", "algorithm", "Lokio/ByteString;", "digest", DomainCampaignEx.LOOPBACK_KEY, "hmac", "buffer", "Ljava/io/OutputStream;", "outputStream", "emitCompleteSegments", "emit", "exhausted", "require", "request", "peek", "inputStream", "out", "offset", "copyTo", "writeTo", "completeSegmentByteCount", "", "readByte", "pos", "getByte", "(J)B", f3.f5657f, "", "readShort", "", "readInt", "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "Lokio/Options;", "options", "select", "sink", "readFully", "Lokio/Sink;", "readAll", "readUtf8", "Ljava/nio/charset/Charset;", "charset", "readString", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "", "readByteArray", "read", "Ljava/nio/ByteBuffer;", "clear", "skip", "byteString", "write", "string", "writeUtf8", "beginIndex", "endIndex", "codePoint", "writeUtf8CodePoint", "writeString", "source", "Lokio/Source;", "writeAll", "b", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", "v", "writeLong", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "minimumCapacity", "Lokio/Segment;", "writableSegment$okio", "(I)Lokio/Segment;", "writableSegment", "indexOf", "fromIndex", "toIndex", "bytes", "targetBytes", "indexOfElement", "rangeEquals", "bytesOffset", "flush", "isOpen", "close", "Lokio/Timeout;", "timeout", "md5", "sha1", "sha256", "sha512", "hmacSha1", "hmacSha256", "hmacSha512", "", "other", "equals", "hashCode", "toString", "copy", "clone", "snapshot", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readUnsafe", "readAndWriteUnsafe", "index", "-deprecated_getByte", "-deprecated_size", "()J", "size", "head", "Lokio/Segment;", "<set-?>", "J", "setSize$okio", "(J)V", "getBuffer", "()Lokio/Buffer;", "<init>", "()V", "UnsafeCursor", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    @JvmField
    @Nullable
    public Segment head;
    private long size;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Buffer.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "", "next", "", "offset", "seek", "newSize", "resizeBuffer", "minByteCount", "expandBuffer", "Lkotlin/f1;", "close", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "", "readWrite", "Z", "Lokio/Segment;", "segment", "Lokio/Segment;", "J", "", "data", "[B", CampaignEx.JSON_NATIVE_VIDEO_START, "I", "end", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class UnsafeCursor implements Closeable {
        @JvmField
        @Nullable
        public Buffer buffer;
        @JvmField
        @Nullable
        public byte[] data;
        @JvmField
        public boolean readWrite;
        private Segment segment;
        @JvmField
        public long offset = -1;
        @JvmField
        public int start = -1;
        @JvmField
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1L;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int i4) {
            if (!(i4 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i4).toString());
            }
            if (i4 <= 8192) {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long size = buffer.size();
                        Segment writableSegment$okio = buffer.writableSegment$okio(i4);
                        int i5 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j4 = i5;
                        buffer.setSize$okio(size + j4);
                        this.segment = writableSegment$okio;
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i5;
                        this.end = 8192;
                        return j4;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i4).toString());
        }

        public final int next() {
            long j4 = this.offset;
            Buffer buffer = this.buffer;
            f0.m(buffer);
            if (j4 != buffer.size()) {
                long j5 = this.offset;
                return seek(j5 == -1 ? 0L : j5 + (this.end - this.start));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j4) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long size = buffer.size();
                    int i4 = 1;
                    if (j4 <= size) {
                        if (j4 >= 0) {
                            long j5 = size - j4;
                            while (true) {
                                if (j5 <= 0) {
                                    break;
                                }
                                Segment segment = buffer.head;
                                f0.m(segment);
                                Segment segment2 = segment.prev;
                                f0.m(segment2);
                                int i5 = segment2.limit;
                                long j6 = i5 - segment2.pos;
                                if (j6 <= j5) {
                                    buffer.head = segment2.pop();
                                    SegmentPool.recycle(segment2);
                                    j5 -= j6;
                                } else {
                                    segment2.limit = i5 - ((int) j5);
                                    break;
                                }
                            }
                            this.segment = null;
                            this.offset = j4;
                            this.data = null;
                            this.start = -1;
                            this.end = -1;
                        } else {
                            throw new IllegalArgumentException(("newSize < 0: " + j4).toString());
                        }
                    } else if (j4 > size) {
                        long j7 = j4 - size;
                        boolean z3 = true;
                        while (j7 > 0) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(i4);
                            int min = (int) Math.min(j7, 8192 - writableSegment$okio.limit);
                            int i6 = writableSegment$okio.limit + min;
                            writableSegment$okio.limit = i6;
                            j7 -= min;
                            if (z3) {
                                this.segment = writableSegment$okio;
                                this.offset = size;
                                this.data = writableSegment$okio.data;
                                this.start = i6 - min;
                                this.end = i6;
                                z3 = false;
                            }
                            i4 = 1;
                        }
                    }
                    buffer.setSize$okio(j4);
                    return size;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int seek(long j4) {
            Segment segment;
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (j4 >= -1 && j4 <= buffer.size()) {
                    if (j4 != -1 && j4 != buffer.size()) {
                        long j5 = 0;
                        long size = buffer.size();
                        Segment segment2 = buffer.head;
                        Segment segment3 = this.segment;
                        if (segment3 != null) {
                            long j6 = this.offset;
                            int i4 = this.start;
                            f0.m(segment3);
                            long j7 = j6 - (i4 - segment3.pos);
                            if (j7 > j4) {
                                segment = segment2;
                                segment2 = this.segment;
                                size = j7;
                            } else {
                                segment = this.segment;
                                j5 = j7;
                            }
                        } else {
                            segment = segment2;
                        }
                        if (size - j4 > j4 - j5) {
                            while (true) {
                                f0.m(segment);
                                int i5 = segment.limit;
                                int i6 = segment.pos;
                                if (j4 < (i5 - i6) + j5) {
                                    break;
                                }
                                j5 += i5 - i6;
                                segment = segment.next;
                            }
                        } else {
                            while (size > j4) {
                                f0.m(segment2);
                                segment2 = segment2.prev;
                                f0.m(segment2);
                                size -= segment2.limit - segment2.pos;
                            }
                            j5 = size;
                            segment = segment2;
                        }
                        if (this.readWrite) {
                            f0.m(segment);
                            if (segment.shared) {
                                Segment unsharedCopy = segment.unsharedCopy();
                                if (buffer.head == segment) {
                                    buffer.head = unsharedCopy;
                                }
                                segment = segment.push(unsharedCopy);
                                Segment segment4 = segment.prev;
                                f0.m(segment4);
                                segment4.pop();
                            }
                        }
                        this.segment = segment;
                        this.offset = j4;
                        f0.m(segment);
                        this.data = segment.data;
                        int i7 = segment.pos + ((int) (j4 - j5));
                        this.start = i7;
                        int i8 = segment.limit;
                        this.end = i8;
                        return i8 - i7;
                    }
                    this.segment = null;
                    this.offset = j4;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                }
                s0 s0Var = s0.f55680a;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(buffer.size())}, 2));
                f0.o(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j4, long j5, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        long j6 = j4;
        if ((i4 & 4) != 0) {
            j5 = buffer.size - j6;
        }
        return buffer.copyTo(outputStream, j6, j5);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        return buffer.copyTo(buffer2, j4);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j4, long j5, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        return buffer.copyTo(buffer2, j4, j5);
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i4 = segment.pos;
            messageDigest.update(bArr, i4, segment.limit - i4);
            Segment segment2 = segment.next;
            f0.m(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i5 = segment2.pos;
                messageDigest.update(bArr2, i5, segment2.limit - i5);
                segment2 = segment2.next;
                f0.m(segment2);
            }
        }
        byte[] digest = messageDigest.digest();
        f0.o(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                mac.update(bArr, i4, segment.limit - i4);
                Segment segment2 = segment.next;
                f0.m(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i5 = segment2.pos;
                    mac.update(bArr2, i5, segment2.limit - i5);
                    segment2 = segment2.next;
                    f0.m(segment2);
                }
            }
            byte[] doFinal = mac.doFinal();
            f0.o(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j4, int i4, Object obj) throws IOException {
        if ((i4 & 2) != 0) {
            j4 = buffer.size;
        }
        return buffer.writeTo(outputStream, j4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m266deprecated_getByte(long j4) {
        return getByte(j4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m267deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        f0.m(segment);
        Segment segment2 = segment.prev;
        f0.m(segment2);
        int i4 = segment2.limit;
        if (i4 < 8192 && segment2.owner) {
            size -= i4 - segment2.pos;
        }
        return size;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            f0.m(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                f0.m(segment3);
                f0.m(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j4) throws IOException {
        return copyTo$default(this, outputStream, j4, 0L, 4, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long j4, long j5) throws IOException {
        int i4;
        f0.p(out, "out");
        Util.checkOffsetAndCount(this.size, j4, j5);
        if (j5 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            f0.m(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (j4 < i5 - i6) {
                break;
            }
            j4 -= i5 - i6;
            segment = segment.next;
        }
        while (j5 > 0) {
            f0.m(segment);
            int min = (int) Math.min(segment.limit - i4, j5);
            out.write(segment.data, (int) (segment.pos + j4), min);
            j5 -= min;
            segment = segment.next;
            j4 = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.head;
                f0.m(segment);
                Segment segment2 = buffer.head;
                f0.m(segment2);
                int i4 = segment.pos;
                int i5 = segment2.pos;
                long j4 = 0;
                while (j4 < size()) {
                    long min = Math.min(segment.limit - i4, segment2.limit - i5);
                    long j5 = 0;
                    while (j5 < min) {
                        int i6 = i4 + 1;
                        int i7 = i5 + 1;
                        if (segment.data[i4] != segment2.data[i5]) {
                            return false;
                        }
                        j5++;
                        i4 = i6;
                        i5 = i7;
                    }
                    if (i4 == segment.limit) {
                        segment = segment.next;
                        f0.m(segment);
                        i4 = segment.pos;
                    }
                    if (i5 == segment2.limit) {
                        segment2 = segment2.next;
                        f0.m(segment2);
                        i5 = segment2.pos;
                    }
                    j4 += min;
                }
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @JvmName(name = "getByte")
    public final byte getByte(long j4) {
        Util.checkOffsetAndCount(size(), j4, 1L);
        Segment segment = this.head;
        if (segment != null) {
            if (size() - j4 < j4) {
                long size = size();
                while (size > j4) {
                    segment = segment.prev;
                    f0.m(segment);
                    size -= segment.limit - segment.pos;
                }
                f0.m(segment);
                return segment.data[(int) ((segment.pos + j4) - size)];
            }
            long j5 = 0;
            while (true) {
                long j6 = (segment.limit - segment.pos) + j5;
                if (j6 > j4) {
                    f0.m(segment);
                    return segment.data[(int) ((segment.pos + j4) - j5)];
                }
                segment = segment.next;
                f0.m(segment);
                j5 = j6;
            }
        } else {
            f0.m(null);
            throw null;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment != null) {
            int i4 = 1;
            do {
                int i5 = segment.limit;
                for (int i6 = segment.pos; i6 < i5; i6++) {
                    i4 = (i4 * 31) + segment.data[i6];
                }
                segment = segment.next;
                f0.m(segment);
            } while (segment != this.head);
            return i4;
        }
        return 0;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString key) {
        f0.p(key, "key");
        return hmac("HmacSHA1", key);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString key) {
        f0.p(key, "key");
        return hmac("HmacSHA256", key);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString key) {
        f0.p(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b4) {
        return indexOf(b4, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        f0.p(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @NotNull
            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] sink, int i4, int i5) {
                f0.p(sink, "sink");
                return Buffer.this.read(sink, i4, i5);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @NotNull
            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i4) {
                Buffer.this.writeByte(i4);
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] data, int i4, int i5) {
                f0.p(data, "data");
                Buffer.this.write(data, i4, i5);
            }
        };
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j4, @NotNull ByteString bytes) {
        f0.p(bytes, "bytes");
        return rangeEquals(j4, bytes, 0, bytes.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) throws IOException {
        f0.p(sink, "sink");
        Segment segment = this.head;
        if (segment != null) {
            int min = Math.min(sink.remaining(), segment.limit - segment.pos);
            sink.put(segment.data, segment.pos, min);
            int i4 = segment.pos + min;
            segment.pos = i4;
            this.size -= min;
            if (i4 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return min;
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) throws IOException {
        f0.p(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        f0.p(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            int i6 = i4 + 1;
            byte b4 = segment.data[i4];
            setSize$okio(size() - 1);
            if (i6 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            return b4;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c4 A[EDGE_INSN: B:52:0x00c4->B:41:0x00c4 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input) throws IOException {
        f0.p(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long j4) throws EOFException {
        f0.p(sink, "sink");
        if (size() >= j4) {
            sink.write(this, j4);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[EDGE_INSN: B:43:0x00ae->B:37:0x00ae ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb8
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.f0.m(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.Util.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La8
        La6:
            r6.pos = r8
        La8:
            if (r1 != 0) goto Lae
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            goto Lbf
        Lbe:
            throw r0
        Lbf:
            goto Lbe
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 24) | ((bArr[i6] & 255) << 16);
            int i9 = i7 + 1;
            int i10 = i8 | ((bArr[i7] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            setSize$okio(size() - 4);
            if (i11 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i11;
            }
            return i12;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j4 = ((bArr[i4] & 255) << 56) | ((bArr[i6] & 255) << 48) | ((bArr[i7] & 255) << 40);
            int i9 = i8 + 1;
            long j5 = ((bArr[i8] & 255) << 32) | j4;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j6 = j5 | ((bArr[i9] & 255) << 24) | ((bArr[i10] & 255) << 16);
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            long j7 = j6 | ((bArr[i11] & 255) << 8) | (bArr[i12] & 255);
            setSize$okio(size() - 8);
            if (i13 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j7;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            f0.m(segment);
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
            setSize$okio(size() - 2);
            if (i7 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i7;
            }
            return (short) i8;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        f0.p(charset, "charset");
        return readString(this.size, charset);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        f0.p(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.size, d.f58930b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i4;
        int i5;
        int i6;
        if (size() != 0) {
            byte b4 = getByte(0L);
            if ((b4 & 128) == 0) {
                i4 = b4 & Byte.MAX_VALUE;
                i5 = 1;
                i6 = 0;
            } else if ((b4 & 224) == 192) {
                i4 = b4 & 31;
                i5 = 2;
                i6 = 128;
            } else if ((b4 & 240) == 224) {
                i4 = b4 & 15;
                i5 = 3;
                i6 = 2048;
            } else if ((b4 & 248) != 240) {
                skip(1L);
                return 65533;
            } else {
                i4 = b4 & 7;
                i5 = 4;
                i6 = 65536;
            }
            long j4 = i5;
            if (size() >= j4) {
                for (int i7 = 1; i7 < i5; i7++) {
                    long j5 = i7;
                    byte b5 = getByte(j5);
                    if ((b5 & 192) != 128) {
                        skip(j5);
                        return 65533;
                    }
                    i4 = (i4 << 6) | (b5 & 63);
                }
                skip(j4);
                if (i4 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i4 && 57343 >= i4) || i4 < i6) {
                    return 65533;
                }
                return i4;
            }
            throw new EOFException("size < " + i5 + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b4) + ')');
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j4) {
        return this.size >= j4;
    }

    @Override // okio.BufferedSource
    public void require(long j4) throws EOFException {
        if (this.size < j4) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        f0.p(options, "options");
        int selectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j4) {
        this.size = j4;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j4) throws EOFException {
        while (j4 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j4, segment.limit - segment.pos);
                long j5 = min;
                setSize$okio(size() - j5);
                j4 -= j5;
                int i4 = segment.pos + min;
                segment.pos = i4;
                if (i4 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int i4) {
        boolean z3 = true;
        if ((i4 < 1 || i4 > 8192) ? false : false) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            f0.m(segment);
            Segment segment2 = segment.prev;
            f0.m(segment2);
            return (segment2.limit + i4 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) throws IOException {
        f0.p(source, "source");
        long j4 = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j4;
            }
            j4 += read;
        }
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out, long j4) throws IOException {
        f0.p(out, "out");
        Util.checkOffsetAndCount(this.size, 0L, j4);
        Segment segment = this.head;
        while (j4 > 0) {
            f0.m(segment);
            int min = (int) Math.min(j4, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, min);
            int i4 = segment.pos + min;
            segment.pos = i4;
            long j5 = min;
            this.size -= j5;
            j4 -= j5;
            if (i4 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b4, long j4) {
        return indexOf(b4, j4, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long j4) {
        int i4;
        int i5;
        f0.p(targetBytes, "targetBytes");
        long j5 = 0;
        if (j4 >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                if (size() - j4 < j4) {
                    j5 = size();
                    while (j5 > j4) {
                        segment = segment.prev;
                        f0.m(segment);
                        j5 -= segment.limit - segment.pos;
                    }
                    if (targetBytes.size() == 2) {
                        byte b4 = targetBytes.getByte(0);
                        byte b5 = targetBytes.getByte(1);
                        while (j5 < size()) {
                            byte[] bArr = segment.data;
                            i4 = (int) ((segment.pos + j4) - j5);
                            int i6 = segment.limit;
                            while (i4 < i6) {
                                byte b6 = bArr[i4];
                                if (b6 != b4 && b6 != b5) {
                                    i4++;
                                }
                                i5 = segment.pos;
                            }
                            j5 += segment.limit - segment.pos;
                            segment = segment.next;
                            f0.m(segment);
                            j4 = j5;
                        }
                        return -1L;
                    }
                    byte[] internalArray$okio = targetBytes.internalArray$okio();
                    while (j5 < size()) {
                        byte[] bArr2 = segment.data;
                        i4 = (int) ((segment.pos + j4) - j5);
                        int i7 = segment.limit;
                        while (i4 < i7) {
                            byte b7 = bArr2[i4];
                            for (byte b8 : internalArray$okio) {
                                if (b7 == b8) {
                                    i5 = segment.pos;
                                }
                            }
                            i4++;
                        }
                        j5 += segment.limit - segment.pos;
                        segment = segment.next;
                        f0.m(segment);
                        j4 = j5;
                    }
                    return -1L;
                }
                while (true) {
                    long j6 = (segment.limit - segment.pos) + j5;
                    if (j6 > j4) {
                        break;
                    }
                    segment = segment.next;
                    f0.m(segment);
                    j5 = j6;
                }
                if (targetBytes.size() == 2) {
                    byte b9 = targetBytes.getByte(0);
                    byte b10 = targetBytes.getByte(1);
                    while (j5 < size()) {
                        byte[] bArr3 = segment.data;
                        i4 = (int) ((segment.pos + j4) - j5);
                        int i8 = segment.limit;
                        while (i4 < i8) {
                            byte b11 = bArr3[i4];
                            if (b11 != b9 && b11 != b10) {
                                i4++;
                            }
                            i5 = segment.pos;
                        }
                        j5 += segment.limit - segment.pos;
                        segment = segment.next;
                        f0.m(segment);
                        j4 = j5;
                    }
                    return -1L;
                }
                byte[] internalArray$okio2 = targetBytes.internalArray$okio();
                while (j5 < size()) {
                    byte[] bArr4 = segment.data;
                    i4 = (int) ((segment.pos + j4) - j5);
                    int i9 = segment.limit;
                    while (i4 < i9) {
                        byte b12 = bArr4[i4];
                        for (byte b13 : internalArray$okio2) {
                            if (b12 == b13) {
                                i5 = segment.pos;
                            }
                        }
                        i4++;
                    }
                    j5 += segment.limit - segment.pos;
                    segment = segment.next;
                    f0.m(segment);
                    j4 = j5;
                }
                return -1L;
                return (i4 - i5) + j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j4, @NotNull ByteString bytes, int i4, int i5) {
        f0.p(bytes, "bytes");
        if (j4 < 0 || i4 < 0 || i5 < 0 || size() - j4 < i5 || bytes.size() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (getByte(i6 + j4) != bytes.getByte(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long j4) throws EOFException {
        if (j4 >= 0 && j4 <= ((long) Integer.MAX_VALUE)) {
            if (size() >= j4) {
                byte[] bArr = new byte[(int) j4];
                readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long j4) throws EOFException {
        if (j4 >= 0 && j4 <= ((long) Integer.MAX_VALUE)) {
            if (size() >= j4) {
                if (j4 >= 4096) {
                    ByteString snapshot = snapshot((int) j4);
                    skip(j4);
                    return snapshot;
                }
                return new ByteString(readByteArray(j4));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input, long j4) throws IOException {
        f0.p(input, "input");
        if (j4 >= 0) {
            readFrom(input, j4, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long j4, @NotNull Charset charset) throws EOFException {
        f0.p(charset, "charset");
        if (j4 >= 0 && j4 <= ((long) Integer.MAX_VALUE)) {
            if (this.size >= j4) {
                if (j4 == 0) {
                    return "";
                }
                Segment segment = this.head;
                f0.m(segment);
                int i4 = segment.pos;
                if (i4 + j4 > segment.limit) {
                    return new String(readByteArray(j4), charset);
                }
                int i5 = (int) j4;
                String str = new String(segment.data, i4, i5, charset);
                int i6 = segment.pos + i5;
                segment.pos = i6;
                this.size -= j4;
                if (i6 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long j4) throws EOFException {
        return readString(j4, d.f58930b);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long j4) throws EOFException {
        if (j4 >= 0) {
            long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
            byte b4 = (byte) 10;
            long indexOf = indexOf(b4, 0L, j5);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(this, indexOf);
            }
            if (j5 < size() && getByte(j5 - 1) == ((byte) 13) && getByte(j5) == b4) {
                return BufferKt.readUtf8Line(this, j5);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0L, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j4) + " content=" + buffer.readByteString().hex() + '\u2026');
        }
        throw new IllegalArgumentException(("limit < 0: " + j4).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int i4) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        writableSegment$okio.limit = i5 + 1;
        bArr[i5] = (byte) i4;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        boolean z3 = false;
        int i4 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z3 = true;
        }
        if (j4 >= 100000000) {
            i4 = j4 < 1000000000000L ? j4 < 10000000000L ? j4 < C.NANOS_PER_SECOND ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i4 = j4 < C.MICROS_PER_SECOND ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i4 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i4 = 2;
        }
        if (z3) {
            i4++;
        }
        Segment writableSegment$okio = writableSegment$okio(i4);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit + i4;
        while (j4 != 0) {
            long j5 = 10;
            i5--;
            bArr[i5] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j4 % j5)];
            j4 /= j5;
        }
        if (z3) {
            bArr[i5 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i4;
        setSize$okio(size() + i4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = writableSegment$okio(i4);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            bArr[i6] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j4)];
            j4 >>>= 4;
        }
        writableSegment$okio.limit += i4;
        setSize$okio(size() + i4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int i4) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i4 >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >>> 8) & 255);
        bArr[i8] = (byte) (i4 & 255);
        writableSegment$okio.limit = i8 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int i4) {
        return writeInt(Util.reverseBytes(i4));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long j4) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i4 = writableSegment$okio.limit;
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j4 >>> 56) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j4 >>> 48) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j4 >>> 40) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j4 >>> 32) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j4 >>> 24) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((j4 >>> 16) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j4 >>> 8) & 255);
        bArr[i11] = (byte) (j4 & 255);
        writableSegment$okio.limit = i11 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long j4) {
        return writeLong(Util.reverseBytes(j4));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int i4) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i5 = writableSegment$okio.limit;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i6] = (byte) (i4 & 255);
        writableSegment$okio.limit = i6 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int i4) {
        return writeShort((int) Util.reverseBytes((short) i4));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int i4) {
        if (i4 < 128) {
            writeByte(i4);
        } else if (i4 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i5 = writableSegment$okio.limit;
            bArr[i5] = (byte) ((i4 >> 6) | 192);
            bArr[i5 + 1] = (byte) ((i4 & 63) | 128);
            writableSegment$okio.limit = i5 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i4 && 57343 >= i4) {
            writeByte(63);
        } else if (i4 < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i6 = writableSegment$okio2.limit;
            bArr2[i6] = (byte) ((i4 >> 12) | 224);
            bArr2[i6 + 1] = (byte) (((i4 >> 6) & 63) | 128);
            bArr2[i6 + 2] = (byte) ((i4 & 63) | 128);
            writableSegment$okio2.limit = i6 + 3;
            setSize$okio(size() + 3);
        } else if (i4 <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i7 = writableSegment$okio3.limit;
            bArr3[i7] = (byte) ((i4 >> 18) | 240);
            bArr3[i7 + 1] = (byte) (((i4 >> 12) & 63) | 128);
            bArr3[i7 + 2] = (byte) (((i4 >> 6) & 63) | 128);
            bArr3[i7 + 3] = (byte) ((i4 & 63) | 128);
            writableSegment$okio3.limit = i7 + 4;
            setSize$okio(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i4));
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) throws IOException {
        f0.p(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, @NotNull Charset charset) {
        f0.p(string, "string");
        f0.p(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string) {
        f0.p(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    private final void readFrom(InputStream inputStream, long j4, boolean z3) throws IOException {
        while (true) {
            if (j4 <= 0 && !z3) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j4, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z3) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j5 = read;
            this.size += j5;
            j4 -= j5;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b4, long j4, long j5) {
        Segment segment;
        int i4;
        long j6 = 0;
        if (0 <= j4 && j5 >= j4) {
            if (j5 > size()) {
                j5 = size();
            }
            if (j4 == j5 || (segment = this.head) == null) {
                return -1L;
            }
            if (size() - j4 < j4) {
                j6 = size();
                while (j6 > j4) {
                    segment = segment.prev;
                    f0.m(segment);
                    j6 -= segment.limit - segment.pos;
                }
                while (j6 < j5) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + j5) - j6);
                    i4 = (int) ((segment.pos + j4) - j6);
                    while (i4 < min) {
                        if (bArr[i4] != b4) {
                            i4++;
                        }
                    }
                    j6 += segment.limit - segment.pos;
                    segment = segment.next;
                    f0.m(segment);
                    j4 = j6;
                }
                return -1L;
            }
            while (true) {
                long j7 = (segment.limit - segment.pos) + j6;
                if (j7 > j4) {
                    break;
                }
                segment = segment.next;
                f0.m(segment);
                j6 = j7;
            }
            while (j6 < j5) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min(segment.limit, (segment.pos + j5) - j6);
                i4 = (int) ((segment.pos + j4) - j6);
                while (i4 < min2) {
                    if (bArr2[i4] != b4) {
                        i4++;
                    }
                }
                j6 += segment.limit - segment.pos;
                segment = segment.next;
                f0.m(segment);
                j4 = j6;
            }
            return -1L;
            return (i4 - segment.pos) + j6;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j4 + " toIndex=" + j5).toString());
    }

    @NotNull
    public final ByteString snapshot(int i4) {
        if (i4 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0L, i4);
        Segment segment = this.head;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            f0.m(segment);
            int i8 = segment.limit;
            int i9 = segment.pos;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i7];
        int[] iArr = new int[i7 * 2];
        Segment segment2 = this.head;
        int i10 = 0;
        while (i5 < i4) {
            f0.m(segment2);
            bArr[i10] = segment2.data;
            i5 += segment2.limit - segment2.pos;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = segment2.pos;
            segment2.shared = true;
            i10++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, int i4, int i5, @NotNull Charset charset) {
        f0.p(string, "string");
        f0.p(charset, "charset");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (i5 >= i4) {
            if (i5 <= string.length()) {
                if (f0.g(charset, d.f58930b)) {
                    return writeUtf8(string, i4, i5);
                }
                String substring = string.substring(i4, i5);
                f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                if (substring != null) {
                    byte[] bytes = substring.getBytes(charset);
                    f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string, int i4, int i5) {
        f0.p(string, "string");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (i5 >= i4) {
            if (!(i5 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + string.length()).toString());
            }
            while (i4 < i5) {
                char charAt = string.charAt(i4);
                if (charAt < '\u0080') {
                    Segment writableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = writableSegment$okio.data;
                    int i6 = writableSegment$okio.limit - i4;
                    int min = Math.min(i5, 8192 - i6);
                    int i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) charAt;
                    while (i7 < min) {
                        char charAt2 = string.charAt(i7);
                        if (charAt2 >= '\u0080') {
                            break;
                        }
                        bArr[i7 + i6] = (byte) charAt2;
                        i7++;
                    }
                    int i8 = writableSegment$okio.limit;
                    int i9 = (i6 + i7) - i8;
                    writableSegment$okio.limit = i8 + i9;
                    setSize$okio(size() + i9);
                    i4 = i7;
                } else {
                    if (charAt < '\u0800') {
                        Segment writableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = writableSegment$okio2.data;
                        int i10 = writableSegment$okio2.limit;
                        bArr2[i10] = (byte) ((charAt >> 6) | 192);
                        bArr2[i10 + 1] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio2.limit = i10 + 2;
                        setSize$okio(size() + 2);
                    } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                        int i11 = i4 + 1;
                        char charAt3 = i11 < i5 ? string.charAt(i11) : (char) 0;
                        if (charAt <= '\udbff' && '\udc00' <= charAt3 && '\udfff' >= charAt3) {
                            int i12 = (((charAt & '\u03ff') << 10) | (charAt3 & '\u03ff')) + 65536;
                            Segment writableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = writableSegment$okio3.data;
                            int i13 = writableSegment$okio3.limit;
                            bArr3[i13] = (byte) ((i12 >> 18) | 240);
                            bArr3[i13 + 1] = (byte) (((i12 >> 12) & 63) | 128);
                            bArr3[i13 + 2] = (byte) (((i12 >> 6) & 63) | 128);
                            bArr3[i13 + 3] = (byte) ((i12 & 63) | 128);
                            writableSegment$okio3.limit = i13 + 4;
                            setSize$okio(size() + 4);
                            i4 += 2;
                        } else {
                            writeByte(63);
                            i4 = i11;
                        }
                    } else {
                        Segment writableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i14 = writableSegment$okio4.limit;
                        bArr4[i14] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i14 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i14 + 2] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio4.limit = i14 + 3;
                        setSize$okio(size() + 3);
                    }
                    i4++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) throws EOFException {
        f0.p(sink, "sink");
        int i4 = 0;
        while (i4 < sink.length) {
            int read = read(sink, i4, sink.length - i4);
            if (read == -1) {
                throw new EOFException();
            }
            i4 += read;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) throws IOException {
        f0.p(source, "source");
        int remaining = source.remaining();
        int i4 = remaining;
        while (i4 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i4, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i4 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        f0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j4) {
        f0.p(out, "out");
        return copyTo(out, j4, this.size - j4);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int i4, int i5) {
        f0.p(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i4, i5);
        Segment segment = this.head;
        if (segment != null) {
            int min = Math.min(i5, segment.limit - segment.pos);
            byte[] bArr = segment.data;
            int i6 = segment.pos;
            l.W0(bArr, sink, i4, i6, i6 + min);
            segment.pos += min;
            setSize$okio(size() - min);
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return min;
            }
            return min;
        }
        return -1;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j4, long j5) {
        f0.p(out, "out");
        Util.checkOffsetAndCount(size(), j4, j5);
        if (j5 != 0) {
            out.setSize$okio(out.size() + j5);
            Segment segment = this.head;
            while (true) {
                f0.m(segment);
                int i4 = segment.limit;
                int i5 = segment.pos;
                if (j4 < i4 - i5) {
                    break;
                }
                j4 -= i4 - i5;
                segment = segment.next;
            }
            while (j5 > 0) {
                f0.m(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i6 = sharedCopy.pos + ((int) j4);
                sharedCopy.pos = i6;
                sharedCopy.limit = Math.min(i6 + ((int) j5), sharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    out.head = sharedCopy;
                } else {
                    f0.m(segment2);
                    Segment segment3 = segment2.prev;
                    f0.m(segment3);
                    segment3.push(sharedCopy);
                }
                j5 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j4 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        f0.p(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i4, int i5) {
        f0.p(byteString, "byteString");
        byteString.write$okio(this, i4, i5);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source) {
        f0.p(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source, int i4, int i5) {
        f0.p(source, "source");
        long j4 = i5;
        Util.checkOffsetAndCount(source.length, i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i6 - i4, 8192 - writableSegment$okio.limit);
            int i7 = i4 + min;
            l.W0(source, writableSegment$okio.data, writableSegment$okio.limit, i4, i7);
            writableSegment$okio.limit += min;
            i4 = i7;
        }
        setSize$okio(size() + j4);
        return this;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j4) {
        f0.p(sink, "sink");
        if (j4 >= 0) {
            if (size() == 0) {
                return -1L;
            }
            if (j4 > size()) {
                j4 = size();
            }
            sink.write(this, j4);
            return j4;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull Source source, long j4) throws IOException {
        f0.p(source, "source");
        while (j4 > 0) {
            long read = source.read(this, j4);
            if (read == -1) {
                throw new EOFException();
            }
            j4 -= read;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long j4) throws IOException {
        long j5 = j4;
        f0.p(bytes, "bytes");
        if (bytes.size() > 0) {
            long j6 = 0;
            if (j5 >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j5 < j5) {
                        long size = size();
                        while (size > j5) {
                            segment = segment.prev;
                            f0.m(segment);
                            size -= segment.limit - segment.pos;
                        }
                        byte[] internalArray$okio = bytes.internalArray$okio();
                        byte b4 = internalArray$okio[0];
                        int size2 = bytes.size();
                        long size3 = (size() - size2) + 1;
                        while (size < size3) {
                            byte[] bArr = segment.data;
                            long j7 = size;
                            int min = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                            for (int i4 = (int) ((segment.pos + j5) - j7); i4 < min; i4++) {
                                if (bArr[i4] == b4 && BufferKt.rangeEquals(segment, i4 + 1, internalArray$okio, 1, size2)) {
                                    return (i4 - segment.pos) + j7;
                                }
                            }
                            j5 = j7 + (segment.limit - segment.pos);
                            segment = segment.next;
                            f0.m(segment);
                            size = j5;
                        }
                    } else {
                        while (true) {
                            long j8 = (segment.limit - segment.pos) + j6;
                            if (j8 > j5) {
                                break;
                            }
                            segment = segment.next;
                            f0.m(segment);
                            j6 = j8;
                        }
                        byte[] internalArray$okio2 = bytes.internalArray$okio();
                        byte b5 = internalArray$okio2[0];
                        int size4 = bytes.size();
                        long size5 = (size() - size4) + 1;
                        while (j6 < size5) {
                            byte[] bArr2 = segment.data;
                            long j9 = size5;
                            int min2 = (int) Math.min(segment.limit, (segment.pos + size5) - j6);
                            for (int i5 = (int) ((segment.pos + j5) - j6); i5 < min2; i5++) {
                                if (bArr2[i5] == b5 && BufferKt.rangeEquals(segment, i5 + 1, internalArray$okio2, 1, size4)) {
                                    return (i5 - segment.pos) + j6;
                                }
                            }
                            j6 += segment.limit - segment.pos;
                            segment = segment.next;
                            f0.m(segment);
                            j5 = j6;
                            size5 = j9;
                        }
                    }
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j5).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j4) {
        Segment segment;
        Segment segment2;
        f0.p(source, "source");
        if (source != this) {
            Util.checkOffsetAndCount(source.size(), 0L, j4);
            while (j4 > 0) {
                Segment segment3 = source.head;
                f0.m(segment3);
                int i4 = segment3.limit;
                f0.m(source.head);
                if (j4 < i4 - segment.pos) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        f0.m(segment4);
                        segment2 = segment4.prev;
                    } else {
                        segment2 = null;
                    }
                    if (segment2 != null && segment2.owner) {
                        if ((segment2.limit + j4) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                            Segment segment5 = source.head;
                            f0.m(segment5);
                            segment5.writeTo(segment2, (int) j4);
                            source.setSize$okio(source.size() - j4);
                            setSize$okio(size() + j4);
                            return;
                        }
                    }
                    Segment segment6 = source.head;
                    f0.m(segment6);
                    source.head = segment6.split((int) j4);
                }
                Segment segment7 = source.head;
                f0.m(segment7);
                long j5 = segment7.limit - segment7.pos;
                source.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    f0.m(segment8);
                    Segment segment9 = segment8.prev;
                    f0.m(segment9);
                    segment9.push(segment7).compact();
                }
                source.setSize$okio(source.size() - j5);
                setSize$okio(size() + j5);
                j4 -= j5;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}
