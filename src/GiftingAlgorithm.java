import java.util.ArrayList;
import java.util.Random;

public class GiftingAlgorithm {
	
	public static void main(String[] args) {
		Random rand = new Random();
		for(int z = 1; z<=1; z++) {
            int n = 1;
            do {
                n = n * 10;
                ArrayList<Pair<Integer, Integer>> pointList = new ArrayList<Pair<Integer, Integer>>();
                for (int i = 0; i < n; i++) {
                    int x = rand.nextInt(n);
                    int y = rand.nextInt(n);
                    pointList.add(new Pair<Integer, Integer>(x, y));
                }
                //pre-processing; find the index in pointList of the leftmost point
        		int leftmostIndex = 0;
        		for(int f = 1; f < n; f++) {
        			if(pointList.get(f).getL() < pointList.get(leftmostIndex).getL())
        				leftmostIndex = f;
        		}
        		
        		/***START OF ALGORITHM HERE***/
                long start = System.currentTimeMillis();

                ArrayList<Pair<Integer,Integer>> P = new ArrayList<Pair<Integer,Integer>>();
        		//set pointOnHull to the leftmost point in S
        		Pair<Integer, Integer> pointOnHull = new Pair<Integer, Integer>(pointList.get(leftmostIndex).getL(), pointList.get(leftmostIndex).getR());
        		Pair<Integer, Integer> endpoint = new Pair<Integer, Integer>(0, 0);
        		int i = 0;
        		do {
        			P.add(i, pointOnHull);
        			endpoint.setL(pointList.get(0).getL());
        			endpoint.setR(pointList.get(0).getR());
        			//for loop
        			for(int j = 0; j < n; j++) {
        				//check if endpoint == pointOnHull
        				if(endpoint == pointOnHull) {
        					endpoint.setL(pointList.get(j).getL());
        					endpoint.setR(pointList.get(j).getR());
        				}
        				//calculate the cross product to determine if we make a left turn
        				int crossProd = (endpoint.getL() - P.get(i).getL())*(pointList.get(j).getR()-P.get(i).getR()) - (endpoint.getR() - P.get(i).getR())*(pointList.get(j).getL()-P.get(i).getL());
        				if(crossProd > 0) { //if crossProd is positive, it's a left turn
        					endpoint.setL(pointList.get(j).getL());
        					endpoint.setR(pointList.get(j).getR());
        				} //if crossProd is 0 or less, its either no turn or a right turn
        			}
        			//
        			i = i+1;
        			pointOnHull.setL(endpoint.getL());
        			pointOnHull.setR(endpoint.getR());
        		} while (i != n);
        		
        		long end = System.currentTimeMillis();
        		float sec = (end - start);
        		
                System.out.println("Time it takes to compute the convex hull of " + n + " points: " + sec + " milliseconds");
            } while (n != 100000);
            System.out.println("\n");		
         }
		System.out.println("Done!");	
	}
	
	
	public static ArrayList<Pair<Integer,Integer>> GiftwrappingAlgorithm(ArrayList<Pair<Integer,Integer>> S, int startIndex){
		ArrayList<Pair<Integer,Integer>> P = new ArrayList<Pair<Integer,Integer>>();
		//set pointOnHull to the leftmost point in S
		Pair<Integer, Integer> pointOnHull = new Pair<Integer, Integer>(S.get(startIndex).getL(), S.get(startIndex).getR());
		Pair<Integer, Integer> endpoint = new Pair<Integer, Integer>(0, 0);
		int i = 0;
		do {
			P.add(i, pointOnHull);
			endpoint.setL(S.get(0).getL());
			endpoint.setR(S.get(0).getR());
			//for loop
			for(int j = 0; j < S.size(); j++) {
				//check if endpoint == pointOnHull
				if(endpoint.getL() == pointOnHull.getL() && endpoint.getR() == pointOnHull.getR()) {
					endpoint.setL(S.get(j).getL());
					endpoint.setR(S.get(j).getR());
				}
				//calculate the cross product to determine if we make a left turn
				int crossProd = (endpoint.getL() - P.get(i).getL())*(S.get(j).getR()-P.get(i).getR()) - (endpoint.getR() - P.get(i).getR())*(S.get(j).getL()-P.get(i).getL());
				if(crossProd > 0) { //if crossProd is positive, it's a left turn
					endpoint.setL(S.get(j).getL());
					endpoint.setR(S.get(j).getR());
				} //if crossProd is 0 or less, its either no turn or a right turn
			}
			//
			i = i+1;
			pointOnHull.setL(endpoint.getL());
			pointOnHull.setR(endpoint.getR());
		} while (endpoint == P.get(0));
		return P;
	}
}

