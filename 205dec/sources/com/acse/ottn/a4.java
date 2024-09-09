package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.activity.SeedingLoadingActivity;
import com.acse.ottn.model.AccessiblityModel;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a4 {

    /* renamed from: a  reason: collision with root package name */
    public static a4 f4587a;

    public static a4 b() {
        if (f4587a == null) {
            synchronized (a4.class) {
                if (f4587a == null) {
                    f4587a = new a4();
                }
            }
        }
        return f4587a;
    }

    public void a(Context context, AccessiblityModel accessiblityModel) {
        if (context == null) {
            return;
        }
        try {
            try {
                z1.a("samonp-->", "mModel.getGenuine_packagename()=" + accessiblityModel.getGenuine_packagename());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(accessiblityModel.getData().getSpop_deeplink()));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                z1.a("samonp-->", "not have error=");
                i2.a().a("open_browser_fail");
            }
        } catch (Exception unused2) {
            z1.a("samonp-->", "not have mModel.getGenuine_packagename()=" + accessiblityModel.getGenuine_packagename());
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(accessiblityModel.getData().getSpop_link()));
            intent2.addCategory("android.intent.category.BROWSABLE");
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public void b(Context context, AccessiblityModel accessiblityModel) {
        if (accessiblityModel == null || TextUtils.isEmpty(accessiblityModel.getData().getSpop_deeplink()) || TextUtils.isEmpty(accessiblityModel.getData().getSpop_link()) || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        i2 a4 = i2.a();
        a4.a("clickcoupon_" + accessiblityModel.getData().getPackage_name());
        if ("1".equals(accessiblityModel.getData().getTo_loading())) {
            try {
                a();
                Intent intent = new Intent(context, SeedingLoadingActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("link", accessiblityModel.getData().getSpop_link());
                intent.putExtra("packagename", accessiblityModel.getData().getPackage_name());
                intent.putExtra("tkl_turn_url", accessiblityModel.getData().getTkl_turn_url());
                intent.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
                intent.putExtra("pic_type", accessiblityModel.getData().getPic_type());
                context.startActivity(intent);
            } catch (Exception unused) {
                a(context, accessiblityModel);
            }
        } else if ("2".equals(accessiblityModel.getData().getTo_loading())) {
            a();
            Intent intent2 = new Intent(context, ExcessActivity.class);
            intent2.putExtra("password", accessiblityModel.getData().getTkl_turn_url());
            intent2.putExtra("deeplink", accessiblityModel.getData().getSpop_deeplink());
            intent2.putExtra("link", accessiblityModel.getData().getSpop_link());
            intent2.putExtra("time", accessiblityModel.getData().getCoupon_load_time());
            intent2.putExtra("name", accessiblityModel.getData().getPackage_name());
            intent2.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } else {
            a(context, accessiblityModel);
        }
    }

    public void a() {
        List<WeakReference<Activity>> list = o.f6075m;
        for (int size = list.size() - 1; size >= 0; size--) {
            Activity activity = list.get(size).get();
            if (activity != null) {
                activity.finish();
                list.remove(size);
            }
        }
    }
}
