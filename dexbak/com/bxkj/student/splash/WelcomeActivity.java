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
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class WelcomeActivity extends BaseActivity {

    /* renamed from: k */
    private iOSTwoButtonDialog f19861k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.splash.WelcomeActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC5464a implements View.OnClickListener {
        View$OnClickListenerC5464a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LoginUser.getLoginUser().setLastVersionCode(WelcomeActivity.this.m39379k0());
            WelcomeActivity.this.startActivity(new Intent(((BaseActivity) WelcomeActivity.this).f1669h, SplashActivity.class));
            WelcomeActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.splash.WelcomeActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5465b extends PagerAdapter {

        /* renamed from: a */
        final /* synthetic */ List f19863a;

        C5465b(final List val$views) {
            this.f19863a = val$views;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) this.f19863a.get(position));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f19863a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView((View) this.f19863a.get(position), 0);
            return this.f19863a.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public int m39379k0() {
        try {
            return this.f1669h.getPackageManager().getPackageInfo(this.f1669h.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_welcome;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        m39378l0();
    }

    /* renamed from: l0 */
    public void m39378l0() {
        getWindow().setBackgroundDrawableResource(C4215R.mipmap.guide1);
        ViewPager viewPager = new ViewPager(this);
        ArrayList arrayList = new ArrayList();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(C4215R.mipmap.guide1);
        arrayList.add(imageView);
        ImageView imageView2 = new ImageView(this);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setImageResource(C4215R.mipmap.guide2);
        arrayList.add(imageView2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView3 = new ImageView(this);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView3.setLayoutParams(layoutParams);
        imageView3.setImageResource(C4215R.mipmap.guide3);
        relativeLayout.addView(imageView3);
        imageView3.setOnClickListener(new View$OnClickListenerC5464a());
        arrayList.add(relativeLayout);
        viewPager.setAdapter(new C5465b(arrayList));
        setContentView(viewPager);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f19861k;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f19861k.dismiss();
        }
        super.onDestroy();
    }
}
