package com.mbridge.msdk.d;

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
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.report.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShortCutsManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f38986b;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f38987a;

    /* renamed from: c  reason: collision with root package name */
    private Handler f38988c = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.d.b.3
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            try {
                int i4 = message.arg1;
                Object obj = message.obj;
                b.a(b.this, i4, obj instanceof String ? (String) obj : null);
            } catch (Exception e4) {
                if (MBridgeConstans.DEBUG) {
                    e4.printStackTrace();
                }
            }
        }
    };

    private b(Context context) {
        this.f38987a = new WeakReference<>(context);
    }

    private String b(Context context) {
        return "";
    }

    private String c(Context context) {
        String b4 = b(context);
        if (b4 == null || b4.trim().equals("")) {
            b();
            b4 = "";
        }
        if (TextUtils.isEmpty(b4)) {
            b4 = Build.VERSION.SDK_INT < 19 ? "com.android.launcher2.settings" : "com.android.launcher3.settings";
        }
        return "content://" + b4 + "/favorites?notify=true";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(String str) {
        Context context = this.f38987a.get();
        if (context != null && (a("com.android.launcher.permission.READ_SETTINGS") || a("com.google.android.launcher.permission.READ_SETTINGS"))) {
            String c4 = c(context);
            if (!TextUtils.isEmpty(c4)) {
                try {
                    Cursor a4 = a(c4, str, context);
                    if (a4 != null && a4.getCount() > 0) {
                        return a4.getCount();
                    }
                    if (a4 != null && !a4.isClosed()) {
                        a4.close();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static b a(Context context) {
        if (f38986b == null) {
            synchronized (b.class) {
                if (f38986b == null) {
                    f38986b = new b(context);
                }
            }
        }
        return f38986b;
    }

    public final String c() {
        String str = "1";
        String str2 = a("com.android.launcher.permission.INSTALL_SHORTCUT") ? "1" : "0";
        String str3 = a("com.android.launcher.permission.UNINSTALL_SHORTCUT") ? "1" : "0";
        if (!a("com.android.launcher.permission.READ_SETTINGS") && !a("com.google.android.launcher.permission.READ_SETTINGS")) {
            str = "0";
        }
        return "[" + str2 + "," + str3 + "," + str + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        Context context = this.f38987a.get();
        return context != null && context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public final String b() {
        ResolveInfo resolveActivity;
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Context context = this.f38987a.get();
        return (context == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || (activityInfo = resolveActivity.activityInfo) == null || activityInfo.packageName.equals("android")) ? "" : resolveActivity.activityInfo.packageName;
    }

    public final void a(final CampaignEx campaignEx, final Activity activity) {
        final Context context = this.f38987a.get();
        if (context == null) {
            return;
        }
        f a4 = f.a(i.a(context));
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        boolean z3 = false;
        List<CampaignEx> a5 = a4.a(b4.D(), 0);
        if (a5 != null && a5.size() > 0) {
            Iterator<CampaignEx> it = a5.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CampaignEx next = it.next();
                if (next.getId().equals(campaignEx.getId()) && next.getAppName().equals(campaignEx.getAppName())) {
                    z3 = true;
                    break;
                }
            }
        }
        if (z3) {
            a(activity);
        } else if (!TextUtils.isEmpty(campaignEx.getIconUrl())) {
            com.mbridge.msdk.foundation.same.c.b.a(context).a(campaignEx.getIconUrl(), new c() { // from class: com.mbridge.msdk.d.b.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    b.this.a(activity);
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    f a6 = f.a(i.a(context));
                    com.mbridge.msdk.c.a b5 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                    if (b5 == null) {
                        b5 = com.mbridge.msdk.c.b.a().b();
                    }
                    b.this.a(context, b5);
                    if (b.this.a("com.android.launcher.permission.INSTALL_SHORTCUT")) {
                        int b6 = b.this.b(campaignEx.getAppName());
                        b.a(b.this, context, bitmap, campaignEx, activity);
                        b.a(b.this, campaignEx, b5, a6, b6);
                    }
                }
            });
        } else {
            a(activity);
        }
    }

    private void a(Context context, CampaignEx campaignEx, int i4) {
        Intent intent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", campaignEx.getAppName());
        Intent intent2 = new Intent(context, MBCommonActivity.class);
        intent2.setAction("android.intent.action.VIEW");
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        context.sendBroadcast(intent);
        f a4 = f.a(i.a(context));
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        String D = b4.D();
        if (!a("com.android.launcher.permission.READ_SETTINGS") && !a("com.google.android.launcher.permission.READ_SETTINGS")) {
            a(campaignEx, 2, -1);
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_deleted", (Integer) 1);
            a4.a(campaignEx.getId(), contentValues);
        } else {
            if (b(campaignEx.getAppName()) < i4) {
                a(campaignEx, 2, 1);
                campaignEx.setIsDeleted(1);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("is_deleted", (Integer) 1);
                a4.a(campaignEx.getId(), contentValues2);
            } else {
                a(campaignEx, 2, 0);
            }
        }
        a4.d(D);
    }

    public final int a() {
        Context context = this.f38987a.get();
        if (context == null) {
            return 0;
        }
        f a4 = f.a(i.a(context));
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        List<CampaignEx> a5 = a4.a(b4.D(), 0);
        if (a5 == null || a5.size() <= 0) {
            return 0;
        }
        return a5.size();
    }

    private boolean a(Context context, String str) {
        boolean z3 = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            String c4 = TextUtils.isEmpty(null) ? c(context) : null;
            if (!TextUtils.isEmpty(c4)) {
                try {
                    Cursor a4 = a(c4, str, context);
                    if (a4 != null && a4.getCount() > 0) {
                        z3 = true;
                    }
                    if (a4 != null && !a4.isClosed()) {
                        a4.close();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return z3;
    }

    private Cursor a(String str, String str2, Context context) {
        return context.getContentResolver().query(Uri.parse(str), new String[]{"title"}, "title=?", new String[]{str2}, null);
    }

    private void a(CampaignEx campaignEx, int i4, int i5) {
        if (this.f38987a.get() == null || campaignEx.getIsDeleted() == 1) {
            return;
        }
        e.a(this.f38987a.get(), campaignEx, i4, i5);
    }

    public final void a(com.mbridge.msdk.c.a aVar) {
        f a4;
        List<CampaignEx> a5;
        try {
            Context context = this.f38987a.get();
            if (context == null || (a5 = (a4 = f.a(i.a(context))).a(aVar.D(), 0)) == null || a5.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : a5) {
                if (campaignEx.getIsAddSuccesful() == 0 && campaignEx.getIsDeleted() == 0) {
                    if (b(campaignEx.getAppName()) != 0) {
                        a(campaignEx, 1, 1);
                        com.mbridge.msdk.foundation.a.a.a.a().a(com.mbridge.msdk.a.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
                    } else {
                        a(campaignEx, 1, 0);
                    }
                    campaignEx.setIsAddSuccesful(-1);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
                    a4.a(campaignEx.getId(), contentValues);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(final int i4, final String str) {
        try {
            if (this.f38987a.get() == null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.d.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.c.a b4 = str != null ? com.mbridge.msdk.c.b.a().b(str) : null;
                    if (b4 == null) {
                        b4 = com.mbridge.msdk.c.b.a().b();
                    }
                    b.this.a(b4);
                    Message obtain = Message.obtain();
                    obtain.arg1 = i4;
                    obtain.obj = str;
                    b.this.f38988c.sendEmptyMessage(10000);
                }
            }).start();
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, com.mbridge.msdk.c.a aVar) {
        List<CampaignEx> a4;
        if (TextUtils.isEmpty(aVar.D()) || (a4 = f.a(i.a(context)).a(aVar.D(), 0)) == null || a4.size() <= 0 || !a("com.android.launcher.permission.UNINSTALL_SHORTCUT")) {
            return;
        }
        for (CampaignEx campaignEx : a4) {
            int b4 = b(campaignEx.getAppName());
            Context context2 = this.f38987a.get();
            if (context2 != null) {
                if (!a("com.android.launcher.permission.READ_SETTINGS") && !a("com.google.android.launcher.permission.READ_SETTINGS")) {
                    if (a("com.android.launcher.permission.UNINSTALL_SHORTCUT")) {
                        a(context2, campaignEx, b4);
                    }
                } else if (a(context2, campaignEx.getAppName())) {
                    a(context2, campaignEx, b4);
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, Context context, Bitmap bitmap, CampaignEx campaignEx, Activity activity) {
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
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                if (jSONObject != null) {
                    intent2.putExtra("intent_jsonobject", jSONObject.toString());
                }
                intent2.setFlags(32768);
                intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                context.sendBroadcast(intent);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        bVar.a(activity);
    }

    static /* synthetic */ void a(b bVar, CampaignEx campaignEx, com.mbridge.msdk.c.a aVar, f fVar, int i4) {
        campaignEx.setTimestamp(0L);
        if (!bVar.a("com.android.launcher.permission.READ_SETTINGS") && !bVar.a("com.google.android.launcher.permission.READ_SETTINGS")) {
            campaignEx.setIsAddSuccesful(1);
            bVar.a(campaignEx, 1, -1);
            campaignEx.setIsAddSuccesful(-1);
            fVar.a(campaignEx, aVar.D(), 0);
            com.mbridge.msdk.foundation.a.a.a.a().a(com.mbridge.msdk.a.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
            return;
        }
        if (bVar.b(campaignEx.getAppName()) > i4) {
            campaignEx.setIsAddSuccesful(1);
            fVar.a(campaignEx, aVar.D(), 0);
            bVar.a(campaignEx, 1, 1);
            campaignEx.setIsAddSuccesful(-1);
            com.mbridge.msdk.foundation.a.a.a.a().a(com.mbridge.msdk.a.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
            return;
        }
        campaignEx.setIsAddSuccesful(0);
        fVar.a(campaignEx, aVar.D(), 0);
        com.mbridge.msdk.foundation.a.a.a.a().a(com.mbridge.msdk.a.SHORTCUTS_CTIME, String.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:3:0x0002, B:8:0x0010, B:10:0x001a, B:21:0x0059, B:13:0x0025, B:15:0x003f, B:16:0x004b), top: B:28:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.mbridge.msdk.d.b r8, int r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "mb_shortcuts_ctime"
            java.lang.ref.WeakReference<android.content.Context> r1 = r8.f38987a     // Catch: java.lang.Exception -> L68
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Exception -> L68
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Exception -> L68
            if (r1 != 0) goto Ld
            goto L70
        Ld:
            r2 = 0
            if (r10 == 0) goto L18
            com.mbridge.msdk.c.b r2 = com.mbridge.msdk.c.b.a()     // Catch: java.lang.Exception -> L68
            com.mbridge.msdk.c.a r2 = r2.b(r10)     // Catch: java.lang.Exception -> L68
        L18:
            if (r2 != 0) goto L22
            com.mbridge.msdk.c.b r10 = com.mbridge.msdk.c.b.a()     // Catch: java.lang.Exception -> L68
            com.mbridge.msdk.c.a r2 = r10.b()     // Catch: java.lang.Exception -> L68
        L22:
            if (r2 != 0) goto L25
            goto L56
        L25:
            int r10 = r2.B()     // Catch: java.lang.Exception -> L68
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L68
            r4 = 0
            com.mbridge.msdk.foundation.a.a.a r6 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch: java.lang.Exception -> L68
            java.lang.String r6 = r6.b(r0)     // Catch: java.lang.Exception -> L68
            java.lang.String r7 = ""
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Exception -> L68
            if (r6 != 0) goto L4b
            com.mbridge.msdk.foundation.a.a.a r4 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch: java.lang.Exception -> L68
            java.lang.String r0 = r4.b(r0)     // Catch: java.lang.Exception -> L68
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.d.b.a(com.mbridge.msdk.d.b, int, java.lang.String):void");
    }
}
