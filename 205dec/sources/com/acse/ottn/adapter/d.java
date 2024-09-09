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
import com.acse.ottn.R;
import com.acse.ottn.widget.RoundRectImageView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class d<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4786a = "BaseViewPagerAdapter";

    /* renamed from: b  reason: collision with root package name */
    private List<T> f4787b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4788c;

    /* renamed from: d  reason: collision with root package name */
    private b f4789d;

    /* renamed from: e  reason: collision with root package name */
    private a f4790e;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a<T> {
        void a(int i4, T t3);
    }

    public d(Context context) {
        this.f4787b = new ArrayList();
        this.f4788c = context;
    }

    public d(Context context, a aVar) {
        this.f4787b = new ArrayList();
        this.f4788c = context;
        this.f4790e = aVar;
    }

    public d(Context context, List<T> list) {
        new ArrayList();
        this.f4788c = context;
        this.f4787b = list;
    }

    public d(Context context, List<T> list, a aVar) {
        new ArrayList();
        this.f4788c = context;
        this.f4787b = list;
        this.f4790e = aVar;
    }

    public d(List<T> list) {
        new ArrayList();
        this.f4787b = list;
    }

    public int a() {
        List<T> list = this.f4787b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public abstract void a(TextView textView, int i4, T t3);

    public void a(b bVar, d dVar) {
        this.f4789d = bVar;
        bVar.setAdapter(this);
        this.f4789d.addOnPageChangeListener(this);
        List<T> list = this.f4787b;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4789d.setCurrentItem(1073741823 - (1073741823 % a()));
        if (this.f4789d.a()) {
            return;
        }
        this.f4789d.e();
        this.f4789d.b(a());
    }

    public void a(a aVar) {
        this.f4790e = aVar;
    }

    public abstract void a(RoundRectImageView roundRectImageView, int i4, T t3);

    public void a(T t3) {
        if (this.f4789d.getAdapter() == null) {
            throw new RuntimeException("\u5fc5\u987b\u5148\u8bbe\u7f6eAdapter");
        }
        if (this.f4787b == null) {
            this.f4787b = new ArrayList();
        }
        int currentItem = this.f4789d.getCurrentItem() % a();
        this.f4787b.add(t3);
        this.f4789d.d();
        Log.d("BaseViewPagerAdapter", "\u5f53\u524d\u663e\u793a\u7b2c" + currentItem + TTPathConst.sSeparator + this.f4789d.getCurrentItem());
        this.f4789d.a(a(), currentItem);
        this.f4789d.c();
    }

    public void a(List<T> list) {
        if (this.f4787b == null) {
            this.f4787b = new ArrayList();
        }
        this.f4787b.addAll(list);
        notifyDataSetChanged();
        this.f4789d.e();
        this.f4789d.b(a());
    }

    public void b(List<T> list) {
        if (this.f4787b == null) {
            this.f4787b = new ArrayList();
        }
        this.f4787b.clear();
        this.f4787b.addAll(list);
        notifyDataSetChanged();
        if (this.f4789d.a()) {
            return;
        }
        this.f4789d.e();
        this.f4789d.b(a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i4, Object obj) {
        viewGroup.removeView((ImageView) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.f4787b;
        return (list == null || list.size() == 0) ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i4) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) LayoutInflater.from(this.f4788c).inflate(R.layout.imageview, viewGroup, false);
        a(roundRectImageView, i4, (int) this.f4787b.get(i4 % a()));
        viewGroup.addView(roundRectImageView);
        if (this.f4789d.getSubTitle() != null) {
            a(this.f4789d.getSubTitle(), i4, (int) this.f4787b.get(i4 == 0 ? a() - 1 : (i4 - 1) % a()));
        }
        roundRectImageView.setOnClickListener(new c(this, i4));
        return roundRectImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i4) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i4, float f4, int i5) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i4) {
        this.f4789d.a(i4 % a());
    }
}
