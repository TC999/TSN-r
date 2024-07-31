package cn.bluemobi.dylan.photoview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ImagePagerActivity extends FragmentActivity {

    /* renamed from: f */
    private static final String f1867f = "STATE_POSITION";

    /* renamed from: g */
    public static final String f1868g = "image_index";

    /* renamed from: h */
    public static final String f1869h = "image_urls";

    /* renamed from: i */
    public static final String f1870i = "is_show_save_button";

    /* renamed from: a */
    private HackyViewPager f1871a;

    /* renamed from: b */
    private int f1872b;

    /* renamed from: c */
    private TextView f1873c;

    /* renamed from: d */
    private ImageView f1874d;

    /* renamed from: e */
    private boolean f1875e;

    /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1191a implements ViewPager.OnPageChangeListener {
        C1191a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ImagePagerActivity.this.f1873c.setText(ImagePagerActivity.this.getString(C1197R.C1202string.viewpager_indicator, new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePagerActivity.this.f1871a.getAdapter().getCount())}));
        }
    }

    /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class View$OnClickListenerC1192b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String[] f1877a;

        /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class C1193a implements ImageCallBack {

            /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a$a */
            /* loaded from: E:\fuckcool\tsn\6276784.dex */
            class RunnableC1194a implements Runnable {
                RunnableC1194a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ImagePagerActivity.this, "已成功保存到相册", 0).show();
                }
            }

            /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a$b */
            /* loaded from: E:\fuckcool\tsn\6276784.dex */
            class RunnableC1195b implements Runnable {
                RunnableC1195b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ImagePagerActivity.this, "保存失败，请稍后再试", 0).show();
                }
            }

            C1193a() {
            }

            @Override // cn.bluemobi.dylan.photoview.ImageCallBack
            public void onFail() {
                ImagePagerActivity.this.runOnUiThread(new RunnableC1195b());
            }

            @Override // cn.bluemobi.dylan.photoview.ImageCallBack
            public void onSuccess() {
                ImagePagerActivity.this.runOnUiThread(new RunnableC1194a());
            }
        }

        View$OnClickListenerC1192b(String[] strArr) {
            this.f1877a = strArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePagerActivity imagePagerActivity = ImagePagerActivity.this;
            new Thread(new DownLoadImageService(imagePagerActivity, this.f1877a[imagePagerActivity.f1871a.getCurrentItem()], new C1193a())).start();
        }
    }

    /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1196c extends FragmentStatePagerAdapter {

        /* renamed from: a */
        public String[] f1882a;

        public C1196c(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f1882a = strArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            String[] strArr = this.f1882a;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return ImageDetailFragment.m57565e(this.f1882a[i]);
        }
    }

    static {
        StubApp.interface11(4035);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(f1867f, this.f1871a.getCurrentItem());
    }
}
