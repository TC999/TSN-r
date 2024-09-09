package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class s3 {

    /* renamed from: c  reason: collision with root package name */
    public static s3 f6259c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f6260d = "ScrolledReadUtil";

    /* renamed from: a  reason: collision with root package name */
    public List<String> f6261a;

    /* renamed from: b  reason: collision with root package name */
    public int f6262b = 0;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Consumer<AccessiblityModel> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6263a;

        public a(String str) {
            this.f6263a = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(AccessiblityModel accessiblityModel) throws Exception {
            String str = s3.f6260d;
            z1.a(str, "\u8bf7\u6c42\u6210\u529f string =" + accessiblityModel.toString());
            if (1 == accessiblityModel.getR()) {
                d.b().a(accessiblityModel, this.f6263a);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            String str = s3.f6260d;
            z1.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
            if (s3.this.f6261a != null) {
                s3.this.f6261a.removeAll(s3.this.f6261a);
            }
        }
    }

    public static s3 b() {
        if (f6259c == null) {
            synchronized (s3.class) {
                if (f6259c == null) {
                    f6259c = new s3();
                }
            }
        }
        return f6259c;
    }

    public final Object c() throws ObjectStreamException {
        return f6259c;
    }

    public void a(AccessibilityService accessibilityService, String str, String str2) {
        List<String> list = this.f6261a;
        if (list != null) {
            list.removeAll(list);
            this.f6261a.clear();
        }
        try {
            this.f6261a = new ArrayList();
            a(accessibilityService.getRootInActiveWindow());
            if (a(this.f6261a)) {
                g1.a().b("scroll_state", j0.f5774p);
                a(accessibilityService, this.f6261a, str, str2);
            }
        } catch (Throwable th) {
            List<String> list2 = this.f6261a;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f6262b = 0;
                this.f6261a = new ArrayList();
                g1.a().b("scroll_state", "0");
            }
            Log.d(f6260d, th.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i4) != null) {
                            a(accessibilityNodeInfo.getChild(i4));
                        }
                    } catch (Throwable th) {
                        g1.a().b("scroll_state", "0");
                        Log.d("ScrolledReadUtil", th.getMessage());
                        return;
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (trim.length() >= 25 || trim.length() <= 2) {
                return;
            }
            this.f6262b = q0.a().a(trim, this.f6262b);
            if (q0.a().a(this.f6262b) && this.f6261a.size() < 100) {
                this.f6261a.add(trim);
                return;
            }
            List<String> list = this.f6261a;
            if (list != null) {
                list.removeAll(list);
                this.f6261a.clear();
                this.f6262b = 0;
                g1.a().b("scroll_state", "0");
            }
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String trim2 = accessibilityNodeInfo.getContentDescription().toString().trim();
            if (trim2.length() >= 25 || trim2.length() <= 2) {
                return;
            }
            this.f6262b = q0.a().a(trim2, this.f6262b);
            if (q0.a().a(this.f6262b) && this.f6261a.size() < 100) {
                this.f6261a.add(trim2);
                return;
            }
            List<String> list2 = this.f6261a;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f6261a.clear();
                this.f6262b = 0;
                g1.a().b("scroll_state", "0");
            }
        }
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).trim().equals("\u8fdb\u5e97\u901b\u901b") || list.get(i4).trim().equals("\u5929\u732b\u56fd\u9645") || list.get(i4).trim().equals("\u53bb\u9891\u9053\u901b\u901b")) {
                    z1.a("zkj_samon", "\u5305\u542b");
                    return true;
                }
            }
            return false;
        }
        z1.a(f6260d, "lists = null");
        return false;
    }

    public final void a(AccessibilityService accessibilityService, List<String> list, String str, String str2) {
        String str3 = f6260d;
        z1.a(str3, "current packageName  =" + str2);
        if (!com.acse.ottn.b.d().b() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        Gson gson = new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("app", str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionNewID());
        if (list != null) {
            treeMap.put("data", gson.toJson(list));
            String str4 = f6260d;
            z1.a(str4, "getCouponInfo string =" + gson.toJson(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("product_info", g1.a().d("goods_info"));
        treeMap.put("new_version", j0.f5769k);
        treeMap.put("coupon_type", q0.a().h(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put("device_brand", c4.b());
        treeMap.put("is_snt", j0.f5769k);
        treeMap.put("version", j0.f5782x);
        new e1().d(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(h.a()).subscribe(new a(str), new b());
    }
}
