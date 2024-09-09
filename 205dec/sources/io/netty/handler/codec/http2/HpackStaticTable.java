package io.netty.handler.codec.http2;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.util.AsciiString;
import java.util.Arrays;
import java.util.List;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class HpackStaticTable {
    private static final CharSequenceMap<Integer> STATIC_INDEX_BY_NAME;
    private static final List<HpackHeaderField> STATIC_TABLE;
    static final int length;

    static {
        List<HpackHeaderField> asList = Arrays.asList(newEmptyHeaderField(":authority"), newHeaderField(":method", "GET"), newHeaderField(":method", "POST"), newHeaderField(":path", TTPathConst.sSeparator), newHeaderField(":path", "/index.html"), newHeaderField(":scheme", "http"), newHeaderField(":scheme", "https"), newHeaderField(":status", "200"), newHeaderField(":status", "204"), newHeaderField(":status", "206"), newHeaderField(":status", "304"), newHeaderField(":status", "400"), newHeaderField(":status", "404"), newHeaderField(":status", "500"), newEmptyHeaderField("accept-charset"), newHeaderField("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField("accept"), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField("allow"), newEmptyHeaderField("authorization"), newEmptyHeaderField("cache-control"), newEmptyHeaderField("content-disposition"), newEmptyHeaderField("content-encoding"), newEmptyHeaderField("content-language"), newEmptyHeaderField("content-length"), newEmptyHeaderField("content-location"), newEmptyHeaderField("content-range"), newEmptyHeaderField("content-type"), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField(DownloadModel.ETAG), newEmptyHeaderField("expect"), newEmptyHeaderField("expires"), newEmptyHeaderField("from"), newEmptyHeaderField("host"), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField("if-none-match"), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField("location"), newEmptyHeaderField("max-forwards"), newEmptyHeaderField("proxy-authenticate"), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField("range"), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField("user-agent"), newEmptyHeaderField("vary"), newEmptyHeaderField("via"), newEmptyHeaderField("www-authenticate"));
        STATIC_TABLE = asList;
        STATIC_INDEX_BY_NAME = createMap();
        length = asList.size();
    }

    private HpackStaticTable() {
    }

    private static CharSequenceMap<Integer> createMap() {
        int size = STATIC_TABLE.size();
        CharSequenceMap<Integer> charSequenceMap = new CharSequenceMap<>(true, UnsupportedValueConverter.instance(), size);
        while (size > 0) {
            charSequenceMap.set((CharSequenceMap<Integer>) getEntry(size).name, (CharSequence) Integer.valueOf(size));
            size--;
        }
        return charSequenceMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HpackHeaderField getEntry(int i4) {
        return STATIC_TABLE.get(i4 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIndex(CharSequence charSequence) {
        Integer num = STATIC_INDEX_BY_NAME.get(charSequence);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private static HpackHeaderField newEmptyHeaderField(String str) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(String str, String str2) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.cached(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIndex(CharSequence charSequence, CharSequence charSequence2) {
        int index = getIndex(charSequence);
        if (index == -1) {
            return -1;
        }
        while (index <= length) {
            HpackHeaderField entry = getEntry(index);
            if (HpackUtil.equalsConstantTime(charSequence, entry.name) == 0) {
                break;
            } else if (HpackUtil.equalsConstantTime(charSequence2, entry.value) != 0) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
}
