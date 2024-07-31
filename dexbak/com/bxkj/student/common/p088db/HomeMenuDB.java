package com.bxkj.student.common.p088db;

/* renamed from: com.bxkj.student.common.db.HomeMenuDB */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HomeMenuDB {
    private String iconResName;

    /* renamed from: id */
    private int f16164id;
    private String menuName;

    public String getIconResName() {
        return this.iconResName;
    }

    public int getId() {
        return this.f16164id;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public HomeMenuDB setIconResName(String iconResName) {
        this.iconResName = iconResName;
        return this;
    }

    public HomeMenuDB setId(int id) {
        this.f16164id = id;
        return this;
    }

    public HomeMenuDB setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String toString() {
        return "HomeMenuDB{id=" + this.f16164id + ", iconResName='" + this.iconResName + "', menuName='" + this.menuName + "'}";
    }
}
