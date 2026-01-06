package Linked_List.Adapter;
import java.util.*;
public class ArrTwoStk {
    public static class TwoStk{
        int[] data;
        int tos1;
        int tos2;
        public TwoStk(int cap){
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1(){
            return tos1 + 1 ;
        }

        int size2(){
            return data.length - tos2 ;
        }

        void push1(int val){
            if(tos2 == tos1 + 1){
                System.out.println("Max elements reached");
            }else{
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val){
            if(tos2 == tos1 + 1){
                System.out.println("Max elements reached");
            }else{
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1(){
            if(tos1 == -1){
                System.out.println("Stack 1 is empty");
                return -1 ;
            }else{
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2(){
            if(tos2 == -1){
                System.out.println("Stack 2 is empty");
                return -1 ;
            }else{
                int val = data[tos2];
                tos2--;
                return val;
            }
        }

        int top1(){
            if(tos1 == -1){
                System.out.println("Stack is empty");
                return -1;
            }else{
                return data[tos1];
            }
        }


        int top2(){
            if(tos2 == -1){
                System.out.println("Stack is empty");
                return -1;
            }else{
                return data[tos2];
            }
        }
    }
    public static void main(String[] args){
        TwoStk s = new TwoStk(5);
        s.push1(10);
        s.push2(20);
        s.push1(30);
        s.push2(40);
        s.push1(50);
        s.push2(60);

        System.out.println(s.top1());
        System.out.println(s.top2());

        System.out.println("Removed Element : "+s.pop1());
        System.out.println("Removed Element : "+s.pop2());
       

    }
}
