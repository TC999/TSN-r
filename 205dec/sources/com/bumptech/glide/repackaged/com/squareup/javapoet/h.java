package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;

/* compiled from: LineWrapper.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class h {

    /* renamed from: a  reason: collision with root package name */
    private final Appendable f17810a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17811b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17812c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17813d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f17814e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    private int f17815f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f17816g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Appendable appendable, String str, int i4) {
        n.c(appendable, "out == null", new Object[0]);
        this.f17810a = appendable;
        this.f17811b = str;
        this.f17812c = i4;
    }

    private void b(boolean z3) throws IOException {
        int i4;
        if (z3) {
            this.f17810a.append('\n');
            int i5 = 0;
            while (true) {
                i4 = this.f17816g;
                if (i5 >= i4) {
                    break;
                }
                this.f17810a.append(this.f17811b);
                i5++;
            }
            int length = i4 * this.f17811b.length();
            this.f17815f = length;
            this.f17815f = length + this.f17814e.length();
        } else {
            this.f17810a.append(' ');
        }
        this.f17810a.append(this.f17814e);
        StringBuilder sb = this.f17814e;
        sb.delete(0, sb.length());
        this.f17816g = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) throws IOException {
        int length;
        if (!this.f17813d) {
            if (this.f17816g != -1) {
                int indexOf = str.indexOf(10);
                if (indexOf == -1 && this.f17815f + str.length() <= this.f17812c) {
                    this.f17814e.append(str);
                    this.f17815f += str.length();
                    return;
                }
                b(indexOf == -1 || this.f17815f + indexOf > this.f17812c);
            }
            this.f17810a.append(str);
            int lastIndexOf = str.lastIndexOf(10);
            if (lastIndexOf != -1) {
                length = (str.length() - lastIndexOf) - 1;
            } else {
                length = str.length() + this.f17815f;
            }
            this.f17815f = length;
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4) throws IOException {
        if (!this.f17813d) {
            if (this.f17816g != -1) {
                b(false);
            }
            this.f17815f++;
            this.f17816g = i4;
            return;
        }
        throw new IllegalStateException("closed");
    }
}
