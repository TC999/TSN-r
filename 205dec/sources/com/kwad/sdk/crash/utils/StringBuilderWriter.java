package com.kwad.sdk.crash.utils;

import java.io.Serializable;
import java.io.Writer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = 4424285024471074820L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) {
        if (cArr != null) {
            this.builder.append(cArr, i4, i5);
        }
    }

    public StringBuilderWriter(int i4) {
        this.builder = new StringBuilder(i4);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) {
        this.builder.append(c4);
        return this;
    }

    public StringBuilderWriter(StringBuilder sb) {
        this.builder = sb == null ? new StringBuilder() : sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i4, int i5) {
        this.builder.append(charSequence, i4, i5);
        return this;
    }
}
