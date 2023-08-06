package s5_stack_queue.p3_크레인인형뽑기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        int[][] board = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                board[i][j] = in.nextInt();
            }
        }
        int M = in.nextInt();
        int[] moves = new int[M];
        for(int i=0; i< M; ++i) {
            moves[i] = in.nextInt();
        }
        System.out.println(sol(N, M, board, moves));
        return ;
    }

    public static int sol(int N, int M, int[][] board, int[] moves){
        int answer = 0;
        int elem = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < M; i++){
            for(int j=0; j< N; j++){
                if(board[j][moves[i]-1] != 0){
                    elem = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;
                    if(stack.empty()){
                        stack.push(elem);
                    } else {
                        if(stack.peek() == elem){
                            stack.pop();
                            answer+=2;
                        } else {
                            stack.push(elem);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
