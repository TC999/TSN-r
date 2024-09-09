package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineMapDownloadList.java */
/* renamed from: com.amap.api.col.3l.g0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f7798a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private r0 f7799b;

    /* renamed from: c  reason: collision with root package name */
    private Context f7800c;

    public g0(Context context) {
        this.f7800c = context;
        this.f7799b = r0.b(context);
    }

    private void d(ax axVar, OfflineMapCity offlineMapCity) {
        int d4 = axVar.s().d();
        if (axVar.s().equals(axVar.f7134f)) {
            p(axVar.J());
        } else {
            if (axVar.s().equals(axVar.f7139k)) {
                axVar.getCity();
                o(axVar);
                axVar.J().n();
            }
            if (k(axVar.getcompleteCode(), axVar.s().d())) {
                f(axVar.J());
            }
        }
        offlineMapCity.setState(d4);
        offlineMapCity.setCompleteCode(axVar.getcompleteCode());
    }

    private void e(ax axVar, OfflineMapProvince offlineMapProvince) {
        m0 m0Var;
        int d4 = axVar.s().d();
        if (d4 == 6) {
            offlineMapProvince.setState(d4);
            offlineMapProvince.setCompleteCode(0);
            p(new m0(offlineMapProvince, this.f7800c));
            try {
                z0.k(offlineMapProvince.getProvinceCode(), this.f7800c);
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else if (j(d4) && l(offlineMapProvince)) {
            if (axVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(d4);
                offlineMapProvince.setCompleteCode(axVar.getcompleteCode());
                offlineMapProvince.setVersion(axVar.getVersion());
                offlineMapProvince.setUrl(axVar.getUrl());
                m0Var = new m0(offlineMapProvince, this.f7800c);
                m0Var.m(axVar.l());
                m0Var.d(axVar.getCode());
            } else {
                offlineMapProvince.setState(d4);
                offlineMapProvince.setCompleteCode(100);
                m0Var = new m0(offlineMapProvince, this.f7800c);
            }
            m0Var.n();
            f(m0Var);
            m0Var.a();
        }
    }

    private void f(m0 m0Var) {
        r0 r0Var = this.f7799b;
        if (r0Var == null || m0Var == null) {
            return;
        }
        r0Var.e(m0Var);
    }

    private static void g(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private static void h(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    private static boolean j(int i4) {
        return i4 == 4;
    }

    private static boolean k(int i4, int i5) {
        return i5 != 1 || i4 <= 2 || i4 >= 98;
    }

    private static boolean l(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    private void o(ax axVar) {
        File[] listFiles = new File(a3.f0(this.f7800c)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(axVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    private void p(m0 m0Var) {
        r0 r0Var = this.f7799b;
        if (r0Var != null) {
            r0Var.k(m0Var);
        }
    }

    private static boolean q(int i4) {
        return i4 == 0 || i4 == 2 || i4 == 3 || i4 == 1 || i4 == 102 || i4 == 101 || i4 == 103 || i4 == -1;
    }

    private void x() {
        ArrayList<OfflineMapProvince> arrayList = this.f7798a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f7798a.clear();
            }
        }
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f7798a) {
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next.getCode().equals(str)) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapProvince> b() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f7798a) {
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final void c(ax axVar) {
        String pinyin = axVar.getPinyin();
        synchronized (this.f7798a) {
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            d(axVar, offlineMapCity);
                            e(axVar, next);
                            break loop0;
                        }
                    }
                    continue;
                }
            }
        }
    }

    public final void i(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f7798a) {
            if (this.f7798a.size() > 0) {
                for (int i4 = 0; i4 < this.f7798a.size(); i4++) {
                    OfflineMapProvince offlineMapProvince2 = this.f7798a.get(i4);
                    Iterator<OfflineMapProvince> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = it.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        } else if (offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince2.getProvinceCode().equals("000001") || offlineMapProvince2.getProvinceCode().equals("100000")) {
                            if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                    }
                    if (offlineMapProvince != null) {
                        h(offlineMapProvince2, offlineMapProvince);
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i5 = 0; i5 < cityList.size(); i5++) {
                            OfflineMapCity offlineMapCity2 = cityList.get(i5);
                            Iterator<OfflineMapCity> it2 = cityList2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    offlineMapCity = null;
                                    break;
                                }
                                offlineMapCity = it2.next();
                                if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                    break;
                                }
                            }
                            if (offlineMapCity != null) {
                                g(offlineMapCity2, offlineMapCity);
                            }
                        }
                    }
                }
            } else {
                for (OfflineMapProvince offlineMapProvince3 : list) {
                    this.f7798a.add(offlineMapProvince3);
                }
            }
        }
    }

    public final OfflineMapCity m(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f7798a) {
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> n() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f7798a) {
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    public final OfflineMapProvince r(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f7798a) {
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> s() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f7798a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> t() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f7798a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> u() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f7798a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (q(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> v() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f7798a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f7798a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && q(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void w() {
        x();
        this.f7799b = null;
        this.f7800c = null;
    }
}
