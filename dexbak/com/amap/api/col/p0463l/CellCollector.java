package com.amap.api.col.p0463l;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3l.g8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CellCollector {

    /* renamed from: a */
    private AmapCell f4293a;

    /* renamed from: b */
    private AmapCell f4294b;

    /* renamed from: c */
    private AmapLocationGnss f4295c;

    /* renamed from: d */
    private C1822a f4296d = new C1822a();

    /* renamed from: e */
    private final List<AmapCell> f4297e = new ArrayList(3);

    /* compiled from: CellCollector.java */
    /* renamed from: com.amap.api.col.3l.g8$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1822a {

        /* renamed from: a */
        public byte f4298a;

        /* renamed from: b */
        public String f4299b;

        /* renamed from: c */
        public AmapCell f4300c;

        /* renamed from: d */
        public AmapCell f4301d;

        /* renamed from: e */
        public AmapCell f4302e;

        /* renamed from: f */
        public List<AmapCell> f4303f = new ArrayList();

        /* renamed from: g */
        public List<AmapCell> f4304g = new ArrayList();

        /* renamed from: c */
        public static boolean m54899c(AmapCell amapCell, AmapCell amapCell2) {
            if (amapCell == null || amapCell2 == null) {
                return (amapCell == null) == (amapCell2 == null);
            } else if ((amapCell instanceof AmapCellGsm) && (amapCell2 instanceof AmapCellGsm)) {
                AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
                AmapCellGsm amapCellGsm2 = (AmapCellGsm) amapCell2;
                return amapCellGsm.f4639j == amapCellGsm2.f4639j && amapCellGsm.f4640k == amapCellGsm2.f4640k;
            } else if ((amapCell instanceof AmapCellCdma) && (amapCell2 instanceof AmapCellCdma)) {
                AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
                AmapCellCdma amapCellCdma2 = (AmapCellCdma) amapCell2;
                return amapCellCdma.f4636l == amapCellCdma2.f4636l && amapCellCdma.f4635k == amapCellCdma2.f4635k && amapCellCdma.f4634j == amapCellCdma2.f4634j;
            } else if ((amapCell instanceof AmapCellLte) && (amapCell2 instanceof AmapCellLte)) {
                AmapCellLte amapCellLte = (AmapCellLte) amapCell;
                AmapCellLte amapCellLte2 = (AmapCellLte) amapCell2;
                return amapCellLte.f4645j == amapCellLte2.f4645j && amapCellLte.f4646k == amapCellLte2.f4646k;
            } else {
                if ((amapCell instanceof AmapCellWcdma) && (amapCell2 instanceof AmapCellWcdma)) {
                    AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
                    AmapCellWcdma amapCellWcdma2 = (AmapCellWcdma) amapCell2;
                    if (amapCellWcdma.f4650j == amapCellWcdma2.f4650j && amapCellWcdma.f4651k == amapCellWcdma2.f4651k) {
                        return true;
                    }
                }
                return false;
            }
        }

        /* renamed from: a */
        public final void m54901a() {
            this.f4298a = (byte) 0;
            this.f4299b = "";
            this.f4300c = null;
            this.f4301d = null;
            this.f4302e = null;
            this.f4303f.clear();
            this.f4304g.clear();
        }

        /* renamed from: b */
        public final void m54900b(byte b, String str, List<AmapCell> list) {
            m54901a();
            this.f4298a = b;
            this.f4299b = str;
            if (list != null) {
                this.f4303f.addAll(list);
                for (AmapCell amapCell : this.f4303f) {
                    boolean z = amapCell.f4633i;
                    if (!z && amapCell.f4632h) {
                        this.f4301d = amapCell;
                    } else if (z && amapCell.f4632h) {
                        this.f4302e = amapCell;
                    }
                }
            }
            AmapCell amapCell2 = this.f4301d;
            if (amapCell2 == null) {
                amapCell2 = this.f4302e;
            }
            this.f4300c = amapCell2;
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f4298a) + ", operator='" + this.f4299b + "', mainCell=" + this.f4300c + ", mainOldInterCell=" + this.f4301d + ", mainNewInterCell=" + this.f4302e + ", cells=" + this.f4303f + ", historyMainCellList=" + this.f4304g + '}';
        }
    }

    /* renamed from: b */
    private void m54904b(C1822a c1822a) {
        synchronized (this.f4297e) {
            for (AmapCell amapCell : c1822a.f4303f) {
                if (amapCell != null && amapCell.f4632h) {
                    AmapCell clone = amapCell.clone();
                    clone.f4629e = SystemClock.elapsedRealtime();
                    m54903c(clone);
                }
            }
            this.f4296d.f4304g.clear();
            this.f4296d.f4304g.addAll(this.f4297e);
        }
    }

    /* renamed from: c */
    private void m54903c(AmapCell amapCell) {
        if (amapCell == null) {
            return;
        }
        int size = this.f4297e.size();
        if (size == 0) {
            this.f4297e.add(amapCell);
            return;
        }
        long j = Long.MAX_VALUE;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= size) {
                i2 = i3;
                break;
            }
            AmapCell amapCell2 = this.f4297e.get(i);
            if (amapCell.equals(amapCell2)) {
                int i4 = amapCell.f4627c;
                if (i4 != amapCell2.f4627c) {
                    amapCell2.f4629e = i4;
                    amapCell2.f4627c = i4;
                }
            } else {
                j = Math.min(j, amapCell2.f4629e);
                if (j == amapCell2.f4629e) {
                    i3 = i;
                }
                i++;
            }
        }
        if (i2 >= 0) {
            if (size < 3) {
                this.f4297e.add(amapCell);
            } else if (amapCell.f4629e <= j || i2 >= size) {
            } else {
                this.f4297e.remove(i2);
                this.f4297e.add(amapCell);
            }
        }
    }

    /* renamed from: d */
    private boolean m54902d(AmapLocationGnss amapLocationGnss) {
        float f = amapLocationGnss.f4481g;
        return amapLocationGnss.m54741a(this.f4295c) > ((double) ((f > 10.0f ? 1 : (f == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f > 2.0f ? 1 : (f == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1822a m54905a(AmapLocationGnss amapLocationGnss, boolean z, byte b, String str, List<AmapCell> list) {
        if (z) {
            this.f4296d.m54901a();
            return null;
        }
        this.f4296d.m54900b(b, str, list);
        if (this.f4296d.f4300c == null) {
            return null;
        }
        if (this.f4295c == null || m54902d(amapLocationGnss) || !C1822a.m54899c(this.f4296d.f4301d, this.f4293a) || !C1822a.m54899c(this.f4296d.f4302e, this.f4294b)) {
            C1822a c1822a = this.f4296d;
            this.f4293a = c1822a.f4301d;
            this.f4294b = c1822a.f4302e;
            this.f4295c = amapLocationGnss;
            RssiManager.m55270c(c1822a.f4303f);
            m54904b(this.f4296d);
            return this.f4296d;
        }
        return null;
    }
}
