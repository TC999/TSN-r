package p025b2;

import android.text.TextUtils;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DrawingCache;
import master.flame.danmaku.danmaku.model.android.DrawingCacheHolder;

/* renamed from: b2.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DanmakuUtils {
    /* renamed from: a */
    public static DrawingCache m59965a(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DrawingCache drawingCache, int i) {
        if (drawingCache == null) {
            drawingCache = new DrawingCache();
        }
        drawingCache.mo3023f((int) Math.ceil(baseDanmaku.f43874p), (int) Math.ceil(baseDanmaku.f43875q), iDisplayer.mo3041e(), false, i);
        DrawingCacheHolder drawingCacheHolder = drawingCache.get();
        if (drawingCacheHolder != null) {
            ((AbsDisplayer) iDisplayer).mo3101v(baseDanmaku, drawingCacheHolder.f43818a, 0.0f, 0.0f, true);
            if (iDisplayer.isHardwareAccelerated()) {
                drawingCacheHolder.m3127h(iDisplayer.getWidth(), iDisplayer.getHeight(), iDisplayer.mo3039g(), iDisplayer.mo3030p());
            }
        }
        return drawingCache;
    }

    /* renamed from: b */
    private static boolean m59964b(int i, int i2, float[] fArr, float[] fArr2) {
        if (i != i2) {
            return false;
        }
        return i == 1 ? fArr2[0] < fArr[2] : i == 6 && fArr2[2] > fArr[0];
    }

    /* renamed from: c */
    private static boolean m59963c(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, long j) {
        float[] mo2998h = baseDanmaku.mo2998h(iDisplayer, j);
        float[] mo2998h2 = baseDanmaku2.mo2998h(iDisplayer, j);
        if (mo2998h == null || mo2998h2 == null) {
            return false;
        }
        return m59964b(baseDanmaku.getType(), baseDanmaku2.getType(), mo2998h, mo2998h2);
    }

    /* renamed from: d */
    public static final int m59962d(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
        CharSequence charSequence;
        if (baseDanmaku == baseDanmaku2) {
            return 0;
        }
        if (baseDanmaku == null) {
            return -1;
        }
        if (baseDanmaku2 == null) {
            return 1;
        }
        long m3084j = baseDanmaku.m3084j() - baseDanmaku2.m3084j();
        if (m3084j > 0) {
            return 1;
        }
        if (m3084j < 0) {
            return -1;
        }
        int type = baseDanmaku.getType() - baseDanmaku2.getType();
        if (type > 0) {
            return 1;
        }
        if (type >= 0 && (charSequence = baseDanmaku.f43861c) != null) {
            if (baseDanmaku2.f43861c == null) {
                return 1;
            }
            int compareTo = charSequence.toString().compareTo(baseDanmaku2.f43861c.toString());
            if (compareTo != 0) {
                return compareTo;
            }
            int i = baseDanmaku.f43865g - baseDanmaku2.f43865g;
            if (i != 0) {
                return i < 0 ? -1 : 1;
            }
            int i2 = baseDanmaku.f43877s - baseDanmaku2.f43877s;
            if (i2 != 0) {
                return i2 < 0 ? -1 : 1;
            }
            return baseDanmaku.hashCode() - baseDanmaku.hashCode();
        }
        return -1;
    }

    /* renamed from: e */
    public static void m59961e(BaseDanmaku baseDanmaku, CharSequence charSequence) {
        baseDanmaku.f43861c = charSequence;
        if (TextUtils.isEmpty(charSequence) || !charSequence.toString().contains(BaseDanmaku.f43837L)) {
            return;
        }
        String[] split = String.valueOf(baseDanmaku.f43861c).split(BaseDanmaku.f43837L, -1);
        if (split.length > 1) {
            baseDanmaku.f43862d = split;
        }
    }

    /* renamed from: f */
    public static int m59960f(int i, int i2, int i3) {
        return i * i2 * i3;
    }

    /* renamed from: g */
    public static final boolean m59959g(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
        if (baseDanmaku == baseDanmaku2) {
            return false;
        }
        CharSequence charSequence = baseDanmaku.f43861c;
        CharSequence charSequence2 = baseDanmaku2.f43861c;
        if (charSequence == charSequence2) {
            return true;
        }
        return charSequence != null && charSequence.equals(charSequence2);
    }

    /* renamed from: h */
    public static final boolean m59958h(IDisplayer iDisplayer, BaseDanmaku baseDanmaku) {
        return iDisplayer.isHardwareAccelerated() && (baseDanmaku.f43874p > ((float) iDisplayer.mo3039g()) || baseDanmaku.f43875q > ((float) iDisplayer.mo3030p()));
    }

    /* renamed from: i */
    public static boolean m59957i(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, long j, long j2) {
        int type = baseDanmaku.getType();
        if (type == baseDanmaku2.getType() && !baseDanmaku.m3076s()) {
            long m3088b = baseDanmaku2.m3088b() - baseDanmaku.m3088b();
            if (m3088b <= 0) {
                return true;
            }
            if (Math.abs(m3088b) >= j || baseDanmaku.m3073w() || baseDanmaku2.m3073w()) {
                return false;
            }
            return type == 5 || type == 4 || m59963c(iDisplayer, baseDanmaku, baseDanmaku2, j2) || m59963c(iDisplayer, baseDanmaku, baseDanmaku2, baseDanmaku.m3088b() + baseDanmaku.m3085f());
        }
        return false;
    }
}
