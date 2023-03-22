using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _78.Subsets
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var res = Subsets(new int[] { 1, 2, 3 });

            foreach (var list in res)
            {
                foreach (var pair in list)
                {
                    Console.Write(String.Join(" ", pair));
                }

                Console.WriteLine();
            }
        }

        public static IList<IList<int>> Subsets(int[] nums)
        {
            var result = new List<IList<int>>();

            result.Add(new List<int>());

            for (int i = 0; i < nums.Length; i++)
            {
                BackTracking(nums, result, i, new List<int>());
            }

            return result;
        }

        public static void BackTracking(int[] nums, List<IList<int>> result,
            int index, List<int> cur)
        {
            if (nums.Length == index)
            {
                return;
            }

            cur.Add(nums[index]);
            result.Add(cur);

            for (int j = index; j < nums.Length; j++)
            {
                if (j + 1 < nums.Length)
                {
                    var arr = new List<int>(cur);
                    BackTracking(nums, result, j + 1, arr);
                }
            }
        }
    }
}
