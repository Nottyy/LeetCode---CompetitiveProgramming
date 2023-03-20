using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15._3Sum
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
            var hash = new HashSet<Tuple<int,int,int>>();

            for (int p = 0; p < nums.Length - 2; p++)
            {
                var target = nums[p];

                for (int i = p + 1; i < nums.Length - 1; i++)
                {
                    var current = nums[i];
                    for (int j = i + 1; j < nums.Length; j++)
                    {
                        var next = nums[j];

                        if (target + current + next == 0)
                        {
                            var arr = new int[] { nums[p], nums[i], nums[j] }.OrderBy(x => x).ToArray();
                            var s = new Tuple<int, int, int>(arr[0], arr[1], arr[2]);
                            hash.Add(s);
                        }
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
