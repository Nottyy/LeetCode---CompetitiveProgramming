using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.TwoSum
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var res = TwoSum(new int[] { 2, 5, 5, 10 }, 10);
            Console.WriteLine(String.Join(" ", res));
        }

        public static int[] TwoSum(int[] nums, int target)
        {
            for (int i = 0; i < nums.Length - 1; i++)
            {
                var current = nums[i];
                for (int j = i + 1; j < nums.Length; j++)
                {
                    var next = nums[j];

                    if (current + next == target)
                    {
                        return new int[] { i, j };
                    }
                }
            }

            return null;
        }
    }
}
