package com.acse.ottn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.widget.RoundRectImageView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class d0<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public static final String f5534e = "BaseViewPagerAdapter";

    /* renamed from: a  reason: collision with root package name */
    public List<T> f5535a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5536b;

    /* renamed from: c  reason: collision with root package name */
    public s f5537c;

    /* renamed from: d  reason: collision with root package name */
    public b f5538d;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f5539a;

        public a(int i4) {
            this.f5539a = i4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0.this.f5537c.f();
            if (d0.this.f5538d != null) {
                d0.this.f5538d.a(this.f5539a % d0.this.a(), d0.this.f5535a.get(this.f5539a % d0.this.a()));
            }
            d0.this.f5537c.e();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface b<T> {
        void a(int i4, T t3);
    }

    public d0(List<T> list) {
        new ArrayList();
        this.f5535a = list;
    }

    public abstract void a(TextView textView, int i4, T t3);

    public abstract void a(RoundRectImageView roundRectImageView, int i4, T t3);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i4, Object obj) {
        viewGroup.removeView((ImageView) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.f5535a;
        return (list == null || list.size() == 0) ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i4) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) LayoutInflater.from(this.f5536b).inflate(R.layout.imageview, viewGroup, false);
        a(roundRectImageView, i4, (int) this.f5535a.get(i4 % a()));
        viewGroup.addView(roundRectImageView);
        if (this.f5537c.getSubTitle() != null) {
            if (i4 == 0) {
                a(this.f5537c.getSubTitle(), i4, (int) this.f5535a.get(a() - 1));
            } else {
                a(this.f5537c.getSubTitle(), i4, (int) this.f5535a.get((i4 - 1) % a()));
            }
        }
        roundRectImageView.setOnClickListener(new a(i4));
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
        this.f5537c.a(i4 % a());
    }

    public void a(s sVar, d0 d0Var) {
        this.f5537c = sVar;
        sVar.setAdapter(this);
        this.f5537c.addOnPageChangeListener(this);
        List<T> list = this.f5535a;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f5537c.setCurrentItem(1073741823 - (1073741823 % a()));
        if (this.f5537c.c()) {
            return;
        }
        this.f5537c.g();
        this.f5537c.b(a());
    }

    public void b(List<T> list) {
        if (this.f5535a == null) {
            this.f5535a = new ArrayList();
        }
        this.f5535a.clear();
        this.f5535a.addAll(list);
        notifyDataSetChanged();
        if (this.f5537c.c()) {
            return;
        }
        this.f5537c.g();
        this.f5537c.b(a());
    }

    public d0(Context context) {
        this.f5535a = new ArrayList();
        this.f5536b = context;
    }

    public d0(Context context, b bVar) {
        this.f5535a = new ArrayList();
        this.f5536b = context;
        this.f5538d = bVar;
    }

    public d0(Context context, List<T> list) {
        new ArrayList();
        this.f5536b = context;
        this.f5535a = list;
    }

    public void a(b bVar) {
        this.f5538d = bVar;
    }

    public void a(T t3) {
        if (this.f5537c.getAdapter() != null) {
            if (this.f5535a == null) {
                this.f5535a = new ArrayList();
            }
            int currentItem = this.f5537c.getCurrentItem() % a();
            this.f5535a.add(t3);
            this.f5537c.f();
            Log.d(f5534e, "\u5f53\u524d\u663e\u793a\u7b2c" + currentItem + TTPathConst.sSeparator + this.f5537c.getCurrentItem());
            this.f5537c.a(a(), currentItem);
            this.f5537c.e();
            return;
        }
        throw new RuntimeException("\u5fc5\u987b\u5148\u8bbe\u7f6eAdapter");
    }

    public d0(Context context, List<T> list, b bVar) {
        new ArrayList();
        this.f5536b = context;
        this.f5535a = list;
        this.f5538d = bVar;
    }

    public void a(List<T> list) {
        if (this.f5535a == null) {
            this.f5535a = new ArrayList();
        }
        this.f5535a.addAll(list);
        notifyDataSetChanged();
        this.f5537c.g();
        this.f5537c.b(a());
    }

    public int a() {
        List<T> list = this.f5535a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
