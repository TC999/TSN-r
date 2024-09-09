package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f implements Iterable<String> {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f51797a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f51798b;

    public f() {
        this.f51797a = null;
        this.f51798b = null;
        this.f51797a = new ConcurrentLinkedQueue<>();
        this.f51798b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f51797a.add(str);
        return this.f51798b.addAndGet(length);
    }

    public void b() {
        this.f51797a.clear();
        this.f51798b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f51797a.iterator();
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i4 = length;
        int i5 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i6 = 0;
            while (length2 > 0) {
                int i7 = i4 > length2 ? length2 : i4;
                int i8 = i6 + i7;
                next.getChars(i6, i8, cArr, i5);
                i4 -= i7;
                i5 += i7;
                length2 -= i7;
                if (i4 == 0) {
                    try {
                        writer.write(cArr, 0, length);
                    } catch (Exception unused) {
                    }
                    i4 = length;
                    i6 = i8;
                    i5 = 0;
                } else {
                    i6 = i8;
                }
            }
        }
        if (i5 > 0) {
            try {
                writer.write(cArr, 0, i5);
            } catch (Exception unused2) {
            }
        }
        try {
            writer.flush();
        } catch (Exception unused3) {
        }
    }

    public int a() {
        return this.f51798b.get();
    }
}
