package cn.jiguang.bx;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f3093a;

    public f(int i4, String str) {
        super(str);
        this.f3093a = i4;
    }

    public int a() {
        return this.f3093a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "JException(" + this.f3093a + "):" + getLocalizedMessage();
    }
}
