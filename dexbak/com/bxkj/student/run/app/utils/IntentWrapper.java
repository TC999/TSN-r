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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.j */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class IntentWrapper {

    /* renamed from: c */
    protected static final int f19595c = 98;

    /* renamed from: d */
    protected static final int f19596d = 99;

    /* renamed from: e */
    protected static final int f19597e = 100;

    /* renamed from: f */
    protected static final int f19598f = 101;

    /* renamed from: g */
    protected static final int f19599g = 102;

    /* renamed from: h */
    protected static final int f19600h = 103;

    /* renamed from: i */
    protected static final int f19601i = 104;

    /* renamed from: j */
    protected static final int f19602j = 105;

    /* renamed from: k */
    protected static final int f19603k = 106;

    /* renamed from: l */
    protected static final int f19604l = 107;

    /* renamed from: m */
    protected static final int f19605m = 108;

    /* renamed from: n */
    protected static final int f19606n = 109;

    /* renamed from: o */
    protected static final int f19607o = 110;

    /* renamed from: p */
    protected static final int f19608p = 111;

    /* renamed from: q */
    protected static final int f19609q = 112;

    /* renamed from: r */
    protected static final int f19610r = 113;

    /* renamed from: s */
    protected static final int f19611s = 114;

    /* renamed from: t */
    protected static final int f19612t = 115;

    /* renamed from: u */
    protected static final int f19613u = 116;

    /* renamed from: v */
    protected static final int f19614v = 117;

    /* renamed from: w */
    protected static List<IntentWrapper> f19615w;

    /* renamed from: x */
    protected static String f19616x;

    /* renamed from: a */
    protected Intent f19617a;

    /* renamed from: b */
    protected int f19618b;

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5384a implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19620b;

        DialogInterface$OnClickListenerC5384a(final Activity val$a) {
            this.f19620b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19620b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5385b implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19622b;

        DialogInterface$OnClickListenerC5385b(final Activity val$a) {
            this.f19622b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19622b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5386c implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19624b;

        DialogInterface$OnClickListenerC5386c(final Activity val$a) {
            this.f19624b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19624b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5387d implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19626b;

        DialogInterface$OnClickListenerC5387d(final Activity val$a) {
            this.f19626b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19626b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5388e implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19628b;

        DialogInterface$OnClickListenerC5388e(final Activity val$a) {
            this.f19628b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19628b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5389f implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19630b;

        DialogInterface$OnClickListenerC5389f(final Activity val$a) {
            this.f19630b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19630b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5390g implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19632b;

        DialogInterface$OnClickListenerC5390g(final Activity val$a) {
            this.f19632b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19632b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5391h implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19634b;

        DialogInterface$OnClickListenerC5391h(final Activity val$a) {
            this.f19634b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19634b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5392i implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19636b;

        DialogInterface$OnClickListenerC5392i(final Activity val$a) {
            this.f19636b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19636b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5393j implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19638b;

        DialogInterface$OnClickListenerC5393j(final Activity val$a) {
            this.f19638b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19638b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5394k implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19640b;

        DialogInterface$OnClickListenerC5394k(final Activity val$a) {
            this.f19640b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19640b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5395l implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19642b;

        DialogInterface$OnClickListenerC5395l(final Activity val$a) {
            this.f19642b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19642b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5396m implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19644b;

        DialogInterface$OnClickListenerC5396m(final Activity val$a) {
            this.f19644b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19644b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5397n implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19646b;

        DialogInterface$OnClickListenerC5397n(final Activity val$a) {
            this.f19646b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19646b);
        }
    }

    /* compiled from: IntentWrapper.java */
    /* renamed from: com.bxkj.student.run.app.utils.j$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class DialogInterface$OnClickListenerC5398o implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ Activity f19648b;

        DialogInterface$OnClickListenerC5398o(final Activity val$a) {
            this.f19648b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d, int w) {
            IntentWrapper.this.m39611e(this.f19648b);
        }
    }

    protected IntentWrapper(Intent intent, int type) {
        this.f19617a = intent;
        this.f19618b = type;
    }

    /* renamed from: b */
    public static String m39614b() {
        if (f19616x == null) {
            try {
                PackageManager packageManager = App.m43005o().getPackageManager();
                f19616x = packageManager.getApplicationLabel(packageManager.getApplicationInfo(App.m43005o().getPackageName(), 0)).toString();
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                f19616x = App.m43005o().getPackageName();
            }
        }
        return f19616x;
    }

    /* renamed from: c */
    public static List<IntentWrapper> m39613c() {
        if (f19615w == null) {
            f19615w = new ArrayList();
            if (Build.VERSION.SDK_INT >= 24 && !((PowerManager) App.m43005o().getSystemService("power")).isIgnoringBatteryOptimizations(App.m43005o().getPackageName())) {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                intent.setData(Uri.parse("package:" + App.m43005o().getPackageName()));
                f19615w.add(new IntentWrapper(intent, 98));
            }
            Intent intent2 = new Intent();
            intent2.setAction("huawei.intent.action.HSM_BOOTAPP_MANAGER");
            f19615w.add(new IntentWrapper(intent2, 99));
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            f19615w.add(new IntentWrapper(intent3, 100));
            Intent intent4 = new Intent();
            intent4.setAction("miui.intent.action.OP_AUTO_START");
            intent4.addCategory("android.intent.category.DEFAULT");
            f19615w.add(new IntentWrapper(intent4, 101));
            Intent intent5 = new Intent();
            intent5.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent5.putExtra("package_name", App.m43005o().getPackageName());
            intent5.putExtra("package_label", m39614b());
            f19615w.add(new IntentWrapper(intent5, 102));
            Intent launchIntentForPackage = App.m43005o().getPackageManager().getLaunchIntentForPackage("com.samsung.android.sm");
            if (launchIntentForPackage != null) {
                f19615w.add(new IntentWrapper(launchIntentForPackage, 103));
            }
            Intent intent6 = new Intent();
            intent6.setComponent(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.battery.BatteryActivity"));
            f19615w.add(new IntentWrapper(intent6, 107));
            Intent intent7 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent7.addCategory("android.intent.category.DEFAULT");
            intent7.putExtra(TTDownloadField.TT_PACKAGE_NAME, App.m43005o().getPackageName());
            f19615w.add(new IntentWrapper(intent7, 104));
            Intent intent8 = new Intent();
            intent8.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.powerui.PowerAppPermissionActivity"));
            f19615w.add(new IntentWrapper(intent8, 105));
            Intent intent9 = new Intent();
            intent9.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            f19615w.add(new IntentWrapper(intent9, 106));
            Intent intent10 = new Intent();
            intent10.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
            f19615w.add(new IntentWrapper(intent10, 108));
            Intent intent11 = new Intent();
            intent11.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
            f19615w.add(new IntentWrapper(intent11, 109));
            Intent intent12 = new Intent();
            intent12.setComponent(new ComponentName("com.gionee.softmanager", "com.gionee.softmanager.MainActivity"));
            f19615w.add(new IntentWrapper(intent12, 110));
            Intent intent13 = new Intent();
            intent13.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
            f19615w.add(new IntentWrapper(intent13, 111));
            Intent intent14 = new Intent();
            intent14.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"));
            f19615w.add(new IntentWrapper(intent14, 112));
            Intent intent15 = new Intent();
            intent15.setComponent(new ComponentName("com.yulong.android.security", "com.yulong.android.seccenter.tabbarmain"));
            f19615w.add(new IntentWrapper(intent15, 113));
            Intent intent16 = new Intent();
            intent16.setComponent(new ComponentName("com.lenovo.security", "com.lenovo.security.purebackground.PureBackgroundActivity"));
            f19615w.add(new IntentWrapper(intent16, 114));
            Intent intent17 = new Intent();
            intent17.setComponent(new ComponentName("com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerApplicationsActivity"));
            f19615w.add(new IntentWrapper(intent17, 115));
            Intent intent18 = new Intent();
            intent18.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.autorun.AppAutoRunManager"));
            f19615w.add(new IntentWrapper(intent18, 116));
            Intent intent19 = new Intent();
            intent19.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.setting.ClearAppSettingsActivity"));
            f19615w.add(new IntentWrapper(intent19, 117));
        }
        return f19615w;
    }

    /* renamed from: d */
    public static void m39612d(Activity a) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        a.startActivity(intent);
    }

    @NonNull
    /* renamed from: f */
    public static List<IntentWrapper> m39610f(final Activity a, String reason) {
        ArrayList arrayList = new ArrayList();
        if (reason == null) {
            reason = "核心服务的持续运行";
        }
        for (IntentWrapper intentWrapper : m39613c()) {
            if (intentWrapper.m39615a()) {
                switch (intentWrapper.f19618b) {
                    case 98:
                        if (Build.VERSION.SDK_INT >= 24) {
                            if (((PowerManager) a.getSystemService("power")).isIgnoringBatteryOptimizations(a.getPackageName())) {
                                break;
                            } else {
                                AlertDialog.Builder cancelable = new AlertDialog.Builder(a).setCancelable(false);
                                AlertDialog.Builder title = cancelable.setTitle("需要忽略 " + m39614b() + " 的电池优化");
                                title.setMessage(reason + "需要 " + m39614b() + " 加入到电池优化的忽略名单。\n\n请点击『确定』，在弹出的『忽略电池优化』对话框中，选择『是』。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5390g(a)).show();
                                arrayList.add(intentWrapper);
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 99:
                        AlertDialog.Builder cancelable2 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title2 = cancelable2.setTitle("需要允许 " + m39614b() + " 自动启动");
                        title2.setMessage(reason + "需要允许 " + m39614b() + " 的自动启动。\n\n请点击『确定』，在弹出的『自启管理』中，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5391h(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 100:
                    case 117:
                        AlertDialog.Builder cancelable3 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title3 = cancelable3.setTitle(m39614b() + " 需要加入锁屏清理白名单");
                        title3.setMessage(reason + "需要 " + m39614b() + " 加入到锁屏清理白名单。\n\n请点击『确定』，在弹出的『锁屏清理』列表中，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5392i(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 101:
                    case 106:
                    case 108:
                    case 111:
                    case 116:
                        AlertDialog.Builder cancelable4 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title4 = cancelable4.setTitle("需要允许 " + m39614b() + " 的自启动");
                        title4.setMessage(reason + "需要 " + m39614b() + " 加入到自启动白名单。\n\n请点击『确定』，在弹出的『自启动管理』中，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5398o(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 102:
                        AlertDialog.Builder cancelable5 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title5 = cancelable5.setTitle("需要关闭 " + m39614b() + " 的神隐模式");
                        title5.setMessage(reason + "需要关闭 " + m39614b() + " 的神隐模式。\n\n请点击『确定』，在弹出的 " + m39614b() + " 神隐模式设置中，选择『无限制』").setPositiveButton("确定", new DialogInterface$OnClickListenerC5393j(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 103:
                        AlertDialog.Builder cancelable6 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title6 = cancelable6.setTitle("需要允许 " + m39614b() + " 的自启动");
                        title6.setMessage(reason + "需要 " + m39614b() + " 在屏幕关闭时继续运行。\n\n请点击『确定』，在弹出的『智能管理器』中，点击『内存』，选择『自启动应用程序』选项卡，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5394k(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 104:
                        AlertDialog.Builder cancelable7 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title7 = cancelable7.setTitle("需要允许 " + m39614b() + " 保持后台运行");
                        title7.setMessage(reason + "需要允许 " + m39614b() + " 保持后台运行。\n\n请点击『确定』，在弹出的应用信息界面中，将『后台管理』选项更改为『保持后台运行』。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5396m(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 105:
                        AlertDialog.Builder cancelable8 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title8 = cancelable8.setTitle(m39614b() + " 需要在待机时保持运行");
                        title8.setMessage(reason + "需要 " + m39614b() + " 在待机时保持运行。\n\n请点击『确定』，在弹出的『待机耗电管理』中，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5397n(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 107:
                        AlertDialog.Builder cancelable9 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title9 = cancelable9.setTitle("需要允许 " + m39614b() + " 的自启动");
                        title9.setMessage(reason + "需要 " + m39614b() + " 在屏幕关闭时继续运行。\n\n请点击『确定』，在弹出的『电池』页面中，点击『未监视的应用程序』->『添加应用程序』，勾选 " + m39614b() + "，然后点击『完成』。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5395l(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 109:
                        AlertDialog.Builder cancelable10 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title10 = cancelable10.setTitle("需要允许 " + m39614b() + " 的后台运行");
                        title10.setMessage(reason + "需要允许 " + m39614b() + " 在后台高耗电时运行。\n\n请点击『确定』，在弹出的『后台高耗电』中，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5385b(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 110:
                        AlertDialog.Builder cancelable11 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title11 = cancelable11.setTitle(m39614b() + " 需要加入应用自启和绿色后台白名单");
                        title11.setMessage(reason + "需要允许 " + m39614b() + " 的自启动和后台运行。\n\n请点击『确定』，在弹出的『系统管家』中，分别找到『应用管理』->『应用自启』和『绿色后台』->『清理白名单』，将 " + m39614b() + " 添加到白名单。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5386c(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 112:
                        AlertDialog.Builder cancelable12 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title12 = cancelable12.setTitle("需要禁止 " + m39614b() + " 被自动清理");
                        title12.setMessage(reason + "需要禁止 " + m39614b() + " 被自动清理。\n\n请点击『确定』，在弹出的『应用保护』中，将 " + m39614b() + " 对应的开关关闭。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5387d(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 113:
                        AlertDialog.Builder cancelable13 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title13 = cancelable13.setTitle("需要允许 " + m39614b() + " 的自启动");
                        title13.setMessage(reason + "需要允许 " + m39614b() + " 的自启动。\n\n请点击『确定』，在弹出的『酷管家』中，找到『软件管理』->『自启动管理』，取消勾选 " + m39614b() + "，将 " + m39614b() + " 的状态改为『已允许』。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5384a(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 114:
                        AlertDialog.Builder cancelable14 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title14 = cancelable14.setTitle("需要允许 " + m39614b() + " 的后台运行");
                        title14.setMessage(reason + "需要允许 " + m39614b() + " 的后台自启、后台 GPS 和后台运行。\n\n请点击『确定』，在弹出的『后台管理』中，分别找到『后台自启』、『后台 GPS』和『后台运行』，将 " + m39614b() + " 对应的开关打开。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5388e(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                    case 115:
                        AlertDialog.Builder cancelable15 = new AlertDialog.Builder(a).setCancelable(false);
                        AlertDialog.Builder title15 = cancelable15.setTitle("需要关闭 " + m39614b() + " 的后台耗电优化");
                        title15.setMessage(reason + "需要关闭 " + m39614b() + " 的后台耗电优化。\n\n请点击『确定』，在弹出的『后台耗电优化』中，将 " + m39614b() + " 对应的开关关闭。").setPositiveButton("确定", new DialogInterface$OnClickListenerC5389f(a)).show();
                        arrayList.add(intentWrapper);
                        continue;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected boolean m39615a() {
        List<ResolveInfo> queryIntentActivities = App.m43005o().getPackageManager().queryIntentActivities(this.f19617a, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    /* renamed from: e */
    protected void m39611e(Activity activityContext) {
        try {
            activityContext.startActivity(this.f19617a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
