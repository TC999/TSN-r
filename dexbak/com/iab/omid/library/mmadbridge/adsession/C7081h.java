package com.iab.omid.library.mmadbridge.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.p202b.C7085a;
import com.iab.omid.library.mmadbridge.p202b.C7088c;
import com.iab.omid.library.mmadbridge.p202b.C7092f;
import com.iab.omid.library.mmadbridge.p204d.C7105e;
import com.iab.omid.library.mmadbridge.publisher.AbstractC7108a;
import com.iab.omid.library.mmadbridge.publisher.C7110b;
import com.iab.omid.library.mmadbridge.publisher.C7111c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;
import p626o0.C15395a;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7081h extends AbstractC7075b {

    /* renamed from: l */
    private static final Pattern f24209l = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a */
    private final C7077d f24210a;

    /* renamed from: b */
    private final C7076c f24211b;

    /* renamed from: d */
    private C15395a f24213d;

    /* renamed from: e */
    private AbstractC7108a f24214e;

    /* renamed from: i */
    private boolean f24218i;

    /* renamed from: j */
    private boolean f24219j;

    /* renamed from: k */
    private InterfaceC7079f f24220k;

    /* renamed from: c */
    private final List<C7088c> f24212c = new ArrayList();

    /* renamed from: f */
    private boolean f24215f = false;

    /* renamed from: g */
    private boolean f24216g = false;

    /* renamed from: h */
    private final String f24217h = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7081h(C7076c c7076c, C7077d c7077d) {
        this.f24211b = c7076c;
        this.f24210a = c7077d;
        m34788t(null);
        this.f24214e = (c7077d.m34827d() == AdSessionContextType.HTML || c7077d.m34827d() == AdSessionContextType.JAVASCRIPT) ? new C7110b(c7077d.m34820k()) : new C7111c(c7077d.m34824g(), c7077d.m34823h());
        this.f24214e.mo34629a();
        C7085a.m34757a().m34756b(this);
        this.f24214e.m34647e(c7076c);
    }

    /* renamed from: C */
    private void m34808C() {
        if (this.f24218i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: D */
    private void m34807D() {
        if (this.f24219j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    /* renamed from: l */
    private C7088c m34796l(View view) {
        for (C7088c c7088c : this.f24212c) {
            if (c7088c.m34742a().get() == view) {
                return c7088c;
            }
        }
        return null;
    }

    /* renamed from: n */
    private void m34794n(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f24209l.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    /* renamed from: q */
    private static void m34791q(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: t */
    private void m34788t(View view) {
        this.f24213d = new C15395a(view);
    }

    /* renamed from: v */
    private void m34786v(View view) {
        Collection<C7081h> m34755c = C7085a.m34757a().m34755c();
        if (m34755c == null || m34755c.isEmpty()) {
            return;
        }
        for (C7081h c7081h : m34755c) {
            if (c7081h != this && c7081h.m34785w() == view) {
                c7081h.f24213d.clear();
            }
        }
    }

    /* renamed from: A */
    public boolean m34810A() {
        return this.f24211b.m34833b();
    }

    /* renamed from: B */
    public boolean m34809B() {
        return this.f24211b.m34832c();
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: a */
    public void mo34806a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f24216g) {
            return;
        }
        m34791q(view);
        m34794n(str);
        if (m34796l(view) == null) {
            this.f24212c.add(new C7088c(view, friendlyObstructionPurpose, str));
        }
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: c */
    public void mo34805c(ErrorType errorType, String str) {
        if (this.f24216g) {
            throw new IllegalStateException("AdSession is finished");
        }
        C7105e.m34671d(errorType, "Error type is null");
        C7105e.m34669f(str, "Message is null");
        mo34802f().m34646f(errorType, str);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: d */
    public void mo34804d() {
        if (this.f24216g) {
            return;
        }
        this.f24213d.clear();
        mo34800h();
        this.f24216g = true;
        mo34802f().m34634t();
        C7085a.m34757a().m34752f(this);
        mo34802f().mo34627o();
        this.f24214e = null;
        this.f24220k = null;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: e */
    public String mo34803e() {
        return this.f24217h;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: f */
    public AbstractC7108a mo34802f() {
        return this.f24214e;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: g */
    public void mo34801g(View view) {
        if (this.f24216g) {
            return;
        }
        C7105e.m34671d(view, "AdView is null");
        if (m34785w() == view) {
            return;
        }
        m34788t(view);
        mo34802f().m34630x();
        m34786v(view);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: h */
    public void mo34800h() {
        if (this.f24216g) {
            return;
        }
        this.f24212c.clear();
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: i */
    public void mo34799i(View view) {
        if (this.f24216g) {
            return;
        }
        m34791q(view);
        C7088c m34796l = m34796l(view);
        if (m34796l != null) {
            this.f24212c.remove(m34796l);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: j */
    public void mo34798j(InterfaceC7079f interfaceC7079f) {
        this.f24220k = interfaceC7079f;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.AbstractC7075b
    /* renamed from: k */
    public void mo34797k() {
        if (this.f24215f) {
            return;
        }
        this.f24215f = true;
        C7085a.m34757a().m34754d(this);
        this.f24214e.m34650b(C7092f.m34717b().m34713f());
        this.f24214e.mo34628g(this, this.f24210a);
    }

    /* renamed from: m */
    public List<C7088c> m34795m() {
        return this.f24212c;
    }

    /* renamed from: o */
    public void m34793o(List<C15395a> list) {
        if (m34790r()) {
            ArrayList arrayList = new ArrayList();
            for (C15395a c15395a : list) {
                View view = c15395a.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f24220k.m34816a(this.f24217h, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m34792p(@NonNull JSONObject jSONObject) {
        m34807D();
        mo34802f().m34640m(jSONObject);
        this.f24219j = true;
    }

    /* renamed from: r */
    public boolean m34790r() {
        return this.f24220k != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public void m34789s() {
        m34808C();
        mo34802f().m34633u();
        this.f24218i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public void m34787u() {
        m34807D();
        mo34802f().m34631w();
        this.f24219j = true;
    }

    /* renamed from: w */
    public View m34785w() {
        return this.f24213d.get();
    }

    /* renamed from: x */
    public boolean m34784x() {
        return this.f24215f && !this.f24216g;
    }

    /* renamed from: y */
    public boolean m34783y() {
        return this.f24215f;
    }

    /* renamed from: z */
    public boolean m34782z() {
        return this.f24216g;
    }
}
