package com.kwad.sdk.components;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ComponentsNotFoundException extends IllegalStateException {
    private static final String MESSAGE = "\u7ec4\u4ef6\u672a\u96c6\u6210/\u672a\u52a0\u8f7d\uff0c\u5982\u9700\u8981\u8be5\u90e8\u5206\u7684\u529f\u80fd\uff0c\u8bf7\u96c6\u6210\u540e\u91cd\u8bd5";
    private static final long serialVersionUID = -2648461538415997941L;

    public ComponentsNotFoundException(String str) {
        this(str, null);
    }

    public ComponentsNotFoundException(String str, Throwable th) {
        super(str + "\u7ec4\u4ef6\u672a\u96c6\u6210/\u672a\u52a0\u8f7d\uff0c\u5982\u9700\u8981\u8be5\u90e8\u5206\u7684\u529f\u80fd\uff0c\u8bf7\u96c6\u6210\u540e\u91cd\u8bd5", th);
    }
}
