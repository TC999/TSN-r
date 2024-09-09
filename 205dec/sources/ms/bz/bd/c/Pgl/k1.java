package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class k1 {

    /* renamed from: c  reason: collision with root package name */
    private static k1 f61406c;

    /* renamed from: a  reason: collision with root package name */
    private Context f61407a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f61408b = new ArrayList();

    private k1(Context context) {
        this.f61407a = null;
        this.f61407a = context;
    }

    public static k1 b(Context context) {
        if (f61406c == null) {
            synchronized (k1.class) {
                if (f61406c == null) {
                    f61406c = new k1(context);
                }
            }
        }
        return f61406c;
    }

    public int a() {
        Intent registerReceiver = this.f61407a.registerReceiver(null, new IntentFilter((String) pblk.a(16777217, 0, 0L, "26d3a9", new byte[]{34, 58, 19, 85, 81, 39, 53, 89, 60, 109, 55, 49, 25, 83, 16, 47, 50, 3, 60, 108, 45, 122, 53, 102, 106, 26, 20, 37, 12, 92, 0, 28, 54, 105, 121, 11, 21})));
        if (registerReceiver == null) {
            return -1;
        }
        return Math.round(((registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0L, "6e30d4", new byte[]{43, 98, 86, 65, 87}), -1) / registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0L, "d58ce4", new byte[]{102, 52, 74, 27, 95}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public void c() {
        int i4;
        int f4;
        int a4;
        try {
            synchronized (this) {
                f4 = f();
                a4 = a();
            }
            i4 = (f4 * 10000) + a4;
        } catch (Exception unused) {
            i4 = -10001;
        }
        Integer valueOf = Integer.valueOf(i4);
        if (valueOf == null) {
            return;
        }
        this.f61408b.add(valueOf);
        try {
            int size = this.f61408b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f61408b.subList(size - 10, size));
                this.f61408b.clear();
                this.f61408b = arrayList;
            }
        } catch (Throwable unused2) {
        }
    }

    public synchronized int[] d() {
        int size = this.f61408b.size();
        if (size <= 0) {
            return new int[0];
        } else if (size == 1) {
            return new int[]{this.f61408b.get(0).intValue()};
        } else {
            List<Integer> list = this.f61408b;
            int i4 = size - 10;
            if (i4 <= 0) {
                i4 = 0;
            }
            List<Integer> subList = list.subList(i4, size);
            int[] iArr = new int[subList.size()];
            for (int i5 = 0; i5 < subList.size(); i5++) {
                iArr[i5] = subList.get(i5).intValue();
            }
            return iArr;
        }
    }

    public int e() {
        Intent registerReceiver = this.f61407a.registerReceiver(null, new IntentFilter((String) pblk.a(16777217, 0, 0L, "5deea0", new byte[]{37, 104, 18, 3, 81, 46, 50, 11, 61, 59, 48, 99, 24, 5, 16, 38, 53, 81, 61, 58, 42, 40, 52, 48, 106, 19, 19, 119, 13, 10, 7, 78, 55, 63, 121, 2, 18})));
        if (registerReceiver == null) {
            return -1;
        }
        int intExtra = registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0L, "6eadbd", new byte[]{52, 115, 19, 4, 72, 96}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public int f() {
        Intent registerReceiver = this.f61407a.registerReceiver(null, new IntentFilter((String) pblk.a(16777217, 0, 0L, "53f9df", new byte[]{37, 63, 17, 95, 84, 120, 50, 92, 62, 103, 48, 52, 27, 89, 21, 112, 53, 6, 62, 102, 42, Byte.MAX_VALUE, 55, 108, 111, 69, 19, 32, 14, 86, 7, 25, 52, 99, 124, 84, 18})));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0L, "67e977", new byte[]{55, 57, 3, 74, 15, 37, 49}), -1);
    }
}
