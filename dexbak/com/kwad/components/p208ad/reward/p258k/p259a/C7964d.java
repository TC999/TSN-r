package com.kwad.components.p208ad.reward.p258k.p259a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p289e.p294e.C8642g;
import com.kwad.components.core.p298i.C8674c;
import com.kwad.components.core.p298i.C8676e;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9182w;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p250c.C7867e;
import com.kwad.components.p208ad.reward.p258k.C7984l;
import com.kwad.components.p208ad.reward.p258k.C7985m;
import com.kwad.components.p208ad.reward.p258k.C7987n;
import com.kwad.components.p208ad.reward.p258k.C7989o;
import com.kwad.components.p208ad.reward.p258k.C7990p;
import com.kwad.components.p208ad.reward.p258k.C7992q;
import com.kwad.components.p208ad.reward.p258k.C7994s;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7993r;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.k.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7964d extends C9305i implements InterfaceC7993r, C9182w.InterfaceC9184b {
    @Nullable
    private C8619c mApkDownloadHelper;

    /* renamed from: qh */
    private WeakReference<C7907g> f26675qh;

    /* renamed from: xA */
    private List<AdTemplate> f26676xA;
    @Nullable

    /* renamed from: xB */
    private DialogInterface.OnDismissListener f26677xB;

    /* renamed from: xw */
    private C7867e f26678xw;

    /* renamed from: xx */
    private C7985m f26679xx;

    /* renamed from: xy */
    private C7984l f26680xy;

    /* renamed from: xz */
    private C7987n f26681xz;

    public C7964d(@NonNull C7907g c7907g, long j, Context context) {
        super(j, context);
        this.f26676xA = null;
        this.f26675qh = new WeakReference<>(c7907g);
    }

    @Override // com.kwad.components.core.webview.jshandler.C9182w.InterfaceC9184b
    /* renamed from: N */
    public final void mo29210N(AdTemplate adTemplate) {
        C8674c c8674c = new C8674c(adTemplate, C8676e.AGGREGATION);
        WeakReference<C7907g> weakReference = this.f26675qh;
        C7907g c7907g = weakReference != null ? weakReference.get() : null;
        if (c7907g != null) {
            c7907g.m32025b(c8674c);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.C9305i
    /* renamed from: a */
    public final void mo29075a(@Nullable Activity activity, AdResultData adResultData, InterfaceC9339j interfaceC9339j) {
        super.mo29075a(activity, adResultData, interfaceC9339j);
        WeakReference<C7907g> weakReference = this.f26675qh;
        C7907g c7907g = weakReference != null ? weakReference.get() : null;
        if (c7907g != null) {
            c7907g.m32044a(this);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p258k.InterfaceC7993r
    /* renamed from: aa */
    public final void mo31900aa(boolean z) {
        C7987n c7987n = this.f26681xz;
        if (c7987n != null) {
            c7987n.m31904Z(z);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.C9305i
    /* renamed from: c */
    public final C9072ak mo29040c(C10605b c10605b) {
        WeakReference<C7907g> weakReference = this.f26675qh;
        return new C7990p(weakReference != null ? weakReference.get() : null, getTkTemplateId(), this.f29395xs, c10605b);
    }

    @Override // com.kwad.components.core.webview.tachikoma.C9305i, com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public final void dismiss() {
        WeakReference<C7907g> weakReference = this.f26675qh;
        if (weakReference != null) {
            weakReference.get().m32066D(false);
        }
        super.dismiss();
    }

    /* renamed from: gn */
    public final BackPressHandleResult m31915gn() {
        C7985m c7985m = this.f26679xx;
        if (c7985m == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        c7985m.m31905jg();
        return BackPressHandleResult.HANDLED;
    }

    /* renamed from: h */
    public final void m31914h(List<AdTemplate> list) {
        this.f26676xA = list;
    }

    /* renamed from: jn */
    public final C7867e m31913jn() {
        return this.f26678xw;
    }

    /* renamed from: jo */
    public final C7984l m31912jo() {
        return this.f26680xy;
    }

    @Override // com.kwad.components.core.webview.tachikoma.C9305i
    /* renamed from: jp */
    public final void mo29029jp() {
        super.mo29029jp();
        WeakReference<C7907g> weakReference = this.f26675qh;
        C7907g c7907g = weakReference != null ? weakReference.get() : null;
        if (c7907g != null) {
            c7907g.m32028b(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.C9305i, com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public final void show() {
        super.show();
        WeakReference<C7907g> weakReference = this.f26675qh;
        if (weakReference != null) {
            weakReference.get().m32066D(true);
        }
    }

    public C7964d(C7907g c7907g, long j, Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.f26676xA = null;
        this.f26677xB = onDismissListener;
        this.f26675qh = new WeakReference<>(c7907g);
    }

    @Override // com.kwad.components.core.webview.tachikoma.C9305i
    /* renamed from: a */
    public final void mo29056a(C10605b c10605b, C8619c c8619c, InterfaceC9876q interfaceC9876q, ViewGroup viewGroup) {
        super.mo29056a(c10605b, c8619c, interfaceC9876q, viewGroup);
        this.mApkDownloadHelper = c8619c;
        WeakReference<C7907g> weakReference = this.f26675qh;
        InterfaceC10625a c7992q = new C7992q(c10605b, c8619c, weakReference != null ? weakReference.get() : null, this.f29395xs, this, this.f26677xB);
        C8642g.m30090or().m30092a(this);
        interfaceC9876q.mo27480c(c7992q);
        C7867e c7867e = new C7867e();
        this.f26678xw = c7867e;
        interfaceC9876q.mo27480c(c7867e);
        Context context = this.mContext;
        WeakReference<C7907g> weakReference2 = this.f26675qh;
        interfaceC9876q.mo27480c(new C7994s(context, weakReference2 != null ? weakReference2.get() : null));
        WeakReference<C7907g> weakReference3 = this.f26675qh;
        interfaceC9876q.mo27480c(new C7989o(weakReference3 != null ? weakReference3.get() : null));
        C7985m c7985m = new C7985m();
        this.f26679xx = c7985m;
        interfaceC9876q.mo27480c(c7985m);
        C7984l c7984l = new C7984l();
        this.f26680xy = c7984l;
        interfaceC9876q.mo27480c(c7984l);
        List<AdTemplate> list = this.f26676xA;
        if (list != null) {
            this.f26680xy.m31906g(list);
            this.f26676xA = null;
        }
        C9182w c9182w = new C9182w(c10605b);
        c9182w.m29212a(this);
        interfaceC9876q.mo27480c(c9182w);
        C7987n c7987n = new C7987n();
        this.f26681xz = c7987n;
        interfaceC9876q.mo27480c(c7987n);
    }
}
