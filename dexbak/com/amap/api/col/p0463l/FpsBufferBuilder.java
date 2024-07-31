package com.amap.api.col.p0463l;

import android.os.SystemClock;
import com.amap.api.col.p0463l.CellCollector;
import java.util.List;

/* renamed from: com.amap.api.col.3l.d8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FpsBufferBuilder extends AbstractBuilder {
    public FpsBufferBuilder() {
        super(2048);
    }

    /* renamed from: b */
    private int m55278b(long j, List<AmapWifi> list) {
        m55273g(list);
        int size = list.size();
        if (size > 0) {
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                AmapWifi amapWifi = list.get(i);
                int mo53704b = this.f3746a.mo53704b(amapWifi.f4585b);
                long j2 = amapWifi.f4584a;
                iArr[i] = TWifiInfo.m55647b(this.f3746a, j2 == j && j2 != -1, j2, (short) amapWifi.f4586c, mo53704b, amapWifi.f4590g, (short) amapWifi.f4587d);
            }
            return TWifi.m53310b(this.f3746a, TWifi.m53309c(this.f3746a, iArr));
        }
        return -1;
    }

    /* renamed from: c */
    private int m55277c(CellCollector.C1822a c1822a) {
        int i;
        int i2;
        int i3;
        byte b;
        int i4;
        int m54429c;
        int m53724c;
        m55275e(c1822a.f4303f);
        int size = c1822a.f4303f.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            AmapCell amapCell = c1822a.f4303f.get(i5);
            if (amapCell instanceof AmapCellGsm) {
                AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
                if (!amapCellGsm.f4633i) {
                    m53724c = TGsm.m53725b(this.f3746a, amapCellGsm.f4639j, amapCellGsm.f4640k, amapCellGsm.f4627c, amapCellGsm.f4641l);
                } else {
                    m53724c = TGsm.m53724c(this.f3746a, amapCellGsm.m54597b(), amapCellGsm.m54596c(), amapCellGsm.f4639j, amapCellGsm.f4640k, amapCellGsm.f4627c, amapCellGsm.f4642m, amapCellGsm.f4643n, amapCellGsm.f4628d, amapCellGsm.f4641l);
                }
                i4 = m53724c;
                i3 = -1;
                b = 1;
            } else if (amapCell instanceof AmapCellLte) {
                AmapCellLte amapCellLte = (AmapCellLte) amapCell;
                i4 = TLte.m53641b(this.f3746a, amapCellLte.m54597b(), amapCellLte.m54596c(), amapCellLte.f4645j, amapCellLte.f4646k, amapCellLte.f4647l, amapCellLte.f4627c, amapCellLte.f4648m, amapCellLte.f4628d);
                i3 = -1;
                b = 3;
            } else if (amapCell instanceof AmapCellCdma) {
                AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
                if (!amapCellCdma.f4633i) {
                    m54429c = TCdma.m54430b(this.f3746a, amapCellCdma.f4634j, amapCellCdma.f4635k, amapCellCdma.f4636l, amapCellCdma.f4637m, amapCellCdma.f4638n, amapCellCdma.f4627c);
                } else {
                    m54429c = TCdma.m54429c(this.f3746a, amapCellCdma.f4634j, amapCellCdma.f4635k, amapCellCdma.f4636l, amapCellCdma.f4637m, amapCellCdma.f4638n, amapCellCdma.f4627c, amapCellCdma.f4628d);
                }
                i4 = m54429c;
                i3 = -1;
                b = 2;
            } else if (amapCell instanceof AmapCellWcdma) {
                AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
                i4 = TWcdma.m53393b(this.f3746a, amapCellWcdma.m54597b(), amapCellWcdma.m54596c(), amapCellWcdma.f4650j, amapCellWcdma.f4651k, amapCellWcdma.f4652l, amapCellWcdma.f4627c, amapCellWcdma.f4653m, amapCellWcdma.f4628d);
                i3 = -1;
                b = 4;
            } else {
                i3 = -1;
                b = 0;
                i4 = -1;
            }
            if (i4 == i3) {
                return i3;
            }
            iArr[i5] = TCellInfo.m54097b(this.f3746a, amapCell.f4632h ? (byte) 1 : (byte) 0, amapCell.f4633i ? (byte) 1 : (byte) 0, (short) amapCell.f4631g, b, i4);
        }
        int mo53704b = this.f3746a.mo53704b(c1822a.f4299b);
        int m54359c = TCell.m54359c(this.f3746a, iArr);
        int size2 = c1822a.f4304g.size();
        int[] iArr2 = new int[size2];
        for (int i6 = 0; i6 < size2; i6++) {
            AmapCell amapCell2 = c1822a.f4304g.get(i6);
            long elapsedRealtime = (SystemClock.elapsedRealtime() - amapCell2.f4629e) / 1000;
            elapsedRealtime = (elapsedRealtime > 32767 || elapsedRealtime < 0) ? 32767L : 32767L;
            if (amapCell2 instanceof AmapCellGsm) {
                AmapCellGsm amapCellGsm2 = (AmapCellGsm) amapCell2;
                i = TMainCellGSMHistory.m53497a(this.f3746a, amapCellGsm2.f4639j, amapCellGsm2.f4640k, (short) elapsedRealtime);
            } else if (amapCell2 instanceof AmapCellLte) {
                AmapCellLte amapCellLte2 = (AmapCellLte) amapCell2;
                i = TMainCellGSMHistory.m53497a(this.f3746a, amapCellLte2.f4645j, amapCellLte2.f4646k, (short) elapsedRealtime);
            } else {
                if (amapCell2 instanceof AmapCellCdma) {
                    AmapCellCdma amapCellCdma2 = (AmapCellCdma) amapCell2;
                    i = TMainCellCDMAHistory.m53575a(this.f3746a, amapCellCdma2.f4634j, amapCellCdma2.f4635k, amapCellCdma2.f4636l, (short) elapsedRealtime);
                    i2 = 2;
                } else if (amapCell2 instanceof AmapCellWcdma) {
                    AmapCellWcdma amapCellWcdma2 = (AmapCellWcdma) amapCell2;
                    i = TMainCellGSMHistory.m53497a(this.f3746a, amapCellWcdma2.f4650j, amapCellWcdma2.f4651k, (short) elapsedRealtime);
                } else {
                    i = 0;
                    i2 = 0;
                }
                iArr2[i6] = TCellHistory.m54162b(this.f3746a, (byte) i2, i);
            }
            i2 = 1;
            iArr2[i6] = TCellHistory.m54162b(this.f3746a, (byte) i2, i);
        }
        return TCell.m54360b(this.f3746a, mo53704b, c1822a.f4298a, m54359c, TCell.m54356f(this.f3746a, iArr2));
    }

    /* renamed from: d */
    private int m55276d(AmapLocationGnss amapLocationGnss) {
        long j = amapLocationGnss.f4514k;
        int i = (int) amapLocationGnss.f4483i;
        int i2 = (int) amapLocationGnss.f4481g;
        short s = (short) amapLocationGnss.f4482h;
        byte b = amapLocationGnss.f4515l;
        return TGps.m53841b(this.f3746a, amapLocationGnss.f4477c, j, (int) (amapLocationGnss.f4479e * 1000000.0d), (int) (amapLocationGnss.f4478d * 1000000.0d), (int) amapLocationGnss.f4480f, i, i2, s, b);
    }

    /* renamed from: e */
    private static void m55275e(List<AmapCell> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (AmapCell amapCell : list) {
            if (amapCell instanceof AmapCellGsm) {
                AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
                amapCell.f4631g = RssiManager.m55271b(RssiManager.m55272a(amapCellGsm.f4639j, amapCellGsm.f4640k));
            } else if (amapCell instanceof AmapCellLte) {
                AmapCellLte amapCellLte = (AmapCellLte) amapCell;
                amapCell.f4631g = RssiManager.m55271b(RssiManager.m55272a(amapCellLte.f4645j, amapCellLte.f4646k));
            } else if (amapCell instanceof AmapCellWcdma) {
                AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
                amapCell.f4631g = RssiManager.m55271b(RssiManager.m55272a(amapCellWcdma.f4650j, amapCellWcdma.f4651k));
            } else if (amapCell instanceof AmapCellCdma) {
                AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
                amapCell.f4631g = RssiManager.m55271b(RssiManager.m55272a(amapCellCdma.f4635k, amapCellCdma.f4636l));
            }
        }
    }

    /* renamed from: g */
    private static void m55273g(List<AmapWifi> list) {
        for (AmapWifi amapWifi : list) {
            amapWifi.f4590g = RssiManager.m55269d(amapWifi.f4584a);
        }
    }

    /* renamed from: f */
    public final byte[] m55274f(AmapLocationGnss amapLocationGnss, CellCollector.C1822a c1822a, long j, List<AmapWifi> list) {
        List<AmapCell> list2;
        super.m55446a();
        try {
            int m55276d = m55276d(amapLocationGnss);
            int i = -1;
            int m55277c = (c1822a == null || (list2 = c1822a.f4303f) == null || list2.size() <= 0) ? -1 : m55277c(c1822a);
            if (list != null && list.size() > 0) {
                i = m55278b(j, list);
            }
            RootTLocator.m54574a(this.f3746a);
            RootTLocator.m54573b(this.f3746a, m55276d);
            if (m55277c > 0) {
                RootTLocator.m54570e(this.f3746a, m55277c);
            }
            if (i > 0) {
                RootTLocator.m54571d(this.f3746a, i);
            }
            this.f3746a.m53683w(RootTLocator.m54572c(this.f3746a));
            return this.f3746a.m53680z();
        } catch (Throwable th) {
            ALLog.m54456a(th);
            return null;
        }
    }
}
