package com.qq.e.dl.j;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.qq.e.comm.plugin.b0.a;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f47002a;

        a(ImageView imageView) {
            this.f47002a = imageView;
        }

        @Override // com.qq.e.comm.plugin.b0.a.c
        public void a(com.qq.e.comm.plugin.b0.f fVar) {
            this.f47002a.setImageBitmap(fVar.b());
        }
    }

    public static void a(Object obj, ImageView imageView, Bitmap bitmap, int i4, JSONArray jSONArray) {
        if (bitmap == null || i4 == 0 || jSONArray == null || i4 != 1) {
            return;
        }
        a(obj, bitmap, imageView, jSONArray);
    }

    private static void a(Object obj, Bitmap bitmap, ImageView imageView, JSONArray jSONArray) {
        float optDouble = (float) jSONArray.optDouble(0);
        if (optDouble <= 0.0f) {
            return;
        }
        if (optDouble > 25.0f) {
            optDouble = 25.0f;
        }
        com.qq.e.comm.plugin.b0.a.a(obj, bitmap, optDouble, new a(imageView));
    }
}
