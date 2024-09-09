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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ImagePagerActivity extends FragmentActivity {

    /* renamed from: f  reason: collision with root package name */
    private static final String f1852f = "STATE_POSITION";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1853g = "image_index";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1854h = "image_urls";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1855i = "is_show_save_button";

    /* renamed from: a  reason: collision with root package name */
    private HackyViewPager f1856a;

    /* renamed from: b  reason: collision with root package name */
    private int f1857b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1858c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f1859d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1860e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i4) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i4, float f4, int i5) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i4) {
            ImagePagerActivity.this.f1858c.setText(ImagePagerActivity.this.getString(R.string.viewpager_indicator, new Object[]{Integer.valueOf(i4 + 1), Integer.valueOf(ImagePagerActivity.this.f1856a.getAdapter().getCount())}));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f1862a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        class a implements cn.bluemobi.dylan.photoview.c {

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
            /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            class RunnableC0039a implements Runnable {
                RunnableC0039a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ImagePagerActivity.this, "\u5df2\u6210\u529f\u4fdd\u5b58\u5230\u76f8\u518c", 0).show();
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
            /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a$b  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            class RunnableC0040b implements Runnable {
                RunnableC0040b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ImagePagerActivity.this, "\u4fdd\u5b58\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                }
            }

            a() {
            }

            @Override // cn.bluemobi.dylan.photoview.c
            public void onFail() {
                ImagePagerActivity.this.runOnUiThread(new RunnableC0040b());
            }

            @Override // cn.bluemobi.dylan.photoview.c
            public void onSuccess() {
                ImagePagerActivity.this.runOnUiThread(new RunnableC0039a());
            }
        }

        b(String[] strArr) {
            this.f1862a = strArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePagerActivity imagePagerActivity = ImagePagerActivity.this;
            new Thread(new cn.bluemobi.dylan.photoview.b(imagePagerActivity, this.f1862a[imagePagerActivity.f1856a.getCurrentItem()], new a())).start();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private class c extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public String[] f1867a;

        public c(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f1867a = strArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            String[] strArr = this.f1867a;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i4) {
            return ImageDetailFragment.e(this.f1867a[i4]);
        }
    }

    static {
        StubApp.interface11(3643);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("STATE_POSITION", this.f1856a.getCurrentItem());
    }
}
