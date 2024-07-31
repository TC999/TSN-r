package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* renamed from: cn.bluemobi.dylan.base.utils.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AppManager {

    /* renamed from: c */
    private static AppManager f1790c;

    /* renamed from: a */
    private Stack<Activity> f1791a = new Stack<>();

    /* renamed from: b */
    private List<Fragment> f1792b = new ArrayList();

    private AppManager() {
    }

    /* renamed from: n */
    public static AppManager m57776n() {
        if (f1790c == null) {
            f1790c = new AppManager();
        }
        return f1790c;
    }

    /* renamed from: a */
    public void m57789a(Context context) {
        try {
            m57780j();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m57788b(Context context, Intent intent) {
        try {
            context.stopService(intent);
            m57780j();
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public void m57787c(Activity activity) {
        this.f1791a.add(activity);
    }

    /* renamed from: d */
    public void m57786d(Fragment fragment) {
        this.f1792b.add(fragment);
    }

    /* renamed from: e */
    public Activity m57785e() {
        if (this.f1791a.isEmpty()) {
            return null;
        }
        return this.f1791a.lastElement();
    }

    /* renamed from: f */
    public void m57784f(Context context) {
    }

    /* renamed from: g */
    public void m57783g() {
        if (this.f1791a.empty()) {
            return;
        }
        m57782h(this.f1791a.lastElement());
    }

    public <T extends Activity> T getActivity(Class<?> cls) {
        Iterator<Activity> it = this.f1791a.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass().equals(cls)) {
                return t;
            }
        }
        return null;
    }

    /* renamed from: h */
    public void m57782h(Activity activity) {
        if (activity == null || !this.f1791a.remove(activity)) {
            return;
        }
        activity.finish();
    }

    /* renamed from: i */
    public void m57781i(Class<?> cls) {
        int i = 0;
        while (i < this.f1791a.size()) {
            Activity activity = this.f1791a.get(i);
            if (activity.getClass().equals(cls)) {
                m57782h(activity);
                i--;
            }
            i++;
        }
    }

    /* renamed from: j */
    public void m57780j() {
        ArrayList arrayList = new ArrayList(this.f1791a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i) != null) {
                ((Activity) arrayList.get(i)).finish();
            }
        }
        this.f1791a.clear();
    }

    /* renamed from: k */
    public void m57779k() {
        ArrayList arrayList = new ArrayList(this.f1791a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Activity activity = (Activity) arrayList.get(i);
            if (arrayList.get(i) != null && !((Activity) arrayList.get(i)).getClass().getSimpleName().equals("LoginActivity")) {
                ((Activity) arrayList.get(i)).finish();
                this.f1791a.remove(activity);
            }
        }
    }

    /* renamed from: l */
    public void m57778l() {
        int size = this.f1791a.size();
        if (size >= 1) {
            ArrayList arrayList = new ArrayList(this.f1791a.subList(1, size));
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                Activity activity = (Activity) arrayList.get(i);
                if (activity != null) {
                    activity.finish();
                    this.f1791a.remove(activity);
                }
            }
        }
    }

    /* renamed from: m */
    public Stack<Activity> m57777m() {
        return this.f1791a;
    }

    /* renamed from: o */
    public <T extends Fragment> T m57775o(Class<?> cls) {
        Iterator<Fragment> it = this.f1792b.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass().equals(cls)) {
                return t;
            }
        }
        return null;
    }

    /* renamed from: p */
    public boolean m57774p() {
        return this.f1791a.isEmpty();
    }

    /* renamed from: q */
    public Activity m57773q() {
        if (this.f1791a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f1791a;
        return stack.get(stack.size() - 1);
    }

    /* renamed from: r */
    public Activity m57772r() {
        if (this.f1791a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f1791a;
        return stack.get(stack.size() - 2);
    }

    /* renamed from: s */
    public void m57771s(Activity activity) {
        if (activity != null) {
            this.f1791a.remove(activity);
        }
    }

    /* renamed from: t */
    public void m57770t(Fragment fragment) {
        List<Fragment> list = this.f1792b;
        if (list != null) {
            try {
                list.remove(fragment);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
