package com.bytedance.adsdk.lottie.c.c;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.bytedance.adsdk.lottie.xv.w.gd;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements b, l {

    /* renamed from: d  reason: collision with root package name */
    private final String f25320d;

    /* renamed from: f  reason: collision with root package name */
    private final gd f25322f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25317a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25318b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f25319c = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final List<b> f25321e = new ArrayList();

    /* renamed from: com.bytedance.adsdk.lottie.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class C0349a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25323a;

        static {
            int[] iArr = new int[gd.c.values().length];
            f25323a = iArr;
            try {
                iArr[gd.c.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25323a[gd.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25323a[gd.c.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25323a[gd.c.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25323a[gd.c.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(gd gdVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f25320d = gdVar.b();
            this.f25322f = gdVar;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void f() {
        for (int i4 = 0; i4 < this.f25321e.size(); i4++) {
            this.f25319c.addPath(this.f25321e.get(i4).sr());
        }
    }

    @TargetApi(19)
    private void g(Path.Op op) {
        this.f25318b.reset();
        this.f25317a.reset();
        for (int size = this.f25321e.size() - 1; size >= 1; size--) {
            b bVar = this.f25321e.get(size);
            if (bVar instanceof o) {
                o oVar = (o) bVar;
                List<b> h4 = oVar.h();
                for (int size2 = h4.size() - 1; size2 >= 0; size2--) {
                    Path sr = h4.get(size2).sr();
                    sr.transform(oVar.i());
                    this.f25318b.addPath(sr);
                }
            } else {
                this.f25318b.addPath(bVar.sr());
            }
        }
        b bVar2 = this.f25321e.get(0);
        if (bVar2 instanceof o) {
            o oVar2 = (o) bVar2;
            List<b> h5 = oVar2.h();
            for (int i4 = 0; i4 < h5.size(); i4++) {
                Path sr2 = h5.get(i4).sr();
                sr2.transform(oVar2.i());
                this.f25317a.addPath(sr2);
            }
        } else {
            this.f25317a.set(bVar2.sr());
        }
        this.f25319c.op(this.f25317a, this.f25318b, op);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        for (int i4 = 0; i4 < this.f25321e.size(); i4++) {
            this.f25321e.get(i4).c(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.c.l
    public void d(ListIterator<t> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            t previous = listIterator.previous();
            if (previous instanceof b) {
                this.f25321e.add((b) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        this.f25319c.reset();
        if (this.f25322f.d()) {
            return this.f25319c;
        }
        int i4 = C0349a.f25323a[this.f25322f.c().ordinal()];
        if (i4 == 1) {
            f();
        } else if (i4 == 2) {
            g(Path.Op.UNION);
        } else if (i4 == 3) {
            g(Path.Op.REVERSE_DIFFERENCE);
        } else if (i4 == 4) {
            g(Path.Op.INTERSECT);
        } else if (i4 == 5) {
            g(Path.Op.XOR);
        }
        return this.f25319c;
    }
}
