package cn.jiguang.bt;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f2893a = "JDataControlManager";

    /* renamed from: e  reason: collision with root package name */
    private static String f2894e = "DISABLE_DATA";

    /* renamed from: f  reason: collision with root package name */
    private static String f2895f = "ENABLE_DATA";

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, HashMap<String, Set<Integer>>> f2896b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Integer> f2897c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f2898d;

    /* renamed from: g  reason: collision with root package name */
    private Context f2899g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f2902a = new c();
    }

    private c() {
        this.f2896b = new HashMap<>();
        this.f2897c = new ArrayList<>();
        this.f2898d = new ArrayList<>();
    }

    public static c a() {
        return a.f2902a;
    }

    public void a(final Context context) {
        try {
            b.c(new Runnable() { // from class: cn.jiguang.bt.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Bundle b4 = c.this.b();
                    if (b4 == null || b4.size() == 0) {
                        return;
                    }
                    d.c(c.f2893a, "start send");
                    JCoreManager.onEvent(context, null, 108, null, b4, new Object[0]);
                }
            }, new int[0]);
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Context context, String str, Bundle bundle) {
        String str2 = f2893a;
        d.c(str2, "setDataControl control=" + bundle + " sdkType=" + str);
        this.f2899g = context;
        HashMap<String, Set<Integer>> hashMap = this.f2896b.get(str);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        Set<Integer> set = hashMap.get("enable_c_c");
        if (set == null) {
            set = new HashSet<>();
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("enable_c_c");
        Set<Integer> set2 = hashMap.get("disable_c_c");
        if (set2 == null) {
            set2 = new HashSet<>();
        }
        ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("disable_c_c");
        set2.addAll(new HashSet(integerArrayList2));
        Iterator<Integer> it = integerArrayList.iterator();
        while (it.hasNext()) {
            set2.remove(Integer.valueOf(it.next().intValue()));
        }
        Iterator<Integer> it2 = integerArrayList2.iterator();
        while (it2.hasNext()) {
            set.remove(Integer.valueOf(it2.next().intValue()));
        }
        set.addAll(new HashSet(integerArrayList));
        hashMap.put("enable_c_c", set);
        hashMap.put("disable_c_c", set2);
        this.f2896b.put(str, hashMap);
        if (JConstants.isCallInit.get()) {
            a(this.f2899g);
        }
    }

    public Bundle b() {
        try {
            this.f2897c.clear();
            this.f2898d.clear();
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap(this.f2896b);
            if (hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    HashMap hashMap2 = (HashMap) entry.getValue();
                    this.f2897c.addAll(new ArrayList((Collection) hashMap2.get("enable_c_c")));
                    this.f2898d.addAll(new ArrayList((Collection) hashMap2.get("disable_c_c")));
                }
                bundle.putSerializable(f2894e, this.f2898d);
                bundle.putSerializable(f2895f, this.f2897c);
            }
            if (this.f2898d.size() > 0) {
                Iterator<Integer> it = this.f2898d.iterator();
                while (it.hasNext()) {
                    cn.jiguang.ck.a.a().b(it.next().intValue());
                }
            }
            String str = f2893a;
            d.c(str, "sendDataToRemoteProcess bundle=" + bundle);
            return bundle;
        } catch (Throwable th) {
            String str2 = f2893a;
            d.c(str2, "sendDataToRemoteProcess throwable=" + th);
            return null;
        }
    }
}
