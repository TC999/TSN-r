package com.bytedance.adsdk.ugeno.w;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m implements o {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a extends n {
        a(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.dislike.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class b extends n {
        b(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.ratingbar.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class c extends n {
        c(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.text.b(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class d extends n {
        d(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.progressbar.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class e extends n {
        e(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.progressbar.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class f extends n {
        f(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.image.b(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class g extends n {
        g(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.flexbox.c(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class h extends n {
        h(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.frame.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class i extends n {
        i(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.scroll.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class j extends n {
        j(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.text.a(context);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class k extends n {
        k(String str) {
            super(str);
        }

        @Override // com.bytedance.adsdk.ugeno.w.n
        public com.bytedance.adsdk.ugeno.component.b c(Context context) {
            return new com.bytedance.adsdk.ugeno.component.input.a(context);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.o
    public List<n> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c("Text"));
        arrayList.add(new f("Image"));
        arrayList.add(new g("FlexLayout"));
        arrayList.add(new h("FrameLayout"));
        arrayList.add(new i("ScrollLayout"));
        arrayList.add(new j("RichText"));
        arrayList.add(new k("Input"));
        arrayList.add(new a("Dislike"));
        arrayList.add(new b("RatingBar"));
        arrayList.add(new d("UgenProgressView"));
        arrayList.add(new e("ProgressButton"));
        return arrayList;
    }
}
