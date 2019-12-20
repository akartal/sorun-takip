package com.uniyaz.sorun.common;

import java.io.Serializable;

/**
 * Created by AKARTAL on 17.12.2019.
 */
public abstract class BaseDomain implements Serializable {

    public abstract Long getId();

    @Override
    public int hashCode() {
        if (getId() == null) return -1;
        return getId().intValue();
    }

    @Override
    public boolean equals(Object o) {
        BaseDomain baseDomain = (BaseDomain) o;
        if (baseDomain == null || baseDomain.getId() == null) return false;
        return baseDomain.getId().equals(getId());
    }
}
