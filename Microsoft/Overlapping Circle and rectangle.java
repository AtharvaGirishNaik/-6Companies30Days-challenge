class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2){
        int nX = Math.max(x1, Math.min(x2, xCenter)); 
        int nY = Math.max(y1, Math.min(y2, yCenter));
        int dist = (int) (Math.pow(nX - xCenter, 2) + Math.pow(nY - yCenter, 2));
        return dist <= Math.pow(radius, 2);
    }
}
