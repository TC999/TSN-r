package net.sourceforge.pinyin4j;

import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChineseToPinyinResource.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private h3.b f61516a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChineseToPinyinResource.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f61517a = new a();

        private b() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChineseToPinyinResource.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c {

        /* renamed from: b  reason: collision with root package name */
        static final String f61518b = "(";

        /* renamed from: c  reason: collision with root package name */
        static final String f61519c = ")";

        /* renamed from: d  reason: collision with root package name */
        static final String f61520d = ",";

        c() {
        }
    }

    private String a(char c4) {
        h3.b a4 = e().a(Integer.toHexString(c4).toUpperCase());
        String c5 = a4 != null ? a4.c() : null;
        if (g(c5)) {
            return c5;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d() {
        return b.f61517a;
    }

    private void f() {
        try {
            i(new h3.b());
            e().d(i.a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
            e().e(i.a("/pinyindb/multi_pinyin.txt"));
            e().f();
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private boolean g(String str) {
        return str != null && !str.equals("(none0)") && str.startsWith("(") && str.endsWith(")");
    }

    private void i(h3.b bVar) {
        this.f61516a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] b(char c4) {
        return h(a(c4));
    }

    h3.b c(char c4) {
        return e().a(Integer.toHexString(c4).toUpperCase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3.b e() {
        return this.f61516a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] h(String str) {
        if (str != null) {
            return str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).split(",");
        }
        return null;
    }

    private a() {
        this.f61516a = null;
        f();
    }
}
