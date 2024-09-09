package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.acse.ottn.e2;
import com.acse.ottn.f0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.q0;
import com.acse.ottn.service.C1391a;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.z1;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.google.gson.Gson;
import com.stub.StubApp;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MainService extends Service implements C1391a.m0 {

    /* renamed from: c  reason: collision with root package name */
    public static View f6366c = null;

    /* renamed from: d  reason: collision with root package name */
    public static WindowManager f6367d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f6368e = "MainService";

    /* renamed from: a  reason: collision with root package name */
    public WindowManager.LayoutParams f6369a;

    /* renamed from: b  reason: collision with root package name */
    public AccessiblityModel f6370b;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6371a;

        public a(String str) {
            this.f6371a = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            String str2 = MainService.f6368e;
            z1.a(str2, "\u8bf7\u6c42\u6210\u529f limit_tips =" + MainService.this.f6370b.toString());
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 1) {
                if (jSONObject.getInt("code") == 1) {
                    e2 a4 = e2.a();
                    MainService mainService = MainService.this;
                    a4.a(mainService, this.f6371a, mainService);
                    return;
                }
                e2.a().b(MainService.this);
                return;
            }
            e2.a().b(MainService.this);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    static {
        StubApp.interface11(5040);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void c() {
        e2.a().a(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        z1.c(f6368e, "MainService Created");
        c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            z1.c(f6368e, "onDestroy ");
            C1391a.b();
            C1391a.d();
            e2.a().b(this);
        } catch (Exception e4) {
            String str = f6368e;
            z1.c(str, "onDestroy e=" + e4.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra("model");
            this.f6370b = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                e2.a().b(this, this.f6370b, this);
            }
        } catch (Exception e4) {
            String str = f6368e;
            z1.a(str, "Exception =" + e4.getMessage());
        }
        return super.onStartCommand(intent, i4, i5);
    }

    @Override // com.acse.ottn.service.C1391a.m0
    public void a(String str) {
        b(str);
    }

    public final void b(String str) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("limitType", PangleAdapterUtils.MEDIA_EXTRA_COUPON);
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new f0().i(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new a(str), new b());
    }

    @Override // com.acse.ottn.service.C1391a.m0
    public void a() {
        e2.a().b(this);
    }
}
