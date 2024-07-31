package com.amap.api.col.p0463l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.3l.i8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class WifiCollector {

    /* renamed from: b */
    private AmapLocationGnss f4511b;

    /* renamed from: a */
    private List<AmapWifi> f4510a = new ArrayList();

    /* renamed from: c */
    private ArrayList<AmapWifi> f4512c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WifiCollector.java */
    /* renamed from: com.amap.api.col.3l.i8$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1839a implements Comparator<AmapWifi> {
        C1839a() {
        }

        /* renamed from: a */
        private static int m54701a(AmapWifi amapWifi, AmapWifi amapWifi2) {
            return amapWifi2.f4586c - amapWifi.f4586c;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AmapWifi amapWifi, AmapWifi amapWifi2) {
            return m54701a(amapWifi, amapWifi2);
        }
    }

    /* renamed from: b */
    private static List<AmapWifi> m54708b(List<AmapWifi> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            AmapWifi amapWifi = list.get(i);
            hashMap.put(Integer.valueOf(amapWifi.f4586c), amapWifi);
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }

    /* renamed from: c */
    private boolean m54707c(AmapLocationGnss amapLocationGnss) {
        float f = amapLocationGnss.f4481g;
        float f2 = 10.0f;
        if (f > 10.0f) {
            f2 = 200.0f;
        } else if (f > 2.0f) {
            f2 = 50.0f;
        }
        return amapLocationGnss.m54741a(this.f4511b) > ((double) f2);
    }

    /* renamed from: d */
    private static boolean m54706d(AmapLocationGnss amapLocationGnss, long j, long j2) {
        return j > 0 && j2 - j < ((long) ((amapLocationGnss.f4481g > 10.0f ? 1 : (amapLocationGnss.f4481g == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    /* renamed from: e */
    private static boolean m54705e(List<AmapWifi> list, List<AmapWifi> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap hashMap = new HashMap(list.size());
            for (AmapWifi amapWifi : list) {
                hashMap.put(Long.valueOf(amapWifi.f4584a), 1);
            }
            int i2 = 0;
            for (AmapWifi amapWifi2 : list2) {
                if (((Integer) hashMap.get(Long.valueOf(amapWifi2.f4584a))) != null) {
                    i2++;
                }
            }
            double d = i2;
            Double.isNaN(d);
            double d2 = i;
            Double.isNaN(d2);
            if (d * 2.0d >= d2 * 0.5d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private List<AmapWifi> m54704f(List<AmapWifi> list) {
        Collections.sort(list, new C1839a());
        return list;
    }

    /* renamed from: g */
    private void m54703g(List<AmapWifi> list, List<AmapWifi> list2) {
        list.clear();
        if (list2 != null) {
            List<AmapWifi> m54704f = m54704f(m54708b(list2));
            int size = m54704f.size();
            if (size > 40) {
                size = 40;
            }
            for (int i = 0; i < size; i++) {
                list.add(m54704f.get(i));
            }
        }
    }

    /* renamed from: h */
    private boolean m54702h(AmapLocationGnss amapLocationGnss, List<AmapWifi> list, boolean z, long j, long j2) {
        if (z && m54706d(amapLocationGnss, j, j2) && list != null && list.size() > 0) {
            if (this.f4511b != null) {
                boolean m54707c = m54707c(amapLocationGnss);
                return !m54707c ? !m54705e(list, this.f4510a) : m54707c;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<AmapWifi> m54709a(AmapLocationGnss amapLocationGnss, List<AmapWifi> list, boolean z, long j, long j2) {
        if (m54702h(amapLocationGnss, list, z, j, j2)) {
            m54703g(this.f4512c, list);
            this.f4510a.clear();
            this.f4510a.addAll(list);
            this.f4511b = amapLocationGnss;
            return this.f4512c;
        }
        return null;
    }
}
