package com.p521ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.ss.android.download.api.model.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11980a {

    /* renamed from: a */
    public String f33853a;

    /* renamed from: bl */
    public String f33854bl;

    /* renamed from: h */
    public Drawable f33855h;

    /* renamed from: k */
    public int f33856k;

    /* renamed from: kf */
    public boolean f33857kf;

    /* renamed from: n */
    public String f33858n;

    /* renamed from: ok */
    public Context f33859ok;

    /* renamed from: p */
    public InterfaceC11982a f33860p;

    /* renamed from: q */
    public View f33861q;

    /* renamed from: s */
    public String f33862s;

    /* renamed from: com.ss.android.download.api.model.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC11982a {
        /* renamed from: a */
        void mo18862a(DialogInterface dialogInterface);

        /* renamed from: bl */
        void mo18861bl(DialogInterface dialogInterface);

        /* renamed from: ok */
        void mo18860ok(DialogInterface dialogInterface);
    }

    /* renamed from: com.ss.android.download.api.model.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C11983ok {

        /* renamed from: a */
        public int f33863a;

        /* renamed from: bl */
        private Context f33864bl;

        /* renamed from: h */
        private String f33865h;

        /* renamed from: k */
        private InterfaceC11982a f33866k;

        /* renamed from: kf */
        private String f33867kf;

        /* renamed from: n */
        private String f33868n;

        /* renamed from: ok */
        public View f33869ok;

        /* renamed from: p */
        private boolean f33870p;

        /* renamed from: q */
        private Drawable f33871q;

        /* renamed from: s */
        private String f33872s;

        public C11983ok(Context context) {
            this.f33864bl = context;
        }

        /* renamed from: a */
        public C11983ok m19609a(String str) {
            this.f33868n = str;
            return this;
        }

        /* renamed from: bl */
        public C11983ok m19607bl(String str) {
            this.f33867kf = str;
            return this;
        }

        /* renamed from: ok */
        public C11983ok m19598ok(String str) {
            this.f33872s = str;
            return this;
        }

        /* renamed from: s */
        public C11983ok m19594s(String str) {
            this.f33865h = str;
            return this;
        }

        /* renamed from: ok */
        public C11983ok m19597ok(boolean z) {
            this.f33870p = z;
            return this;
        }

        /* renamed from: ok */
        public C11983ok m19601ok(Drawable drawable) {
            this.f33871q = drawable;
            return this;
        }

        /* renamed from: ok */
        public C11983ok m19600ok(InterfaceC11982a interfaceC11982a) {
            this.f33866k = interfaceC11982a;
            return this;
        }

        /* renamed from: ok */
        public C11983ok m19602ok(int i) {
            this.f33863a = i;
            return this;
        }

        /* renamed from: ok */
        public C11980a m19603ok() {
            return new C11980a(this);
        }
    }

    private C11980a(C11983ok c11983ok) {
        this.f33857kf = true;
        this.f33859ok = c11983ok.f33864bl;
        this.f33853a = c11983ok.f33872s;
        this.f33854bl = c11983ok.f33868n;
        this.f33862s = c11983ok.f33867kf;
        this.f33858n = c11983ok.f33865h;
        this.f33857kf = c11983ok.f33870p;
        this.f33855h = c11983ok.f33871q;
        this.f33860p = c11983ok.f33866k;
        this.f33861q = c11983ok.f33869ok;
        this.f33856k = c11983ok.f33863a;
    }
}
