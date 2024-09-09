package okhttp3.internal.http2;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import xyz.adscope.common.network.Headers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Hpack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    @NotNull
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    @NotNull
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, TTPathConst.sSeparator), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i4].name)) {
                linkedHashMap.put(headerArr2[i4].name, Integer.valueOf(i4));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        f0.o(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString name) throws IOException {
        f0.p(name, "name");
        int size = name.size();
        for (int i4 = 0; i4 < size; i4++) {
            byte b4 = (byte) 65;
            byte b5 = (byte) 90;
            byte b6 = name.getByte(i4);
            if (b4 <= b6 && b5 >= b6) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Hpack.kt */
    @Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010$\u001a\u00020.\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0002J\u0016\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0010R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010*R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010*\u00a8\u00061"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "Lkotlin/f1;", "adjustDynamicTableByteCount", "clearDynamicTable", "", "bytesToRecover", "evictToRecoverBytes", "index", "readIndexedHeader", "dynamicTableIndex", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingIndexedName", "readLiteralHeaderWithIncrementalIndexingNewName", "Lokio/ByteString;", "getName", "", "isStaticHeader", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "readByte", "", "getAndResetHeaderList", "maxDynamicTableByteCount", "readHeaders", "firstByte", "prefixMask", "readInt", "readByteString", "", "headerList", "Ljava/util/List;", "Lokio/BufferedSource;", "source", "Lokio/BufferedSource;", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "I", "headerCount", "dynamicTableByteCount", "headerTableSizeSetting", "Lokio/Source;", "<init>", "(Lokio/Source;II)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Reader {
        @JvmField
        @NotNull
        public Header[] dynamicTable;
        @JvmField
        public int dynamicTableByteCount;
        @JvmField
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        @JvmOverloads
        public Reader(@NotNull Source source, int i4) {
            this(source, i4, 0, 4, null);
        }

        @JvmOverloads
        public Reader(@NotNull Source source, int i4, int i5) {
            f0.p(source, "source");
            this.headerTableSizeSetting = i4;
            this.maxDynamicTableByteCount = i5;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i4 = this.maxDynamicTableByteCount;
            int i5 = this.dynamicTableByteCount;
            if (i4 < i5) {
                if (i4 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i5 - i4);
                }
            }
        }

        private final void clearDynamicTable() {
            o.w2(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i4) {
            return this.nextHeaderIndex + 1 + i4;
        }

        private final int evictToRecoverBytes(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i5 = this.nextHeaderIndex;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    f0.m(header);
                    int i7 = header.hpackSize;
                    i4 -= i7;
                    this.dynamicTableByteCount -= i7;
                    this.headerCount--;
                    i6++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i6, this.headerCount);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private final ByteString getName(int i4) throws IOException {
            if (isStaticHeader(i4)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i4].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i4 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    f0.m(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private final void insertIntoDynamicTable(int i4, Header header) {
            this.headerList.add(header);
            int i5 = header.hpackSize;
            if (i4 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i4)];
                f0.m(header2);
                i5 -= header2.hpackSize;
            }
            int i6 = this.maxDynamicTableByteCount;
            if (i5 > i6) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i5) - i6);
            if (i4 == -1) {
                int i7 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i7 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i8 = this.nextHeaderIndex;
                this.nextHeaderIndex = i8 - 1;
                this.dynamicTable[i8] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i4 + dynamicTableIndex(i4) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i5;
        }

        private final boolean isStaticHeader(int i4) {
            return i4 >= 0 && i4 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i4) throws IOException {
            if (isStaticHeader(i4)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i4]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i4 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    f0.m(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i4) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i4), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i4) throws IOException {
            this.headerList.add(new Header(getName(i4), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            List<Header> G5;
            G5 = kotlin.collections.f0.G5(this.headerList);
            this.headerList.clear();
            return G5;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        @NotNull
        public final ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z3 = (readByte & 128) == 128;
            long readInt = readInt(readByte, 127);
            if (z3) {
                Buffer buffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, readInt, buffer);
                return buffer.readByteString();
            }
            return this.source.readByteString(readInt);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt >= 0 && readInt <= this.headerTableSizeSetting) {
                        adjustDynamicTableByteCount();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                } else if (and != 16 && and != 0) {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                } else {
                    readLiteralHeaderWithoutIndexingNewName();
                }
            }
        }

        public final int readInt(int i4, int i5) throws IOException {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i5 + (readByte << i7);
                }
                i5 += (readByte & 127) << i7;
                i7 += 7;
            }
        }

        public /* synthetic */ Reader(Source source, int i4, int i5, int i6, u uVar) {
            this(source, i4, (i6 & 4) != 0 ? i4 : i5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Hpack.kt */
    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0019\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0016\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "Lkotlin/f1;", "clearDynamicTable", "", "bytesToRecover", "evictToRecoverBytes", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "adjustDynamicTableByteCount", "", "headerBlock", "writeHeaders", "value", "prefixMask", "bits", "writeInt", "Lokio/ByteString;", "data", "writeByteString", "headerTableSizeSetting", "resizeHeaderTable", "smallestHeaderTableSizeSetting", "I", "", "emitDynamicTableSizeUpdate", "Z", "maxDynamicTableByteCount", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "useCompression", "Lokio/Buffer;", "out", "Lokio/Buffer;", "<init>", "(IZLokio/Buffer;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Writer {
        @JvmField
        @NotNull
        public Header[] dynamicTable;
        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        @JvmField
        public int headerCount;
        @JvmField
        public int headerTableSizeSetting;
        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        @JvmOverloads
        public Writer(int i4, @NotNull Buffer buffer) {
            this(i4, false, buffer, 2, null);
        }

        @JvmOverloads
        public Writer(int i4, boolean z3, @NotNull Buffer out) {
            f0.p(out, "out");
            this.headerTableSizeSetting = i4;
            this.useCompression = z3;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i4;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        @JvmOverloads
        public Writer(@NotNull Buffer buffer) {
            this(0, false, buffer, 3, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i4 = this.maxDynamicTableByteCount;
            int i5 = this.dynamicTableByteCount;
            if (i4 < i5) {
                if (i4 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i5 - i4);
                }
            }
        }

        private final void clearDynamicTable() {
            o.w2(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i5 = this.nextHeaderIndex;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    f0.m(header);
                    i4 -= header.hpackSize;
                    int i7 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    f0.m(header2);
                    this.dynamicTableByteCount = i7 - header2.hpackSize;
                    this.headerCount--;
                    i6++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i6, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i8 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i8 + 1, i8 + 1 + i6, (Object) null);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i4 = header.hpackSize;
            int i5 = this.maxDynamicTableByteCount;
            if (i4 > i5) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i4) - i5);
            int i6 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i6 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i7 = this.nextHeaderIndex;
            this.nextHeaderIndex = i7 - 1;
            this.dynamicTable[i7] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i4;
        }

        public final void resizeHeaderTable(int i4) {
            this.headerTableSizeSetting = i4;
            int min = Math.min(i4, 16384);
            int i5 = this.maxDynamicTableByteCount;
            if (i5 == min) {
                return;
            }
            if (min < i5) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(@NotNull ByteString data) throws IOException {
            f0.p(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(data, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(data.size(), 127, 0);
            this.out.write(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeHeaders(@org.jetbrains.annotations.NotNull java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 268
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i4, int i5, int i6) {
            if (i4 < i5) {
                this.out.writeByte(i4 | i6);
                return;
            }
            this.out.writeByte(i6 | i5);
            int i7 = i4 - i5;
            while (i7 >= 128) {
                this.out.writeByte(128 | (i7 & 127));
                i7 >>>= 7;
            }
            this.out.writeByte(i7);
        }

        public /* synthetic */ Writer(int i4, boolean z3, Buffer buffer, int i5, u uVar) {
            this((i5 & 1) != 0 ? 4096 : i4, (i5 & 2) != 0 ? true : z3, buffer);
        }
    }
}
