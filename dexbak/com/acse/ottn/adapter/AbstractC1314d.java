package com.acse.ottn.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.C1239R;
import com.acse.ottn.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.internal.C15104v;

/* renamed from: com.acse.ottn.adapter.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1314d<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private static final String f2235a = "BaseViewPagerAdapter";

    /* renamed from: b */
    private List<T> f2236b;

    /* renamed from: c */
    private Context f2237c;

    /* renamed from: d */
    private C1310b f2238d;

    /* renamed from: e */
    private InterfaceC1315a f2239e;

    /* renamed from: com.acse.ottn.adapter.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1315a<T> {
        /* renamed from: a */
        void mo57217a(int i, T t);
    }

    public AbstractC1314d(Context context) {
        this.f2236b = new ArrayList();
        this.f2237c = context;
    }

    public AbstractC1314d(Context context, InterfaceC1315a interfaceC1315a) {
        this.f2236b = new ArrayList();
        this.f2237c = context;
        this.f2239e = interfaceC1315a;
    }

    public AbstractC1314d(Context context, List<T> list) {
        new ArrayList();
        this.f2237c = context;
        this.f2236b = list;
    }

    public AbstractC1314d(Context context, List<T> list, InterfaceC1315a interfaceC1315a) {
        new ArrayList();
        this.f2237c = context;
        this.f2236b = list;
        this.f2239e = interfaceC1315a;
    }

    public AbstractC1314d(List<T> list) {
        new ArrayList();
        this.f2236b = list;
    }

    /* renamed from: a */
    public int m57228a() {
        List<T> list = this.f2236b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public abstract void m57227a(TextView textView, int i, T t);

    /* renamed from: a */
    public void m57226a(C1310b c1310b, AbstractC1314d abstractC1314d) {
        this.f2238d = c1310b;
        c1310b.setAdapter(this);
        this.f2238d.addOnPageChangeListener(this);
        List<T> list = this.f2236b;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f2238d.setCurrentItem(C15104v.f43109i - (C15104v.f43109i % m57228a()));
        if (this.f2238d.m57242a()) {
            return;
        }
        this.f2238d.m57231e();
        this.f2238d.m57236b(m57228a());
    }

    /* renamed from: a */
    public void m57225a(InterfaceC1315a interfaceC1315a) {
        this.f2239e = interfaceC1315a;
    }

    /* renamed from: a */
    public abstract void m57223a(RoundRectImageView roundRectImageView, int i, T t);

    /* renamed from: a */
    public void m57222a(T t) {
        if (this.f2238d.getAdapter() == null) {
            throw new RuntimeException("必须先设置Adapter");
        }
        if (this.f2236b == null) {
            this.f2236b = new ArrayList();
        }
        int currentItem = this.f2238d.getCurrentItem() % m57228a();
        this.f2236b.add(t);
        this.f2238d.m57232d();
        Log.d(f2235a, "当前显示第" + currentItem + "/" + this.f2238d.getCurrentItem());
        this.f2238d.m57240a(m57228a(), currentItem);
        this.f2238d.m57234c();
    }

    /* renamed from: a */
    public void m57221a(List<T> list) {
        if (this.f2236b == null) {
            this.f2236b = new ArrayList();
        }
        this.f2236b.addAll(list);
        notifyDataSetChanged();
        this.f2238d.m57231e();
        this.f2238d.m57236b(m57228a());
    }

    /* renamed from: b */
    public void m57219b(List<T> list) {
        if (this.f2236b == null) {
            this.f2236b = new ArrayList();
        }
        this.f2236b.clear();
        this.f2236b.addAll(list);
        notifyDataSetChanged();
        if (this.f2238d.m57242a()) {
            return;
        }
        this.f2238d.m57231e();
        this.f2238d.m57236b(m57228a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((ImageView) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.f2236b;
        return (list == null || list.size() == 0) ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) LayoutInflater.from(this.f2237c).inflate(C1239R.C1244layout.imageview, viewGroup, false);
        m57223a(roundRectImageView, i, (int) this.f2236b.get(i % m57228a()));
        viewGroup.addView(roundRectImageView);
        if (this.f2238d.getSubTitle() != null) {
            m57227a(this.f2238d.getSubTitle(), i, (int) this.f2236b.get(i == 0 ? m57228a() - 1 : (i - 1) % m57228a()));
        }
        roundRectImageView.setOnClickListener(new View$OnClickListenerC1313c(this, i));
        return roundRectImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f2238d.m57241a(i % m57228a());
    }
}
