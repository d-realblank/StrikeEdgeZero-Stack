import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
public class Part2_B {
    /**
     * Checks for a solution using the Stack ADT
     * @param arr - the array of integers
     * @param n - the number of integers in the array
     * @param currP - the initial position in the array
     * @return true if a solution is found, false otherwise
     */
    public static boolean strikeEdge(int arr[], int n, int initP){
        //creates the boolean visited array of size n
        boolean[] visited = new boolean[n];
        //creates the stack
        Stack stack = new Stack();
        //pushes the first element onto the stack
        stack.push(initP);
        //sets the first element to visited
        visited[initP] = true;
        //while the stack is not empty
        while(!stack.isEmpty()){
            //pops the index off the stack
            int curr = stack.pop();
            //if curr is the last element
            if(curr == n - 1){
                //returns true
                return true;
            }
            //checks right side of the array
            if(curr + arr[curr] < n && !visited[curr + arr[curr]]){
                //pushes the index onto the stack
                stack.push(curr + arr[curr]);
                //sets the index to visited
                visited[curr + arr[curr]] = true;
            }
            //checks left side of the array
            if(curr - arr[curr] >= 0 && !visited[curr - arr[curr]]){
                //pushes the index onto the stack
                stack.push(curr - arr[curr]);
                //sets the index to visited
                visited[curr - arr[curr]] = true;
            }
        }
        //returns false if no solution is found
        return false;
    }
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new File("in.txt"));
            FileWriter fw = new FileWriter("out.txt");
            //reads m
            int m = sc.nextInt();
            //reads the n and start position and arr values
            for(int tests = 0; tests < m; tests++){
                int n = sc.nextInt();
                int initP = sc.nextInt();
                int[] arr = new int[n];
                for(int i = 0; i < n - 1; i++){
                    arr[i] = sc.nextInt();
                }
                arr[n - 1] = 0;
                //checks if there is a solution
                if(strikeEdge(arr, n, initP))
                    fw.write("1\n");
                else
                    fw.write("0\n");
            }
            fw.close();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
}

 
 
