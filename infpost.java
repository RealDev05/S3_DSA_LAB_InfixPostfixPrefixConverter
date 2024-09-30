import java.io.*;

class infpost {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        try {
            System.out.print("Enter infix : ");
            in = br.readLine();
        } catch (IOException e) {
        }
        Stack stack = new Stack(in.length());
        String out = "";
        char[] temp = in.toCharArray();
        for (int i = 0; i < in.length(); i++) {
            switch (temp[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    if (!stack.isEmpty()) {
                        String item = stack.pop();
                        if (item != "(") {
                            while (item != null && operatorValue(item) >= operatorValue(String.valueOf(temp[i]))
                                    && item != "(") {
                                out += item;
                                item = stack.pop();
                            }
                        }
                        if (item != null) {
                            stack.insert(String.valueOf(item));
                        }
                    }

                    stack.insert(String.valueOf(temp[i]));
                    break;
                case '(':
                    stack.insert(String.valueOf(temp[i]));
                    break;
                case ')':
                    String item = stack.pop();
                    while (!item.equals("(")) {
                        out += item;
                        item = stack.pop();
                        if (item == null) {
                            break;
                        }
                    }
                    break;
                default:
                    out += temp[i];
                    break;
            }

        }
        while (!stack.isEmpty()) {
            String item = stack.pop();
            out += item;
        }
        System.out.println(out);
    }

    static int operatorValue(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            case "^":
                return 2;
            default:
                return -1;
        }
    }
}