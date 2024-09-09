package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.stub.StubApp;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/* compiled from: CommonClickUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static Handler f38898a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.click.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            super.handleMessage(message);
            try {
                if (message.what != 1000) {
                    return;
                }
                int i4 = message.arg1;
                int i5 = message.arg2;
                Bundle data = message.getData();
                if (data != null) {
                    String string = data.getString("rid");
                    String string2 = data.getString("rid_n");
                    str3 = data.getString(BidResponsedEx.KEY_CID);
                    str = string;
                    str2 = string2;
                } else {
                    str = "";
                    str2 = str;
                    str3 = str2;
                }
                new com.mbridge.msdk.foundation.same.report.d(com.mbridge.msdk.foundation.controller.a.f().j()).a(i4, i5, str, str2, str3);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f38899b;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf(TTPathConst.sSeparator) == -1) {
            return str.hashCode() + "";
        }
        return (str.hashCode() + str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1).hashCode()) + "";
    }

    public static void b(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
            Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
            intent.putExtra("url", str);
            if (!(context instanceof ContextThemeWrapper)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (ClassNotFoundException e4) {
            x.d("CommonClickUtil", e4.getMessage());
        } catch (Throwable th) {
            x.d("CommonClickUtil", th.getMessage());
        }
    }

    public static void c(Context context, String str) {
        com.mbridge.msdk.foundation.db.e a4 = com.mbridge.msdk.foundation.db.e.a(i.a(context));
        int c4 = a4.c(str);
        if ((Build.VERSION.SDK_INT >= 29 && com.mbridge.msdk.foundation.controller.a.f().b() == 0) && c4 == 1) {
            a4.a(str);
        }
        if (c4 == 10) {
            a4.a(str, 11);
        }
    }

    public static boolean d(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setData(parse);
            if ((parse.getScheme().startsWith(s.b("L7QthdSsLkP8")) || o.a().a(str)) && a(context, intent)) {
                return true;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            x.b("SDKCLICK", th.getMessage(), th);
            return false;
        }
    }

    public static void f(Context context, String str) {
        Intent launchIntentForPackage;
        List<ResolveInfo> queryIntentActivities;
        ResolveInfo next;
        try {
            if (TextUtils.isEmpty(str) || !d(context, str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0)) == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return;
            }
            ActivityInfo activityInfo = next.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e4) {
            Toast.makeText(context, "The app connot start up", 0).show();
            e4.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        if (str == null || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                ActivityInfo activityInfo = resolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    private static void b(Context context, String str, String str2) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j4, str2 + "downloadType", 3);
            a(context, str);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public static void b(final CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.click.c.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    CampaignEx campaignEx2 = CampaignEx.this;
                    if (campaignEx2 == null || TextUtils.isEmpty(campaignEx2.getDeepLinkURL())) {
                        return;
                    }
                    String deepLinkURL = CampaignEx.this.getDeepLinkURL();
                    if (Uri.parse(deepLinkURL).getScheme().startsWith(s.b("L7QthdSsLkP8")) || o.a().a(deepLinkURL)) {
                        com.mbridge.msdk.foundation.db.e.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(CampaignEx.this);
                    }
                } catch (Throwable th) {
                    x.d("SDKCLICK", th.getMessage());
                }
            }
        });
    }

    public static void a(Activity activity, int i4, boolean z3, Context context) {
        x.a("======", "======onActivityStarted:" + i4 + "---" + z3);
        if (Build.VERSION.SDK_INT < 29 || z3 || i4 != 0) {
            return;
        }
        x.a("======", "======onActivityStarted:inner");
        com.mbridge.msdk.foundation.entity.f a4 = com.mbridge.msdk.foundation.db.e.a(i.a(context)).a();
        if (a4 != null) {
            x.a("======", "======dlinfo:" + a4.toString());
            String a5 = a4.a();
            if (TextUtils.isEmpty(a5)) {
                return;
            }
            File file = new File(a5);
            if (file.exists()) {
                String c4 = a4.c();
                a(context, Uri.fromFile(file), a4.b(), a4.c());
                com.mbridge.msdk.foundation.same.report.e.a(context, c4, a4.d(), a4.e(), a4.f(), a4.h(), a4.g());
            }
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            String akdlui = campaignEx.getAkdlui();
            if (TextUtils.isEmpty(akdlui)) {
                akdlui = SameMD5.getMD5(campaignEx.getClickURL());
            }
            String obj = ae.b(com.mbridge.msdk.foundation.controller.a.f().j(), akdlui, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                return !new File(obj).exists();
            }
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            int intValue = ((Integer) ae.b(j4, akdlui + "process", 0)).intValue();
            int myPid = Process.myPid();
            if (intValue != 0 && intValue == myPid) {
                Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (((Long) ae.b(j5, akdlui + "isDowning", 0L)).longValue() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void a(Context context, Uri uri, String str, String str2) {
        File file;
        int intValue;
        int intValue2;
        String str3;
        String str4;
        StringBuilder sb;
        Class<?> cls;
        if (f38899b) {
            synchronized (c.class) {
                if (f38899b) {
                    return;
                }
            }
        }
        f38899b = true;
        Uri uri2 = null;
        try {
            file = new File(new URI(uri.toString()));
        } catch (URISyntaxException e4) {
            e4.printStackTrace();
            file = null;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        try {
            try {
                if (ah.b(context)) {
                    if (ah.d(context)) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            try {
                                try {
                                    if (!TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH)) {
                                        cls = Class.forName(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH);
                                    } else {
                                        cls = Class.forName("com.mbridge.msdk.foundation.tools.MBFileProvider");
                                    }
                                    uri2 = (Uri) cls.getMethod("getUriForFile", Context.class, String.class, File.class).invoke(null, context, StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName() + ".mbFileProvider", file);
                                } catch (IllegalAccessException e5) {
                                    e5.printStackTrace();
                                } catch (NoSuchMethodException e6) {
                                    e6.printStackTrace();
                                } catch (SecurityException e7) {
                                    e7.printStackTrace();
                                } catch (InvocationTargetException e8) {
                                    e8.printStackTrace();
                                }
                            } catch (ClassNotFoundException e9) {
                                e9.printStackTrace();
                            } catch (IllegalArgumentException e10) {
                                e10.printStackTrace();
                            }
                            if (uri2 != null) {
                                intent.addFlags(1);
                                intent.setDataAndType(uri2, context.getContentResolver().getType(uri2));
                                c(context, str2);
                                context.startActivity(intent);
                            } else {
                                b(context, str, str2);
                            }
                        } else {
                            intent.setDataAndType(Uri.fromFile(file), a(file));
                            c(context, str2);
                            context.startActivity(intent);
                        }
                    } else if (ah.e(context)) {
                        b(context, str, str2);
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), a(file));
                        c(context, str2);
                        context.startActivity(intent);
                    }
                } else {
                    b(context, str, str2);
                }
                f38899b = false;
                intValue = ((Integer) ae.b(context, str2 + "downloadType", -1)).intValue();
                intValue2 = ((Integer) ae.b(context, str2 + "linkType", -1)).intValue();
                str3 = (String) ae.b(context, str2 + "rid", "");
                str4 = (String) ae.b(context, str2 + "rid_n", "");
                sb = new StringBuilder();
            } catch (Exception e11) {
                e11.printStackTrace();
                b(context, str, str2);
                f38899b = false;
                intValue = ((Integer) ae.b(context, str2 + "downloadType", -1)).intValue();
                intValue2 = ((Integer) ae.b(context, str2 + "linkType", -1)).intValue();
                str3 = (String) ae.b(context, str2 + "rid", "");
                str4 = (String) ae.b(context, str2 + "rid_n", "");
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(BidResponsedEx.KEY_CID);
                a(intValue, intValue2, str3, str4, (String) ae.b(context, sb.toString(), ""));
            } catch (Throwable unused) {
                b(context, str, str2);
                f38899b = false;
                intValue = ((Integer) ae.b(context, str2 + "downloadType", -1)).intValue();
                intValue2 = ((Integer) ae.b(context, str2 + "linkType", -1)).intValue();
                str3 = (String) ae.b(context, str2 + "rid", "");
                str4 = (String) ae.b(context, str2 + "rid_n", "");
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(BidResponsedEx.KEY_CID);
                a(intValue, intValue2, str3, str4, (String) ae.b(context, sb.toString(), ""));
            }
            sb.append(str2);
            sb.append(BidResponsedEx.KEY_CID);
            a(intValue, intValue2, str3, str4, (String) ae.b(context, sb.toString(), ""));
        } catch (Throwable th) {
            f38899b = false;
            a(((Integer) ae.b(context, str2 + "downloadType", -1)).intValue(), ((Integer) ae.b(context, str2 + "linkType", -1)).intValue(), (String) ae.b(context, str2 + "rid", ""), (String) ae.b(context, str2 + "rid_n", ""), (String) ae.b(context, str2 + BidResponsedEx.KEY_CID, ""));
            throw th;
        }
    }

    private static void a(int i4, int i5, String str, String str2, String str3) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new com.mbridge.msdk.foundation.same.report.d(com.mbridge.msdk.foundation.controller.a.f().j()).a(i4, i5, str, str2, str3);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 1000;
                obtain.arg1 = i4;
                obtain.arg2 = i5;
                Bundle bundle = new Bundle();
                bundle.putString("rid", str);
                bundle.putString("rid_n", str2);
                bundle.putString(BidResponsedEx.KEY_CID, str3);
                obtain.setData(bundle);
                f38898a.sendMessage(obtain);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j4, str2 + "downloadType", 3);
            a(context, str);
            int intValue = ((Integer) ae.b(context, str2 + "downloadType", -1)).intValue();
            int intValue2 = ((Integer) ae.b(context, str2 + "linkType", -1)).intValue();
            a(intValue, intValue2, (String) ae.b(context, str2 + "rid", ""), (String) ae.b(context, str2 + "rid_n", ""), (String) ae.b(context, str2 + BidResponsedEx.KEY_CID, ""));
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    private static String a(File file) {
        String name = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase());
    }

    private static boolean a(Context context, Intent intent) {
        try {
        } catch (Throwable th) {
            x.b("SDKCLICK", th.getMessage(), th);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return true;
        }
        if (com.mbridge.msdk.foundation.controller.a.f().c() != null) {
            Context c4 = com.mbridge.msdk.foundation.controller.a.f().c();
            if (c4 instanceof Activity) {
                c4.startActivity(intent);
                return true;
            }
            return false;
        }
        return false;
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3)) {
                    str = str.replaceAll(str3, str2);
                }
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3) {
        Map<String, a.C0727a> aA;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String host = Uri.parse(str).getHost();
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null || (aA = b4.aA()) == null || TextUtils.isEmpty(host)) {
                return str;
            }
            for (Map.Entry<String, a.C0727a> entry : aA.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && host.contains(key)) {
                    a.C0727a c0727a = aA.get(key);
                    return a(a(a(a(str, c0727a.d(), String.valueOf(t.y(com.mbridge.msdk.foundation.controller.a.f().j()))), c0727a.c(), String.valueOf(t.x(com.mbridge.msdk.foundation.controller.a.f().j()))), c0727a.a(), str2), c0727a.b(), str3);
                }
            }
            return str;
        } catch (Exception e4) {
            e4.printStackTrace();
            return str;
        }
    }
}
