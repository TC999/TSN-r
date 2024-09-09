package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder add(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                    this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }

        public Builder addEncoded(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                    this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(@Nullable BufferedSink bufferedSink, boolean z3) {
        Buffer buffer;
        if (z3) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.encodedNames.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i4));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i4));
        }
        if (z3) {
            long size2 = buffer.size();
            buffer.clear();
            return size2;
        }
        return 0L;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i4) {
        return this.encodedNames.get(i4);
    }

    public String encodedValue(int i4) {
        return this.encodedValues.get(i4);
    }

    public String name(int i4) {
        return HttpUrl.percentDecode(encodedName(i4), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i4) {
        return HttpUrl.percentDecode(encodedValue(i4), true);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
