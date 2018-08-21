package com.scrat.personalvault.framework.util;

import java.util.Collection;

public class CollectionUtil {
    private CollectionUtil() {
        throw new AssertionError("No instances.");
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
