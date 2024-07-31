package com.acse.ottn.activity;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1631H;

/* renamed from: com.acse.ottn.activity.G */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class HandlerC1269G extends Handler {

    /* renamed from: a */
    final /* synthetic */ SeedingLoadingActivity f2112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1269G(SeedingLoadingActivity seedingLoadingActivity) {
        this.f2112a = seedingLoadingActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        String str;
        ImageView imageView;
        int i;
        String str2;
        TextView textView;
        String str3;
        TextView textView2;
        String str4;
        ImageView imageView2;
        int i2;
        TextView textView3;
        String str5;
        TextView textView4;
        String str6;
        super.handleMessage(message);
        int i3 = message.what;
        if (i3 == 10010) {
            ValueAnimator valueAnimator = this.f2112a.f2154p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f2112a.f2154p = null;
            }
            String str7 = C1631H.m56262a().f3231ta;
            str4 = this.f2112a.f2147i;
            if (str7.equals(str4)) {
                imageView2 = this.f2112a.f2142d;
                i2 = C1239R.mipmap.jd_one;
            } else {
                imageView2 = this.f2112a.f2142d;
                i2 = C1239R.mipmap.loading_one;
            }
            imageView2.setImageResource(i2);
            textView3 = this.f2112a.f2151m;
            textView3.setText("");
            str5 = this.f2112a.f2150l;
            if ("1".equals(str5)) {
                textView4 = this.f2112a.f2143e;
                str6 = "生成专属礼金...ok";
            } else {
                textView4 = this.f2112a.f2143e;
                str6 = "生成专属优惠券...ok";
            }
            textView4.setText(str6);
            this.f2112a.m57295a(10011, 1000);
        } else if (i3 != 10011) {
            if (i3 == 10012) {
                ValueAnimator valueAnimator2 = this.f2112a.f2154p;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                    this.f2112a.f2154p = null;
                }
                this.f2112a.m57284e();
            }
        } else {
            this.f2112a.m57288c();
            String str8 = C1631H.m56262a().f3231ta;
            str = this.f2112a.f2147i;
            if (str8.equals(str)) {
                imageView = this.f2112a.f2142d;
                i = C1239R.mipmap.jd_two;
            } else {
                imageView = this.f2112a.f2142d;
                i = C1239R.mipmap.loading_two;
            }
            imageView.setImageResource(i);
            str2 = this.f2112a.f2150l;
            if ("1".equals(str2)) {
                textView = this.f2112a.f2143e;
                str3 = "复制礼金口令";
            } else {
                textView = this.f2112a.f2143e;
                str3 = "复制优惠券口令";
            }
            textView.setText(str3);
            textView2 = this.f2112a.f2151m;
            textView2.setText("...");
            this.f2112a.m57295a(10012, 2000);
            this.f2112a.runOnUiThread(new RunnableC1268F(this));
        }
    }
}
