package com.acse.ottn.activity;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.acse.ottn.R;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class G extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SeedingLoadingActivity f4665a;

    G(SeedingLoadingActivity seedingLoadingActivity) {
        this.f4665a = seedingLoadingActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        ImageView d4;
        int i4;
        TextView g4;
        String str;
        ImageView d5;
        int i5;
        TextView g5;
        String str2;
        super.handleMessage(message);
        int i6 = message.what;
        if (i6 == 10010) {
            ValueAnimator valueAnimator = this.f4665a.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f4665a.p = null;
            }
            if (com.acse.ottn.util.H.a().ta.equals(SeedingLoadingActivity.b(this.f4665a))) {
                d5 = SeedingLoadingActivity.d(this.f4665a);
                i5 = R.mipmap.jd_one;
            } else {
                d5 = SeedingLoadingActivity.d(this.f4665a);
                i5 = R.mipmap.loading_one;
            }
            d5.setImageResource(i5);
            SeedingLoadingActivity.e(this.f4665a).setText("");
            if ("1".equals(SeedingLoadingActivity.f(this.f4665a))) {
                g5 = SeedingLoadingActivity.g(this.f4665a);
                str2 = "\u751f\u6210\u4e13\u5c5e\u793c\u91d1...ok";
            } else {
                g5 = SeedingLoadingActivity.g(this.f4665a);
                str2 = "\u751f\u6210\u4e13\u5c5e\u4f18\u60e0\u5238...ok";
            }
            g5.setText(str2);
            SeedingLoadingActivity.a(this.f4665a, 10011, 1000);
        } else if (i6 != 10011) {
            if (i6 == 10012) {
                ValueAnimator valueAnimator2 = this.f4665a.p;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                    this.f4665a.p = null;
                }
                SeedingLoadingActivity.j(this.f4665a);
            }
        } else {
            SeedingLoadingActivity.h(this.f4665a);
            if (com.acse.ottn.util.H.a().ta.equals(SeedingLoadingActivity.b(this.f4665a))) {
                d4 = SeedingLoadingActivity.d(this.f4665a);
                i4 = R.mipmap.jd_two;
            } else {
                d4 = SeedingLoadingActivity.d(this.f4665a);
                i4 = R.mipmap.loading_two;
            }
            d4.setImageResource(i4);
            if ("1".equals(SeedingLoadingActivity.f(this.f4665a))) {
                g4 = SeedingLoadingActivity.g(this.f4665a);
                str = "\u590d\u5236\u793c\u91d1\u53e3\u4ee4";
            } else {
                g4 = SeedingLoadingActivity.g(this.f4665a);
                str = "\u590d\u5236\u4f18\u60e0\u5238\u53e3\u4ee4";
            }
            g4.setText(str);
            SeedingLoadingActivity.e(this.f4665a).setText("...");
            SeedingLoadingActivity.a(this.f4665a, 10012, 2000);
            this.f4665a.runOnUiThread(new F(this));
        }
    }
}
