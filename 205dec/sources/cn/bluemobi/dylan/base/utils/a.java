package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AppManager.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f1776c;

    /* renamed from: a  reason: collision with root package name */
    private Stack<Activity> f1777a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    private List<Fragment> f1778b = new ArrayList();

    private a() {
    }

    public static a n() {
        if (f1776c == null) {
            f1776c = new a();
        }
        return f1776c;
    }

    public void a(Context context) {
        try {
            j();
        } catch (Exception unused) {
        }
    }

    public void b(Context context, Intent intent) {
        try {
            context.stopService(intent);
            j();
        } catch (Exception unused) {
        }
    }

    public void c(Activity activity) {
        this.f1777a.add(activity);
    }

    public void d(Fragment fragment) {
        this.f1778b.add(fragment);
    }

    public Activity e() {
        if (this.f1777a.isEmpty()) {
            return null;
        }
        return this.f1777a.lastElement();
    }

    public void f(Context context) {
    }

    public void g() {
        if (this.f1777a.empty()) {
            return;
        }
        h(this.f1777a.lastElement());
    }

    public <T extends Activity> T getActivity(Class<?> cls) {
        Iterator<Activity> it = this.f1777a.iterator();
        while (it.hasNext()) {
            T t3 = (T) it.next();
            if (t3.getClass().equals(cls)) {
                return t3;
            }
        }
        return null;
    }

    public void h(Activity activity) {
        if (activity == null || !this.f1777a.remove(activity)) {
            return;
        }
        activity.finish();
    }

    public void i(Class<?> cls) {
        int i4 = 0;
        while (i4 < this.f1777a.size()) {
            Activity activity = this.f1777a.get(i4);
            if (activity.getClass().equals(cls)) {
                h(activity);
                i4--;
            }
            i4++;
        }
    }

    public void j() {
        ArrayList arrayList = new ArrayList(this.f1777a);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (arrayList.get(i4) != null) {
                ((Activity) arrayList.get(i4)).finish();
            }
        }
        this.f1777a.clear();
    }

    public void k() {
        ArrayList arrayList = new ArrayList(this.f1777a);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Activity activity = (Activity) arrayList.get(i4);
            if (arrayList.get(i4) != null && !((Activity) arrayList.get(i4)).getClass().getSimpleName().equals("LoginActivity")) {
                ((Activity) arrayList.get(i4)).finish();
                this.f1777a.remove(activity);
            }
        }
    }

    public void l() {
        int size = this.f1777a.size();
        if (size >= 1) {
            ArrayList arrayList = new ArrayList(this.f1777a.subList(1, size));
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                Activity activity = (Activity) arrayList.get(i4);
                if (activity != null) {
                    activity.finish();
                    this.f1777a.remove(activity);
                }
            }
        }
    }

    public Stack<Activity> m() {
        return this.f1777a;
    }

    public <T extends Fragment> T o(Class<?> cls) {
        Iterator<Fragment> it = this.f1778b.iterator();
        while (it.hasNext()) {
            T t3 = (T) it.next();
            if (t3.getClass().equals(cls)) {
                return t3;
            }
        }
        return null;
    }

    public boolean p() {
        return this.f1777a.isEmpty();
    }

    public Activity q() {
        if (this.f1777a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f1777a;
        return stack.get(stack.size() - 1);
    }

    public Activity r() {
        if (this.f1777a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f1777a;
        return stack.get(stack.size() - 2);
    }

    public void s(Activity activity) {
        if (activity != null) {
            this.f1777a.remove(activity);
        }
    }

    public void t(Fragment fragment) {
        List<Fragment> list = this.f1778b;
        if (list != null) {
            try {
                list.remove(fragment);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
