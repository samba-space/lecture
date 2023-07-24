package hello.controller;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DeviceInfoProvider {

    static ThreadLocal<DeviceInfo> a= new ThreadLocal<>();



    static getDevie(){
        a.remove();
    }

        remove



}
