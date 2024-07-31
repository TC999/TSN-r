package com.amap.api.col.p0463l;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3l.d9 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RssiManager {

    /* compiled from: RssiManager.java */
    /* renamed from: com.amap.api.col.3l.d9$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1772a implements IRssiInfo {

        /* renamed from: a */
        private int f3879a;

        /* renamed from: b */
        private int f3880b;

        /* renamed from: c */
        private int f3881c;

        C1772a(int i, int i2, int i3) {
            this.f3879a = i;
            this.f3880b = i2;
            this.f3881c = i3;
        }

        @Override // com.amap.api.col.p0463l.IRssiInfo
        /* renamed from: a */
        public final long mo55267a() {
            return RssiManager.m55272a(this.f3879a, this.f3880b);
        }

        @Override // com.amap.api.col.p0463l.IRssiInfo
        /* renamed from: b */
        public final int mo55266b() {
            return this.f3881c;
        }
    }

    /* compiled from: RssiManager.java */
    /* renamed from: com.amap.api.col.3l.d9$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1773b implements IRssiInfo {

        /* renamed from: a */
        private long f3882a;

        /* renamed from: b */
        private int f3883b;

        C1773b(long j, int i) {
            this.f3882a = j;
            this.f3883b = i;
        }

        @Override // com.amap.api.col.p0463l.IRssiInfo
        /* renamed from: a */
        public final long mo55267a() {
            return this.f3882a;
        }

        @Override // com.amap.api.col.p0463l.IRssiInfo
        /* renamed from: b */
        public final int mo55266b() {
            return this.f3883b;
        }
    }

    /* renamed from: a */
    public static long m55272a(int i, int i2) {
        return (i2 & 4294967295L) | ((i & 4294967295L) << 32);
    }

    /* renamed from: b */
    public static synchronized short m55271b(long j) {
        short m55444b;
        synchronized (RssiManager.class) {
            m55444b = RssiInfoManager.m55445a().m55444b(j);
        }
        return m55444b;
    }

    /* renamed from: c */
    public static synchronized void m55270c(List<AmapCell> list) {
        synchronized (RssiManager.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (AmapCell amapCell : list) {
                        if (amapCell instanceof AmapCellGsm) {
                            AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
                            arrayList.add(new C1772a(amapCellGsm.f4639j, amapCellGsm.f4640k, amapCellGsm.f4627c));
                        } else if (amapCell instanceof AmapCellLte) {
                            AmapCellLte amapCellLte = (AmapCellLte) amapCell;
                            arrayList.add(new C1772a(amapCellLte.f4645j, amapCellLte.f4646k, amapCellLte.f4627c));
                        } else if (amapCell instanceof AmapCellWcdma) {
                            AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
                            arrayList.add(new C1772a(amapCellWcdma.f4650j, amapCellWcdma.f4651k, amapCellWcdma.f4627c));
                        } else if (amapCell instanceof AmapCellCdma) {
                            AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
                            arrayList.add(new C1772a(amapCellCdma.f4635k, amapCellCdma.f4636l, amapCellCdma.f4627c));
                        }
                    }
                    RssiInfoManager.m55445a().m55442d(arrayList);
                }
            }
        }
    }

    /* renamed from: d */
    public static synchronized short m55269d(long j) {
        short m55439g;
        synchronized (RssiManager.class) {
            m55439g = RssiInfoManager.m55445a().m55439g(j);
        }
        return m55439g;
    }

    /* renamed from: e */
    public static synchronized void m55268e(List<AmapWifi> list) {
        synchronized (RssiManager.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (AmapWifi amapWifi : list) {
                        arrayList.add(new C1773b(amapWifi.f4584a, amapWifi.f4586c));
                    }
                    RssiInfoManager.m55445a().m55438h(arrayList);
                }
            }
        }
    }
}
