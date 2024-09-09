package com.amap.api.col.s;

import com.amap.api.col.s.cf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PrivacyError.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    public final cf.c f9876a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9877b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: PrivacyError.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9878a;

        static {
            int[] iArr = new int[cf.c.values().length];
            f9878a = iArr;
            try {
                iArr[cf.c.ShowUnknowCode.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9878a[cf.c.ShowNoShowCode.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9878a[cf.c.InfoUnknowCode.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9878a[cf.c.InfoNotContainCode.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9878a[cf.c.AgreeUnknowCode.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9878a[cf.c.AgreeNotAgreeCode.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9878a[cf.c.InvaildUserKeyCode.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9878a[cf.c.IllegalArgument.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9878a[cf.c.SuccessCode.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(cf.c cVar, i1 i1Var) {
        String format;
        this.f9876a = cVar;
        switch (a.f9878a[cVar.ordinal()]) {
            case 1:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u524d\u8bf7\u8bbe\u7f6e\u9690\u79c1\u6743\u653f\u7b56\u662f\u5426\u5f39\u7a97\u544a\u77e5\u7528\u6237", i1Var.d());
                break;
            case 2:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u524d\u8bf7\u786e\u4fdd\u9690\u79c1\u6743\u653f\u7b56\u5df2\u5f39\u7a97\u544a\u77e5\u7528\u6237", i1Var.d());
                break;
            case 3:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u524d\u8bf7\u786e\u4fdd\u8bbe\u7f6e\u9690\u79c1\u6743\u653f\u7b56\u662f\u5426\u5305\u542b\u9ad8\u5fb7\u5f00\u5e73\u9690\u79c1\u6743\u653f\u7b56", i1Var.d());
                break;
            case 4:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u524d\u8bf7\u786e\u4fdd\u9690\u79c1\u6743\u653f\u7b56\u5df2\u7ecf\u5305\u542b\u9ad8\u5fb7\u5f00\u5e73\u9690\u79c1\u6743\u653f\u7b56", i1Var.d());
                break;
            case 5:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u524d\u8bf7\u786e\u4fdd\u8bbe\u7f6e\u9690\u79c1\u6743\u653f\u7b56\u662f\u5426\u53d6\u5f97\u7528\u6237\u540c\u610f", i1Var.d());
                break;
            case 6:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u524d\u8bf7\u786e\u4fdd\u9690\u79c1\u6743\u653f\u7b56\u5df2\u53d6\u5f97\u7528\u6237\u540c\u610f", i1Var.d());
                break;
            case 7:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u4f7f\u7528%s SDK \u529f\u80fd\u4f7f\u7528\u524d\u8bf7\u786e\u4fdd\u5df2\u7ecf\u6b63\u786e\u8bbe\u7f6eapiKey\uff0c\u5982\u6709\u7591\u95ee\u8bf7\u5728\u9ad8\u5fb7\u5f00\u653e\u5e73\u53f0\u5b98\u7f51\u4e2d\u641c\u7d22\u3010INVALID_USER_KEY\u3011\u76f8\u5173\u5185\u5bb9\u8fdb\u884c\u89e3\u51b3\u3002", i1Var.d());
                break;
            case 8:
                format = String.format("***\u786e\u4fdd\u8c03\u7528SDK\u4efb\u4f55\u63a5\u53e3\u524d\u5148\u8c03\u7528\u66f4\u65b0\u9690\u79c1\u5408\u89c4updatePrivacyShow\u3001updatePrivacyAgree\u4e24\u4e2a\u63a5\u53e3\u5e76\u4e14\u53c2\u6570\u503c\u90fd\u4e3atrue\uff0c\u82e5\u672a\u6b63\u786e\u8bbe\u7f6e\u6709\u5d29\u6e83\u98ce\u9669***\n\u53c2\u6570\u975e\u6cd5\uff0ccontext \u6216 sdkInfo\u4e3a\u7a7a", new Object[0]);
                break;
            case 9:
                format = String.format("\u8bbe\u7f6e\u9690\u79c1\u653f\u7b56\u6210\u529f", new Object[0]);
                break;
            default:
                format = "";
                break;
        }
        this.f9877b = format;
    }
}
