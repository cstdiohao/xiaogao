package com.nihao.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("aaa")
public class Main {
    @Autowired
    private MyTestBean myTestBean;

    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
        MyBean myBean = (MyBean) beanFactory.getBean("myBean");
        System.out.println(myBean.getMyTestBean().getName());
    }

    @RequestMapping(value = "name", method = RequestMethod.GET)
    @ResponseBody
    public String getName(){
        return myTestBean.getName();
    }
}
