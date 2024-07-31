package com.mbridge.msdk.p462d;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.clj.fastble.BleManager;
import com.mbridge.msdk.DomainMBridgeConstans;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.p472db.CampaignDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ShortCutsManager {

    /* renamed from: b */
    private static volatile ShortCutsManager f30159b;

    /* renamed from: a */
    private WeakReference<Context> f30160a;

    /* renamed from: c */
    private Handler f30161c = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.d.b.3
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            try {
                int i = message.arg1;
                Object obj = message.obj;
                ShortCutsManager.m22990a(ShortCutsManager.this, i, obj instanceof String ? (String) obj : null);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    };

    private ShortCutsManager(Context context) {
        this.f30160a = new WeakReference<>(context);
    }

    /* renamed from: b */
    private String m22979b(Context context) {
        return "";
    }

    /* renamed from: c */
    private String m22974c(Context context) {
        String m22979b = m22979b(context);
        if (m22979b == null || m22979b.trim().equals("")) {
            m22980b();
            m22979b = "";
        }
        if (TextUtils.isEmpty(m22979b)) {
            m22979b = Build.VERSION.SDK_INT < 19 ? "com.android.launcher2.settings" : "com.android.launcher3.settings";
        }
        return "content://" + m22979b + "/favorites?notify=true";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m22976b(String str) {
        Context context = this.f30160a.get();
        if (context != null && (m22982a("com.android.launcher.permission.READ_SETTINGS") || m22982a("com.google.android.launcher.permission.READ_SETTINGS"))) {
            String m22974c = m22974c(context);
            if (!TextUtils.isEmpty(m22974c)) {
                try {
                    Cursor m22981a = m22981a(m22974c, str, context);
                    if (m22981a != null && m22981a.getCount() > 0) {
                        return m22981a.getCount();
                    }
                    if (m22981a != null && !m22981a.isClosed()) {
                        m22981a.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static ShortCutsManager m22996a(Context context) {
        if (f30159b == null) {
            synchronized (ShortCutsManager.class) {
                if (f30159b == null) {
                    f30159b = new ShortCutsManager(context);
                }
            }
        }
        return f30159b;
    }

    /* renamed from: c */
    public final String m22975c() {
        String str = "1";
        String str2 = m22982a("com.android.launcher.permission.INSTALL_SHORTCUT") ? "1" : "0";
        String str3 = m22982a("com.android.launcher.permission.UNINSTALL_SHORTCUT") ? "1" : "0";
        if (!m22982a("com.android.launcher.permission.READ_SETTINGS") && !m22982a("com.google.android.launcher.permission.READ_SETTINGS")) {
            str = "0";
        }
        return "[" + str2 + "," + str3 + "," + str + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m22982a(String str) {
        Context context = this.f30160a.get();
        return context != null && context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* renamed from: b */
    public final String m22980b() {
        ResolveInfo resolveActivity;
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Context context = this.f30160a.get();
        return (context == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || (activityInfo = resolveActivity.activityInfo) == null || activityInfo.packageName.equals(FaceEnvironment.f8430OS)) ? "" : resolveActivity.activityInfo.packageName;
    }

    /* renamed from: a */
    public final void m22983a(final CampaignEx campaignEx, final Activity activity) {
        final Context context = this.f30160a.get();
        if (context == null) {
            return;
        }
        CampaignDao m22767a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(context));
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        boolean z = false;
        List<CampaignEx> m22763a = m22767a.m22763a(m23252b.m23446D(), 0);
        if (m22763a != null && m22763a.size() > 0) {
            Iterator<CampaignEx> it = m22763a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CampaignEx next = it.next();
                if (next.getId().equals(campaignEx.getId()) && next.getAppName().equals(campaignEx.getAppName())) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            m22997a(activity);
        } else if (!TextUtils.isEmpty(campaignEx.getIconUrl())) {
            CommonImageLoader.m22343a(context).m22339a(campaignEx.getIconUrl(), new CommonImageLoaderListener() { // from class: com.mbridge.msdk.d.b.1
                @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                public final void onFailedLoad(String str, String str2) {
                    ShortCutsManager.this.m22997a(activity);
                }

                @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    CampaignDao m22767a2 = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(context));
                    Setting m23252b2 = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                    if (m23252b2 == null) {
                        m23252b2 = SettingManager.m23261a().m23253b();
                    }
                    ShortCutsManager.this.m22995a(context, m23252b2);
                    if (ShortCutsManager.this.m22982a("com.android.launcher.permission.INSTALL_SHORTCUT")) {
                        int m22976b = ShortCutsManager.this.m22976b(campaignEx.getAppName());
                        ShortCutsManager.m22988a(ShortCutsManager.this, context, bitmap, campaignEx, activity);
                        ShortCutsManager.m22986a(ShortCutsManager.this, campaignEx, m23252b2, m22767a2, m22976b);
                    }
                }
            });
        } else {
            m22997a(activity);
        }
    }

    /* renamed from: a */
    private void m22994a(Context context, CampaignEx campaignEx, int i) {
        Intent intent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", campaignEx.getAppName());
        Intent intent2 = new Intent(context, MBCommonActivity.class);
        intent2.setAction("android.intent.action.VIEW");
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        context.sendBroadcast(intent);
        CampaignDao m22767a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(context));
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        String m23446D = m23252b.m23446D();
        if (!m22982a("com.android.launcher.permission.READ_SETTINGS") && !m22982a("com.google.android.launcher.permission.READ_SETTINGS")) {
            m22984a(campaignEx, 2, -1);
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_deleted", (Integer) 1);
            m22767a.m22754a(campaignEx.getId(), contentValues);
        } else {
            if (m22976b(campaignEx.getAppName()) < i) {
                m22984a(campaignEx, 2, 1);
                campaignEx.setIsDeleted(1);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("is_deleted", (Integer) 1);
                m22767a.m22754a(campaignEx.getId(), contentValues2);
            } else {
                m22984a(campaignEx, 2, 0);
            }
        }
        m22767a.m22735d(m23446D);
    }

    /* renamed from: a */
    public final int m22999a() {
        Context context = this.f30160a.get();
        if (context == null) {
            return 0;
        }
        CampaignDao m22767a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(context));
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        List<CampaignEx> m22763a = m22767a.m22763a(m23252b.m23446D(), 0);
        if (m22763a == null || m22763a.size() <= 0) {
            return 0;
        }
        return m22763a.size();
    }

    /* renamed from: a */
    private boolean m22993a(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            String m22974c = TextUtils.isEmpty(null) ? m22974c(context) : null;
            if (!TextUtils.isEmpty(m22974c)) {
                try {
                    Cursor m22981a = m22981a(m22974c, str, context);
                    if (m22981a != null && m22981a.getCount() > 0) {
                        z = true;
                    }
                    if (m22981a != null && !m22981a.isClosed()) {
                        m22981a.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private Cursor m22981a(String str, String str2, Context context) {
        return context.getContentResolver().query(Uri.parse(str), new String[]{"title"}, "title=?", new String[]{str2}, null);
    }

    /* renamed from: a */
    private void m22984a(CampaignEx campaignEx, int i, int i2) {
        if (this.f30160a.get() == null || campaignEx.getIsDeleted() == 1) {
            return;
        }
        C11385e.m22084a(this.f30160a.get(), campaignEx, i, i2);
    }

    /* renamed from: a */
    public final void m22992a(Setting setting) {
        CampaignDao m22767a;
        List<CampaignEx> m22763a;
        try {
            Context context = this.f30160a.get();
            if (context == null || (m22763a = (m22767a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(context))).m22763a(setting.m23446D(), 0)) == null || m22763a.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : m22763a) {
                if (campaignEx.getIsAddSuccesful() == 0 && campaignEx.getIsDeleted() == 0) {
                    if (m22976b(campaignEx.getAppName()) != 0) {
                        m22984a(campaignEx, 1, 1);
                        SharedPerferenceManager.m22949a().m22945a(DomainMBridgeConstans.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
                    } else {
                        m22984a(campaignEx, 1, 0);
                    }
                    campaignEx.setIsAddSuccesful(-1);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
                    m22767a.m22754a(campaignEx.getId(), contentValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m22998a(final int i, final String str) {
        try {
            if (this.f30160a.get() == null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.d.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    Setting m23252b = str != null ? SettingManager.m23261a().m23252b(str) : null;
                    if (m23252b == null) {
                        m23252b = SettingManager.m23261a().m23253b();
                    }
                    ShortCutsManager.this.m22992a(m23252b);
                    Message obtain = Message.obtain();
                    obtain.arg1 = i;
                    obtain.obj = str;
                    ShortCutsManager.this.f30161c.sendEmptyMessage(BleManager.f22896l);
                }
            }).start();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m22997a(Activity activity) {
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m22995a(Context context, Setting setting) {
        List<CampaignEx> m22763a;
        if (TextUtils.isEmpty(setting.m23446D()) || (m22763a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(context)).m22763a(setting.m23446D(), 0)) == null || m22763a.size() <= 0 || !m22982a("com.android.launcher.permission.UNINSTALL_SHORTCUT")) {
            return;
        }
        for (CampaignEx campaignEx : m22763a) {
            int m22976b = m22976b(campaignEx.getAppName());
            Context context2 = this.f30160a.get();
            if (context2 != null) {
                if (!m22982a("com.android.launcher.permission.READ_SETTINGS") && !m22982a("com.google.android.launcher.permission.READ_SETTINGS")) {
                    if (m22982a("com.android.launcher.permission.UNINSTALL_SHORTCUT")) {
                        m22994a(context2, campaignEx, m22976b);
                    }
                } else if (m22993a(context2, campaignEx.getAppName())) {
                    m22994a(context2, campaignEx, m22976b);
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22988a(ShortCutsManager shortCutsManager, Context context, Bitmap bitmap, CampaignEx campaignEx, Activity activity) {
        if (!TextUtils.isEmpty(campaignEx.getAppName()) && bitmap != null) {
            try {
                Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                intent.putExtra("android.intent.extra.shortcut.NAME", campaignEx.getAppName());
                intent.putExtra("duplicate", false);
                intent.putExtra("android.intent.extra.shortcut.ICON", Bitmap.createScaledBitmap(bitmap, 140, 140, true));
                Intent intent2 = new Intent(context, MBCommonActivity.class);
                intent2.putExtra("intent_flag", "shortcuts");
                JSONObject jSONObject = null;
                try {
                    jSONObject = CampaignEx.campaignToJsonObject(campaignEx);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject != null) {
                    intent2.putExtra("intent_jsonobject", jSONObject.toString());
                }
                intent2.setFlags(32768);
                intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                context.sendBroadcast(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        shortCutsManager.m22997a(activity);
    }

    /* renamed from: a */
    static /* synthetic */ void m22986a(ShortCutsManager shortCutsManager, CampaignEx campaignEx, Setting setting, CampaignDao campaignDao, int i) {
        campaignEx.setTimestamp(0L);
        if (!shortCutsManager.m22982a("com.android.launcher.permission.READ_SETTINGS") && !shortCutsManager.m22982a("com.google.android.launcher.permission.READ_SETTINGS")) {
            campaignEx.setIsAddSuccesful(1);
            shortCutsManager.m22984a(campaignEx, 1, -1);
            campaignEx.setIsAddSuccesful(-1);
            campaignDao.m22766a(campaignEx, setting.m23446D(), 0);
            SharedPerferenceManager.m22949a().m22945a(DomainMBridgeConstans.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
            return;
        }
        if (shortCutsManager.m22976b(campaignEx.getAppName()) > i) {
            campaignEx.setIsAddSuccesful(1);
            campaignDao.m22766a(campaignEx, setting.m23446D(), 0);
            shortCutsManager.m22984a(campaignEx, 1, 1);
            campaignEx.setIsAddSuccesful(-1);
            SharedPerferenceManager.m22949a().m22945a(DomainMBridgeConstans.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
            return;
        }
        campaignEx.setIsAddSuccesful(0);
        campaignDao.m22766a(campaignEx, setting.m23446D(), 0);
        SharedPerferenceManager.m22949a().m22945a(DomainMBridgeConstans.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:3:0x0002, B:8:0x0010, B:10:0x001a, B:21:0x0059, B:13:0x0025, B:15:0x003f, B:16:0x004b), top: B:28:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void m22990a(com.mbridge.msdk.p462d.ShortCutsManager r8, int r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "mb_shortcuts_ctime"
            java.lang.ref.WeakReference<android.content.Context> r1 = r8.f30160a     // Catch: java.lang.Exception -> L68
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Exception -> L68
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Exception -> L68
            if (r1 != 0) goto Ld
            goto L70
        Ld:
            r2 = 0
            if (r10 == 0) goto L18
            com.mbridge.msdk.c.b r2 = com.mbridge.msdk.p457c.SettingManager.m23261a()     // Catch: java.lang.Exception -> L68
            com.mbridge.msdk.c.a r2 = r2.m23252b(r10)     // Catch: java.lang.Exception -> L68
        L18:
            if (r2 != 0) goto L22
            com.mbridge.msdk.c.b r10 = com.mbridge.msdk.p457c.SettingManager.m23261a()     // Catch: java.lang.Exception -> L68
            com.mbridge.msdk.c.a r2 = r10.m23253b()     // Catch: java.lang.Exception -> L68
        L22:
            if (r2 != 0) goto L25
            goto L56
        L25:
            int r10 = r2.m23450B()     // Catch: java.lang.Exception -> L68
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L68
            r4 = 0
            com.mbridge.msdk.foundation.a.a.a r6 = com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager.m22949a()     // Catch: java.lang.Exception -> L68
            java.lang.String r6 = r6.m22944b(r0)     // Catch: java.lang.Exception -> L68
            java.lang.String r7 = ""
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Exception -> L68
            if (r6 != 0) goto L4b
            com.mbridge.msdk.foundation.a.a.a r4 = com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager.m22949a()     // Catch: java.lang.Exception -> L68
            java.lang.String r0 = r4.m22944b(r0)     // Catch: java.lang.Exception -> L68
            long r4 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L68
        L4b:
            long r2 = r2 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            long r4 = (long) r10     // Catch: java.lang.Exception -> L68
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L56
            r10 = 1
            goto L57
        L56:
            r10 = 0
        L57:
            if (r10 == 0) goto L70
            android.os.Handler r10 = new android.os.Handler     // Catch: java.lang.Exception -> L68
            r10.<init>()     // Catch: java.lang.Exception -> L68
            com.mbridge.msdk.d.b$4 r0 = new com.mbridge.msdk.d.b$4     // Catch: java.lang.Exception -> L68
            r0.<init>()     // Catch: java.lang.Exception -> L68
            long r8 = (long) r9     // Catch: java.lang.Exception -> L68
            r10.postDelayed(r0, r8)     // Catch: java.lang.Exception -> L68
            goto L70
        L68:
            r8 = move-exception
            boolean r9 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r9 == 0) goto L70
            r8.printStackTrace()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.p462d.ShortCutsManager.m22990a(com.mbridge.msdk.d.b, int, java.lang.String):void");
    }
}
