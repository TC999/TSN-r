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
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DlInfo;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.TargetAdaptionUtils;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/* renamed from: com.mbridge.msdk.click.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CommonClickUtil {

    /* renamed from: a */
    static Handler f30071a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.click.c.1
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
                int i = message.arg1;
                int i2 = message.arg2;
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
                new ReportController(MBSDKContext.m22865f().m22861j()).m22104a(i, i2, str, str2, str3);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    };

    /* renamed from: b */
    private static volatile boolean f30072b;

    /* renamed from: a */
    public static String m23072a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf("/") == -1) {
            return str.hashCode() + "";
        }
        return (str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode()) + "";
    }

    /* renamed from: b */
    public static void m23069b(Context context, String str) {
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
        } catch (ClassNotFoundException e) {
            SameLogTool.m21733d("CommonClickUtil", e.getMessage());
        } catch (Throwable th) {
            SameLogTool.m21733d("CommonClickUtil", th.getMessage());
        }
    }

    /* renamed from: c */
    public static void m23066c(Context context, String str) {
        CampaignDAIDao m22789a = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(context));
        int m22781c = m22789a.m22781c(str);
        if ((Build.VERSION.SDK_INT >= 29 && MBSDKContext.m22865f().m22877b() == 0) && m22781c == 1) {
            m22789a.m22787a(str);
        }
        if (m22781c == 10) {
            m22789a.m22786a(str, 11);
        }
    }

    /* renamed from: d */
    public static boolean m23065d(Context context, String str) {
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

    /* renamed from: e */
    public static boolean m23064e(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setData(parse);
            if ((parse.getScheme().startsWith(SameBase64Tool.m21812b("L7QthdSsLkP8")) || MIMManager.m21838a().m21831a(str)) && m23078a(context, intent)) {
                return true;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            SameLogTool.m21735b("SDKCLICK", th.getMessage(), th);
            return false;
        }
    }

    /* renamed from: f */
    public static void m23063f(Context context, String str) {
        Intent launchIntentForPackage;
        List<ResolveInfo> queryIntentActivities;
        ResolveInfo next;
        try {
            if (TextUtils.isEmpty(str) || !m23065d(context, str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0)) == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return;
            }
            ActivityInfo activityInfo = next.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "The app connot start up", 0).show();
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m23076a(Context context, String str) {
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
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static void m23068b(Context context, String str, String str2) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j, str2 + "downloadType", 3);
            m23076a(context, str);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m23067b(final CampaignEx campaignEx) {
        ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.click.c.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    CampaignEx campaignEx2 = CampaignEx.this;
                    if (campaignEx2 == null || TextUtils.isEmpty(campaignEx2.getDeepLinkURL())) {
                        return;
                    }
                    String deepLinkURL = CampaignEx.this.getDeepLinkURL();
                    if (Uri.parse(deepLinkURL).getScheme().startsWith(SameBase64Tool.m21812b("L7QthdSsLkP8")) || MIMManager.m21838a().m21831a(deepLinkURL)) {
                        CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22788a(CampaignEx.this);
                    }
                } catch (Throwable th) {
                    SameLogTool.m21733d("SDKCLICK", th.getMessage());
                }
            }
        });
    }

    /* renamed from: a */
    public static void m23079a(Activity activity, int i, boolean z, Context context) {
        SameLogTool.m21738a("======", "======onActivityStarted:" + i + "---" + z);
        if (Build.VERSION.SDK_INT < 29 || z || i != 0) {
            return;
        }
        SameLogTool.m21738a("======", "======onActivityStarted:inner");
        DlInfo m22790a = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(context)).m22790a();
        if (m22790a != null) {
            SameLogTool.m21738a("======", "======dlinfo:" + m22790a.toString());
            String m22578a = m22790a.m22578a();
            if (TextUtils.isEmpty(m22578a)) {
                return;
            }
            File file = new File(m22578a);
            if (file.exists()) {
                String m22574c = m22790a.m22574c();
                m23077a(context, Uri.fromFile(file), m22790a.m22576b(), m22790a.m22574c());
                C11385e.m22071a(context, m22574c, m22790a.m22572d(), m22790a.m22570e(), m22790a.m22568f(), m22790a.m22564h(), m22790a.m22566g());
            }
        }
    }

    /* renamed from: a */
    public static boolean m23074a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            String akdlui = campaignEx.getAkdlui();
            if (TextUtils.isEmpty(akdlui)) {
                akdlui = SameMD5.getMD5(campaignEx.getClickURL());
            }
            String obj = C11400ae.m21961b(MBSDKContext.m22865f().m22861j(), akdlui, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                return !new File(obj).exists();
            }
            Context m22861j = MBSDKContext.m22865f().m22861j();
            int intValue = ((Integer) C11400ae.m21961b(m22861j, akdlui + UMModuleRegister.PROCESS, 0)).intValue();
            int myPid = Process.myPid();
            if (intValue != 0 && intValue == myPid) {
                Context m22861j2 = MBSDKContext.m22865f().m22861j();
                if (((Long) C11400ae.m21961b(m22861j2, akdlui + "isDowning", 0L)).longValue() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m23077a(Context context, Uri uri, String str, String str2) {
        File file;
        int intValue;
        int intValue2;
        String str3;
        String str4;
        StringBuilder sb;
        Class<?> cls;
        if (f30072b) {
            synchronized (CommonClickUtil.class) {
                if (f30072b) {
                    return;
                }
            }
        }
        f30072b = true;
        Uri uri2 = null;
        try {
            file = new File(new URI(uri.toString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            file = null;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        try {
            try {
                if (TargetAdaptionUtils.m21954b(context)) {
                    if (TargetAdaptionUtils.m21952d(context)) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            try {
                                try {
                                    if (!TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH)) {
                                        cls = Class.forName(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH);
                                    } else {
                                        cls = Class.forName("com.mbridge.msdk.foundation.tools.MBFileProvider");
                                    }
                                    uri2 = (Uri) cls.getMethod("getUriForFile", Context.class, String.class, File.class).invoke(null, context, StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName() + ".mbFileProvider", file);
                                } catch (IllegalAccessException e2) {
                                    e2.printStackTrace();
                                } catch (NoSuchMethodException e3) {
                                    e3.printStackTrace();
                                } catch (SecurityException e4) {
                                    e4.printStackTrace();
                                } catch (InvocationTargetException e5) {
                                    e5.printStackTrace();
                                }
                            } catch (ClassNotFoundException e6) {
                                e6.printStackTrace();
                            } catch (IllegalArgumentException e7) {
                                e7.printStackTrace();
                            }
                            if (uri2 != null) {
                                intent.addFlags(1);
                                intent.setDataAndType(uri2, context.getContentResolver().getType(uri2));
                                m23066c(context, str2);
                                context.startActivity(intent);
                            } else {
                                m23068b(context, str, str2);
                            }
                        } else {
                            intent.setDataAndType(Uri.fromFile(file), m23073a(file));
                            m23066c(context, str2);
                            context.startActivity(intent);
                        }
                    } else if (TargetAdaptionUtils.m21951e(context)) {
                        m23068b(context, str, str2);
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), m23073a(file));
                        m23066c(context, str2);
                        context.startActivity(intent);
                    }
                } else {
                    m23068b(context, str, str2);
                }
                f30072b = false;
                intValue = ((Integer) C11400ae.m21961b(context, str2 + "downloadType", -1)).intValue();
                intValue2 = ((Integer) C11400ae.m21961b(context, str2 + "linkType", -1)).intValue();
                str3 = (String) C11400ae.m21961b(context, str2 + "rid", "");
                str4 = (String) C11400ae.m21961b(context, str2 + "rid_n", "");
                sb = new StringBuilder();
            } catch (Exception e8) {
                e8.printStackTrace();
                m23068b(context, str, str2);
                f30072b = false;
                intValue = ((Integer) C11400ae.m21961b(context, str2 + "downloadType", -1)).intValue();
                intValue2 = ((Integer) C11400ae.m21961b(context, str2 + "linkType", -1)).intValue();
                str3 = (String) C11400ae.m21961b(context, str2 + "rid", "");
                str4 = (String) C11400ae.m21961b(context, str2 + "rid_n", "");
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(BidResponsedEx.KEY_CID);
                m23080a(intValue, intValue2, str3, str4, (String) C11400ae.m21961b(context, sb.toString(), ""));
            } catch (Throwable unused) {
                m23068b(context, str, str2);
                f30072b = false;
                intValue = ((Integer) C11400ae.m21961b(context, str2 + "downloadType", -1)).intValue();
                intValue2 = ((Integer) C11400ae.m21961b(context, str2 + "linkType", -1)).intValue();
                str3 = (String) C11400ae.m21961b(context, str2 + "rid", "");
                str4 = (String) C11400ae.m21961b(context, str2 + "rid_n", "");
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(BidResponsedEx.KEY_CID);
                m23080a(intValue, intValue2, str3, str4, (String) C11400ae.m21961b(context, sb.toString(), ""));
            }
            sb.append(str2);
            sb.append(BidResponsedEx.KEY_CID);
            m23080a(intValue, intValue2, str3, str4, (String) C11400ae.m21961b(context, sb.toString(), ""));
        } catch (Throwable th) {
            f30072b = false;
            m23080a(((Integer) C11400ae.m21961b(context, str2 + "downloadType", -1)).intValue(), ((Integer) C11400ae.m21961b(context, str2 + "linkType", -1)).intValue(), (String) C11400ae.m21961b(context, str2 + "rid", ""), (String) C11400ae.m21961b(context, str2 + "rid_n", ""), (String) C11400ae.m21961b(context, str2 + BidResponsedEx.KEY_CID, ""));
            throw th;
        }
    }

    /* renamed from: a */
    private static void m23080a(int i, int i2, String str, String str2, String str3) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new ReportController(MBSDKContext.m22865f().m22861j()).m22104a(i, i2, str, str2, str3);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 1000;
                obtain.arg1 = i;
                obtain.arg2 = i2;
                Bundle bundle = new Bundle();
                bundle.putString("rid", str);
                bundle.putString("rid_n", str2);
                bundle.putString(BidResponsedEx.KEY_CID, str3);
                obtain.setData(bundle);
                f30071a.sendMessage(obtain);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m23075a(Context context, String str, String str2) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j, str2 + "downloadType", 3);
            m23076a(context, str);
            int intValue = ((Integer) C11400ae.m21961b(context, str2 + "downloadType", -1)).intValue();
            int intValue2 = ((Integer) C11400ae.m21961b(context, str2 + "linkType", -1)).intValue();
            m23080a(intValue, intValue2, (String) C11400ae.m21961b(context, str2 + "rid", ""), (String) C11400ae.m21961b(context, str2 + "rid_n", ""), (String) C11400ae.m21961b(context, str2 + BidResponsedEx.KEY_CID, ""));
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static String m23073a(File file) {
        String name = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase());
    }

    /* renamed from: a */
    private static boolean m23078a(Context context, Intent intent) {
        try {
        } catch (Throwable th) {
            SameLogTool.m21735b("SDKCLICK", th.getMessage(), th);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return true;
        }
        if (MBSDKContext.m22865f().m22872c() != null) {
            Context m22872c = MBSDKContext.m22865f().m22872c();
            if (m22872c instanceof Activity) {
                m22872c.startActivity(intent);
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private static String m23070a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3)) {
                    str = str.replaceAll(str3, str2);
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m23071a(String str, String str2, String str3) {
        Map<String, Setting.C11193a> m23397aA;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String host = Uri.parse(str).getHost();
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null || (m23397aA = m23252b.m23397aA()) == null || TextUtils.isEmpty(host)) {
                return str;
            }
            for (Map.Entry<String, Setting.C11193a> entry : m23397aA.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && host.contains(key)) {
                    Setting.C11193a c11193a = m23397aA.get(key);
                    return m23070a(m23070a(m23070a(m23070a(str, c11193a.m23267d(), String.valueOf(SameDiTool.m21763y(MBSDKContext.m22865f().m22861j()))), c11193a.m23268c(), String.valueOf(SameDiTool.m21765x(MBSDKContext.m22865f().m22861j()))), c11193a.m23271a(), str2), c11193a.m23269b(), str3);
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
