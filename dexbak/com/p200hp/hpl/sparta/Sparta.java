package com.p200hp.hpl.sparta;

import java.util.Hashtable;

/* renamed from: com.hp.hpl.sparta.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Sparta {

    /* renamed from: a */
    private static InterfaceC7055f f23942a = new C7050a();

    /* renamed from: b */
    private static InterfaceC7053d f23943b = new C7051b();

    /* compiled from: Sparta.java */
    /* renamed from: com.hp.hpl.sparta.q$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7050a implements InterfaceC7055f {

        /* renamed from: a */
        private final Hashtable f23944a = new Hashtable();

        C7050a() {
        }

        @Override // com.p200hp.hpl.sparta.Sparta.InterfaceC7055f
        /* renamed from: a */
        public String mo35119a(String str) {
            String str2 = (String) this.f23944a.get(str);
            if (str2 == null) {
                this.f23944a.put(str, str);
                return str;
            }
            return str2;
        }
    }

    /* compiled from: Sparta.java */
    /* renamed from: com.hp.hpl.sparta.q$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7051b implements InterfaceC7053d {
        C7051b() {
        }

        @Override // com.p200hp.hpl.sparta.Sparta.InterfaceC7053d
        /* renamed from: a */
        public InterfaceC7052c mo35120a() {
            return new C7054e(null);
        }
    }

    /* compiled from: Sparta.java */
    /* renamed from: com.hp.hpl.sparta.q$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7052c {
        Object get(Object obj);

        Object put(Object obj, Object obj2);

        int size();
    }

    /* compiled from: Sparta.java */
    /* renamed from: com.hp.hpl.sparta.q$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7053d {
        /* renamed from: a */
        InterfaceC7052c mo35120a();
    }

    /* compiled from: Sparta.java */
    /* renamed from: com.hp.hpl.sparta.q$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C7054e extends Hashtable implements InterfaceC7052c {
        private C7054e() {
        }

        /* synthetic */ C7054e(C7050a c7050a) {
            this();
        }
    }

    /* compiled from: Sparta.java */
    /* renamed from: com.hp.hpl.sparta.q$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7055f {
        /* renamed from: a */
        String mo35119a(String str);
    }

    /* renamed from: a */
    public static String m35124a(String str) {
        return f23942a.mo35119a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static InterfaceC7052c m35123b() {
        return f23943b.mo35120a();
    }

    /* renamed from: c */
    public static void m35122c(InterfaceC7053d interfaceC7053d) {
        f23943b = interfaceC7053d;
    }

    /* renamed from: d */
    public static void m35121d(InterfaceC7055f interfaceC7055f) {
        f23942a = interfaceC7055f;
    }
}
