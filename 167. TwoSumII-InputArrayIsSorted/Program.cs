using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _167.TwoSumII_InputArrayIsSorted
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var arr = new int[] { 2, 7, 11, 15 };

            Console.WriteLine(String.Join(" ", TwoSum(arr, 9)));
        }
        public static int[] TwoSum(int[] numbers, int target)
        {
            var l = 0;
            var r = numbers.Length - 1;

            while (l < r)
            {
                if (numbers[l] + numbers[r] > target)
                {
                    r--;
                    while (numbers[r] == numbers[r + 1] && l < r)
                    {
                        r--;
                    }
                }
                else if (numbers[l] + numbers[r] < target)
                {
                    l++;
                    while (numbers[l] == numbers[l-1] && l < r)
                    {
                        l++;
                    }
                }
                else
                {
                    return new int[] { l + 1, r + 1};
                }
            }

            return null;
        }
    }
}
