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
            var res = ThreeSum(new int[] { -1, 0, 1, 2, -1, -4 });

            foreach (var item in res)
            {
                Console.WriteLine(String.Join(" ", item));
            }
        }

        public static IList<IList<int>> ThreeSum(int[] nums)
        {
            var hash = new HashSet<Tuple<int, int, int>>();
            var sortedNums = nums.OrderBy(x => x).ToArray();

            for (int p = 0; p < sortedNums.Length; p++)
            {
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
                    else if (leftNum +rightNum < target)
                    {
                        l++;
                    }
                    else
                    {
                        var arr = new int[] { sortedNums[p], leftNum, rightNum }.OrderBy(x => x).ToArray();
                        var s = new Tuple<int, int, int>(arr[0], arr[1], arr[2]);
                        hash.Add(s);
                        l++;
                        r--;
                    }
                }

            }
            var list = new List<IList<int>>();
            foreach (var item in hash)
            {
                list.Add(new List<int> { item.Item1, item.Item2, item.Item3 });
            }

            return list;
        }
    }
}
