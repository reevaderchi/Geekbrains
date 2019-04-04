package Lesson_5;

import java.util.Arrays;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.System.currentTimeMillis;

public class ThreadMain {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int THREADS_COUNT = 16;
        // определяем размерность двумерного массива
        final int PART_SIZE = SIZE / THREADS_COUNT;
        float[] mas = new float[SIZE];
        Arrays.fill(mas, 1f);
        long a = currentTimeMillis();
        // разделяем данные
        final float[][] m = new float[THREADS_COUNT][PART_SIZE];
        // создадим массив потоков
        Thread[] t = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            // будем копировать в двумерный массив данные из основного потока со сдвигом
            System.arraycopy(mas, PART_SIZE * i, m[i], 0, PART_SIZE);
            final int u = i;
            t[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // считаем массив со сдвигом
                    int n = u * PART_SIZE;
                    for (int j = 0; j < PART_SIZE; j++, n++) {
                        m[u][j] = (float) (m[u][j] * sin(0.2f + n / 5) * cos(0.2f + n / 5) * cos(0.4f + n / 2));
                    }
                }
            });
            t[i].start();
        }
        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                t[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // складываем массив обратно в исходный массив
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(m[i], 0, mas, i * PART_SIZE, PART_SIZE);
        }
        // определяем время
        System.out.println(currentTimeMillis() - a);
    }
}





















//class MyThread implements Runnable{
//
//    float[] arr;
//
//    public MyThread(float[] inArr){
//        arr = inArr;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < arr.length; i++){
//            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//    }
//
//    public float[] getArr(){
//        return arr;
//    }
//}
//
//    ///////////////
//
//
//    статичный метод
//    static void reCalculate(float[] array){
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//    }
//
//
//    ////////////////
//    два метода для двух потоков
//
//static void forOneArr(float arr[]) {// метод для большого массива
//        long a = System.currentTimeMillis();
//        for (int f = 0; f < arr.length; f++) {
//        arr[f] = (float) (arr[f] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
//        }
//        System.out.println("Время обработки через один массив: " + (System.currentTimeMillis() - a));
//        }

//static void forTwoArr(float arr[]) { // метод для малых массивов без присвоения 1 и вывода времени
//        for (int f = 0; f < arr.length; f++) {
//        arr[f] = (float) (arr[f] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
//        }
//        }
//

//        ///////////
//
//
//
//
//        сдвиг
//
//
//        Thread t1 = new Thread(new Runnable() {
//@Override
//public void run() {
//        for (int i = 0; i < HALF; i++) {
//        halfArray1[i] = (float)(halfArray1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        System.out.println("Время заполнения первой половины массива - " + (System.currentTimeMillis() - time2) + "мс");
//        }
//        });
//        Thread t2 = new Thread(new Runnable() {
//@Override
//public void run() {
//        for (int i = 0; i < HALF; i++) {
//        halfArray2[i] = (float)(halfArray2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        System.out.println("Время заполнения второй половины массива - " + (System.currentTimeMillis() - time2) + "мс");
//        }
//        });
//        t1.start();
//        t2.start();
//
//
//        //////////
//
//
//
//
//        Thread t1 = new Thread(new Runnable() {
//@Override
//public void run() {
//        arrayChanger(a1);
//        }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//@Override
//public void run() {
//        arrayChanger(a2);
//        }
//        });
//
//// изменение содержимого массива
//private float[] arrayChanger(float[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//        arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        return arr;
//        }
//
//
////////////////////////