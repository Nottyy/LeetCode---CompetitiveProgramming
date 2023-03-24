using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _26.RemoveDuplicatesfromSortedArray
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var arr = new int[] { 1, 1, 2 };
            var k = RemoveDuplicates(arr);
            Console.WriteLine(k);
        }

        // 1222334566

        public static int RemoveDuplicates(int[] nums)
        {

            if (nums.Length == 1)
            {
                return nums[0];
            }

            var l = 1;

            for (int i = 1; i < nums.Length; i++)
            {
                var cur = nums[i];
                var prev = nums[i - 1];

                if (cur != prev)
                {
                    nums[l] = nums[i];
                    l++;
                }
            }

            return l;
        }
    }
}
