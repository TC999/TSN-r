package cn.bluemobi.dylan.base.adapter;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FragmentRadioAdapter.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private List<Fragment> f1670a;

    /* renamed from: b  reason: collision with root package name */
    private RadioGroup f1671b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f1672c;

    /* renamed from: d  reason: collision with root package name */
    private int f1673d;

    /* renamed from: e  reason: collision with root package name */
    private int f1674e;

    /* renamed from: f  reason: collision with root package name */
    private C0038a f1675f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1676g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: FragmentRadioAdapter.java */
    /* renamed from: cn.bluemobi.dylan.base.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class C0038a {
        public void a(RadioGroup radioGroup, int i4, int i5) {
        }

        public void b() {
        }
    }

    public a(FragmentManager fragmentManager, List<Fragment> list, int i4, RadioGroup radioGroup) {
        this(fragmentManager, list, i4, radioGroup, 0);
    }

    private FragmentTransaction d(int i4) {
        return this.f1672c.beginTransaction();
    }

    public Fragment a() {
        return this.f1670a.get(this.f1674e);
    }

    public int b() {
        return this.f1674e;
    }

    public C0038a c() {
        return this.f1675f;
    }

    public void e(boolean z3) {
        this.f1676g = z3;
    }

    public void f(C0038a c0038a) {
        this.f1675f = c0038a;
    }

    public void g(int i4) {
        for (int i5 = 0; i5 < this.f1670a.size(); i5++) {
            Fragment fragment = this.f1670a.get(i5);
            FragmentTransaction d4 = d(i4);
            if (i4 == i5) {
                d4.show(fragment);
            } else {
                d4.hide(fragment);
            }
            d4.commitAllowingStateLoss();
        }
        this.f1674e = i4;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i4) {
        if (!this.f1676g) {
            ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
            C0038a c0038a = this.f1675f;
            if (c0038a != null) {
                c0038a.b();
                return;
            }
            return;
        }
        for (int i5 = 0; i5 < this.f1671b.getChildCount(); i5++) {
            try {
                if (this.f1671b.getChildAt(i5).getId() == i4) {
                    Fragment fragment = this.f1670a.get(i5);
                    FragmentTransaction d4 = d(i5);
                    if (fragment.isAdded()) {
                        this.f1674e = i5;
                        if (!fragment.isResumed()) {
                            fragment.onResume();
                        }
                    } else {
                        d4.add(this.f1673d, fragment, String.valueOf(this.f1674e));
                    }
                    g(i5);
                    d4.commitAllowingStateLoss();
                    C0038a c0038a2 = this.f1675f;
                    if (c0038a2 != null) {
                        c0038a2.a(radioGroup, i4, i5);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    public a(FragmentManager fragmentManager, List<Fragment> list, int i4, RadioGroup radioGroup, int i5) {
        this.f1676g = true;
        this.f1670a = list;
        this.f1671b = radioGroup;
        this.f1672c = fragmentManager;
        this.f1673d = i4;
        this.f1674e = i4;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i4, list.get(i5), String.valueOf(i5));
        beginTransaction.commitAllowingStateLoss();
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(this);
        }
    }
}
