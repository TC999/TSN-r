package c0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6329136.dex
 */
/* compiled from: MenuDb.kt */
@Entity(tableName = "menu")
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0002H\u00c6\u0003J\u008b\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u001f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010 \u001a\u00020\tH\u00d6\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010$\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010$\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010$\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010$\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010$\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010$\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(\u00a8\u0006E"}, d2 = {"Lc0/b;", "", "", "a", "f", "g", "h", "i", "j", "", "k", "l", "m", "b", "c", "d", "e", "mkey", "name", RewardPlus.ICON, "iconS", "isShow", "isEnabled", "isLogin", "linkUrl", "type", "lastUploadTime", "sort", "isShowIndex", "homeSort", "n", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "I", "(Ljava/lang/String;)V", "v", "J", CampaignEx.JSON_KEY_AD_Q, "D", "r", "E", "z", "K", "x", "B", "y", "()I", "H", "(I)V", "t", "G", "getType", "N", "s", "F", "w", "M", "A", "L", "p", "C", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b {
    @PrimaryKey
    @ColumnInfo(name = "mkey", typeAffinity = 2)
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private String f1473a;
    @ColumnInfo(name = "name", typeAffinity = 2)
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f1474b;
    @ColumnInfo(name = RewardPlus.ICON, typeAffinity = 2)
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f1475c;
    @ColumnInfo(name = "iconS", typeAffinity = 2)
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private String f1476d;
    @ColumnInfo(name = "isShow", typeAffinity = 2)
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private String f1477e;
    @ColumnInfo(name = "isEnabled", typeAffinity = 2)
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private String f1478f;
    @ColumnInfo(name = "isLogin", typeAffinity = 3)

    /* renamed from: g  reason: collision with root package name */
    private int f1479g;
    @ColumnInfo(name = "linkUrl", typeAffinity = 2)
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private String f1480h;
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f1481i;
    @ColumnInfo(name = "lastUploadTime", typeAffinity = 2)
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private String f1482j;
    @ColumnInfo(name = "sort", typeAffinity = 2)
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private String f1483k;
    @ColumnInfo(name = "isShowIndex", typeAffinity = 2)
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private String f1484l;
    @ColumnInfo(name = "homeSort", typeAffinity = 2)
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private String f1485m;

    public b(@NotNull String mkey, @NotNull String name, @NotNull String icon, @NotNull String iconS, @NotNull String isShow, @NotNull String isEnabled, int i4, @NotNull String linkUrl, @NotNull String type, @NotNull String lastUploadTime, @NotNull String sort, @NotNull String isShowIndex, @NotNull String homeSort) {
        f0.p(mkey, "mkey");
        f0.p(name, "name");
        f0.p(icon, "icon");
        f0.p(iconS, "iconS");
        f0.p(isShow, "isShow");
        f0.p(isEnabled, "isEnabled");
        f0.p(linkUrl, "linkUrl");
        f0.p(type, "type");
        f0.p(lastUploadTime, "lastUploadTime");
        f0.p(sort, "sort");
        f0.p(isShowIndex, "isShowIndex");
        f0.p(homeSort, "homeSort");
        this.f1473a = mkey;
        this.f1474b = name;
        this.f1475c = icon;
        this.f1476d = iconS;
        this.f1477e = isShow;
        this.f1478f = isEnabled;
        this.f1479g = i4;
        this.f1480h = linkUrl;
        this.f1481i = type;
        this.f1482j = lastUploadTime;
        this.f1483k = sort;
        this.f1484l = isShowIndex;
        this.f1485m = homeSort;
    }

    @NotNull
    public final String A() {
        return this.f1484l;
    }

    public final void B(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1478f = str;
    }

    public final void C(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1485m = str;
    }

    public final void D(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1475c = str;
    }

    public final void E(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1476d = str;
    }

    public final void F(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1482j = str;
    }

    public final void G(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1480h = str;
    }

    public final void H(int i4) {
        this.f1479g = i4;
    }

    public final void I(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1473a = str;
    }

    public final void J(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1474b = str;
    }

    public final void K(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1477e = str;
    }

    public final void L(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1484l = str;
    }

    public final void M(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1483k = str;
    }

    public final void N(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1481i = str;
    }

    @NotNull
    public final String a() {
        return this.f1473a;
    }

    @NotNull
    public final String b() {
        return this.f1482j;
    }

    @NotNull
    public final String c() {
        return this.f1483k;
    }

    @NotNull
    public final String d() {
        return this.f1484l;
    }

    @NotNull
    public final String e() {
        return this.f1485m;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return f0.g(this.f1473a, bVar.f1473a) && f0.g(this.f1474b, bVar.f1474b) && f0.g(this.f1475c, bVar.f1475c) && f0.g(this.f1476d, bVar.f1476d) && f0.g(this.f1477e, bVar.f1477e) && f0.g(this.f1478f, bVar.f1478f) && this.f1479g == bVar.f1479g && f0.g(this.f1480h, bVar.f1480h) && f0.g(this.f1481i, bVar.f1481i) && f0.g(this.f1482j, bVar.f1482j) && f0.g(this.f1483k, bVar.f1483k) && f0.g(this.f1484l, bVar.f1484l) && f0.g(this.f1485m, bVar.f1485m);
        }
        return false;
    }

    @NotNull
    public final String f() {
        return this.f1474b;
    }

    @NotNull
    public final String g() {
        return this.f1475c;
    }

    @NotNull
    public final String getType() {
        return this.f1481i;
    }

    @NotNull
    public final String h() {
        return this.f1476d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f1473a.hashCode() * 31) + this.f1474b.hashCode()) * 31) + this.f1475c.hashCode()) * 31) + this.f1476d.hashCode()) * 31) + this.f1477e.hashCode()) * 31) + this.f1478f.hashCode()) * 31) + this.f1479g) * 31) + this.f1480h.hashCode()) * 31) + this.f1481i.hashCode()) * 31) + this.f1482j.hashCode()) * 31) + this.f1483k.hashCode()) * 31) + this.f1484l.hashCode()) * 31) + this.f1485m.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f1477e;
    }

    @NotNull
    public final String j() {
        return this.f1478f;
    }

    public final int k() {
        return this.f1479g;
    }

    @NotNull
    public final String l() {
        return this.f1480h;
    }

    @NotNull
    public final String m() {
        return this.f1481i;
    }

    @NotNull
    public final b n(@NotNull String mkey, @NotNull String name, @NotNull String icon, @NotNull String iconS, @NotNull String isShow, @NotNull String isEnabled, int i4, @NotNull String linkUrl, @NotNull String type, @NotNull String lastUploadTime, @NotNull String sort, @NotNull String isShowIndex, @NotNull String homeSort) {
        f0.p(mkey, "mkey");
        f0.p(name, "name");
        f0.p(icon, "icon");
        f0.p(iconS, "iconS");
        f0.p(isShow, "isShow");
        f0.p(isEnabled, "isEnabled");
        f0.p(linkUrl, "linkUrl");
        f0.p(type, "type");
        f0.p(lastUploadTime, "lastUploadTime");
        f0.p(sort, "sort");
        f0.p(isShowIndex, "isShowIndex");
        f0.p(homeSort, "homeSort");
        return new b(mkey, name, icon, iconS, isShow, isEnabled, i4, linkUrl, type, lastUploadTime, sort, isShowIndex, homeSort);
    }

    @NotNull
    public final String p() {
        return this.f1485m;
    }

    @NotNull
    public final String q() {
        return this.f1475c;
    }

    @NotNull
    public final String r() {
        return this.f1476d;
    }

    @NotNull
    public final String s() {
        return this.f1482j;
    }

    @NotNull
    public final String t() {
        return this.f1480h;
    }

    @NotNull
    public String toString() {
        return "MenuDb(mkey=" + this.f1473a + ", name=" + this.f1474b + ", icon=" + this.f1475c + ", iconS=" + this.f1476d + ", isShow=" + this.f1477e + ", isEnabled=" + this.f1478f + ", isLogin=" + this.f1479g + ", linkUrl=" + this.f1480h + ", type=" + this.f1481i + ", lastUploadTime=" + this.f1482j + ", sort=" + this.f1483k + ", isShowIndex=" + this.f1484l + ", homeSort=" + this.f1485m + ')';
    }

    @NotNull
    public final String u() {
        return this.f1473a;
    }

    @NotNull
    public final String v() {
        return this.f1474b;
    }

    @NotNull
    public final String w() {
        return this.f1483k;
    }

    @NotNull
    public final String x() {
        return this.f1478f;
    }

    public final int y() {
        return this.f1479g;
    }

    @NotNull
    public final String z() {
        return this.f1477e;
    }
}
