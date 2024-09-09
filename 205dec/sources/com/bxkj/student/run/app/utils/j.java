package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import com.bxkj.student.App;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: IntentWrapper.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    protected static final int f22825c = 98;

    /* renamed from: d  reason: collision with root package name */
    protected static final int f22826d = 99;

    /* renamed from: e  reason: collision with root package name */
    protected static final int f22827e = 100;

    /* renamed from: f  reason: collision with root package name */
    protected static final int f22828f = 101;

    /* renamed from: g  reason: collision with root package name */
    protected static final int f22829g = 102;

    /* renamed from: h  reason: collision with root package name */
    protected static final int f22830h = 103;

    /* renamed from: i  reason: collision with root package name */
    protected static final int f22831i = 104;

    /* renamed from: j  reason: collision with root package name */
    protected static final int f22832j = 105;

    /* renamed from: k  reason: collision with root package name */
    protected static final int f22833k = 106;

    /* renamed from: l  reason: collision with root package name */
    protected static final int f22834l = 107;

    /* renamed from: m  reason: collision with root package name */
    protected static final int f22835m = 108;

    /* renamed from: n  reason: collision with root package name */
    protected static final int f22836n = 109;

    /* renamed from: o  reason: collision with root package name */
    protected static final int f22837o = 110;

    /* renamed from: p  reason: collision with root package name */
    protected static final int f22838p = 111;

    /* renamed from: q  reason: collision with root package name */
    protected static final int f22839q = 112;

    /* renamed from: r  reason: collision with root package name */
    protected static final int f22840r = 113;

    /* renamed from: s  reason: collision with root package name */
    protected static final int f22841s = 114;

    /* renamed from: t  reason: collision with root package name */
    protected static final int f22842t = 115;

    /* renamed from: u  reason: collision with root package name */
    protected static final int f22843u = 116;

    /* renamed from: v  reason: collision with root package name */
    protected static final int f22844v = 117;

    /* renamed from: w  reason: collision with root package name */
    protected static List<j> f22845w;

    /* renamed from: x  reason: collision with root package name */
    protected static String f22846x;

    /* renamed from: a  reason: collision with root package name */
    protected Intent f22847a;

    /* renamed from: b  reason: collision with root package name */
    protected int f22848b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22850b;

        a(final Activity val$a) {
            this.f22850b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22850b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22852b;

        b(final Activity val$a) {
            this.f22852b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22852b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22854b;

        c(final Activity val$a) {
            this.f22854b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22854b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22856b;

        d(final Activity val$a) {
            this.f22856b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22856b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22858b;

        e(final Activity val$a) {
            this.f22858b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22858b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22860b;

        f(final Activity val$a) {
            this.f22860b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22860b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22862b;

        g(final Activity val$a) {
            this.f22862b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22862b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class h implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22864b;

        h(final Activity val$a) {
            this.f22864b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22864b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class i implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22866b;

        i(final Activity val$a) {
            this.f22866b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22866b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$j  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class DialogInterface$OnClickListenerC0283j implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22868b;

        DialogInterface$OnClickListenerC0283j(final Activity val$a) {
            this.f22868b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22868b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class k implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22870b;

        k(final Activity val$a) {
            this.f22870b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22870b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class l implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22872b;

        l(final Activity val$a) {
            this.f22872b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22872b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class m implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22874b;

        m(final Activity val$a) {
            this.f22874b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22874b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class n implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22876b;

        n(final Activity val$a) {
            this.f22876b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22876b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: IntentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class o implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f22878b;

        o(final Activity val$a) {
            this.f22878b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d4, int w3) {
            j.this.e(this.f22878b);
        }
    }

    protected j(Intent intent, int type) {
        this.f22847a = intent;
        this.f22848b = type;
    }

    public static String b() {
        if (f22846x == null) {
            try {
                PackageManager packageManager = App.o().getPackageManager();
                f22846x = packageManager.getApplicationLabel(packageManager.getApplicationInfo(App.o().getPackageName(), 0)).toString();
            } catch (PackageManager.NameNotFoundException e4) {
                e4.printStackTrace();
                f22846x = App.o().getPackageName();
            }
        }
        return f22846x;
    }

    public static List<j> c() {
        if (f22845w == null) {
            f22845w = new ArrayList();
            if (Build.VERSION.SDK_INT >= 24 && !((PowerManager) App.o().getSystemService("power")).isIgnoringBatteryOptimizations(App.o().getPackageName())) {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                intent.setData(Uri.parse("package:" + App.o().getPackageName()));
                f22845w.add(new j(intent, 98));
            }
            Intent intent2 = new Intent();
            intent2.setAction("huawei.intent.action.HSM_BOOTAPP_MANAGER");
            f22845w.add(new j(intent2, 99));
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            f22845w.add(new j(intent3, 100));
            Intent intent4 = new Intent();
            intent4.setAction("miui.intent.action.OP_AUTO_START");
            intent4.addCategory("android.intent.category.DEFAULT");
            f22845w.add(new j(intent4, 101));
            Intent intent5 = new Intent();
            intent5.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent5.putExtra("package_name", App.o().getPackageName());
            intent5.putExtra("package_label", b());
            f22845w.add(new j(intent5, 102));
            Intent launchIntentForPackage = App.o().getPackageManager().getLaunchIntentForPackage("com.samsung.android.sm");
            if (launchIntentForPackage != null) {
                f22845w.add(new j(launchIntentForPackage, 103));
            }
            Intent intent6 = new Intent();
            intent6.setComponent(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.battery.BatteryActivity"));
            f22845w.add(new j(intent6, 107));
            Intent intent7 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent7.addCategory("android.intent.category.DEFAULT");
            intent7.putExtra("packageName", App.o().getPackageName());
            f22845w.add(new j(intent7, 104));
            Intent intent8 = new Intent();
            intent8.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.powerui.PowerAppPermissionActivity"));
            f22845w.add(new j(intent8, 105));
            Intent intent9 = new Intent();
            intent9.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            f22845w.add(new j(intent9, 106));
            Intent intent10 = new Intent();
            intent10.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
            f22845w.add(new j(intent10, 108));
            Intent intent11 = new Intent();
            intent11.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
            f22845w.add(new j(intent11, 109));
            Intent intent12 = new Intent();
            intent12.setComponent(new ComponentName("com.gionee.softmanager", "com.gionee.softmanager.MainActivity"));
            f22845w.add(new j(intent12, 110));
            Intent intent13 = new Intent();
            intent13.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
            f22845w.add(new j(intent13, 111));
            Intent intent14 = new Intent();
            intent14.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"));
            f22845w.add(new j(intent14, 112));
            Intent intent15 = new Intent();
            intent15.setComponent(new ComponentName("com.yulong.android.security", "com.yulong.android.seccenter.tabbarmain"));
            f22845w.add(new j(intent15, 113));
            Intent intent16 = new Intent();
            intent16.setComponent(new ComponentName("com.lenovo.security", "com.lenovo.security.purebackground.PureBackgroundActivity"));
            f22845w.add(new j(intent16, 114));
            Intent intent17 = new Intent();
            intent17.setComponent(new ComponentName("com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerApplicationsActivity"));
            f22845w.add(new j(intent17, 115));
            Intent intent18 = new Intent();
            intent18.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.autorun.AppAutoRunManager"));
            f22845w.add(new j(intent18, 116));
            Intent intent19 = new Intent();
            intent19.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.setting.ClearAppSettingsActivity"));
            f22845w.add(new j(intent19, 117));
        }
        return f22845w;
    }

    public static void d(Activity a4) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        a4.startActivity(intent);
    }

    @NonNull
    public static List<j> f(final Activity a4, String reason) {
        ArrayList arrayList = new ArrayList();
        if (reason == null) {
            reason = "\u6838\u5fc3\u670d\u52a1\u7684\u6301\u7eed\u8fd0\u884c";
        }
        for (j jVar : c()) {
            if (jVar.a()) {
                switch (jVar.f22848b) {
                    case 98:
                        if (Build.VERSION.SDK_INT >= 24) {
                            if (((PowerManager) a4.getSystemService("power")).isIgnoringBatteryOptimizations(a4.getPackageName())) {
                                break;
                            } else {
                                AlertDialog.Builder cancelable = new AlertDialog.Builder(a4).setCancelable(false);
                                AlertDialog.Builder title = cancelable.setTitle("\u9700\u8981\u5ffd\u7565 " + b() + " \u7684\u7535\u6c60\u4f18\u5316");
                                title.setMessage(reason + "\u9700\u8981 " + b() + " \u52a0\u5165\u5230\u7535\u6c60\u4f18\u5316\u7684\u5ffd\u7565\u540d\u5355\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u5ffd\u7565\u7535\u6c60\u4f18\u5316\u300f\u5bf9\u8bdd\u6846\u4e2d\uff0c\u9009\u62e9\u300e\u662f\u300f\u3002").setPositiveButton("\u786e\u5b9a", new g(a4)).show();
                                arrayList.add(jVar);
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 99:
                        AlertDialog.Builder cancelable2 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title2 = cancelable2.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u81ea\u52a8\u542f\u52a8");
                        title2.setMessage(reason + "\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u52a8\u542f\u52a8\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u81ea\u542f\u7ba1\u7406\u300f\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new h(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 100:
                    case 117:
                        AlertDialog.Builder cancelable3 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title3 = cancelable3.setTitle(b() + " \u9700\u8981\u52a0\u5165\u9501\u5c4f\u6e05\u7406\u767d\u540d\u5355");
                        title3.setMessage(reason + "\u9700\u8981 " + b() + " \u52a0\u5165\u5230\u9501\u5c4f\u6e05\u7406\u767d\u540d\u5355\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u9501\u5c4f\u6e05\u7406\u300f\u5217\u8868\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new i(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 101:
                    case 106:
                    case 108:
                    case 111:
                    case 116:
                        AlertDialog.Builder cancelable4 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title4 = cancelable4.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u542f\u52a8");
                        title4.setMessage(reason + "\u9700\u8981 " + b() + " \u52a0\u5165\u5230\u81ea\u542f\u52a8\u767d\u540d\u5355\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u81ea\u542f\u52a8\u7ba1\u7406\u300f\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new o(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 102:
                        AlertDialog.Builder cancelable5 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title5 = cancelable5.setTitle("\u9700\u8981\u5173\u95ed " + b() + " \u7684\u795e\u9690\u6a21\u5f0f");
                        title5.setMessage(reason + "\u9700\u8981\u5173\u95ed " + b() + " \u7684\u795e\u9690\u6a21\u5f0f\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684 " + b() + " \u795e\u9690\u6a21\u5f0f\u8bbe\u7f6e\u4e2d\uff0c\u9009\u62e9\u300e\u65e0\u9650\u5236\u300f").setPositiveButton("\u786e\u5b9a", new DialogInterface$OnClickListenerC0283j(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 103:
                        AlertDialog.Builder cancelable6 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title6 = cancelable6.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u542f\u52a8");
                        title6.setMessage(reason + "\u9700\u8981 " + b() + " \u5728\u5c4f\u5e55\u5173\u95ed\u65f6\u7ee7\u7eed\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u667a\u80fd\u7ba1\u7406\u5668\u300f\u4e2d\uff0c\u70b9\u51fb\u300e\u5185\u5b58\u300f\uff0c\u9009\u62e9\u300e\u81ea\u542f\u52a8\u5e94\u7528\u7a0b\u5e8f\u300f\u9009\u9879\u5361\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new k(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 104:
                        AlertDialog.Builder cancelable7 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title7 = cancelable7.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u4fdd\u6301\u540e\u53f0\u8fd0\u884c");
                        title7.setMessage(reason + "\u9700\u8981\u5141\u8bb8 " + b() + " \u4fdd\u6301\u540e\u53f0\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u5e94\u7528\u4fe1\u606f\u754c\u9762\u4e2d\uff0c\u5c06\u300e\u540e\u53f0\u7ba1\u7406\u300f\u9009\u9879\u66f4\u6539\u4e3a\u300e\u4fdd\u6301\u540e\u53f0\u8fd0\u884c\u300f\u3002").setPositiveButton("\u786e\u5b9a", new m(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 105:
                        AlertDialog.Builder cancelable8 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title8 = cancelable8.setTitle(b() + " \u9700\u8981\u5728\u5f85\u673a\u65f6\u4fdd\u6301\u8fd0\u884c");
                        title8.setMessage(reason + "\u9700\u8981 " + b() + " \u5728\u5f85\u673a\u65f6\u4fdd\u6301\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u5f85\u673a\u8017\u7535\u7ba1\u7406\u300f\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new n(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 107:
                        AlertDialog.Builder cancelable9 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title9 = cancelable9.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u542f\u52a8");
                        title9.setMessage(reason + "\u9700\u8981 " + b() + " \u5728\u5c4f\u5e55\u5173\u95ed\u65f6\u7ee7\u7eed\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u7535\u6c60\u300f\u9875\u9762\u4e2d\uff0c\u70b9\u51fb\u300e\u672a\u76d1\u89c6\u7684\u5e94\u7528\u7a0b\u5e8f\u300f->\u300e\u6dfb\u52a0\u5e94\u7528\u7a0b\u5e8f\u300f\uff0c\u52fe\u9009 " + b() + "\uff0c\u7136\u540e\u70b9\u51fb\u300e\u5b8c\u6210\u300f\u3002").setPositiveButton("\u786e\u5b9a", new l(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 109:
                        AlertDialog.Builder cancelable10 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title10 = cancelable10.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u540e\u53f0\u8fd0\u884c");
                        title10.setMessage(reason + "\u9700\u8981\u5141\u8bb8 " + b() + " \u5728\u540e\u53f0\u9ad8\u8017\u7535\u65f6\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u540e\u53f0\u9ad8\u8017\u7535\u300f\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new b(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 110:
                        AlertDialog.Builder cancelable11 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title11 = cancelable11.setTitle(b() + " \u9700\u8981\u52a0\u5165\u5e94\u7528\u81ea\u542f\u548c\u7eff\u8272\u540e\u53f0\u767d\u540d\u5355");
                        title11.setMessage(reason + "\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u542f\u52a8\u548c\u540e\u53f0\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u7cfb\u7edf\u7ba1\u5bb6\u300f\u4e2d\uff0c\u5206\u522b\u627e\u5230\u300e\u5e94\u7528\u7ba1\u7406\u300f->\u300e\u5e94\u7528\u81ea\u542f\u300f\u548c\u300e\u7eff\u8272\u540e\u53f0\u300f->\u300e\u6e05\u7406\u767d\u540d\u5355\u300f\uff0c\u5c06 " + b() + " \u6dfb\u52a0\u5230\u767d\u540d\u5355\u3002").setPositiveButton("\u786e\u5b9a", new c(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 112:
                        AlertDialog.Builder cancelable12 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title12 = cancelable12.setTitle("\u9700\u8981\u7981\u6b62 " + b() + " \u88ab\u81ea\u52a8\u6e05\u7406");
                        title12.setMessage(reason + "\u9700\u8981\u7981\u6b62 " + b() + " \u88ab\u81ea\u52a8\u6e05\u7406\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u5e94\u7528\u4fdd\u62a4\u300f\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u5173\u95ed\u3002").setPositiveButton("\u786e\u5b9a", new d(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 113:
                        AlertDialog.Builder cancelable13 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title13 = cancelable13.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u542f\u52a8");
                        title13.setMessage(reason + "\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u81ea\u542f\u52a8\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u9177\u7ba1\u5bb6\u300f\u4e2d\uff0c\u627e\u5230\u300e\u8f6f\u4ef6\u7ba1\u7406\u300f->\u300e\u81ea\u542f\u52a8\u7ba1\u7406\u300f\uff0c\u53d6\u6d88\u52fe\u9009 " + b() + "\uff0c\u5c06 " + b() + " \u7684\u72b6\u6001\u6539\u4e3a\u300e\u5df2\u5141\u8bb8\u300f\u3002").setPositiveButton("\u786e\u5b9a", new a(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 114:
                        AlertDialog.Builder cancelable14 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title14 = cancelable14.setTitle("\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u540e\u53f0\u8fd0\u884c");
                        title14.setMessage(reason + "\u9700\u8981\u5141\u8bb8 " + b() + " \u7684\u540e\u53f0\u81ea\u542f\u3001\u540e\u53f0 GPS \u548c\u540e\u53f0\u8fd0\u884c\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u540e\u53f0\u7ba1\u7406\u300f\u4e2d\uff0c\u5206\u522b\u627e\u5230\u300e\u540e\u53f0\u81ea\u542f\u300f\u3001\u300e\u540e\u53f0 GPS\u300f\u548c\u300e\u540e\u53f0\u8fd0\u884c\u300f\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u6253\u5f00\u3002").setPositiveButton("\u786e\u5b9a", new e(a4)).show();
                        arrayList.add(jVar);
                        continue;
                    case 115:
                        AlertDialog.Builder cancelable15 = new AlertDialog.Builder(a4).setCancelable(false);
                        AlertDialog.Builder title15 = cancelable15.setTitle("\u9700\u8981\u5173\u95ed " + b() + " \u7684\u540e\u53f0\u8017\u7535\u4f18\u5316");
                        title15.setMessage(reason + "\u9700\u8981\u5173\u95ed " + b() + " \u7684\u540e\u53f0\u8017\u7535\u4f18\u5316\u3002\n\n\u8bf7\u70b9\u51fb\u300e\u786e\u5b9a\u300f\uff0c\u5728\u5f39\u51fa\u7684\u300e\u540e\u53f0\u8017\u7535\u4f18\u5316\u300f\u4e2d\uff0c\u5c06 " + b() + " \u5bf9\u5e94\u7684\u5f00\u5173\u5173\u95ed\u3002").setPositiveButton("\u786e\u5b9a", new f(a4)).show();
                        arrayList.add(jVar);
                        continue;
                }
            }
        }
        return arrayList;
    }

    protected boolean a() {
        List<ResolveInfo> queryIntentActivities = App.o().getPackageManager().queryIntentActivities(this.f22847a, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    protected void e(Activity activityContext) {
        try {
            activityContext.startActivity(this.f22847a);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
