package com.baidu.mobads.sdk.internal;

import java.io.File;
import java.io.FilenameFilter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum br {
    INTERFACE_USE_PROBLEM(1010001, "\u63a5\u53e3\u4f7f\u7528\u95ee\u9898"),
    SHOW_STANDARD_UNFIT(3040001, "\u5bb9\u5668\u5927\u5c0f\u4e0d\u8fbe\u6807");
    

    /* renamed from: c  reason: collision with root package name */
    public static final String f12526c = "msg";

    /* renamed from: d  reason: collision with root package name */
    private int f12528d;

    /* renamed from: e  reason: collision with root package name */
    private String f12529e;

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    br(int i4, String str) {
        this.f12528d = i4;
        this.f12529e = str;
    }

    public int b() {
        return this.f12528d;
    }

    public String c() {
        return this.f12529e;
    }
}
