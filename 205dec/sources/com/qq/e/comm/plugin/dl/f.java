package com.qq.e.comm.plugin.dl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.jpush.android.local.JPushConstants;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.dl.b;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f implements com.qq.e.dl.b {
    private void b(String str, b.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith(JPushConstants.HTTP_PRE) && !str.startsWith(JPushConstants.HTTPS_PRE)) {
            Bitmap a4 = m1.a(str);
            if (a4 != null) {
                aVar.a(null, a4);
                return;
            }
            return;
        }
        com.qq.e.comm.plugin.b0.b.a().a(str, (ImageView) null, new a(aVar));
    }

    @Override // com.qq.e.dl.b
    public void a(Object obj, b.a aVar) {
        if (obj instanceof String) {
            b((String) obj, aVar);
        } else if (obj instanceof File) {
            com.qq.e.comm.plugin.b0.b.a().a((File) obj, (ImageView) null, new a(aVar));
        } else {
            aVar.a(null, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        private final b.a f42432a;

        a(b.a aVar) {
            this.f42432a = aVar;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
            b.a aVar = this.f42432a;
            if (aVar == null) {
                return;
            }
            aVar.a(str, i4, exc);
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            Object b4;
            if (this.f42432a == null) {
                return;
            }
            int f4 = fVar.f();
            if (f4 == 1) {
                b4 = fVar.b();
            } else if (f4 == 2) {
                b4 = fVar.e();
            } else if (f4 != 3) {
                b4 = fVar.d();
            } else {
                b4 = fVar.c();
            }
            if (b4 == null) {
                return;
            }
            this.f42432a.a(fVar.d(), b4);
        }
    }

    @Override // com.qq.e.dl.b
    public void a(String str, b.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) {
            com.qq.e.comm.plugin.b0.b.a().b(str, new a(aVar));
        }
    }
}
