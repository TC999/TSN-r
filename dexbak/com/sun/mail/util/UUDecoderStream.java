package com.sun.mail.util;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import io.netty.handler.codec.http.HttpConstants;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import okio.Utf8;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize;
    private boolean gotEnd;
    private boolean gotPrefix;
    private int index;
    private LineInputStream lin;
    private int mode;
    private String name;

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.buffer = new byte[45];
    }

    private boolean decode() throws IOException {
        String readLine;
        if (this.gotEnd) {
            return false;
        }
        this.bufsize = 0;
        do {
            readLine = this.lin.readLine();
            if (readLine != null) {
                if (readLine.regionMatches(true, 0, "end", 0, 3)) {
                    this.gotEnd = true;
                    return false;
                }
            } else {
                throw new IOException("Missing End");
            }
        } while (readLine.length() == 0);
        char charAt = readLine.charAt(0);
        if (charAt >= ' ') {
            int i = (charAt - HttpConstants.SP_CHAR) & 63;
            if (i == 0) {
                String readLine2 = this.lin.readLine();
                if (readLine2 != null && readLine2.regionMatches(true, 0, "end", 0, 3)) {
                    this.gotEnd = true;
                    return false;
                }
                throw new IOException("Missing End");
            } else if (readLine.length() >= (((i * 8) + 5) / 6) + 1) {
                int i2 = 1;
                while (this.bufsize < i) {
                    int i3 = i2 + 1;
                    int i4 = i3 + 1;
                    byte charAt2 = (byte) ((readLine.charAt(i3) - HttpConstants.SP_CHAR) & 63);
                    byte[] bArr = this.buffer;
                    int i5 = this.bufsize;
                    int i6 = i5 + 1;
                    this.bufsize = i6;
                    bArr[i5] = (byte) (((((byte) ((readLine.charAt(i2) - HttpConstants.SP_CHAR) & 63)) << 2) & 252) | ((charAt2 >>> 4) & 3));
                    if (i6 < i) {
                        i2 = i4 + 1;
                        byte charAt3 = (byte) ((readLine.charAt(i4) - HttpConstants.SP_CHAR) & 63);
                        byte[] bArr2 = this.buffer;
                        int i7 = this.bufsize;
                        this.bufsize = i7 + 1;
                        bArr2[i7] = (byte) (((charAt2 << 4) & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) | ((charAt3 >>> 2) & 15));
                        charAt2 = charAt3;
                    } else {
                        i2 = i4;
                    }
                    if (this.bufsize < i) {
                        byte[] bArr3 = this.buffer;
                        int i8 = this.bufsize;
                        this.bufsize = i8 + 1;
                        bArr3[i8] = (byte) ((((byte) ((readLine.charAt(i2) - HttpConstants.SP_CHAR) & 63)) & Utf8.REPLACEMENT_BYTE) | ((charAt2 << 6) & Opcodes.CHECKCAST));
                        i2++;
                    }
                }
                return true;
            } else {
                throw new IOException("Short buffer error");
            }
        }
        throw new IOException("Buffer format error");
    }

    private void readPrefix() throws IOException {
        String readLine;
        if (this.gotPrefix) {
            return;
        }
        do {
            readLine = this.lin.readLine();
            if (readLine == null) {
                throw new IOException("UUDecoder error: No Begin");
            }
        } while (!readLine.regionMatches(true, 0, "begin", 0, 5));
        try {
            this.mode = Integer.parseInt(readLine.substring(6, 9));
            this.name = readLine.substring(10);
            this.gotPrefix = true;
        } catch (NumberFormatException e) {
            throw new IOException("UUDecoder error: " + e.toString());
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public int getMode() throws IOException {
        readPrefix();
        return this.mode;
    }

    public String getName() throws IOException {
        readPrefix();
        return this.name;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return bArr[i] & UByte.f41242c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i + i3] = (byte) read;
            i3++;
        }
        return i3;
    }
}
