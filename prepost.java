import java.io.*;

class prepost {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        try {
            System.out.print("Enter prefix : ");
            in = br.readLine();
        } catch (IOException e) {
        }
        Stack stack = new Stack(in.length());
        char[] temp = in.toCharArray();
        for (int i = in.length() - 1; i >= 0; i--) {
            switch (temp[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    String a = stack.pop();
                    String b = stack.pop();
                    stack.insert(a + b + temp[i]);
                    break;
                default:
                    stack.insert(String.valueOf(temp[i]));
                    break;
            }

        }

        System.out.println(stack.pop());
    }
}
