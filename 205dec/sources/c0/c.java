package c0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6329136.dex
 */
/* compiled from: SportsDb.kt */
@Entity(tableName = "sports")
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B\u00bf\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u00a2\u0006\u0004\bi\u0010jJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0002H\u00c6\u0003J\u00ef\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u0002H\u00c6\u0001J\t\u00102\u001a\u00020\u0002H\u00d6\u0001J\t\u00104\u001a\u000203H\u00d6\u0001J\u0013\u00107\u001a\u0002062\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00108\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00108\u001a\u0004\bC\u0010:\"\u0004\bD\u0010<R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u00108\u001a\u0004\bE\u0010:\"\u0004\bF\u0010<R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b \u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u00108\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u00108\u001a\u0004\bK\u0010:\"\u0004\bL\u0010<R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b#\u00108\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b$\u00108\u001a\u0004\bO\u0010:\"\u0004\bP\u0010<R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u00108\u001a\u0004\bQ\u0010:\"\u0004\bR\u0010<R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b&\u00108\u001a\u0004\bS\u0010:\"\u0004\bT\u0010<R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b'\u00108\u001a\u0004\bU\u0010:\"\u0004\bV\u0010<R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b(\u00108\u001a\u0004\bW\u0010:\"\u0004\bX\u0010<R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b)\u00108\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010<R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b*\u00108\u001a\u0004\b[\u0010:\"\u0004\b\\\u0010<R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b+\u00108\u001a\u0004\b]\u0010:\"\u0004\b^\u0010<R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b,\u00108\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b-\u00108\u001a\u0004\ba\u0010:\"\u0004\bb\u0010<R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b.\u00108\u001a\u0004\bc\u0010:\"\u0004\bd\u0010<R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b/\u00108\u001a\u0004\be\u0010:\"\u0004\bf\u0010<R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b0\u00108\u001a\u0004\bg\u0010:\"\u0004\bh\u0010<\u00a8\u0006k"}, d2 = {"Lc0/c;", "", "", "a", "l", CampaignEx.JSON_KEY_AD_Q, "r", "s", "t", "u", "v", "w", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "o", "p", "identify", "userNumber", "sportsType", "sportsSet", "startTime", "endTime", "countTime", "distance", "gpsDistance", "latLngList", "stepList", "passLatLngList", "isFaceOut", "faceDetectCount", "uploadType", "isException", "startFace", "midFace", "endFace", "isValid", "faceCheckingDistance", "pauseLatLng", "isOpenDevelop", "x", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "f0", "(Ljava/lang/String;)V", "R", "r0", "M", "m0", "L", "l0", "O", "o0", "C", "Z", "z", "W", "A", "X", "F", "e0", "H", "g0", "P", "p0", "J", "j0", "T", "d0", "E", "c0", "Q", "q0", "S", "a0", "N", "n0", "I", "h0", "B", "Y", "V", "s0", "D", "b0", "K", "k0", "U", "i0", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class c {
    @PrimaryKey
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private String f1486a;
    @ColumnInfo(name = "userNumber", typeAffinity = 2)
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f1487b;
    @ColumnInfo(name = "sportsType", typeAffinity = 2)
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f1488c;
    @ColumnInfo(name = "sportsSet", typeAffinity = 2)
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private String f1489d;
    @ColumnInfo(name = "startTime", typeAffinity = 2)
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private String f1490e;
    @ColumnInfo(name = "endTime", typeAffinity = 2)
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private String f1491f;
    @ColumnInfo(name = "countTime", typeAffinity = 2)
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private String f1492g;
    @ColumnInfo(name = "distance", typeAffinity = 2)
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private String f1493h;
    @ColumnInfo(name = "gpsDistance", typeAffinity = 2)
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f1494i;
    @ColumnInfo(name = "latLngList", typeAffinity = 2)
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private String f1495j;
    @ColumnInfo(name = "stepList", typeAffinity = 2)
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private String f1496k;
    @ColumnInfo(name = "passLatLngList", typeAffinity = 2)
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private String f1497l;
    @ColumnInfo(name = "isFaceOut", typeAffinity = 2)
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private String f1498m;
    @ColumnInfo(name = "faceDetectCount", typeAffinity = 2)
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private String f1499n;
    @ColumnInfo(name = "uploadType", typeAffinity = 2)
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private String f1500o;
    @ColumnInfo(name = "isException", typeAffinity = 2)
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private String f1501p;
    @ColumnInfo(name = "startFace", typeAffinity = 2)
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private String f1502q;
    @ColumnInfo(name = "midFace", typeAffinity = 2)
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private String f1503r;
    @ColumnInfo(name = "endFace", typeAffinity = 2)
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private String f1504s;
    @ColumnInfo(defaultValue = "0", name = "isValid", typeAffinity = 2)
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private String f1505t;
    @ColumnInfo(name = "faceCheckingDistance", typeAffinity = 2)
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    private String f1506u;
    @ColumnInfo(name = "pauseLatLng", typeAffinity = 2)
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    private String f1507v;
    @ColumnInfo(defaultValue = "0", name = "isOpenDevelop", typeAffinity = 2)
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private String f1508w;

    public c(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String gpsDistance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType, @NotNull String isException, @NotNull String startFace, @NotNull String midFace, @NotNull String endFace, @NotNull String isValid, @NotNull String faceCheckingDistance, @NotNull String pauseLatLng, @NotNull String isOpenDevelop) {
        f0.p(identify, "identify");
        f0.p(userNumber, "userNumber");
        f0.p(sportsType, "sportsType");
        f0.p(sportsSet, "sportsSet");
        f0.p(startTime, "startTime");
        f0.p(endTime, "endTime");
        f0.p(countTime, "countTime");
        f0.p(distance, "distance");
        f0.p(gpsDistance, "gpsDistance");
        f0.p(latLngList, "latLngList");
        f0.p(stepList, "stepList");
        f0.p(passLatLngList, "passLatLngList");
        f0.p(isFaceOut, "isFaceOut");
        f0.p(faceDetectCount, "faceDetectCount");
        f0.p(uploadType, "uploadType");
        f0.p(isException, "isException");
        f0.p(startFace, "startFace");
        f0.p(midFace, "midFace");
        f0.p(endFace, "endFace");
        f0.p(isValid, "isValid");
        f0.p(faceCheckingDistance, "faceCheckingDistance");
        f0.p(pauseLatLng, "pauseLatLng");
        f0.p(isOpenDevelop, "isOpenDevelop");
        this.f1486a = identify;
        this.f1487b = userNumber;
        this.f1488c = sportsType;
        this.f1489d = sportsSet;
        this.f1490e = startTime;
        this.f1491f = endTime;
        this.f1492g = countTime;
        this.f1493h = distance;
        this.f1494i = gpsDistance;
        this.f1495j = latLngList;
        this.f1496k = stepList;
        this.f1497l = passLatLngList;
        this.f1498m = isFaceOut;
        this.f1499n = faceDetectCount;
        this.f1500o = uploadType;
        this.f1501p = isException;
        this.f1502q = startFace;
        this.f1503r = midFace;
        this.f1504s = endFace;
        this.f1505t = isValid;
        this.f1506u = faceCheckingDistance;
        this.f1507v = pauseLatLng;
        this.f1508w = isOpenDevelop;
    }

    @NotNull
    public final String A() {
        return this.f1493h;
    }

    @NotNull
    public final String B() {
        return this.f1504s;
    }

    @NotNull
    public final String C() {
        return this.f1491f;
    }

    @NotNull
    public final String D() {
        return this.f1506u;
    }

    @NotNull
    public final String E() {
        return this.f1499n;
    }

    @NotNull
    public final String F() {
        return this.f1494i;
    }

    @NotNull
    public final String G() {
        return this.f1486a;
    }

    @NotNull
    public final String H() {
        return this.f1495j;
    }

    @NotNull
    public final String I() {
        return this.f1503r;
    }

    @NotNull
    public final String J() {
        return this.f1497l;
    }

    @NotNull
    public final String K() {
        return this.f1507v;
    }

    @NotNull
    public final String L() {
        return this.f1489d;
    }

    @NotNull
    public final String M() {
        return this.f1488c;
    }

    @NotNull
    public final String N() {
        return this.f1502q;
    }

    @NotNull
    public final String O() {
        return this.f1490e;
    }

    @NotNull
    public final String P() {
        return this.f1496k;
    }

    @NotNull
    public final String Q() {
        return this.f1500o;
    }

    @NotNull
    public final String R() {
        return this.f1487b;
    }

    @NotNull
    public final String S() {
        return this.f1501p;
    }

    @NotNull
    public final String T() {
        return this.f1498m;
    }

    @NotNull
    public final String U() {
        return this.f1508w;
    }

    @NotNull
    public final String V() {
        return this.f1505t;
    }

    public final void W(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1492g = str;
    }

    public final void X(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1493h = str;
    }

    public final void Y(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1504s = str;
    }

    public final void Z(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1491f = str;
    }

    @NotNull
    public final String a() {
        return this.f1486a;
    }

    public final void a0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1501p = str;
    }

    @NotNull
    public final String b() {
        return this.f1495j;
    }

    public final void b0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1506u = str;
    }

    @NotNull
    public final String c() {
        return this.f1496k;
    }

    public final void c0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1499n = str;
    }

    @NotNull
    public final String d() {
        return this.f1497l;
    }

    public final void d0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1498m = str;
    }

    @NotNull
    public final String e() {
        return this.f1498m;
    }

    public final void e0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1494i = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return f0.g(this.f1486a, cVar.f1486a) && f0.g(this.f1487b, cVar.f1487b) && f0.g(this.f1488c, cVar.f1488c) && f0.g(this.f1489d, cVar.f1489d) && f0.g(this.f1490e, cVar.f1490e) && f0.g(this.f1491f, cVar.f1491f) && f0.g(this.f1492g, cVar.f1492g) && f0.g(this.f1493h, cVar.f1493h) && f0.g(this.f1494i, cVar.f1494i) && f0.g(this.f1495j, cVar.f1495j) && f0.g(this.f1496k, cVar.f1496k) && f0.g(this.f1497l, cVar.f1497l) && f0.g(this.f1498m, cVar.f1498m) && f0.g(this.f1499n, cVar.f1499n) && f0.g(this.f1500o, cVar.f1500o) && f0.g(this.f1501p, cVar.f1501p) && f0.g(this.f1502q, cVar.f1502q) && f0.g(this.f1503r, cVar.f1503r) && f0.g(this.f1504s, cVar.f1504s) && f0.g(this.f1505t, cVar.f1505t) && f0.g(this.f1506u, cVar.f1506u) && f0.g(this.f1507v, cVar.f1507v) && f0.g(this.f1508w, cVar.f1508w);
        }
        return false;
    }

    @NotNull
    public final String f() {
        return this.f1499n;
    }

    public final void f0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1486a = str;
    }

    @NotNull
    public final String g() {
        return this.f1500o;
    }

    public final void g0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1495j = str;
    }

    @NotNull
    public final String h() {
        return this.f1501p;
    }

    public final void h0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1503r = str;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.f1486a.hashCode() * 31) + this.f1487b.hashCode()) * 31) + this.f1488c.hashCode()) * 31) + this.f1489d.hashCode()) * 31) + this.f1490e.hashCode()) * 31) + this.f1491f.hashCode()) * 31) + this.f1492g.hashCode()) * 31) + this.f1493h.hashCode()) * 31) + this.f1494i.hashCode()) * 31) + this.f1495j.hashCode()) * 31) + this.f1496k.hashCode()) * 31) + this.f1497l.hashCode()) * 31) + this.f1498m.hashCode()) * 31) + this.f1499n.hashCode()) * 31) + this.f1500o.hashCode()) * 31) + this.f1501p.hashCode()) * 31) + this.f1502q.hashCode()) * 31) + this.f1503r.hashCode()) * 31) + this.f1504s.hashCode()) * 31) + this.f1505t.hashCode()) * 31) + this.f1506u.hashCode()) * 31) + this.f1507v.hashCode()) * 31) + this.f1508w.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f1502q;
    }

    public final void i0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1508w = str;
    }

    @NotNull
    public final String j() {
        return this.f1503r;
    }

    public final void j0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1497l = str;
    }

    @NotNull
    public final String k() {
        return this.f1504s;
    }

    public final void k0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1507v = str;
    }

    @NotNull
    public final String l() {
        return this.f1487b;
    }

    public final void l0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1489d = str;
    }

    @NotNull
    public final String m() {
        return this.f1505t;
    }

    public final void m0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1488c = str;
    }

    @NotNull
    public final String n() {
        return this.f1506u;
    }

    public final void n0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1502q = str;
    }

    @NotNull
    public final String o() {
        return this.f1507v;
    }

    public final void o0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1490e = str;
    }

    @NotNull
    public final String p() {
        return this.f1508w;
    }

    public final void p0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1496k = str;
    }

    @NotNull
    public final String q() {
        return this.f1488c;
    }

    public final void q0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1500o = str;
    }

    @NotNull
    public final String r() {
        return this.f1489d;
    }

    public final void r0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1487b = str;
    }

    @NotNull
    public final String s() {
        return this.f1490e;
    }

    public final void s0(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1505t = str;
    }

    @NotNull
    public final String t() {
        return this.f1491f;
    }

    @NotNull
    public String toString() {
        return "SportsDb(identify=" + this.f1486a + ", userNumber=" + this.f1487b + ", sportsType=" + this.f1488c + ", sportsSet=" + this.f1489d + ", startTime=" + this.f1490e + ", endTime=" + this.f1491f + ", countTime=" + this.f1492g + ", distance=" + this.f1493h + ", gpsDistance=" + this.f1494i + ", latLngList=" + this.f1495j + ", stepList=" + this.f1496k + ", passLatLngList=" + this.f1497l + ", isFaceOut=" + this.f1498m + ", faceDetectCount=" + this.f1499n + ", uploadType=" + this.f1500o + ", isException=" + this.f1501p + ", startFace=" + this.f1502q + ", midFace=" + this.f1503r + ", endFace=" + this.f1504s + ", isValid=" + this.f1505t + ", faceCheckingDistance=" + this.f1506u + ", pauseLatLng=" + this.f1507v + ", isOpenDevelop=" + this.f1508w + ')';
    }

    @NotNull
    public final String u() {
        return this.f1492g;
    }

    @NotNull
    public final String v() {
        return this.f1493h;
    }

    @NotNull
    public final String w() {
        return this.f1494i;
    }

    @NotNull
    public final c x(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String gpsDistance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType, @NotNull String isException, @NotNull String startFace, @NotNull String midFace, @NotNull String endFace, @NotNull String isValid, @NotNull String faceCheckingDistance, @NotNull String pauseLatLng, @NotNull String isOpenDevelop) {
        f0.p(identify, "identify");
        f0.p(userNumber, "userNumber");
        f0.p(sportsType, "sportsType");
        f0.p(sportsSet, "sportsSet");
        f0.p(startTime, "startTime");
        f0.p(endTime, "endTime");
        f0.p(countTime, "countTime");
        f0.p(distance, "distance");
        f0.p(gpsDistance, "gpsDistance");
        f0.p(latLngList, "latLngList");
        f0.p(stepList, "stepList");
        f0.p(passLatLngList, "passLatLngList");
        f0.p(isFaceOut, "isFaceOut");
        f0.p(faceDetectCount, "faceDetectCount");
        f0.p(uploadType, "uploadType");
        f0.p(isException, "isException");
        f0.p(startFace, "startFace");
        f0.p(midFace, "midFace");
        f0.p(endFace, "endFace");
        f0.p(isValid, "isValid");
        f0.p(faceCheckingDistance, "faceCheckingDistance");
        f0.p(pauseLatLng, "pauseLatLng");
        f0.p(isOpenDevelop, "isOpenDevelop");
        return new c(identify, userNumber, sportsType, sportsSet, startTime, endTime, countTime, distance, gpsDistance, latLngList, stepList, passLatLngList, isFaceOut, faceDetectCount, uploadType, isException, startFace, midFace, endFace, isValid, faceCheckingDistance, pauseLatLng, isOpenDevelop);
    }

    @NotNull
    public final String z() {
        return this.f1492g;
    }
}
