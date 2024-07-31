package p640rx;

import p640rx.exceptions.MissingBackpressureException;

/* renamed from: rx.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BackpressureOverflow {

    /* renamed from: a */
    public static final InterfaceC15500d f44623a;

    /* renamed from: b */
    public static final InterfaceC15500d f44624b;

    /* renamed from: c */
    public static final InterfaceC15500d f44625c;

    /* renamed from: d */
    public static final InterfaceC15500d f44626d;

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: rx.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15497a implements InterfaceC15500d {

        /* renamed from: a */
        static final C15497a f44627a = new C15497a();

        private C15497a() {
        }

        @Override // p640rx.BackpressureOverflow.InterfaceC15500d
        /* renamed from: a */
        public boolean mo1993a() {
            return false;
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: rx.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15498b implements InterfaceC15500d {

        /* renamed from: a */
        static final C15498b f44628a = new C15498b();

        private C15498b() {
        }

        @Override // p640rx.BackpressureOverflow.InterfaceC15500d
        /* renamed from: a */
        public boolean mo1993a() {
            return true;
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: rx.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15499c implements InterfaceC15500d {

        /* renamed from: a */
        static final C15499c f44629a = new C15499c();

        private C15499c() {
        }

        @Override // p640rx.BackpressureOverflow.InterfaceC15500d
        /* renamed from: a */
        public boolean mo1993a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: rx.a$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15500d {
        /* renamed from: a */
        boolean mo1993a() throws MissingBackpressureException;
    }

    static {
        C15499c c15499c = C15499c.f44629a;
        f44623a = c15499c;
        f44624b = c15499c;
        f44625c = C15498b.f44628a;
        f44626d = C15497a.f44627a;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }
}
