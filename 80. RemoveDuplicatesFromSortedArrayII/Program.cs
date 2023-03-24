using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _80.RemoveDuplicatesFromSortedArrayII
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var arr = new int[] { 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5 };
            var res = RemoveDuplicates(arr);
        }

        public static int RemoveDuplicates(int[] nums)
        {
            if (nums.Length == 1)
            {
                return 1;
            }

            var l = 1;
            var check = false;

            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i - 1] != nums[i])
                {
                    nums[l] = nums[i];
                    l++;
                    check = false;
                }
                else
                {
                    if (check == false)
                    {
                        nums[l] = nums[i];
                        l++;
                        check = true;
                    }
                }
            }

            return l;
        }
    }
}
