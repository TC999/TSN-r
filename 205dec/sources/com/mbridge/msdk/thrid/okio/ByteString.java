package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
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
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = of(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    static int codePointIndexToCharIndex(String str, int i4) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            if (i6 == i4) {
                return i5;
            }
            int codePointAt = str.codePointAt(i5);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i6++;
            i5 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str != null) {
            byte[] decode = Base64.decode(str);
            if (decode != null) {
                return new ByteString(decode);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static ByteString decodeHex(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = i4 * 2;
                    bArr[i4] = (byte) ((decodeHexDigit(str.charAt(i5)) << 4) + decodeHexDigit(str.charAt(i5 + 1)));
                }
                return of(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    private static int decodeHexDigit(char c4) {
        if (c4 < '0' || c4 > '9') {
            char c5 = 'a';
            if (c4 < 'a' || c4 > 'f') {
                c5 = 'A';
                if (c4 < 'A' || c4 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c4);
                }
            }
            return (c4 - c5) + 10;
        }
        return c4 - '0';
    }

    private ByteString digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        }
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str != null) {
            if (charset != null) {
                return new ByteString(str.getBytes(charset));
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
            byteString.utf8 = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(mac.doFinal(this.data));
        } catch (InvalidKeyException e4) {
            throw new IllegalArgumentException(e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new AssertionError(e5);
        }
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString read(InputStream inputStream, int i4) throws IOException {
        if (inputStream != null) {
            if (i4 >= 0) {
                byte[] bArr = new byte[i4];
                int i5 = 0;
                while (i5 < i4) {
                    int read = inputStream.read(bArr, i5, i4 - i5);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i5 += read;
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException("byteCount < 0: " + i4);
        }
        throw new IllegalArgumentException("in == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return Base64.encode(this.data);
    }

    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i4) {
        return this.data[i4];
    }

    public int hashCode() {
        int i4 = this.hashCode;
        if (i4 != 0) {
            return i4;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.hashCode = hashCode;
        return hashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i4] = cArr2[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] internalArray() {
        return this.data;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public ByteString md5() {
        return digest("MD5");
    }

    public boolean rangeEquals(int i4, ByteString byteString, int i5, int i6) {
        return byteString.rangeEquals(i5, this.data, i4, i6);
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    public int size() {
        return this.data.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i4) {
        return substring(i4, this.data.length);
    }

    public ByteString toAsciiLowercase() {
        int i4 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i4 >= bArr.length) {
                return this;
            }
            byte b4 = bArr[i4];
            if (b4 >= 65 && b4 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i4] = (byte) (b4 + 32);
                for (int i5 = i4 + 1; i5 < bArr2.length; i5++) {
                    byte b5 = bArr2[i5];
                    if (b5 >= 65 && b5 <= 90) {
                        bArr2[i5] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i4++;
        }
    }

    public ByteString toAsciiUppercase() {
        int i4 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i4 >= bArr.length) {
                return this;
            }
            byte b4 = bArr[i4];
            if (b4 >= 97 && b4 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i4] = (byte) (b4 - 32);
                for (int i5 = i4 + 1; i5 < bArr2.length; i5++) {
                    byte b5 = bArr2[i5];
                    if (b5 >= 97 && b5 <= 122) {
                        bArr2[i5] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i4++;
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        StringBuilder sb;
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf8 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf8, 64);
        if (codePointIndexToCharIndex == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + hex() + "]";
            }
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "\u2026]";
        }
        String replace = utf8.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (codePointIndexToCharIndex < utf8.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.data.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("\u2026]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, Util.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i4 = 0; i4 < min; i4++) {
            int i5 = getByte(i4) & 255;
            int i6 = byteString.getByte(i4) & 255;
            if (i5 != i6) {
                return i5 < i6 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString, int i4) {
        return indexOf(byteString.internalArray(), i4);
    }

    public final int lastIndexOf(ByteString byteString, int i4) {
        return lastIndexOf(byteString.internalArray(), i4);
    }

    public boolean rangeEquals(int i4, byte[] bArr, int i5, int i6) {
        if (i4 >= 0) {
            byte[] bArr2 = this.data;
            if (i4 <= bArr2.length - i6 && i5 >= 0 && i5 <= bArr.length - i6 && Util.arrayRangeEquals(bArr2, i4, bArr, i5, i6)) {
                return true;
            }
        }
        return false;
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public ByteString substring(int i4, int i5) {
        if (i4 >= 0) {
            byte[] bArr = this.data;
            if (i5 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
            }
            int i6 = i5 - i4;
            if (i6 >= 0) {
                if (i4 == 0 && i5 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i4, bArr2, 0, i6);
                return new ByteString(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public static ByteString of(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            Util.checkOffsetAndCount(bArr.length, i4, i5);
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i4, bArr2, 0, i5);
            return new ByteString(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        byte[] bArr = this.data;
        buffer.write(bArr, 0, bArr.length);
    }

    public int indexOf(byte[] bArr, int i4) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i4, 0); max <= length; max++) {
            if (Util.arrayRangeEquals(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i4) {
        for (int min = Math.min(i4, this.data.length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }
}
