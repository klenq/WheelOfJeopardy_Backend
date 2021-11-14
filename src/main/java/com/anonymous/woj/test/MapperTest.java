package com.anonymous.woj.test;

import com.anonymous.woj.bean.Questions;
import com.anonymous.woj.bean.QuestionsExample;
import com.anonymous.woj.dao.AnswersMapper;
import com.anonymous.woj.dao.CategoriesMapper;
import com.anonymous.woj.dao.QuestionsMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/14
 */
@RunWith(SpringJUnit4ClassRunner.class) //AutoWired after setting
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //location of spring configuration
public class MapperTest {

    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    QuestionsMapper questionsMapper;
    @Autowired
    AnswersMapper answersMapper;

    @Autowired
    SqlSession sqlSession;
    /**
     *
     */
    @Test
    public void testSelect(){

        QuestionsExample questionsExample  = new QuestionsExample();
        QuestionsExample.Criteria criteria = questionsExample.createCriteria();
        criteria.andQuestionidEqualTo(2);
        List<Questions> questions = questionsMapper.selectByExample(questionsExample);
        Questions question1 = questions.get(0);
        System.out.println(question1);
        System.out.println(question1.getCategoryid());
        System.out.println(question1.getPointvalue());
        System.out.println(question1.getQuestion());
        System.out.println("finished");


    }

}
