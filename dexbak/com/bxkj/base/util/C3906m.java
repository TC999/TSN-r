package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.C3801R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageUtils.java */
/* renamed from: com.bxkj.base.util.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3906m {
    /* renamed from: a */
    public static void m44069a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        m44067c(context, arrayList, 0);
    }

    /* renamed from: b */
    public static void m44068b(Context context, List<String> list) {
        m44067c(context, list, 0);
    }

    /* renamed from: c */
    public static void m44067c(Context context, List<String> list, int i) {
        Intent intent = new Intent(context, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1870i, true);
        intent.putExtra(ImagePagerActivity.f1869h, (String[]) list.toArray(new String[list.size()]));
        intent.putExtra(ImagePagerActivity.f1868g, i);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(C3801R.anim.zoom_ente, C3801R.anim.zoom_exit);
        }
    }
}
