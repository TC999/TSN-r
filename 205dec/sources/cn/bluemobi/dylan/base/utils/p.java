package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PermissionUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1805a = 111;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1806b = 222;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PermissionUtil.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f1807a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f1808b;

        a(boolean z3, Activity activity) {
            this.f1807a = z3;
            this.f1808b = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            dialogInterface.dismiss();
            if (this.f1807a) {
                this.f1808b.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PermissionUtil.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f1809a;

        b(Activity activity) {
            this.f1809a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            p.o(this.f1809a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PermissionUtil.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface c {
        void a(String... strArr);

        void b();

        void c(String... strArr);
    }

    public static void a(Context context, String[] strArr, int i4) {
        List<String> c4 = c(context, strArr);
        if (c4.size() > 0) {
            l(context, c4, i4);
        }
    }

    public static void b(Context context, String str, int i4) {
        if (f(context, str)) {
            return;
        }
        m(context, str, i4);
    }

    public static List<String> c(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (!f(context, strArr[i4])) {
                arrayList.add(strArr[i4]);
            }
        }
        return arrayList;
    }

    public static void d(Context context, String[] strArr, c cVar) {
        List<String> c4 = c(context, strArr);
        if (c4.size() == 0) {
            cVar.b();
            return;
        }
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= c4.size()) {
                z3 = true;
                break;
            } else if (i(context, c4.get(i4))) {
                break;
            } else {
                i4++;
            }
        }
        String[] strArr2 = (String[]) c4.toArray(new String[c4.size()]);
        if (z3) {
            cVar.c(strArr2);
        } else {
            cVar.a(strArr2);
        }
    }

    public static void e(Context context, String str, c cVar) {
        if (f(context, str)) {
            cVar.b();
        } else if (i(context, str)) {
            cVar.c(str);
        } else {
            cVar.a(str);
        }
    }

    public static boolean f(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean g(int[] iArr) {
        return iArr.length > 0 && iArr[0] == 0;
    }

    public static void h(Activity activity, String[] strArr, boolean z3) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                n(activity, "\u5b58\u50a8", z3);
                return;
            } else if (strArr[i4].equals("android.permission.CAMERA")) {
                n(activity, "\u76f8\u673a", z3);
                return;
            } else if (strArr[i4].equals("android.permission.READ_CONTACTS")) {
                n(activity, "\u901a\u8baf\u5f55", z3);
                return;
            } else if (strArr[i4].equals("android.permission.RECORD_AUDIO")) {
                n(activity, "\u9ea6\u514b\u98ce", z3);
                return;
            }
        }
    }

    public static boolean i(Context context, String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, str);
    }

    public static void j(Context context, String[] strArr, c cVar) {
        List<String> c4 = c(context, strArr);
        if (c4.size() == 0) {
            cVar.b();
            return;
        }
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= c4.size()) {
                break;
            } else if (!i(context, c4.get(i4))) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        if (z3) {
            cVar.a(strArr);
        } else {
            cVar.c(strArr);
        }
    }

    public static void k(Context context, String str, int[] iArr, c cVar) {
        if (g(iArr)) {
            cVar.b();
        } else if (i(context, str)) {
            cVar.c(str);
        } else {
            cVar.a(str);
        }
    }

    public static void l(Context context, List list, int i4) {
        ActivityCompat.requestPermissions((Activity) context, (String[]) list.toArray(new String[list.size()]), i4);
    }

    public static void m(Context context, String str, int i4) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{str}, i4);
    }

    public static void n(Activity activity, String str, boolean z3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        AlertDialog.Builder title = builder.setTitle(str + "\u6743\u9650\u4e0d\u53ef\u7528");
        title.setMessage("\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00" + str + "\u6743\u9650").setPositiveButton("\u7acb\u5373\u5f00\u542f", new b(activity)).setNegativeButton("\u53d6\u6d88", new a(z3, activity)).setCancelable(false).show();
    }

    public static void o(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivityForResult(intent, 222);
    }
}
