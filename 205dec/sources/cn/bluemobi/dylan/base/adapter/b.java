package cn.bluemobi.dylan.base.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FragmentTabAdapter.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements TabLayout.OnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private List<Fragment> f1677a;

    /* renamed from: b  reason: collision with root package name */
    private TabLayout f1678b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f1679c;

    /* renamed from: d  reason: collision with root package name */
    private int f1680d;

    /* renamed from: e  reason: collision with root package name */
    private int f1681e;

    /* renamed from: f  reason: collision with root package name */
    private a f1682f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1683g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: FragmentTabAdapter.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {
        public void a(TabLayout tabLayout, TabLayout.Tab tab, int i4) {
        }

        public void b() {
        }
    }

    public b(FragmentManager fragmentManager, List<Fragment> list, int i4, TabLayout tabLayout) {
        this(fragmentManager, list, i4, tabLayout, 0);
    }

    private FragmentTransaction d(int i4) {
        return this.f1679c.beginTransaction();
    }

    public Fragment a() {
        return this.f1677a.get(this.f1681e);
    }

    public int b() {
        return this.f1681e;
    }

    public a c() {
        return this.f1682f;
    }

    public void e(boolean z3) {
        this.f1683g = z3;
    }

    public void f(a aVar) {
        this.f1682f = aVar;
    }

    public void g(int i4) {
        for (int i5 = 0; i5 < this.f1677a.size(); i5++) {
            Fragment fragment = this.f1677a.get(i5);
            FragmentTransaction d4 = d(i4);
            if (i4 == i5) {
                d4.show(fragment);
            } else {
                d4.hide(fragment);
            }
            d4.commitAllowingStateLoss();
        }
        this.f1681e = i4;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (!this.f1683g) {
            a aVar = this.f1682f;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        for (int i4 = 0; i4 < this.f1678b.getTabCount(); i4++) {
            try {
                if (this.f1678b.getTabAt(i4) == tab) {
                    Fragment fragment = this.f1677a.get(i4);
                    FragmentTransaction d4 = d(i4);
                    if (fragment.isAdded()) {
                        this.f1681e = i4;
                        if (!fragment.isResumed()) {
                            fragment.onResume();
                        }
                    } else {
                        d4.add(this.f1680d, fragment, String.valueOf(this.f1681e));
                    }
                    g(i4);
                    d4.commitAllowingStateLoss();
                    a aVar2 = this.f1682f;
                    if (aVar2 != null) {
                        aVar2.a(this.f1678b, tab, i4);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public b(FragmentManager fragmentManager, List<Fragment> list, int i4, TabLayout tabLayout, int i5) {
        this.f1683g = true;
        this.f1677a = list;
        this.f1678b = tabLayout;
        this.f1679c = fragmentManager;
        this.f1680d = i4;
        this.f1681e = i5;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i4, list.get(i5), String.valueOf(i5));
        beginTransaction.commitAllowingStateLoss();
        if (tabLayout != null) {
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        }
    }
}
