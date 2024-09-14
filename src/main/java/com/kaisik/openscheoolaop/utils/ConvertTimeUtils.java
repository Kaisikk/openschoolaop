package com.kaisik.openscheoolaop.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertTimeUtils {

    /**
     * Конвертация миллисекунд в секунды
     *
     * @param milliseconds
     * @return
     */
    long convertMillisecondsToSeconds(Long milliseconds){
        if(milliseconds == null){
            return 0;
        }
        return milliseconds / 1000;
    }

}
