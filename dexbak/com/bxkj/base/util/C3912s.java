package com.bxkj.base.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.kuaishou.weapon.p205p0.C7282g;
import java.util.ArrayList;
import java.util.List;
import p618m.StartActivityForResult;

/* compiled from: PermissionUtil.java */
/* renamed from: com.bxkj.base.util.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3912s {

    /* renamed from: a */
    public static final int f14935a = 111;

    /* renamed from: b */
    public static final int f14936b = 222;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionUtil.java */
    /* renamed from: com.bxkj.base.util.s$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class DialogInterface$OnClickListenerC3913a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f14937a;

        /* renamed from: b */
        final /* synthetic */ Activity f14938b;

        DialogInterface$OnClickListenerC3913a(boolean z, Activity activity) {
            this.f14937a = z;
            this.f14938b = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.f14937a) {
                this.f14938b.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionUtil.java */
    /* renamed from: com.bxkj.base.util.s$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class DialogInterface$OnClickListenerC3914b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f14939a;

        DialogInterface$OnClickListenerC3914b(Activity activity) {
            this.f14939a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C3912s.m44034o(this.f14939a);
        }
    }

    /* compiled from: PermissionUtil.java */
    /* renamed from: com.bxkj.base.util.s$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3915c {
        /* renamed from: a */
        void m44032a(String... strArr);

        /* renamed from: b */
        void m44031b();

        /* renamed from: c */
        void m44030c(String... strArr);
    }

    /* renamed from: a */
    public static void m44048a(Context context, String[] strArr, int i) {
        List<String> m44046c = m44046c(context, strArr);
        if (m44046c.size() > 0) {
            m44037l(context, m44046c, i);
        }
    }

    /* renamed from: b */
    public static void m44047b(Context context, String str, int i) {
        if (m44043f(context, str)) {
            return;
        }
        m44036m(context, str, i);
    }

    /* renamed from: c */
    public static List<String> m44046c(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (!m44043f(context, strArr[i])) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static void m44045d(Context context, String[] strArr, InterfaceC3915c interfaceC3915c) {
        List<String> m44046c = m44046c(context, strArr);
        if (m44046c.size() == 0) {
            interfaceC3915c.m44031b();
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= m44046c.size()) {
                z = true;
                break;
            } else if (m44040i(context, m44046c.get(i))) {
                break;
            } else {
                i++;
            }
        }
        String[] strArr2 = (String[]) m44046c.toArray(new String[m44046c.size()]);
        if (z) {
            interfaceC3915c.m44030c(strArr2);
        } else {
            interfaceC3915c.m44032a(strArr2);
        }
    }

    /* renamed from: e */
    public static void m44044e(Context context, String str, InterfaceC3915c interfaceC3915c) {
        if (m44043f(context, str)) {
            interfaceC3915c.m44031b();
        } else if (m44040i(context, str)) {
            interfaceC3915c.m44030c(str);
        } else {
            interfaceC3915c.m44032a(str);
        }
    }

    /* renamed from: f */
    public static boolean m44043f(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    /* renamed from: g */
    public static boolean m44042g(int[] iArr) {
        return iArr.length > 0 && iArr[0] == 0;
    }

    /* renamed from: h */
    public static void m44041h(Activity activity, String[] strArr, boolean z) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(C7282g.f24952j)) {
                m44035n(activity, "存储", z);
                return;
            } else if (strArr[i].equals("android.permission.CAMERA")) {
                m44035n(activity, "相机", z);
                return;
            } else if (strArr[i].equals("android.permission.READ_CONTACTS")) {
                m44035n(activity, "通讯录", z);
                return;
            } else if (strArr[i].equals("android.permission.RECORD_AUDIO")) {
                m44035n(activity, "麦克风", z);
                return;
            }
        }
    }

    /* renamed from: i */
    public static boolean m44040i(Context context, String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, str);
    }

    /* renamed from: j */
    public static void m44039j(Context context, String[] strArr, InterfaceC3915c interfaceC3915c) {
        List<String> m44046c = m44046c(context, strArr);
        if (m44046c.size() == 0) {
            interfaceC3915c.m44031b();
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= m44046c.size()) {
                break;
            } else if (!m44040i(context, m44046c.get(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            interfaceC3915c.m44032a(strArr);
        } else {
            interfaceC3915c.m44030c(strArr);
        }
    }

    /* renamed from: k */
    public static void m44038k(Context context, String str, int[] iArr, InterfaceC3915c interfaceC3915c) {
        if (m44042g(iArr)) {
            interfaceC3915c.m44031b();
        } else if (m44040i(context, str)) {
            interfaceC3915c.m44030c(str);
        } else {
            interfaceC3915c.m44032a(str);
        }
    }

    /* renamed from: l */
    public static void m44037l(Context context, List list, int i) {
        ActivityCompat.requestPermissions((Activity) context, (String[]) list.toArray(new String[list.size()]), i);
    }

    /* renamed from: m */
    public static void m44036m(Context context, String str, int i) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{str}, i);
    }

    /* renamed from: n */
    public static void m44035n(Activity activity, String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        AlertDialog.Builder title = builder.setTitle(str + "权限不可用");
        title.setMessage("请在设置中打开" + str + "权限").setPositiveButton("立即开启", new DialogInterface$OnClickListenerC3914b(activity)).setNegativeButton("取消", new DialogInterface$OnClickListenerC3913a(z, activity)).setCancelable(false).show();
    }

    /* renamed from: o */
    public static void m44034o(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivityForResult(intent, 222);
    }

    /* renamed from: p */
    public static void m44033p(FragmentActivity fragmentActivity, StartActivityForResult.InterfaceC15293a interfaceC15293a) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragmentActivity.getPackageName(), null));
        new StartActivityForResult(fragmentActivity).startActivityForResult(intent).startActivityForResult(intent).m3460c(interfaceC15293a);
    }
}
