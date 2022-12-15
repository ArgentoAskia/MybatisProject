package cn.argentoaskia.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MybatisSpringConfigType1.class})
public class MybatisConfigTest {

    @Autowired
    private MybatisSpringConfigType1 mybatisSpringConfigType1;


    @Test
    public void testConfig(){
        System.out.println(mybatisSpringConfigType1);
    }


}
