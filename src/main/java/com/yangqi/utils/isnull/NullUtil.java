package com.yangqi.utils.isnull;

/**
 * The type Null util.
 *
 * @author Yankee
 * @date 2020 /3/13 17:39
 */
public class NullUtil {
    /**
     * Is null boolean.
     * <p>
     * NullUtil.isNull(null) = true
     * NullUtil.isNull("") = true
     * NullUtil.isNull("  ") = true
     * </p>
     *
     * @param obj the obj
     * @return the boolean
     */
    public static boolean isNull(Object obj) {
        return obj == null || "".equals(obj.toString().trim());
    }
}
