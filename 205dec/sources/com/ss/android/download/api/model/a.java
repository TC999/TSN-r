package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48201a;
    public String bl;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f48202h;

    /* renamed from: k  reason: collision with root package name */
    public int f48203k;
    public boolean kf;

    /* renamed from: n  reason: collision with root package name */
    public String f48204n;
    public Context ok;

    /* renamed from: p  reason: collision with root package name */
    public InterfaceC0935a f48205p;

    /* renamed from: q  reason: collision with root package name */
    public View f48206q;

    /* renamed from: s  reason: collision with root package name */
    public String f48207s;

    /* renamed from: com.ss.android.download.api.model.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface InterfaceC0935a {
        void a(DialogInterface dialogInterface);

        void bl(DialogInterface dialogInterface);

        void ok(DialogInterface dialogInterface);
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class ok {

        /* renamed from: a  reason: collision with root package name */
        public int f48208a;
        private Context bl;

        /* renamed from: h  reason: collision with root package name */
        private String f48209h;

        /* renamed from: k  reason: collision with root package name */
        private InterfaceC0935a f48210k;
        private String kf;

        /* renamed from: n  reason: collision with root package name */
        private String f48211n;
        public View ok;

        /* renamed from: p  reason: collision with root package name */
        private boolean f48212p;

        /* renamed from: q  reason: collision with root package name */
        private Drawable f48213q;

        /* renamed from: s  reason: collision with root package name */
        private String f48214s;

        public ok(Context context) {
            this.bl = context;
        }

        public ok a(String str) {
            this.f48211n = str;
            return this;
        }

        public ok bl(String str) {
            this.kf = str;
            return this;
        }

        public ok ok(String str) {
            this.f48214s = str;
            return this;
        }

        public ok s(String str) {
            this.f48209h = str;
            return this;
        }

        public ok ok(boolean z3) {
            this.f48212p = z3;
            return this;
        }

        public ok ok(Drawable drawable) {
            this.f48213q = drawable;
            return this;
        }

        public ok ok(InterfaceC0935a interfaceC0935a) {
            this.f48210k = interfaceC0935a;
            return this;
        }

        public ok ok(int i4) {
            this.f48208a = i4;
            return this;
        }

        public a ok() {
            return new a(this);
        }
    }

    private a(ok okVar) {
        this.kf = true;
        this.ok = okVar.bl;
        this.f48201a = okVar.f48214s;
        this.bl = okVar.f48211n;
        this.f48207s = okVar.kf;
        this.f48204n = okVar.f48209h;
        this.kf = okVar.f48212p;
        this.f48202h = okVar.f48213q;
        this.f48205p = okVar.f48210k;
        this.f48206q = okVar.ok;
        this.f48203k = okVar.f48208a;
    }
}
