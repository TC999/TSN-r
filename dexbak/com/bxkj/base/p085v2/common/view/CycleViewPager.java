package com.bxkj.base.p085v2.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bxkj.base.C3801R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.base.v2.common.view.CycleViewPager */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CycleViewPager extends FrameLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: B */
    private static final String f15144B = "CycleViewPager";

    /* renamed from: A */
    private int f15145A;

    /* renamed from: a */
    private Context f15146a;

    /* renamed from: b */
    private ViewPager f15147b;

    /* renamed from: c */
    private TextView f15148c;

    /* renamed from: d */
    private LinearLayout f15149d;

    /* renamed from: e */
    private Handler f15150e;

    /* renamed from: f */
    private int f15151f;

    /* renamed from: g */
    private int f15152g;

    /* renamed from: h */
    private List<View> f15153h;

    /* renamed from: i */
    private ImageView[] f15154i;

    /* renamed from: j */
    private boolean f15155j;

    /* renamed from: k */
    private boolean f15156k;

    /* renamed from: l */
    private boolean f15157l;

    /* renamed from: m */
    private int f15158m;

    /* renamed from: n */
    private int f15159n;

    /* renamed from: o */
    private long f15160o;

    /* renamed from: p */
    private C3979e f15161p;

    /* renamed from: q */
    private InterfaceC3977c f15162q;

    /* renamed from: r */
    private InterfaceC3978d f15163r;

    /* renamed from: s */
    private List<String> f15164s;

    /* renamed from: t */
    private List<Integer> f15165t;

    /* renamed from: u */
    private int f15166u;

    /* renamed from: v */
    private int f15167v;

    /* renamed from: w */
    final Runnable f15168w;

    /* renamed from: x */
    private int f15169x;

    /* renamed from: y */
    private int f15170y;

    /* renamed from: z */
    private View f15171z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.v2.common.view.CycleViewPager$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC3975a implements Runnable {
        RunnableC3975a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CycleViewPager.this.f15146a == null || !CycleViewPager.this.f15157l) {
                return;
            }
            if (System.currentTimeMillis() - CycleViewPager.this.f15160o > CycleViewPager.this.f15158m - 500) {
                CycleViewPager.this.f15150e.sendEmptyMessage(CycleViewPager.this.f15151f);
            } else {
                CycleViewPager.this.f15150e.sendEmptyMessage(CycleViewPager.this.f15152g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.v2.common.view.CycleViewPager$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class HandlerC3976b extends Handler {
        HandlerC3976b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == CycleViewPager.this.f15151f && CycleViewPager.this.f15153h.size() > 0) {
                if (!CycleViewPager.this.f15155j) {
                    CycleViewPager.this.f15147b.setCurrentItem((CycleViewPager.this.f15159n + 1) % CycleViewPager.this.f15153h.size(), true);
                }
                CycleViewPager.this.f15160o = System.currentTimeMillis();
                CycleViewPager.this.f15150e.removeCallbacks(CycleViewPager.this.f15168w);
                Handler handler = CycleViewPager.this.f15150e;
                CycleViewPager cycleViewPager = CycleViewPager.this;
                handler.postDelayed(cycleViewPager.f15168w, cycleViewPager.f15158m);
            } else if (message.what != CycleViewPager.this.f15152g || CycleViewPager.this.f15153h.size() <= 0) {
            } else {
                CycleViewPager.this.f15150e.removeCallbacks(CycleViewPager.this.f15168w);
                Handler handler2 = CycleViewPager.this.f15150e;
                CycleViewPager cycleViewPager2 = CycleViewPager.this;
                handler2.postDelayed(cycleViewPager2.f15168w, cycleViewPager2.f15158m);
            }
        }
    }

    /* renamed from: com.bxkj.base.v2.common.view.CycleViewPager$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC3977c {
        void onImageClick(String str, int i, View view);
    }

    /* renamed from: com.bxkj.base.v2.common.view.CycleViewPager$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC3978d {
        void onItemSelect(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bxkj.base.v2.common.view.CycleViewPager$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C3979e extends PagerAdapter {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.base.v2.common.view.CycleViewPager$e$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC3980a implements View.OnClickListener {
            View$OnClickListenerC3980a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CycleViewPager.this.f15162q.onImageClick((String) CycleViewPager.this.f15164s.get(CycleViewPager.this.f15159n - 1), CycleViewPager.this.f15159n - 1, view);
            }
        }

        private C3979e() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CycleViewPager.this.f15153h.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* synthetic */ C3979e(CycleViewPager cycleViewPager, RunnableC3975a runnableC3975a) {
            this();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup viewGroup, int i) {
            View view = (View) CycleViewPager.this.f15153h.get(i);
            if (CycleViewPager.this.f15162q != null) {
                view.setOnClickListener(new View$OnClickListenerC3980a());
            }
            viewGroup.addView(view);
            return view;
        }
    }

    public CycleViewPager(Context context) {
        this(context, null);
    }

    /* renamed from: C */
    public static void m43731C(TextView textView, int i) {
        if (textView != null) {
            m43730D(textView, i + "");
        }
    }

    /* renamed from: D */
    public static void m43730D(TextView textView, String str) {
        if (str == null || textView == null) {
            return;
        }
        textView.setText(str);
    }

    /* renamed from: q */
    private View m43713q(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        Glide.m45751C(context).mo45499p(Integer.valueOf(i)).m45551i1(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    /* renamed from: r */
    private View m43712r(Context context, String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        try {
            Glide.m45751C(context).mo45499p(Integer.valueOf(Integer.parseInt(str))).m45551i1(imageView);
        } catch (NumberFormatException unused) {
            Glide.m45751C(context).mo45507a(str).m45551i1(imageView);
        }
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    /* renamed from: s */
    private void m43711s() {
        LayoutInflater.from(this.f15146a).inflate(C3801R.C3807layout.pub_layout_cycle_view, (ViewGroup) this, true);
        this.f15147b = (ViewPager) findViewById(C3801R.C3805id.cycle_view_pager);
        this.f15148c = (TextView) findViewById(C3801R.C3805id.cycle_title);
        this.f15149d = (LinearLayout) findViewById(C3801R.C3805id.cycle_indicator);
        this.f15150e = new HandlerC3976b();
    }

    private void setIndicator(int i) {
        ImageView[] imageViewArr;
        InterfaceC3978d interfaceC3978d = this.f15163r;
        if (interfaceC3978d != null) {
            interfaceC3978d.onItemSelect(i);
        }
        int i2 = 0;
        while (true) {
            try {
                imageViewArr = this.f15154i;
                if (i2 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i2].setBackgroundResource(this.f15167v);
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (imageViewArr.length > i) {
            imageViewArr[i].setBackgroundResource(this.f15166u);
        }
    }

    /* renamed from: A */
    public void m43733A(int i, int i2) {
        this.f15169x = i;
        this.f15170y = i2;
    }

    /* renamed from: B */
    public void m43732B(int i, int i2) {
        this.f15166u = i;
        this.f15167v = i2;
    }

    /* renamed from: o */
    public void m43715o(View view) {
        this.f15171z = view;
        this.f15153h.add(view);
        if (this.f15164s == null) {
            this.f15164s = new ArrayList();
        }
        if (!this.f15164s.isEmpty() && this.f15153h.size() > 1 && this.f15153h.size() > this.f15164s.size()) {
            List<View> list = this.f15153h;
            list.remove(list.size() - 2);
        }
        this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(0)));
        int size = this.f15153h.size();
        this.f15154i = new ImageView[size];
        if (this.f15156k) {
            this.f15154i = new ImageView[size - 2];
        }
        this.f15149d.removeAllViews();
        int i = 0;
        while (true) {
            ImageView[] imageViewArr = this.f15154i;
            if (i < imageViewArr.length) {
                imageViewArr[i] = new ImageView(this.f15146a);
                this.f15154i[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f15169x, this.f15170y);
                layoutParams.setMargins(10, 0, 10, 0);
                this.f15154i[i].setLayoutParams(layoutParams);
                this.f15149d.addView(this.f15154i[i]);
                i++;
            } else {
                setIndicator(this.f15145A);
                this.f15161p.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f15150e.removeCallbacks(this.f15168w);
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 1) {
            this.f15155j = true;
            return;
        }
        if (i == 0) {
            this.f15160o = System.currentTimeMillis();
            this.f15147b.setCurrentItem(this.f15159n, false);
        }
        this.f15155j = false;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int size = this.f15153h.size() - 1;
        this.f15159n = i;
        if (this.f15156k) {
            if (i == 0) {
                this.f15159n = size - 1;
            } else if (i == size) {
                this.f15159n = 1;
            }
            i = this.f15159n - 1;
        }
        this.f15145A = i;
        setIndicator(i);
    }

    /* renamed from: p */
    public void m43714p() {
        this.f15153h.remove(this.f15171z);
        int size = this.f15153h.size();
        this.f15154i = new ImageView[size];
        if (this.f15156k) {
            this.f15154i = new ImageView[size - 2];
        }
        this.f15149d.removeAllViews();
        int i = 0;
        while (true) {
            ImageView[] imageViewArr = this.f15154i;
            if (i < imageViewArr.length) {
                imageViewArr[i] = new ImageView(this.f15146a);
                this.f15154i[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f15169x, this.f15170y);
                layoutParams.setMargins(10, 0, 10, 0);
                this.f15154i[i].setLayoutParams(layoutParams);
                this.f15149d.addView(this.f15154i[i]);
                i++;
            } else {
                this.f15159n = 1;
                setIndicator(0);
                this.f15161p.notifyDataSetChanged();
                return;
            }
        }
    }

    public void setCycle(boolean z) {
        this.f15156k = z;
    }

    public void setDelay(int i) {
        this.f15158m = i;
    }

    public void setImageCycleViewSelectListener(InterfaceC3978d interfaceC3978d) {
        this.f15163r = interfaceC3978d;
    }

    public void setWheel(boolean z) {
        this.f15157l = z;
        this.f15156k = true;
        if (z) {
            this.f15150e.postDelayed(this.f15168w, this.f15158m);
        }
    }

    /* renamed from: t */
    public boolean m43710t() {
        return this.f15156k;
    }

    /* renamed from: u */
    public boolean m43709u() {
        return this.f15157l;
    }

    /* renamed from: v */
    public void m43708v() {
        C3979e c3979e = this.f15161p;
        if (c3979e != null) {
            c3979e.notifyDataSetChanged();
        }
    }

    /* renamed from: w */
    public void m43707w(List<String> list, InterfaceC3977c interfaceC3977c) {
        m43706x(list, interfaceC3977c, 0);
    }

    /* renamed from: x */
    public void m43706x(List<String> list, InterfaceC3977c interfaceC3977c, int i) {
        if (list != null && list.size() != 0) {
            this.f15153h.clear();
            this.f15164s = list;
            if (this.f15156k) {
                this.f15153h.add(m43712r(this.f15146a, list.get(list.size() - 1)));
                for (int i2 = 0; i2 < this.f15164s.size(); i2++) {
                    this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(i2)));
                }
                this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(0)));
            } else {
                for (int i3 = 0; i3 < this.f15164s.size(); i3++) {
                    this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(i3)));
                }
            }
            List<View> list2 = this.f15153h;
            if (list2 != null && list2.size() != 0) {
                this.f15162q = interfaceC3977c;
                int size = this.f15153h.size();
                this.f15154i = new ImageView[size];
                if (this.f15156k) {
                    this.f15154i = new ImageView[size - 2];
                }
                this.f15149d.removeAllViews();
                int i4 = 0;
                while (true) {
                    ImageView[] imageViewArr = this.f15154i;
                    if (i4 >= imageViewArr.length) {
                        break;
                    }
                    imageViewArr[i4] = new ImageView(this.f15146a);
                    this.f15154i[i4].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f15169x, this.f15170y);
                    layoutParams.setMargins(10, 0, 10, 0);
                    this.f15154i[i4].setLayoutParams(layoutParams);
                    this.f15149d.addView(this.f15154i[i4]);
                    i4++;
                }
                this.f15161p = new C3979e(this, null);
                setIndicator(0);
                this.f15147b.setOffscreenPageLimit(3);
                this.f15147b.setOnPageChangeListener(this);
                this.f15147b.setAdapter(this.f15161p);
                i = (i < 0 || i >= this.f15153h.size()) ? 0 : 0;
                if (this.f15156k) {
                    i++;
                }
                this.f15147b.setCurrentItem(i);
                setWheel(m43709u());
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    /* renamed from: y */
    public void m43705y(List<Integer> list, InterfaceC3977c interfaceC3977c) {
        m43704z(list, interfaceC3977c, 0);
    }

    /* renamed from: z */
    public void m43704z(List<Integer> list, InterfaceC3977c interfaceC3977c, int i) {
        if (list != null && list.size() != 0) {
            this.f15153h.clear();
            this.f15165t = list;
            if (this.f15156k) {
                List<View> list2 = this.f15153h;
                Context context = this.f15146a;
                List<String> list3 = this.f15164s;
                list2.add(m43712r(context, list3.get(list3.size() - 1)));
                for (int i2 = 0; i2 < this.f15164s.size(); i2++) {
                    this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(i2)));
                }
                this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(0)));
            } else {
                for (int i3 = 0; i3 < this.f15164s.size(); i3++) {
                    this.f15153h.add(m43712r(this.f15146a, this.f15164s.get(i3)));
                }
            }
            List<View> list4 = this.f15153h;
            if (list4 != null && list4.size() != 0) {
                this.f15162q = interfaceC3977c;
                int size = this.f15153h.size();
                this.f15154i = new ImageView[size];
                if (this.f15156k) {
                    this.f15154i = new ImageView[size - 2];
                }
                this.f15149d.removeAllViews();
                int i4 = 0;
                while (true) {
                    ImageView[] imageViewArr = this.f15154i;
                    if (i4 >= imageViewArr.length) {
                        break;
                    }
                    imageViewArr[i4] = new ImageView(this.f15146a);
                    this.f15154i[i4].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f15169x, this.f15170y);
                    layoutParams.setMargins(10, 0, 10, 0);
                    this.f15154i[i4].setLayoutParams(layoutParams);
                    this.f15149d.addView(this.f15154i[i4]);
                    i4++;
                }
                this.f15161p = new C3979e(this, null);
                setIndicator(0);
                this.f15147b.setOffscreenPageLimit(3);
                this.f15147b.setOnPageChangeListener(this);
                this.f15147b.setAdapter(this.f15161p);
                i = (i < 0 || i >= this.f15153h.size()) ? 0 : 0;
                if (this.f15156k) {
                    i++;
                }
                this.f15147b.setCurrentItem(i);
                setWheel(m43709u());
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15151f = 100;
        this.f15152g = 101;
        this.f15153h = new ArrayList();
        this.f15155j = false;
        this.f15156k = true;
        this.f15157l = true;
        this.f15158m = 5000;
        this.f15159n = 0;
        this.f15160o = 0L;
        this.f15168w = new RunnableC3975a();
        this.f15169x = -2;
        this.f15170y = -2;
        this.f15171z = null;
        this.f15145A = 0;
        this.f15146a = context;
        m43711s();
    }
}
