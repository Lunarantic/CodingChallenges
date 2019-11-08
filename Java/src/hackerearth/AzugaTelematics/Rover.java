public class Rover {
    public static int roverMove(int matrixSize, List<String> cmds) {
        int x = 0, y = 0, m = matrixSize - 1;
        
        for (String cmd: cmds) {
            switch(cmd) {
                case "UP":
                    if (x > 0) --x;
                    break;
                case "LEFT":
                    if (y > 0) --y;
                    break;
                case "DOWN":
                    if (x < m) ++x;
                    break;
                case "RIGHT":
                    if (y < m) ++y;
                    break;
                default: break:
            }
        }
        
        return x * matrixSize + y;
    }
}
