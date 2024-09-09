package com.bxkj.student.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class WelcomeActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private iOSTwoButtonDialog f23091k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            LoginUser.getLoginUser().setLastVersionCode(WelcomeActivity.this.k0());
            WelcomeActivity.this.startActivity(new Intent(((BaseActivity) WelcomeActivity.this).f1656h, SplashActivity.class));
            WelcomeActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f23093a;

        b(final List val$views) {
            this.f23093a = val$views;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) this.f23093a.get(position));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f23093a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView((View) this.f23093a.get(position), 0);
            return this.f23093a.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k0() {
        try {
            return this.f1656h.getPackageManager().getPackageInfo(this.f1656h.getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427523;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        l0();
    }

    public void l0() {
        getWindow().setBackgroundDrawableResource(2131558585);
        ViewPager viewPager = new ViewPager(this);
        ArrayList arrayList = new ArrayList();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(2131558585);
        arrayList.add(imageView);
        ImageView imageView2 = new ImageView(this);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setImageResource(2131558586);
        arrayList.add(imageView2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView3 = new ImageView(this);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView3.setLayoutParams(layoutParams);
        imageView3.setImageResource(2131558587);
        relativeLayout.addView(imageView3);
        imageView3.setOnClickListener(new a());
        arrayList.add(relativeLayout);
        viewPager.setAdapter(new b(arrayList));
        setContentView(viewPager);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f23091k;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f23091k.dismiss();
        }
        super.onDestroy();
    }
}
