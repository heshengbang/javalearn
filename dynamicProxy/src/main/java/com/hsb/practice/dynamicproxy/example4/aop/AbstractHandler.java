package com.hsb.practice.dynamicproxy.example4.aop;/*
 * Copyright ©2011-2016 hsb
 */

import java.lang.reflect.InvocationHandler;

public abstract class AbstractHandler implements InvocationHandler {

    /** The target object. */
    private Object targetObject;

    /**
     * Sets the target object.
     *
     * @param targetObject the new target object
     */
    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * Gets the target object.
     *
     * @return the target object
     */
    public Object getTargetObject() {
        return targetObject;
    }
}
