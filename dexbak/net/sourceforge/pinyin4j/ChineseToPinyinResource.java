package net.sourceforge.pinyin4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import p029c2.Trie;

/* renamed from: net.sourceforge.pinyin4j.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class ChineseToPinyinResource {

    /* renamed from: a */
    private Trie f44102a;

    /* compiled from: ChineseToPinyinResource.java */
    /* renamed from: net.sourceforge.pinyin4j.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static class C15379b {

        /* renamed from: a */
        static final ChineseToPinyinResource f44103a = new ChineseToPinyinResource();

        private C15379b() {
        }
    }

    /* compiled from: ChineseToPinyinResource.java */
    /* renamed from: net.sourceforge.pinyin4j.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15380c {

        /* renamed from: b */
        static final String f44104b = "(";

        /* renamed from: c */
        static final String f44105c = ")";

        /* renamed from: d */
        static final String f44106d = ",";

        C15380c() {
        }
    }

    /* renamed from: a */
    private String m2871a(char c) {
        Trie m58051a = m2867e().m58051a(Integer.toHexString(c).toUpperCase());
        String m58049c = m58051a != null ? m58051a.m58049c() : null;
        if (m2865g(m58049c)) {
            return m58049c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static ChineseToPinyinResource m2868d() {
        return C15379b.f44103a;
    }

    /* renamed from: f */
    private void m2866f() {
        try {
            m2863i(new Trie());
            m2867e().m58048d(ResourceHelper.m2823a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
            m2867e().m58047e(ResourceHelper.m2823a("/pinyindb/multi_pinyin.txt"));
            m2867e().m58046f();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: g */
    private boolean m2865g(String str) {
        return str != null && !str.equals("(none0)") && str.startsWith("(") && str.endsWith(")");
    }

    /* renamed from: i */
    private void m2863i(Trie trie) {
        this.f44102a = trie;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String[] m2870b(char c) {
        return m2864h(m2871a(c));
    }

    /* renamed from: c */
    Trie m2869c(char c) {
        return m2867e().m58051a(Integer.toHexString(c).toUpperCase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Trie m2867e() {
        return this.f44102a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public String[] m2864h(String str) {
        if (str != null) {
            return str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).split(",");
        }
        return null;
    }

    private ChineseToPinyinResource() {
        this.f44102a = null;
        m2866f();
    }
}
