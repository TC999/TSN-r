package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import okio.Utf8;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UUEncoderStream extends FilterOutputStream {
    private byte[] buffer;
    private int bufsize;
    protected int mode;
    protected String name;
    private boolean wrotePrefix;

    public UUEncoderStream(OutputStream outputStream) {
        this(outputStream, "encoder.buf", 644);
    }

    private void encode() throws IOException {
        int i;
        byte b;
        ((FilterOutputStream) this).out.write((this.bufsize & 63) + 32);
        int i2 = 0;
        while (true) {
            int i3 = this.bufsize;
            if (i2 >= i3) {
                ((FilterOutputStream) this).out.write(10);
                return;
            }
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            byte b3 = 1;
            if (i4 < i3) {
                int i5 = i4 + 1;
                byte b4 = bArr[i4];
                if (i5 < i3) {
                    i = i5 + 1;
                    b = bArr[i5];
                    b3 = b4;
                    int i6 = ((b2 << 4) & 48) | ((b3 >>> 4) & 15);
                    int i7 = ((b3 << 2) & 60) | ((b >>> 6) & 3);
                    int i8 = b & Utf8.REPLACEMENT_BYTE;
                    ((FilterOutputStream) this).out.write(((b2 >>> 2) & 63) + 32);
                    ((FilterOutputStream) this).out.write(i6 + 32);
                    ((FilterOutputStream) this).out.write(i7 + 32);
                    ((FilterOutputStream) this).out.write(i8 + 32);
                    i2 = i;
                } else {
                    b3 = b4;
                    i = i5;
                }
            } else {
                i = i4;
            }
            b = 1;
            int i62 = ((b2 << 4) & 48) | ((b3 >>> 4) & 15);
            int i72 = ((b3 << 2) & 60) | ((b >>> 6) & 3);
            int i82 = b & Utf8.REPLACEMENT_BYTE;
            ((FilterOutputStream) this).out.write(((b2 >>> 2) & 63) + 32);
            ((FilterOutputStream) this).out.write(i62 + 32);
            ((FilterOutputStream) this).out.write(i72 + 32);
            ((FilterOutputStream) this).out.write(i82 + 32);
            i2 = i;
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

    public void setNameMode(String str, int i) {
        this.name = str;
        this.mode = i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public UUEncoderStream(OutputStream outputStream, String str) {
        this(outputStream, str, 644);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public UUEncoderStream(OutputStream outputStream, String str, int i) {
        super(outputStream);
        this.bufsize = 0;
        this.wrotePrefix = false;
        this.name = str;
        this.mode = i;
        this.buffer = new byte[45];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.bufsize;
        int i3 = i2 + 1;
        this.bufsize = i3;
        bArr[i2] = (byte) i;
        if (i3 == 45) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
    }
}
