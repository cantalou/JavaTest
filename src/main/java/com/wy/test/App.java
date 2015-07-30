package com.wy.test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args) throws Exception
    {
        Object[] objs = new Object[7];
        objs[0] = 1;
        objs[1] = "o2";
        objs[2] = new int[]{1, 2, 3};
        objs[3] = new String[]{"a", "b", "c"};
        objs[4] = new int[][]{{1, 2, 3}, {1, 2, 3}};
        objs[5] = new ArrayList<String>()
        {{
                add("list1");
                add("list2");
            }};
        objs[6] = new HashMap<String, String>()
        {{
                put("key1", "value1");
                put("key2", "value2");
            }};
        System.out.println(replace("{}\n{}\n{}\n{}\n{}\n{}\n{}", objs));
    }

    /**
     * 将Object数组转换成String数组
     *
     * @return String数组
     */
    private static String replace(String msg, Object[] args)
    {
        if (msg.indexOf("{}") == -1)
        {
            return msg;

        }
        StringBuilder sb = new StringBuilder(msg);
        int index = 0;
        for (Object arg : args)
        {
            index = sb.indexOf("{}");
            if (index == -1)
            {
                break;
            }
            sb.replace(index, index + 2, toString(arg));
        }
        return sb.toString();
    }

    private static String toString(Object obj)
    {
        if (obj == null)
        {
            return "null";
        }
        else if (obj.getClass()
                    .isArray())
        {

            int len = Array.getLength(obj);
            if (len > 0)
            {
                StringBuilder sb = new StringBuilder("[");
                sb.append(toString(Array.get(obj, 0)));
                for (int i = 1; i < len; i++)
                {
                    sb.append(",")
                      .append(toString(Array.get(obj, i)));
                }
                sb.append("]");
                return sb.toString();
            }
            else
            {
                return "[]";
            }
        }
        else
        {
            return obj.toString();
        }
    }
}
