package com.bxkj.base.v2.common.view;

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
import com.bxkj.base.R;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CycleViewPager extends FrameLayout implements ViewPager.OnPageChangeListener {
    private static final String B = "CycleViewPager";
    private int A;

    /* renamed from: a  reason: collision with root package name */
    private Context f18637a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f18638b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18639c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f18640d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f18641e;

    /* renamed from: f  reason: collision with root package name */
    private int f18642f;

    /* renamed from: g  reason: collision with root package name */
    private int f18643g;

    /* renamed from: h  reason: collision with root package name */
    private List<View> f18644h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView[] f18645i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18646j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18647k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18648l;

    /* renamed from: m  reason: collision with root package name */
    private int f18649m;

    /* renamed from: n  reason: collision with root package name */
    private int f18650n;

    /* renamed from: o  reason: collision with root package name */
    private long f18651o;

    /* renamed from: p  reason: collision with root package name */
    private e f18652p;

    /* renamed from: q  reason: collision with root package name */
    private c f18653q;

    /* renamed from: r  reason: collision with root package name */
    private d f18654r;

    /* renamed from: s  reason: collision with root package name */
    private List<String> f18655s;

    /* renamed from: t  reason: collision with root package name */
    private List<Integer> f18656t;

    /* renamed from: u  reason: collision with root package name */
    private int f18657u;

    /* renamed from: v  reason: collision with root package name */
    private int f18658v;

    /* renamed from: w  reason: collision with root package name */
    final Runnable f18659w;

    /* renamed from: x  reason: collision with root package name */
    private int f18660x;

    /* renamed from: y  reason: collision with root package name */
    private int f18661y;

    /* renamed from: z  reason: collision with root package name */
    private View f18662z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CycleViewPager.this.f18637a == null || !CycleViewPager.this.f18648l) {
                return;
            }
            if (System.currentTimeMillis() - CycleViewPager.this.f18651o > CycleViewPager.this.f18649m - 500) {
                CycleViewPager.this.f18641e.sendEmptyMessage(CycleViewPager.this.f18642f);
            } else {
                CycleViewPager.this.f18641e.sendEmptyMessage(CycleViewPager.this.f18643g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == CycleViewPager.this.f18642f && CycleViewPager.this.f18644h.size() > 0) {
                if (!CycleViewPager.this.f18646j) {
                    CycleViewPager.this.f18638b.setCurrentItem((CycleViewPager.this.f18650n + 1) % CycleViewPager.this.f18644h.size(), true);
                }
                CycleViewPager.this.f18651o = System.currentTimeMillis();
                CycleViewPager.this.f18641e.removeCallbacks(CycleViewPager.this.f18659w);
                Handler handler = CycleViewPager.this.f18641e;
                CycleViewPager cycleViewPager = CycleViewPager.this;
                handler.postDelayed(cycleViewPager.f18659w, cycleViewPager.f18649m);
            } else if (message.what != CycleViewPager.this.f18643g || CycleViewPager.this.f18644h.size() <= 0) {
            } else {
                CycleViewPager.this.f18641e.removeCallbacks(CycleViewPager.this.f18659w);
                Handler handler2 = CycleViewPager.this.f18641e;
                CycleViewPager cycleViewPager2 = CycleViewPager.this;
                handler2.postDelayed(cycleViewPager2.f18659w, cycleViewPager2.f18649m);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface c {
        void onImageClick(String str, int i4, View view);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface d {
        void onItemSelect(int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends PagerAdapter {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CycleViewPager.this.f18653q.onImageClick((String) CycleViewPager.this.f18655s.get(CycleViewPager.this.f18650n - 1), CycleViewPager.this.f18650n - 1, view);
            }
        }

        private e() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i4, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CycleViewPager.this.f18644h.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* synthetic */ e(CycleViewPager cycleViewPager, a aVar) {
            this();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup viewGroup, int i4) {
            View view = (View) CycleViewPager.this.f18644h.get(i4);
            if (CycleViewPager.this.f18653q != null) {
                view.setOnClickListener(new a());
            }
            viewGroup.addView(view);
            return view;
        }
    }

    public CycleViewPager(Context context) {
        this(context, null);
    }

    public static void C(TextView textView, int i4) {
        if (textView != null) {
            D(textView, i4 + "");
        }
    }

    public static void D(TextView textView, String str) {
        if (str == null || textView == null) {
            return;
        }
        textView.setText(str);
    }

    private View q(Context context, int i4) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        com.bumptech.glide.d.C(context).p(Integer.valueOf(i4)).i1(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    private View r(Context context, String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        try {
            com.bumptech.glide.d.C(context).p(Integer.valueOf(Integer.parseInt(str))).i1(imageView);
        } catch (NumberFormatException unused) {
            com.bumptech.glide.d.C(context).a(str).i1(imageView);
        }
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    private void s() {
        LayoutInflater.from(this.f18637a).inflate(R.layout.pub_layout_cycle_view, (ViewGroup) this, true);
        this.f18638b = (ViewPager) findViewById(R.id.cycle_view_pager);
        this.f18639c = (TextView) findViewById(R.id.cycle_title);
        this.f18640d = (LinearLayout) findViewById(R.id.cycle_indicator);
        this.f18641e = new b();
    }

    private void setIndicator(int i4) {
        ImageView[] imageViewArr;
        d dVar = this.f18654r;
        if (dVar != null) {
            dVar.onItemSelect(i4);
        }
        int i5 = 0;
        while (true) {
            try {
                imageViewArr = this.f18645i;
                if (i5 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i5].setBackgroundResource(this.f18658v);
                i5++;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (imageViewArr.length > i4) {
            imageViewArr[i4].setBackgroundResource(this.f18657u);
        }
    }

    public void A(int i4, int i5) {
        this.f18660x = i4;
        this.f18661y = i5;
    }

    public void B(int i4, int i5) {
        this.f18657u = i4;
        this.f18658v = i5;
    }

    public void o(View view) {
        this.f18662z = view;
        this.f18644h.add(view);
        if (this.f18655s == null) {
            this.f18655s = new ArrayList();
        }
        if (!this.f18655s.isEmpty() && this.f18644h.size() > 1 && this.f18644h.size() > this.f18655s.size()) {
            List<View> list = this.f18644h;
            list.remove(list.size() - 2);
        }
        this.f18644h.add(r(this.f18637a, this.f18655s.get(0)));
        int size = this.f18644h.size();
        this.f18645i = new ImageView[size];
        if (this.f18647k) {
            this.f18645i = new ImageView[size - 2];
        }
        this.f18640d.removeAllViews();
        int i4 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f18645i;
            if (i4 < imageViewArr.length) {
                imageViewArr[i4] = new ImageView(this.f18637a);
                this.f18645i[i4].setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18660x, this.f18661y);
                layoutParams.setMargins(10, 0, 10, 0);
                this.f18645i[i4].setLayoutParams(layoutParams);
                this.f18640d.addView(this.f18645i[i4]);
                i4++;
            } else {
                setIndicator(this.A);
                this.f18652p.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f18641e.removeCallbacks(this.f18659w);
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i4) {
        if (i4 == 1) {
            this.f18646j = true;
            return;
        }
        if (i4 == 0) {
            this.f18651o = System.currentTimeMillis();
            this.f18638b.setCurrentItem(this.f18650n, false);
        }
        this.f18646j = false;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i4, float f4, int i5) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i4) {
        int size = this.f18644h.size() - 1;
        this.f18650n = i4;
        if (this.f18647k) {
            if (i4 == 0) {
                this.f18650n = size - 1;
            } else if (i4 == size) {
                this.f18650n = 1;
            }
            i4 = this.f18650n - 1;
        }
        this.A = i4;
        setIndicator(i4);
    }

    public void p() {
        this.f18644h.remove(this.f18662z);
        int size = this.f18644h.size();
        this.f18645i = new ImageView[size];
        if (this.f18647k) {
            this.f18645i = new ImageView[size - 2];
        }
        this.f18640d.removeAllViews();
        int i4 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f18645i;
            if (i4 < imageViewArr.length) {
                imageViewArr[i4] = new ImageView(this.f18637a);
                this.f18645i[i4].setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18660x, this.f18661y);
                layoutParams.setMargins(10, 0, 10, 0);
                this.f18645i[i4].setLayoutParams(layoutParams);
                this.f18640d.addView(this.f18645i[i4]);
                i4++;
            } else {
                this.f18650n = 1;
                setIndicator(0);
                this.f18652p.notifyDataSetChanged();
                return;
            }
        }
    }

    public void setCycle(boolean z3) {
        this.f18647k = z3;
    }

    public void setDelay(int i4) {
        this.f18649m = i4;
    }

    public void setImageCycleViewSelectListener(d dVar) {
        this.f18654r = dVar;
    }

    public void setWheel(boolean z3) {
        this.f18648l = z3;
        this.f18647k = true;
        if (z3) {
            this.f18641e.postDelayed(this.f18659w, this.f18649m);
        }
    }

    public boolean t() {
        return this.f18647k;
    }

    public boolean u() {
        return this.f18648l;
    }

    public void v() {
        e eVar = this.f18652p;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    public void w(List<String> list, c cVar) {
        x(list, cVar, 0);
    }

    public void x(List<String> list, c cVar, int i4) {
        if (list != null && list.size() != 0) {
            this.f18644h.clear();
            this.f18655s = list;
            if (this.f18647k) {
                this.f18644h.add(r(this.f18637a, list.get(list.size() - 1)));
                for (int i5 = 0; i5 < this.f18655s.size(); i5++) {
                    this.f18644h.add(r(this.f18637a, this.f18655s.get(i5)));
                }
                this.f18644h.add(r(this.f18637a, this.f18655s.get(0)));
            } else {
                for (int i6 = 0; i6 < this.f18655s.size(); i6++) {
                    this.f18644h.add(r(this.f18637a, this.f18655s.get(i6)));
                }
            }
            List<View> list2 = this.f18644h;
            if (list2 != null && list2.size() != 0) {
                this.f18653q = cVar;
                int size = this.f18644h.size();
                this.f18645i = new ImageView[size];
                if (this.f18647k) {
                    this.f18645i = new ImageView[size - 2];
                }
                this.f18640d.removeAllViews();
                int i7 = 0;
                while (true) {
                    ImageView[] imageViewArr = this.f18645i;
                    if (i7 >= imageViewArr.length) {
                        break;
                    }
                    imageViewArr[i7] = new ImageView(this.f18637a);
                    this.f18645i[i7].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18660x, this.f18661y);
                    layoutParams.setMargins(10, 0, 10, 0);
                    this.f18645i[i7].setLayoutParams(layoutParams);
                    this.f18640d.addView(this.f18645i[i7]);
                    i7++;
                }
                this.f18652p = new e(this, null);
                setIndicator(0);
                this.f18638b.setOffscreenPageLimit(3);
                this.f18638b.setOnPageChangeListener(this);
                this.f18638b.setAdapter(this.f18652p);
                i4 = (i4 < 0 || i4 >= this.f18644h.size()) ? 0 : 0;
                if (this.f18647k) {
                    i4++;
                }
                this.f18638b.setCurrentItem(i4);
                setWheel(u());
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void y(List<Integer> list, c cVar) {
        z(list, cVar, 0);
    }

    public void z(List<Integer> list, c cVar, int i4) {
        if (list != null && list.size() != 0) {
            this.f18644h.clear();
            this.f18656t = list;
            if (this.f18647k) {
                List<View> list2 = this.f18644h;
                Context context = this.f18637a;
                List<String> list3 = this.f18655s;
                list2.add(r(context, list3.get(list3.size() - 1)));
                for (int i5 = 0; i5 < this.f18655s.size(); i5++) {
                    this.f18644h.add(r(this.f18637a, this.f18655s.get(i5)));
                }
                this.f18644h.add(r(this.f18637a, this.f18655s.get(0)));
            } else {
                for (int i6 = 0; i6 < this.f18655s.size(); i6++) {
                    this.f18644h.add(r(this.f18637a, this.f18655s.get(i6)));
                }
            }
            List<View> list4 = this.f18644h;
            if (list4 != null && list4.size() != 0) {
                this.f18653q = cVar;
                int size = this.f18644h.size();
                this.f18645i = new ImageView[size];
                if (this.f18647k) {
                    this.f18645i = new ImageView[size - 2];
                }
                this.f18640d.removeAllViews();
                int i7 = 0;
                while (true) {
                    ImageView[] imageViewArr = this.f18645i;
                    if (i7 >= imageViewArr.length) {
                        break;
                    }
                    imageViewArr[i7] = new ImageView(this.f18637a);
                    this.f18645i[i7].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18660x, this.f18661y);
                    layoutParams.setMargins(10, 0, 10, 0);
                    this.f18645i[i7].setLayoutParams(layoutParams);
                    this.f18640d.addView(this.f18645i[i7]);
                    i7++;
                }
                this.f18652p = new e(this, null);
                setIndicator(0);
                this.f18638b.setOffscreenPageLimit(3);
                this.f18638b.setOnPageChangeListener(this);
                this.f18638b.setAdapter(this.f18652p);
                i4 = (i4 < 0 || i4 >= this.f18644h.size()) ? 0 : 0;
                if (this.f18647k) {
                    i4++;
                }
                this.f18638b.setCurrentItem(i4);
                setWheel(u());
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

    public CycleViewPager(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18642f = 100;
        this.f18643g = 101;
        this.f18644h = new ArrayList();
        this.f18646j = false;
        this.f18647k = true;
        this.f18648l = true;
        this.f18649m = 5000;
        this.f18650n = 0;
        this.f18651o = 0L;
        this.f18659w = new a();
        this.f18660x = -2;
        this.f18661y = -2;
        this.f18662z = null;
        this.A = 0;
        this.f18637a = context;
        s();
    }
}
