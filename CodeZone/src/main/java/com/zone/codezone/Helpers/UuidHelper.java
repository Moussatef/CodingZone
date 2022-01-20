package com.zone.codezone.Helpers;

import java.util.UUID;

public class UuidHelper {

    public static String getUuiId(){
       return  UUID.randomUUID().toString();
    }
}
