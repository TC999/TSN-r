package net.sourceforge.pinyin4j.format;

/* renamed from: net.sourceforge.pinyin4j.format.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class HanyuPinyinOutputFormat {

    /* renamed from: a */
    private HanyuPinyinVCharType f44118a;

    /* renamed from: b */
    private HanyuPinyinCaseType f44119b;

    /* renamed from: c */
    private HanyuPinyinToneType f44120c;

    public HanyuPinyinOutputFormat() {
        m2834d();
    }

    /* renamed from: a */
    public HanyuPinyinCaseType m2837a() {
        return this.f44119b;
    }

    /* renamed from: b */
    public HanyuPinyinToneType m2836b() {
        return this.f44120c;
    }

    /* renamed from: c */
    public HanyuPinyinVCharType m2835c() {
        return this.f44118a;
    }

    /* renamed from: d */
    public void m2834d() {
        this.f44118a = HanyuPinyinVCharType.f44125b;
        this.f44119b = HanyuPinyinCaseType.f44116c;
        this.f44120c = HanyuPinyinToneType.f44121b;
    }

    /* renamed from: e */
    public void m2833e(HanyuPinyinCaseType hanyuPinyinCaseType) {
        this.f44119b = hanyuPinyinCaseType;
    }

    /* renamed from: f */
    public void m2832f(HanyuPinyinToneType hanyuPinyinToneType) {
        this.f44120c = hanyuPinyinToneType;
    }

    /* renamed from: g */
    public void m2831g(HanyuPinyinVCharType hanyuPinyinVCharType) {
        this.f44118a = hanyuPinyinVCharType;
    }
}
