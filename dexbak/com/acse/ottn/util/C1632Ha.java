package com.acse.ottn.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.activity.SeedingLoadingActivity;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.p045e.C1551a;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.acse.ottn.util.Ha */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1632Ha {

    /* renamed from: a */
    private static C1632Ha f3244a;

    private C1632Ha() {
    }

    /* renamed from: b */
    public static C1632Ha m56256b() {
        if (f3244a == null) {
            synchronized (C1632Ha.class) {
                if (f3244a == null) {
                    f3244a = new C1632Ha();
                }
            }
        }
        return f3244a;
    }

    /* renamed from: a */
    public void m56258a() {
        List<WeakReference<Activity>> list = C1551a.f2896m;
        for (int size = list.size() - 1; size >= 0; size--) {
            Activity activity = list.get(size).get();
            if (activity != null) {
                activity.finish();
                list.remove(size);
            }
        }
    }

    /* renamed from: a */
    public void m56257a(Context context, AccessiblityModel accessiblityModel) {
        if (context == null) {
            return;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("mModel.getGenuine_packagename()=");
                sb.append(accessiblityModel.getGenuine_packagename());
                C1694ra.m55917a("samonp-->", sb.toString());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(accessiblityModel.getData().getSpop_deeplink()));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                C1694ra.m55917a("samonp-->", "not have error=");
                C1703va.m55903a().m55901a("open_browser_fail");
            }
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not have mModel.getGenuine_packagename()=");
            sb2.append(accessiblityModel.getGenuine_packagename());
            C1694ra.m55917a("samonp-->", sb2.toString());
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(accessiblityModel.getData().getSpop_link()));
            intent2.addCategory("android.intent.category.BROWSABLE");
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    /* renamed from: b */
    public void m56255b(Context context, AccessiblityModel accessiblityModel) {
        if (accessiblityModel == null || TextUtils.isEmpty(accessiblityModel.getData().getSpop_deeplink()) || TextUtils.isEmpty(accessiblityModel.getData().getSpop_link()) || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        C1703va m55903a = C1703va.m55903a();
        m55903a.m55901a("clickcoupon_" + accessiblityModel.getData().getPackage_name());
        if ("1".equals(accessiblityModel.getData().getTo_loading())) {
            try {
                m56258a();
                Intent intent = new Intent(context, SeedingLoadingActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("link", accessiblityModel.getData().getSpop_link());
                intent.putExtra("packagename", accessiblityModel.getData().getPackage_name());
                intent.putExtra("tkl_turn_url", accessiblityModel.getData().getTkl_turn_url());
                intent.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
                intent.putExtra("pic_type", accessiblityModel.getData().getPic_type());
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
            }
        } else if ("2".equals(accessiblityModel.getData().getTo_loading())) {
            m56258a();
            Intent intent2 = new Intent(context, ExcessActivity.class);
            intent2.putExtra("password", accessiblityModel.getData().getTkl_turn_url());
            intent2.putExtra("deeplink", accessiblityModel.getData().getSpop_deeplink());
            intent2.putExtra("link", accessiblityModel.getData().getSpop_link());
            intent2.putExtra(RtspHeaders.Values.TIME, accessiblityModel.getData().getCoupon_load_time());
            intent2.putExtra("name", accessiblityModel.getData().getPackage_name());
            intent2.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        m56257a(context, accessiblityModel);
    }
}
