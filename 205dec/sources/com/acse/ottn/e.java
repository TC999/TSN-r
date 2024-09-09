package com.acse.ottn;

import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f5610a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f5611b = "acse_ShopHelperService";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Consumer<String> {
        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            String str = e.f5611b;
            z1.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
        }
    }

    public static e c() {
        if (f5610a == null) {
            synchronized (e.class) {
                if (f5610a == null) {
                    f5610a = new e();
                }
            }
        }
        return f5610a;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
    }

    public void b() {
    }

    public final Object d() throws ObjectStreamException {
        return f5610a;
    }

    public void a(AccessiblityModel accessiblityModel) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("para", accessiblityModel.getData().getCoupon_activity_name());
        treeMap.put("app", accessiblityModel.getData().getPackage_name());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("is_snt", "0");
        new e1().c(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(h.a()).subscribe(new a(), new b());
    }
}
