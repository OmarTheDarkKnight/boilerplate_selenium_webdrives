package com.bat.webdrivers;

import org.springframework.util.StringUtils;

public abstract class BaseWebDriver {
    public BaseWebDriver() {}

    protected static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }
}
