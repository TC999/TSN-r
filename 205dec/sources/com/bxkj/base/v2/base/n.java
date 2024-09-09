package com.bxkj.base.v2.base;

import android.app.Dialog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MultiItemTypeSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/base/v2/base/n;", "T", "", "", "position", "t", "a", "(ILjava/lang/Object;)I", "itemType", "b", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface n<T> {

    /* compiled from: LoadingDialog.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class a extends com.bjtsn.dylan.lifecycleobserver.b {
        a() {
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.b
        public void onDestroy() {
            Dialog dialog = n.this.a;
            if (dialog != null && dialog.isShowing()) {
                n.this.a.dismiss();
            }
            super.onDestroy();
        }
    }

    int a(int i4, @Nullable T t3);

    int b(int i4);
}
