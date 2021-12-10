package com.producter.demo.utils;

import java.util.Objects;

public final class StringUtils {
    public static boolean isEmptyAndNull(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }
}
