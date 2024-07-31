package com.devlin_n.floatWindowPermission;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

/* renamed from: com.devlin_n.floatWindowPermission.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FloatWindowManager {

    /* renamed from: b */
    private static final String f23167b = "FloatWindowManager";

    /* renamed from: c */
    public static final int f23168c = 1;

    /* renamed from: d */
    private static volatile FloatWindowManager f23169d;

    /* renamed from: a */
    private Dialog f23170a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6587a implements InterfaceC6594h {

        /* renamed from: a */
        final /* synthetic */ Context f23171a;

        C6587a(Context context) {
            this.f23171a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.FloatWindowManager.InterfaceC6594h
        /* renamed from: a */
        public void mo35809a(boolean z) {
            if (z) {
                QikuUtils.m35793a(this.f23171a);
            } else {
                Log.e(FloatWindowManager.f23167b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6588b implements InterfaceC6594h {

        /* renamed from: a */
        final /* synthetic */ Context f23173a;

        C6588b(Context context) {
            this.f23173a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.FloatWindowManager.InterfaceC6594h
        /* renamed from: a */
        public void mo35809a(boolean z) {
            if (z) {
                HuaweiUtils.m35808a(this.f23173a);
            } else {
                Log.e(FloatWindowManager.f23167b, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6589c implements InterfaceC6594h {

        /* renamed from: a */
        final /* synthetic */ Context f23175a;

        C6589c(Context context) {
            this.f23175a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.FloatWindowManager.InterfaceC6594h
        /* renamed from: a */
        public void mo35809a(boolean z) {
            if (z) {
                MeizuUtils.m35805a(this.f23175a);
            } else {
                Log.e(FloatWindowManager.f23167b, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6590d implements InterfaceC6594h {

        /* renamed from: a */
        final /* synthetic */ Context f23177a;

        C6590d(Context context) {
            this.f23177a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.FloatWindowManager.InterfaceC6594h
        /* renamed from: a */
        public void mo35809a(boolean z) {
            if (z) {
                MiuiUtils.m35802a(this.f23177a);
            } else {
                Log.e(FloatWindowManager.f23167b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6591e implements InterfaceC6594h {

        /* renamed from: a */
        final /* synthetic */ Context f23179a;

        C6591e(Context context) {
            this.f23179a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.FloatWindowManager.InterfaceC6594h
        /* renamed from: a */
        public void mo35809a(boolean z) {
            if (z) {
                try {
                    Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
                    intent.setData(Uri.parse("package:" + this.f23179a.getPackageName()));
                    WindowUtil.m35782a(this.f23179a).startActivityForResult(intent, 1);
                    return;
                } catch (Exception e) {
                    Log.e(FloatWindowManager.f23167b, Log.getStackTraceString(e));
                    return;
                }
            }
            Log.d(FloatWindowManager.f23167b, "user manually refuse OVERLAY_PERMISSION");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class DialogInterface$OnClickListenerC6592f implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ InterfaceC6594h f23181a;

        DialogInterface$OnClickListenerC6592f(InterfaceC6594h interfaceC6594h) {
            this.f23181a = interfaceC6594h;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23181a.mo35809a(false);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class DialogInterface$OnClickListenerC6593g implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ InterfaceC6594h f23183a;

        DialogInterface$OnClickListenerC6593g(InterfaceC6594h interfaceC6594h) {
            this.f23183a = interfaceC6594h;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23183a.mo35809a(true);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6594h {
        /* renamed from: a */
        void mo35809a(boolean z);
    }

    /* renamed from: a */
    private void m35824a(Context context) {
        m35811n(context, new C6587a(context));
    }

    /* renamed from: d */
    private void m35821d(Context context) {
        if (C6595g.m35787c()) {
            m35815j(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            m35811n(context, new C6591e(context));
        }
    }

    /* renamed from: e */
    private boolean m35820e(Context context) {
        if (C6595g.m35787c()) {
            return m35816i(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e) {
                Log.e(f23167b, Log.getStackTraceString(e));
            }
        }
        return bool.booleanValue();
    }

    /* renamed from: f */
    public static FloatWindowManager m35819f() {
        if (f23169d == null) {
            synchronized (FloatWindowManager.class) {
                if (f23169d == null) {
                    f23169d = new FloatWindowManager();
                }
            }
        }
        return f23169d;
    }

    /* renamed from: g */
    private boolean m35818g(Context context) {
        return HuaweiUtils.m35807b(context);
    }

    /* renamed from: h */
    private void m35817h(Context context) {
        m35811n(context, new C6588b(context));
    }

    /* renamed from: i */
    private boolean m35816i(Context context) {
        return MeizuUtils.m35804b(context);
    }

    /* renamed from: j */
    private void m35815j(Context context) {
        m35811n(context, new C6589c(context));
    }

    /* renamed from: k */
    private boolean m35814k(Context context) {
        return MiuiUtils.m35801b(context);
    }

    /* renamed from: l */
    private void m35813l(Context context) {
        m35811n(context, new C6590d(context));
    }

    /* renamed from: m */
    private boolean m35812m(Context context) {
        return QikuUtils.m35792b(context);
    }

    /* renamed from: n */
    private void m35811n(Context context, InterfaceC6594h interfaceC6594h) {
        m35810o(context, "您的手机没有授予悬浮窗权限，开启后才能正常使用此功能", interfaceC6594h);
    }

    /* renamed from: o */
    private void m35810o(Context context, String str, InterfaceC6594h interfaceC6594h) {
        Dialog dialog = this.f23170a;
        if (dialog != null && dialog.isShowing()) {
            this.f23170a.dismiss();
        }
        AlertDialog create = new AlertDialog.Builder(context).setCancelable(true).setTitle("").setMessage(str).setPositiveButton("现在去开启", new DialogInterface$OnClickListenerC6593g(interfaceC6594h)).setNegativeButton("暂不开启", new DialogInterface$OnClickListenerC6592f(interfaceC6594h)).create();
        this.f23170a = create;
        create.show();
    }

    /* renamed from: b */
    public void m35823b(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (C6595g.m35786d()) {
                m35813l(context);
            } else if (C6595g.m35787c()) {
                m35815j(context);
            } else if (C6595g.m35788b()) {
                m35817h(context);
            } else if (C6595g.m35789a()) {
                m35824a(context);
            }
        }
        m35821d(context);
    }

    /* renamed from: c */
    public boolean m35822c(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (C6595g.m35786d()) {
                return m35814k(context);
            }
            if (C6595g.m35787c()) {
                return m35816i(context);
            }
            if (C6595g.m35788b()) {
                return m35818g(context);
            }
            if (C6595g.m35789a()) {
                return m35812m(context);
            }
        }
        return m35820e(context);
    }
}
