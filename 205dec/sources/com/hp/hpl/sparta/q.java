package com.hp.hpl.sparta;

import java.util.Hashtable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Sparta.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static f f37425a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static d f37426b = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Sparta.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a implements f {

        /* renamed from: a  reason: collision with root package name */
        private final Hashtable f37427a = new Hashtable();

        a() {
        }

        @Override // com.hp.hpl.sparta.q.f
        public String a(String str) {
            String str2 = (String) this.f37427a.get(str);
            if (str2 == null) {
                this.f37427a.put(str, str);
                return str;
            }
            return str2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Sparta.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b implements d {
        b() {
        }

        @Override // com.hp.hpl.sparta.q.d
        public c a() {
            return new e(null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Sparta.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        Object get(Object obj);

        Object put(Object obj, Object obj2);

        int size();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Sparta.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface d {
        c a();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Sparta.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class e extends Hashtable implements c {
        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Sparta.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface f {
        String a(String str);
    }

    public static String a(String str) {
        return f37425a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c b() {
        return f37426b.a();
    }

    public static void c(d dVar) {
        f37426b = dVar;
    }

    public static void d(f fVar) {
        f37425a = fVar;
    }
}
