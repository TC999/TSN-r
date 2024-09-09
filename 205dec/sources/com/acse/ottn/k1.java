package com.acse.ottn;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.HelpShopAppUtil;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public static k1 f5789a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Consumer<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnIndividuationCallBack f5790a;

        public a(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
            this.f5790a = onIndividuationCallBack;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.f5790a.onIndividuationState(true);
            z1.b("ShopHelperService", "\u62a5\u9519\u4e86=" + th.getMessage());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Consumer<String> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Consumer<Throwable> {
        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f5794a;

        public d(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f5794a = onOpenPermission;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 1) {
                if (jSONObject.getInt("open_plugin_permission") == 1) {
                    AcseHelpManager.OnOpenPermission onOpenPermission = this.f5794a;
                    if (onOpenPermission != null) {
                        onOpenPermission.openPermission(true);
                    }
                } else {
                    AcseHelpManager.OnOpenPermission onOpenPermission2 = this.f5794a;
                    if (onOpenPermission2 != null) {
                        onOpenPermission2.openPermission(false);
                    }
                }
            } else {
                AcseHelpManager.OnOpenPermission onOpenPermission3 = this.f5794a;
                if (onOpenPermission3 != null) {
                    onOpenPermission3.openPermission(false);
                }
            }
            i2.a().a("open_app");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements Consumer<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f5796a;

        public e(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f5796a = onOpenPermission;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            AcseHelpManager.OnOpenPermission onOpenPermission = this.f5796a;
            if (onOpenPermission != null) {
                onOpenPermission.openPermission(false);
            }
            i2.a().a("open_app");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f5798a;

        public f(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f5798a = onOpenPermission;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f5798a != null) {
                if (jSONObject.getInt("r") == 1) {
                    this.f5798a.openPermission(AcseHelpManager.isOPenPermission());
                } else {
                    this.f5798a.openPermission(true);
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements Consumer<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f5800a;

        public g(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f5800a = onOpenPermission;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            AcseHelpManager.OnOpenPermission onOpenPermission = this.f5800a;
            if (onOpenPermission != null) {
                onOpenPermission.openPermission(AcseHelpManager.isOPenPermission());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5802a;

        public h(String str) {
            this.f5802a = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            h1.c().a(this.f5802a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class i implements Consumer<Throwable> {
        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class j implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnIndividuationCallBack f5805a;

        public j(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
            this.f5805a = onIndividuationCallBack;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            if (new JSONObject(str).getInt("state") == 1) {
                this.f5805a.onIndividuationState(true);
            } else {
                this.f5805a.onIndividuationState(false);
            }
        }
    }

    public static k1 b() {
        if (f5789a == null) {
            synchronized (k1.class) {
                if (f5789a == null) {
                    f5789a = new k1();
                }
            }
        }
        return f5789a;
    }

    public void a() {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("device_manufacturer", c4.i());
        treeMap.put("device_product", c4.j());
        treeMap.put("device_brand", c4.b());
        treeMap.put("system_model", c4.p());
        treeMap.put("device_board", c4.a());
        treeMap.put("device_device", c4.d());
        treeMap.put("device_fubgerprint", c4.f());
        treeMap.put("device_SDK", c4.k() + "");
        treeMap.put("system_version", g1.a().d("getSystemVersion"));
        treeMap.put("plunin_version", "0");
        treeMap.put("is_snt", "0");
        new f0().e(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new b(), new c());
    }

    public final Object c() throws ObjectStreamException {
        return f5789a;
    }

    public void b(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("device_manufacturer", c4.i());
        treeMap.put("device_product", c4.j());
        treeMap.put("device_brand", c4.b());
        treeMap.put("system_model", c4.p());
        treeMap.put("device_board", c4.a());
        treeMap.put("device_device", c4.d());
        treeMap.put("device_fubgerprint", c4.f());
        treeMap.put("device_SDK", c4.k() + "");
        treeMap.put("system_version", g1.a().d("getSystemVersion"));
        treeMap.put("plunin_version", p1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new f0().l(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new d(onOpenPermission), new e(onOpenPermission));
    }

    public void a(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("device_manufacturer", c4.i());
        treeMap.put("device_product", c4.j());
        treeMap.put("device_brand", c4.b());
        treeMap.put("system_model", c4.p());
        treeMap.put("device_board", c4.a());
        treeMap.put("device_device", c4.d());
        treeMap.put("device_fubgerprint", c4.f());
        treeMap.put("device_SDK", c4.k() + "");
        treeMap.put("system_version", g1.a().d("getSystemVersion"));
        treeMap.put("plunin_version", p1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new f0().h(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new f(onOpenPermission), new g(onOpenPermission));
    }

    public void a(String str) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("version", p1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        treeMap.put("state", str);
        new f0().d(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new h(str), new i());
    }

    public void a(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        new f0().n(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new j(onIndividuationCallBack), new a(onIndividuationCallBack));
    }
}
