package com.example.demo.juc;

public class Lambda {
    public static void main(String[] args) {


     /*   Foo foo =new Foo() {

            @Override
            public void sayHello() {
                System.out.println("say hello");
            }

            @Override
            public int add(int x, int y) {
                return 0;
            }
        };
        foo.sayHello();*/

       /* Foo f=()->{
            System.out.println("say hello2");
        };
        f.sayHello();*/
      Foo  f2=(int x,int y)->{
          System.out.println("test method");
          return x+y;
      };
        System.out.println(f2.add(3,4));

        f2.sayHello();
    }
}

interface  Foo {
   // public  void sayHello();
    public   int add(int  x,int y);

    //default 方法可以有几种
    public default void sayHello(){
        System.out.println("hey jude");
    }

}