package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13045f implements Iterable<String> {

    /* renamed from: a */
    private ConcurrentLinkedQueue<String> f37397a;

    /* renamed from: b */
    private AtomicInteger f37398b;

    public C13045f() {
        this.f37397a = null;
        this.f37398b = null;
        this.f37397a = new ConcurrentLinkedQueue<>();
        this.f37398b = new AtomicInteger(0);
    }

    /* renamed from: a */
    public int m15070a(String str) {
        int length = str.length();
        this.f37397a.add(str);
        return this.f37398b.addAndGet(length);
    }

    /* renamed from: b */
    public void m15069b() {
        this.f37397a.clear();
        this.f37398b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f37397a.iterator();
    }

    /* renamed from: a */
    public void m15071a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i = length;
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i3 = 0;
            while (length2 > 0) {
                int i4 = i > length2 ? length2 : i;
                int i5 = i3 + i4;
                next.getChars(i3, i5, cArr, i2);
                i -= i4;
                i2 += i4;
                length2 -= i4;
                if (i == 0) {
                    try {
                        writer.write(cArr, 0, length);
                    } catch (Exception unused) {
                    }
                    i = length;
                    i3 = i5;
                    i2 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        if (i2 > 0) {
            try {
                writer.write(cArr, 0, i2);
            } catch (Exception unused2) {
            }
        }
        try {
            writer.flush();
        } catch (Exception unused3) {
        }
    }

    /* renamed from: a */
    public int m15072a() {
        return this.f37398b.get();
    }
}
