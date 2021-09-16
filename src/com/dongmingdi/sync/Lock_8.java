package com.dongmingdi.sync;

import java.util.concurrent.TimeUnit;
// synchronized 锁的范围
class Phone {
    public static synchronized void sendSMS() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("--------sendSMS");
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println("--------sendEmail");
    }

    public void getHello() {
        System.out.println("--------getHello");
    }
}

/*
   8个所得问题
   1.先打印短信还是先打印邮件 锁的是当前对象
   --------sendSMS
    --------sendEmail
   2.在短信里停4秒  锁的是当前对象
   --------sendSMS
    --------sendEmail
   3.调用Hello方法 先打印短信还是hello hello 与锁无关
   --------getHello
    --------sendSMS
   4.两部手机先打印短信还是先打印邮件 两个对象各有一把锁
   --------sendEmail
    --------sendSMS
   5.一部手机两个静态同步方法 什么现象  锁的是当前CLASS 字节码对象
   --------sendSMS
    --------sendEmail
   6.两部手机两个静态同步方法 什么现象 锁的是当前CLASS 字节码对象
   --------sendSMS
    --------sendEmail
   7.一部手机一个静态 一个普通同步方法 什么现象 一个锁的CLASS 一个锁的是phone对象
   --------sendEmail
    --------sendSMS
   8.两部手机一个静态 一个普通同步方法 什么现象 一个锁的CLASS 一个锁的是phone1对象
   --------sendEmail
    --------sendSMS
 */
public class Lock_8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(()->{
            try{
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(()->{
            try{
                phone1.sendEmail();
//                phone.getHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
