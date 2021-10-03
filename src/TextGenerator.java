import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextGenerator {

    public static void main(String[] args) {

        Scanner scstr = new Scanner(System.in);
        Scanner scint = new Scanner(System.in);

        System.out.print("username : ");
        String username = scstr.next();

        System.out.print("password : ");
        String password = scstr.next();

        System.out.println("default browser of chrome ?\n1.default browser\n2.chrome");
        boolean chrome = scint.nextInt()==2;
        String browser = "";
        if (chrome) {
            browser = "START chrome \"https://elearning3.nit.ac.ir/home/index/\"\n";
        } else {
            browser = "START https://elearning3.nit.ac.ir/home/index/\n";
        }

        String text1 = "@if (@CodeSection == @Batch) @then\n" +
            "\n" +
            "\n" +
            "@echo off\n" +
            "set SendKeys=CScript //nologo //E:JScript \"%~F0\"\n" +
            browser +
            "timeout /t 5\n" +
            "%SendKeys% \"{TAB}\"\n";
        String text2 = "%SendKeys% \"{ENTER}\"\n" +
            "timeout /t 5\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{TAB}\"\n" +
            "%SendKeys% \"{ENTER}\"\n" +
            "\n" +
            "goto :EOF\n" +
            "\n" +
            "\n" +
            "@end\n" +
            "// JScript section\n" +
            "\n" +
            "var WshShell = WScript.CreateObject(\"WScript.Shell\");\n" +
            "WshShell.SendKeys(WScript.Arguments(0));";

        String[] user = username.split("");
        String[] pass = password.split("");

        for (int i = 0; i < user.length; i++) {
            text1 += "%SendKeys% \"{"+user[i]+"}\"\n";
        }

        text1 += "%SendKeys% \"{TAB}\"\n";

        for (int i = 0; i < pass.length; i++) {
            text1 += "%SendKeys% \"{"+pass[i]+"}\"\n";
        }

        String text = text1+text2;

        try (FileWriter writer = new FileWriter("auto_class.bat");
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(text);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
}
