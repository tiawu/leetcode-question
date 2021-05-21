//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 813 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class CourseSchedule{
  public static void main(String[] args) {
       Solution solution = new CourseSchedule().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.canFinish(2, new int[][]{{1,0}, {0,1}}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>(numCourses);

        for(int i =0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        // map courseA -> courses that depend on courseA
        for(int[] req : prerequisites) {
            map.get(req[1]).add(req[0]);
        }
        int[] visited = new int[numCourses];
        for(int i =0; i < numCourses; i++) {

            if(!dfs(map, visited, i)) {
                return false;
            }
        }
        return true;

    }

    public boolean dfs(List<List<Integer>> map, int[] visited, int course) {
        if(visited[course] == 1) {
            return false;
        }

        visited[course] = 1;
        for(Integer nextCourse : map.get(course)) {
            if(visited[nextCourse] ==0) {
                if(!dfs(map, visited, nextCourse)) {
                    return false;
                }
            }else if (visited[nextCourse] == 1) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
