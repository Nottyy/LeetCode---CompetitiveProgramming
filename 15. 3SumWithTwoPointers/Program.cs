using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15._3SumWithTwoPointers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var res = ThreeSum(new int[] { -1, 1, 0, 0 });

            foreach (var item in res)
            {
                Console.WriteLine(String.Join(" ", item));
            }
        }

        public static IList<IList<int>> ThreeSum(int[] nums)
        {
            // var hash = new HashSet<Tuple<int, int, int>>();
            var hash = new List<IList<int>>();
            var sortedNums = nums.OrderBy(x => x).ToArray();

            for (int p = 0; p < sortedNums.Length; p++)
            {
                if (p > 0 && sortedNums[p - 1] == sortedNums[p])
                {
                    continue;
                }
                var l = p + 1;
                var r = sortedNums.Length - 1;
                var target = sortedNums[p] * -1;

                while (l < r)
                {
                    var leftNum = sortedNums[l];
                    var rightNum = sortedNums[r];

                    if (leftNum + rightNum > target)
                    {
                        r--;
                    }
                    else if (leftNum + rightNum < target)
                    {
                        l++;
                    }
                    else
                    {
                        hash.Add(new List<int> { sortedNums[p], leftNum, rightNum });
                        l++;
                        while (sortedNums[l] == sortedNums[l - 1] && l < r)
                        {
                            l++;
                        }
                    }
                }

            }

            return hash;
        }
    }
}
