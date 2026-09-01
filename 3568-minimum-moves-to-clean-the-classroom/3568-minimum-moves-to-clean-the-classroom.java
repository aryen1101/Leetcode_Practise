class Solution {

    static int[][] directions = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int startX = -1;
        int startY = -1;
        int litterCount = 0;

        int[][] litterIndex = new int[n][m];

        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startX = i;
                    startY = j;
                } else if (ch == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;

        boolean[][][][] visited =
            new boolean[n][m][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            startX,
            startY,
            energy,
            0
        });

        visited[startX][startY][energy][0] = true;

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();

                int x = curr[0];
                int y = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];

                if (mask == fullMask) {
                    return moves;
                }

                if (currEnergy == 0) {
                    continue;
                }

                for (int[] dir : directions) {

                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx < 0 || nx >= n ||
                        ny < 0 || ny >= m) {
                        continue;
                    }

                    char cell = classroom[nx].charAt(ny);

                    if (cell == 'X') {
                        continue;
                    }

                    int nextEnergy = currEnergy - 1;
                    int nextMask = mask;

                    if (cell == 'R') {
                        nextEnergy = energy;
                    }

                    if (cell == 'L') {
                        int index = litterIndex[nx][ny];
                        nextMask = mask | (1 << index);
                    }

                    if (!visited[nx][ny][nextEnergy][nextMask]) {

                        visited[nx][ny][nextEnergy][nextMask] = true;

                        queue.offer(new int[]{
                            nx,
                            ny,
                            nextEnergy,
                            nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}