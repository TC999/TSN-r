package b2;

import android.text.TextUtils;
import master.flame.danmaku.danmaku.model.android.f;
import master.flame.danmaku.danmaku.model.android.g;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DanmakuUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static f a(d dVar, n nVar, f fVar, int i4) {
        if (fVar == null) {
            fVar = new f();
        }
        fVar.f((int) Math.ceil(dVar.f61161p), (int) Math.ceil(dVar.f61162q), nVar.e(), false, i4);
        g gVar = fVar.get();
        if (gVar != null) {
            ((master.flame.danmaku.danmaku.model.b) nVar).v(dVar, gVar.f61126a, 0.0f, 0.0f, true);
            if (nVar.isHardwareAccelerated()) {
                gVar.h(nVar.getWidth(), nVar.getHeight(), nVar.g(), nVar.p());
            }
        }
        return fVar;
    }

    private static boolean b(int i4, int i5, float[] fArr, float[] fArr2) {
        if (i4 != i5) {
            return false;
        }
        return i4 == 1 ? fArr2[0] < fArr[2] : i4 == 6 && fArr2[2] > fArr[0];
    }

    private static boolean c(n nVar, d dVar, d dVar2, long j4) {
        float[] h4 = dVar.h(nVar, j4);
        float[] h5 = dVar2.h(nVar, j4);
        if (h4 == null || h5 == null) {
            return false;
        }
        return b(dVar.getType(), dVar2.getType(), h4, h5);
    }

    public static final int d(d dVar, d dVar2) {
        CharSequence charSequence;
        if (dVar == dVar2) {
            return 0;
        }
        if (dVar == null) {
            return -1;
        }
        if (dVar2 == null) {
            return 1;
        }
        long j4 = dVar.j() - dVar2.j();
        if (j4 > 0) {
            return 1;
        }
        if (j4 < 0) {
            return -1;
        }
        int type = dVar.getType() - dVar2.getType();
        if (type > 0) {
            return 1;
        }
        if (type >= 0 && (charSequence = dVar.f61148c) != null) {
            if (dVar2.f61148c == null) {
                return 1;
            }
            int compareTo = charSequence.toString().compareTo(dVar2.f61148c.toString());
            if (compareTo != 0) {
                return compareTo;
            }
            int i4 = dVar.f61152g - dVar2.f61152g;
            if (i4 != 0) {
                return i4 < 0 ? -1 : 1;
            }
            int i5 = dVar.f61164s - dVar2.f61164s;
            if (i5 != 0) {
                return i5 < 0 ? -1 : 1;
            }
            return dVar.hashCode() - dVar.hashCode();
        }
        return -1;
    }

    public static void e(d dVar, CharSequence charSequence) {
        dVar.f61148c = charSequence;
        if (TextUtils.isEmpty(charSequence) || !charSequence.toString().contains("/n")) {
            return;
        }
        String[] split = String.valueOf(dVar.f61148c).split("/n", -1);
        if (split.length > 1) {
            dVar.f61149d = split;
        }
    }

    public static int f(int i4, int i5, int i6) {
        return i4 * i5 * i6;
    }

    public static final boolean g(d dVar, d dVar2) {
        if (dVar == dVar2) {
            return false;
        }
        CharSequence charSequence = dVar.f61148c;
        CharSequence charSequence2 = dVar2.f61148c;
        if (charSequence == charSequence2) {
            return true;
        }
        return charSequence != null && charSequence.equals(charSequence2);
    }

    public static final boolean h(n nVar, d dVar) {
        return nVar.isHardwareAccelerated() && (dVar.f61161p > ((float) nVar.g()) || dVar.f61162q > ((float) nVar.p()));
    }

    public static boolean i(n nVar, d dVar, d dVar2, long j4, long j5) {
        int type = dVar.getType();
        if (type == dVar2.getType() && !dVar.s()) {
            long b4 = dVar2.b() - dVar.b();
            if (b4 <= 0) {
                return true;
            }
            if (Math.abs(b4) >= j4 || dVar.w() || dVar2.w()) {
                return false;
            }
            return type == 5 || type == 4 || c(nVar, dVar, dVar2, j5) || c(nVar, dVar, dVar2, dVar.b() + dVar.f());
        }
        return false;
    }
}
