import java.io.IOException;


public class ExecuteStress {
    public static void newTest() {

        {
            try {
                //Command for Windows
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K \" cd C:\\Users\\PC\\Documents && bash tes_sys.sh");
                //Command for linux
                //Runtime.getRuntime().exec("stress-ng -d 20 --timeout 30s");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
