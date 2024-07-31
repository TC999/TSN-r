package cn.bluemobi.dylan.base.adapter;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* renamed from: cn.bluemobi.dylan.base.adapter.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class FragmentRadioAdapter implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a */
    private List<Fragment> f1684a;

    /* renamed from: b */
    private RadioGroup f1685b;

    /* renamed from: c */
    private FragmentManager f1686c;

    /* renamed from: d */
    private int f1687d;

    /* renamed from: e */
    private int f1688e;

    /* renamed from: f */
    private C1118a f1689f;

    /* renamed from: g */
    private boolean f1690g;

    /* compiled from: FragmentRadioAdapter.java */
    /* renamed from: cn.bluemobi.dylan.base.adapter.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1118a {
        /* renamed from: a */
        public void m57899a(RadioGroup radioGroup, int i, int i2) {
        }

        /* renamed from: b */
        public void m57898b() {
        }
    }

    public FragmentRadioAdapter(FragmentManager fragmentManager, List<Fragment> list, int i, RadioGroup radioGroup) {
        this(fragmentManager, list, i, radioGroup, 0);
    }

    /* renamed from: d */
    private FragmentTransaction m57903d(int i) {
        return this.f1686c.beginTransaction();
    }

    /* renamed from: a */
    public Fragment m57906a() {
        return this.f1684a.get(this.f1688e);
    }

    /* renamed from: b */
    public int m57905b() {
        return this.f1688e;
    }

    /* renamed from: c */
    public C1118a m57904c() {
        return this.f1689f;
    }

    /* renamed from: e */
    public void m57902e(boolean z) {
        this.f1690g = z;
    }

    /* renamed from: f */
    public void m57901f(C1118a c1118a) {
        this.f1689f = c1118a;
    }

    /* renamed from: g */
    public void m57900g(int i) {
        for (int i2 = 0; i2 < this.f1684a.size(); i2++) {
            Fragment fragment = this.f1684a.get(i2);
            FragmentTransaction m57903d = m57903d(i);
            if (i == i2) {
                m57903d.show(fragment);
            } else {
                m57903d.hide(fragment);
            }
            m57903d.commitAllowingStateLoss();
        }
        this.f1688e = i;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (!this.f1690g) {
            ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
            C1118a c1118a = this.f1689f;
            if (c1118a != null) {
                c1118a.m57898b();
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < this.f1685b.getChildCount(); i2++) {
            try {
                if (this.f1685b.getChildAt(i2).getId() == i) {
                    Fragment fragment = this.f1684a.get(i2);
                    FragmentTransaction m57903d = m57903d(i2);
                    if (fragment.isAdded()) {
                        this.f1688e = i2;
                        if (!fragment.isResumed()) {
                            fragment.onResume();
                        }
                    } else {
                        m57903d.add(this.f1687d, fragment, String.valueOf(this.f1688e));
                    }
                    m57900g(i2);
                    m57903d.commitAllowingStateLoss();
                    C1118a c1118a2 = this.f1689f;
                    if (c1118a2 != null) {
                        c1118a2.m57899a(radioGroup, i, i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public FragmentRadioAdapter(FragmentManager fragmentManager, List<Fragment> list, int i, RadioGroup radioGroup, int i2) {
        this.f1690g = true;
        this.f1684a = list;
        this.f1685b = radioGroup;
        this.f1686c = fragmentManager;
        this.f1687d = i;
        this.f1688e = i;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, list.get(i2), String.valueOf(i2));
        beginTransaction.commitAllowingStateLoss();
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(this);
        }
    }
}
