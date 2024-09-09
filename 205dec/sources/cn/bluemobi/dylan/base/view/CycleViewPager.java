package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
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
import cn.bluemobi.dylan.base.R;
import com.bumptech.glide.d;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CycleViewPager extends FrameLayout implements ViewPager.OnPageChangeListener {
    private static final String TAG = "CycleViewPager";
    private int WHEEL;
    private int WHEEL_WAIT;
    private int delay;
    private int dotHeight;
    private int dotWidth;
    private Handler handler;
    private ImageCycleViewSelectListener imageCycleViewSelectListener;
    private List<String> infos;
    private List<Integer> infos0;
    private boolean isCycle;
    private boolean isScrolling;
    private boolean isWheel;
    private ViewPagerAdapter mAdapter;
    private Context mContext;
    private int mCurrentPosition;
    private ImageCycleViewListener mImageCycleViewListener;
    private LinearLayout mIndicatorLayout;
    private int mIndicatorSelected;
    private int mIndicatorUnselected;
    private ImageView[] mIndicators;
    private TextView mTitle;
    private ViewPager mViewPager;
    private List<View> mViews;
    private long releaseTime;
    final Runnable runnable;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface ImageCycleViewListener {
        void onImageClick(String str, int i4, View view);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface ImageCycleViewSelectListener {
        void onItemSelect(int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class ViewPagerAdapter extends PagerAdapter {
        private ViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i4, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CycleViewPager.this.mViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup viewGroup, int i4) {
            View view = (View) CycleViewPager.this.mViews.get(i4);
            if (CycleViewPager.this.mImageCycleViewListener != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.CycleViewPager.ViewPagerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CycleViewPager.this.mImageCycleViewListener.onImageClick((String) CycleViewPager.this.infos.get(CycleViewPager.this.mCurrentPosition - 1), CycleViewPager.this.mCurrentPosition - 1, view2);
                    }
                });
            }
            viewGroup.addView(view);
            return view;
        }
    }

    public CycleViewPager(Context context) {
        this(context, null);
    }

    private View getImageView(Context context, int i4) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        d.C(context).p(Integer.valueOf(i4)).j1(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.pub_layout_cycle_view, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(R.id.cycle_view_pager);
        this.mTitle = (TextView) findViewById(R.id.cycle_title);
        this.mIndicatorLayout = (LinearLayout) findViewById(R.id.cycle_indicator);
        this.handler = new Handler() { // from class: cn.bluemobi.dylan.base.view.CycleViewPager.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == CycleViewPager.this.WHEEL && CycleViewPager.this.mViews.size() > 0) {
                    if (!CycleViewPager.this.isScrolling) {
                        CycleViewPager.this.mViewPager.setCurrentItem((CycleViewPager.this.mCurrentPosition + 1) % CycleViewPager.this.mViews.size(), true);
                    }
                    CycleViewPager.this.releaseTime = System.currentTimeMillis();
                    CycleViewPager.this.handler.removeCallbacks(CycleViewPager.this.runnable);
                    Handler handler = CycleViewPager.this.handler;
                    CycleViewPager cycleViewPager = CycleViewPager.this;
                    handler.postDelayed(cycleViewPager.runnable, cycleViewPager.delay);
                } else if (message.what != CycleViewPager.this.WHEEL_WAIT || CycleViewPager.this.mViews.size() <= 0) {
                } else {
                    CycleViewPager.this.handler.removeCallbacks(CycleViewPager.this.runnable);
                    Handler handler2 = CycleViewPager.this.handler;
                    CycleViewPager cycleViewPager2 = CycleViewPager.this;
                    handler2.postDelayed(cycleViewPager2.runnable, cycleViewPager2.delay);
                }
            }
        };
    }

    private void setIndicator(int i4) {
        ImageView[] imageViewArr;
        ImageCycleViewSelectListener imageCycleViewSelectListener = this.imageCycleViewSelectListener;
        if (imageCycleViewSelectListener != null) {
            imageCycleViewSelectListener.onItemSelect(i4);
        }
        int i5 = 0;
        while (true) {
            try {
                imageViewArr = this.mIndicators;
                if (i5 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i5].setBackgroundResource(this.mIndicatorUnselected);
                i5++;
            } catch (Exception unused) {
                Log.i("CycleViewPager", "\u6307\u793a\u5668\u8def\u5f84\u4e0d\u6b63\u786e");
                return;
            }
        }
        if (imageViewArr.length > i4) {
            imageViewArr[i4].setBackgroundResource(this.mIndicatorSelected);
        }
    }

    public static void setText(TextView textView, String str) {
        if (str == null || textView == null) {
            return;
        }
        textView.setText(str);
    }

    public boolean isCycle() {
        return this.isCycle;
    }

    public boolean isWheel() {
        return this.isWheel;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.handler.removeCallbacks(this.runnable);
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i4) {
        if (i4 == 1) {
            this.isScrolling = true;
            return;
        }
        if (i4 == 0) {
            this.releaseTime = System.currentTimeMillis();
            this.mViewPager.setCurrentItem(this.mCurrentPosition, false);
        }
        this.isScrolling = false;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i4, float f4, int i5) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i4) {
        int size = this.mViews.size() - 1;
        this.mCurrentPosition = i4;
        if (this.isCycle) {
            if (i4 == 0) {
                this.mCurrentPosition = size - 1;
            } else if (i4 == size) {
                this.mCurrentPosition = 1;
            }
            i4 = this.mCurrentPosition - 1;
        }
        setIndicator(i4);
    }

    public void refreshData() {
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.notifyDataSetChanged();
        }
    }

    public void setCycle(boolean z3) {
        this.isCycle = z3;
    }

    public void setData(List<String> list, ImageCycleViewListener imageCycleViewListener) {
        setData(list, imageCycleViewListener, 0);
    }

    public void setDataResource(List<Integer> list, ImageCycleViewListener imageCycleViewListener) {
        setDataResource(list, imageCycleViewListener, 0);
    }

    public void setDelay(int i4) {
        this.delay = i4;
    }

    public void setImageCycleViewSelectListener(ImageCycleViewSelectListener imageCycleViewSelectListener) {
        this.imageCycleViewSelectListener = imageCycleViewSelectListener;
    }

    public void setIndicatorSize(int i4, int i5) {
        this.dotWidth = i4;
        this.dotHeight = i5;
    }

    public void setIndicators(int i4, int i5) {
        this.mIndicatorSelected = i4;
        this.mIndicatorUnselected = i5;
    }

    public void setWheel(boolean z3) {
        this.isWheel = z3;
        this.isCycle = true;
        if (z3) {
            this.handler.postDelayed(this.runnable, this.delay);
        }
    }

    public CycleViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void setText(TextView textView, int i4) {
        if (textView != null) {
            setText(textView, i4 + "");
        }
    }

    public void setData(List<String> list, ImageCycleViewListener imageCycleViewListener, int i4) {
        if (list != null && list.size() != 0) {
            this.mViews.clear();
            this.infos = list;
            if (this.isCycle) {
                this.mViews.add(getImageView(this.mContext, list.get(list.size() - 1)));
                for (int i5 = 0; i5 < this.infos.size(); i5++) {
                    this.mViews.add(getImageView(this.mContext, this.infos.get(i5)));
                }
                this.mViews.add(getImageView(this.mContext, this.infos.get(0)));
            } else {
                for (int i6 = 0; i6 < this.infos.size(); i6++) {
                    this.mViews.add(getImageView(this.mContext, this.infos.get(i6)));
                }
            }
            List<View> list2 = this.mViews;
            if (list2 != null && list2.size() != 0) {
                this.mImageCycleViewListener = imageCycleViewListener;
                int size = this.mViews.size();
                this.mIndicators = new ImageView[size];
                if (this.isCycle) {
                    this.mIndicators = new ImageView[size - 2];
                }
                this.mIndicatorLayout.removeAllViews();
                int i7 = 0;
                while (true) {
                    ImageView[] imageViewArr = this.mIndicators;
                    if (i7 >= imageViewArr.length) {
                        break;
                    }
                    imageViewArr[i7] = new ImageView(this.mContext);
                    this.mIndicators[i7].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dotWidth, this.dotHeight);
                    layoutParams.setMargins(10, 0, 10, 0);
                    this.mIndicators[i7].setLayoutParams(layoutParams);
                    this.mIndicatorLayout.addView(this.mIndicators[i7]);
                    i7++;
                }
                this.mAdapter = new ViewPagerAdapter();
                setIndicator(0);
                this.mViewPager.setOffscreenPageLimit(3);
                this.mViewPager.setOnPageChangeListener(this);
                this.mViewPager.setAdapter(this.mAdapter);
                i4 = (i4 < 0 || i4 >= this.mViews.size()) ? 0 : 0;
                if (this.isCycle) {
                    i4++;
                }
                this.mViewPager.setCurrentItem(i4);
                setWheel(isWheel());
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void setDataResource(List<Integer> list, ImageCycleViewListener imageCycleViewListener, int i4) {
        if (list != null && list.size() != 0) {
            this.mViews.clear();
            this.infos0 = list;
            if (this.isCycle) {
                List<View> list2 = this.mViews;
                Context context = this.mContext;
                List<String> list3 = this.infos;
                list2.add(getImageView(context, list3.get(list3.size() - 1)));
                for (int i5 = 0; i5 < this.infos.size(); i5++) {
                    this.mViews.add(getImageView(this.mContext, this.infos.get(i5)));
                }
                this.mViews.add(getImageView(this.mContext, this.infos.get(0)));
            } else {
                for (int i6 = 0; i6 < this.infos.size(); i6++) {
                    this.mViews.add(getImageView(this.mContext, this.infos.get(i6)));
                }
            }
            List<View> list4 = this.mViews;
            if (list4 != null && list4.size() != 0) {
                this.mImageCycleViewListener = imageCycleViewListener;
                int size = this.mViews.size();
                this.mIndicators = new ImageView[size];
                if (this.isCycle) {
                    this.mIndicators = new ImageView[size - 2];
                }
                this.mIndicatorLayout.removeAllViews();
                int i7 = 0;
                while (true) {
                    ImageView[] imageViewArr = this.mIndicators;
                    if (i7 >= imageViewArr.length) {
                        break;
                    }
                    imageViewArr[i7] = new ImageView(this.mContext);
                    this.mIndicators[i7].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dotWidth, this.dotHeight);
                    layoutParams.setMargins(10, 0, 10, 0);
                    this.mIndicators[i7].setLayoutParams(layoutParams);
                    this.mIndicatorLayout.addView(this.mIndicators[i7]);
                    i7++;
                }
                this.mAdapter = new ViewPagerAdapter();
                setIndicator(0);
                this.mViewPager.setOffscreenPageLimit(3);
                this.mViewPager.setOnPageChangeListener(this);
                this.mViewPager.setAdapter(this.mAdapter);
                i4 = (i4 < 0 || i4 >= this.mViews.size()) ? 0 : 0;
                if (this.isCycle) {
                    i4++;
                }
                this.mViewPager.setCurrentItem(i4);
                setWheel(isWheel());
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.WHEEL = 100;
        this.WHEEL_WAIT = 101;
        this.mViews = new ArrayList();
        this.isScrolling = false;
        this.isCycle = true;
        this.isWheel = true;
        this.delay = 3000;
        this.mCurrentPosition = 0;
        this.releaseTime = 0L;
        this.runnable = new Runnable() { // from class: cn.bluemobi.dylan.base.view.CycleViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                if (CycleViewPager.this.mContext == null || !CycleViewPager.this.isWheel) {
                    return;
                }
                if (System.currentTimeMillis() - CycleViewPager.this.releaseTime > CycleViewPager.this.delay - 500) {
                    CycleViewPager.this.handler.sendEmptyMessage(CycleViewPager.this.WHEEL);
                } else {
                    CycleViewPager.this.handler.sendEmptyMessage(CycleViewPager.this.WHEEL_WAIT);
                }
            }
        };
        this.dotWidth = -2;
        this.dotHeight = -2;
        this.mContext = context;
        initView();
    }

    private View getImageView(Context context, String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        try {
            d.C(context).p(Integer.valueOf(Integer.parseInt(str))).j1(imageView);
        } catch (NumberFormatException unused) {
            d.C(context).a(str).j1(imageView);
        }
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
