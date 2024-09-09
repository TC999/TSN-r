package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Headers;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Reader(int i4, Source source) {
            this(i4, i4, source);
        }

        private void adjustDynamicTableByteCount() {
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

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i4) {
            return this.nextHeaderIndex + 1 + i4;
        }

        private int evictToRecoverBytes(int i4) {
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
                    Header[] headerArr = this.dynamicTable;
                    i4 -= headerArr[length].hpackSize;
                    this.dynamicTableByteCount -= headerArr[length].hpackSize;
                    this.headerCount--;
                    i6++;
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i5 + 1, headerArr2, i5 + 1 + i6, this.headerCount);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private ByteString getName(int i4) throws IOException {
            if (isStaticHeader(i4)) {
                return Hpack.STATIC_HEADER_TABLE[i4].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i4 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private void insertIntoDynamicTable(int i4, Header header) {
            this.headerList.add(header);
            int i5 = header.hpackSize;
            if (i4 != -1) {
                i5 -= this.dynamicTable[dynamicTableIndex(i4)].hpackSize;
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

        private boolean isStaticHeader(int i4) {
            return i4 >= 0 && i4 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i4) throws IOException {
            if (isStaticHeader(i4)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i4]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i4 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i4) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i4), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i4) throws IOException {
            this.headerList.add(new Header(getName(i4), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z3 = (readByte & 128) == 128;
            int readInt = readInt(readByte, 127);
            if (z3) {
                return ByteString.of(Huffman.get().decode(this.source.readByteArray(readInt)));
            }
            return this.source.readByteString(readInt);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int readByte = this.source.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    readIndexedHeader(readInt(readByte, 127) - 1);
                } else if (readByte == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((readByte & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int readInt = readInt(readByte, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt >= 0 && readInt <= this.headerTableSizeSetting) {
                        adjustDynamicTableByteCount();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(readByte, 15) - 1);
                } else {
                    readLiteralHeaderWithoutIndexingNewName();
                }
            }
        }

        int readInt(int i4, int i5) throws IOException {
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

        Reader(int i4, int i5, Source source) {
            this.headerList = new ArrayList();
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i4;
            this.maxDynamicTableByteCount = i5;
            this.source = Okio.buffer(source);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
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

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i4) {
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
                    Header[] headerArr = this.dynamicTable;
                    i4 -= headerArr[length].hpackSize;
                    this.dynamicTableByteCount -= headerArr[length].hpackSize;
                    this.headerCount--;
                    i6++;
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i5 + 1, headerArr2, i5 + 1 + i6, this.headerCount);
                Header[] headerArr3 = this.dynamicTable;
                int i7 = this.nextHeaderIndex;
                Arrays.fill(headerArr3, i7 + 1, i7 + 1 + i6, (Object) null);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private void insertIntoDynamicTable(Header header) {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setHeaderTableSizeSetting(int i4) {
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

        void writeByteString(ByteString byteString) throws IOException {
            if (this.useCompression && Huffman.get().encodedLength(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                Huffman.get().encode(byteString, buffer);
                ByteString readByteString = buffer.readByteString();
                writeInt(readByteString.size(), 127, 128);
                this.out.write(readByteString);
                return;
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeHeaders(List<Header> list) throws IOException {
            int i4;
            int i5;
            if (this.emitDynamicTableSizeUpdate) {
                int i6 = this.smallestHeaderTableSizeSetting;
                if (i6 < this.maxDynamicTableByteCount) {
                    writeInt(i6, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                Header header = list.get(i7);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    i4 = num.intValue() + 1;
                    if (i4 > 1 && i4 < 8) {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Util.equal(headerArr[i4 - 1].value, byteString)) {
                            i5 = i4;
                        } else if (Util.equal(headerArr[i4].value, byteString)) {
                            i5 = i4;
                            i4++;
                        }
                    }
                    i5 = i4;
                    i4 = -1;
                } else {
                    i4 = -1;
                    i5 = -1;
                }
                if (i4 == -1) {
                    int i8 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i8 >= length) {
                            break;
                        }
                        if (Util.equal(this.dynamicTable[i8].name, asciiLowercase)) {
                            if (Util.equal(this.dynamicTable[i8].value, byteString)) {
                                i4 = Hpack.STATIC_HEADER_TABLE.length + (i8 - this.nextHeaderIndex);
                                break;
                            } else if (i5 == -1) {
                                i5 = (i8 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                        i8++;
                    }
                }
                if (i4 != -1) {
                    writeInt(i4, 127, 128);
                } else if (i5 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX) && !Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    writeInt(i5, 15, 0);
                    writeByteString(byteString);
                } else {
                    writeInt(i5, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                }
            }
        }

        void writeInt(int i4, int i5, int i6) {
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

        Writer(int i4, boolean z3, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i4;
            this.maxDynamicTableByteCount = i4;
            this.useCompression = z3;
            this.out = buffer;
        }
    }

    static {
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, TTPathConst.sSeparator), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i4 = 0; i4 < size; i4++) {
            byte b4 = byteString.getByte(i4);
            if (b4 >= 65 && b4 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i4 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i4 < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i4].name)) {
                    linkedHashMap.put(headerArr[i4].name, Integer.valueOf(i4));
                }
                i4++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}
