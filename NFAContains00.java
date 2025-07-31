import java.util.Scanner;
import java.util.*;
class NFAContains00{
    enum State{
        q0,q1,q2
    }
    public static boolean NFA(String input){
        Set<State> currentStates = new HashSet<>();
        currentStates.add(State.q0);
        for(int i=0;i<input.length();i++){
            char symbol = input.charAt(i);
            List<String> path = new ArrayList<>();
            Set<State> nextStates = new HashSet<>();
            for(State state: currentStates){
                switch(state){
                    case q0:
                        if(symbol == '0'){
                            nextStates.add(State.q0);
                            nextStates.add(State.q1);
                            path.add("q0------0------q0");
                            path.add("q0------0------q1");
                            
                        }else{
                            nextStates.add(State.q0);
                            path.add("q0------1------q0");
                        }
                        break;
                    case q1:
                        if(symbol == '0'){
                            nextStates.add(State.q2);
                            path.add("q1------0------q2");
                        }
                        break;
                    case q2:
                        nextStates.add(State.q2);
                        path.add("q0------"+symbol+"------q0");
                        path.add("q0------"+symbol+"------q0");
                        break;
                }
            }
            for(String p:path){

                System.out.println(p);
            }
            currentStates = nextStates;
            System.out.println("Active states aftet reading "+symbol+" : ");
            for(State s:currentStates){
                System.out.print("q"+s.name().substring(1)+" ");
            }
            System.out.println("\n");
        }
        return currentStates.contains(State.q2);
    }
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary string : ");
        String input = sc.nextLine();
        
        boolean accepted = NFA(input);
        if(accepted){
            System.out.println("Accepted");
        }
        else{
            System.out.println("not contain 00 as substring");
        }
    }
}