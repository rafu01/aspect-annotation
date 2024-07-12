package com.aspectannotation.util;

import com.aspectannotation.annotations.Read;
import com.aspectannotation.annotations.Write;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ReadWriteUtil {
    public static boolean write(Object data) {

        try {
            // write to master node in async or sync way
            //CompletableFuture.supplyAsync(() -> );
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Object read(Object indexKey) {

        try {
            // write to master node in async or sync way
            //CompletableFuture.supplyAsync(() -> );
            return new Object();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}