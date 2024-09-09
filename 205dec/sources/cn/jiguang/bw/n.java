package cn.jiguang.bw;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static f f3075a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f3076b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f3077c;

    static {
        f fVar = new f("Message Section", 3);
        f3075a = fVar;
        f3076b = new String[4];
        f3077c = new String[4];
        fVar.a(3);
        f3075a.a(true);
        f3075a.a(0, "qd");
        f3075a.a(1, "an");
        f3075a.a(2, "au");
        f3075a.a(3, "ad");
        String[] strArr = f3076b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = f3077c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i4) {
        return f3075a.d(i4);
    }
}
