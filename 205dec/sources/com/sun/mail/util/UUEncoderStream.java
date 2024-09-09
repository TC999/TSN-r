package com.sun.mail.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UUEncoderStream extends FilterOutputStream {
    private byte[] buffer;
    private int bufsize;
    protected int mode;
    protected String name;
    private boolean wrotePrefix;

    public UUEncoderStream(OutputStream outputStream) {
        this(outputStream, "encoder.buf", MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS);
    }

    private void encode() throws IOException {
        int i4;
        byte b4;
        ((FilterOutputStream) this).out.write((this.bufsize & 63) + 32);
        int i5 = 0;
        while (true) {
            int i6 = this.bufsize;
            if (i5 >= i6) {
                ((FilterOutputStream) this).out.write(10);
                return;
            }
            byte[] bArr = this.buffer;
            int i7 = i5 + 1;
            byte b5 = bArr[i5];
            byte b6 = 1;
            if (i7 < i6) {
                int i8 = i7 + 1;
                byte b7 = bArr[i7];
                if (i8 < i6) {
                    i4 = i8 + 1;
                    b4 = bArr[i8];
                    b6 = b7;
                    int i9 = ((b5 << 4) & 48) | ((b6 >>> 4) & 15);
                    ((FilterOutputStream) this).out.write(((b5 >>> 2) & 63) + 32);
                    ((FilterOutputStream) this).out.write(i9 + 32);
                    ((FilterOutputStream) this).out.write((((b6 << 2) & 60) | ((b4 >>> 6) & 3)) + 32);
                    ((FilterOutputStream) this).out.write((b4 & 63) + 32);
                    i5 = i4;
                } else {
                    b6 = b7;
                    i4 = i8;
                }
            } else {
                i4 = i7;
            }
            b4 = 1;
            int i92 = ((b5 << 4) & 48) | ((b6 >>> 4) & 15);
            ((FilterOutputStream) this).out.write(((b5 >>> 2) & 63) + 32);
            ((FilterOutputStream) this).out.write(i92 + 32);
            ((FilterOutputStream) this).out.write((((b6 << 2) & 60) | ((b4 >>> 6) & 3)) + 32);
            ((FilterOutputStream) this).out.write((b4 & 63) + 32);
            i5 = i4;
        }
    }

    private void writePrefix() throws IOException {
        if (this.wrotePrefix) {
            return;
        }
        PrintStream printStream = new PrintStream(((FilterOutputStream) this).out);
        printStream.println("begin " + this.mode + " " + this.name);
        printStream.flush();
        this.wrotePrefix = true;
    }

    private void writeSuffix() throws IOException {
        PrintStream printStream = new PrintStream(((FilterOutputStream) this).out);
        printStream.println(" \nend");
        printStream.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.bufsize > 0) {
            writePrefix();
            encode();
        }
        writeSuffix();
        ((FilterOutputStream) this).out.flush();
    }

    public void setNameMode(String str, int i4) {
        this.name = str;
        this.mode = i4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        for (int i6 = 0; i6 < i5; i6++) {
            write(bArr[i4 + i6]);
        }
    }

    public UUEncoderStream(OutputStream outputStream, String str) {
        this(outputStream, str, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public UUEncoderStream(OutputStream outputStream, String str, int i4) {
        super(outputStream);
        this.bufsize = 0;
        this.wrotePrefix = false;
        this.name = str;
        this.mode = i4;
        this.buffer = new byte[45];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        byte[] bArr = this.buffer;
        int i5 = this.bufsize;
        int i6 = i5 + 1;
        this.bufsize = i6;
        bArr[i5] = (byte) i4;
        if (i6 == 45) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
    }
}
