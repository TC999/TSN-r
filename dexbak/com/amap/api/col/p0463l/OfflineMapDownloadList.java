package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.amap.api.col.3l.g0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineMapDownloadList {

    /* renamed from: a */
    public ArrayList<OfflineMapProvince> f4233a = new ArrayList<>();

    /* renamed from: b */
    private OfflineDBOperation f4234b;

    /* renamed from: c */
    private Context f4235c;

    public OfflineMapDownloadList(Context context) {
        this.f4235c = context;
        this.f4234b = OfflineDBOperation.m54085b(context);
    }

    /* renamed from: d */
    private void m54962d(CityObject cityObject, OfflineMapCity offlineMapCity) {
        int m55089d = cityObject.m55618s().m55089d();
        if (cityObject.m55618s().equals(cityObject.f3573f)) {
            m54950p(cityObject.m55631I());
        } else {
            if (cityObject.m55618s().equals(cityObject.f3578k)) {
                cityObject.getCity();
                m54951o(cityObject);
                cityObject.m55631I().m54534n();
            }
            if (m54955k(cityObject.getcompleteCode(), cityObject.m55618s().m55089d())) {
                m54960f(cityObject.m55631I());
            }
        }
        offlineMapCity.setState(m55089d);
        offlineMapCity.setCompleteCode(cityObject.getcompleteCode());
    }

    /* renamed from: e */
    private void m54961e(CityObject cityObject, OfflineMapProvince offlineMapProvince) {
        UpdateItem updateItem;
        int m55089d = cityObject.m55618s().m55089d();
        if (m55089d == 6) {
            offlineMapProvince.setState(m55089d);
            offlineMapProvince.setCompleteCode(0);
            m54950p(new UpdateItem(offlineMapProvince, this.f4235c));
            try {
                Utility.m53343k(offlineMapProvince.getProvinceCode(), this.f4235c);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (m54956j(m55089d) && m54954l(offlineMapProvince)) {
            if (cityObject.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(m55089d);
                offlineMapProvince.setCompleteCode(cityObject.getcompleteCode());
                offlineMapProvince.setVersion(cityObject.getVersion());
                offlineMapProvince.setUrl(cityObject.getUrl());
                updateItem = new UpdateItem(offlineMapProvince, this.f4235c);
                updateItem.m54535m(cityObject.m55624h());
                updateItem.m54253d(cityObject.getCode());
            } else {
                offlineMapProvince.setState(m55089d);
                offlineMapProvince.setCompleteCode(100);
                updateItem = new UpdateItem(offlineMapProvince, this.f4235c);
            }
            updateItem.m54534n();
            m54960f(updateItem);
            updateItem.m54256a();
        }
    }

    /* renamed from: f */
    private void m54960f(UpdateItem updateItem) {
        OfflineDBOperation offlineDBOperation = this.f4234b;
        if (offlineDBOperation == null || updateItem == null) {
            return;
        }
        offlineDBOperation.m54082e(updateItem);
    }

    /* renamed from: g */
    private static void m54959g(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    /* renamed from: h */
    private static void m54958h(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    /* renamed from: j */
    private static boolean m54956j(int i) {
        return i == 4;
    }

    /* renamed from: k */
    private static boolean m54955k(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    /* renamed from: l */
    private static boolean m54954l(OfflineMapProvince offlineMapProvince) {
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

    /* renamed from: o */
    private void m54951o(CityObject cityObject) {
        File[] listFiles = new File(C1732a3.m55707f0(this.f4235c)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(cityObject.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    /* renamed from: p */
    private void m54950p(UpdateItem updateItem) {
        OfflineDBOperation offlineDBOperation = this.f4234b;
        if (offlineDBOperation != null) {
            offlineDBOperation.m54076k(updateItem);
        }
    }

    /* renamed from: q */
    private static boolean m54949q(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    /* renamed from: x */
    private void m54942x() {
        ArrayList<OfflineMapProvince> arrayList = this.f4233a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f4233a.clear();
            }
        }
    }

    /* renamed from: a */
    public final OfflineMapCity m54965a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f4233a) {
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
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

    /* renamed from: b */
    public final ArrayList<OfflineMapProvince> m54964b() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f4233a) {
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final void m54963c(CityObject cityObject) {
        String pinyin = cityObject.getPinyin();
        synchronized (this.f4233a) {
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            m54962d(cityObject, offlineMapCity);
                            m54961e(cityObject, next);
                            break loop0;
                        }
                    }
                    continue;
                }
            }
        }
    }

    /* renamed from: i */
    public final void m54957i(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f4233a) {
            if (this.f4233a.size() > 0) {
                for (int i = 0; i < this.f4233a.size(); i++) {
                    OfflineMapProvince offlineMapProvince2 = this.f4233a.get(i);
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
                        m54958h(offlineMapProvince2, offlineMapProvince);
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i2 = 0; i2 < cityList.size(); i2++) {
                            OfflineMapCity offlineMapCity2 = cityList.get(i2);
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
                                m54959g(offlineMapCity2, offlineMapCity);
                            }
                        }
                    }
                }
            } else {
                for (OfflineMapProvince offlineMapProvince3 : list) {
                    this.f4233a.add(offlineMapProvince3);
                }
            }
        }
    }

    /* renamed from: m */
    public final OfflineMapCity m54953m(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f4233a) {
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
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

    /* renamed from: n */
    public final ArrayList<OfflineMapCity> m54952n() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f4233a) {
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: r */
    public final OfflineMapProvince m54948r(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f4233a) {
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    /* renamed from: s */
    public final ArrayList<OfflineMapCity> m54947s() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f4233a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
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

    /* renamed from: t */
    public final ArrayList<OfflineMapProvince> m54946t() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f4233a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: u */
    public final ArrayList<OfflineMapCity> m54945u() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f4233a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (m54949q(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: v */
    public final ArrayList<OfflineMapProvince> m54944v() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f4233a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4233a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && m54949q(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: w */
    public final void m54943w() {
        m54942x();
        this.f4234b = null;
        this.f4235c = null;
    }
}
