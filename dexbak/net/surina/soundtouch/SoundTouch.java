package net.surina.soundtouch;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SoundTouch {

    /* renamed from: a */
    long f44155a;

    static {
        System.loadLibrary("soundtouch");
    }

    public SoundTouch() {
        this.f44155a = 0L;
        this.f44155a = newInstance();
    }

    private final native void deleteInstance(long j);

    public static final native String getErrorString();

    public static final native String getVersionString();

    private static final native long newInstance();

    private final native int processFile(long j, String str, String str2);

    private final native void setPitchSemiTones(long j, float f);

    private final native void setSpeed(long j, float f);

    private final native void setTempo(long j, float f);

    /* renamed from: a */
    public void m2819a() {
        deleteInstance(this.f44155a);
        this.f44155a = 0L;
    }

    /* renamed from: b */
    public int m2818b(String str, String str2) {
        return processFile(this.f44155a, str, str2);
    }

    /* renamed from: c */
    public void m2817c(float f) {
        setPitchSemiTones(this.f44155a, f);
    }

    /* renamed from: d */
    public void m2816d(float f) {
        setSpeed(this.f44155a, f);
    }

    /* renamed from: e */
    public void m2815e(float f) {
        setTempo(this.f44155a, f);
    }
}
