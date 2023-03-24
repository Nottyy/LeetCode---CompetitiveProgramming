using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _189.RotateArray
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var arr = new int[] { 1, 2 };
            Rotate(arr, 3);
        }

        // 12345
        public static void Rotate(int[] nums, int k)
        {
            if (k > nums.Length)
            {
                k = k % nums.Length;
            }
            if (nums.Length == 1)
            {
                return;
            }
            var newArr = new int[nums.Length];
            nums.CopyTo(newArr,0);

            for (int i = 0; i < k; i++)
            {
                nums[i] = nums[nums.Length - k + i];
            }

            for (int i = 0; i < nums.Length - k; i++)
            {
                nums[k + i] = newArr[i];
            }
        }
    }
}
