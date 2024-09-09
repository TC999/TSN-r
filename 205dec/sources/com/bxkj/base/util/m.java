package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.R;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ImageUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class m {
    public static void a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        c(context, arrayList, 0);
    }

    public static void b(Context context, List<String> list) {
        c(context, list, 0);
    }

    public static void c(Context context, List<String> list, int i4) {
        Intent intent = new Intent(context, ImagePagerActivity.class);
        intent.putExtra("is_show_save_button", true);
        intent.putExtra("image_urls", (String[]) list.toArray(new String[list.size()]));
        intent.putExtra("image_index", i4);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.zoom_ente, R.anim.zoom_exit);
        }
    }
}
