package com.bxkj.student.common.db;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class HomeMenuDB {
    private String iconResName;
    private int id;
    private String menuName;

    public String getIconResName() {
        return this.iconResName;
    }

    public int getId() {
        return this.id;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public HomeMenuDB setIconResName(String iconResName) {
        this.iconResName = iconResName;
        return this;
    }

    public HomeMenuDB setId(int id) {
        this.id = id;
        return this;
    }

    public HomeMenuDB setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String toString() {
        return "HomeMenuDB{id=" + this.id + ", iconResName='" + this.iconResName + "', menuName='" + this.menuName + "'}";
    }
}
