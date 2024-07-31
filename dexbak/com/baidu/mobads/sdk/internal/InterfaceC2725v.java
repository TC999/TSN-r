package com.baidu.mobads.sdk.internal;

import java.util.Observer;

/* renamed from: com.baidu.mobads.sdk.internal.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC2725v {

    /* renamed from: com.baidu.mobads.sdk.internal.v$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2726a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");
        

        /* renamed from: i */
        private int f9132i;

        /* renamed from: j */
        private String f9133j;

        EnumC2726a(int i, String str) {
            this.f9132i = i;
            this.f9133j = str;
        }

        /* renamed from: b */
        public int m50299b() {
            return this.f9132i;
        }

        /* renamed from: c */
        public String m50298c() {
            return this.f9133j;
        }
    }

    /* renamed from: a */
    void mo50316a();

    /* renamed from: a */
    void mo50315a(boolean z);

    void addObserver(Observer observer);

    /* renamed from: b */
    void mo50314b();

    /* renamed from: c */
    void mo50313c();

    /* renamed from: d */
    void mo50312d();

    /* renamed from: e */
    String mo50311e();

    /* renamed from: f */
    String mo50310f();

    /* renamed from: g */
    String mo50309g();

    /* renamed from: h */
    String mo50308h();

    /* renamed from: i */
    String mo50307i();

    /* renamed from: j */
    int mo50306j();

    /* renamed from: k */
    float mo50305k();

    /* renamed from: l */
    EnumC2726a mo50304l();

    /* renamed from: m */
    void mo50303m();

    /* renamed from: n */
    boolean mo50302n();
}
