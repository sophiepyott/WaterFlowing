public class WaterFlowing{

    public static boolean canFlowOff(int[][] map, int r, int c, boolean[][] used){
        //if already on the edge
        if(r == 0 || c == 0 || r == map.length -1 || c == map[0].length - 1){
            return true;
        }
        //already checked
        if(used[r][c]){
            return false;
        }
        //marked as used
        used[r][c] = true;

        //can we go up
        if(map[r - 1][c] < map[r][c] && canFlowOff(map, r - 1, c, used)){
            return true;
        }

        //can we go down
        if(map[r + 1][c] < map[r][c] && canFlowOff(map, r + 1, c, used)){
            return true;
        }

        //can we go left
        if(map[r][c - 1] < map[r][c] && canFlowOff(map, r, c - 1, used)){
            return true;
        }

        //can we go right
        if(map[r][c + 1] < map[r][c] && canFlowOff(map, r, c + 1, used)){
            return true;
        }

        return false;

    }

    public static void main(String[] args){

        int[][] map = {
			{100, 99, 200, 200, 200, 200, 200, 200, 200, 200}, 
			{200, 98, 200, 200, 200, 200, 200, 200, 200, 200},
			{200, 97, 96, 200, 200, 200, 200, 200, 200, 200},
			{200, 200, 95, 200, 200, 200, 85, 84, 83, 200},
			{200, 200, 94, 93, 92, 200, 86, 200, 82, 200},
			{200, 150, 200, 200, 91, 200, 87, 200, 81, 200},
			{200, 200, 200, 200, 90, 89, 88, 200, 80, 200},
			{200, 150, 100, 200, 200, 200, 200, 200, 79, 200},
			{200, 200, 200, 200, 200, 200, 200, 200, 78, 77},
			{200, 98, 200, 200, 200, 200, 200, 200, 200, 76}		
	    };

        boolean[][] used = new boolean[map.length][map[0].length];

        //should return true
        System.out.println(canFlowOff(map, 4, 5, used));

    }
}
