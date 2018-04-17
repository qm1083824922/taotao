package com.taotao.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {

    @Test
    public void testPageHelper(){
        //获得mapper代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/config/spring-*.xml");
        TbItemMapper itMapper = applicationContext.getBean(TbItemMapper.class);
        //设置分页
        PageHelper.startPage(1,30);
        //执行查询
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> list = itMapper.selectByExample(tbItemExample);
        //取分页后的结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        long total = pageInfo.getTotal();
        System.out.println(total);
        //一共有多少页
        int pages = pageInfo.getPages();
        System.out.println(pages);
        //每页大小
        int pageSize = pageInfo.getPageSize();
        System.out.println(pageSize);
    }
}
