package p027c0;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(tableName = "menu")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\bC\u0010DJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J\u008b\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0002HÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010$\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010$\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010$\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010$\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010$\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010$\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(¨\u0006E"}, m12616d2 = {"Lc0/b;", "", "", "a", "f", "g", "h", "i", "j", "", "k", C7304t.f25048d, "m", "b", "c", "d", "e", "mkey", "name", RewardPlus.ICON, "iconS", "isShow", "isEnabled", "isLogin", "linkUrl", "type", "lastUploadTime", "sort", "isShowIndex", "homeSort", "n", "toString", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "I", "(Ljava/lang/String;)V", "v", "J", CampaignEx.JSON_KEY_AD_Q, "D", "r", ExifInterface.LONGITUDE_EAST, UMCommonContent.f37777aG, "K", "x", "B", "y", "()I", "H", "(I)V", UMCommonContent.f37782aL, "G", "getType", "N", "s", "F", IAdInterListener.AdReqParam.WIDTH, "M", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "L", "p", "C", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: c0.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MenuDb {
    @PrimaryKey
    @ColumnInfo(name = "mkey", typeAffinity = 2)
    @NotNull

    /* renamed from: a */
    private String f1474a;
    @ColumnInfo(name = "name", typeAffinity = 2)
    @NotNull

    /* renamed from: b */
    private String f1475b;
    @ColumnInfo(name = RewardPlus.ICON, typeAffinity = 2)
    @NotNull

    /* renamed from: c */
    private String f1476c;
    @ColumnInfo(name = "iconS", typeAffinity = 2)
    @NotNull

    /* renamed from: d */
    private String f1477d;
    @ColumnInfo(name = "isShow", typeAffinity = 2)
    @NotNull

    /* renamed from: e */
    private String f1478e;
    @ColumnInfo(name = "isEnabled", typeAffinity = 2)
    @NotNull

    /* renamed from: f */
    private String f1479f;
    @ColumnInfo(name = "isLogin", typeAffinity = 3)

    /* renamed from: g */
    private int f1480g;
    @ColumnInfo(name = "linkUrl", typeAffinity = 2)
    @NotNull

    /* renamed from: h */
    private String f1481h;
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull

    /* renamed from: i */
    private String f1482i;
    @ColumnInfo(name = "lastUploadTime", typeAffinity = 2)
    @NotNull

    /* renamed from: j */
    private String f1483j;
    @ColumnInfo(name = "sort", typeAffinity = 2)
    @NotNull

    /* renamed from: k */
    private String f1484k;
    @ColumnInfo(name = "isShowIndex", typeAffinity = 2)
    @NotNull

    /* renamed from: l */
    private String f1485l;
    @ColumnInfo(name = "homeSort", typeAffinity = 2)
    @NotNull

    /* renamed from: m */
    private String f1486m;

    public MenuDb(@NotNull String mkey, @NotNull String name, @NotNull String icon, @NotNull String iconS, @NotNull String isShow, @NotNull String isEnabled, int i, @NotNull String linkUrl, @NotNull String type, @NotNull String lastUploadTime, @NotNull String sort, @NotNull String isShowIndex, @NotNull String homeSort) {
        C14342f0.m8184p(mkey, "mkey");
        C14342f0.m8184p(name, "name");
        C14342f0.m8184p(icon, "icon");
        C14342f0.m8184p(iconS, "iconS");
        C14342f0.m8184p(isShow, "isShow");
        C14342f0.m8184p(isEnabled, "isEnabled");
        C14342f0.m8184p(linkUrl, "linkUrl");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(lastUploadTime, "lastUploadTime");
        C14342f0.m8184p(sort, "sort");
        C14342f0.m8184p(isShowIndex, "isShowIndex");
        C14342f0.m8184p(homeSort, "homeSort");
        this.f1474a = mkey;
        this.f1475b = name;
        this.f1476c = icon;
        this.f1477d = iconS;
        this.f1478e = isShow;
        this.f1479f = isEnabled;
        this.f1480g = i;
        this.f1481h = linkUrl;
        this.f1482i = type;
        this.f1483j = lastUploadTime;
        this.f1484k = sort;
        this.f1485l = isShowIndex;
        this.f1486m = homeSort;
    }

    @NotNull
    /* renamed from: A */
    public final String m58172A() {
        return this.f1485l;
    }

    /* renamed from: B */
    public final void m58171B(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1479f = str;
    }

    /* renamed from: C */
    public final void m58170C(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1486m = str;
    }

    /* renamed from: D */
    public final void m58169D(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1476c = str;
    }

    /* renamed from: E */
    public final void m58168E(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1477d = str;
    }

    /* renamed from: F */
    public final void m58167F(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1483j = str;
    }

    /* renamed from: G */
    public final void m58166G(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1481h = str;
    }

    /* renamed from: H */
    public final void m58165H(int i) {
        this.f1480g = i;
    }

    /* renamed from: I */
    public final void m58164I(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1474a = str;
    }

    /* renamed from: J */
    public final void m58163J(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1475b = str;
    }

    /* renamed from: K */
    public final void m58162K(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1478e = str;
    }

    /* renamed from: L */
    public final void m58161L(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1485l = str;
    }

    /* renamed from: M */
    public final void m58160M(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1484k = str;
    }

    /* renamed from: N */
    public final void m58159N(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1482i = str;
    }

    @NotNull
    /* renamed from: a */
    public final String m58158a() {
        return this.f1474a;
    }

    @NotNull
    /* renamed from: b */
    public final String m58157b() {
        return this.f1483j;
    }

    @NotNull
    /* renamed from: c */
    public final String m58156c() {
        return this.f1484k;
    }

    @NotNull
    /* renamed from: d */
    public final String m58155d() {
        return this.f1485l;
    }

    @NotNull
    /* renamed from: e */
    public final String m58154e() {
        return this.f1486m;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MenuDb) {
            MenuDb menuDb = (MenuDb) obj;
            return C14342f0.m8193g(this.f1474a, menuDb.f1474a) && C14342f0.m8193g(this.f1475b, menuDb.f1475b) && C14342f0.m8193g(this.f1476c, menuDb.f1476c) && C14342f0.m8193g(this.f1477d, menuDb.f1477d) && C14342f0.m8193g(this.f1478e, menuDb.f1478e) && C14342f0.m8193g(this.f1479f, menuDb.f1479f) && this.f1480g == menuDb.f1480g && C14342f0.m8193g(this.f1481h, menuDb.f1481h) && C14342f0.m8193g(this.f1482i, menuDb.f1482i) && C14342f0.m8193g(this.f1483j, menuDb.f1483j) && C14342f0.m8193g(this.f1484k, menuDb.f1484k) && C14342f0.m8193g(this.f1485l, menuDb.f1485l) && C14342f0.m8193g(this.f1486m, menuDb.f1486m);
        }
        return false;
    }

    @NotNull
    /* renamed from: f */
    public final String m58153f() {
        return this.f1475b;
    }

    @NotNull
    /* renamed from: g */
    public final String m58152g() {
        return this.f1476c;
    }

    @NotNull
    public final String getType() {
        return this.f1482i;
    }

    @NotNull
    /* renamed from: h */
    public final String m58151h() {
        return this.f1477d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f1474a.hashCode() * 31) + this.f1475b.hashCode()) * 31) + this.f1476c.hashCode()) * 31) + this.f1477d.hashCode()) * 31) + this.f1478e.hashCode()) * 31) + this.f1479f.hashCode()) * 31) + this.f1480g) * 31) + this.f1481h.hashCode()) * 31) + this.f1482i.hashCode()) * 31) + this.f1483j.hashCode()) * 31) + this.f1484k.hashCode()) * 31) + this.f1485l.hashCode()) * 31) + this.f1486m.hashCode();
    }

    @NotNull
    /* renamed from: i */
    public final String m58150i() {
        return this.f1478e;
    }

    @NotNull
    /* renamed from: j */
    public final String m58149j() {
        return this.f1479f;
    }

    /* renamed from: k */
    public final int m58148k() {
        return this.f1480g;
    }

    @NotNull
    /* renamed from: l */
    public final String m58147l() {
        return this.f1481h;
    }

    @NotNull
    /* renamed from: m */
    public final String m58146m() {
        return this.f1482i;
    }

    @NotNull
    /* renamed from: n */
    public final MenuDb m58145n(@NotNull String mkey, @NotNull String name, @NotNull String icon, @NotNull String iconS, @NotNull String isShow, @NotNull String isEnabled, int i, @NotNull String linkUrl, @NotNull String type, @NotNull String lastUploadTime, @NotNull String sort, @NotNull String isShowIndex, @NotNull String homeSort) {
        C14342f0.m8184p(mkey, "mkey");
        C14342f0.m8184p(name, "name");
        C14342f0.m8184p(icon, "icon");
        C14342f0.m8184p(iconS, "iconS");
        C14342f0.m8184p(isShow, "isShow");
        C14342f0.m8184p(isEnabled, "isEnabled");
        C14342f0.m8184p(linkUrl, "linkUrl");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(lastUploadTime, "lastUploadTime");
        C14342f0.m8184p(sort, "sort");
        C14342f0.m8184p(isShowIndex, "isShowIndex");
        C14342f0.m8184p(homeSort, "homeSort");
        return new MenuDb(mkey, name, icon, iconS, isShow, isEnabled, i, linkUrl, type, lastUploadTime, sort, isShowIndex, homeSort);
    }

    @NotNull
    /* renamed from: p */
    public final String m58143p() {
        return this.f1486m;
    }

    @NotNull
    /* renamed from: q */
    public final String m58142q() {
        return this.f1476c;
    }

    @NotNull
    /* renamed from: r */
    public final String m58141r() {
        return this.f1477d;
    }

    @NotNull
    /* renamed from: s */
    public final String m58140s() {
        return this.f1483j;
    }

    @NotNull
    /* renamed from: t */
    public final String m58139t() {
        return this.f1481h;
    }

    @NotNull
    public String toString() {
        return "MenuDb(mkey=" + this.f1474a + ", name=" + this.f1475b + ", icon=" + this.f1476c + ", iconS=" + this.f1477d + ", isShow=" + this.f1478e + ", isEnabled=" + this.f1479f + ", isLogin=" + this.f1480g + ", linkUrl=" + this.f1481h + ", type=" + this.f1482i + ", lastUploadTime=" + this.f1483j + ", sort=" + this.f1484k + ", isShowIndex=" + this.f1485l + ", homeSort=" + this.f1486m + ')';
    }

    @NotNull
    /* renamed from: u */
    public final String m58138u() {
        return this.f1474a;
    }

    @NotNull
    /* renamed from: v */
    public final String m58137v() {
        return this.f1475b;
    }

    @NotNull
    /* renamed from: w */
    public final String m58136w() {
        return this.f1484k;
    }

    @NotNull
    /* renamed from: x */
    public final String m58135x() {
        return this.f1479f;
    }

    /* renamed from: y */
    public final int m58134y() {
        return this.f1480g;
    }

    @NotNull
    /* renamed from: z */
    public final String m58133z() {
        return this.f1478e;
    }
}
