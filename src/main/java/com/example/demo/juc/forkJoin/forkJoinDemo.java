package com.example.demo.juc.forkJoin;

import com.example.demo.interview.ThreadPool.ThreadPool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class forkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask =new MyTask(0,100);

        ForkJoinPool forkJoinPool= new ForkJoinPool();

        ForkJoinTask<Integer> forkJoinTask =forkJoinPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        forkJoinPool.shutdown();

    }
}


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
class MyTask extends RecursiveTask<Integer>{

    private  static  final  Integer ADJUST_VALUE=10;
    private  int start=0;
    private  int end=0;
    private  int result=0;

    public MyTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end-start)<ADJUST_VALUE){
            for (int i = start; i <=end ; i++) {
                result=result+i;
            }
        }
        else {
            int mid=(start+end)/2;
            MyTask task1=new MyTask(start,mid);
            MyTask task2=new MyTask(mid+1,end);

            task1.fork();
            task2.fork();

           result=task1.join()+task2.join();
        }
        return result;
    }
}