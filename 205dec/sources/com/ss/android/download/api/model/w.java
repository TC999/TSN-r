package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public Context f48256c;
    public InterfaceC0938w ev;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48257f;
    public View gd;

    /* renamed from: p  reason: collision with root package name */
    public int f48258p;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f48259r;
    public String sr;
    public String ux;

    /* renamed from: w  reason: collision with root package name */
    public String f48260w;
    public String xv;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public View f48261c;
        private boolean ev;

        /* renamed from: f  reason: collision with root package name */
        private String f48262f;
        private Drawable gd;

        /* renamed from: p  reason: collision with root package name */
        private InterfaceC0938w f48263p;

        /* renamed from: r  reason: collision with root package name */
        private String f48264r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        public int f48265w;
        private Context xv;

        public c(Context context) {
            this.xv = context;
        }

        public c c(String str) {
            this.sr = str;
            return this;
        }

        public c sr(String str) {
            this.f48264r = str;
            return this;
        }

        public c w(String str) {
            this.ux = str;
            return this;
        }

        public c xv(String str) {
            this.f48262f = str;
            return this;
        }

        public c c(boolean z3) {
            this.ev = z3;
            return this;
        }

        public c c(Drawable drawable) {
            this.gd = drawable;
            return this;
        }

        public c c(InterfaceC0938w interfaceC0938w) {
            this.f48263p = interfaceC0938w;
            return this;
        }

        public c c(int i4) {
            this.f48265w = i4;
            return this;
        }

        public w c() {
            return new w(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface InterfaceC0938w {
        void c(DialogInterface dialogInterface);

        void w(DialogInterface dialogInterface);

        void xv(DialogInterface dialogInterface);
    }

    private w(c cVar) {
        this.f48257f = true;
        this.f48256c = cVar.xv;
        this.f48260w = cVar.sr;
        this.xv = cVar.ux;
        this.sr = cVar.f48262f;
        this.ux = cVar.f48264r;
        this.f48257f = cVar.ev;
        this.f48259r = cVar.gd;
        this.ev = cVar.f48263p;
        this.gd = cVar.f48261c;
        this.f48258p = cVar.f48265w;
    }
}
