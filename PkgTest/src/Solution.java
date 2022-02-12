import java.util.ArrayList;

public class Solution {
    // 结果容器
    private ArrayList<ArrayList<Point>> resultList = new ArrayList<ArrayList<Point>>();
    // 已经有路径的步数大小，如果大于这个步数就不用在递归了，肯定不是最优解
    private int alreadyPath = -1;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid, 0, 0,
                obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int startX,
            int startY, int endX, int endY) {
        Point[] pointArray = constructPointArray(obstacleGrid);
        if (pointArray != null && pointArray.length == 1
                && pointArray[0].value == 0) {
            return 1;
        }
        if (pointArray[startY + startX * obstacleGrid[0].length].value == 1
                || pointArray[endY + endX * obstacleGrid[0].length].value == 1) {
            return 0;
        }

        ArrayList<Point> list = new ArrayList<Point>();
        list.add(pointArray[startY + startX * obstacleGrid[0].length]);
        pointArray[startY + startX * obstacleGrid[0].length].IsCheck = true;
        caclPath(pointArray, pointArray[startY + startX
                * obstacleGrid[0].length], pointArray[endY + endX
                * obstacleGrid[0].length], list, obstacleGrid);
        return resultList.size();
    }

    private void caclPath(Point[] pointArray, Point currentPoint,
            Point targetPoint, ArrayList<Point> pointList, int[][] obstacleGrid) {
        if (alreadyPath != -1 && alreadyPath < pointList.size()) {
            return;
        }
        if (currentPoint == targetPoint) {
            ArrayList<Point> tempList = (ArrayList<Point>) pointList.clone();
            if (tempList.size() < alreadyPath) {
                resultList = new ArrayList<ArrayList<Point>>();
            }
            alreadyPath = tempList.size();
            resultList.add(tempList);
            currentPoint.IsCheck = false;
            return;
        } else {
            ArrayList<Point> pointArrayTemp = currentPoint.getAroundPoint(
                    pointArray, obstacleGrid, targetPoint);
            for (int i = 0; i < pointArrayTemp.size(); ++i) {
                pointList.add(pointArrayTemp.get(i));
                pointArrayTemp.get(i).IsCheck = true;
                caclPath(pointArray, pointArrayTemp.get(i), targetPoint,
                        pointList, obstacleGrid);
                pointArrayTemp.get(i).IsCheck = false;
                pointList.remove(pointArrayTemp.get(i));
            }
        }

    }

    /**
     * 组成点对象
     * 
     * @param obstacleGrid
     * @return
     */
    private Point[] constructPointArray(int[][] obstacleGrid) {
        Point[] arrayPoint = new Point[obstacleGrid.length
                * obstacleGrid[0].length];
        Point point = null;
        for (int i = 0; i < obstacleGrid.length; ++i) {
            for (int k = 0; k < obstacleGrid[0].length; ++k) {
                point = new Point();
                point.X = i;
                point.Y = k;
                point.IsCheck = false;
                point.value = obstacleGrid[i][k];
                arrayPoint[k + i * obstacleGrid[0].length] = point;
            }
        }
        return arrayPoint;
    }

    private class Point {
        public int X;
        public int Y;
        public boolean IsCheck;
        public int value;

        /**
         * 获取某个点接下来可走的位置
         * 
         * @param pointArray
         * @param obstacleGrid
         * @param targetPoint
         * @return
         */
        private ArrayList<Point> getAroundPoint(Point[] pointArray,
                int[][] obstacleGrid, final Point targetPoint) {
            Point original = this;
            ArrayList<Point> arraylist = new ArrayList<Point>();
            Point point = null;
            // 上
            if (original.X - 1 >= 0
                    && pointArray[(original.X - 1) * obstacleGrid[0].length
                            + original.Y].value != 1
                    && !pointArray[(original.X - 1) * obstacleGrid[0].length
                            + original.Y].IsCheck) {
                // 说明点可以走
                point = pointArray[(original.X - 1) * obstacleGrid[0].length
                        + original.Y];
                arraylist.add(point);
            }
            // 下
            if (original.X + 1 < obstacleGrid.length
                    && pointArray[(original.X + 1) * obstacleGrid[0].length
                            + original.Y].value != 1
                    && !pointArray[(original.X + 1) * obstacleGrid[0].length
                            + original.Y].IsCheck) {
                // 说明点可以走
                point = pointArray[(original.X + 1) * obstacleGrid[0].length
                        + original.Y];
                arraylist.add(point);
            }
            // 左
            if (original.Y - 1 >= 0
                    && pointArray[(original.X) * obstacleGrid[0].length
                            + original.Y - 1].value != 1
                    && !pointArray[(original.X) * obstacleGrid[0].length
                            + original.Y - 1].IsCheck) {
                // 说明点可以走
                point = pointArray[(original.X) * obstacleGrid[0].length
                        + original.Y - 1];
                arraylist.add(point);
            }
            // 右
            if (original.Y + 1 < obstacleGrid[0].length
                    && pointArray[(original.X) * obstacleGrid[0].length
                            + original.Y + 1].value != 1
                    && !pointArray[(original.X) * obstacleGrid[0].length
                            + original.Y + 1].IsCheck) {
                // 说明点可以走
                point = pointArray[(original.X) * obstacleGrid[0].length
                        + original.Y + 1];
                arraylist.add(point);
            }
            return arraylist;
        }
    }
}

