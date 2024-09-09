package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f2395a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f2396b = new AtomicBoolean(true);

    /* renamed from: c  reason: collision with root package name */
    private Context f2397c;

    /* renamed from: d  reason: collision with root package name */
    private Set<cn.jiguang.common.m.d> f2398d;

    /* renamed from: e  reason: collision with root package name */
    private Set<cn.jiguang.common.m.d> f2399e;

    /* renamed from: f  reason: collision with root package name */
    private Set<cn.jiguang.common.m.d> f2400f;

    /* renamed from: g  reason: collision with root package name */
    private List<cn.jiguang.common.m.d> f2401g;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends cn.jiguang.ah.e {

        /* renamed from: b  reason: collision with root package name */
        private Context f2403b;

        /* renamed from: c  reason: collision with root package name */
        private Intent f2404c;

        a(Context context, Intent intent) {
            this.f2403b = context;
            this.f2404c = intent;
            this.f2244d = "JAppMovement#MovementAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            try {
                c.this.b(this.f2403b, this.f2404c);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JAppMovement", "dealMovementAction throwable:" + th.getMessage());
            }
        }
    }

    private void a(String str, int i4, String str2, int i5, cn.jiguang.common.m.d dVar) {
        try {
            Map<String, cn.jiguang.common.m.d> a4 = cn.jiguang.common.n.d.a(this.f2397c);
            String str3 = "";
            if (a4 != null) {
                cn.jiguang.common.m.d dVar2 = a4.get(str);
                if (dVar2 == null || TextUtils.isEmpty(dVar2.f3495a)) {
                    dVar2 = cn.jiguang.common.n.d.c(this.f2397c, str);
                }
                if (dVar2 != null) {
                    str3 = dVar2.f3495a;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str2);
            jSONObject.put("app_name", str3);
            jSONObject.put("appid", str);
            jSONObject.put("source", i5);
            long j4 = dVar.f3505k;
            if (j4 >= 0) {
                jSONObject.put("update_time", j4);
            }
            long j5 = dVar.f3504j;
            if (j5 >= 0) {
                jSONObject.put("install_time", j5);
            }
            if (i4 != -1000) {
                jSONObject.put("install_type", i4);
            }
            cn.jiguang.ah.d.a(this.f2397c, jSONObject, "app_add_rmv");
            cn.jiguang.ah.d.a(this.f2397c, (Object) jSONObject);
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("JAppMovement", "package json exception:" + e4.getMessage());
        }
    }

    private boolean a(int i4, String str) {
        if (i4 == 1) {
            cn.jiguang.w.a.f("JAppMovement", "the " + str + " app is system app,need dealAction all apps,to executeMovementAction JAppAll");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        String dataString;
        if (cn.jiguang.ar.a.a().g(1101)) {
            return;
        }
        String action = intent.getAction();
        if (action == null || TextUtils.isEmpty(action)) {
            cn.jiguang.w.a.f("JAppMovement", "the action'" + action + "'is illegal");
            return;
        }
        boolean equals = action.equals("android.intent.action.PACKAGE_ADDED");
        if ((equals || action.equals("android.intent.action.PACKAGE_REMOVED")) && (dataString = intent.getDataString()) != null && !TextUtils.isEmpty(dataString) && dataString.length() > 8 && dataString.startsWith("package:")) {
            String substring = dataString.substring(8);
            cn.jiguang.w.a.b("JAppMovement", "receive the action'" + action + ",package:" + substring);
            String str = equals ? "add.catch" : "rmv.catch";
            String c4 = cn.jiguang.ao.e.c(context, str);
            Set hashSet = new HashSet();
            if (!TextUtils.isEmpty(c4)) {
                hashSet = cn.jiguang.common.n.d.a(c4);
            }
            cn.jiguang.common.m.d f4 = f(context, substring);
            if (f4 == null) {
                f4 = new cn.jiguang.common.m.d();
            }
            if (TextUtils.isEmpty(f4.f3496b) || !TextUtils.equals(f4.f3496b, substring)) {
                f4.f3496b = substring;
            }
            hashSet.add(f4);
            String a4 = cn.jiguang.common.n.d.a(hashSet);
            cn.jiguang.ao.e.e(context, str);
            cn.jiguang.ao.e.a(context, str, a4);
        }
    }

    public static c d() {
        if (f2395a == null) {
            synchronized (c.class) {
                if (f2395a == null) {
                    f2395a = new c();
                }
            }
        }
        return f2395a;
    }

    private static cn.jiguang.common.m.d f(Context context, String str) {
        cn.jiguang.common.m.d dVar;
        Map<String, cn.jiguang.common.m.d> a4 = cn.jiguang.common.n.d.a(context);
        return (a4 == null || (dVar = a4.get(str)) == null) ? cn.jiguang.common.n.d.c(context, str) : dVar;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2397c = context;
        return "JAppMovement";
    }

    public void a(Context context, Intent intent) {
        String a4 = a(context);
        cn.jiguang.w.a.b("JAppMovement", "executeMovementAction: [" + a4 + "] from broadcast");
        if (c()) {
            cn.jiguang.ah.d.a(new a(context, intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        if (this.f2396b.get()) {
            return true;
        }
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1101)) {
            return;
        }
        super.b(context, str);
        this.f2396b.set(false);
        String c4 = cn.jiguang.ao.e.c(context, "add.catch");
        if (!TextUtils.isEmpty(c4)) {
            this.f2399e = cn.jiguang.common.n.d.a(c4);
        }
        String c5 = cn.jiguang.ao.e.c(context, "rmv.catch");
        if (!TextUtils.isEmpty(c5)) {
            this.f2400f = cn.jiguang.common.n.d.a(c5);
        }
        Set<cn.jiguang.common.m.d> b4 = cn.jiguang.common.n.d.b(context);
        if (b4 == null || b4.isEmpty()) {
            cn.jiguang.w.a.f("JAppMovement", "current appList cache is empty,need collect appList first,to executeMovementAction JAppAll");
            b.d().f(context);
            return;
        }
        cn.jiguang.w.a.b("JAppMovement", "get cache appList success");
        List<cn.jiguang.common.m.d> a4 = cn.jiguang.common.n.d.a(context, true, false);
        if (a4 == null || a4.isEmpty()) {
            cn.jiguang.w.a.f("JAppMovement", "collect installedAppList failed");
            return;
        }
        cn.jiguang.w.a.b("JAppMovement", "collect installedAppList success");
        if (a4.size() == 1 && a4.get(0).f3496b.equals(context.getPackageName())) {
            cn.jiguang.w.a.f("JAppMovement", "installedAppList only has one app and this app is itself");
            return;
        }
        try {
            this.f2398d = new HashSet(b4);
            this.f2401g = new ArrayList(a4);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (cn.jiguang.common.m.d dVar : this.f2401g) {
                for (cn.jiguang.common.m.d dVar2 : this.f2398d) {
                    if (dVar2.f3496b.equals(dVar.f3496b)) {
                        arrayList2.add(dVar2);
                        arrayList.add(dVar);
                    }
                }
            }
            this.f2401g.removeAll(arrayList);
            this.f2398d.removeAll(arrayList2);
            cn.jiguang.w.a.b("JAppMovement", "currentAppInfoList size: " + this.f2401g.size() + ", installedJAppInfoCache size: " + this.f2398d.size());
        } catch (Throwable th) {
            this.f2401g.clear();
            this.f2398d.clear();
            cn.jiguang.w.a.f("JAppMovement", "currentAppInfoList throwable=" + th);
        }
        try {
            Set<cn.jiguang.common.m.d> set = this.f2399e;
            if (set != null && !set.isEmpty()) {
                Iterator<cn.jiguang.common.m.d> it = this.f2399e.iterator();
                while (it.hasNext()) {
                    cn.jiguang.common.m.d next = it.next();
                    for (cn.jiguang.common.m.d dVar3 : this.f2401g) {
                        if (dVar3.f3496b.equals(next.f3496b)) {
                            it.remove();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.w.a.f("JAppMovement", "broadcastAddJAppInfoCache throwable=" + th2);
        }
        try {
            Set<cn.jiguang.common.m.d> set2 = this.f2400f;
            if (set2 != null && set2.size() > 0) {
                this.f2398d.removeAll(this.f2400f);
            }
        } catch (Throwable th3) {
            cn.jiguang.w.a.f("JAppMovement", "installedJAppInfoCache throwable=" + th3);
        }
        if (this.f2398d.isEmpty() && this.f2401g.isEmpty()) {
            cn.jiguang.w.a.b("JAppMovement", "installedAppList has no change");
        } else {
            String a5 = cn.jiguang.common.n.d.a((Collection<cn.jiguang.common.m.d>) a4);
            if (!TextUtils.isEmpty(a5)) {
                cn.jiguang.w.a.b("JAppMovement", "update installedAppList cache:" + a4);
                cn.jiguang.ao.e.a(context, "bal.catch", a5);
            }
        }
        Set<cn.jiguang.common.m.d> set3 = this.f2400f;
        if (set3 == null || set3.isEmpty()) {
            Set<cn.jiguang.common.m.d> set4 = this.f2399e;
            if (set4 == null || set4.isEmpty()) {
                cn.jiguang.w.a.b("JAppMovement", "no broad app data");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        Set<cn.jiguang.common.m.d> set;
        Set<cn.jiguang.common.m.d> set2;
        if (cn.jiguang.ar.a.a().g(1101)) {
            return;
        }
        String packageName = context.getPackageName();
        try {
            List<cn.jiguang.common.m.d> list = this.f2401g;
            if (list != null && !list.isEmpty()) {
                for (cn.jiguang.common.m.d dVar : this.f2401g) {
                    if (!TextUtils.equals(packageName, dVar.f3496b)) {
                        if (a(dVar.f3499e, "add")) {
                            b.d().f(context);
                        } else {
                            a(dVar.f3496b, dVar.f3499e, "add", 1, dVar);
                            super.c(context, str);
                        }
                    }
                }
            }
            Set<cn.jiguang.common.m.d> set3 = this.f2398d;
            if (set3 != null && !set3.isEmpty()) {
                for (cn.jiguang.common.m.d dVar2 : this.f2398d) {
                    if (!TextUtils.equals(packageName, dVar2.f3496b)) {
                        if (a(-1000, "rmv")) {
                            b.d().f(context);
                        } else {
                            a(dVar2.f3496b, -1000, "rmv", 1, dVar2);
                            super.c(context, str);
                        }
                    }
                }
            }
            Set<cn.jiguang.common.m.d> set4 = this.f2399e;
            if (set4 != null && !set4.isEmpty()) {
                for (cn.jiguang.common.m.d dVar3 : this.f2399e) {
                    String str2 = dVar3.f3496b;
                    if (!TextUtils.equals(packageName, str2)) {
                        int a4 = cn.jiguang.common.n.d.a(cn.jiguang.common.n.d.a(context, str2));
                        if (a(a4, "add")) {
                            b.d().f(context);
                        } else {
                            a(str2, a4, "add", 0, dVar3);
                            super.c(context, str);
                        }
                    }
                }
                cn.jiguang.w.a.b("JAppMovement", "report broad add app data");
                cn.jiguang.ao.e.e(context, "add.catch");
            }
            Set<cn.jiguang.common.m.d> set5 = this.f2400f;
            if (set5 != null && !set5.isEmpty()) {
                for (cn.jiguang.common.m.d dVar4 : this.f2400f) {
                    if (!TextUtils.equals(packageName, dVar4.f3496b)) {
                        if (a(-1000, "rmv")) {
                            b.d().f(context);
                        } else {
                            a(dVar4.f3496b, -1000, "rmv", 0, dVar4);
                            super.c(context, str);
                        }
                    }
                }
                cn.jiguang.w.a.b("JAppMovement", "report broad rmv app data");
                cn.jiguang.ao.e.e(context, "rmv.catch");
            }
            List<cn.jiguang.common.m.d> list2 = this.f2401g;
            if ((list2 == null || list2.isEmpty()) && ((set = this.f2399e) == null || set.isEmpty())) {
                cn.jiguang.w.a.b("JAppMovement", "there are no add app data to report");
            }
            Set<cn.jiguang.common.m.d> set6 = this.f2398d;
            if ((set6 == null || set6.isEmpty()) && ((set2 = this.f2400f) == null || set2.isEmpty())) {
                cn.jiguang.w.a.b("JAppMovement", "there are no remove app data to report");
            }
        } catch (Throwable unused) {
        }
        this.f2401g = null;
        this.f2398d = null;
        this.f2399e = null;
        this.f2400f = null;
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        cn.jiguang.w.a.b("JAppMovement", "for googlePlay:false");
        return cn.jiguang.ar.a.a().e(1101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        Set<cn.jiguang.common.m.d> set;
        Set<cn.jiguang.common.m.d> set2;
        Set<cn.jiguang.common.m.d> set3;
        List<cn.jiguang.common.m.d> list = this.f2401g;
        return ((list == null || list.isEmpty()) && ((set = this.f2398d) == null || set.isEmpty()) && (((set2 = this.f2400f) == null || set2.isEmpty()) && ((set3 = this.f2399e) == null || set3.isEmpty()))) ? false : true;
    }
}
