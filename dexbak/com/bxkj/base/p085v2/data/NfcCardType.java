package com.bxkj.base.p085v2.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m12616d2 = {"Lcom/bxkj/base/v2/data/b;", "", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.data.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface NfcCardType {
    @NotNull

    /* renamed from: a */
    public static final C3985a f15186a = C3985a.f15191a;

    /* renamed from: b */
    public static final int f15187b = 0;

    /* renamed from: c */
    public static final int f15188c = 1;

    /* renamed from: d */
    public static final int f15189d = 2;

    /* renamed from: e */
    public static final int f15190e = 3;

    /* compiled from: NfcCardType.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006¨\u0006\u0010"}, m12616d2 = {"Lcom/bxkj/base/v2/data/b$a;", "", "", "a", "", "b", "I", "DEFAULT_CARD_NUMBER", "c", "TSN", "d", "WJXY", "e", "BJKJDX", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.data.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3985a {

        /* renamed from: a */
        static final /* synthetic */ C3985a f15191a = new C3985a();

        /* renamed from: b */
        public static final int f15192b = 0;

        /* renamed from: c */
        public static final int f15193c = 1;

        /* renamed from: d */
        public static final int f15194d = 2;

        /* renamed from: e */
        public static final int f15195e = 3;

        private C3985a() {
        }

        @NotNull
        /* renamed from: a */
        public final String m43633a() {
            int m43650l = LoggedInUser.f15182b.m43634a().m43650l();
            return m43650l != 1 ? m43650l != 2 ? m43650l != 3 ? "默认卡->只读取物理卡号" : "北京科技大学卡->从卡中读取学生学号和姓名" : "外交学院卡->从卡中读取学生学号和姓名" : "体适能卡->从卡中读取学生学号和姓名";
        }
    }
}
