package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AuthAgent extends BaseApi {
    public static final String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";

    /* renamed from: a  reason: collision with root package name */
    private IUiListener f51354a;

    /* renamed from: d  reason: collision with root package name */
    private String f51355d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Activity> f51356e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class a extends DefaultUiListener {

        /* renamed from: a  reason: collision with root package name */
        IUiListener f51362a;

        public a(IUiListener iUiListener) {
            this.f51362a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f51362a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj == null) {
                SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i4 = jSONObject.getInt("ret");
                String string = i4 == 0 ? "success" : jSONObject.getString("msg");
                IUiListener iUiListener = this.f51362a;
                if (iUiListener != null) {
                    iUiListener.onComplete(new JSONObject().put("ret", i4).put("msg", string));
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.f51362a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c extends DefaultUiListener {

        /* renamed from: b  reason: collision with root package name */
        private final IUiListener f51381b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f51382c;

        /* renamed from: d  reason: collision with root package name */
        private final Context f51383d;

        public c(Context context, IUiListener iUiListener, boolean z3, boolean z4) {
            this.f51383d = context;
            this.f51381b = iUiListener;
            this.f51382c = z3;
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f51381b.onCancel();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (string != null && ((BaseApi) AuthAgent.this).f51502c != null && string3 != null) {
                    ((BaseApi) AuthAgent.this).f51502c.setAccessToken(string, string2);
                    ((BaseApi) AuthAgent.this).f51502c.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.f51383d, ((BaseApi) AuthAgent.this).f51502c);
                }
                String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.f51383d.getSharedPreferences("pfStore", 0).edit().putString("pf", string4).commit();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e4);
                    }
                }
                if (this.f51382c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
                SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e5);
            }
            this.f51381b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f51381b.onError(uiError);
            SLog.release();
        }
    }

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str != null && !str.equals("")) {
            if (str.equalsIgnoreCase("arm64-v8a")) {
                SECURE_LIB_FILE_NAME = "libwbsafeedit_64";
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
                return;
            } else if (str.equalsIgnoreCase("x86")) {
                SECURE_LIB_FILE_NAME = "libwbsafeedit_x86";
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is x86 architecture");
                return;
            } else if (str.equalsIgnoreCase("x86_64")) {
                SECURE_LIB_FILE_NAME = "libwbsafeedit_x86_64";
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
                return;
            } else {
                SECURE_LIB_FILE_NAME = "libwbsafeedit";
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
                return;
            }
        }
        SECURE_LIB_FILE_NAME = "libwbsafeedit";
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    private void a(Bundle bundle, Map<String, Object> map) {
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z3, Fragment fragment, boolean z4, Map<String, Object> map) {
        if (com.tencent.connect.a.a("openSDK_LOG.AuthAgent", iUiListener)) {
            return -1;
        }
        this.f51355d = str;
        this.f51356e = new WeakReference<>(activity);
        this.f51354a = iUiListener;
        Object[] objArr = new Object[2];
        boolean booleanExtra = activity.getIntent().getBooleanExtra("KEY_FORCE_QR_LOGIN", false);
        boolean b4 = i.a(activity, this.f51502c.getAppId()).b("C_LoginWeb");
        SLog.i("openSDK_LOG.AuthAgent", "doLogin needForceQrLogin=" + booleanExtra + ", toWebLogin=" + b4);
        if (!booleanExtra && !b4 && a(activity, fragment, map, z3, objArr)) {
            SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            e.a().a(this.f51502c.getOpenId(), this.f51502c.getAppId(), "2", "1", "5", (String) objArr[0], "0", "0");
            return ((Integer) objArr[1]).intValue();
        }
        e.a().a(this.f51502c.getOpenId(), this.f51502c.getAppId(), "2", "1", "5", "1", "0", "0");
        SLog.w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        b bVar = new b(this.f51354a);
        this.f51354a = bVar;
        return a(z3, bVar, z4, map);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.f51354a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(IUiListener iUiListener) {
        Bundle a4 = a();
        a4.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.f51502c, g.a(), "https://openmobile.qq.com/v3/user/get_info", a4, "GET", new BaseApi.TempRequestListener(new a(iUiListener)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Activity activity, String str, IUiListener iUiListener, boolean z3, Fragment fragment, boolean z4) {
        return doLogin(activity, str, iUiListener, z3, fragment, z4, null);
    }

    private int a(boolean z3, IUiListener iUiListener, boolean z4, Map<String, Object> map) {
        CookieSyncManager.createInstance(g.a());
        Bundle a4 = a();
        if (z3) {
            a4.putString("isadd", "1");
        }
        a4.putString("scope", this.f51355d);
        a4.putString("client_id", this.f51502c.getAppId());
        if (BaseApi.isOEM) {
            a4.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
        } else {
            a4.putString("pf", "openmobile_android");
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        a4.putString("sign", k.b(g.a(), str));
        a4.putString("time", str);
        a4.putString("display", "mobile");
        a4.putString("response_type", "token");
        a4.putString("redirect_uri", "auth://tauth.qq.com/");
        a4.putString("cancel_display", "1");
        a4.putString("switch", "1");
        a4.putString("compat_v", "1");
        if (z4) {
            a4.putString("style", "qr");
        }
        boolean a5 = a(map);
        a4.putString("show_download_ui", Boolean.toString(a5));
        SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start, isShowDownloadUi=" + a5);
        final String str2 = j.a().a(g.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(a4);
        final c cVar = new c(g.a(), iUiListener, true, false);
        SLog.d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        l.b(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1
            @Override // java.lang.Runnable
            public void run() {
                final Activity activity;
                k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
                if (AuthAgent.this.f51356e == null || (activity = (Activity) AuthAgent.this.f51356e.get()) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (JniInterface.isJniOk) {
                            Activity activity2 = activity;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", str2, cVar, ((BaseApi) AuthAgent.this).f51502c);
                            if (activity.isFinishing()) {
                                return;
                            }
                            aVar.show();
                            return;
                        }
                        SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                        Activity activity3 = activity;
                        String a6 = AuthAgent.this.a("");
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        TDialog tDialog = new TDialog(activity3, "", a6, cVar, ((BaseApi) AuthAgent.this).f51502c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        tDialog.show();
                    }
                });
            }
        });
        SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b extends DefaultUiListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<IUiListener> f51364a;

        /* renamed from: c  reason: collision with root package name */
        private final String f51366c = "sendinstall";

        /* renamed from: d  reason: collision with root package name */
        private final String f51367d = "installwording";

        /* renamed from: e  reason: collision with root package name */
        private final String f51368e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* compiled from: ProGuard */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        private abstract class a implements View.OnClickListener {

            /* renamed from: d  reason: collision with root package name */
            Dialog f51378d;

            a(Dialog dialog) {
                this.f51378d = dialog;
            }
        }

        public b(IUiListener iUiListener) {
            this.f51364a = new WeakReference<>(iUiListener);
        }

        private void a(String str, final IUiListener iUiListener, final Object obj) {
            PackageInfo packageInfo;
            if (AuthAgent.this.f51356e == null) {
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            Activity activity = (Activity) AuthAgent.this.f51356e.get();
            if (activity == null) {
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e4) {
                SLog.e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e4.getStackTrace().toString());
                packageInfo = null;
            }
            Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener onClickListener = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.a();
                    Dialog dialog2 = this.f51378d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f51378d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Dialog dialog2 = this.f51378d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f51378d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog.getWindow().setBackgroundDrawable(colorDrawable);
            dialog.setContentView(a(activity, loadIcon, str, onClickListener, onClickListener2));
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.connect.auth.AuthAgent.b.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            });
            if (activity.isFinishing()) {
                return;
            }
            dialog.show();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.f51364a.get() != null) {
                this.f51364a.get().onCancel();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onComplete(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.String r0 = "openSDK_LOG.AuthAgent"
                if (r8 == 0) goto La3
                r1 = r8
                org.json.JSONObject r1 = (org.json.JSONObject) r1
                r2 = 0
                java.lang.String r3 = "sendinstall"
                int r3 = r1.getInt(r3)     // Catch: org.json.JSONException -> L1a
                r4 = 1
                if (r3 != r4) goto L12
                goto L13
            L12:
                r4 = 0
            L13:
                java.lang.String r3 = "installwording"
                java.lang.String r3 = r1.getString(r3)     // Catch: org.json.JSONException -> L1b
                goto L22
            L1a:
                r4 = 0
            L1b:
                java.lang.String r3 = "FeedConfirmListener onComplete There is no value for sendinstall."
                com.tencent.open.log.SLog.w(r0, r3)
                java.lang.String r3 = ""
            L22:
                java.lang.String r3 = java.net.URLDecoder.decode(r3)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = " WORDING = "
                r5.append(r6)
                r5.append(r3)
                java.lang.String r6 = "xx,showConfirmDialog="
                r5.append(r6)
                r5.append(r4)
                java.lang.String r5 = r5.toString()
                com.tencent.open.log.SLog.i(r0, r5)
                if (r4 == 0) goto L5b
                boolean r4 = android.text.TextUtils.isEmpty(r3)
                if (r4 != 0) goto L5b
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r1 = r7.f51364a
                java.lang.Object r1 = r1.get()
                com.tencent.tauth.IUiListener r1 = (com.tencent.tauth.IUiListener) r1
                r7.a(r3, r1, r8)
                java.lang.String r8 = " WORDING is not empty and return"
                com.tencent.open.log.SLog.i(r0, r8)
                return
            L5b:
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r3 = r7.f51364a
                java.lang.Object r3 = r3.get()
                com.tencent.tauth.IUiListener r3 = (com.tencent.tauth.IUiListener) r3
                if (r3 == 0) goto L9e
                com.tencent.connect.auth.AuthAgent r4 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r4 = com.tencent.connect.auth.AuthAgent.h(r4)
                if (r4 == 0) goto L8b
                com.tencent.connect.auth.AuthAgent r2 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r2 = com.tencent.connect.auth.AuthAgent.i(r2)
                boolean r2 = r2.saveSession(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = " saveSession saveSuccess="
                r1.append(r4)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.tencent.open.log.SLog.i(r0, r1)
            L8b:
                if (r2 == 0) goto L91
                r3.onComplete(r8)
                goto La3
            L91:
                com.tencent.tauth.UiError r8 = new com.tencent.tauth.UiError
                r0 = -6
                r1 = 0
                java.lang.String r2 = "\u6301\u4e45\u5316\u5931\u8d25!"
                r8.<init>(r0, r2, r1)
                r3.onError(r8)
                goto La3
            L9e:
                java.lang.String r8 = " userListener is null"
                com.tencent.open.log.SLog.i(r0, r8)
            La3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.AuthAgent.b.onComplete(java.lang.Object):void");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.f51364a.get() != null) {
                this.f51364a.get().onError(uiError);
            }
        }

        private Drawable a(String str, Context context) {
            InputStream open;
            Bitmap bitmap;
            Drawable drawable = null;
            try {
                open = context.getApplicationContext().getAssets().open(str);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                try {
                    bitmap = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e5) {
                    e5.printStackTrace();
                    bitmap = null;
                }
                if (bitmap != null) {
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
                }
                return null;
            }
            drawable = Drawable.createFromStream(open, str);
            open.close();
            return drawable;
        }

        private View a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f4 = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i4 = (int) (60.0f * f4);
            int i5 = (int) (f4 * 14.0f);
            int i6 = (int) (18.0f * f4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i6, (int) (6.0f * f4), i6);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f4));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f5 = 5.0f * f4;
            layoutParams2.setMargins(0, 0, (int) f5, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i7 = (int) (12.0f * f4);
            layoutParams3.setMargins(0, 0, 0, i7);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("\u8df3\u8fc7");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i8 = (int) (45.0f * f4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i8);
            layoutParams5.rightMargin = i5;
            int i9 = (int) (4.0f * f4);
            layoutParams5.leftMargin = i9;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("\u786e\u5b9a");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i8);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i9;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f4), (int) (f4 * 163.0f));
            relativeLayout.setPadding(i5, 0, i7, i7);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, (int) MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, (int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, (int) MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, (int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT));
            paintDrawable.setCornerRadius(f5);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        protected void a() {
            Activity activity;
            Bundle b4 = AuthAgent.this.b();
            if (AuthAgent.this.f51356e == null || (activity = (Activity) AuthAgent.this.f51356e.get()) == null) {
                return;
            }
            HttpUtils.requestAsync(((BaseApi) AuthAgent.this).f51502c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b4, "POST", null);
        }
    }

    private boolean a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Object obj = map.get(Constants.KEY_ENABLE_SHOW_DOWNLOAD_URL);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    private boolean a(Activity activity, Fragment fragment, Map<String, Object> map, boolean z3, Object[] objArr) {
        SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent c4 = c();
        if (c4 != null) {
            Bundle a4 = a();
            if (z3) {
                a4.putString("isadd", "1");
            }
            a4.putString("scope", this.f51355d);
            a4.putString("client_id", this.f51502c.getAppId());
            if (BaseApi.isOEM) {
                a4.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
            } else {
                a4.putString("pf", "openmobile_android");
            }
            a4.putString("need_pay", "1");
            a(a4, map);
            a4.putString("oauth_app_name", k.a(g.a()));
            c4.putExtra("key_action", "action_login");
            c4.putExtra("key_params", a4);
            c4.putExtra("appid", this.f51502c.getAppId());
            a4.putString("ppsts", k.a(activity, a(a4)));
            try {
                this.f51354a = new b(this.f51354a);
                UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.f51354a);
                if (fragment != null) {
                    SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, c4, 11101, map);
                } else {
                    SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, c4, 11101, map);
                }
                SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                e.a().a(0, "LOGIN_CHECK_SDK", "1000", this.f51502c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.AuthAgent", "startActionActivity() exception", e4);
            }
        }
        e.a().a(1, "LOGIN_CHECK_SDK", "1000", this.f51502c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    private String a(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString("sdkv");
        String string5 = bundle.getString("client_id");
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString("pf");
        SLog.d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
        StringBuilder sb = new StringBuilder();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb.append(string7);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IUiListener iUiListener) {
        String str;
        SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.f51502c.getAccessToken();
        String openId = this.f51502c.getOpenId();
        String appId = this.f51502c.getAppId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = m.g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (TextUtils.isEmpty(str)) {
            SLog.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle a4 = a();
        a4.putString("encrytoken", str);
        HttpUtils.requestAsync(this.f51502c, g.a(), "https://openmobile.qq.com/user/user_login_statis", a4, "POST", null);
        SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }
}
