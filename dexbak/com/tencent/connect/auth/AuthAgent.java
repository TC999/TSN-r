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
import com.baidu.idl.face.platform.FaceEnvironment;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.tencent.connect.C12925a;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.p561a.C12926a;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13014e;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13063i;
import com.tencent.open.utils.C13065j;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13067l;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AuthAgent extends BaseApi {
    public static final String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";

    /* renamed from: a */
    private IUiListener f36988a;

    /* renamed from: d */
    private String f36989d;

    /* renamed from: e */
    private WeakReference<Activity> f36990e;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.AuthAgent$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class C12930a extends DefaultUiListener {

        /* renamed from: a */
        IUiListener f36996a;

        public C12930a(IUiListener iUiListener) {
            this.f36996a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f36996a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj == null) {
                SLog.m15129e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i = jSONObject.getInt("ret");
                String string = i == 0 ? "success" : jSONObject.getString("msg");
                IUiListener iUiListener = this.f36996a;
                if (iUiListener != null) {
                    iUiListener.onComplete(new JSONObject().put("ret", i).put("msg", string));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                SLog.m15129e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.f36996a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.AuthAgent$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12936c extends DefaultUiListener {

        /* renamed from: b */
        private final IUiListener f37015b;

        /* renamed from: c */
        private final boolean f37016c;

        /* renamed from: d */
        private final Context f37017d;

        public C12936c(Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.f37017d = context;
            this.f37015b = iUiListener;
            this.f37016c = z;
            SLog.m15131d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            SLog.m15131d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f37015b.onCancel();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            SLog.m15131d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (string != null && ((BaseApi) AuthAgent.this).f37136c != null && string3 != null) {
                    ((BaseApi) AuthAgent.this).f37136c.setAccessToken(string, string2);
                    ((BaseApi) AuthAgent.this).f37136c.setOpenId(string3);
                    C12926a.m15465d(this.f37017d, ((BaseApi) AuthAgent.this).f37136c);
                }
                String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.f37017d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        SLog.m15128e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.f37016c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.m15128e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.f37015b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.m15131d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f37015b.onError(uiError);
            SLog.release();
        }
    }

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str != null && !str.equals("")) {
            if (str.equalsIgnoreCase("arm64-v8a")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.m15127i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
                return;
            } else if (str.equalsIgnoreCase(DeviceUtils.f47125a)) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.m15127i("openSDK_LOG.AuthAgent", "is x86 architecture");
                return;
            } else if (str.equalsIgnoreCase("x86_64")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.m15127i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
                return;
            } else {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.m15127i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
                return;
            }
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        SLog.m15127i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private void m15458a(Bundle bundle, Map<String, Object> map) {
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2, Map<String, Object> map) {
        if (C12925a.m15471a("openSDK_LOG.AuthAgent", iUiListener)) {
            return -1;
        }
        this.f36989d = str;
        this.f36990e = new WeakReference<>(activity);
        this.f36988a = iUiListener;
        Object[] objArr = new Object[2];
        boolean booleanExtra = activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false);
        boolean m15008b = C13063i.m15015a(activity, this.f37136c.getAppId()).m15008b("C_LoginWeb");
        SLog.m15127i("openSDK_LOG.AuthAgent", "doLogin needForceQrLogin=" + booleanExtra + ", toWebLogin=" + m15008b);
        if (!booleanExtra && !m15008b && m15461a(activity, fragment, map, z, objArr)) {
            SLog.m15127i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            C13014e.m15176a().m15173a(this.f37136c.getOpenId(), this.f37136c.getAppId(), "2", "1", "5", (String) objArr[0], "0", "0");
            return ((Integer) objArr[1]).intValue();
        }
        C13014e.m15176a().m15173a(this.f37136c.getOpenId(), this.f37136c.getAppId(), "2", "1", "5", "1", "0", "0");
        SLog.m15121w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        C12931b c12931b = new C12931b(this.f36988a);
        this.f36988a = c12931b;
        return m15453a(z, c12931b, z2, map);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.f36988a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m15451b(IUiListener iUiListener) {
        Bundle m15318a = m15318a();
        m15318a.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.f37136c, C13061g.m15027a(), "https://openmobile.qq.com/v3/user/get_info", m15318a, "GET", new BaseApi.TempRequestListener(new C12930a(iUiListener)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m15460a(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2) {
        return doLogin(activity, str, iUiListener, z, fragment, z2, null);
    }

    /* renamed from: a */
    private int m15453a(boolean z, IUiListener iUiListener, boolean z2, Map<String, Object> map) {
        CookieSyncManager.createInstance(C13061g.m15027a());
        Bundle m15318a = m15318a();
        if (z) {
            m15318a.putString("isadd", "1");
        }
        m15318a.putString(Constants.PARAM_SCOPE, this.f36989d);
        m15318a.putString(Constants.PARAM_CLIENT_ID, this.f37136c.getAppId());
        if (BaseApi.isOEM) {
            m15318a.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-" + FaceEnvironment.f8430OS + "-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
        } else {
            m15318a.putString("pf", Constants.DEFAULT_PF);
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        m15318a.putString("sign", C13066k.m14987b(C13061g.m15027a(), str));
        m15318a.putString(RtspHeaders.Values.TIME, str);
        m15318a.putString("display", "mobile");
        m15318a.putString("response_type", BidResponsed.KEY_TOKEN);
        m15318a.putString("redirect_uri", "auth://tauth.qq.com/");
        m15318a.putString("cancel_display", "1");
        m15318a.putString("switch", "1");
        m15318a.putString("compat_v", "1");
        if (z2) {
            m15318a.putString("style", "qr");
        }
        boolean m15454a = m15454a(map);
        m15318a.putString("show_download_ui", Boolean.toString(m15454a));
        SLog.m15127i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start, isShowDownloadUi=" + m15454a);
        final String str2 = C13065j.m15004a().m15003a(C13061g.m15027a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(m15318a);
        final C12936c c12936c = new C12936c(C13061g.m15027a(), iUiListener, true, false);
        SLog.m15131d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        C13067l.m14974b(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1
            @Override // java.lang.Runnable
            public void run() {
                final Activity activity;
                C13066k.m14991a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
                if (AuthAgent.this.f36990e == null || (activity = (Activity) AuthAgent.this.f36990e.get()) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (JniInterface.isJniOk) {
                            Activity activity2 = activity;
                            RunnableC129281 runnableC129281 = RunnableC129281.this;
                            DialogC12937a dialogC12937a = new DialogC12937a(activity2, "action_login", str2, c12936c, ((BaseApi) AuthAgent.this).f37136c);
                            if (activity.isFinishing()) {
                                return;
                            }
                            dialogC12937a.show();
                            return;
                        }
                        SLog.m15121w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                        Activity activity3 = activity;
                        String m15311a = AuthAgent.this.m15311a("");
                        RunnableC129281 runnableC1292812 = RunnableC129281.this;
                        TDialog tDialog = new TDialog(activity3, "", m15311a, c12936c, ((BaseApi) AuthAgent.this).f37136c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        tDialog.show();
                    }
                });
            }
        });
        SLog.m15127i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.AuthAgent$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12931b extends DefaultUiListener {

        /* renamed from: a */
        WeakReference<IUiListener> f36998a;

        /* renamed from: c */
        private final String f37000c = "sendinstall";

        /* renamed from: d */
        private final String f37001d = "installwording";

        /* renamed from: e */
        private final String f37002e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.connect.auth.AuthAgent$b$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        private abstract class AbstractView$OnClickListenerC12935a implements View.OnClickListener {

            /* renamed from: d */
            Dialog f37012d;

            AbstractView$OnClickListenerC12935a(Dialog dialog) {
                this.f37012d = dialog;
            }
        }

        public C12931b(IUiListener iUiListener) {
            this.f36998a = new WeakReference<>(iUiListener);
        }

        /* renamed from: a */
        private void m15438a(String str, final IUiListener iUiListener, final Object obj) {
            PackageInfo packageInfo;
            if (AuthAgent.this.f36990e == null) {
                SLog.m15127i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            Activity activity = (Activity) AuthAgent.this.f36990e.get();
            if (activity == null) {
                SLog.m15127i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                SLog.m15129e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                packageInfo = null;
            }
            Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener onClickListener = new AbstractView$OnClickListenerC12935a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C12931b.this.m15441a();
                    Dialog dialog2 = this.f37012d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f37012d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new AbstractView$OnClickListenerC12935a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Dialog dialog2 = this.f37012d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f37012d.dismiss();
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
            dialog.setContentView(m15440a(activity, loadIcon, str, onClickListener, onClickListener2));
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
            if (this.f36998a.get() != null) {
                this.f36998a.get().onCancel();
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
                com.tencent.open.log.SLog.m15121w(r0, r3)
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
                com.tencent.open.log.SLog.m15127i(r0, r5)
                if (r4 == 0) goto L5b
                boolean r4 = android.text.TextUtils.isEmpty(r3)
                if (r4 != 0) goto L5b
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r1 = r7.f36998a
                java.lang.Object r1 = r1.get()
                com.tencent.tauth.IUiListener r1 = (com.tencent.tauth.IUiListener) r1
                r7.m15438a(r3, r1, r8)
                java.lang.String r8 = " WORDING is not empty and return"
                com.tencent.open.log.SLog.m15127i(r0, r8)
                return
            L5b:
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r3 = r7.f36998a
                java.lang.Object r3 = r3.get()
                com.tencent.tauth.IUiListener r3 = (com.tencent.tauth.IUiListener) r3
                if (r3 == 0) goto L9e
                com.tencent.connect.auth.AuthAgent r4 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r4 = com.tencent.connect.auth.AuthAgent.m15445h(r4)
                if (r4 == 0) goto L8b
                com.tencent.connect.auth.AuthAgent r2 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r2 = com.tencent.connect.auth.AuthAgent.m15444i(r2)
                boolean r2 = r2.saveSession(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = " saveSession saveSuccess="
                r1.append(r4)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.tencent.open.log.SLog.m15127i(r0, r1)
            L8b:
                if (r2 == 0) goto L91
                r3.onComplete(r8)
                goto La3
            L91:
                com.tencent.tauth.UiError r8 = new com.tencent.tauth.UiError
                r0 = -6
                r1 = 0
                java.lang.String r2 = "持久化失败!"
                r8.<init>(r0, r2, r1)
                r3.onError(r8)
                goto La3
            L9e:
                java.lang.String r8 = " userListener is null"
                com.tencent.open.log.SLog.m15127i(r0, r8)
            La3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.AuthAgent.C12931b.onComplete(java.lang.Object):void");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.f36998a.get() != null) {
                this.f36998a.get().onError(uiError);
            }
        }

        /* renamed from: a */
        private Drawable m15439a(String str, Context context) {
            InputStream open;
            Bitmap bitmap;
            Drawable drawable = null;
            try {
                open = context.getApplicationContext().getAssets().open(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                try {
                    bitmap = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
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

        /* renamed from: a */
        private View m15440a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (f * 14.0f);
            int i3 = (int) (18.0f * f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, (int) (6.0f * f), i3);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams2.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i4 = (int) (12.0f * f);
            layoutParams3.setMargins(0, 0, 0, i4);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(m15439a("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i5 = (int) (45.0f * f);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i5);
            layoutParams5.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams5.leftMargin = i6;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(m15439a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i5);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i6;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
            relativeLayout.setPadding(i2, 0, i4, i4);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        /* renamed from: a */
        protected void m15441a() {
            Activity activity;
            Bundle m15308b = AuthAgent.this.m15308b();
            if (AuthAgent.this.f36990e == null || (activity = (Activity) AuthAgent.this.f36990e.get()) == null) {
                return;
            }
            HttpUtils.requestAsync(((BaseApi) AuthAgent.this).f37136c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", m15308b, "POST", null);
        }
    }

    /* renamed from: a */
    private boolean m15454a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Object obj = map.get(Constants.KEY_ENABLE_SHOW_DOWNLOAD_URL);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m15461a(Activity activity, Fragment fragment, Map<String, Object> map, boolean z, Object[] objArr) {
        SLog.m15127i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent m15307c = m15307c();
        if (m15307c != null) {
            Bundle m15318a = m15318a();
            if (z) {
                m15318a.putString("isadd", "1");
            }
            m15318a.putString(Constants.PARAM_SCOPE, this.f36989d);
            m15318a.putString(Constants.PARAM_CLIENT_ID, this.f37136c.getAppId());
            if (BaseApi.isOEM) {
                m15318a.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-" + FaceEnvironment.f8430OS + "-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
            } else {
                m15318a.putString("pf", Constants.DEFAULT_PF);
            }
            m15318a.putString("need_pay", "1");
            m15458a(m15318a, map);
            m15318a.putString(Constants.KEY_APP_NAME, C13066k.m14998a(C13061g.m15027a()));
            m15307c.putExtra(Constants.KEY_ACTION, "action_login");
            m15307c.putExtra(Constants.KEY_PARAMS, m15318a);
            m15307c.putExtra("appid", this.f37136c.getAppId());
            m15318a.putString(Constants.KEY_PPSTS, C13066k.m14999a(activity, m15459a(m15318a)));
            try {
                this.f36988a = new C12931b(this.f36988a);
                UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.f36988a);
                if (fragment != null) {
                    SLog.m15131d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    m15312a(fragment, m15307c, 11101, map);
                } else {
                    SLog.m15131d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    m15315a(activity, m15307c, 11101, map);
                }
                SLog.m15127i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                C13014e.m15176a().m15175a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f37136c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            } catch (Exception e) {
                SLog.m15128e("openSDK_LOG.AuthAgent", "startActionActivity() exception", e);
            }
        }
        C13014e.m15176a().m15175a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f37136c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        SLog.m15127i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    /* renamed from: a */
    private String m15459a(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION);
        String string5 = bundle.getString(Constants.PARAM_CLIENT_ID);
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString("pf");
        SLog.m15131d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
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
    /* renamed from: a */
    public void m15455a(IUiListener iUiListener) {
        String str;
        SLog.m15127i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.f37136c.getAccessToken();
        String openId = this.f37136c.getOpenId();
        String appId = this.f37136c.getAppId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = C13071m.m14924g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (TextUtils.isEmpty(str)) {
            SLog.m15129e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle m15318a = m15318a();
        m15318a.putString("encrytoken", str);
        HttpUtils.requestAsync(this.f37136c, C13061g.m15027a(), "https://openmobile.qq.com/user/user_login_statis", m15318a, "POST", null);
        SLog.m15127i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }
}
