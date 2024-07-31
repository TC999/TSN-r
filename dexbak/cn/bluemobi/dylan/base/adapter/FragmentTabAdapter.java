package cn.bluemobi.dylan.base.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* renamed from: cn.bluemobi.dylan.base.adapter.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class FragmentTabAdapter implements TabLayout.OnTabSelectedListener {

    /* renamed from: a */
    private List<Fragment> f1691a;

    /* renamed from: b */
    private TabLayout f1692b;

    /* renamed from: c */
    private FragmentManager f1693c;

    /* renamed from: d */
    private int f1694d;

    /* renamed from: e */
    private int f1695e;

    /* renamed from: f */
    private C1119a f1696f;

    /* renamed from: g */
    private boolean f1697g;

    /* compiled from: FragmentTabAdapter.java */
    /* renamed from: cn.bluemobi.dylan.base.adapter.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1119a {
        /* renamed from: a */
        public void m57890a(TabLayout tabLayout, TabLayout.Tab tab, int i) {
        }

        /* renamed from: b */
        public void m57889b() {
        }
    }

    public FragmentTabAdapter(FragmentManager fragmentManager, List<Fragment> list, int i, TabLayout tabLayout) {
        this(fragmentManager, list, i, tabLayout, 0);
    }

    /* renamed from: d */
    private FragmentTransaction m57894d(int i) {
        return this.f1693c.beginTransaction();
    }

    /* renamed from: a */
    public Fragment m57897a() {
        return this.f1691a.get(this.f1695e);
    }

    /* renamed from: b */
    public int m57896b() {
        return this.f1695e;
    }

    /* renamed from: c */
    public C1119a m57895c() {
        return this.f1696f;
    }

    /* renamed from: e */
    public void m57893e(boolean z) {
        this.f1697g = z;
    }

    /* renamed from: f */
    public void m57892f(C1119a c1119a) {
        this.f1696f = c1119a;
    }

    /* renamed from: g */
    public void m57891g(int i) {
        for (int i2 = 0; i2 < this.f1691a.size(); i2++) {
            Fragment fragment = this.f1691a.get(i2);
            FragmentTransaction m57894d = m57894d(i);
            if (i == i2) {
                m57894d.show(fragment);
            } else {
                m57894d.hide(fragment);
            }
            m57894d.commitAllowingStateLoss();
        }
        this.f1695e = i;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (!this.f1697g) {
            C1119a c1119a = this.f1696f;
            if (c1119a != null) {
                c1119a.m57889b();
                return;
            }
            return;
        }
        for (int i = 0; i < this.f1692b.getTabCount(); i++) {
            try {
                if (this.f1692b.getTabAt(i) == tab) {
                    Fragment fragment = this.f1691a.get(i);
                    FragmentTransaction m57894d = m57894d(i);
                    if (fragment.isAdded()) {
                        this.f1695e = i;
                        if (!fragment.isResumed()) {
                            fragment.onResume();
                        }
                    } else {
                        m57894d.add(this.f1694d, fragment, String.valueOf(this.f1695e));
                    }
                    m57891g(i);
                    m57894d.commitAllowingStateLoss();
                    C1119a c1119a2 = this.f1696f;
                    if (c1119a2 != null) {
                        c1119a2.m57890a(this.f1692b, tab, i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public FragmentTabAdapter(FragmentManager fragmentManager, List<Fragment> list, int i, TabLayout tabLayout, int i2) {
        this.f1697g = true;
        this.f1691a = list;
        this.f1692b = tabLayout;
        this.f1693c = fragmentManager;
        this.f1694d = i;
        this.f1695e = i2;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, list.get(i2), String.valueOf(i2));
        beginTransaction.commitAllowingStateLoss();
        if (tabLayout != null) {
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        }
    }
}
