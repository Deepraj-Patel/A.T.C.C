import java.util.*;
class FA111{
    enum State{
        q0,q1,q2,q3

    }
    public static boolean accepts(String input){
        State currentState = State.q0;
        StringBuilder path = new StringBuilder("Path : \n");
        path.append(currentState);
        for(char ch:input.toCharArray()){
            
            switch(currentState){
                
                case q0:
                    if(ch == '1'){
                        currentState = State.q1;
                        path.append("--1--q1");
                    }
                    else{
                        currentState = State.q0;
                        path.append("--0--q0");
                    }
                    break;
                case q1:
                    if(ch =='1'){
                        currentState = State.q2;
                        path.append("--1--q2");
                    }
                    else{
                        currentState = State.q0;
                        path.append("--0--q0");
                    }
                    break;
                case q2:
                    if(ch == '1'){
                        currentState = State.q3;
                        path.append("--1--q3");
                    }
                    else{
                        currentState = State.q0;
                        path.append("--0--q0");
                    }
                    break;
                case q3:
                    currentState = State.q3;
                    if(ch == '1'){
                        path.append("--1--q3");
                    }
                    else{
                        path.append("--0--q3");
                    }
                    break;
            }
        }
        System.out.println(path);
        return currentState == State.q3;
    }
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary string : ");
        String input = sc.nextLine();
        boolean accepted = accepts(input);
        if(accepted){
            System.out.println("accepted");
        }
        else{
            System.out.println("Not accepted");
        }
    }
}