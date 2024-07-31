package p027c0;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(tableName = "sports")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\bi\u0010jJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0002HÆ\u0003Jï\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u0002HÆ\u0001J\t\u00102\u001a\u00020\u0002HÖ\u0001J\t\u00104\u001a\u000203HÖ\u0001J\u0013\u00107\u001a\u0002062\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00108\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00108\u001a\u0004\bC\u0010:\"\u0004\bD\u0010<R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00108\u001a\u0004\bE\u0010:\"\u0004\bF\u0010<R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00108\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00108\u001a\u0004\bK\u0010:\"\u0004\bL\u0010<R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00108\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00108\u001a\u0004\bO\u0010:\"\u0004\bP\u0010<R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00108\u001a\u0004\bQ\u0010:\"\u0004\bR\u0010<R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00108\u001a\u0004\bS\u0010:\"\u0004\bT\u0010<R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u00108\u001a\u0004\bU\u0010:\"\u0004\bV\u0010<R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00108\u001a\u0004\bW\u0010:\"\u0004\bX\u0010<R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u00108\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010<R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u00108\u001a\u0004\b[\u0010:\"\u0004\b\\\u0010<R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u00108\u001a\u0004\b]\u0010:\"\u0004\b^\u0010<R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u00108\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u00108\u001a\u0004\ba\u0010:\"\u0004\bb\u0010<R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u00108\u001a\u0004\bc\u0010:\"\u0004\bd\u0010<R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00108\u001a\u0004\be\u0010:\"\u0004\bf\u0010<R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00108\u001a\u0004\bg\u0010:\"\u0004\bh\u0010<¨\u0006k"}, m12616d2 = {"Lc0/c;", "", "", "a", C7304t.f25048d, CampaignEx.JSON_KEY_AD_Q, "r", "s", UMCommonContent.f37782aL, "u", "v", IAdInterListener.AdReqParam.WIDTH, "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "o", "p", "identify", "userNumber", "sportsType", "sportsSet", AnalyticsConfig.RTD_START_TIME, "endTime", "countTime", "distance", "gpsDistance", "latLngList", "stepList", "passLatLngList", "isFaceOut", "faceDetectCount", "uploadType", "isException", "startFace", "midFace", "endFace", "isValid", "faceCheckingDistance", "pauseLatLng", "isOpenDevelop", "x", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "f0", "(Ljava/lang/String;)V", "R", "r0", "M", "m0", "L", "l0", "O", "o0", "C", "Z", UMCommonContent.f37777aG, ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "X", "F", "e0", "H", "g0", "P", C7202bq.f24604g, "J", "j0", ExifInterface.GPS_DIRECTION_TRUE, "d0", ExifInterface.LONGITUDE_EAST, "c0", "Q", "q0", ExifInterface.LATITUDE_SOUTH, "a0", "N", "n0", "I", "h0", "B", "Y", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "s0", "D", "b0", "K", "k0", "U", "i0", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: c0.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SportsDb {
    @PrimaryKey
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull

    /* renamed from: a */
    private String f1487a;
    @ColumnInfo(name = "userNumber", typeAffinity = 2)
    @NotNull

    /* renamed from: b */
    private String f1488b;
    @ColumnInfo(name = "sportsType", typeAffinity = 2)
    @NotNull

    /* renamed from: c */
    private String f1489c;
    @ColumnInfo(name = "sportsSet", typeAffinity = 2)
    @NotNull

    /* renamed from: d */
    private String f1490d;
    @ColumnInfo(name = AnalyticsConfig.RTD_START_TIME, typeAffinity = 2)
    @NotNull

    /* renamed from: e */
    private String f1491e;
    @ColumnInfo(name = "endTime", typeAffinity = 2)
    @NotNull

    /* renamed from: f */
    private String f1492f;
    @ColumnInfo(name = "countTime", typeAffinity = 2)
    @NotNull

    /* renamed from: g */
    private String f1493g;
    @ColumnInfo(name = "distance", typeAffinity = 2)
    @NotNull

    /* renamed from: h */
    private String f1494h;
    @ColumnInfo(name = "gpsDistance", typeAffinity = 2)
    @NotNull

    /* renamed from: i */
    private String f1495i;
    @ColumnInfo(name = "latLngList", typeAffinity = 2)
    @NotNull

    /* renamed from: j */
    private String f1496j;
    @ColumnInfo(name = "stepList", typeAffinity = 2)
    @NotNull

    /* renamed from: k */
    private String f1497k;
    @ColumnInfo(name = "passLatLngList", typeAffinity = 2)
    @NotNull

    /* renamed from: l */
    private String f1498l;
    @ColumnInfo(name = "isFaceOut", typeAffinity = 2)
    @NotNull

    /* renamed from: m */
    private String f1499m;
    @ColumnInfo(name = "faceDetectCount", typeAffinity = 2)
    @NotNull

    /* renamed from: n */
    private String f1500n;
    @ColumnInfo(name = "uploadType", typeAffinity = 2)
    @NotNull

    /* renamed from: o */
    private String f1501o;
    @ColumnInfo(name = "isException", typeAffinity = 2)
    @NotNull

    /* renamed from: p */
    private String f1502p;
    @ColumnInfo(name = "startFace", typeAffinity = 2)
    @NotNull

    /* renamed from: q */
    private String f1503q;
    @ColumnInfo(name = "midFace", typeAffinity = 2)
    @NotNull

    /* renamed from: r */
    private String f1504r;
    @ColumnInfo(name = "endFace", typeAffinity = 2)
    @NotNull

    /* renamed from: s */
    private String f1505s;
    @ColumnInfo(defaultValue = "0", name = "isValid", typeAffinity = 2)
    @NotNull

    /* renamed from: t */
    private String f1506t;
    @ColumnInfo(name = "faceCheckingDistance", typeAffinity = 2)
    @NotNull

    /* renamed from: u */
    private String f1507u;
    @ColumnInfo(name = "pauseLatLng", typeAffinity = 2)
    @NotNull

    /* renamed from: v */
    private String f1508v;
    @ColumnInfo(defaultValue = "0", name = "isOpenDevelop", typeAffinity = 2)
    @NotNull

    /* renamed from: w */
    private String f1509w;

    public SportsDb(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String gpsDistance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType, @NotNull String isException, @NotNull String startFace, @NotNull String midFace, @NotNull String endFace, @NotNull String isValid, @NotNull String faceCheckingDistance, @NotNull String pauseLatLng, @NotNull String isOpenDevelop) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(userNumber, "userNumber");
        C14342f0.m8184p(sportsType, "sportsType");
        C14342f0.m8184p(sportsSet, "sportsSet");
        C14342f0.m8184p(startTime, "startTime");
        C14342f0.m8184p(endTime, "endTime");
        C14342f0.m8184p(countTime, "countTime");
        C14342f0.m8184p(distance, "distance");
        C14342f0.m8184p(gpsDistance, "gpsDistance");
        C14342f0.m8184p(latLngList, "latLngList");
        C14342f0.m8184p(stepList, "stepList");
        C14342f0.m8184p(passLatLngList, "passLatLngList");
        C14342f0.m8184p(isFaceOut, "isFaceOut");
        C14342f0.m8184p(faceDetectCount, "faceDetectCount");
        C14342f0.m8184p(uploadType, "uploadType");
        C14342f0.m8184p(isException, "isException");
        C14342f0.m8184p(startFace, "startFace");
        C14342f0.m8184p(midFace, "midFace");
        C14342f0.m8184p(endFace, "endFace");
        C14342f0.m8184p(isValid, "isValid");
        C14342f0.m8184p(faceCheckingDistance, "faceCheckingDistance");
        C14342f0.m8184p(pauseLatLng, "pauseLatLng");
        C14342f0.m8184p(isOpenDevelop, "isOpenDevelop");
        this.f1487a = identify;
        this.f1488b = userNumber;
        this.f1489c = sportsType;
        this.f1490d = sportsSet;
        this.f1491e = startTime;
        this.f1492f = endTime;
        this.f1493g = countTime;
        this.f1494h = distance;
        this.f1495i = gpsDistance;
        this.f1496j = latLngList;
        this.f1497k = stepList;
        this.f1498l = passLatLngList;
        this.f1499m = isFaceOut;
        this.f1500n = faceDetectCount;
        this.f1501o = uploadType;
        this.f1502p = isException;
        this.f1503q = startFace;
        this.f1504r = midFace;
        this.f1505s = endFace;
        this.f1506t = isValid;
        this.f1507u = faceCheckingDistance;
        this.f1508v = pauseLatLng;
        this.f1509w = isOpenDevelop;
    }

    @NotNull
    /* renamed from: A */
    public final String m58132A() {
        return this.f1494h;
    }

    @NotNull
    /* renamed from: B */
    public final String m58131B() {
        return this.f1505s;
    }

    @NotNull
    /* renamed from: C */
    public final String m58130C() {
        return this.f1492f;
    }

    @NotNull
    /* renamed from: D */
    public final String m58129D() {
        return this.f1507u;
    }

    @NotNull
    /* renamed from: E */
    public final String m58128E() {
        return this.f1500n;
    }

    @NotNull
    /* renamed from: F */
    public final String m58127F() {
        return this.f1495i;
    }

    @NotNull
    /* renamed from: G */
    public final String m58126G() {
        return this.f1487a;
    }

    @NotNull
    /* renamed from: H */
    public final String m58125H() {
        return this.f1496j;
    }

    @NotNull
    /* renamed from: I */
    public final String m58124I() {
        return this.f1504r;
    }

    @NotNull
    /* renamed from: J */
    public final String m58123J() {
        return this.f1498l;
    }

    @NotNull
    /* renamed from: K */
    public final String m58122K() {
        return this.f1508v;
    }

    @NotNull
    /* renamed from: L */
    public final String m58121L() {
        return this.f1490d;
    }

    @NotNull
    /* renamed from: M */
    public final String m58120M() {
        return this.f1489c;
    }

    @NotNull
    /* renamed from: N */
    public final String m58119N() {
        return this.f1503q;
    }

    @NotNull
    /* renamed from: O */
    public final String m58118O() {
        return this.f1491e;
    }

    @NotNull
    /* renamed from: P */
    public final String m58117P() {
        return this.f1497k;
    }

    @NotNull
    /* renamed from: Q */
    public final String m58116Q() {
        return this.f1501o;
    }

    @NotNull
    /* renamed from: R */
    public final String m58115R() {
        return this.f1488b;
    }

    @NotNull
    /* renamed from: S */
    public final String m58114S() {
        return this.f1502p;
    }

    @NotNull
    /* renamed from: T */
    public final String m58113T() {
        return this.f1499m;
    }

    @NotNull
    /* renamed from: U */
    public final String m58112U() {
        return this.f1509w;
    }

    @NotNull
    /* renamed from: V */
    public final String m58111V() {
        return this.f1506t;
    }

    /* renamed from: W */
    public final void m58110W(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1493g = str;
    }

    /* renamed from: X */
    public final void m58109X(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1494h = str;
    }

    /* renamed from: Y */
    public final void m58108Y(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1505s = str;
    }

    /* renamed from: Z */
    public final void m58107Z(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1492f = str;
    }

    @NotNull
    /* renamed from: a */
    public final String m58106a() {
        return this.f1487a;
    }

    /* renamed from: a0 */
    public final void m58105a0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1502p = str;
    }

    @NotNull
    /* renamed from: b */
    public final String m58104b() {
        return this.f1496j;
    }

    /* renamed from: b0 */
    public final void m58103b0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1507u = str;
    }

    @NotNull
    /* renamed from: c */
    public final String m58102c() {
        return this.f1497k;
    }

    /* renamed from: c0 */
    public final void m58101c0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1500n = str;
    }

    @NotNull
    /* renamed from: d */
    public final String m58100d() {
        return this.f1498l;
    }

    /* renamed from: d0 */
    public final void m58099d0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1499m = str;
    }

    @NotNull
    /* renamed from: e */
    public final String m58098e() {
        return this.f1499m;
    }

    /* renamed from: e0 */
    public final void m58097e0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1495i = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SportsDb) {
            SportsDb sportsDb = (SportsDb) obj;
            return C14342f0.m8193g(this.f1487a, sportsDb.f1487a) && C14342f0.m8193g(this.f1488b, sportsDb.f1488b) && C14342f0.m8193g(this.f1489c, sportsDb.f1489c) && C14342f0.m8193g(this.f1490d, sportsDb.f1490d) && C14342f0.m8193g(this.f1491e, sportsDb.f1491e) && C14342f0.m8193g(this.f1492f, sportsDb.f1492f) && C14342f0.m8193g(this.f1493g, sportsDb.f1493g) && C14342f0.m8193g(this.f1494h, sportsDb.f1494h) && C14342f0.m8193g(this.f1495i, sportsDb.f1495i) && C14342f0.m8193g(this.f1496j, sportsDb.f1496j) && C14342f0.m8193g(this.f1497k, sportsDb.f1497k) && C14342f0.m8193g(this.f1498l, sportsDb.f1498l) && C14342f0.m8193g(this.f1499m, sportsDb.f1499m) && C14342f0.m8193g(this.f1500n, sportsDb.f1500n) && C14342f0.m8193g(this.f1501o, sportsDb.f1501o) && C14342f0.m8193g(this.f1502p, sportsDb.f1502p) && C14342f0.m8193g(this.f1503q, sportsDb.f1503q) && C14342f0.m8193g(this.f1504r, sportsDb.f1504r) && C14342f0.m8193g(this.f1505s, sportsDb.f1505s) && C14342f0.m8193g(this.f1506t, sportsDb.f1506t) && C14342f0.m8193g(this.f1507u, sportsDb.f1507u) && C14342f0.m8193g(this.f1508v, sportsDb.f1508v) && C14342f0.m8193g(this.f1509w, sportsDb.f1509w);
        }
        return false;
    }

    @NotNull
    /* renamed from: f */
    public final String m58096f() {
        return this.f1500n;
    }

    /* renamed from: f0 */
    public final void m58095f0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1487a = str;
    }

    @NotNull
    /* renamed from: g */
    public final String m58094g() {
        return this.f1501o;
    }

    /* renamed from: g0 */
    public final void m58093g0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1496j = str;
    }

    @NotNull
    /* renamed from: h */
    public final String m58092h() {
        return this.f1502p;
    }

    /* renamed from: h0 */
    public final void m58091h0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1504r = str;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.f1487a.hashCode() * 31) + this.f1488b.hashCode()) * 31) + this.f1489c.hashCode()) * 31) + this.f1490d.hashCode()) * 31) + this.f1491e.hashCode()) * 31) + this.f1492f.hashCode()) * 31) + this.f1493g.hashCode()) * 31) + this.f1494h.hashCode()) * 31) + this.f1495i.hashCode()) * 31) + this.f1496j.hashCode()) * 31) + this.f1497k.hashCode()) * 31) + this.f1498l.hashCode()) * 31) + this.f1499m.hashCode()) * 31) + this.f1500n.hashCode()) * 31) + this.f1501o.hashCode()) * 31) + this.f1502p.hashCode()) * 31) + this.f1503q.hashCode()) * 31) + this.f1504r.hashCode()) * 31) + this.f1505s.hashCode()) * 31) + this.f1506t.hashCode()) * 31) + this.f1507u.hashCode()) * 31) + this.f1508v.hashCode()) * 31) + this.f1509w.hashCode();
    }

    @NotNull
    /* renamed from: i */
    public final String m58090i() {
        return this.f1503q;
    }

    /* renamed from: i0 */
    public final void m58089i0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1509w = str;
    }

    @NotNull
    /* renamed from: j */
    public final String m58088j() {
        return this.f1504r;
    }

    /* renamed from: j0 */
    public final void m58087j0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1498l = str;
    }

    @NotNull
    /* renamed from: k */
    public final String m58086k() {
        return this.f1505s;
    }

    /* renamed from: k0 */
    public final void m58085k0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1508v = str;
    }

    @NotNull
    /* renamed from: l */
    public final String m58084l() {
        return this.f1488b;
    }

    /* renamed from: l0 */
    public final void m58083l0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1490d = str;
    }

    @NotNull
    /* renamed from: m */
    public final String m58082m() {
        return this.f1506t;
    }

    /* renamed from: m0 */
    public final void m58081m0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1489c = str;
    }

    @NotNull
    /* renamed from: n */
    public final String m58080n() {
        return this.f1507u;
    }

    /* renamed from: n0 */
    public final void m58079n0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1503q = str;
    }

    @NotNull
    /* renamed from: o */
    public final String m58078o() {
        return this.f1508v;
    }

    /* renamed from: o0 */
    public final void m58077o0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1491e = str;
    }

    @NotNull
    /* renamed from: p */
    public final String m58076p() {
        return this.f1509w;
    }

    /* renamed from: p0 */
    public final void m58075p0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1497k = str;
    }

    @NotNull
    /* renamed from: q */
    public final String m58074q() {
        return this.f1489c;
    }

    /* renamed from: q0 */
    public final void m58073q0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1501o = str;
    }

    @NotNull
    /* renamed from: r */
    public final String m58072r() {
        return this.f1490d;
    }

    /* renamed from: r0 */
    public final void m58071r0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1488b = str;
    }

    @NotNull
    /* renamed from: s */
    public final String m58070s() {
        return this.f1491e;
    }

    /* renamed from: s0 */
    public final void m58069s0(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1506t = str;
    }

    @NotNull
    /* renamed from: t */
    public final String m58068t() {
        return this.f1492f;
    }

    @NotNull
    public String toString() {
        return "SportsDb(identify=" + this.f1487a + ", userNumber=" + this.f1488b + ", sportsType=" + this.f1489c + ", sportsSet=" + this.f1490d + ", startTime=" + this.f1491e + ", endTime=" + this.f1492f + ", countTime=" + this.f1493g + ", distance=" + this.f1494h + ", gpsDistance=" + this.f1495i + ", latLngList=" + this.f1496j + ", stepList=" + this.f1497k + ", passLatLngList=" + this.f1498l + ", isFaceOut=" + this.f1499m + ", faceDetectCount=" + this.f1500n + ", uploadType=" + this.f1501o + ", isException=" + this.f1502p + ", startFace=" + this.f1503q + ", midFace=" + this.f1504r + ", endFace=" + this.f1505s + ", isValid=" + this.f1506t + ", faceCheckingDistance=" + this.f1507u + ", pauseLatLng=" + this.f1508v + ", isOpenDevelop=" + this.f1509w + ')';
    }

    @NotNull
    /* renamed from: u */
    public final String m58067u() {
        return this.f1493g;
    }

    @NotNull
    /* renamed from: v */
    public final String m58066v() {
        return this.f1494h;
    }

    @NotNull
    /* renamed from: w */
    public final String m58065w() {
        return this.f1495i;
    }

    @NotNull
    /* renamed from: x */
    public final SportsDb m58064x(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String gpsDistance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType, @NotNull String isException, @NotNull String startFace, @NotNull String midFace, @NotNull String endFace, @NotNull String isValid, @NotNull String faceCheckingDistance, @NotNull String pauseLatLng, @NotNull String isOpenDevelop) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(userNumber, "userNumber");
        C14342f0.m8184p(sportsType, "sportsType");
        C14342f0.m8184p(sportsSet, "sportsSet");
        C14342f0.m8184p(startTime, "startTime");
        C14342f0.m8184p(endTime, "endTime");
        C14342f0.m8184p(countTime, "countTime");
        C14342f0.m8184p(distance, "distance");
        C14342f0.m8184p(gpsDistance, "gpsDistance");
        C14342f0.m8184p(latLngList, "latLngList");
        C14342f0.m8184p(stepList, "stepList");
        C14342f0.m8184p(passLatLngList, "passLatLngList");
        C14342f0.m8184p(isFaceOut, "isFaceOut");
        C14342f0.m8184p(faceDetectCount, "faceDetectCount");
        C14342f0.m8184p(uploadType, "uploadType");
        C14342f0.m8184p(isException, "isException");
        C14342f0.m8184p(startFace, "startFace");
        C14342f0.m8184p(midFace, "midFace");
        C14342f0.m8184p(endFace, "endFace");
        C14342f0.m8184p(isValid, "isValid");
        C14342f0.m8184p(faceCheckingDistance, "faceCheckingDistance");
        C14342f0.m8184p(pauseLatLng, "pauseLatLng");
        C14342f0.m8184p(isOpenDevelop, "isOpenDevelop");
        return new SportsDb(identify, userNumber, sportsType, sportsSet, startTime, endTime, countTime, distance, gpsDistance, latLngList, stepList, passLatLngList, isFaceOut, faceDetectCount, uploadType, isException, startFace, midFace, endFace, isValid, faceCheckingDistance, pauseLatLng, isOpenDevelop);
    }

    @NotNull
    /* renamed from: z */
    public final String m58062z() {
        return this.f1493g;
    }
}
