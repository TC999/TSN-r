package p637r;

/* renamed from: r.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class User implements Comparable<User> {

    /* renamed from: a */
    private String f44598a;

    /* renamed from: b */
    private String f44599b;

    /* renamed from: c */
    private String f44600c;

    /* renamed from: d */
    private String f44601d;

    /* renamed from: e */
    private String f44602e;

    /* renamed from: f */
    private String f44603f;

    public User() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(User user) {
        if (!this.f44603f.equals("#") || user.m2132b().equals("#")) {
            if (this.f44603f.equals("#") || !user.m2132b().equals("#")) {
                return this.f44602e.compareToIgnoreCase(user.m2129e());
            }
            return -1;
        }
        return 1;
    }

    /* renamed from: b */
    public String m2132b() {
        return this.f44603f;
    }

    /* renamed from: c */
    public String m2131c() {
        return this.f44598a;
    }

    /* renamed from: d */
    public String m2130d() {
        return this.f44601d;
    }

    /* renamed from: e */
    public String m2129e() {
        return this.f44602e;
    }

    /* renamed from: f */
    public void m2128f(String str) {
        this.f44598a = str;
    }

    /* renamed from: g */
    public void m2127g(String str) {
        this.f44600c = str;
        String m2136a = Cn2Spell.m2136a(str);
        this.f44602e = m2136a;
        String upperCase = m2136a.substring(0, 1).toUpperCase();
        this.f44603f = upperCase;
        if (upperCase.matches("[A-Z]")) {
            return;
        }
        this.f44603f = "#";
    }

    public String getName() {
        return this.f44600c;
    }

    public String getType() {
        return this.f44599b;
    }

    /* renamed from: h */
    public void m2126h(String str) {
        this.f44601d = str;
    }

    /* renamed from: i */
    public void m2125i(String str) {
        this.f44599b = str;
    }

    public User(String str, String str2, String str3, String str4) {
        m2128f(str);
        m2125i(str2);
        m2127g(str3);
        m2126h(str4);
    }
}
