package com.wy.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * Project Name: test<br>
 * File Name:    CollectionsUtil.java<br>
 * ClassName:    CollectionsUtil <br>
 *
 * Description: TODO.<br> 
 * 
 * @author  LinZhiWei  
 * @date    2015年3月18日 下午3:43:02
 * 
 * Copyright (c) 2015年,  Network CO.ltd. All Rights Reserved.
 */
public class CollectionsUtil
{

    /**
     * 
     * @Description: 往dest头部添加数据,并移除已存在的节点
     * @Title: CollectionsUtil.java
     * @date 2015年3月14日 下午2:37:05
     * @author LinZhiWei
     * @param dest
     * @param src
     */
    public static <T> void addFirstAndRemoveOldIfNeed(List<T> dest, List<T> src)
    {
	if (dest == null)
	{
	    return;
	}

	if (src == null || src.isEmpty())
	{
	    return;
	}

	removeDuplicate(dest, src);
	dest.addAll(0, src);
    }

    /**
     * 
     * @Description: 往dest尾部添加数据,并移除已存在的节点
     * @Title: CollectionsUtil.java
     * @date 2015年3月14日 下午2:37:05
     * @author LinZhiWei
     * @param dest
     * @param src
     */
    public static <T> void addTailAndRemoveOldIfNeed(List<T> dest, List<T> src)
    {
	if (dest == null)
	{
	    return;
	}

	if (src == null || src.isEmpty())
	{
	    return;
	}

	removeDuplicate(dest, src);
	if (dest.isEmpty())
	{
	    dest.addAll(src);
	}
	else
	{
	    dest.addAll(dest.size(), src);
	}
    }

    /**
     * 
     * @Description: 从dest中删除存在于src中的节点
     * @Title: CollectionsUtil.java
     * @date 2015年3月14日 下午2:37:05
     * @author LinZhiWei
     * @param dest 目标
     * @param src 源
     */
    @SuppressWarnings("unchecked")
    public static <T> void removeDuplicate(List<T> dest, List<T> src)
    {
	if (dest == null)
	{
	    return;
	}

	if (src == null || src.isEmpty())
	{
	    return;
	}

	int capacity = dest.size() > src.size() ? dest.size() : src.size();
	HashMap<T, Integer> map = new HashMap<T, Integer>(capacity);
	for (int i = 0; i < dest.size(); i++)
	{
	    map.put(dest.get(i), i);
	}

	T[] oldData = (T[]) dest.toArray();
	int length = oldData.length;
	for (T t : src)
	{
	    Integer index = map.get(t);
	    if (index != null)
	    {
		oldData[index] = null;
		length--;
	    }
	}

	T[] removedDuplicate = (T[]) new Object[length];
	int index = 0;
	for (int i = 0; i < oldData.length; i++)
	{
	    if (oldData[i] != null)
	    {
		removedDuplicate[index++] = oldData[i];
	    }
	}

	dest.clear();
	dest.addAll(Arrays.asList(removedDuplicate));
    }
}
