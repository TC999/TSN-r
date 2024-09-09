package okio;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
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
import kotlin.collections.o;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.d;
import kotlin.text.w;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ByteString.kt */
@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0016\u0018\u0000 b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001bB\u0011\b\u0000\u0012\u0006\u0010]\u001a\u000202\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nH\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0016J\u001f\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0000H\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\u001c\u0010&\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#H\u0017J\u0017\u0010+\u001a\u00020(2\u0006\u0010'\u001a\u00020#H\u0010\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010.\u001a\u00020(2\u0006\u0010,\u001a\u00020#H\u0087\u0002\u00a2\u0006\u0004\b-\u0010*J\u000f\u00101\u001a\u00020#H\u0010\u00a2\u0006\u0004\b/\u00100J\b\u00103\u001a\u000202H\u0016J\u000f\u00106\u001a\u000202H\u0010\u00a2\u0006\u0004\b4\u00105J\b\u00108\u001a\u000207H\u0016J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010\b\u001a\u000209H\u0016J'\u0010:\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0010\u00a2\u0006\u0004\b?\u0010@J(\u0010D\u001a\u00020C2\u0006\u0010=\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0016J(\u0010D\u001a\u00020C2\u0006\u0010=\u001a\u00020#2\u0006\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0016J\u000e\u0010F\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0000J\u000e\u0010F\u001a\u00020C2\u0006\u0010E\u001a\u000202J\u000e\u0010H\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0000J\u000e\u0010H\u001a\u00020C2\u0006\u0010G\u001a\u000202J\u001a\u0010J\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00002\b\b\u0002\u0010I\u001a\u00020#H\u0007J\u001a\u0010J\u001a\u00020#2\u0006\u0010A\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020#H\u0017J\u001a\u0010K\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00002\b\b\u0002\u0010I\u001a\u00020#H\u0007J\u001a\u0010K\u001a\u00020#2\u0006\u0010A\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020#H\u0017J\u0013\u0010M\u001a\u00020C2\b\u0010A\u001a\u0004\u0018\u00010LH\u0096\u0002J\b\u0010N\u001a\u00020#H\u0016J\u0011\u0010O\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0000H\u0096\u0002J\b\u0010P\u001a\u00020\nH\u0016J\u0017\u0010-\u001a\u00020(2\u0006\u0010,\u001a\u00020#H\u0007\u00a2\u0006\u0004\bQ\u0010*J\u000f\u0010S\u001a\u00020#H\u0007\u00a2\u0006\u0004\bR\u00100R\"\u0010N\u001a\u00020#8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010T\u001a\u0004\bU\u00100\"\u0004\bV\u0010WR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u0002028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u00105R\u0011\u0010S\u001a\u00020#8G\u00a2\u0006\u0006\u001a\u0004\bS\u00100\u00a8\u0006c"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "Lkotlin/f1;", "readObject", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "", "utf8", "Ljava/nio/charset/Charset;", "charset", "string", "base64", "md5", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", DomainCampaignEx.LOOPBACK_KEY, "hmacSha1", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "pos", "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", f3.f5657f, "getSize$okio", "()I", "getSize", "", "toByteArray", "internalArray$okio", "()[B", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "Ljava/io/OutputStream;", "write", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "prefix", "startsWith", "suffix", "endsWith", "fromIndex", "indexOf", "lastIndexOf", "", "equals", "hashCode", "compareTo", "toString", "-deprecated_getByte", "-deprecated_size", "size", "I", "getHashCode$okio", "setHashCode$okio", "(I)V", "Ljava/lang/String;", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "data", "[B", "getData$okio", "<init>", "([B)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    @NotNull
    private final byte[] data;
    private transient int hashCode;
    @Nullable
    private transient String utf8;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ByteString.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u00a2\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007\u00a2\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                charset = d.f58930b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = 0;
            }
            if ((i6 & 2) != 0) {
                i5 = bArr.length;
            }
            return companion.of(bArr, i4, i5);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @JvmName(name = "-deprecated_decodeBase64")
        @Nullable
        /* renamed from: -deprecated_decodeBase64  reason: not valid java name */
        public final ByteString m271deprecated_decodeBase64(@NotNull String string) {
            f0.p(string, "string");
            return decodeBase64(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        @NotNull
        /* renamed from: -deprecated_decodeHex  reason: not valid java name */
        public final ByteString m272deprecated_decodeHex(@NotNull String string) {
            f0.p(string, "string");
            return decodeHex(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        @NotNull
        /* renamed from: -deprecated_encodeString  reason: not valid java name */
        public final ByteString m273deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            f0.p(string, "string");
            f0.p(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        @NotNull
        /* renamed from: -deprecated_encodeUtf8  reason: not valid java name */
        public final ByteString m274deprecated_encodeUtf8(@NotNull String string) {
            f0.p(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m275deprecated_of(@NotNull ByteBuffer buffer) {
            f0.p(buffer, "buffer");
            return of(buffer);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        @NotNull
        /* renamed from: -deprecated_read  reason: not valid java name */
        public final ByteString m277deprecated_read(@NotNull InputStream inputstream, int i4) {
            f0.p(inputstream, "inputstream");
            return read(inputstream, i4);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String decodeBase64) {
            f0.p(decodeBase64, "$this$decodeBase64");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(decodeBase64);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String decodeHex) {
            f0.p(decodeHex, "$this$decodeHex");
            if (decodeHex.length() % 2 == 0) {
                int length = decodeHex.length() / 2;
                byte[] bArr = new byte[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = i4 * 2;
                    bArr[i4] = (byte) ((ByteStringKt.access$decodeHexDigit(decodeHex.charAt(i5)) << 4) + ByteStringKt.access$decodeHexDigit(decodeHex.charAt(i5 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        @NotNull
        public final ByteString encodeString(@NotNull String encode, @NotNull Charset charset) {
            f0.p(encode, "$this$encode");
            f0.p(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String encodeUtf8) {
            f0.p(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(encodeUtf8));
            byteString.setUtf8$okio(encodeUtf8);
            return byteString;
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull ByteBuffer toByteString) {
            f0.p(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "read")
        @NotNull
        public final ByteString read(@NotNull InputStream readByteString, int i4) throws IOException {
            f0.p(readByteString, "$this$readByteString");
            int i5 = 0;
            if (i4 >= 0) {
                byte[] bArr = new byte[i4];
                while (i5 < i4) {
                    int read = readByteString.read(bArr, i5, i4 - i5);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i5 += read;
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i4).toString());
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m276deprecated_of(@NotNull byte[] array, int i4, int i5) {
            f0.p(array, "array");
            return of(array, i4, i5);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... data) {
            f0.p(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull byte[] toByteString, int i4, int i5) {
            byte[] G1;
            f0.p(toByteString, "$this$toByteString");
            Util.checkOffsetAndCount(toByteString.length, i4, i5);
            G1 = o.G1(toByteString, i4, i5 + i4);
            return new ByteString(G1);
        }
    }

    public ByteString(@NotNull byte[] data) {
        f0.p(data, "data");
        this.data = data;
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return Companion.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return Companion.decodeHex(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i4 = 0;
            }
            return byteString.indexOf(byteString2, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i4 = 0;
            }
            return byteString.indexOf(bArr, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i4 = byteString.size();
            }
            return byteString.lastIndexOf(byteString2, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i4 = byteString.size();
            }
            return byteString.lastIndexOf(bArr, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return Companion.of(bArr);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i4, int i5) {
        return Companion.of(bArr, i4, i5);
    }

    @JvmStatic
    @JvmName(name = "read")
    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i4) throws IOException {
        return Companion.read(inputStream, i4);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field field = ByteString.class.getDeclaredField("data");
        f0.o(field, "field");
        field.setAccessible(true);
        field.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i4, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                i4 = 0;
            }
            if ((i6 & 2) != 0) {
                i5 = byteString.size();
            }
            return byteString.substring(i4, i5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m269deprecated_getByte(int i4) {
        return getByte(i4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m270deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        f0.o(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        f0.p(algorithm, "algorithm");
        byte[] digest = MessageDigest.getInstance(algorithm).digest(this.data);
        f0.o(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        f0.p(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int i4) {
        return internalGet$okio(i4);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public String hex() {
        byte[] data$okio;
        char[] cArr = new char[getData$okio().length * 2];
        int i4 = 0;
        for (byte b4 : getData$okio()) {
            int i5 = i4 + 1;
            cArr[i4] = ByteStringKt.getHEX_DIGIT_CHARS()[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = ByteStringKt.getHEX_DIGIT_CHARS()[b4 & 15];
        }
        return new String(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        f0.p(algorithm, "algorithm");
        f0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            f0.o(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        f0.p(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        f0.p(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        f0.p(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other, int i4) {
        f0.p(other, "other");
        return indexOf(other.internalArray$okio(), i4);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i4) {
        return getData$okio()[i4];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other, int i4) {
        f0.p(other, "other");
        return lastIndexOf(other.internalArray$okio(), i4);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i4, @NotNull ByteString other, int i5, int i6) {
        f0.p(other, "other");
        return other.rangeEquals(i5, getData$okio(), i4, i6);
    }

    public final void setHashCode$okio(int i4) {
        this.hashCode = i4;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        f0.p(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        f0.p(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int i4) {
        return substring$default(this, i4, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int i4, int i5) {
        byte[] G1;
        if (i4 >= 0) {
            if (!(i5 <= getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
            if (i5 - i4 >= 0) {
                if (i4 == 0 && i5 == getData$okio().length) {
                    return this;
                }
                G1 = o.G1(getData$okio(), i4, i5);
                return new ByteString(G1);
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b4;
        for (int i4 = 0; i4 < getData$okio().length; i4++) {
            byte b5 = getData$okio()[i4];
            byte b6 = (byte) 65;
            if (b5 >= b6 && b5 <= (b4 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i4] = (byte) (b5 + 32);
                for (int i5 = i4 + 1; i5 < copyOf.length; i5++) {
                    byte b7 = copyOf[i5];
                    if (b7 >= b6 && b7 <= b4) {
                        copyOf[i5] = (byte) (b7 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b4;
        for (int i4 = 0; i4 < getData$okio().length; i4++) {
            byte b5 = getData$okio()[i4];
            byte b6 = (byte) 97;
            if (b5 >= b6 && b5 <= (b4 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i4] = (byte) (b5 - 32);
                for (int i5 = i4 + 1; i5 < copyOf.length; i5++) {
                    byte b7 = copyOf[i5];
                    if (b7 >= b6 && b7 <= b4) {
                        copyOf[i5] = (byte) (b7 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public String toString() {
        String k22;
        String k23;
        String k24;
        ByteString byteString;
        byte[] G1;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
        if (access$codePointIndexToCharIndex == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(getData$okio().length);
            sb.append(" hex=");
            if (64 <= getData$okio().length) {
                if (64 == getData$okio().length) {
                    byteString = this;
                } else {
                    G1 = o.G1(getData$okio(), 0, 64);
                    byteString = new ByteString(G1);
                }
                sb.append(byteString.hex());
                sb.append("\u2026]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        String utf8 = utf8();
        if (utf8 != null) {
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            k22 = w.k2(substring, "\\", "\\\\", false, 4, null);
            k23 = w.k2(k22, "\n", "\\n", false, 4, null);
            k24 = w.k2(k23, "\r", "\\r", false, 4, null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + getData$okio().length + " text=" + k24 + "\u2026]";
            }
            return "[text=" + k24 + ']';
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = Platform.toUtf8String(internalArray$okio());
            setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    public void write(@NotNull OutputStream out) throws IOException {
        f0.p(out, "out");
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int i4, int i5) {
        f0.p(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.f0.p(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        f0.p(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] other, int i4) {
        f0.p(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i4, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] other, int i4) {
        f0.p(other, "other");
        for (int min = Math.min(i4, getData$okio().length - other.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i4, @NotNull byte[] other, int i5, int i6) {
        f0.p(other, "other");
        return i4 >= 0 && i4 <= getData$okio().length - i6 && i5 >= 0 && i5 <= other.length - i6 && Util.arrayRangeEquals(getData$okio(), i4, other, i5, i6);
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        f0.p(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }
}
