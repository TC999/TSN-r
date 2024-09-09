package net.surina.soundtouch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SoundTouch {

    /* renamed from: a  reason: collision with root package name */
    long f61569a;

    static {
        System.loadLibrary("soundtouch");
    }

    public SoundTouch() {
        this.f61569a = 0L;
        this.f61569a = newInstance();
    }

    private final native void deleteInstance(long j4);

    public static final native String getErrorString();

    public static final native String getVersionString();

    private static final native long newInstance();

    private final native int processFile(long j4, String str, String str2);

    private final native void setPitchSemiTones(long j4, float f4);

    private final native void setSpeed(long j4, float f4);

    private final native void setTempo(long j4, float f4);

    public void a() {
        deleteInstance(this.f61569a);
        this.f61569a = 0L;
    }

    public int b(String str, String str2) {
        return processFile(this.f61569a, str, str2);
    }

    public void c(float f4) {
        setPitchSemiTones(this.f61569a, f4);
    }

    public void d(float f4) {
        setSpeed(this.f61569a, f4);
    }

    public void e(float f4) {
        setTempo(this.f61569a, f4);
    }
}
