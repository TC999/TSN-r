package com.bytedance.android.live.base.api.push;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface PushInterceptor {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class InterceptResult {
        public boolean intercept;
        public String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z3) {
            this(z3, "");
        }

        public InterceptResult(boolean z3, String str) {
            this.intercept = z3;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
