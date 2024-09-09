package cn.jiguang.ar;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f2375a = "JDataUserControl";

    /* renamed from: b  reason: collision with root package name */
    private static String f2376b = "DISABLE_DATA";

    /* renamed from: c  reason: collision with root package name */
    private static String f2377c = "ENABLE_DATA";

    /* renamed from: d  reason: collision with root package name */
    private HashMap<Integer, Object> f2378d;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f2379a = new c();
    }

    private c() {
        this.f2378d = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(2000);
        arrayList.add(3000);
        arrayList.add(1000);
        this.f2378d.put(Integer.valueOf((int) AVMDLDataLoader.KeyIsIsTestSpeedVersion), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(2001);
        arrayList2.add(3001);
        arrayList2.add(1001);
        this.f2378d.put(1100, arrayList2);
        this.f2378d.put(1101, arrayList2);
        this.f2378d.put(1104, arrayList2);
        this.f2378d.put(1110, arrayList2);
        this.f2378d.put(1102, arrayList2);
        this.f2378d.put(1013, 3003);
        this.f2378d.put(2009, 3003);
        this.f2378d.put(1014, 3004);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(3005);
        arrayList3.add(2006);
        this.f2378d.put(1017, arrayList3);
        this.f2378d.put(2012, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(1009);
        arrayList4.add(2005);
        arrayList4.add(3006);
        this.f2378d.put(1009, arrayList4);
        this.f2378d.put(2006, arrayList4);
        this.f2378d.put(1015, 3007);
        this.f2378d.put(1011, 3008);
        this.f2378d.put(2008, 3008);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(2009);
        arrayList5.add(3009);
        arrayList5.add(1005);
        this.f2378d.put(2007, arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(2003);
        arrayList6.add(3010);
        arrayList6.add(1012);
        this.f2378d.put(Integer.valueOf((int) AVMDLDataLoader.KeyIsIsEncryptVersion), arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(1006);
        arrayList7.add(2010);
        arrayList7.add(3011);
        this.f2378d.put(1608, arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(2004);
        arrayList8.add(3012);
        arrayList8.add(1007);
        this.f2378d.put(1601, arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(1008);
        arrayList9.add(2011);
        arrayList9.add(3013);
        this.f2378d.put(1501, arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(2007);
        arrayList10.add(3014);
        arrayList10.add(1003);
        this.f2378d.put(2004, arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(2008);
        arrayList11.add(3015);
        arrayList11.add(1004);
        this.f2378d.put(1012, arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(3016);
        arrayList12.add(1010);
        arrayList12.add(2012);
        this.f2378d.put(2005, arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(3017);
        arrayList13.add(1011);
        arrayList13.add(2013);
        this.f2378d.put(2201, arrayList13);
        b.a();
    }

    public static c a() {
        return a.f2379a;
    }

    public synchronized void a(Bundle bundle) {
        String str = f2375a;
        cn.jiguang.w.a.b(str, "updateCollectConfig bundle=" + bundle);
        if (bundle != null && bundle.size() != 0) {
            b.a((ArrayList) bundle.getSerializable(f2376b), (ArrayList) bundle.getSerializable(f2377c));
            String str2 = f2375a;
            cn.jiguang.w.a.b(str2, "updateCollectConfig mDisableDatas=" + b.f2367e);
            String str3 = f2375a;
            cn.jiguang.w.a.b(str3, "updateCollectConfig mEnableDatas=" + b.f2366d);
        }
    }

    public synchronized boolean a(int i4) {
        try {
            if (this.f2378d.containsKey(Integer.valueOf(i4))) {
                Object obj = this.f2378d.get(Integer.valueOf(i4));
                if (b.a(obj)) {
                    if (!(obj instanceof List)) {
                        return b.f2366d.contains(obj);
                    }
                    ArrayList arrayList = new ArrayList(b.f2366d);
                    arrayList.retainAll((List) obj);
                    return !arrayList.isEmpty();
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public synchronized boolean b(int i4) {
        try {
            if (this.f2378d.containsKey(Integer.valueOf(i4))) {
                Object obj = this.f2378d.get(Integer.valueOf(i4));
                if (b.a(obj)) {
                    if (!(obj instanceof List)) {
                        return b.f2367e.contains(obj);
                    }
                    ArrayList arrayList = new ArrayList(b.f2367e);
                    arrayList.retainAll((List) obj);
                    return !arrayList.isEmpty();
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JDataConfigManager", "isContainDisableDatas throwable=" + th);
            return false;
        }
    }
}
