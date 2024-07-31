package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p205p0.C7282g;
import java.util.ArrayList;
import java.util.List;

/* renamed from: cn.bluemobi.dylan.base.utils.p */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PermissionUtil {

    /* renamed from: a */
    public static final int f1819a = 111;

    /* renamed from: b */
    public static final int f1820b = 222;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionUtil.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.p$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class DialogInterface$OnClickListenerC1141a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f1821a;

        /* renamed from: b */
        final /* synthetic */ Activity f1822b;

        DialogInterface$OnClickListenerC1141a(boolean z, Activity activity) {
            this.f1821a = z;
            this.f1822b = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.f1821a) {
                this.f1822b.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionUtil.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.p$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class DialogInterface$OnClickListenerC1142b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f1823a;

        DialogInterface$OnClickListenerC1142b(Activity activity) {
            this.f1823a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            PermissionUtil.m57704o(this.f1823a);
        }
    }

    /* compiled from: PermissionUtil.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.p$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1143c {
        /* renamed from: a */
        void m57703a(String... strArr);

        /* renamed from: b */
        void m57702b();

        /* renamed from: c */
        void m57701c(String... strArr);
    }

    /* renamed from: a */
    public static void m57718a(Context context, String[] strArr, int i) {
        List<String> m57716c = m57716c(context, strArr);
        if (m57716c.size() > 0) {
            m57707l(context, m57716c, i);
        }
    }

    /* renamed from: b */
    public static void m57717b(Context context, String str, int i) {
        if (m57713f(context, str)) {
            return;
        }
        m57706m(context, str, i);
    }

    /* renamed from: c */
    public static List<String> m57716c(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (!m57713f(context, strArr[i])) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static void m57715d(Context context, String[] strArr, InterfaceC1143c interfaceC1143c) {
        List<String> m57716c = m57716c(context, strArr);
        if (m57716c.size() == 0) {
            interfaceC1143c.m57702b();
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= m57716c.size()) {
                z = true;
                break;
            } else if (m57710i(context, m57716c.get(i))) {
                break;
            } else {
                i++;
            }
        }
        String[] strArr2 = (String[]) m57716c.toArray(new String[m57716c.size()]);
        if (z) {
            interfaceC1143c.m57701c(strArr2);
        } else {
            interfaceC1143c.m57703a(strArr2);
        }
    }

    /* renamed from: e */
    public static void m57714e(Context context, String str, InterfaceC1143c interfaceC1143c) {
        if (m57713f(context, str)) {
            interfaceC1143c.m57702b();
        } else if (m57710i(context, str)) {
            interfaceC1143c.m57701c(str);
        } else {
            interfaceC1143c.m57703a(str);
        }
    }

    /* renamed from: f */
    public static boolean m57713f(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    /* renamed from: g */
    public static boolean m57712g(int[] iArr) {
        return iArr.length > 0 && iArr[0] == 0;
    }

    /* renamed from: h */
    public static void m57711h(Activity activity, String[] strArr, boolean z) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(C7282g.f24952j)) {
                m57705n(activity, "存储", z);
                return;
            } else if (strArr[i].equals("android.permission.CAMERA")) {
                m57705n(activity, "相机", z);
                return;
            } else if (strArr[i].equals("android.permission.READ_CONTACTS")) {
                m57705n(activity, "通讯录", z);
                return;
            } else if (strArr[i].equals("android.permission.RECORD_AUDIO")) {
                m57705n(activity, "麦克风", z);
                return;
            }
        }
    }

    /* renamed from: i */
    public static boolean m57710i(Context context, String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, str);
    }

    /* renamed from: j */
    public static void m57709j(Context context, String[] strArr, InterfaceC1143c interfaceC1143c) {
        List<String> m57716c = m57716c(context, strArr);
        if (m57716c.size() == 0) {
            interfaceC1143c.m57702b();
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= m57716c.size()) {
                break;
            } else if (!m57710i(context, m57716c.get(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            interfaceC1143c.m57703a(strArr);
        } else {
            interfaceC1143c.m57701c(strArr);
        }
    }

    /* renamed from: k */
    public static void m57708k(Context context, String str, int[] iArr, InterfaceC1143c interfaceC1143c) {
        if (m57712g(iArr)) {
            interfaceC1143c.m57702b();
        } else if (m57710i(context, str)) {
            interfaceC1143c.m57701c(str);
        } else {
            interfaceC1143c.m57703a(str);
        }
    }

    /* renamed from: l */
    public static void m57707l(Context context, List list, int i) {
        ActivityCompat.requestPermissions((Activity) context, (String[]) list.toArray(new String[list.size()]), i);
    }

    /* renamed from: m */
    public static void m57706m(Context context, String str, int i) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{str}, i);
    }

    /* renamed from: n */
    public static void m57705n(Activity activity, String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        AlertDialog.Builder title = builder.setTitle(str + "权限不可用");
        title.setMessage("请在设置中打开" + str + "权限").setPositiveButton("立即开启", new DialogInterface$OnClickListenerC1142b(activity)).setNegativeButton("取消", new DialogInterface$OnClickListenerC1141a(z, activity)).setCancelable(false).show();
    }

    /* renamed from: o */
    public static void m57704o(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivityForResult(intent, 222);
    }
}
