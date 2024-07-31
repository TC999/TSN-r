package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QPDecoderStream extends FilterInputStream {

    /* renamed from: ba */
    protected byte[] f36236ba;
    protected int spaces;

    public QPDecoderStream(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 2));
        this.f36236ba = new byte[2];
        this.spaces = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i = this.spaces;
        if (i > 0) {
            this.spaces = i - 1;
            return 32;
        }
        int read2 = ((FilterInputStream) this).in.read();
        if (read2 == 32) {
            while (true) {
                read = ((FilterInputStream) this).in.read();
                if (read != 32) {
                    break;
                }
                this.spaces++;
            }
            if (read != 13 && read != 10 && read != -1) {
                ((PushbackInputStream) ((FilterInputStream) this).in).unread(read);
                return 32;
            }
            this.spaces = 0;
            return read;
        }
        if (read2 == 61) {
            int read3 = ((FilterInputStream) this).in.read();
            if (read3 == 10) {
                return read();
            }
            if (read3 == 13) {
                int read4 = ((FilterInputStream) this).in.read();
                if (read4 != 10) {
                    ((PushbackInputStream) ((FilterInputStream) this).in).unread(read4);
                }
                return read();
            } else if (read3 == -1) {
                return -1;
            } else {
                byte[] bArr = this.f36236ba;
                bArr[0] = (byte) read3;
                bArr[1] = (byte) ((FilterInputStream) this).in.read();
                try {
                    return ASCIIUtility.parseInt(this.f36236ba, 0, 2, 16);
                } catch (NumberFormatException unused) {
                    ((PushbackInputStream) ((FilterInputStream) this).in).unread(this.f36236ba);
                }
            }
        }
        return read2;
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
