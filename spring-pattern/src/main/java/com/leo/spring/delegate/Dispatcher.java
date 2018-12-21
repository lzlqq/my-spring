package com.leo.spring.delegate;

public class Dispatcher implements IExecutor {
    IExecutor executor;

    public Dispatcher(IExecutor executor) {
        this.executor = executor;
    }

    //项目经理，虽然也有执行方法
    //但是他的工作职责是不一样的
    //很像适配器，但是适配器是做接口转换的，而委派是转发任务的
    //和代理相比，代理是给业务加统一逻辑的，而不同分层，而委派转发任务
    //装饰模式一般在下列情况使用：
    //  需要扩展一个类的功能或者给你个类增加附加责任；
    //  需要动态的给一个对象增加功能，这些功能可以再动态的撤销；
    //  需要增加有一些基本功能的排列组合而产生非常大量的功能，从而使得继承关系变得不现实。
    //适配器模式一般使用的情况包括：
    //  系统需要使用现有的类，但此类已经不符合系统的需要；
    @Override
    public void doing() {
        this.executor.doing();
    }
}
