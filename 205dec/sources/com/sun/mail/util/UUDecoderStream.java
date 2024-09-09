package com.sun.mail.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
            int i4 = (charAt - ' ') & 63;
            if (i4 == 0) {
                String readLine2 = this.lin.readLine();
                if (readLine2 != null && readLine2.regionMatches(true, 0, "end", 0, 3)) {
                    this.gotEnd = true;
                    return false;
                }
                throw new IOException("Missing End");
            } else if (readLine.length() >= (((i4 * 8) + 5) / 6) + 1) {
                int i5 = 1;
                while (this.bufsize < i4) {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    byte charAt2 = (byte) ((readLine.charAt(i6) - ' ') & 63);
                    byte[] bArr = this.buffer;
                    int i8 = this.bufsize;
                    int i9 = i8 + 1;
                    this.bufsize = i9;
                    bArr[i8] = (byte) (((((byte) ((readLine.charAt(i5) - ' ') & 63)) << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((charAt2 >>> 4) & 3));
                    if (i9 < i4) {
                        i5 = i7 + 1;
                        byte charAt3 = (byte) ((readLine.charAt(i7) - ' ') & 63);
                        byte[] bArr2 = this.buffer;
                        int i10 = this.bufsize;
                        this.bufsize = i10 + 1;
                        bArr2[i10] = (byte) (((charAt2 << 4) & 240) | ((charAt3 >>> 2) & 15));
                        charAt2 = charAt3;
                    } else {
                        i5 = i7;
                    }
                    if (this.bufsize < i4) {
                        int i11 = i5 + 1;
                        byte[] bArr3 = this.buffer;
                        int i12 = this.bufsize;
                        this.bufsize = i12 + 1;
                        bArr3[i12] = (byte) ((((byte) ((readLine.charAt(i5) - ' ') & 63)) & 63) | ((charAt2 << 6) & 192));
                        i5 = i11;
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
        } catch (NumberFormatException e4) {
            throw new IOException("UUDecoder error: " + e4.toString());
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
        int i4 = this.index;
        this.index = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        while (i6 < i5) {
            int read = read();
            if (read == -1) {
                if (i6 == 0) {
                    return -1;
                }
                return i6;
            }
            bArr[i4 + i6] = (byte) read;
            i6++;
        }
        return i6;
    }
}
