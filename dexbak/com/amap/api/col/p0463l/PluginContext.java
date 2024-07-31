package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.amap.api.col.3l.v3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PluginContext extends ContextThemeWrapper {

    /* renamed from: f */
    private static final String[] f5547f = {"android.widget", "android.webkit", MBridgeConstans.APPLICATION_STACK_ANDROID_APP};

    /* renamed from: a */
    private Resources f5548a;

    /* renamed from: b */
    private LayoutInflater f5549b;

    /* renamed from: c */
    private ClassLoader f5550c;

    /* renamed from: d */
    private C1969b f5551d;

    /* renamed from: e */
    private LayoutInflater.Factory f5552e;

    /* compiled from: PluginContext.java */
    /* renamed from: com.amap.api.col.3l.v3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class LayoutInflater$FactoryC1968a implements LayoutInflater.Factory {
        LayoutInflater$FactoryC1968a() {
        }

        @Override // android.view.LayoutInflater.Factory
        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return PluginContext.this.m53661b(str, context, attributeSet);
        }
    }

    /* compiled from: PluginContext.java */
    /* renamed from: com.amap.api.col.3l.v3$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C1969b {

        /* renamed from: a */
        public HashSet<String> f5554a = new HashSet<>();

        /* renamed from: b */
        public HashMap<String, Constructor<?>> f5555b = new HashMap<>();

        public C1969b() {
        }
    }

    public PluginContext(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.f5551d = new C1969b();
        this.f5552e = new LayoutInflater$FactoryC1968a();
        this.f5548a = ServiceUtils.m53599b();
        this.f5550c = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View m53661b(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r11 = this;
            com.amap.api.col.3l.v3$b r0 = r11.f5551d
            java.util.HashSet<java.lang.String> r0 = r0.f5554a
            boolean r0 = r0.contains(r12)
            r1 = 0
            if (r0 == 0) goto Lc
            return r1
        Lc:
            com.amap.api.col.3l.v3$b r0 = r11.f5551d
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.f5555b
            java.lang.Object r0 = r0.get(r12)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L86
            java.lang.String r5 = "api.navi"
            boolean r5 = r12.contains(r5)     // Catch: java.lang.Throwable -> L63
            if (r5 == 0) goto L2a
            java.lang.ClassLoader r5 = r11.f5550c     // Catch: java.lang.Throwable -> L63
            java.lang.Class r5 = r5.loadClass(r12)     // Catch: java.lang.Throwable -> L63
            goto L51
        L2a:
            java.lang.String[] r5 = com.amap.api.col.p0463l.PluginContext.f5547f     // Catch: java.lang.Throwable -> L63
            int r6 = r5.length     // Catch: java.lang.Throwable -> L63
            r7 = 0
        L2e:
            if (r7 >= r6) goto L50
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L63
            java.lang.ClassLoader r9 = r11.f5550c     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r10.<init>()     // Catch: java.lang.Throwable -> L4d
            r10.append(r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "."
            r10.append(r8)     // Catch: java.lang.Throwable -> L4d
            r10.append(r12)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.Class r5 = r9.loadClass(r8)     // Catch: java.lang.Throwable -> L4d
            goto L51
        L4d:
            int r7 = r7 + 1
            goto L2e
        L50:
            r5 = r1
        L51:
            if (r5 != 0) goto L54
            goto L64
        L54:
            java.lang.Class<android.view.ViewStub> r6 = android.view.ViewStub.class
            if (r5 == r6) goto L64
            java.lang.ClassLoader r6 = r5.getClassLoader()     // Catch: java.lang.Throwable -> L64
            java.lang.ClassLoader r7 = r11.f5550c     // Catch: java.lang.Throwable -> L64
            if (r6 == r7) goto L61
            goto L64
        L61:
            r6 = 1
            goto L65
        L63:
            r5 = r1
        L64:
            r6 = 0
        L65:
            if (r6 != 0) goto L6f
            com.amap.api.col.3l.v3$b r13 = r11.f5551d
            java.util.HashSet<java.lang.String> r13 = r13.f5554a
            r13.add(r12)
            return r1
        L6f:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L85
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L85
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r6[r3] = r7     // Catch: java.lang.Throwable -> L85
            java.lang.reflect.Constructor r0 = r5.getConstructor(r6)     // Catch: java.lang.Throwable -> L85
            com.amap.api.col.3l.v3$b r5 = r11.f5551d     // Catch: java.lang.Throwable -> L85
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r5 = r5.f5555b     // Catch: java.lang.Throwable -> L85
            r5.put(r12, r0)     // Catch: java.lang.Throwable -> L85
            goto L86
        L85:
        L86:
            if (r0 == 0) goto L96
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L96
            r12[r4] = r13     // Catch: java.lang.Throwable -> L96
            r12[r3] = r14     // Catch: java.lang.Throwable -> L96
            java.lang.Object r12 = r0.newInstance(r12)     // Catch: java.lang.Throwable -> L96
            android.view.View r12 = (android.view.View) r12     // Catch: java.lang.Throwable -> L96
            r1 = r12
        L96:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.PluginContext.m53661b(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.f5548a;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f5549b == null) {
                LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
                if (layoutInflater != null) {
                    this.f5549b = layoutInflater.cloneInContext(this);
                }
                this.f5549b.setFactory(this.f5552e);
                this.f5549b = this.f5549b.cloneInContext(this);
            }
            return this.f5549b;
        }
        return super.getSystemService(str);
    }
}
