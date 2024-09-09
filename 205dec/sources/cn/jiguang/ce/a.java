package cn.jiguang.ce;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f3314a;

    public a(String str, Thread thread) {
        super(str);
        this.f3314a = thread;
        setStackTrace(thread.getStackTrace());
    }

    public Thread a() {
        return this.f3314a;
    }
}
