
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder str = new StringBuilder();
        str.append("{\n ");

        for (int i = 0; i < t.length; i++) {
            str.append(t[i]);
            if (i != t.length - 1) {
                str.append(", ");
                if (i % 4 == 3) {
                    str.append("\n ");
                }
            }

        }
        return str + "\n}";
    }
}
