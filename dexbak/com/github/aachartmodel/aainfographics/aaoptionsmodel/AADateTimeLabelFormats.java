package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AADateTimeLabelFormats.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001f"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "", "()V", "day", "", "getDay", "()Ljava/lang/String;", "setDay", "(Ljava/lang/String;)V", "hour", "getHour", "setHour", "millisecond", "getMillisecond", "setMillisecond", "minute", "getMinute", "setMinute", "month", "getMonth", "setMonth", "second", "getSecond", "setSecond", "week", "getWeek", "setWeek", "year", "getYear", "setYear", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AADateTimeLabelFormats {
    @Nullable
    private String day;
    @Nullable
    private String hour;
    @Nullable
    private String millisecond;
    @Nullable
    private String minute;
    @Nullable
    private String month;
    @Nullable
    private String second;
    @Nullable
    private String week;
    @Nullable
    private String year;

    @NotNull
    public final AADateTimeLabelFormats day(@Nullable String str) {
        this.day = str;
        return this;
    }

    @Nullable
    public final String getDay() {
        return this.day;
    }

    @Nullable
    public final String getHour() {
        return this.hour;
    }

    @Nullable
    public final String getMillisecond() {
        return this.millisecond;
    }

    @Nullable
    public final String getMinute() {
        return this.minute;
    }

    @Nullable
    public final String getMonth() {
        return this.month;
    }

    @Nullable
    public final String getSecond() {
        return this.second;
    }

    @Nullable
    public final String getWeek() {
        return this.week;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    @NotNull
    public final AADateTimeLabelFormats hour(@Nullable String str) {
        this.hour = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats millisecond(@Nullable String str) {
        this.millisecond = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats minute(@Nullable String str) {
        this.minute = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats month(@Nullable String str) {
        this.month = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats second(@Nullable String str) {
        this.second = str;
        return this;
    }

    public final void setDay(@Nullable String str) {
        this.day = str;
    }

    public final void setHour(@Nullable String str) {
        this.hour = str;
    }

    public final void setMillisecond(@Nullable String str) {
        this.millisecond = str;
    }

    public final void setMinute(@Nullable String str) {
        this.minute = str;
    }

    public final void setMonth(@Nullable String str) {
        this.month = str;
    }

    public final void setSecond(@Nullable String str) {
        this.second = str;
    }

    public final void setWeek(@Nullable String str) {
        this.week = str;
    }

    public final void setYear(@Nullable String str) {
        this.year = str;
    }

    @NotNull
    public final AADateTimeLabelFormats week(@Nullable String str) {
        this.week = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats year(@Nullable String str) {
        this.year = str;
        return this;
    }
}
