package com.bxkj.base.p085v2.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.C3801R;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProgressDialogFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0013\u001a\u00020\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010 \"\u0004\b\u001e\u0010!R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010%¨\u0006)"}, m12616d2 = {"Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "messageResID", "", "cancelAble", "d", "", "messageStr", "e", "a", "Ljava/lang/String;", "b", "Ljava/lang/Integer;", "messageResId", "Landroid/content/DialogInterface$OnKeyListener;", "c", "Landroid/content/DialogInterface$OnKeyListener;", "()Landroid/content/DialogInterface$OnKeyListener;", "(Landroid/content/DialogInterface$OnKeyListener;)V", "onKeyListener", "msg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvMsg", "<init>", "(Ljava/lang/String;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.ProgressDialogFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ProgressDialogFragment extends DialogFragment {
    @Nullable

    /* renamed from: a */
    private String f15023a;
    @Nullable

    /* renamed from: b */
    private Integer f15024b;
    @Nullable

    /* renamed from: c */
    private DialogInterface.OnKeyListener f15025c;
    @NotNull

    /* renamed from: d */
    private String f15026d;
    @Nullable

    /* renamed from: e */
    private TextView f15027e;

    public ProgressDialogFragment() {
        this(null, 1, null);
    }

    public ProgressDialogFragment(@Nullable String str) {
        this.f15023a = str;
        this.f15026d = "Loading...";
    }

    /* renamed from: f */
    public static /* synthetic */ void m43935f(ProgressDialogFragment progressDialogFragment, FragmentManager fragmentManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        progressDialogFragment.m43937d(fragmentManager, i, z);
    }

    /* renamed from: g */
    public static /* synthetic */ void m43934g(ProgressDialogFragment progressDialogFragment, FragmentManager fragmentManager, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        progressDialogFragment.m43936e(fragmentManager, str, z);
    }

    @Nullable
    /* renamed from: b */
    public final DialogInterface.OnKeyListener m43939b() {
        return this.f15025c;
    }

    /* renamed from: c */
    public final void m43938c(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        this.f15025c = onKeyListener;
    }

    /* renamed from: d */
    public final void m43937d(@NotNull FragmentManager fragmentManager, int i, boolean z) {
        C14342f0.m8184p(fragmentManager, "fragmentManager");
        this.f15024b = Integer.valueOf(i);
        setCancelable(z);
        show(fragmentManager, "TSNProgressDialogFragment");
    }

    /* renamed from: e */
    public final void m43936e(@NotNull FragmentManager fragmentManager, @Nullable String str, boolean z) {
        C14342f0.m8184p(fragmentManager, "fragmentManager");
        try {
            if (fragmentManager.isDestroyed()) {
                return;
            }
            this.f15023a = str;
            setCancelable(z);
            if (str != null) {
                this.f15026d = str;
                TextView textView = this.f15027e;
                if (textView != null) {
                    textView.setText(str);
                }
            }
            if (isAdded() || isVisible() || isRemoving()) {
                return;
            }
            showNow(fragmentManager, "TSNProgressDialogFragment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, C3801R.C3810style.loadingDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C14342f0.m8184p(inflater, "inflater");
        return inflater.inflate(C3801R.C3807layout.fragment_progress_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        C14342f0.m8184p(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(C3801R.C3805id.tv_msg);
        this.f15027e = textView;
        if (textView != null && textView != null) {
            textView.setText(this.f15026d);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(this.f15025c);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null) {
            return;
        }
        dialog2.setCanceledOnTouchOutside(false);
    }

    public /* synthetic */ ProgressDialogFragment(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "loading" : str);
    }
}
