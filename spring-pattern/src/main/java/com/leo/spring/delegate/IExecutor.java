package com.leo.spring.delegate;

/**
 * 要执行的任务标准，只要符合标准就行，不需要关注谁来做
 * 只关心最后结果，做事的人等级比较低，可替代性强
 */
public interface IExecutor {
    //普通员工执行任务
    //在公司中，员工执行任务
    //规定在一周之内必须完成
    void doing();
}
