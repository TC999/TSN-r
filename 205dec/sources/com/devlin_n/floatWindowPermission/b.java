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
import com.acse.ottn.b1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FloatWindowManager.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f36834b = "FloatWindowManager";

    /* renamed from: c  reason: collision with root package name */
    public static final int f36835c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f36836d;

    /* renamed from: a  reason: collision with root package name */
    private Dialog f36837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class a implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36838a;

        a(Context context) {
            this.f36838a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z3) {
            if (z3) {
                com.devlin_n.floatWindowPermission.f.a(this.f36838a);
            } else {
                Log.e(b1.f5166b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* renamed from: com.devlin_n.floatWindowPermission.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class C0543b implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36840a;

        C0543b(Context context) {
            this.f36840a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z3) {
            if (z3) {
                com.devlin_n.floatWindowPermission.c.a(this.f36840a);
            } else {
                Log.e(b1.f5166b, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class c implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36842a;

        c(Context context) {
            this.f36842a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z3) {
            if (z3) {
                com.devlin_n.floatWindowPermission.d.a(this.f36842a);
            } else {
                Log.e(b1.f5166b, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class d implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36844a;

        d(Context context) {
            this.f36844a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z3) {
            if (z3) {
                com.devlin_n.floatWindowPermission.e.a(this.f36844a);
            } else {
                Log.e(b1.f5166b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class e implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36846a;

        e(Context context) {
            this.f36846a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z3) {
            if (z3) {
                try {
                    Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
                    intent.setData(Uri.parse("package:" + this.f36846a.getPackageName()));
                    com.devlin_n.floatWindowPermission.h.a(this.f36846a).startActivityForResult(intent, 1);
                    return;
                } catch (Exception e4) {
                    Log.e(b1.f5166b, Log.getStackTraceString(e4));
                    return;
                }
            }
            Log.d(b1.f5166b, "user manually refuse OVERLAY_PERMISSION");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f36848a;

        f(h hVar) {
            this.f36848a = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            this.f36848a.a(false);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f36850a;

        g(h hVar) {
            this.f36850a = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            this.f36850a.a(true);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FloatWindowManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface h {
        void a(boolean z3);
    }

    private void a(Context context) {
        n(context, new a(context));
    }

    private void d(Context context) {
        if (com.devlin_n.floatWindowPermission.g.c()) {
            j(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            n(context, new e(context));
        }
    }

    private boolean e(Context context) {
        if (com.devlin_n.floatWindowPermission.g.c()) {
            return i(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e4) {
                Log.e(b1.f5166b, Log.getStackTraceString(e4));
            }
        }
        return bool.booleanValue();
    }

    public static b f() {
        if (f36836d == null) {
            synchronized (b.class) {
                if (f36836d == null) {
                    f36836d = new b();
                }
            }
        }
        return f36836d;
    }

    private boolean g(Context context) {
        return com.devlin_n.floatWindowPermission.c.b(context);
    }

    private void h(Context context) {
        n(context, new C0543b(context));
    }

    private boolean i(Context context) {
        return com.devlin_n.floatWindowPermission.d.b(context);
    }

    private void j(Context context) {
        n(context, new c(context));
    }

    private boolean k(Context context) {
        return com.devlin_n.floatWindowPermission.e.b(context);
    }

    private void l(Context context) {
        n(context, new d(context));
    }

    private boolean m(Context context) {
        return com.devlin_n.floatWindowPermission.f.b(context);
    }

    private void n(Context context, h hVar) {
        o(context, "\u60a8\u7684\u624b\u673a\u6ca1\u6709\u6388\u4e88\u60ac\u6d6e\u7a97\u6743\u9650\uff0c\u5f00\u542f\u540e\u624d\u80fd\u6b63\u5e38\u4f7f\u7528\u6b64\u529f\u80fd", hVar);
    }

    private void o(Context context, String str, h hVar) {
        Dialog dialog = this.f36837a;
        if (dialog != null && dialog.isShowing()) {
            this.f36837a.dismiss();
        }
        AlertDialog create = new AlertDialog.Builder(context).setCancelable(true).setTitle("").setMessage(str).setPositiveButton("\u73b0\u5728\u53bb\u5f00\u542f", new g(hVar)).setNegativeButton("\u6682\u4e0d\u5f00\u542f", new f(hVar)).create();
        this.f36837a = create;
        create.show();
    }

    public void b(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (com.devlin_n.floatWindowPermission.g.d()) {
                l(context);
            } else if (com.devlin_n.floatWindowPermission.g.c()) {
                j(context);
            } else if (com.devlin_n.floatWindowPermission.g.b()) {
                h(context);
            } else if (com.devlin_n.floatWindowPermission.g.a()) {
                a(context);
            }
        }
        d(context);
    }

    public boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (com.devlin_n.floatWindowPermission.g.d()) {
                return k(context);
            }
            if (com.devlin_n.floatWindowPermission.g.c()) {
                return i(context);
            }
            if (com.devlin_n.floatWindowPermission.g.b()) {
                return g(context);
            }
            if (com.devlin_n.floatWindowPermission.g.a()) {
                return m(context);
            }
        }
        return e(context);
    }
}
