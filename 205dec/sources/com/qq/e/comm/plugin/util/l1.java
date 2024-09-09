package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f46505a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicLong f46506b = new AtomicLong(60000);

    /* renamed from: c  reason: collision with root package name */
    private static Pair<Integer, Integer> f46507c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f46508c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f46509d;

        a(WeakReference weakReference, com.qq.e.comm.plugin.g0.e eVar) {
            this.f46508c = weakReference;
            this.f46509d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = (View) this.f46508c.get();
            if (view == null) {
                return;
            }
            if (l1.f46507c == null) {
                Pair unused = l1.f46507c = y.b();
            }
            com.qq.e.comm.plugin.n0.v.a(1402003, com.qq.e.comm.plugin.n0.c.a(this.f46509d), null, null, new com.qq.e.comm.plugin.n0.d().a("w", Integer.valueOf(view.getWidth())).a("h", Integer.valueOf(view.getHeight())).a("dh", l1.f46507c.first).a("dw", l1.f46507c.second));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46510c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f46511d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ WeakReference f46512e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f46513f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ WeakReference f46514g;

        b(String str, com.qq.e.comm.plugin.g0.e eVar, WeakReference weakReference, String str2, WeakReference weakReference2) {
            this.f46510c = str;
            this.f46511d = eVar;
            this.f46512e = weakReference;
            this.f46513f = str2;
            this.f46514g = weakReference2;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r9 = this;
                java.lang.String r0 = ""
                r1 = 60
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L42
                java.lang.String r3 = r9.f46510c     // Catch: org.json.JSONException -> L42
                r2.<init>(r3)     // Catch: org.json.JSONException -> L42
                java.lang.String r3 = "quality"
                int r3 = r2.optInt(r3)     // Catch: org.json.JSONException -> L42
                java.lang.String r4 = "task_id"
                java.lang.String r4 = r2.optString(r4)     // Catch: org.json.JSONException -> L43
                java.lang.String r5 = "tid"
                java.lang.String r0 = r2.optString(r5)     // Catch: org.json.JSONException -> L3f
                java.lang.String r5 = "cover_limit"
                int r5 = r2.optInt(r5, r1)     // Catch: org.json.JSONException -> L3f
                java.util.concurrent.atomic.AtomicLong r6 = com.qq.e.comm.plugin.util.l1.b()     // Catch: org.json.JSONException -> L3c
                java.lang.String r7 = "period"
                r8 = 1
                int r2 = r2.optInt(r7, r8)     // Catch: org.json.JSONException -> L3c
                int r2 = r2 * 60
                long r1 = (long) r2     // Catch: org.json.JSONException -> L3c
                r7 = 1000(0x3e8, double:4.94E-321)
                long r1 = r1 * r7
                r6.set(r1)     // Catch: org.json.JSONException -> L3c
                r6 = r5
                r5 = r4
                r4 = r3
                goto L4a
            L3c:
                r1 = r0
                r0 = r4
                goto L46
            L3f:
                r1 = r0
                r0 = r4
                goto L44
            L42:
                r3 = 0
            L43:
                r1 = r0
            L44:
                r5 = 60
            L46:
                r4 = r3
                r6 = r5
                r5 = r0
                r0 = r1
            L4a:
                if (r4 > 0) goto L4d
                return
            L4d:
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L60
                com.qq.e.comm.plugin.g0.e r1 = r9.f46511d
                java.lang.String r1 = r1.G0()
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L60
                return
            L60:
                java.lang.ref.WeakReference r1 = r9.f46512e
                com.qq.e.comm.plugin.g0.e r2 = r9.f46511d
                java.lang.String r3 = r9.f46513f
                java.lang.ref.WeakReference r7 = r9.f46514g
                com.qq.e.comm.plugin.util.l1.a(r1, r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.l1.b.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f46515c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WeakReference f46516d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f46517e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f46518f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f46519g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f46520h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f46521i;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bitmap f46522c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Boolean f46523d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ JSONObject f46524e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Integer f46525f;

            a(Bitmap bitmap, Boolean bool, JSONObject jSONObject, Integer num) {
                this.f46522c = bitmap;
                this.f46523d = bool;
                this.f46524e = jSONObject;
                this.f46525f = num;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap = this.f46522c;
                c cVar = c.this;
                l1.b(bitmap, cVar.f46518f, cVar.f46519g, cVar.f46520h, this.f46523d, this.f46524e, cVar.f46521i, this.f46525f.intValue());
            }
        }

        c(WeakReference weakReference, WeakReference weakReference2, int i4, int i5, com.qq.e.comm.plugin.g0.e eVar, String str, String str2) {
            this.f46515c = weakReference;
            this.f46516d = weakReference2;
            this.f46517e = i4;
            this.f46518f = i5;
            this.f46519g = eVar;
            this.f46520h = str;
            this.f46521i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            Bitmap b4;
            JSONObject jSONObject;
            Boolean bool;
            Window window;
            WeakReference weakReference = this.f46515c;
            if (weakReference == null || (view = (View) weakReference.get()) == null || (b4 = l1.b(view)) == null) {
                return;
            }
            View view2 = (View) this.f46516d.get();
            Integer num = (Integer) o2.a(view, this.f46517e).second;
            try {
                jSONObject = l1.b(view, l1.b(view, view2), view2);
            } catch (Throwable unused) {
                jSONObject = null;
            }
            Activity a4 = k.a(view);
            if (a4 == null || (window = a4.getWindow()) == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf((window.getAttributes().flags & 8192) != 0);
            }
            d0.f46406b.submit(new a(b4, bool, jSONObject, num));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d extends com.qq.e.comm.plugin.i0.j {
        d() {
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
            com.qq.e.comm.plugin.n0.v.b(9700002, null, Integer.valueOf(i4));
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap b(View view) {
        return (Bitmap) pro.getobjresult(303, 1, view);
    }

    private static JSONObject c(View view, JSONArray jSONArray, View view2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            jSONObject.put("name", view);
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("x", view.getX());
            jSONObject.put("y", view.getY());
            jSONObject.put("visible", view.getVisibility());
            if (view2 != null && view2 == view) {
                jSONObject.put("clicked", true);
            }
        } else {
            jSONObject.put("name", "nullView");
        }
        jSONObject.put("children", jSONArray);
        return jSONObject;
    }

    public static void b(View view, com.qq.e.comm.plugin.g0.e eVar, int i4) {
        a(view, eVar, i4);
        String a4 = a("radss", eVar);
        if (TextUtils.isEmpty(a4)) {
            return;
        }
        a(view, eVar, i4, a4, null, null);
    }

    public static void a(View view, com.qq.e.comm.plugin.g0.e eVar) {
        b(view, eVar, 2);
    }

    private static void a(View view, com.qq.e.comm.plugin.g0.e eVar, int i4) {
        com.qq.e.comm.plugin.b.g o4 = eVar.o();
        if ((o4.f() || o4.i()) && com.qq.e.comm.plugin.d0.a.d().f().a("resion", eVar.q0(), 0) == 1) {
            view.postDelayed(new a(new WeakReference(view), eVar), i4 * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(WeakReference<View> weakReference, com.qq.e.comm.plugin.g0.e eVar, String str, int i4, String str2, int i5, WeakReference<View> weakReference2) {
        p0.c(new c(weakReference, weakReference2, i5, i4, eVar, str2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray b(View view, View view2) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt instanceof ViewGroup) {
                    jSONArray.put(c(childAt, b(childAt, view2), view2));
                } else {
                    jSONArray.put(c(childAt, null, view2));
                }
            }
        }
        return jSONArray;
    }

    public static void a(View view, com.qq.e.comm.plugin.g0.e eVar, String str) {
        a(view, eVar, str, null);
    }

    public static void a(View view, com.qq.e.comm.plugin.g0.e eVar, String str, View view2) {
        String a4 = a("radssc", eVar);
        if (TextUtils.isEmpty(a4)) {
            return;
        }
        a(view, eVar, 0, a4, str, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject b(View view, JSONArray jSONArray, View view2) throws Throwable {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            JSONArray jSONArray2 = new JSONArray();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                jSONArray2.put(c(childAt, childAt == view ? jSONArray : null, view2));
            }
            return b(viewGroup, jSONArray2, view2);
        }
        return c(view, jSONArray, view2);
    }

    private static String a(String str, com.qq.e.comm.plugin.g0.e eVar) {
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c(com.qq.e.comm.plugin.d0.d.h.a(str, eVar.o()), eVar.q0());
        return TextUtils.isEmpty(c4) ? com.qq.e.comm.plugin.d0.a.d().f().c(str, eVar.q0()) : c4;
    }

    private static void a(View view, com.qq.e.comm.plugin.g0.e eVar, int i4, String str, String str2, View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f46505a.get() < f46506b.get()) {
            return;
        }
        f46505a.set(currentTimeMillis);
        d0.f46410f.schedule(new b(str, eVar, new WeakReference(view), str2, new WeakReference(view2)), i4, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(31:37|38|39|40|41|42|43|44|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:20|21)|22|23|24|25|(3:27|(1:29)(1:34)|30)(1:35)|31|32)|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(0)|22|23|24|25|(0)(0)|31|32) */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da A[Catch: JSONException -> 0x00eb, TRY_ENTER, TryCatch #2 {JSONException -> 0x00eb, blocks: (B:13:0x0072, B:15:0x0077, B:17:0x0080, B:19:0x0089, B:21:0x009c, B:23:0x00a3, B:25:0x00aa, B:28:0x00bc, B:29:0x00c3, B:31:0x00d3, B:34:0x00da, B:38:0x00e3, B:39:0x00e7), top: B:49:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7 A[Catch: JSONException -> 0x00eb, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00eb, blocks: (B:13:0x0072, B:15:0x0077, B:17:0x0080, B:19:0x0089, B:21:0x009c, B:23:0x00a3, B:25:0x00aa, B:28:0x00bc, B:29:0x00c3, B:31:0x00d3, B:34:0x00da, B:38:0x00e3, B:39:0x00e7), top: B:49:0x0072 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.graphics.Bitmap r17, int r18, com.qq.e.comm.plugin.g0.e r19, java.lang.String r20, java.lang.Boolean r21, org.json.JSONObject r22, java.lang.String r23, int r24) {
        /*
            r0 = r20
            java.lang.String r1 = "sld"
            java.lang.String r2 = "db"
            java.lang.String r3 = "da"
            java.lang.String r4 = "bb"
            java.lang.String r5 = "ba"
            java.lang.String r6 = "ab"
            java.lang.String r7 = "aa"
            java.lang.String r8 = "task_id"
            r9 = r17
            r10 = r18
            java.lang.String r9 = a(r10, r9)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            boolean r11 = android.text.TextUtils.isEmpty(r23)
            r12 = 1
            r11 = r11 ^ r12
            if (r11 == 0) goto L67
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L67
            r14 = r23
            r13.<init>(r14)     // Catch: java.lang.Throwable -> L67
            java.lang.String r14 = r13.optString(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.String r15 = r13.optString(r6)     // Catch: java.lang.Throwable -> L67
            java.lang.String r12 = r13.optString(r5)     // Catch: java.lang.Throwable -> L67
            r18 = r11
            java.lang.String r11 = r13.optString(r4)     // Catch: java.lang.Throwable -> L64
            r16 = r9
            java.lang.String r9 = r13.optString(r3)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = r13.optString(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r13 = r13.optString(r1)     // Catch: java.lang.Throwable -> L6b
            r10.put(r7, r14)     // Catch: java.lang.Throwable -> L6b
            r10.put(r6, r15)     // Catch: java.lang.Throwable -> L6b
            r10.put(r5, r12)     // Catch: java.lang.Throwable -> L6b
            r10.put(r4, r11)     // Catch: java.lang.Throwable -> L6b
            r10.put(r3, r9)     // Catch: java.lang.Throwable -> L6b
            r10.put(r2, r0)     // Catch: java.lang.Throwable -> L6b
            r10.put(r1, r13)     // Catch: java.lang.Throwable -> L6b
            goto L6b
        L64:
            r16 = r9
            goto L6b
        L67:
            r16 = r9
            r18 = r11
        L6b:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = r20
            r0.put(r8, r1)     // Catch: org.json.JSONException -> Leb
            java.lang.String r2 = "render_type"
            int r3 = r19.u0()     // Catch: org.json.JSONException -> Leb
            r0.put(r2, r3)     // Catch: org.json.JSONException -> Leb
            java.lang.String r2 = "aid"
            java.lang.String r3 = r19.k()     // Catch: org.json.JSONException -> Leb
            r0.put(r2, r3)     // Catch: org.json.JSONException -> Leb
            java.lang.String r2 = "tid"
            java.lang.String r3 = r19.G0()     // Catch: org.json.JSONException -> Leb
            r0.put(r2, r3)     // Catch: org.json.JSONException -> Leb
            r0.put(r8, r1)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "ad_view"
            r2 = r16
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "ov"
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch: org.json.JSONException -> Leb
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "mn"
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch: org.json.JSONException -> Leb
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "is_video"
            boolean r2 = r19.l1()     // Catch: org.json.JSONException -> Leb
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "os"
            java.lang.String r2 = "android"
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            if (r22 == 0) goto Lc3
            java.lang.String r1 = "hierarchy"
            java.lang.String r2 = r22.toString()     // Catch: org.json.JSONException -> Leb
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
        Lc3:
            java.lang.String r1 = "view"
            r0.put(r1, r10)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "covered_ratio"
            r2 = r24
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "stage"
            r2 = r18
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
            java.lang.String r1 = "secure"
            if (r21 == 0) goto Le7
            boolean r2 = r21.booleanValue()     // Catch: org.json.JSONException -> Leb
            if (r2 == 0) goto Le2
            r12 = 1
            goto Le3
        Le2:
            r12 = 2
        Le3:
            r0.put(r1, r12)     // Catch: org.json.JSONException -> Leb
            goto Leb
        Le7:
            r2 = 0
            r0.put(r1, r2)     // Catch: org.json.JSONException -> Leb
        Leb:
            r1 = r19
            a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.l1.b(android.graphics.Bitmap, int, com.qq.e.comm.plugin.g0.e, java.lang.String, java.lang.Boolean, org.json.JSONObject, java.lang.String, int):void");
    }

    private static String a(int i4, Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, i4, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    private static void a(JSONObject jSONObject, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.l0.g.a(1011, jSONObject, new com.qq.e.comm.plugin.b.m(eVar.q0(), eVar.o(), (com.qq.e.comm.plugin.b.f) null), new d());
    }
}
