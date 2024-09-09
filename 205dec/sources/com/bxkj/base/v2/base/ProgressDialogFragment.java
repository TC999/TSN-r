package com.bxkj.base.v2.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.R;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ProgressDialogFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0013\u001a\u00020\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010 \"\u0004\b\u001e\u0010!R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%\u00a8\u0006)"}, d2 = {"Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "messageResID", "", "cancelAble", "d", "", "messageStr", "e", "a", "Ljava/lang/String;", "b", "Ljava/lang/Integer;", "messageResId", "Landroid/content/DialogInterface$OnKeyListener;", "c", "Landroid/content/DialogInterface$OnKeyListener;", "()Landroid/content/DialogInterface$OnKeyListener;", "(Landroid/content/DialogInterface$OnKeyListener;)V", "onKeyListener", "msg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvMsg", "<init>", "(Ljava/lang/String;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ProgressDialogFragment extends DialogFragment {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f18507a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Integer f18508b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private DialogInterface.OnKeyListener f18509c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private String f18510d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private TextView f18511e;

    public ProgressDialogFragment() {
        this(null, 1, null);
    }

    public ProgressDialogFragment(@Nullable String str) {
        this.f18507a = str;
        this.f18510d = "Loading...";
    }

    public static /* synthetic */ void f(ProgressDialogFragment progressDialogFragment, FragmentManager fragmentManager, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        progressDialogFragment.d(fragmentManager, i4, z3);
    }

    public static /* synthetic */ void g(ProgressDialogFragment progressDialogFragment, FragmentManager fragmentManager, String str, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        progressDialogFragment.e(fragmentManager, str, z3);
    }

    @Nullable
    public final DialogInterface.OnKeyListener b() {
        return this.f18509c;
    }

    public final void c(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        this.f18509c = onKeyListener;
    }

    public final void d(@NotNull FragmentManager fragmentManager, int i4, boolean z3) {
        f0.p(fragmentManager, "fragmentManager");
        this.f18508b = Integer.valueOf(i4);
        setCancelable(z3);
        show(fragmentManager, "TSNProgressDialogFragment");
    }

    public final void e(@NotNull FragmentManager fragmentManager, @Nullable String str, boolean z3) {
        f0.p(fragmentManager, "fragmentManager");
        try {
            if (fragmentManager.isDestroyed()) {
                return;
            }
            this.f18507a = str;
            setCancelable(z3);
            if (str != null) {
                this.f18510d = str;
                TextView textView = this.f18511e;
                if (textView != null) {
                    textView.setText(str);
                }
            }
            if (isAdded() || isVisible() || isRemoving()) {
                return;
            }
            showNow(fragmentManager, "TSNProgressDialogFragment");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.loadingDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        f0.p(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_progress_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        f0.p(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.tv_msg);
        this.f18511e = textView;
        if (textView != null && textView != null) {
            textView.setText(this.f18510d);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(this.f18509c);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null) {
            return;
        }
        dialog2.setCanceledOnTouchOutside(false);
    }

    public /* synthetic */ ProgressDialogFragment(String str, int i4, u uVar) {
        this((i4 & 1) != 0 ? "loading" : str);
    }
}
