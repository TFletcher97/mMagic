package net.tpf.magic.UTIL;

public class Util {

    private static Util util = null;

    public static Util getInstance(){
        if (util == null){
            util = new Util();
        }
        return util;
    }

}
